package com.bkl.examine.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import com.bkl.examine.entity.ArcType;
import com.bkl.examine.entity.Cash2User;
import com.bkl.examine.entity.Handout;
import com.bkl.examine.entity.Handout2Media;
import com.bkl.examine.service.ArcTypeService;
import com.bkl.examine.service.HandoutService;
import com.bkl.examine.service.impl.ArcTypeServiceImpl;
import com.bkl.examine.service.impl.HandoutServiceImpl;
import com.km.common.servlet.CommonServlet;
import com.km.common.utils.ServletUtil; 
import com.km.common.vo.Page;
import com.km.common.vo.PageReply;
import com.km.common.vo.RetCode;
/**
 * 讲义servlet
 * @author fanti_000
 *
 */
public class HandoutServlet extends CommonServlet {
	
	private static final long serialVersionUID = 1L;

	public void addHandout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Handout handout = ServletUtil.readObjectServletQuery(request, Handout.class);
		HandoutService handoutServ = new HandoutServiceImpl();
		RetCode ret = RetCode.OK;
		handoutServ.saveHandout(handout);
		ServletUtil.writeCommonReply(null, ret, response);
	}
	/**
	 * 获得讲义列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getHandoutList(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		HandoutService handoutServ = new HandoutServiceImpl();
		Page page = ServletUtil.getPage(request);
		PageReply<Handout2Media> handouts = handoutServ.getHandout2Media(typeid, null, page);
		ServletUtil.writeOkCommonReply(handouts, response);
	}
	
	public void getHandout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		HandoutService handoutServ = new HandoutServiceImpl();
		List<Handout2Media> handout = handoutServ.getHandout2MediaSingle(id);
		ServletUtil.writeOkCommonReply(handout, response);
	}
	
	public void modifyHandout(HttpServletRequest request,HttpServletResponse response){
		
	}
	public void deleteHandout(HttpServletRequest request,HttpServletResponse response){
		
	}
	
}
