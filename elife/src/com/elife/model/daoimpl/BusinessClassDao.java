package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.elife.model.beans.Businessclass;
import com.elife.model.dao.IBusinessClass;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:41:15
 * TODO ---
 *
 */
public class BusinessClassDao implements IBusinessClass {

	private List<Businessclass> query;

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IBusinessClass#addBusinessClass(int, java.lang.String)
	 */
	@Override
	public boolean addBusinessClass(Connection conn, Businessclass businessclass) {
		//  
		// QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into businessclass(business,classoneid) values (?,?)";
		// boolean

		try {
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, businessclass.getBusiness());
			state.setInt(2, businessclass.getClassoneid());
			int flag = state.executeUpdate();

			// 0表示操作失败，>0表示操作成功需要在接受返回值的地方再做判断
			return flag > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IBusinessClass#getClassById(int)
	 */
	@Override
	public List<Businessclass> getClassById(int businessid) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from businessclass where business = ?";
		
		try {

			List<Businessclass> result = runner.query(sql,
					new BeanListHandler<Businessclass>(
					Businessclass.class), businessid);
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
