package com.elife.model.service;

import com.elife.model.beans.Users;
import com.elife.model.dao.IUserDao;
import com.elife.model.daoimpl.UserDao;

/**
 * @author 任创权
 * 编写时间  2016-6-2 下午3:36:49
 * TODO ---
 *
 */
public class UserService {

	/**
	 * TODO ---
	 */
	public boolean check(String phone) {
		IUserDao iUserDao = new UserDao();
		return iUserDao.isExist(phone);
	}

	/**
	 * TODO ---
	 */
	public boolean add(String phone) {
		IUserDao iUserDao = new UserDao();
		return iUserDao.addUser(phone);
	}

	/**
	 * TODO ---
	 */
	public Users getUserInfo(String phone) {
		IUserDao iUserDao = new UserDao();
		return iUserDao.getUserInfo(phone);
	}

	/**
	 * TODO ---
	 */
	public Users checkUser(String phone, String password) {
		IUserDao iUserDao = new UserDao();
		return iUserDao.login(phone, password);
	}

	/**
	 * TODO ---
	 */
	public boolean update(Users user) {
		IUserDao iUserDao = new UserDao();
		return iUserDao.update(user);
	}

}
