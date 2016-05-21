package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Classone;
import com.elife.model.daoimpl.ClassoneDao;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午2:42:58
 * TODO ---
 *
 */
public class ClassoneService {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.IClassone#getAllClass()
	 */

	public List<Classone> getAllClass() {
		ClassoneDao classonedao = new ClassoneDao();
		return classonedao.getAllClass();
	}

}
