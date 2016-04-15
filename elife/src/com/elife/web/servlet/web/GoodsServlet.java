package com.elife.web.servlet.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.beans.Goodsimg;
import com.elife.model.service.GoodsService;
import com.elife.utils.ParamUtils;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午6:44:32</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
@WebServlet("/goodsservlet")
public class GoodsServlet extends HttpServlet {

	private static final String TAG = "GoodsServlet";
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {

		this.config = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		/*
		 * 如果type=1,表示获取三级分类信息；2代表添加商品。测试数据，商家默认是零食，id:1
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			List<Classthree> classthrees = goodsService.getAllThreeClass();
			if (classthrees != null) {
				req.setAttribute("classthrees", classthrees);
				req.getRequestDispatcher("web/admin/AddGoods.jsp").forward(req,
						resp);
			} else {
				System.out.println(TAG + "：获取三级分类失败。");
			}
		} else if (type.equals("2")) {
			List<Goodsimg> goodsimgs = new ArrayList<Goodsimg>();
			/*
			 * 逻辑：第一步：获取商品基本信息、商家id、商品分类id数组. 第二步：存储商品信息(不包括商品图片信息)，返回商品id.第三步：
			 * 、遍历存储商品id和对应分类id到三级分类中间表。第四步：根据商品id存储商品图片信息到商品图片表
			 */
			Goods goods = new Goods();
			try {
				// 第一步，获取数据
				// BeanUtils.populate(goods, req.getParameterMap());//不能使用
				// 获取分类组数据
				@SuppressWarnings("unused")
				// String[] threeclassid =
				// req.getParameterValues("threeclassid");//
				// 这个数据不能保存到商品表中。应该通过商品id，把商品id和三级分类id保存到对应的三级中间表中。

				// 第二步，保存商品信息
				SmartUpload smartUpload = new SmartUpload();
				smartUpload.initialize(config, req, resp);
				try {
					smartUpload.upload();// 此步操作之后才可以获取表单参数
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * 这一块处理获取普通表单
				 */
				Map<String, String> parameterMap = new HashMap<String, String>();
				String parameter = smartUpload.getRequest()
						.getParameter("name");
				System.out.println(TAG + "打印name:" + parameter);
				@SuppressWarnings("rawtypes")
				Enumeration em = smartUpload.getRequest()
						.getParameterNames();
				while (em.hasMoreElements()) {
					String key = (String) em.nextElement();
					String value = smartUpload.getRequest().getParameter(key);
					parameterMap.put(key, value);
				}

				BeanUtils.populate(goods, parameterMap);// 我们在这里获取自己封装的数据
				String[] threeclassid = smartUpload.getRequest()
						.getParameterValues("threeclassid");// 获取分类列表

				System.out.println(TAG + "测试打印goods:" + goods);
				System.out.println(TAG + ":测试打印分类列表："
						+ Arrays.toString(threeclassid));

				// 文件夹不存在，创建
				String dir = ParamUtils.SAVEPATP + ParamUtils.SAVEPATP_GOODS;
				File file = new File(dir);
				if (!file.exists()) {
					file.mkdirs();
				}
				for (int i = 0; i < smartUpload.getFiles().getCount(); i++) {
					// 用户上传少于四张时处理
					if (smartUpload.getFiles().getFile(i).getSize() == 0)
						continue;
					Goodsimg goodsimg = new Goodsimg();// 存放商品图片路径
					com.jspsmart.upload.File myFile = smartUpload.getFiles()
							.getFile(i);
					String fileName = myFile.getFileName();
					long currentTimeMillis = System.currentTimeMillis();
					String saveName = currentTimeMillis
							+ fileName.substring(fileName.lastIndexOf("."));
					String saveFullPath = dir + saveName;
					goodsimg.setImgaddress(saveFullPath);
					goodsimgs.add(goodsimg);// 保存路径
					try {
						smartUpload.getFiles().getFile(i).saveAs(saveFullPath);
					} catch (SmartUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(TAG + "文件已上传");

				// 准备上传商品信息到数据库
				int returnId = goodsService.addGoods(goods);
				System.out.println(TAG + "商品id" + returnId);
				if (returnId != -1) {
					goods.setId(returnId);// 获取返回的商品id
				} else {
					System.out.println(TAG + "上传商品失败");
				}

				// 第三步，根据获取到商品id，保存三级分类中间表
				for (int i = 0; i < threeclassid.length; i++) {
					Goodsclass goodsclass = new Goodsclass();
					goodsclass.setClassthreeid(Integer
							.parseInt(threeclassid[i]));
					goodsclass.setGoodsid(goods.getId());
					boolean isAdd = goodsService.addGoodsClass(goodsclass);
					if (isAdd) {
						System.out.println(TAG + ":" + "添加三级分类中间表成功");
					} else {
						System.out.println(TAG + ":" + "添加三级分类中间表失败");
					}
					goodsclass = null;// 释放资源
				}

				// 第四步，保存商品图片到商品图片表
				for (Goodsimg gs : goodsimgs) {
					gs.setGoodsid(returnId);// 保存商品id
					boolean isAdd = goodsService.addGoodsImg(gs);
					if (isAdd) {
						System.out.println(TAG + "添加商品图片表成功！");
					} else {
						System.out.println(TAG + "添加商品图片表失败");
					}
				}
				//goodsimgs = null;// 释放内存

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(TAG + ":测试打印数据：" + goods);
			PrintWriter printWriter=resp.getWriter();
			printWriter
					.print("<img alt='我是图片标题' src='D:/elife/web/admin/upload/goods/1460697901796.jpg'>");
		}
		
	}

}
