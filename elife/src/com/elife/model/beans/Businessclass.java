package com.elife.model.beans;/******************************************************************************* * javaBeans * businessclass --> Businessclass  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Businessclass implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Businessclass() {		super();	}	public Businessclass(int id, int business, int classoneid, String remark) {		super();		this.id = id;		this.business = business;		this.classoneid = classoneid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 商家id **/	private int business;	/** 一级分类表 **/	private int classoneid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public int getBusiness() {		return business;	}	public void setBusiness(int business) {		this.business = business;	}	public int getClassoneid() {		return classoneid;	}	public void setClassoneid(int classoneid) {		this.classoneid = classoneid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'business':'"+this.getBusiness()+"',");		sb.append("'classoneid':'"+this.getClassoneid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","business","classoneid","remark"};	}}