package com.bkl.examine.service;

import java.util.List;

import com.bkl.examine.entity.ArcType;

/**
 * 类实现：目录结构
 * @author fanti_000
 *
 */

public interface ArcTypeService {
	public long saveArcType(ArcType arcType);
	public long updateArcType(ArcType arcType,long id);
	//need update
	public List<ArcType> getArcType(int reid,int channel);
}
