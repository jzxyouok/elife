package com.elife.model.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.elife.model.beans.Classone;
import com.elife.model.dao.IClassone;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午2:25:42
 * TODO ---
 *
 */
public class ClassoneDao implements IClassone {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IClassone#getAllClass()
	 */
	@Override
	public List<Classone> getAllClass() {
//		ArrayList<Classone> classones = null;

		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from classone";

		try {
			ArrayList<Classone> classones = (ArrayList<Classone>) runner.query(
					sql, new BeanListHandler<Classone>(Classone.class));

			// 返回值可能为空，得到这个集合之后需要先判断集合为不为空
			return classones;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IClassone#getClassById(int)
	 */
	@Override
	public String getClassById(int classId) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from classone where id = ?";
		
		try {
			Classone classone = runner.query(sql, new BeanHandler<Classone>(
					Classone.class), classId);

			if (classone != null) {
				return classone.getName();
			} else {
				throw new RuntimeException("获取商家分类失败");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
