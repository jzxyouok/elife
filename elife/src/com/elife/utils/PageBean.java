/**
 * 
 */
package com.elife.utils;

import java.util.List;

import com.elife.model.beans.Banner;

/**
 * @ClassName: PageBean
 * @author: 张凯 Email: cloudpluie.github.io
 * @date: 2016-4-23
 * @Description: TODO
 */
public class PageBean {
	public static final int NUMPERPAGE = 10;// 每页多少条
	private int pNum;// 当前第几页
	private int totalPageNum;// 总页数
	private int totalRecordNum;// 总记录数
	private List<Banner> bannerList;

	/**
	 * @return the bannerList
	 */
	public List<Banner> getBannerList() {
		return bannerList;
	}

	/**
	 * @param bannerList
	 *            the bannerList to set
	 */
	public void setBannerList(List<Banner> bannerList) {
		this.bannerList = bannerList;
	}

	/**
	 * @return the pNum
	 */
	public int getpNum() {
		return pNum;
	}

	/**
	 * @param pNum
	 *            the pNum to set
	 */
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	/**
	 * @return the totalPageNum
	 */
	public int getTotalPageNum() {
		return totalPageNum;
	}

	/**
	 * @param totalPageNum
	 *            the totalPageNum to set
	 */
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	/**
	 * @return the totalRecordNum
	 */
	public int getTotalRecordNum() {
		return totalRecordNum;
	}

	/**
	 * @param totalRecordNum
	 *            the totalRecordNum to set
	 */
	public void setTotalRecordNum(int totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}
}
