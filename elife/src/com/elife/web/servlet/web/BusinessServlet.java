package com.elife.web.servlet.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import com.elife.model.beans.Business;
import com.elife.model.beans.Businessclass;
import com.elife.model.beans.Classone;
import com.elife.model.service.BusinessClassService;
import com.elife.model.service.BusinessService;
import com.elife.model.service.ClassoneService;
import com.elife.utils.DateUtils;
import com.elife.utils.MD5Utils;
import com.elife.utils.ParamUtils;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @author 任创权
 * 编写时间  2016-4-23 下午3:39:16
 * TODO ---
 *
 */
@WebServlet("/businessservlet")
public class BusinessServlet extends HttpServlet {

	private final static String TAG = "BusinessServlet：";

	BusinessService businessservice = new BusinessService();
	BusinessClassService bclassservice = new BusinessClassService();
	ClassoneService classoneService = new ClassoneService();
	private ServletConfig config;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		//
		super.init();
		this.config = config;
	}

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

		// 添加商家和商家身份表
		Business business = new Business();
		
		// 获取操作类型
		String action = req.getParameter("action");
		System.out.println("action = " + action);

		if ("add".equals(action)) {
			// 添加商家
			try {
				Businessclass businessclass = new Businessclass();

				/******** 上传图片 ***********/
				SmartUpload smartUpload = new SmartUpload();
				smartUpload.initialize(config, req, resp);

				try {
					smartUpload.upload();
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Map<String, String> parameterMap = new HashMap<String, String>();
				@SuppressWarnings("rawtypes")
				Enumeration em = smartUpload.getRequest().getParameterNames();

				while (em.hasMoreElements()) {
					String key = (String) em.nextElement();
					String value = smartUpload.getRequest().getParameter(key);
					parameterMap.put(key, value);
					System.out.println(TAG + "key:" + key + "value:" + value);
				}

				BeanUtils.populate(business, parameterMap);// 我们在这里获取自己封装的数据
				// // 在此处获取了商家手机号(phone)、地址(address)、商家称呼(storename)
				// BeanUtils.populate(business, req.getParameterMap());

				// 获取商家的身份类别(一级分类)
				String[] type = smartUpload.getRequest().getParameterValues(
						"type");
				System.out.println(TAG + "身份类型 ：" + type);

				business.setStatus(1);
				business.setNickname(business.getPhone());
				business.setLasttime(DateUtils.getNowDate());
				business.setPassword(MD5Utils.md5("123456"));// 默认的密码

				// 上传文件
				  String dir = ParamUtils.SAVEPATP + ParamUtils.SAVEPATP_GOODS;
				  File file = new File(dir);
				  if (!file.exists()) {
					  file.mkdirs();// 文件夹不存在，创建
				  } 
				  
				com.jspsmart.upload.File myFile = smartUpload.getFiles()
						.getFile(0);
				String fileName = myFile.getFileName();

				long currentTimeMillis = System.currentTimeMillis();

				  String saveName = currentTimeMillis + fileName.substring(fileName.lastIndexOf(".")); 

				  String saveFullPath = dir + saveName;

				try {
					smartUpload.getFiles().getFile(0).saveAs(saveFullPath);
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				business.setImageurl(saveFullPath);
				System.out.println(TAG + "整个对象为" + business);


				System.out.println(TAG + "商家身份类型" + type.length);
				 
				
				
				
				// 根据添加商家返回的一些信息，判断接下进行什么样的操作
				 if (addBusiness(business, type)) {
				 // 添加成功，跳转到商家展示页面
				 resp.sendRedirect("businessservlet?action=show");
				 }

			} catch (IllegalAccessException e) {
				throw new RuntimeException("添加商家出错");
			} catch (InvocationTargetException e) {
				throw new RuntimeException("添加商家出错");
			}

		} else if ("show".equals(action)) {
			// 展示商家

			List<Business> allBusiness = businessservice.getAllBusiness();
			List<Classone> allClassone = classoneService.getAllClass();

			if (allBusiness != null) {
				req.setAttribute("businesslist", allBusiness);
				req.setAttribute("allClassone", allClassone);

				req.getRequestDispatcher("web/admin/ManageBusiness.jsp")
						.forward(req, resp);
			} else {
				throw new RuntimeException("获取商家信息失败");
			}
		} else if ("lock".equals(action)) {
			// 进行锁定操作
			
			int status = Integer.parseInt(req.getParameter("status"));
			int businessid = Integer.parseInt(req.getParameter("id"));
			
			if (businessservice.lockById(Math.abs(status - 1), businessid)) {
				// 锁定用户成功，重新展示用户
				resp.sendRedirect("businessservlet?action=show");
			}
		}

	}

	/**
	 * 添加商家信息
	 * 
	 * @param businessid添加完商家之后获取的商家的id
	 * @param type商家的身份类型
	 * @param business商家对象
	 * 
	 */
	private boolean addBusiness(Business business, String[] type) {

		// 插入商家对象，返回商家的主键并作为，类别表的一个字段
		int businessid = businessservice.addBusiness(business);
		
		if (businessid == 0) {
			// 添加商家失败，终止执行，跳转到错误页面
			throw new RuntimeException("添加商家失败...");
		}

		System.out.println(TAG + "添加完成后，商家的id是" + businessid);

		List<Businessclass> BClassList = new ArrayList<Businessclass>();
		
		for (String classoneid : type) {
			Businessclass Bclass = new Businessclass(0, businessid,
					Integer.parseInt(classoneid), null);
			BClassList.add(Bclass);
			
		}
		System.out.println(TAG + "：数据集合的大小为" + BClassList.size());

		// 添加数据集合
		if (bclassservice.addBusinessClass(BClassList)) {
			System.out.println(TAG + "一级分类添加成功，去一级分类表查看");
			return true;
		} else {
			System.out.println(TAG + "添加失败");
			throw new RuntimeException("添加商家分类失败...");
		}

	}

}
