package com.bkl.examine.service;

import java.util.List;
import java.util.Map;

import com.bkl.examine.entity.Handout;
import com.bkl.examine.entity.Handout2Media;
import com.km.common.vo.Page;
import com.km.common.vo.PageReply;
/**
 * 类实现：讲义部分
 * @author fanti_000
 *
 */
public interface HandoutService {
	public long saveHandout(Handout handout);
	/**
	 * 修改讲义
	 * @param handout
	 * @param id
	 * @return
	 */
	public long modifyHandout(Handout handout,long id);
	/**
	 * 根据目录查询讲义
	 * @param typeid
	 * @return
	 */
	public List<Handout> getHandoutList(int typeid);
	/**
	 * 根据讲义id查看单个讲义
	 * @param id
	 * @return
	 */
	public Handout getHandout(int id);
	/**
	 * 获得讲义列表
	 * @param typeid
	 * @return
	 */
	public List<Handout2Media> getHandout2Media(int typeid);
	/**
	 * 分页获取讲义
	 * @param typeid
	 * @param SearchMap
	 * @param page
	 * @return
	 */
	public PageReply<Handout2Media> getHandout2Media(int typeid,Map SearchMap,Page page);
	/**
	 * 获得单个讲义
	 * @param id
	 * @return
	 */
	public List<Handout2Media> getHandout2MediaSingle(int id);
	
	
}
