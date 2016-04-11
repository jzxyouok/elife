package com.elife.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 高远 2015-6-3 下午6:24:36
 * 
 */
public class DateUtils {

	/*
	 * 获取日期
	 */
	public static String getNowDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		return str;
	}

	/*
	 * 获取日期和时间
	 */
	public static String getFullNowDateTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		return str;
	}


}
