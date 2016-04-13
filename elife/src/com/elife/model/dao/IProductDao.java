package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Classone;
import com.elife.model.beans.Classsecond;
import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;

/**
 * @author 高远</n> 编写时期 2016-4-12 上午9:55:18</n> TODO 关于管理员商品的各种处理</n>
 *         邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 * 
 */
public interface IProductDao {
	/**
	 * 添加一级分类
	 */
	public boolean addFirstClass(Classone classone);

	/**
	 * 添加二级分类
	 */

	public boolean addSecondClass(Classsecond classsecond);

	/**
	 * 添加三级分类
	 */
	public boolean addThreeClass(Classthree classthree);


	/**
	 * 查看一级分类
	 */
	public List<Classone> getFirstClass();

	/**
	 * 查看二级分类
	 */
	public List<Classsecond> getSecondClass();

	/**
	 * 查看三级分类
	 */
	public List<Classthree> getThreeClass();

	/**
	 * 查看一级分类名
	 */
	public Classone getFirstClassById(int id);

	/**
	 * 查看二级分类名
	 */
	public Classsecond getSecondClassById(int id);

	/**
	 * 查看三级分类名
	 */
	public Classthree getThreeClassById(int id);

	/**
	 * 修改一级分类
	 */
	public boolean updateFirstClassById(int id);
	
	/**
	 * 修改二级分类
	 */
	public boolean updateSecondClassById(int id);

	/**
	 * 修改三级分类
	 */
	public boolean updateThreeClassById(int id);

	/**
	 * 查询商品总条数
	 */
	public int getGoodsCount();

	/**
	 * 根据库存量查看商品排行
	 * 
	 * @param 页码
	 */
	public List<Goods> getGoodsByStock(int page);

	/**
	 * 根据卖出量查看商品排行
	 * 
	 * @param 页码
	 */
	public List<Goods> getGoodsBySale(int page);

	/**
	 * 根据商家名分组排行
	 * 
	 * @param:页码
	 */
	public List<Goods> getGoodsByMerchant(int page);

	/**
	 * 根据商品id获取商品
	 * 
	 * @param:商品id
	 */
	public Goods getGoodsById(int id);

	/**
	 * 根据商品id修改商品信息
	 * 
	 * @param:商品id
	 */
	public boolean updateGoodsById(int id);

	/**
	 * 根据商品id限制商品上架出售
	 */
	public boolean banGoodsById(int id);

	/**
	 * 根据商品id取消限制商品上架出售
	 */
	public boolean cancelBanGoodsById(int id);

	/*
	 * 添加商品
	 * 
	 * @prarm Goods 商品信息
	 */
	public boolean addGoods(Goods goods);
}
