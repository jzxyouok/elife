package com.elife.utils;

/**
 * @author 高远</n> 编写时期 2016-4-11 下午12:53:46</n> TODO 一些全局参数全部放到这个类里面</n>
 *         邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class ParamUtils {
	/*
	 * 用户登录成功之后（游客不设置）必须有这样设置：session.setAttrbute(ParamUtils.LOGIN,ParamUtils
	 * .ADMIN \ParamUtils.MERCHANT...);
	 */
	public static final String LOGIN = "login";

	public static final String ADMIN = "admin";
	public static final String MERCHANT = "merchant";
	public static final String CUSTOMER = "customer";
	public static final String GUEST = "guest";

	/*
	 * 临时token，后期再改
	 */
	private static final String TOKEN = "elife";


}
