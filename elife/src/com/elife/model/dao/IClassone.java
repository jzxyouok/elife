package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Classone;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午2:24:28
 * TODO ---
 *
 */
public interface IClassone {
	
	/**
	 * TODO 得到所有的一级分类
	 */
	public List<Classone> getAllClass();

	/**
	 * 根据id获取身份类型
	 */
	public String getClassById(int classId);


}
