package com.elife.model.beans;/******************************************************************************* * javaBeans * favorite --> Favorite  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Favorite implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Favorite() {		super();	}	public Favorite(int id, int favoriteid, int identity, int userid,			String remark) {		super();		this.id = id;		this.favoriteid = favoriteid;		this.identity = identity;		this.userid = userid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 可以是商品也可以是商家 **/	private int favoriteid;	/** 区别收藏的商家还是商品 **/	private int identity;	/** 收藏的用户的id **/	private int userid;	/** remark **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public int getFavoriteid() {		return favoriteid;	}	public void setFavoriteid(int favoriteid) {		this.favoriteid = favoriteid;	}	public int getIdentity() {		return identity;	}	public void setIdentity(int identity) {		this.identity = identity;	}	public int getUserid() {		return userid;	}	public void setUserid(int userid) {		this.userid = userid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'favoriteid':'"+this.getFavoriteid()+"',");		sb.append("'identity':'"+this.getIdentity()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","favoriteid","identity","userid","remark"};	}}