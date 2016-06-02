package com.elife.model.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.elife.model.beans.Users;
import com.elife.model.dao.IUserDao;
import com.elife.utils.C3p0Utils;
import com.elife.utils.MD5Utils;

/**
 * @author 任创权
 * 编写时间  2016-6-2 下午3:46:09
 * TODO ---
 *
 */
public class UserDao implements IUserDao {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IUserDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String phone) {
		String sql = "select * from users where phone = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Users users = queryRunner.query(sql, new BeanHandler<Users>(
					Users.class), phone);
			if (users == null) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IUserDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Users login(String phone, String password) {
		String sql = "select * from users where phone = ? and password=?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Users users = queryRunner.query(sql, new BeanHandler<Users>(
					Users.class), phone, password);
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IUserDao#addUser(java.lang.String)
	 */
	@Override
	public boolean addUser(String phone) {
		String sql = "insert into users(phone) values(?)";
		Object[] param = { phone };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IUserDao#getUserInfo(java.lang.String)
	 */
	@Override
	public Users getUserInfo(String phone) {

		String sql = "select * from users where phone = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Users users = queryRunner.query(sql, new BeanHandler<Users>(
					Users.class), phone);
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IUserDao#update(com.elife.model.beans.Users)
	 */
	@Override
	public boolean update(Users user) {
		String sql = "update Users set username=?,nickname=?,password=?,email=?,sex=?,age=?,birthday=?,headimg=?,address=?,school=?,verify=?,status=?,remark=? where phone=?";
		Object[] param = { user.getUsername(), user.getNickname(),
				MD5Utils.md5(user.getPassword()), user.getEmail(),
				user.getSex(), user.getAge(), user.getBirthday(),
				user.getHeadimg(), user.getAddress(), user.getSchool(),
				user.getVerify(), user.getStatus(),
				user.getRemark(), user.getPhone() };

		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
