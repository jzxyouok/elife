package com.elife.model.service;

import java.util.ArrayList;
import java.util.List;

import com.elife.model.beans.Business;
import com.elife.model.beans.Businessclass;
import com.elife.model.daoimpl.BusinessClassDao;
import com.elife.model.daoimpl.BusinessDao;
import com.elife.model.daoimpl.ClassoneDao;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:21:52
 * TODO ---
 *
 */
public class BusinessService {

	/**
	 * 
	 */
	private static final String TAG = "BusinessService";
	BusinessDao businessdao = new BusinessDao();

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IBusiness#addBusiness(com.elife.model.beans.Business)
	 */
	public int addBusiness(Business business) {
		//
		return businessdao.addBusiness(business);
	}

	/**
	 * TODO 得到所有的商家信息
	 */
	public List<Business> getAllBusiness() {
		//
		List<Business> businessList = new ArrayList<Business>();
		// 获取商家的用户信息
		businessList = businessdao.getAllBusiness();
		// 封装商家的身份类型
		BusinessClassDao bcDao = new BusinessClassDao();
		ClassoneDao coDao = new ClassoneDao();
		for (int i = 0; i < businessList.size(); i++) {
			// 获取商家的身份类型
			List<Businessclass> result = bcDao.getClassById(businessList.get(i)
					.getId());
			if (result == null) {
				System.out.println(TAG + "获取的商家身份集合为空");
			} else {
				System.out.println(TAG + "商家身份集合大小" + result.size());
			}
			String identity = "";
			if (result != null) {
				for (Businessclass businessclass : result) {

					String name = coDao.getClassById(businessclass
							.getClassoneid());
					identity = identity + " " + name;
				}
			}
			businessList.get(i).setIdentity(identity);
		}
		return businessList;
	}

	/**
	 * TODO 根据用户id删除用户，还需要删除用户的很多信息 ，凡是参照了该表主键的都需要删除（将有很多表数据需要删除）
	 */
	public boolean deleteById(int deleid) {
		//
		return businessdao.deleteById(deleid);
	}

	/**
	 * TODO 根据id锁定用户
	 * 
	 * @param businessid
	 */
	public boolean lockById(int lockId, int businessid) {
		//
		return businessdao.lockById(lockId, businessid);
	}

}
