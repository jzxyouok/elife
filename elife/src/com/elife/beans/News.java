package com.elife.beans;/******************************************************************************* * javaBeans * news --> News  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class News implements java.io.Serializable {	public News() {		super();	}	public News(int id, String content, int praise, int commentnum,			int readnum, String time, int userid, int topicid, Object status,			String remark) {		super();		this.id = id;		this.content = content;		this.praise = praise;		this.commentnum = commentnum;		this.readnum = readnum;		this.time = time;		this.userid = userid;		this.topicid = topicid;		this.status = status;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 新闻内容 **/	private String content;	/** 点赞的数量 **/	private int praise;	/** 评论的数量 **/	private int commentnum;	/** 浏览人数 **/	private int readnum;	/** 发表时间 **/	private String time;	/** 发表人id **/	private int userid;	/** 所属话题的id **/	private int topicid;	/** 状态（允不允许显示） **/	private Object status;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getContent() {		return content;	}	public void setContent(String content) {		this.content = content;	}	public int getPraise() {		return praise;	}	public void setPraise(int praise) {		this.praise = praise;	}	public int getCommentnum() {		return commentnum;	}	public void setCommentnum(int commentnum) {		this.commentnum = commentnum;	}	public int getReadnum() {		return readnum;	}	public void setReadnum(int readnum) {		this.readnum = readnum;	}	public String getTime() {		return time;	}	public void setTime(String time) {		this.time = time;	}	public int getUserid() {		return userid;	}	public void setUserid(int userid) {		this.userid = userid;	}	public int getTopicid() {		return topicid;	}	public void setTopicid(int topicid) {		this.topicid = topicid;	}	public Object getStatus() {		return status;	}	public void setStatus(Object status) {		this.status = status;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'content':'"+this.getContent()+"',");		sb.append("'praise':'"+this.getPraise()+"',");		sb.append("'commentnum':'"+this.getCommentnum()+"',");		sb.append("'readnum':'"+this.getReadnum()+"',");		sb.append("'time':'"+this.getTime()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'topicid':'"+this.getTopicid()+"',");		sb.append("'status':'"+this.getStatus()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","content","praise","commentnum","readnum","time","userid","topicid","status","remark"};	}}