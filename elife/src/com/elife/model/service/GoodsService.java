package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.beans.Goodsimg;
import com.elife.model.beans.Pager;
import com.elife.model.dao.IGoodsDao;
import com.elife.model.daoimpl.GoodsDao;
import com.elife.utils.PageUtils;
import com.elife.utils.ParamUtils;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午7:45:17</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class GoodsService {

	private static final String TAG = "GoodsService";

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
	public int addGoods(Goods goods) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.addGoods(goods);

	}

	/**
	 * TODO
	 */
	public boolean addGoodsImg(Goodsimg gs) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.addGoodsImg(gs);
	}



	public Pager<Goods> getGoodsPager(int page) {
		IGoodsDao goodsDao = new GoodsDao();
		Pager<Goods> p=new Pager<Goods>();
		List<Goods> goodsList=goodsDao.getGoodsList(page);//过去List参数
		int count =goodsDao.getGoodsCount();//获取总条数
		
		p.setNowPager(page);//设置当前页
		p.setPerSize(ParamUtils.PERPAGE);//设置每页大小
		p.setTotalRecordNum(count);//设置总条数
		p.setTotalPageNum(PageUtils.getPagersByNums(count));//设置总页数
		p.setObjects(goodsList);//封装信息list
		return p;
	}

	/**
	 * TODO
	 */
	public Goods getGoodsById(int id) {
		IGoodsDao goodsDao = new GoodsDao();
		Goods goods=new Goods();
		List<Classthree> classThreesList = goodsDao.getThreeClass();// 获取所有分类
		List<Goodsimg> goodsImgList = goodsDao.getGoodsImgByGoodsId(id);// 根据商品id获取图片
		goods = goodsDao.getGoodsById(id);// 获取商品基本信息
		goods.setClassThreesList(classThreesList);
		goods.setGoodsImgsList(goodsImgList);
		return goods;
	}

	/**
	 * TODO
	 */
	public boolean updateGoods(Goods goods) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.updateGoods(goods);
	}

	/**
	 * TODO
	 */
	public boolean updateGoodsClass(Goodsclass goodsclass) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.updateGoodsClass(goodsclass);
	}

	/**
	 * TODO
	 */
	public boolean updateGoodsImg(Goodsimg gs) {
		IGoodsDao goodsDao = new GoodsDao();
		return goodsDao.updateGoodsImg(gs);
	}

	/**
	 * TODO
	 */
	public boolean deleteGoodsImgByGoodsId(int id) {
		IGoodsDao goodsDao = new GoodsDao();
		boolean isdel = goodsDao.deleteGoodsByGoodsId(id);
		return isdel;
	}

}
