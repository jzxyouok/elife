/**
 * 
 */
package com.elife.web.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.service.BannerService;
import com.elife.utils.PageBean;

/**
 * @ClassName: QueryBannerServlet
 * @author: 张凯 Email: cloudpluie.github.io
 * @date: 2016-4-16
 * @Description: TODO
 */
@WebServlet("/queryBanner")
public class QueryBannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获得客户端提交页码
		String pNumStr = req.getParameter("pNum");
		System.out.println(pNumStr);
		int pNum = 0;
		if (pNumStr == null) {
			pNum = 1;
		} else {
			pNum = Integer.parseInt(pNumStr);
		}
		BannerService bannerService = new BannerService();
		// 查出所有轮播图
		PageBean pageBean = bannerService.selectBanner(pNum);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("web/admin/Banner.jsp").forward(req, resp);

		// String choose = req.getParameter("choose");// 页面中的操作选项
		// // 用户不进行任何选择
		// if (choose.equals(null)) {
		//
		// } else if (choose.equals("classfirst")) {// 按照一级分类查找
		//
		// } else if (choose.equals("classsecond")) {// 按照二级分类查找
		//
		// }
		// super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
