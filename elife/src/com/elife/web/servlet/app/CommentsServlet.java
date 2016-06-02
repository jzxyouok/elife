package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.elife.model.beans.Commentreply;
import com.elife.model.beans.Goodscomment;
import com.elife.model.beans.Pager;
import com.elife.model.service.CommentsService;
import com.google.gson.Gson;

/**
 * @author 任创权
 * 编写时间  2016-6-1 下午6:22:30
 * TODO ---
 *
 */
/**
 * <!--评论相关-->
 * <!--获取评论默认列表。参数：评论分类info(int)（默认(0)、好(1)、中(2)、差(3)，默认0）、页码page(int
 * )、商品id(int)--> <string name="comments_list_url">/comments?type=1</string>
 * <!--上传商品评论。参数：完善的goodscomment对象。特别注意必须：userid和goodsid--> <string
 * name="comments_comment_url">/comments?type=2</string>
 * <!--上传商品评论回复。参数：完善的commentreply对象
 * 。特别注意必须：回复者userid和商品评论commentid、回复者身份identity
 * 。规定：identity:0表示顾客；1表示商家；2表示管理员；3表示未知；默认0--> <string
 * name="comments_commentreply_url">/comments?type=2</string>
 * 
 * 
 * 
 */
@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		/*
		 * type:1:获取评论列表;2:上传评论；3 ：上传回复
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			int page = 1;
			int infos = 0;
			int id = -1;
			String pageStr = req.getParameter("page");
			String goodsId = req.getParameter("id");
			String info = req.getParameter("info");// 评论类型：默认 好中差
			if (goodsId == null || goodsId == "") {
				printWriter.print("-1");// 异常
				return;
			} else {
				id = Integer.parseInt(goodsId);
			}
			if (pageStr == null || pageStr == "") {

			} else {
				page = Integer.parseInt(pageStr);
			}
			if (info == null || info == "") {
				infos = 0;

			} else {
				infos = Integer.parseInt(info);
			}

			CommentsService commentsService = new CommentsService();
			Pager<Goodscomment> commentsPager = commentsService.getGoodsPager(
					id, infos, page);
			System.out.println(commentsPager.toString());
			System.out.println(commentsPager.getObjects());
			// 开始解析
			Gson gson = new Gson();
			List<Goodscomment> goodsList = commentsPager.getObjects();
			String json = gson.toJson(goodsList);
			System.out.println(json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("2")) {
			CommentsService commentsService = new CommentsService();
			Goodscomment goodscomment = new Goodscomment();
			try {
				BeanUtils.populate(goodscomment, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
				printWriter.print("-1");
				printWriter.close();
				return;
			}
			
			boolean isAdd = commentsService.add(goodscomment);
			if (isAdd) {
				printWriter.print("0");
				printWriter.close();
				return;
			} else {
				printWriter.print("-1");
				printWriter.close();
				return;
			}
			

		} else if (type.equals("3")) {
			CommentsService commentsService = new CommentsService();
			Commentreply commentreply = new Commentreply();
			try {
				BeanUtils.populate(commentreply, req.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				printWriter.print("-1");
				printWriter.close();
				return;
			}

			boolean isAdd = commentsService.addReply(commentreply);
			if (isAdd) {
				printWriter.print("0");
				printWriter.close();
			} else {
				printWriter.print("-1");
				printWriter.close();
			}

		} else if (type.equals("4")) {

		}

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
