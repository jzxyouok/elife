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
 * @Description: TODO
 */
public interface IBannerDao {
	//添加轮播图
	public abstract boolean addBanner(String classfirst,String classsecond,String name);
	//查看轮播图
	public abstract List<Banner> selectAllBanner();
	//修改轮播图
	public abstract boolean modifyBanner(String classfirst,String classsecond,String name);
	//删除轮播图
	public abstract boolean deleteBanner();
}
