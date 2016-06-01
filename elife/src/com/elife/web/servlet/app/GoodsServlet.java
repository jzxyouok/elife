package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Goods;
import com.elife.model.beans.Pager;
import com.elife.model.service.GoodsService;
import com.google.gson.Gson;

/**
 * @author 任创权
 * 编写时间  2016-6-1 下午6:22:30
 * TODO ---
 *
 */
/**
 * <!--商品相关--> <!--以下两个url不放在一起，便于扩展--> <!--获取首页猜你喜欢商品列表，参数：页码page(int)-->
 * <string name="goods_guess_url">/goods?type=1</string>
 * <!--获取零食页面商品列表，参数：页码page(int)--> <string
 * name="goods_snack_url">/goods?type=2</string>
 * <!--获取商家详情页所有宝贝商品列表，参数：页码page(int)、商家id(int)--> <string
 * name="goods_merchant_url">/goods?type=3</string> <!--获取商品详情，参数：商品id(int)-->
 * <string name="goods_detail_url">/goods?type=4</string>
 * 
 * 
 * 
 */
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		/*
		 * type:1:获取猜你喜欢商品列表;2:获取零食商品列表；3
		 * ：获取商家详情页所有宝贝商品列表，参数：页码page(int)、商家id(int)
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			int page = 1;
			String pageStr = req.getParameter("page");
			if (pageStr == null || pageStr == "") {

			} else {
				page = Integer.parseInt(pageStr);
			}

			GoodsService goodsService = new GoodsService();
			Pager<Goods> goodsPager = goodsService.getGoodsPagerByRank(page,
					"0");// 按照默认排序
			System.out.println(goodsPager.toString());
			System.out.println(goodsPager.getObjects());
			// 开始解析
			Gson gson = new Gson();
			List<Goods> goodsList = goodsPager.getObjects();
			String json = gson.toJson(goodsList);
			System.out.println(json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("2")) {
			int page = 1;
			String pageStr = req.getParameter("page");
			if (pageStr == null || pageStr == "") {

			} else {
				page = Integer.parseInt(pageStr);
			}

			GoodsService goodsService = new GoodsService();
			Pager<Goods> goodsPager = goodsService.getGoodsPagerByRank(page,
					"2");// 销量由高到低
			System.out.println(goodsPager.toString());
			System.out.println(goodsPager.getObjects());
			// 开始解析
			Gson gson = new Gson();
			List<Goods> goodsList = goodsPager.getObjects();
			String json = gson.toJson(goodsList);
			System.out.println(json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("3")) {
			int page = 1;
			String pageStr = req.getParameter("page");
			String merchantid = req.getParameter("id");
			if (pageStr == null || pageStr == "") {

			} else {
				page = Integer.parseInt(pageStr);
			}

			GoodsService goodsService = new GoodsService();
			Pager<Goods> goodsPager = goodsService.getGoodsPagerByRank(page,
					"2", merchantid);// 销量由高到低
			System.out.println(goodsPager.toString());
			System.out.println(goodsPager.getObjects());
			// 开始解析
			Gson gson = new Gson();
			List<Goods> goodsList = goodsPager.getObjects();
			String json = gson.toJson(goodsList);
			System.out.println(json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("4")) {
			String goodsId = req.getParameter("id");
			int id=Integer.parseInt(goodsId);
			GoodsService goodsService=new GoodsService();
			Goods goods = goodsService.getGoodsById(id);
			Gson gson = new Gson();
			String json = gson.toJson(goods);
			printWriter.print(json);
			printWriter.close();
		}

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
