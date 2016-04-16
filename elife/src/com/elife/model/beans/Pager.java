package com.elife.model.beans;

import java.util.List;

import com.elife.utils.ParamUtils;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午1:32:16</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class Pager<T> {
	public int perSize = ParamUtils.PERPAGE;// 每页条数
	private int nowPager; // 当前页
	private int totalPageNum; // 总页数
	private int totalRecordNum; // 总条数
	private List<T> objects; // 获取的信息列表
	public int getPerSize() {
		return perSize;
	}

	public void setPerSize(int perSize) {
		this.perSize = perSize;
	}

	public int getNowPager() {
		return nowPager;
	}

	public void setNowPager(int nowPager) {
		this.nowPager = nowPager;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getTotalRecordNum() {
		return totalRecordNum;
	}

	public void setTotalRecordNum(int totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	@Override
	public String toString() {
		return "Pager [perSize=" + perSize + ", nowPager=" + nowPager
				+ ", totalPageNum=" + totalPageNum + ", totalRecordNum="
				+ totalRecordNum + ", objects=" + objects + "]";
	}


}
