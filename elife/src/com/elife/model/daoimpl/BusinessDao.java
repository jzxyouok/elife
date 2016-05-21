package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.elife.model.beans.Business;
import com.elife.model.dao.IBusiness;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:10:06
 * TODO ---
 *
 */
public class BusinessDao implements IBusiness {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IBusiness#addBusiness(com.elife.model.beans.Business)
	 */
	public int addBusiness(Business business) {
		//  
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		Connection conn = C3p0Utils.getConnection();
		String sql = "insert into business(phone,address,storename,nickname,password,status,lasttime)"
				+ " values (?,?,?,?,?,?,?)";
		String[] params = { business.getPhone(), business.getAddress(),
				business.getStorename(), business.getNickname(),
				business.getPassword(), business.getStatus() + "",
				business.getLasttime()
		};
		

		try {

			// 返回操作的记录行
			int flag = runner.update(sql, params);

			// 0表示操作失败，>0表示操作成功需要在接受返回值的地方再做判断
			// return flag;
			
			if (flag > 0) {
				// 插入操作执行成功，现在查询最新的插入行的id
				String sqlGetId = "select id from business order by id desc limit 0,1";
				Business bus = runner.query(sqlGetId,
						new BeanHandler<Business>(Business.class));
				if (bus != null) {
					return bus.getId();
				} else {
					return 0;
				}
			} else {
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * TODO 得到所有的商家信息
	 */
	public List<Business> getAllBusiness() {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());

		String sql = "select * from business";
		
		try {
			List<Business> list = runner.query(sql,
					new BeanListHandler<Business>(Business.class));

			// 判断集合为不为空
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

	/**
	 * TODO 根据id删除商家
	 */
	public boolean deleteById(int deleid) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());

		String sql = "delete from business where id = ?";

		try {
			int flag = runner.update(sql, deleid);
			
			if (flag >= 0) {
				// 删除成功
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("删除用户失败！");
		}
	}

	/**
	 * TODO 根据用户锁定ID
	 * 
	 * @throws SQLException
	 */
	public boolean lockById(int lockId, int businessid) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update business set status = ? where id = ?";
		
		try {
			int flag = runner.update(sql, lockId, businessid);

			if (flag > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


}
