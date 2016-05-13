package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Classone;
import com.elife.model.beans.Classsecond;
import com.elife.model.beans.Classthree;
import com.elife.model.dao.IGoodsDao;
import com.elife.model.daoimpl.GoodsDao;

/**
 * @author 高远</n>
 * 编写日期   2016-5-8下午5:01:52</n>
 * 邮箱  wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * TODO</n>
 */
public class ClassService {
	private static final String TAG = "ClassService";
	
	/**
	 * 完成三级分类的数据获取
	 */
	public List<Classone> getAllClass() {
		IGoodsDao goodsDao = new GoodsDao();
		List<Classone> firstClass = goodsDao.getFirstClass();
		//根据分类一得到分类二
		for (Classone classone : firstClass) {
			List<Classsecond> classsecondList = goodsDao
					.getSecondClassByClassOneId(classone.getId());
			classone.setClasssecondList(classsecondList);
			// 根据分类二得到分类三
			for (Classsecond classsecond : classsecondList) {
				List<Classthree> classthreeList = goodsDao
						.getThridClassByClassSecondId(classsecond.getId());
				classsecond.setClassthreeList(classthreeList);
			}
		}
		return firstClass;

	}

	/**
	 * 添加三级分类
	 * 
	 * @return
	 */
	public boolean addClassThree(Classthree classthree) {
		// TODO Auto-generated method stub
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.addThreeClass(classthree);
	}

	/**
	 * TODO
	 */
	public boolean updateThreeName(Classthree classthree) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.updateThreeName(classthree);
	}

}
