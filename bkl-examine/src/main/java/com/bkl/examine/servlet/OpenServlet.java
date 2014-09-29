package com.bkl.examine.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;

import com.bkl.examine.ExamineConfig;
import com.bkl.examine.entity.AdminUser;
import com.bkl.examine.entity.RecommendDetail;
import com.bkl.examine.entity.User;
import com.bkl.examine.service.AdminService;
import com.bkl.examine.service.UserService;
import com.bkl.examine.service.impl.AdminServiceImpl;
import com.bkl.examine.service.impl.UserServiceImpl;
import com.bkl.examine.utils.EmailUtil;
import com.bkl.examine.utils.RequestUtil;
import com.km.common.dao.DaoFactory;
import com.km.common.dao.GeneralDao;
import com.km.common.servlet.CommonServlet;
import com.km.common.utils.ServletUtil; 
import com.km.common.utils.TimeUtil;
import com.km.common.utils.ValidUtils;
import com.km.common.vo.RetCode;

public class OpenServlet extends CommonServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(OpenServlet.class);

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = ServletUtil.readObjectServletQuery(request, User.class);
		UserService userServ = new UserServiceImpl();
		User userFound = userServ.find(user.getEmail());
		if (userFound == null) {
			ServletUtil.writeCommonReply(null,
					RetCode.USERNAME_OR_PASSWORD_ERROR, response);
			return;
		}
		// 邮件验证
		if (userFound.getEmail_validated() == 0
				&& ExamineConfig.enableEmailActive()) {
			ServletUtil.writeCommonReply(null, RetCode.USER_NOT_ACTIVE,
					response);
			return;
		}
		// 用户被禁用
		if (userFound.getFrozen() == 1) {
			ServletUtil.writeCommonReply(null, RetCode.USER_STATUS_FREEZE,
					response);
			return;
		}
		if (!userFound.checkPassword(user.getPassword())) {
			ServletUtil.writeCommonReply(null,
					RetCode.USERNAME_OR_PASSWORD_ERROR, response);
			return;
		}
		request.getSession(true).setAttribute("username", user.getEmail());
		log.info("user: " + user.getEmail() + " login, ip address: "
				+ RequestUtil.getRemoteAddress(request));
		// RetCode ret = userServ.login(user.getEmail(),user.getPassword());
		// if (ret == RetCode.OK) {
		// request.getSession(true).setAttribute("username", user.getEmail());
		// log.info("user: " + user.getEmail() + " login, ip address: " +
		// RequestUtil.getRemoteAddress(request));
		// //response.sendRedirect("../index.jsp");
		// }

		// 返回是否实名认证
		boolean hasConfirmRealName = true;
		if (!ExamineConfig.isCnVersion()) {
			hasConfirmRealName = userFound.getRealname_validated() == 1;
		}
		ServletUtil.writeCommonReply(hasConfirmRealName, RetCode.OK, response);
	}

	public void reg1(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = ServletUtil.readObjectServletQuery(request, User.class);
		UserService userServ = new UserServiceImpl();
		RetCode ret = RetCode.OK;
		if (userServ.exist(user.getEmail())) {
			ret = RetCode.USER_EXIST;
			ServletUtil.writeCommonReply(null, ret, response);
			return;
		} else if (!ValidUtils.emailFormat(user.getEmail())) {
			ret = RetCode.EMAIL_ERROR;
			ServletUtil.writeCommonReply(null, ret, response);
			return;
		}
		user.setCtime(TimeUtil.getUnixTime());
		user.setReg_ip(RequestUtil.getRemoteAddress(request));
		long userId = userServ.createUser(user);
		final User userTemp = user;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					EmailUtil.sendActiveMail(userTemp);
				} catch (EmailException e) {
					e.printStackTrace();
				}

			}
		});
		thread.start();
		ServletUtil.writeCommonReply(null, ret, response);
	}
	
	public void reg2(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = ServletUtil.readObjectServletQuery(request, User.class);
		UserService userServ = new UserServiceImpl();
		RetCode ret = RetCode.OK;
		if (userServ.exist(user.getEmail())) {
			ret = RetCode.USER_EXIST;
			ServletUtil.writeCommonReply(null, ret, response);
			return;
		} else if (!ValidUtils.emailFormat(user.getEmail())) {
			ret = RetCode.EMAIL_ERROR;
			ServletUtil.writeCommonReply(null, ret, response);
			return;
		}
		user.setCtime(TimeUtil.getUnixTime());
		user.setReg_ip(RequestUtil.getRemoteAddress(request));
		int recommended_user_id = 0;
		try {
			String recommend = request.getParameter("r");
			// String recommend = null;
			if (recommend == null || "null".equals(recommend))
				recommend = (String) request.getSession(true).getAttribute(
						"recommend");
			if (recommend != null) {
				recommended_user_id = Integer.parseInt(recommend);
			}
		} catch (NumberFormatException e) {

		}
		long userId = userServ.createUser(user);

		// 保存推荐人信息
		if (recommended_user_id > 0) {
			GeneralDao<RecommendDetail> rdDao = DaoFactory
					.createGeneralDao(RecommendDetail.class);
			RecommendDetail recommendDetail = new RecommendDetail();
			recommendDetail.setStatus(0);
			recommendDetail.setRecommended_id(recommended_user_id);
			recommendDetail.setUser_id(userId);
			rdDao.save(recommendDetail);
		}

		final User userTemp = user;
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					EmailUtil.sendActiveMail(userTemp);
				} catch (EmailException e) {
					e.printStackTrace();
				}

			}
		});
		thread.start();

		ServletUtil.writeCommonReply(null, ret, response);
	}

	public void activeUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");

		GeneralDao<User> userDao = DaoFactory.createGeneralDao(User.class);
		User user = userDao.find("email", email);
		if (user != null) {
			int emailValidated = user.getEmail_validated();
			if (emailValidated == 0) {
				user.setEmail_validated(1);
				userDao.update(user);
				response.sendRedirect("/html/activate-success.html");
				return;
			} else {
				response.sendRedirect("/html/activate-duplicate.html");
				return;
			}
		}
		response.sendRedirect("/html/activate-failure.html");
	}

	public void chcekregname(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = ServletUtil.readObjectServletQuery(request, User.class);
		UserService userServ = new UserServiceImpl();
		boolean isUserExisted = userServ.exist(user.getEmail());
		RetCode ret = RetCode.OK;
		if (isUserExisted) {
			ret = RetCode.USER_EXIST;
		}
		ServletUtil.writeCommonReply(null, ret, response);
	}

	public void resetPassword(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GeneralDao<User> dao = DaoFactory.createGeneralDao(User.class);
		String email = StringUtils.defaultString(request.getParameter("email"),
				"");
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();
		if (!isMatched) {
			ServletUtil.writeCommonReply(null, RetCode.EMAIL_ERROR, response);
			return;
		}
		UserService userSrv = new UserServiceImpl();
		User user = userSrv.find(email);
		if (user == null) {
			ServletUtil
					.writeCommonReply(null, RetCode.USER_NOT_EXIST, response);
			return;
		}
		// try {
		Timestamp overTime = new Timestamp(
				System.currentTimeMillis() + 15 * 60 * 1000);
		user.setPasswd_modify_overtime(overTime.getTime() / 1000);
		dao.update(user);
		final User tempUser = user;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					EmailUtil.sendResetPasswordMail(tempUser);
				} catch (EmailException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		ServletUtil.writeCommonReply(null, RetCode.OK, response);
		// } catch(EmailException e) {
		// e.printStackTrace();
		// ServletUtil.writeCommonReply(null, RetCode.EMAIL_SEND_ERROR,
		// response);
		// }
	}

	public void doResetPassword(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GeneralDao<User> dao = DaoFactory.createGeneralDao(User.class);
		String newPassword = StringUtils.defaultString(
				request.getParameter("newPassword"), "");
		String newPassword2 = StringUtils.defaultString(
				request.getParameter("newPassword2"), "");

		if (newPassword.length() < 6 || newPassword.length() > 16) {
			ServletUtil.writeCommonReply(null, RetCode.PASSWORD_ILLEGAL,
					response);
			return;
		}
		if (!StringUtils.equals(newPassword, newPassword2)) {
			ServletUtil.writeCommonReply(null, RetCode.TWO_PASSWORD_NOT_EQUAL,
					response);
			return;
		}

		UserService userSrv = new UserServiceImpl();
		User user = null;
		long userId = Long.parseLong(StringUtils.defaultString(
				request.getParameter("userId"), "0"));
		String token = StringUtils.defaultString(request.getParameter("token"),
				"");
		if (userId > 0) {
			user = userSrv.get(userId);
			String key = user.getEmail() + "$$"
					+ (user.getPasswd_modify_overtime());
			if (user.getPasswd_modify_overtime() > TimeUtil.getUnixTime()
					&& DigestUtils.sha512Hex(key).equals(token)) {
				user.saveMD5Password(newPassword);
				dao.update(user);
				ServletUtil.writeCommonReply(null, RetCode.OK, response);
				return;
			}
		}
		ServletUtil.writeCommonReply(null, RetCode.ERROR, response);
	}

	public void loginandredirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = ServletUtil.readObjectServletQuery(request, User.class);
		UserService userServ = new UserServiceImpl();

		RetCode ret = userServ.login(user.getEmail(), user.getPassword());
		if (ret == RetCode.OK) {
			request.getSession(true).setAttribute("username", user.getEmail());
			response.sendRedirect("../index.jsp");
			return;
		}
		ServletUtil.writeCommonReply(null, ret, response);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession(true).invalidate();
		ServletUtil.writeOkCommonReply(true, response);
	}

	public void loginadmin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AdminUser user = ServletUtil.readObjectServletQuery(request,
				AdminUser.class);
		AdminService adminUserServ = new AdminServiceImpl();

		boolean isok = adminUserServ.login(user.getUsername(),
				user.getPassword());
		if (isok) {
			request.getSession(true).setAttribute("adminusername",
					user.getUsername());
		}

		if (!isok) {
			ServletUtil.writeCommonReply(null,
					RetCode.USERNAME_OR_PASSWORD_ERROR, response);
			return;
		} else {
			ServletUtil.writeCommonReply(null, RetCode.OK, response);
			return;
		}
	}

	public void klineData2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		String areaKey = "";
		// 五分钟
		if ("1".equals(type)) {
			areaKey = "floor(deal.ctime - deal.ctime % (5 * 60))";
		} else {
			areaKey = "floor(deal.ctime - (deal.ctime % (24 * 60 * 60)))";
		}
		// 开盘查询SQL
		String open_sql = "select price,%s min from deal inner join trade on deal.buy_trade=trade.id inner join (select min(id) id from deal group by %s) b on deal.id=b.id";
		// 最高价查询SQL
		String high_sql = "select max(price) price,%s min from deal inner join trade on deal.buy_trade=trade.id group by %s";
		// 最低价查询SQL
		String lower_sql = "select min(price) price,%s min from deal inner join trade on deal.buy_trade=trade.id  group by %s";
		// 收盘查询SQL
		String close_sql = "select price,%s min from deal inner join trade on deal.buy_trade=trade.id  inner join (select max(id) id from deal group by %s) b on deal.id=b.id";
		// 成交量查询SQL
		String volume_sql = "select sum(amount) amount,ctime,%s min from deal group by %s";

		// 开盘价
		Connection conn = DaoFactory.createConnection();
		QueryRunner runner = new QueryRunner();
		Map<Long, Map<String, Object>> openData = runner.query(conn,
				String.format(open_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> highData = runner.query(conn,
				String.format(high_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> lowData = runner.query(conn,
				String.format(lower_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> closeData = runner.query(conn,
				String.format(close_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> volumeData = runner.query(conn,
				String.format(volume_sql, areaKey, areaKey),
				new KeyedHandler<Long>(3), new Object[] {});
		List<Object[]> ls = new ArrayList<Object[]>();
		if (openData != null && openData.size() > 0) {
			for (Object o : openData.keySet()) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Object open = openData.get(o) == null ? 0L : openData.get(o)
						.get("price");
				Object high = highData.get(o) == null ? 0L : highData.get(o)
						.get("price");
				Object lower = lowData.get(o) == null ? 0L : lowData.get(o)
						.get("price");
				Object close = closeData.get(o) == null ? 0L : closeData.get(o)
						.get("price");
				Object volume = volumeData.get(o) == null ? 0L : volumeData
						.get(o).get("amount");
				Object[] obj = new Object[] { (Long) o * 1000, open, high,
						lower, close, volume };
				ls.add(obj);

				// System.out.println(sdf.format(new Date((Long)obj[0])) + " " +
				// obj[1] + " " + obj[2] + " " + obj[3] + " " + obj[4]);
			}
		}

		// 按时间排序
		Collections.sort(ls, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return (int) ((Long) o1[0] - (Long) o2[0]);
			}

		});
		ServletUtil.writeOkCommonReply(ls, response);
	}

	public void klineData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		String areaKey = "";
		// 五分钟
		if ("1".equals(type)) {
			areaKey = "floor(deal.ctime - deal.ctime % (5 * 60))";
		} else {
			areaKey = "floor(deal.ctime - (deal.ctime % (24 * 60 * 60)))";
		}
		// 开盘查询SQL
		// String open_sql =
		// "select price,%s min from deal inner join trade on deal.buy_trade=trade.id inner join (select min(id) id from deal group by %s) b on deal.id=b.id";
		String open_sql = "select price as price,%s min from deal join (select min(id) id from deal group by %s)b on deal.id=b.id order by min ";
		// 最高价查询SQL
		// String high_sql =
		// "select max(price) price,%s min from deal inner join trade on deal.buy_trade=trade.id group by %s";
		String high_sql = "select max(price) price,%s min from deal group by %s";
		// 最低价查询SQL
		// String lower_sql =
		// "select min(price) price,%s min from deal inner join trade on deal.buy_trade=trade.id  group by %s";
		String lower_sql = "select min(price) price,%s min from deal  group by %s";
		// 收盘查询SQL
		// String close_sql =
		// "select price,%s min from deal inner join trade on deal.buy_trade=trade.id  inner join (select max(id) id from deal group by %s) b on deal.id=b.id";
		String close_sql = "select price as price,%s min from deal join (select max(id) id from deal group by %s)b on deal.id=b.id order by min";
		// 成交量查询SQL
		String volume_sql = "select sum(amount) amount,ctime,%s min from deal group by %s";

		// 开盘价
		Connection conn = DaoFactory.createConnection();
		QueryRunner runner = new QueryRunner();
		Map<Long, Map<String, Object>> openData = runner.query(conn,
				String.format(open_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> highData = runner.query(conn,
				String.format(high_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> lowData = runner.query(conn,
				String.format(lower_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> closeData = runner.query(conn,
				String.format(close_sql, areaKey, areaKey),
				new KeyedHandler<Long>(2), new Object[] {});
		Map<Long, Map<String, Object>> volumeData = runner.query(conn,
				String.format(volume_sql, areaKey, areaKey),
				new KeyedHandler<Long>(3), new Object[] {});
		List<Object[]> ls = new ArrayList<Object[]>();
		if (openData != null && openData.size() > 0) {
			for (Object o : openData.keySet()) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Object open = openData.get(o) == null ? 0L : openData.get(o)
						.get("price");
				Object high = highData.get(o) == null ? 0L : highData.get(o)
						.get("price");
				Object lower = lowData.get(o) == null ? 0L : lowData.get(o)
						.get("price");
				Object close = closeData.get(o) == null ? 0L : closeData.get(o)
						.get("price");
				Object volume = volumeData.get(o) == null ? 0L : volumeData
						.get(o).get("amount");
				Object[] obj = new Object[] { (Long) o * 1000, open, high,
						lower, close, volume };
				ls.add(obj);

				// System.out.println(sdf.format(new Date((Long)obj[0])) + " " +
				// obj[1] + " " + obj[2] + " " + obj[3] + " " + obj[4]);
			}
		}

		// 按时间排序
		Collections.sort(ls, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return (int) ((Long) o1[0] - (Long) o2[0]);
			}

		});
		ServletUtil.writeOkCommonReply(ls, response);
	}
}
