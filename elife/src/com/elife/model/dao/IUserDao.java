package com.elife.model.dao;

import com.elife.model.beans.Users;

/**
 * @author 任创权
 * 编写时间  2016-6-2 下午3:37:21
 * TODO ---
 *
 */
public interface IUserDao {
	public boolean isExist(String phone);

	public Users login(String phone, String password);
	public boolean addUser(String phone);

	public Users getUserInfo(String phone);

	public boolean update(Users user);

}
