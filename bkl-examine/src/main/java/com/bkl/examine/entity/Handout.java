package com.bkl.examine.entity;
import java.math.BigDecimal;

import com.km.common.dao.TableAonn;
import com.km.common.utils.TimeUtil;
@TableAonn(tableName = "handout")
public class Handout {
	public static final int FREE_TRUE=1;
	public static final int FREE_FALSE=0;
	private int id;
	private int typeid;
	private String redirecturl;
	private String userip;
	private int sortrank;
	private int click;
	private String shorttitle;
	private String source;
	private int pubdate;
	private int senddate;
	private String keywords;
	private int postnum;
	private String likeid;
	private int hid;
	private int mid;
	private int free;
	private BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getFree() {
		if(free==1)return "免费";
		else if(free==0)return "收费";
		else return "未定义";
	}
	public void setFree(int free) {
		this.free = free;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getRedirecturl() {
		return redirecturl;
	}
	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	public int getSortrank() {
		return sortrank;
	}
	public void setSortrank(int sortrank) {
		this.sortrank = sortrank;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public String getShorttitle() {
		return shorttitle;
	}
	public void setShorttitle(String shorttitle) {
		this.shorttitle = shorttitle;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPubdate() {
		return TimeUtil.fromUnixTime(pubdate);
	}
	public void setPubdate(int pubdate) {
		this.pubdate = pubdate;
	}
	public String getSenddate() {
		return TimeUtil.fromUnixTime(senddate);
	}
	public void setSenddate(int senddate) {
		this.senddate = senddate;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
}