package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Goodscomment;
import com.google.gson.Gson;

/**
 * @author 任创权
 * 编写时间  2016-6-4 下午2:38:32
 * TODO ---
 *
 */
@WebServlet("/mytest")
public class TestServlet extends HttpServlet {

	static int count = 0;

	protected void doGet(javax.servlet.http.HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		doPost(req, resp);
	};

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
		//
		PrintWriter out = resp.getWriter();
		

		String type = req.getParameter("type");
		
		if (type.equals("1")) {
			// 获取评论列表
			Gson gson = new Gson();
			List<Goodscomment> goodsList = new ArrayList<Goodscomment>();
			
			for (int i = 0; i < 10; i++) {
				goodsList.add(new Goodscomment(1, "这是评论内容" + count, "商品等级",
						"商家等级",
						"服务等级", "时间", 12, 123, "3.5"));
				count++;
			}
			String json = gson.toJson(goodsList);
			out.println(json);
		} else if (type.equals("2")) {

		}

	}


}
