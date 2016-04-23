package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Classone;
import com.elife.model.beans.Classsecond;
import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.beans.Goodsimg;
import com.elife.model.beans.Pager;

/**
 * @author 高远</n> 编写时期 2016-4-12 上午9:55:18</n> TODO 关于管理员商品的各种处理</n>
 *         邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 * 
 */
public interface IGoodsDao {
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
	public boolean updateFirstClassById(Classone classone);
	
	/**
	 * 修改二级分类
	 */
	public boolean updateSecondClassById(Classsecond classsecond);

	/**
	 * 修改三级分类
	 */
	public boolean updateThreeClassById(Classthree classthree);

	/**
	 * 查询商品总条数
	 */
	public int getGoodsCount();

	/**
	 * 根据库存量查看商品排行
	 * 
	 * @param 页码
	 */
	public List<Goods> getGoodsByStock(int page,boolean bl);

	/**
	 * 根据卖出量查看商品排行
	 * 
	 * @param 页码 true表示由高到低
	 */
	public List<Goods> getGoodsBySale(int page, boolean bl);

	/**
	 * 根据商家id查询商品
	 * 
	 * @param:页码
	 */
	public List<Goods> getGoodsByMerchant(int businessid);

	
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
	public boolean updateGoodsById(Goods goods);

	/**
	 * 根据商品id限制商品上架出售
	 */
	public boolean toggleGoodsById(int id);


	/*
	 * 添加商品
	 * 
	 * @prarm Goods 商品信息;修改该接口返回boolean，返回id。失败返回-1
	 */
	public int addGoods(Goods goods);

	/**
	 * 添加三级中间表 goodsclass 插入数据
	 */
	public boolean addGoodsClass(Goodsclass goodsclass);
	/*
	 * 添加接口：添加商品图片表。添加时间：0414
	 */

	public boolean addGoodsImg(Goodsimg goodsimg);
	
	/*
	 * 添加接口：获取商品Pager(默认顺序)。添加时间：0416
	 */

	public Pager<Goods> getGoodsPager(int page);
	/*
	 * 添加接口：获取商品list(默认顺序)。添加时间：0416
	 */

	public List<Goods> getGoodsList(int page);
	/*
	
	 * 添加接口：获取商家名字。添加时间：0416
	 */

	public String getBusinessNameById(int id);

	/**
	 * 添加接口： 根据商品id获取图片。添加时间：0423
	 */
	public List<Goodsimg> getGoodsImgByGoodsId(int id);

	/**
	 * 添加接口： 根据商品id更新商品信息。添加时间：0423
	 */
	public boolean updateGoods(Goods goods);

	/**
	 * TODO 添加接口： 根据Goodsclass（包含商品id）更新商品分类信息。添加时间：0423
	 */
	public boolean updateGoodsClass(Goodsclass goodsclass);

	/**
	 * TODO 添加接口： 根据商品id更新。添加时间：0423
	 */
	public boolean updateGoodsImg(Goodsimg gs);

	/**
	 * 添加接口： 根据商品id删除原有图片。添加时间：0423
	 */
	public boolean deleteGoodsByGoodsId(int goodsid);
	
}
