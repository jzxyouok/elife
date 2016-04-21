package com.elife.web.servlet.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Banner;
import com.elife.model.daoimpl.BannerDaoImpl;
/**
 * @ClassName: BannerServlet
 * @author 张凯   E-mail: cloudpluie.github.io
 * @date: 2016-4-14 下午8:17:29 
 * @Description: 对轮播图表的转发处理
 */
@WebServlet("/bannerServlet")
@MultipartConfig
public class BannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		Banner banner=new Banner();
		String classfirst=request.getParameter("classfirst");
		String classsecond=request.getParameter("classsecond");
		String url=request.getParameter("url");
		banner.setClassfirst(classfirst);
		banner.setClasssecond(classsecond);
		banner.setImgaddress("uploadimage");
		banner.setUrl(url);
		BannerDaoImpl bannerImpl=new BannerDaoImpl();
		bannerImpl.addBanner(banner);
		List<Banner> list=bannerImpl.selectAllBanner(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getClassfirst());
			System.out.println(list.get(i).getClasssecond());
			System.out.println(list.get(i).getImgaddress());
			System.out.println(list.get(i).getUrl());
			System.out.println();
		}
	}
}
