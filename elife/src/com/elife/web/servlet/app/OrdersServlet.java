package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author 任创权
 * 编写时间  2016-6-5 下午3:19:52
 * TODO ---
 *
 */
@WebServlet("/ordertest")
public class OrdersServlet extends HttpServlet {

	static int count = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		String type = req.getParameter("type");
		String page = req.getParameter("page");

		JSONArray jsonarray = new JSONArray();

		for (int i = 0; i < 6; i++) {
			JSONObject object = new JSONObject();
			object.put("userid", count);
			object.put("goodid", count);
			object.put("id", count);
			object.put("no", type + count + "");
			object.put("orderpic",
					"http://p4.so.qhimg.com/bdr/_240_/t019b66d2bf56d59354.jpg ");
			object.put("goodname", "老干妈第" + page + "页");
			object.put("mercname", "乐可便利");
			object.put("nowtime", "2016-5-25");
			object.put("price", "23.00");
			object.put("status", type);
			object.put("orderquit", "0");
			object.put("content", "请发申通");
			object.put("counts", "3");
			object.put("allprice", "30");
			jsonarray.put(object);
		}
		out.println(jsonarray);
	}


}
