/**
 * 
 */
package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.elife.model.beans.Banner;
import com.elife.model.dao.IBannerDao;
import com.elife.utils.C3p0Utils;

/**
 * @ClassName: BannerDaoImpl 
 * @author: 张凯     Email: cloudpluie.github.io
 * @date: 2016-4-16
 * @Description: TODO
 */
public class BannerDaoImpl implements IBannerDao{

	Connection conn=null;
	PreparedStatement stmt=null;
	//添加轮播图
	@Override
	public boolean addBanner(Banner banner) {
		conn=C3p0Utils.getConnection();
		String sql="insert into banner(classfirst,classsecond,imgaddress,url) values(?,?,?,?);";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, banner.getClassfirst());
			stmt.setString(1, banner.getClasssecond());
			stmt.setString(1, banner.getImgaddress());
			stmt.setString(1, banner.getUrl());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			C3p0Utils.release(null, stmt, conn);
		}
	}

	//查询全部的轮播图
	@Override
	public List<Banner> selectAllBanner(int page) {
		// TODO Auto-generated method stub
		return null;
	}	
			
	//根据一级分类，查询轮播图
	@Override
	public List<Banner> selectBannerByClassFirst(String classfirst) {
		// TODO Auto-generated method stub
		return null;
	}

	//根据二级分类，查询轮播图
	@Override
	public List<Banner> selectBannerByClassSecond(String classsecond) {
		// TODO Auto-generated method stub
		return null;
	}

	//修改轮播图
	
	@Override
	public boolean modifyBanner(Banner banner) {
		// TODO Auto-generated method stub
		return false;
	}
	//删除轮播图
	@Override
	public boolean deleteBanner(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
