package com.elife.beans;/******************************************************************************* * javaBeans * praise --> Praise  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Praise implements java.io.Serializable {	public Praise() {		super();	}	public Praise(int id, Object status, int newsid, int userid, String remark) {		super();		this.id = id;		this.status = status;		this.newsid = newsid;		this.userid = userid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 赞的状态（是否取消） **/	private Object status;	/** 新闻的id **/	private int newsid;	/** 点赞用户的id **/	private int userid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public Object getStatus() {		return status;	}	public void setStatus(Object status) {		this.status = status;	}	public int getNewsid() {		return newsid;	}	public void setNewsid(int newsid) {		this.newsid = newsid;	}	public int getUserid() {		return userid;	}	public void setUserid(int userid) {		this.userid = userid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'status':'"+this.getStatus()+"',");		sb.append("'newsid':'"+this.getNewsid()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","status","newsid","userid","remark"};	}}