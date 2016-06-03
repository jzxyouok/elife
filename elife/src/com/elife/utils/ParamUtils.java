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
	public static final String TOKEN = "elife";
	/*
	 * 规定全局分页，每页显示条数
	 */
	public static final int PERPAGE = 5;
	/*
	 * 定义一个存储的全局位置，注意，这是一个根节点，全部img在此文件夹下.前面加“/”相对于tomcat所在的盘符的根目录，不加“/”，
	 * 相对于myeclipse安装目录为根目录
	 */
	public static final String SAVEPATP = "/save";
	/*
	 * 商品的存储位置
	 */
	public static final String SAVEPATP_GOODS = "/img/goods/";
	/*
	 * 轮播图的存储位置
	 */
	public static final String SAVEPATP_BANNERS = "/img/banners";

}
