package com.elife.utils;


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
