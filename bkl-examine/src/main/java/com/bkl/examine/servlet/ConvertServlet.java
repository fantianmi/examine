package com.bkl.examine.servlet;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkl.examine.entity.Media;
import com.bkl.examine.service.MediaService;
import com.bkl.examine.service.impl.MediaServiceImpl;
import com.bkl.examine.utils.DistorySoffice;
import com.bkl.examine.utils.DocConverter;
import com.bkl.examine.utils.JavaCallOpenoffice;
import com.bkl.examine.utils.Word2Html;
import com.km.common.servlet.CommonServlet;
import com.km.common.utils.TimeUtil;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ConvertServlet extends CommonServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void docUpload(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Log log = LogFactory.getLog("testCase");
		HttpSession session = request.getSession();
		// open openoffice service
		JavaCallOpenoffice openOpenoffice = new JavaCallOpenoffice();
		// 文件上传采用cos组件上传，可更换为commons-fileupload上传，文件上传后，保存在upload文件夹
		// 获取文件上传路径
		String saveDirectory = request.getSession().getServletContext().getRealPath("upload");
		// 打印上传路径信息
		System.out.println(saveDirectory);
		// 每个文件最大50m
		int maxPostSize = 50 * 1024 * 1024;
		// 采用cos缺省的命名策略，重名后加1,2,3...如果不加dfp重名将覆盖
		DefaultFileRenamePolicy dfp = new DefaultFileRenamePolicy();
		// response的编码为"UTF-8",同时采用缺省的文件名冲突解决策略,实现上传,如果不加dfp重名将覆盖
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", dfp);
		// MultipartRequest multi = new MultipartRequest(request, saveDirectory,
		// maxPostSize,"UTF-8");
		// 输出反馈信息
		Enumeration<?> files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			File f = multi.getFile(name);
			if (f != null) {
				String fileName = multi.getFilesystemName(name);
				// 获取上传文件的扩展名
				String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
				// 文件全路径
				String lastFileName = saveDirectory + "\\" + fileName;
				// 获取需要转换的文件名,将路径名中的'\'替换为'/'
				String converfilename = saveDirectory.replaceAll("\\\\", "/") + "/" + fileName;
				System.out.println(converfilename);
				// 调用转换类DocConverter,并将需要转换的文件传递给该类的构造方法
				DocConverter d = new DocConverter(converfilename);
				// 调用conver方法开始转换，先执行doc2pdf()将office文件转换为pdf;再执行pdf2swf()将pdf转换为swf;
				d.conver();
				// 调用getswfPath()方法，打印转换后的swf文件路径
				System.out.println(d.getswfPath());
				// 生成swf相对路径，以便传递给flexpaper播放器
				String swfpath = "upload" + d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));
				System.out.println(swfpath);
				// 将相对路径放入sessio中保存
				session.setAttribute("swfpath", swfpath);
				// do processs doc 
				System.out.println("let`s process this filepath:"+saveDirectory+" and fileName:"+fileName);
				Word2Html word2Html=new Word2Html();
				String resultPath=word2Html.wordToHtml(saveDirectory.replaceAll("\\\\", "/")+"/", fileName);
				
				//save to DB
				Media media=new Media();
				String downloadURL="upload/"+fileName;
				String readURL="upload"+resultPath.replaceAll("\\\\", "/");
				String thumbnails="img/icon/tdoc_default.jpg";
				int type=Media.TYPE_HANDOUT;
				media.setDownloadURL(downloadURL);
				media.setFileName(fileName);
				media.setReadURL(readURL);
				media.setThumbnails(thumbnails);
				media.setType(type);
				media.setUptime(TimeUtil.getUnixTime());
				MediaService mediaServ=new MediaServiceImpl();
				mediaServ.saveMedia(media);
				
				response.setContentType("text/json;charset=UTF-8");
				response.getWriter().write("上传的文件:" + lastFileName);
				response.getWriter().write("文件类型" + extName);
				response.getWriter().write("<hr><a href='documentUpload.jsp'>继续上传</a>");
				response.getWriter().flush();
				response.getWriter().close();
			}
		}
		// close openoffice service
		DistorySoffice closeOpenoffice = new DistorySoffice();
	}
	
}
