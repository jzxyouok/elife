package com.elife.model.beans;

import java.io.Serializable;

/**
 * Created by 叶梦雅 on 2016/5/26.
 */
public class MyOrders implements Serializable {
    int userid;//用户id
    int goodid;//商品id
    int merchantid;//商家id
    int id;//订单id
    String no;//订单编号
    String orderpic;//订单图片地址
    String mercname;//商家名字
    String nowtime;//用来显示当前时间
    String goodname;//商品名称
    String price;//订单单价
    String style;//订单口味或者说是种类
    String orderquit;//订单状态1
    String status;//订单状态2
    String content;//买家留言
    String counts;//订单的数量
    String allprice;//订单的总价
    //new add
    String addressId;//收货地址id

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public MyOrders(){}
    public MyOrders(int userid, int goodid, int merchantid, int id, String no,
                    String orderpic, String mercname, String nowtime, String goodname,
                    String price, String style, String orderquit, String status, String content,
                    String counts, String allprice) {
        this.userid = userid;
        this.goodid = goodid;
        this.merchantid = merchantid;
        this.id = id;
        this.no = no;
        this.orderpic = orderpic;
        this.mercname = mercname;
        this.nowtime = nowtime;
        this.goodname = goodname;
        this.price = price;
        this.style = style;
        this.orderquit = orderquit;
        this.status = status;
        this.content = content;
        this.counts = counts;
        this.allprice = allprice;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
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

    public String getOrderpic() {
        return orderpic;
    }

    public void setOrderpic(String orderpic) {
        this.orderpic = orderpic;
    }

    public String getMercname() {
        return mercname;
    }

    public void setMercname(String mercname) {
        this.mercname = mercname;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getOrderquit() {
        return orderquit;
    }

    public void setOrderquit(String orderquit) {
        this.orderquit = orderquit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getAllprice() {
        return allprice;
    }

    public void setAllprice(String allprice) {
        this.allprice = allprice;
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "userid=" + userid +
                ", goodid=" + goodid +
                ", merchantid=" + merchantid +
                ", id=" + id +
                ", no='" + no + '\'' +
                ", orderpic='" + orderpic + '\'' +
                ", mercname='" + mercname + '\'' +
                ", nowtime='" + nowtime + '\'' +
                ", goodname='" + goodname + '\'' +
                ", price='" + price + '\'' +
                ", style='" + style + '\'' +
                ", orderquit='" + orderquit + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", counts='" + counts + '\'' +
                ", allprice='" + allprice + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}