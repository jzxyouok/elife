package com.elife.model.beans;/******************************************************************************* * javaBeans * banner --> Banner  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Banner implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Banner() {		super();	}	public Banner(int id, String classfirst, String classsecond,			String imgaddress, String url) {		super();		this.id = id;		this.classfirst = classfirst;		this.classsecond = classsecond;		this.imgaddress = imgaddress;		this.url = url;	}	public Banner(int id, String classfirst, String classsecond,			String imgaddress, String url, String remark) {		super();		this.id = id;		this.classfirst = classfirst;		this.classsecond = classsecond;		this.imgaddress = imgaddress;		this.url = url;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 轮播图的一级分类 **/	private String classfirst;	/** 轮播图的二级分类 **/	private String classsecond;	/** 图片地址 **/	private String imgaddress;	/** 图片链接的地址 **/	private String url;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getClassfirst() {		return classfirst;	}	public void setClassfirst(String classfirst) {		this.classfirst = classfirst;	}	public String getClasssecond() {		return classsecond;	}	public void setClasssecond(String classsecond) {		this.classsecond = classsecond;	}	public String getImgaddress() {		return imgaddress;	}	public void setImgaddress(String imgaddress) {		this.imgaddress = imgaddress;	}	public String getUrl() {		return url;	}	public void setUrl(String url) {		this.url = url;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'classfirst':'"+this.getClassfirst()+"',");		sb.append("'classsecond':'"+this.getClasssecond()+"',");		sb.append("'imgaddress':'"+this.getImgaddress()+"',");		sb.append("'url':'"+this.getUrl()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","classfirst","classsecond","imgaddress","url","remark"};	}}