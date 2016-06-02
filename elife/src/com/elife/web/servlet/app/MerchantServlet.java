package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.elife.model.beans.Business;
import com.elife.model.beans.Pager;
import com.elife.model.service.BusinessService;




/**
 * @author 任创权
 * 编写时间  2016-5-30 下午2:08:19
 * TODO ---
 *
 */
@WebServlet("/merchant")
public class MerchantServlet extends HttpServlet {

	private final String TAG = "MerchantServlet";

	BusinessService businessservice = new BusinessService();
	String[] icons = {
			"https://img.alicdn.com/imgextra/i3/1957017077/TB2teDGoFXXXXaEXXXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i3/1957017077/TB2xLHjoFXXXXblXpXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i1/1957017077/TB2j8bEoFXXXXaYXXXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i1/1957017077/TB2xMYtoFXXXXc2XXXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i3/1957017077/TB2cmjzoFXXXXbPXXXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i2/1957017077/TB2pJfloFXXXXa4XpXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i2/1957017077/TB2yHjdoFXXXXcuXpXXXXXXXXXX_!!1957017077.png",
			"https://img.alicdn.com/imgextra/i1/1957017077/TB2yT99oFXXXXXBXFXXXXXXXXXX_!!1957017077.jpg" };
	int id = (new Random()).nextInt(icons.length);
	
	PrintWriter out;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		out = resp.getWriter();
		String type = req.getParameter("type");
		
		if (type.equals("1")) {
			// 获取商家列表
			String page = req.getParameter("page");
			getALlBusiness(page);
		} else if (type.equals("2")) {
			// 获取商家信息
			String businessid = req.getParameter("id");
			getMerchantMessage(businessid);
		} else if (type.equals("3")) {
			// 评论
			String businessid = req.getParameter("id");
			getMerchantComment(businessid, null, null);
		} else if (type.equals("4")) {
			// 所有的评论
			String businessid = req.getParameter("id");
			String info = req.getParameter("info");
			String page = req.getParameter("page");
			getMerchantComment(businessid, page, info);
		}


	}

	/**
	 * 获取商家的所有评论,,,商家详情页的评论和所有的评论都调用这个方法，，，所有评论还有各种评论的类型（好评中评差评）
	 */
	private void getMerchantComment(String businessid, String page,String info) {
		JSONObject objectJson = new JSONObject();
		int currentpage = 1;
		int commenttype = 1;
		if (businessid == null) {
			// objectJson.put("error", "1");
			// objectJson.put("message", "商家索引为空");
			out.println(objectJson);
			return;
		}
		// 获取当前分页
		if (page == null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(page);
		}
		// 获取需要的评论的类型
		if (info == null) {
			commenttype = 1;
		} else {
			commenttype = Integer.parseInt(info);
		}
		// 根据商家id,评论类型，当前页数，，，获取对应的评论，businessid,currentpage,commentType








	}

	/**
	 * 获取商家所有的信息,根据商家id
	 */
	private void getMerchantMessage(String businessid) {
		JSONObject objectJson = new JSONObject();
		if (businessid == null) {
			// objectJson.put("error", "1");
			// objectJson.put("message", "商家的索引为空");
			out.println(objectJson);
			return;
		}

		Business business = businessservice.getBusinessById(Integer
				.parseInt(businessid));
		if (business == null) {
			// objectJson.put("error", "1");
			// objectJson.put("message", "获取的数据为空");
			out.println(objectJson);
			return;
		} else {
			objectJson.put("id", business.getId());
			objectJson.put("title", business.getStorename());
			objectJson.put("address", business.getAddress());
			objectJson.put("description", business.getRemark()
 + "");// 使用了备用字段
			// 封装商家详情的轮播图，，，稍等
			out.println(objectJson);
			return;
		}

	}

	/**
	 * 获取商家列表
	 */
	private void getALlBusiness(String page) {
		//
		int currentpage = 1;
		// 获取当前页面
		if (page == null || page.equals("")) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(page);
		}

		// 根据当前页面，求对应的数据
		Pager<Business> businessPager = businessservice
				.getAllBusinessByPage(currentpage);
		List<Business> businessList = businessPager.getObjects();
		// 进行数据的封装
		JSONArray arraytJson = new JSONArray();
		// JSONObject objectJson = new JSONObject();
		if (businessList != null) {
			// objectJson.put("error", "0");
			for (Business business : businessList) {
				JSONObject json = new JSONObject();
				json.put("id", business.getId());
				json.put("title", business.getStorename());
				json.put("rateBar", "10");// 这个数据没有
				json.put("begin", "3");// 这个数据没有
				json.put("url", icons[id]);// 这个数据没有
				json.put("nums", "1000");// 这个数据没有
				json.put("page", businessPager.getNowPager());
				arraytJson.put(json);
			}
			// objectJson.put("merchantList", arraytJson);
		} else {
			out.println("-1");
			return;
		}
		out.println(arraytJson);
	}

}
