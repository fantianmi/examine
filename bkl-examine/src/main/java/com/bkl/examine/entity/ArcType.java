package com.bkl.examine.entity;
import com.km.common.dao.TableAonn;
@TableAonn(tableName = "arctype")
public class ArcType {
	public static final int CHANEL_VIDEO=1;
	public static final int CHANEL_DOC=0;
	private int id;
	//父栏目编号
	private int reid;
	//排序编号
	private int sortrank;
	//默认页名称
	private String defaultname;
	//是否支持投稿
	private int issend;
	//所属栏目-0 doc 1 vedio
	private int channel;
	//浏览权限
	private int corank;
	//导航描述
	private String description;
	//关键字
	private String keywords;
	//多站点绑定域名
	private String siteurl;
	//多站点站点根目录 
	private String sitepath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public int getSortrank() {
		return sortrank;
	}
	public void setSortrank(int sortrank) {
		this.sortrank = sortrank;
	}
	public String getDefaultname() {
		return defaultname;
	}
	public void setDefaultname(String defaultname) {
		this.defaultname = defaultname;
	}
	public int getIssend() {
		return issend;
	}
	public void setIssend(int issend) {
		this.issend = issend;
	}
	public int getCorank() {
		return corank;
	}
	public void setCorank(int corank) {
		this.corank = corank;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSiteurl() {
		return siteurl;
	}
	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}
	public String getSitepath() {
		return sitepath;
	}
	public void setSitepath(String sitepath) {
		this.sitepath = sitepath;
	}
	public String getChannel() {
		if(channel==0)return "讲义栏目";
		else if(channel==1) return "视频栏目";
		else return "未知频道";
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
}