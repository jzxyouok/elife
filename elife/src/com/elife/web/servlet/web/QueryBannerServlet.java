/**
 * 
 */
package com.elife.web.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: QueryBannerServlet 
 * @author: 张凯     Email: cloudpluie.github.io
 * @date: 2016-4-16
 * @Description: TODO
 */
public class QueryBannerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String choose = req.getParameter("choose");//页面中的操作选项
		//用户不进行任何选择
		if(choose.equals(null)){
			
		}else if(choose.equals("classfirst")){//按照一级分类查找
			
		}else if(choose.equals("classsecond")){//按照二级分类查找
		
		}
		super.doPost(req, resp);
	}

}
