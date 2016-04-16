package com.elife.utils;



/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午12:46:38</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */

public class PageUtils {
	/**
	 * @param pager
	 *            当前页 。返回limit m,n 的第一个参数
	 */
	public static int getParam1(int pager) {
		int param1 = (pager - 1) * ParamUtils.PERPAGE;
		return param1;
	}

	/**
	 * @param totalRecordNum
	 *            信息总条数 。返回 总页数
	 */
	public static int getPagersByNums(int totalRecordNum) {
		int totalPageNum = (totalRecordNum + ParamUtils.PERPAGE - 1)
				/ ParamUtils.PERPAGE;
		return totalPageNum;
	}

}

