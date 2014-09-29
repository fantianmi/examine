package com.bkl.examine.entity;

import com.bkl.examine.ExamineConfig;
import com.km.common.dao.TableAonn;
import com.km.common.utils.TimeUtil;

/**
 * 媒体库（视频，文档先上传到媒体库，然后添加读取内容时再添加对应文件）
 * @author fanti_000
 *
 */
@TableAonn(tableName = "media")
public class Media {
	public static final int TYPE_HANDOUT = 0;
	public static final int TYPE_VIDEO = 1;
	
	private Integer id;
	private String fileName;
	private String readURL;
	private String downloadURL;
	private String thumbnails;
	private long uptime;
	private Integer type;
	//如果为视频，则有视频播放时长
	private String duration;
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReadURL() {
		return ExamineConfig.getMediaBaseUrl()+readURL;
	}
	public void setReadURL(String readURL) {
		this.readURL = readURL;
	}
	public String getDownloadURL() {
		return ExamineConfig.getMediaBaseUrl()+downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public long getUnixUptime() {
		return uptime;
	}
	public String getUptime(){
		return TimeUtil.fromUnixTime(uptime);
	}
	public void setUptime(long uptime) {
		this.uptime = uptime;
	}
	public String getType() {
		if(type==0){
			return "讲义";
		}else if(type==1){
			return "视频";
		}else{
			return "未知文件";
		}
	}
	public void setType(Integer type) {
		this.type = type;
	}
}