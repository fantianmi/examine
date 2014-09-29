package com.bkl.examine.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bkl.examine.entity.Video;
import com.bkl.examine.entity.Video2Media;
import com.bkl.examine.service.VideoService;
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

public class VideoServiceImpl implements VideoService{
	GeneralDao<Video> videoDao = DaoFactory.createGeneralDao(Video.class);
	public long saveVideo(Video video){
		return videoDao.save(video);
	}
	public long modifyVideo(Video video,long id){
		Condition handtCon = DbUtil.generalEqualWhere("id", id);
		return videoDao.update(video,new Condition[] {handtCon});
	}
	public List<Video> getVideoList(int typeid){
		List<Video> videos = new ArrayList<Video>();
		Condition handtCon = DbUtil.generalEqualWhere("typeid", typeid);
		videos = videoDao.findList(new Condition[]{handtCon}, new String[]{"sortrank desc"});
		return videos;
	}
	public Video getVideo(int id){
		return videoDao.find("id", id);
	}
	public List<Video2Media> getVideo2Media(int typeid) {
		GeneralDao<Video2Media> video2MediaDao = DaoFactory.createGeneralDao(Video2Media.class);
		String sql="select v.id,v.typeid,v.redirecturl,v.userip,v.sortrank,v.click,v.shorttitle,v.source,v.pubdate,v.senddate,v.keywords,v.postnum,v.likeid,v.hid,v.mid,v.description,m.readURL,m.downloadURL,m.thumbnails,m.fileName,m.duration from `video` v,`media` m where v.mid=m.id and v.typeid=? order by v.pubdate desc";
		List<Video2Media> video2Medias = video2MediaDao.findListBySQL(sql,typeid);
		return video2Medias;
	}
	public PageReply<Video2Media> getVideo2Media(int typeid, Map searchMap,
			Page page) {
		GeneralDao<Video2Media> video2MediaDao = DaoFactory.createGeneralDao(Video2Media.class);
		String sql="select v.id,v.typeid,v.redirecturl,v.userip,v.sortrank,v.click,v.shorttitle,v.source,v.pubdate,v.senddate,v.keywords,v.postnum,v.likeid,v.hid,v.mid,v.description,m.readURL,m.downloadURL,m.thumbnails,m.fileName,m.duration from `video` v,`media` m where v.mid=m.id and v.typeid="+typeid+" order by v.pubdate desc";
		PageReply<Video2Media> video2Medias = video2MediaDao.getPage(sql, page, searchMap);
		return video2Medias;
	}
	public List<Video2Media> getVideo2MediaSingle(int id) {
		GeneralDao<Video2Media> video2MediaDao = DaoFactory.createGeneralDao(Video2Media.class);
		String sql="select v.id,v.typeid,v.redirecturl,v.userip,v.sortrank,v.click,v.shorttitle,v.source,v.pubdate,v.senddate,v.keywords,v.postnum,v.likeid,v.hid,v.mid,v.description,m.readURL,m.downloadURL,m.thumbnails,m.fileName,m.duration from `video` v,`media` m where v.mid=m.id and v.id="+id;
		List<Video2Media> video = video2MediaDao.find(sql);
		return video;
	}
	@Override
	public List<Video> getVideotList(int typeid) {
		// TODO Auto-generated method stub
		return null;
	}
}
