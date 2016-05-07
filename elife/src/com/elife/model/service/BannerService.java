/**
 * 
 */
package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Banner;
import com.elife.model.dao.IBannerDao;
import com.elife.model.daoimpl.BannerDaoImpl;
import com.elife.utils.PageBean;

/**
 * @ClassName: BannerService
 * @author: 张凯 Email: cloudpluie.github.io
 * @date: 2016-4-16
 * @Description: TODO
 */
public class BannerService {
	List<Banner> bannerList;

	/**
	 * 添加轮播图
	 */
	public void addBanner(Banner banner) {
		IBannerDao bannerDao = new BannerDaoImpl();
		bannerDao.addBanner(banner);
	}

	/**
	 * 根据页码查询轮播图
	 */
	public PageBean selectBanner(int pNum) {
		// 根据页码和每页条数计算开始索引
		int start = (pNum - 1) * PageBean.NUMPERPAGE;
		PageBean bean = new PageBean();
		// 获取当前页码
		bean.setpNum(pNum);
		// 调用DaoImpl进行分页查询
		IBannerDao bannerDao = new BannerDaoImpl();
		bannerList = bannerDao.selectAllBanner(start, PageBean.NUMPERPAGE);
		bean.setBannerList(bannerList);
		// 总记录数
		int totalRecordNum = BannerDaoImpl.findTotalRecordNum();
		bean.setTotalRecordNum(totalRecordNum);
		// 计算总页数
		int totalPageNum = (totalRecordNum + PageBean.NUMPERPAGE - 1)
				/ PageBean.NUMPERPAGE;
		bean.setTotalPageNum(totalPageNum);
		return bean;
	}
}
