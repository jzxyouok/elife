package com.elife.model.beans;/******************************************************************************* * javaBeans * classsecond --> Classsecond  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Classsecond implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Classsecond() {		super();	}	public Classsecond(int id, String name, int classoneid, String remark) {		super();		this.id = id;		this.name = name;		this.classoneid = classoneid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 二级分类名称 **/	private String name;	/** 一级分类id **/	private int classoneid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public int getClassoneid() {		return classoneid;	}	public void setClassoneid(int classoneid) {		this.classoneid = classoneid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'name':'"+this.getName()+"',");		sb.append("'classoneid':'"+this.getClassoneid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","name","classoneid","remark"};	}}