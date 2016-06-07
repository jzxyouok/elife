package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.elife.model.beans.MyOrders;
import com.elife.model.beans.Order;
import com.elife.model.dao.IOrdersDao;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-6-7 上午11:49:11
 * TODO ---
 *
 */
public class OrdersDaoImpl implements IOrdersDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.elife.model.dao.IOrdersDao#addOrder(com.elife.model.beans.Orders)
	 */
	@Override
	public boolean addOrder(Connection conn, MyOrders order) {
		// 添加一个订单
		String sql = "insert into orders(time,total,status,message,userid,goodsid,businessid,price,orderpic,addressid) "
				+
 " value(?,?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, order.getNowtime());
			state.setDouble(2, Double.parseDouble(order.getAllprice()));
			state.setInt(3, 2);// 订单状态，订单创建单未支付
			state.setString(4, order.getContent());
			state.setInt(5, order.getUserid());
			state.setInt(6, order.getGoodid());
			state.setInt(7, order.getMerchantid());
			state.setDouble(8, Double.parseDouble(order.getPrice()));
			state.setString(9, order.getOrderpic());
			state.setInt(10, Integer.parseInt(order.getAddressId()));

			int result = state.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IOrdersDao#getOrdersAdded(int)
	 */
	@Override
	public List<Order> getOrdersAdded(int size) {

		String sql = "select * from orders order by id desc limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		
		try {

			List<Order> orderList = queryRunner.query(sql,
					new BeanListHandler<Order>(Order.class), 0, size);

			return orderList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IOrdersDao#addOrders(java.util.List)
	 */
	@Override
	public void addOrders(List<MyOrders> orders) {
		//

	}

}
