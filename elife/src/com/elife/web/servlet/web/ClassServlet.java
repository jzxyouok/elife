package com.elife.web.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Classone;
import com.elife.model.beans.Classthree;
import com.elife.model.service.ClassService;

/**
 * @author 高远</n>
 * 编写日期   2016-5-8下午4:50:37</n>
 * 邮箱  wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * TODO</n>
 */
@WebServlet("/classservlet")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "ClassServlet";

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
		ClassService classService = new ClassService();
		/*
		 * type的值，1：表示获取所有一级、二级、三级分类
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			List<Classone> classOneList = classService.getAllClass();// 该返回值包括所有的三级分类信息
			req.setAttribute("classOneList", classOneList);
			req.getRequestDispatcher("web/admin/ShowClassList.jsp").forward(
					req, resp);
		} else if (type.equals("2")) {
			String secondId = req.getParameter("secondId");
			String threeName = req.getParameter("threeName");
			Classthree classthree = new Classthree();
			classthree.setName(threeName);
			classthree.setClasssecondid(Integer.parseInt(secondId));
			boolean isAdd = classService.addClassThree(classthree);
			if (isAdd) {
				resp.sendRedirect("classservlet?type=1");
			} else {
				new Throwable("添加三级分类失败!");
			}
		} else if (type.equals("3")) {
			String secondId = req.getParameter("secondId");
			String threeId = req.getParameter("threeId");
			String newThreeName = req.getParameter("newThreeName");
			// System.out.println(TAG + secondId + "-" + threeId +
			// newThreeName);
			Classthree classthree = new Classthree();
			classthree.setName(newThreeName);
			classthree.setClasssecondid(Integer.parseInt(secondId));
			classthree.setId(Integer.parseInt(threeId));
			boolean isUpdate = classService.updateThreeName(classthree);
			if(isUpdate){
				resp.sendRedirect("classservlet?type=1");
			}else{
				new Throwable("更新三级分类名失败！");
			}
		}
	}

}
