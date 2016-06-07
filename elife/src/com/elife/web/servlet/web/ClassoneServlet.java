package com.elife.web.servlet.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Classone;
import com.elife.model.service.ClassoneService;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午2:46:50
 * TODO ---
 *
 */
@WebServlet("/getclassone")
public class ClassoneServlet extends HttpServlet {
	
	// private final static String TAG = "ClassoneServlet:";

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
		// System.out.println(TAG + "在这里可以得到");
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

		// 得到所有的一级分类（即商家的身份分类）

		ClassoneService classone = new ClassoneService();
		ArrayList<Classone> classonelist = (ArrayList<Classone>) classone
				.getAllClass();
		// System.out.println(TAG + "可以得到所有的一级分类");
		

		if (classonelist != null) {
			//返回的一级分类集合不为空
			// System.out.println(TAG + "一级分类列表不为空");
			req.setAttribute("classonelist", classone.getAllClass());
			req.getRequestDispatcher("web/admin/AddBusiness.jsp").forward(req,
					resp);

		} else {
			// 返回的一级分类集合为空，跳转到错误页面
		}
		



	}

}
