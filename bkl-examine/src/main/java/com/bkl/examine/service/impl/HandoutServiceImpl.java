package com.bkl.examine.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bkl.examine.entity.Cash2User;
import com.bkl.examine.entity.Handout;
import com.bkl.examine.entity.Handout2Media;
import com.bkl.examine.service.HandoutService;
import com.km.common.dao.DaoFactory;
import com.km.common.dao.GeneralDao;
import com.km.common.utils.DbUtil;
import com.km.common.vo.Condition;
import com.km.common.vo.Page;
import com.km.common.vo.PageReply;

/**
 * 类实现：目录结构
 * @author fanti_000
 *
 */

public class HandoutServiceImpl implements HandoutService{
	GeneralDao<Handout> handoutDao = DaoFactory.createGeneralDao(Handout.class);
	public long saveHandout(Handout handout){
		return handoutDao.save(handout);
	}
	public long modifyHandout(Handout handout,long id){
		Condition handtCon = DbUtil.generalEqualWhere("id", id);
		return handoutDao.update(handout,new Condition[] {handtCon});
	}
	public List<Handout> getHandoutList(int typeid){
		List<Handout> handouts = new ArrayList<Handout>();
		Condition handtCon = DbUtil.generalEqualWhere("typeid", typeid);
		handouts = handoutDao.findList(new Condition[]{handtCon}, new String[]{"sortrank desc"});
		return handouts;
	}
	public Handout getHandout(int id){
		return handoutDao.find("id", id);
	}
	public List<Handout2Media> getHandout2Media(int typeid) {
		GeneralDao<Handout2Media> handout2MediaDao = DaoFactory.createGeneralDao(Handout2Media.class);
		String sql="select h.id,h.typeid,h.redirecturl,h.userip,h.sortrank,h.click,h.shorttitle,h.source,h.pubdate,h.senddate,h.keywords,h.postnum,h.likeid,h.hid,h.mid,m.readURL,m.downloadURL,m.thumbnails,m.fileName from `handout` h,`media` m where h.mid=m.id and h.typeid=? order by h.pubdate desc";
		List<Handout2Media> handout2Medias = handout2MediaDao.findListBySQL(sql,typeid);
		return handout2Medias;
	}
	public PageReply<Handout2Media> getHandout2Media(int typeid, Map searchMap,
			Page page) {
		GeneralDao<Handout2Media> handout2MediaDao = DaoFactory.createGeneralDao(Handout2Media.class);
		String sql="select h.id,h.typeid,h.redirecturl,h.userip,h.sortrank,h.click,h.shorttitle,h.source,h.pubdate,h.senddate,h.keywords,h.postnum,h.likeid,h.hid,h.mid,m.readURL,m.downloadURL,m.thumbnails,m.fileName from `handout` h,`media` m where h.mid=m.id and h.typeid="+typeid+" order by h.pubdate desc";
		PageReply<Handout2Media> handout2Medias = handout2MediaDao.getPage(sql, page, searchMap);
		return handout2Medias;
	}
	public List<Handout2Media> getHandout2MediaSingle(int id) {
		GeneralDao<Handout2Media> handout2MediaDao = DaoFactory.createGeneralDao(Handout2Media.class);
		String sql="select h.id,h.typeid,h.redirecturl,h.userip,h.sortrank,h.click,h.shorttitle,h.source,h.pubdate,h.senddate,h.keywords,h.postnum,h.likeid,h.hid,h.mid,m.readURL,m.downloadURL,m.thumbnails,m.fileName from `handout` h,`media` m where h.mid=m.id and h.id="+id;
		List<Handout2Media> handout = handout2MediaDao.find(sql);
		return handout;
	}
}
