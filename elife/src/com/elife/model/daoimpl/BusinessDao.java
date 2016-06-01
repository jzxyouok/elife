package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.elife.model.beans.Business;
import com.elife.model.dao.IBusiness;
import com.elife.utils.C3p0Utils;
import com.elife.utils.PageUtils;
import com.elife.utils.ParamUtils;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:10:06
 * TODO ---
 *
 */
public class BusinessDao implements IBusiness {

	private final String TAG = "BusinessDao";

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

	/**
	 * TODO 得到所有的商家信息
	 */
	public List<Business> getAllBusinessByPage(int page) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from business limit ?,?";
		try {
			List<Business> list = runner.query(sql,
					new BeanListHandler<Business>(Business.class),
					PageUtils.getParam1(page), ParamUtils.PERPAGE);
			
			System.out.println(TAG + PageUtils.getParam1(page)
					+
					ParamUtils.PERPAGE);
			System.out.println("数据集合大小" + list.size());
			
			// 判断集合为不为空
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取商家的个数
	 */
	public int getGoodsCount() {
		String sql = "select count(*) from business";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			long totalRecordNum = (Long) queryRunner.query(sql,
					new ScalarHandler(1));
			return (int) totalRecordNum;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Business getBussinessById(int businessid) {
		String sql = "select * from business where id = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Business business = queryRunner.query(sql,
					new BeanHandler<Business>(Business.class), businessid);
			return business;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


}
