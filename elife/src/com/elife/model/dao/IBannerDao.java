/**
 * 
 */
package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Banner;

/**
 * @ClassName: IBanner
 * @author 张凯   E-mail: cloudpluie.github.io
 * @date: 2016-4-12 下午8:17:29 
 * @Description: 对轮播图表的操作
 */
public interface IBannerDao {
	//添加轮播图
	public abstract boolean addBanner(Banner banner);
	//查看轮播图
	public abstract List<Banner> selectAllBanner(int page);
	/**
	 * 根据一级分类查询轮播图
	 * @param banner
	 * @return
	 */
	public abstract List<Banner> selectBannerByClassFirst(String classfirst);
	/**
	 * 根据二级分类查询
	 * @param banner
	 * @return
	 */
	public abstract List<Banner> selectBannerByClassSecond(String classsecond);
	//修改轮播图
	public abstract boolean modifyBanner(Banner banner);
	//删除轮播图
	public abstract boolean deleteBanner(int id);
}
