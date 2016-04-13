package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.dao.IGoodsDao;
import com.elife.model.daoimpl.GoodsDao;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午7:45:17</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class GoodsService {

	/**
	 * TODO
	 */
	public List<Classthree> getAllThreeClass() {
		IGoodsDao goodsDao = new GoodsDao();

		return goodsDao.getThreeClass();

	}
	
	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean addGoodsClass(Goodsclass goodsclass) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.addGoodsClass(goodsclass);
	}
	/**
	 * TODO
	 */
	public boolean addGoods(Goods goods) {
		return false;

	}


}
