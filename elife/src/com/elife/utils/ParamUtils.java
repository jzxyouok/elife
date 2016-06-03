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
	public static final int PERPAGE = 10;
	/*
	 * 定义一个存储的全局位置，注意，这是一个根节点，全部img在此文件夹下.前面加“/”相对于tomcat所在的盘符的根目录，不加“/”，
	 * 相对于myeclipse安装目录为根目录
	 */
	public static final String SAVEPATP = "/save";
	/*
	 * 商品的存储位置
	 */
	public static final String SAVEPATP_GOODS = "/img/goods/";

	// app相关
	public static final int PERPAGE_APP = 10;
	// 对于好评差评的定义：十分制；对于商品，综合考虑商品评价、商家服务、快递服务平均分。对于商家只考虑商家服务
	public static final int BOTTOM = 0;// 最低分
	public static final int TOP = 10;// 最高分
	public static final int BAD = 3;// 小于等于4
	public static final int MIDDLE = 6;// 小于等于7
	public static final int GOOD = 10;// 小于等于10

	// 七牛相关配置
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	public static final String ACCESS_KEY = "FHr8UUiAK_HWCa8UInZumUiwwhlSCsOjqn1_Ob1m";
	public static final String SECRET_KEY = "QQNVrx9ZNdQtnSSaA-eP3s2CugxCiLGcqsVd-UqX";
	// 要上传的空间
	public static final String bucketname = "wgyscsf";



}
