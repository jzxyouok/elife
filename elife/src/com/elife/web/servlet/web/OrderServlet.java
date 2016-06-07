package com.elife.web.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.MyOrders;
import com.elife.model.beans.Order;
import com.elife.model.service.OrderServier;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author 任创权
 * 编写时间  2016-6-7 上午8:35:52
 * TODO ---
 *
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

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
		
		// json形式的List<Myorders>集合
		OrderServier orderService = new OrderServier();

		Gson gson = new Gson();
		// Orders order = new Orders();
		String type = req.getParameter("type");
		out.println("访问成功");

		if (type.equals("1")) {
			String confirmorder = req.getParameter("confirmorder");
			if (confirmorder == null) {
				out.println("-1");
				return;
			}
			
			List<MyOrders> orderList = gson.fromJson(confirmorder,
					new TypeToken<List<MyOrders>>() {
					}.getType());

			if (orderService.addOrders(orderList)) {
				// 生成订单成功,返回订单的数据集合（会不会有多线程的问题）
				// 获得刚刚插入的数据记录
				List<Order> orders = orderService.getOrdersAdded(orderList
						.size());
				if (orders != null) {

					// 更新id，这是从数据库中取出来的
					for (int i = 0; i < orders.size(); i++) {
						orderList.get(i).setId(
								orders.get(orders.size() - i - 1).getId());
					}
					String result = gson.toJson(orderList);
					out.println(result);
				} else {
					out.println("1获取的集合为空");
				}

			} else {
				// 失败，返回创建订单失败的状态码
				out.println("1创建失败");
			}
		}
		



	}
}
