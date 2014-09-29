package com.bkl.examine.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.bkl.examine.entity.ArcType;
import com.bkl.examine.service.ArcTypeService;
import com.km.common.dao.DaoFactory;
import com.km.common.dao.GeneralDao;
import com.km.common.utils.DbUtil;
import com.km.common.vo.Condition;

/**
 * 类实现：目录结构
 * @author fanti_000
 *
 */

public class ArcTypeServiceImpl implements ArcTypeService{
	GeneralDao<ArcType> arcTypeDao = DaoFactory.createGeneralDao(ArcType.class);
	public long saveArcType(ArcType arcType){
		return arcTypeDao.save(arcType);
	}
	public long updateArcType(ArcType arcType,long id){
		Condition arctCon = DbUtil.generalEqualWhere("id", id);
		return arcTypeDao.update(arcType,new Condition[] {arctCon});
	}
	public List<ArcType> getArcType(int reid,int channel){
		List<ArcType> ArcTypes = new ArrayList<ArcType>();
		Condition arctCon = DbUtil.generalEqualWhere("reid", reid);
		Condition channelCon = DbUtil.generalEqualWhere("channel", channel);
		ArcTypes = arcTypeDao.findList(new Condition[]{arctCon,channelCon}, new String[]{"sortrank desc"});
		return ArcTypes;
	}
}
