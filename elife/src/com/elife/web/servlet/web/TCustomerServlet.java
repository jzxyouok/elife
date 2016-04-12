package com.elife.web.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 高远</n> 编写时期 2016-4-11 下午9:29:18</n> TODO 关于客户的各种操作</n>
 *         邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 * 
 */
@WebServlet("/tcustomerservlet")
public class TCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// String type = req.getParameter("type");
		// if (type.equals("1")) {
		// IUserService userService = new UserService();
		// // 添加用户
		// Users users = new Users();
		// try {
		// BeanUtils.populate(users, req.getParameterMap());
		// boolean addUser = userService.addUser(users);
		// System.out.println(addUser);
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } else if (type.equals("2")) {
		// // 修改用户信息
		// } else if (type.equals("3")) {
		// // 查询所有用户
		// }
	}

}
