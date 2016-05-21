package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Business;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:05:17
 * TODO ---
 *
 */
public interface IBusiness {

	/**
	 * TODO 添加新的商家,并返回该商家的id
	 */
	public int addBusiness(Business business);
	
	/**
	 * 
	 * TODO 得到所有的商家
	 */
	public List<Business> getAllBusiness();
	
	/**
	 * 
	 * 根据id删除用户
	 */
	public boolean deleteById(int deleteid);

	public boolean lockById(int lockId, int businessid);


}
