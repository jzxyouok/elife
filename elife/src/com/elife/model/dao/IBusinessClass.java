package com.elife.model.dao;

import java.sql.Connection;
import java.util.List;

import com.elife.model.beans.Businessclass;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午4:37:11
 * TODO ---
 *
 */
public interface IBusinessClass {

	/**
	 * 根据商家的id和商家的身份类别完善商家的信息，返回插入的信息
	 */
	public boolean addBusinessClass(Connection conn, Businessclass businessclass);

	/**
	 * 根据商家的id，获取商家的身份信息
	 */
	
	public List<Businessclass> getClassById(int businessid);


}
