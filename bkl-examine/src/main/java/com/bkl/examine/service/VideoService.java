package com.bkl.examine.service;

import java.util.List;
import java.util.Map;

import com.bkl.examine.entity.Video;
import com.bkl.examine.entity.Video2Media;
import com.km.common.vo.Page;
import com.km.common.vo.PageReply;
/**
 * 类实现：视频部分
 * @author fanti_000
 *
 */
public interface VideoService {
	public long saveVideo(Video Video);
	/**
	 * 修改视频
	 * @param Video
	 * @param id
	 * @return
	 */
	public long modifyVideo(Video Video,long id);
	/**
	 * 根据目录查询视频
	 * @param typeid
	 * @return
	 */
	public List<Video> getVideotList(int typeid);
	/**
	 * 根据视频id查看单个视频
	 * @param id
	 * @return
	 */
	public Video getVideo(int id);
	/**
	 * 获得视频列表
	 * @param typeid
	 * @return
	 */
	public List<Video2Media> getVideo2Media(int typeid);
	/**
	 * 分页获取视频
	 * @param typeid
	 * @param SearchMap
	 * @param page
	 * @return
	 */
	public PageReply<Video2Media> getVideo2Media(int typeid,Map SearchMap,Page page);
	/**
	 * 获得单个视频
	 * @param id
	 * @return
	 */
	public List<Video2Media> getVideo2MediaSingle(int id);
	
	
}
