package com.elife.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elife.model.beans.Businessclass;
import com.elife.model.daoimpl.BusinessClassDao;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-5-20 上午1:14:12
 * TODO ---
 *
 */
public class BusinessClassService {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IBusinessClass#addBusinessClass(com.elife.model.beans.Businessclass)
	 */
	public boolean addBusinessClass(List<Businessclass> BClist) {
		//  
		BusinessClassDao BClassDao = new BusinessClassDao();
		Connection conn = C3p0Utils.getConnection();
		
		boolean isSuccess = false;


		try {
			// 开启事务
			conn.setAutoCommit(false);
			for (Businessclass businessclass : BClist) {
				if (BClassDao.addBusinessClass(conn, businessclass)) {
					isSuccess = true;
				}else{
					isSuccess = false;
					break;
				}
			}

			if (isSuccess) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
