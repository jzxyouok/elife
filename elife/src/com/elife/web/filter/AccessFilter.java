package com.elife.web.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 高远</n> 编写时期 2016-4-11 上午10:06:38</n> TODO:关于不同用户访问页面权限的控制</n>
 * 
 */
public class AccessFilter implements Filter {
	// private static final String TAG = "AccessFilter";
	private static final String PATH = "/config/access";
	// 管理员
	private List<String> adminPathList = new ArrayList<String>();
	// 商家
	private List<String> merchantPathList = new ArrayList<String>();
	// 用户
	private List<String> customerPathList = new ArrayList<String>();

	// 游客
	private List<String> guestPathList = new ArrayList<String>();

	public void init(FilterConfig filterConfig) throws ServletException {

		// 设置管理员
		try {
			BufferedReader admin = new BufferedReader(new FileReader(
					AccessFilter.class.getResource(
							AccessFilter.PATH + "/admin.txt")
							.getFile()));
			String line1;
			while ((line1 = admin.readLine()) != null) {
				adminPathList.add(line1);
			}
			admin.close();

			// 设置商家
			BufferedReader merchant = new BufferedReader(new FileReader(
					AccessFilter.class.getResource(
							AccessFilter.PATH + "/merchant.txt").getFile()));
			String line2;
			while ((line2 = merchant.readLine()) != null) {
				merchantPathList.add(line2);
			}
			merchant.close();

			// 设置顾客
			BufferedReader customer = new BufferedReader(new FileReader(
					AccessFilter.class.getResource(
							AccessFilter.PATH + "/customer.txt").getFile()));
			String line3;
			while ((line3 = customer.readLine()) != null) {
				customerPathList.add(line3);
			}
			customer.close();

			// 设置游客
			BufferedReader guest = new BufferedReader(new FileReader(
					AccessFilter.class.getResource(
							AccessFilter.PATH + "/guest.txt").getFile()));
			String line4;
			while ((line4 = guest.readLine()) != null) {
				guestPathList.add(line4);
			}
			guest.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//
		// HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// // 获取访问的根路径
		// String visitPath = httpServletRequest.getRequestURI().substring(
		// httpServletRequest.getContextPath().length());
		// // 判断根路径是否在以下几个用户能访问的列表。如果在，允许该用户访问，如果不在，不允许访问
		// if (adminPathList.contains(visitPath)
		// || customerPathList.contains(visitPath)
		// || merchantPathList.contains(visitPath)
		// | guestPathList.contains(visitPath)) {
		// // 获取用户身份
		// String userRole = (String) httpServletRequest.getSession()
		// .getAttribute(ParamUtils.LOGIN);
		// // 如果没有设置，默认是游客
		// if (userRole != null) {
		// if (userRole.equals(ParamUtils.ADMIN)) {
		// // 管理员
		// if (adminPathList.contains(visitPath)) {
		// // 放行
		// chain.doFilter(httpServletRequest, response);
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		// } else if (userRole.equals(ParamUtils.MERCHANT)) {
		// // 商家
		// if (merchantPathList.contains(visitPath)) {
		// chain.doFilter(httpServletRequest, response);
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		// } else if (userRole.equals(ParamUtils.CUSTOMER)) {
		// // 用户
		// if (customerPathList.contains(visitPath)) {
		// chain.doFilter(httpServletRequest, response);
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		// } else if (userRole.equals(ParamUtils.GUEST)) {//
		// if (guestPathList.contains(visitPath)) {
		// // 游客
		// chain.doFilter(httpServletRequest, response);
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		//
		// } else {
		// // 游客
		// if (guestPathList.contains(visitPath)) {
		// // 放行
		// chain.doFilter(httpServletRequest, response);
		// } else {
		// throw new RuntimeException("对不起，没有访问权限：" + userRole);
		// }
		// }
		// } else {
		// // 用户不在允许的范围
		// throw new RuntimeException("对不起，该页面不允许访问");
		// }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
