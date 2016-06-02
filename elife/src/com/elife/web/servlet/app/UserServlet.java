package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.elife.model.beans.Users;
import com.elife.model.service.UserService;
import com.google.gson.Gson;

/**
 * 登录逻辑： 1、验证码登录（验证靠第三方）：我会首先判断用户是否存在。当不存在，创建新用户，返回“0”；当存在用户，直接返回用户信息，请保存到本地。
 * 2、密码登录：登录成功，直接返回用户信息。
 * 3、完善个人资料（两次请求）：第一步：首先请求服务器，返回完整用户信息。第二步：用户对这些信息进行修改并返回给服务器完整的对象
 * ，服务器直接进行更新。客户端请确保返回给服务端信息的完整性
 * 。第三步：服务器直接返回修改后的信息。（头像上传（包括其它资料上传）用七牛云，直接返回头像路径即可）
 * 
 * 
 * <!--用户相关-->
 * 
 * <!--验证码登录(确保验证成功之后请求服务器)，参数：phone(String);返回值：“0”表示新用户、json(Users)表示老用户信息-->
 * <string name="users_verify_url">/users?type=1</string>
 * <!--密码登录，参数：phone(String
 * )、password(String);返回值:json(Users)表示用户信息-、“error”表示验证失败-> <string
 * name="users_psw_url">/users?type=2</string>
 * 
 * <!--以下两步操作是修改和完善个人信息（参考登录逻辑3）-->
 * <!--请求服务器获取数据，参数：用户电话phone(String);返回值：json(Users)表示用户信息--> <string
 * name="users_obtain_url">/users?type=3</string>
 * <!--通知服务器更新数据，参数：完善的用户信息Users;返回值：完善的用户信息Users(不要偷懒直接使用本地数据显示更新后的结果)-->
 * <string name="users_update_url">/users?type=4</string>
 * 
 * 
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {

	private static final String TAG = "UserServlet";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		/*
		 * type:1:验证码登录;2:密码登录；3 完善个人资料
		 */
		String type = req.getParameter("type");
		if (type.equals("1")) {
			Users user = null;
			String phone = req.getParameter("phone");
			if (phone == null || phone == "") {
				printWriter.print("-1");
				return;
			}
			UserService userService = new UserService();
			boolean isExist = userService.check(phone);
			if (isExist) {
				user = userService.getUserInfo(phone);
			} else {
				boolean isAdd = userService.add(phone);
				if (isAdd) {
					printWriter.print("0");
					System.out.println(TAG + "add new user");
				} else {
					printWriter.print("-1");
				}
				printWriter.close();
				return;
			}

			// 开始解析
			Gson gson = new Gson();
			String json = gson.toJson(user);
			System.out.println(TAG + "1" + user);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("2")) {
			Users user = null;
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			if (phone == null || phone == "" || password == null
					|| password == "") {
				printWriter.print("-1");
				return;
			}
			UserService userService = new UserService();
			user = userService.checkUser(phone, password);
			if (user == null) {
				printWriter.print("error");
				System.out.println(TAG + "2" + "user no exist");
				printWriter.close();
				return;
			}
			// 开始解析
			Gson gson = new Gson();
			String json = gson.toJson(user);
			System.out.println(TAG + "2" + json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("3")) {
			Users user = null;
			String phone = req.getParameter("phone");
			if (phone == null || phone == "") {
				printWriter.print("-1");
				return;
			}
			UserService userService = new UserService();
			boolean isExist = userService.check(phone);
			if (isExist) {
				user = userService.getUserInfo(phone);
			} else {
				printWriter.print("-1");
				printWriter.close();
				return;
			}

			// 开始解析
			Gson gson = new Gson();
			String json = gson.toJson(user);
			System.out.println(TAG + "3" + json);
			printWriter.print(json);
			printWriter.close();
		} else if (type.equals("4")) {
			Users user = new Users();
			try {
				BeanUtils.populate(user, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
				printWriter.print("-1");
			}
			UserService userService = new UserService();
			boolean isExist = userService.update(user);
			if (isExist) {
				user = userService.getUserInfo(user.getPhone());
			} else {
				printWriter.print("-1");
				printWriter.close();
				return;
			}

			// 开始解析
			Gson gson = new Gson();
			String json = gson.toJson(user);
			System.out.println(TAG + "4" + json);
			printWriter.print(json);
			printWriter.close();
		} else {
			printWriter.print("-1");// 异常
			return;
		}

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
