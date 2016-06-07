package com.elife.model.dao;

import java.sql.Connection;
import java.util.List;

import com.elife.model.beans.MyOrders;
import com.elife.model.beans.Order;

/**
 * @author 任创权
 * 编写时间  2016-6-7 上午11:46:44
 * TODO ---
 *
 */
public interface IOrdersDao {

	/*
	 * 添加一个订单
	 */
	public boolean addOrder(Connection conn, MyOrders order);

	/*
	 * 添加多个订单
	 */
	public void addOrders(List<MyOrders> orders);

	/**
	 * TODO ---
	 */
	public List<Order> getOrdersAdded(int size);

}
