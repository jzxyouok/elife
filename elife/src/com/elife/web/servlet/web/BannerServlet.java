package com.elife.web.servlet.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elife.model.beans.Banner;
import com.elife.model.daoimpl.BannerDaoImpl;
import com.elife.utils.ParamUtils;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @ClassName: BannerServlet
 * @author 张凯 E-mail: cloudpluie.github.io
 * @date: 2016-4-14 下午8:17:29
 * @Description: 对轮播图表的转发处理
 */
@WebServlet("/bannerServlet")
public class BannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name.equals("add")) {
			// 添加轮播图
			Banner banner = new Banner();
			// 创建smartupload组件
			SmartUpload su = new SmartUpload();
			su.initialize(getServletConfig(), request, response);
			String dir = ParamUtils.SAVEPATP + ParamUtils.SAVEPATP_BANNERS;
			File file = new File(dir);
			if (!file.exists()) {
				file.mkdirs();// 文件夹不存在，创建
			}
			// 上传文件
			try {
				su.upload();
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				if (e.getMessage().indexOf("1015") != -1) {
					System.out.println("上传失败：上传文件类型不正确！");
				} else if (e.getMessage().indexOf("1010") != -1) {
					System.out.println("上传失败：上传文件类型不正确！");
				} else if (e.getMessage().indexOf("1105") != -1) {
					System.out.println("上传失败：上传文件大小大于允许上传的最大值！");
				} else if (e.getMessage().indexOf("1110") != -1) {
					System.out.println("上传失败：上传文件总大小大于允许上传总大小的最大值！");
				}
			}
			try {
				su.save(dir);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String classfirst = su.getRequest().getParameter("classfirst");
			String classsecond = su.getRequest().getParameter("classsecond");
			String url = su.getRequest().getParameter("url");
			banner.setClassfirst(classfirst);
			banner.setClasssecond(classsecond);
			banner.setUrl(url);
			banner.setImgaddress(dir);
			BannerDaoImpl bannerImpl = new BannerDaoImpl();
			bannerImpl.addBanner(banner);
			request.getRequestDispatcher("web/admin/AddBanner.jsp").forward(
					request, response);

		} else if (name.equals("modify")) {
			// 修改轮播图
			String bannerid = request.getParameter("id");// 获取要修改轮播图的id
			int id = Integer.parseInt(bannerid);
			Banner banner = new Banner();
			String classfirst = request.getParameter("classfirst");
			String classsecond = request.getParameter("classsecond");
			String url = request.getParameter("url");
			banner.setClassfirst(classfirst);
			banner.setClasssecond(classsecond);
			banner.setImgaddress("uploadimage");
			banner.setUrl(url);
			BannerDaoImpl bannerImpl = new BannerDaoImpl();
			bannerImpl.modifyBanner(banner, id);
		} else if (name.equals("delete")) {
			// 删除轮播图
			String bannerid = request.getParameter("id");// 获取要删除轮播图的id
			int id = Integer.parseInt(bannerid);
			BannerDaoImpl bannerImpl = new BannerDaoImpl();
			bannerImpl.deleteBanner(id);
		}

	}
}
