package com.elife.model.beans;

/**
 * @author 任创权
 * 编写时间  2016-6-7 下午3:08:52
 * TODO ---
 *
 */
public class Order implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String no;
	private String time;
	private double total;
	private int status;
	private String message;
	private int userid;
	private String remark;
	private int goodsid;
	private int businessid;
	private double price;
	private String orderpic;
	private int addressid;

	public Order() {
		super();
	}

	public Order(int id, String no, String time, double total, int status,
			String message, int userid, String remark, int goodsid,
			int businessid, double price, String orderpic, int addressid) {
		super();
		this.id = id;
		this.no = no;
		this.time = time;
		this.total = total;
		this.status = status;
		this.message = message;
		this.userid = userid;
		this.remark = remark;
		this.goodsid = goodsid;
		this.businessid = businessid;
		this.price = price;
		this.orderpic = orderpic;
		this.addressid = addressid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public int getBusinessid() {
		return businessid;
	}

	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrderpic() {
		return orderpic;
	}

	public void setOrderpic(String orderpic) {
		this.orderpic = orderpic;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}


}
