package com.bkl.examine.servlet;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bkl.examine.entity.Video;
import com.bkl.examine.entity.Video2Media;
import com.bkl.examine.service.VideoService;
import com.bkl.examine.service.impl.VideoServiceImpl;
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
public class VideoServlet extends CommonServlet {
	
	private static final long serialVersionUID = 1L;

	public void addVideo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Video video = ServletUtil.readObjectServletQuery(request, Video.class);
		VideoService videoServ = new VideoServiceImpl();
		RetCode ret = RetCode.OK;
		videoServ.saveVideo(video);
		ServletUtil.writeCommonReply(null, ret, response);
	}
	/**
	 * 获得讲义列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getVideoList(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		VideoService videoServ = new VideoServiceImpl();
		Page page = ServletUtil.getPage(request);
		PageReply<Video2Media> videos = videoServ.getVideo2Media(typeid, null, page);
		ServletUtil.writeOkCommonReply(videos, response);
	}
	
	public void getVideo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		VideoService videoServ = new VideoServiceImpl();
		List<Video2Media> video = videoServ.getVideo2MediaSingle(id);
		ServletUtil.writeOkCommonReply(video, response);
	}
	
	public void modifyVideo(HttpServletRequest request,HttpServletResponse response){
		
	}
	public void deleteVideo(HttpServletRequest request,HttpServletResponse response){
		
	}
	
}
