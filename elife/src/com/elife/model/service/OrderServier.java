package com.elife.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elife.model.beans.MyOrders;
import com.elife.model.beans.Order;
import com.elife.model.dao.IOrdersDao;
import com.elife.model.daoimpl.OrdersDaoImpl;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-6-7 上午11:45:16
 * TODO ---
 *
 */
public class OrderServier {

	IOrdersDao orderDao = new OrdersDaoImpl();



	public boolean addOrders(List<MyOrders> orders) {
		//
		Connection conn = C3p0Utils.getConnection();
		boolean flag = false;
		
		try {
			conn.setAutoCommit(false);
			for (MyOrders order : orders) {
				flag = orderDao.addOrder(conn, order);
			}
			if (flag) {
				// 全部订单已经生成
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * TODO ---
	 */
	public List<Order> getOrdersAdded(int size) {
		//
		return orderDao.getOrdersAdded(size);
	}

}
