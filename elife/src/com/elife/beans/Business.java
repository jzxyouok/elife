package com.elife.beans;public class Business implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Business() {		super();	}	public Business(int id, String username, String nickname, String password,			String phone, String email, Object identity, String storename,			String address, Object status, String verify, String lasttime,			Object stamp, String remark) {		super();		this.id = id;		this.username = username;		this.nickname = nickname;		this.password = password;		this.phone = phone;		this.email = email;		this.identity = identity;		this.storename = storename;		this.address = address;		this.status = status;		this.verify = verify;		this.lasttime = lasttime;		this.stamp = stamp;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 用户名 **/	private String username;	/** 昵称 **/	private String nickname;	/** 密码 **/	private String password;	/** 手机号 **/	private String phone;	/** 邮箱 **/	private String email;	/** 身份类型 **/	private Object identity;	/** 商店名称 **/	private String storename;	/** 商家地址 **/	private String address;	/** 商家状态 **/	private Object status;	/** 验证码 **/	private String verify;	/** 上次登录时间 **/	private String lasttime;	/** 时间戳 **/	private Object stamp;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getUsername() {		return username;	}	public void setUsername(String username) {		this.username = username;	}	public String getNickname() {		return nickname;	}	public void setNickname(String nickname) {		this.nickname = nickname;	}	public String getPassword() {		return password;	}	public void setPassword(String password) {		this.password = password;	}	public String getPhone() {		return phone;	}	public void setPhone(String phone) {		this.phone = phone;	}	public String getEmail() {		return email;	}	public void setEmail(String email) {		this.email = email;	}	public Object getIdentity() {		return identity;	}	public void setIdentity(Object identity) {		this.identity = identity;	}	public String getStorename() {		return storename;	}	public void setStorename(String storename) {		this.storename = storename;	}	public String getAddress() {		return address;	}	public void setAddress(String address) {		this.address = address;	}	public Object getStatus() {		return status;	}	public void setStatus(Object status) {		this.status = status;	}	public String getVerify() {		return verify;	}	public void setVerify(String verify) {		this.verify = verify;	}	public String getLasttime() {		return lasttime;	}	public void setLasttime(String lasttime) {		this.lasttime = lasttime;	}	public Object getStamp() {		return stamp;	}	public void setStamp(Object stamp) {		this.stamp = stamp;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'username':'"+this.getUsername()+"',");		sb.append("'nickname':'"+this.getNickname()+"',");		sb.append("'password':'"+this.getPassword()+"',");		sb.append("'phone':'"+this.getPhone()+"',");		sb.append("'email':'"+this.getEmail()+"',");		sb.append("'identity':'"+this.getIdentity()+"',");		sb.append("'storename':'"+this.getStorename()+"',");		sb.append("'address':'"+this.getAddress()+"',");		sb.append("'status':'"+this.getStatus()+"',");		sb.append("'verify':'"+this.getVerify()+"',");		sb.append("'lasttime':'"+this.getLasttime()+"',");		sb.append("'stamp':'"+this.getStamp()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","username","nickname","password","phone","email","identity","storename","address","status","verify","lasttime","stamp","remark"};	}}