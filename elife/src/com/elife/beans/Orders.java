package com.elife.beans;/******************************************************************************* * javaBeans * orders --> Orders  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Orders implements java.io.Serializable {	public Orders() {		super();	}	public Orders(int id, String no, String time, Double total, Object status,			String messaage, int userid, String remark) {		super();		this.id = id;		this.no = no;		this.time = time;		this.total = total;		this.status = status;		this.messaage = messaage;		this.userid = userid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 订单编号 **/	private String no;	/** 订单时间 **/	private String time;	/** 订单总价 **/	private Double total;	/** 订单状态 **/	private Object status;	/** 留言 **/	private String messaage;	/** 所属用户id **/	private int userid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getNo() {		return no;	}	public void setNo(String no) {		this.no = no;	}	public String getTime() {		return time;	}	public void setTime(String time) {		this.time = time;	}	public Double getTotal() {		return total;	}	public void setTotal(Double total) {		this.total = total;	}	public Object getStatus() {		return status;	}	public void setStatus(Object status) {		this.status = status;	}	public String getMessaage() {		return messaage;	}	public void setMessaage(String messaage) {		this.messaage = messaage;	}	public int getUserid() {		return userid;	}	public void setUserid(int userid) {		this.userid = userid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'no':'"+this.getNo()+"',");		sb.append("'time':'"+this.getTime()+"',");		sb.append("'total':'"+this.getTotal()+"',");		sb.append("'status':'"+this.getStatus()+"',");		sb.append("'messaage':'"+this.getMessaage()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","no","time","total","status","messaage","userid","remark"};	}}