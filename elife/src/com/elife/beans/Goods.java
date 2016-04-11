package com.elife.beans;/******************************************************************************* * javaBeans * goods --> Goods  * <table explanation> * @author 2016-04-11 15:40:38 *  */	public class Goods implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Goods() {		super();	}	public Goods(int id, String name, String description, Double price,			int stock, Double oldprice, int sale, Object status,			int businessid, int threeclassid, String remark) {		super();		this.id = id;		this.name = name;		this.description = description;		this.price = price;		this.stock = stock;		this.oldprice = oldprice;		this.sale = sale;		this.status = status;		this.businessid = businessid;		this.threeclassid = threeclassid;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 商品名称 **/	private String name;	/** 商品描述 **/	private String description;	/** 商品价格 **/	private Double price;	/** 库存 **/	private int stock;	/** 商品原价 **/	private Double oldprice;	/** 销售量 **/	private int sale;	/** 状态 **/	private Object status;	/** 所属商家 **/	private int businessid;	/** 所属三级分类的id **/	private int threeclassid;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public String getDescription() {		return description;	}	public void setDescription(String description) {		this.description = description;	}	public Double getPrice() {		return price;	}	public void setPrice(Double price) {		this.price = price;	}	public int getStock() {		return stock;	}	public void setStock(int stock) {		this.stock = stock;	}	public Double getOldprice() {		return oldprice;	}	public void setOldprice(Double oldprice) {		this.oldprice = oldprice;	}	public int getSale() {		return sale;	}	public void setSale(int sale) {		this.sale = sale;	}	public Object getStatus() {		return status;	}	public void setStatus(Object status) {		this.status = status;	}	public int getBusinessid() {		return businessid;	}	public void setBusinessid(int businessid) {		this.businessid = businessid;	}	public int getThreeclassid() {		return threeclassid;	}	public void setThreeclassid(int threeclassid) {		this.threeclassid = threeclassid;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'name':'"+this.getName()+"',");		sb.append("'description':'"+this.getDescription()+"',");		sb.append("'price':'"+this.getPrice()+"',");		sb.append("'stock':'"+this.getStock()+"',");		sb.append("'oldprice':'"+this.getOldprice()+"',");		sb.append("'sale':'"+this.getSale()+"',");		sb.append("'status':'"+this.getStatus()+"',");		sb.append("'businessid':'"+this.getBusinessid()+"',");		sb.append("'threeclassid':'"+this.getThreeclassid()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","name","description","price","stock","oldprice","sale","status","businessid","threeclassid","remark"};	}}