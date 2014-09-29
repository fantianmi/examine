package com.bkl.examine.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bkl.examine.entity.ArcType;
import com.bkl.examine.service.ArcTypeService;
import com.bkl.examine.service.impl.ArcTypeServiceImpl;
import com.km.common.servlet.CommonServlet;
import com.km.common.utils.ServletUtil; 
import com.km.common.vo.RetCode;
/**
 * 目录管理
 * @author fanti_000
 *
 */
public class ArcTypeServlet extends CommonServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addArcType(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArcType arcType = ServletUtil.readObjectServletQuery(request, ArcType.class);
		ArcTypeService arcTypeServ = new ArcTypeServiceImpl();
		RetCode ret = RetCode.OK;
		arcTypeServ.saveArcType(arcType);
		ServletUtil.writeCommonReply(null, ret, response);
	}
	public void getArcType(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		int reid = Integer.parseInt(request.getParameter("reid"));
		int channel=Integer.parseInt(request.getParameter("channel"));
		ArcTypeService arcTypeServ = new ArcTypeServiceImpl();
		List<ArcType> ArcTypes = arcTypeServ.getArcType(reid,channel);
		ServletUtil.writeOkCommonReply(ArcTypes, response);
	}
	public void modifyArcType(HttpServletRequest request,HttpServletResponse response){
		
	}
	public void deleteArcType(HttpServletRequest request,HttpServletResponse response){
		
	}
	
}
