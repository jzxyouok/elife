package com.elife.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 高远</n> 编写时期 2016-4-11 上午10:07:06</n> TODO 这是这个方法的说明</n>
 * 
 */
@WebServlet("/demoservlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "DemoServlet";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/*
	 * 该方法主要实现了web请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// your code
		System.out.println(TAG + ":");
	}

}
