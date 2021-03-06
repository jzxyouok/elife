package com.elife.model.beans;

/*******************************************************************************
 * javaBeans
 * address --> Address
 * <table explanation>
 * @author 2016-04-11 15:40:38
 *
 */

public class Address implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public Address() {
        super();
    }
    public Address(int id, String name, Object sex, String phone,
                   String addressgeneral, String addressexact, Object status,
                   int userid, String remark) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.addressgeneral = addressgeneral;
        this.addressexact = addressexact;
        this.status = status;
        this.userid = userid;
        this.remark = remark;
    }
    //field
    /**  **/
    private int id;
    /** 收货人姓名 **/
    private String name;
    /** true=男；false=女 **/
    private Object sex;
    /** 手机号 **/
    private String phone;
    /** 大概地址（精确到市） **/
    private String addressgeneral;
    /** 详细地址 **/
    private String addressexact;
    /** 收货地址状态（是否为默认地址） **/
    private Object status;
    /** 所属用户 **/
    private int userid;
    /** 备用字段 **/
    private String remark;
    //method
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Object getSex() {
        return sex;
    }
    public void setSex(Object sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddressgeneral() {
        return addressgeneral;
    }
    public void setAddressgeneral(String addressgeneral) {
        this.addressgeneral = addressgeneral;
    }
    public String getAddressexact() {
        return addressexact;
    }
    public void setAddressexact(String addressexact) {
        this.addressexact = addressexact;
    }
    public Object getStatus() {
        return status;
    }
    public void setStatus(Object status) {
        this.status = status;
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
    //override toString Method
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("{");
        sb.append("'id':'"+this.getId()+"',");
        sb.append("'name':'"+this.getName()+"',");
        sb.append("'sex':'"+this.getSex()+"',");
        sb.append("'phone':'"+this.getPhone()+"',");
        sb.append("'addressgeneral':'"+this.getAddressgeneral()+"',");
        sb.append("'addressexact':'"+this.getAddressexact()+"',");
        sb.append("'status':'"+this.getStatus()+"',");
        sb.append("'userid':'"+this.getUserid()+"',");
        sb.append("'remark':'"+this.getRemark()+"',");
        sb.append("}");
        return sb.toString();
    }
    //return String[] filed;
    public String[] getField() {
        return new String[]{"id","name","sex","phone","addressgeneral","addressexact","status","userid","remark"};
    }
}
