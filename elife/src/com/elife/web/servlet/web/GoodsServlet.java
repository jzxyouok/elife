package com.elife.web.servlet.web;

import java.io.File;
import java.io.IOException;
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
		 * 如果type=1,表示获取三级分类信息；2代表添加商品。测试数据，商家默认是零食
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
			/*
			 * 上传商品所有逻辑： 第一步：点击添加商品按钮，携带过来商家ID、商家产的商品所属的全部三级分类信息。
			 * 第二步：提交之后，初始化第三方文件上传框架
			 * ，为获取普通表单数据做准备。注意,获取普通表单数据不能使用传统方式，在smartUpload
			 * .upload()之后，用该框架提供的方法获取表单数据。第三步：上传文件。
			 * 第四步：获取商品表单基本信息之后插入商品表，返回插入商品的id 第五步：遍历存储分类ID和返回的商品ID到三级分类中间表。
			 * 第六步：遍历获取到的商品图片路径和商品ID存储到商品图片表。
			 */

			List<Goodsimg> goodsimgs = new ArrayList<Goodsimg>();// 商品图片列表
			Goods goods = new Goods();// 商品

			try {
				// 第二步，初始化SmartUpload
				SmartUpload smartUpload = new SmartUpload();
				smartUpload.initialize(config, req, resp);
				try {
					smartUpload.upload();// 此步操作之后才可以获取普通表单参数
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}

				Map<String, String> parameterMap = new HashMap<String, String>();
				@SuppressWarnings("rawtypes")
				Enumeration em = smartUpload.getRequest()
						.getParameterNames();
				/*
				 * 这一块处理获取普通表单， 存储到Map中然后用beanutils进行封装
				 */
				while (em.hasMoreElements()) {
					String key = (String) em.nextElement();
					String value = smartUpload.getRequest().getParameter(key);
					parameterMap.put(key, value);
				}

				BeanUtils.populate(goods, parameterMap);// 我们在这里获取自己封装的数据
				String[] threeclassid = smartUpload.getRequest()
						.getParameterValues("threeclassid");// 获取分类列表ID

				System.out.println(TAG + "测试打印goods:" + goods);
				System.out.println(TAG + ":测试打印分类列表："
						+ Arrays.toString(threeclassid));

				// 第三步：上传文件
				String dir = ParamUtils.SAVEPATP + ParamUtils.SAVEPATP_GOODS;
				File file = new File(dir);
				if (!file.exists()) {
					file.mkdirs();// 文件夹不存在，创建
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

				// 第四步：添加商品到商品表，返回ID
				int returnId = goodsService.addGoods(goods);
				System.out.println(TAG + "商品id" + returnId);
				if (returnId != -1) {
					goods.setId(returnId);// 获取返回的商品id
				} else {
					System.out.println(TAG + "上传商品失败");
				}

				// 第五步：根据获取到商品id，保存三级分类中间表
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

				// 第六步，保存商品图片到商品图片表
				for (Goodsimg gs : goodsimgs) {
					gs.setGoodsid(returnId);// 保存商品id
					boolean isAdd = goodsService.addGoodsImg(gs);
					if (isAdd) {
						System.out.println(TAG + "添加商品图片表成功！");
					} else {
						System.out.println(TAG + "添加商品图片表失败");
					}
				}
				goodsimgs = null;// 释放内存
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(TAG + ":测试打印数据：" + goods);

		}
		
	}

}
