package com.elife.beans;public class Admin implements java.io.Serializable {	private static final long serialVersionUID = 1L;	public Admin() {		super();	}	public Admin(int id, String username, String password, Object level,			String remark) {		super();		this.id = id;		this.username = username;		this.password = password;		this.level = level;		this.remark = remark;	}	//field	/**  **/	private int id;	/** 用户名 **/	private String username;	/** 密码 **/	private String password;	/** 管理员等级 **/	private Object level;	/** 备用字段 **/	private String remark;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getUsername() {		return username;	}	public void setUsername(String username) {		this.username = username;	}	public String getPassword() {		return password;	}	public void setPassword(String password) {		this.password = password;	}	public Object getLevel() {		return level;	}	public void setLevel(Object level) {		this.level = level;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'username':'"+this.getUsername()+"',");		sb.append("'password':'"+this.getPassword()+"',");		sb.append("'level':'"+this.getLevel()+"',");		sb.append("'remark':'"+this.getRemark()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","username","password","level","remark"};	}}