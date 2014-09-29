package com.bkl.examine.entity;
import com.bkl.examine.ExamineConfig;
import com.km.common.dao.TableAonn;
@TableAonn(tableName = "handout")
public class Handout2Media extends Handout{
	private String readURl;
	private String downloadURL;
	private String thumbnails;
	private String fileName;
	
	public String getReadURl() {
		return ExamineConfig.getMediaBaseUrl()+readURl;
	}
	public void setReadURl(String readURl) {
		this.readURl = readURl;
	}
	public String getDownloadURL() {
		return ExamineConfig.getMediaBaseUrl()+downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getThumbnails() {
		return ExamineConfig.getMediaBaseUrl()+thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getFileName() {
		return ExamineConfig.getMediaBaseUrl()+fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}