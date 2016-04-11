package com.elife.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 高远</n> 邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 *         编写时期 2016-4-5 下午5:47:25
 */
public class EncodingFilter implements Filter {
	// private static final String TAG = "EncodingFilter";
	private static String encode = "utf-8";// 默认编码

	/*
	 * 过滤器初始化方法，只会执行一次
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encode = filterConfig.getInitParameter("encode");


	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 浏览器告诉服务器采用的解码格式
		request.setCharacterEncoding(encode);
		// 服务器告诉浏览器接受文档的类型和解码格式
		response.setContentType("text/html;charset=" + encode);
		// 服务器本身采用的编码方式
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
