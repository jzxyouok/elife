package com.elife.web.servlet.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.service.GoodsService;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午6:44:32</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
@WebServlet("/goodsservlet")
public class GoodsServlet extends HttpServlet {

	private static final String TAG = "GoodsServlet";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		/*
		 * 如果type=1,表示获取三级分类信息；2代表添加商品。测试数据，商家默认是零食，id:1
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			List<Classthree> classthrees = goodsService.getAllThreeClass();
			if (classthrees != null) {
				req.setAttribute("classthrees", classthrees);
				req.getRequestDispatcher("web/admin/AddGoods.jsp").forward(req,
						resp);
			} else {
				System.out.println(TAG + "：获取三级分类失败。");
			}
		} else if (type.equals("2")) {
			/*
			 * 逻辑：第一步：获取商品基本信息、商家id、商品分类id数组.
			 * 第二步：存储商品信息，返回商品id.第三步：遍历存储商品id和对应分类id到三级分类中间表
			 */
			Goods goods = new Goods();
			try {
				// 第一步
				BeanUtils.populate(goods, req.getParameterMap());
				// 获取分类组数据
				String[] threeclassid = req.getParameterValues("threeclassid");// 这个数据不能保存到商品表中。应该通过商品id，把商品id和三级分类id保存到对应的三级中间表中。
				// System.out.println(TAG + ":" +
				// Arrays.toString(threeclassid));
				// 第二步


				for (int i = 0; i < threeclassid.length; i++) {
					Goodsclass goodsclass = new Goodsclass();
					goodsclass.setClassthreeid(Integer
							.parseInt(threeclassid[i]));
					goodsclass.setGoodsid(goods.getId());
					boolean isAdd = goodsService.addGoodsClass(goodsclass);
					if (isAdd) {
						System.out.println(TAG + ":" + "添加三级分类中间表成功");
					} else {
						System.out.println(TAG + ":" + "添加三级分类中间表失败");
					}
					goodsclass = null;// 释放资源
				}

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(TAG + ":测试打印数据：" + goods);
			boolean isAdd = goodsService.addGoods(goods);
			if (isAdd) {

			} else {
				System.out.println(TAG + "：添加商品失败");
			}
		}
	}

}
