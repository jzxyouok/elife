package com.elife.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


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
