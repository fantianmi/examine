package com.bkl.examine.service.impl;
import java.util.List;

import com.bkl.examine.entity.Media;
import com.bkl.examine.service.MediaService;
import com.km.common.dao.DaoFactory;
import com.km.common.dao.GeneralDao;
import com.km.common.utils.DbUtil;
import com.km.common.vo.Condition;

/**
 * 类实现：媒体库服务实现层
 * @author fanti_000
 *
 */

public class MediaServiceImpl implements MediaService{
	GeneralDao<Media> mediaDao = DaoFactory.createGeneralDao(Media.class);
	
	public long saveMedia(Media media){
		return mediaDao.save(media);
	}
	public long updateMedia(Media media,int id){
		Condition mediaCon = DbUtil.generalEqualWhere("id", id);
		return mediaDao.update(media,new Condition[] {mediaCon});
	}
	public List<Media> getMediaListByType(int type){
		Condition mediaCon = DbUtil.generalEqualWhere("type", type);
		return mediaDao.findList(new Condition[] {mediaCon},new String[]{"uptime desc"});
	}
	
	public List<Media> getMediaList(){
		return mediaDao.findList("uptime desc");
	}
	
	public Media getMedia(int id){
		return mediaDao.find(id);
	}
}
