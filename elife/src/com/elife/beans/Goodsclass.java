package com.elife.beans;/******************************************************************************* * javaBeans * goodsclass --> Goodsclass  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Goodsclass implements java.io.Serializable {	public Goodsclass() {		super();	}	public Goodsclass(int id, int goodsid, int classthreeid, String remark) {		super();		this.id = id;		this.goodsid = goodsid;		this.classthreeid = classthreeid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 商品id **/	private int goodsid;	/** 三级分类id **/	private int classthreeid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public int getGoodsid() {		return goodsid;	}	public void setGoodsid(int goodsid) {		this.goodsid = goodsid;	}	public int getClassthreeid() {		return classthreeid;	}	public void setClassthreeid(int classthreeid) {		this.classthreeid = classthreeid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'goodsid':'"+this.getGoodsid()+"',");		sb.append("'classthreeid':'"+this.getClassthreeid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","goodsid","classthreeid","remark"};	}}