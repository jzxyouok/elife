/**
 * 
 */
package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	ResultSet rs=null;
	//添加轮播图
	@Override
	public boolean addBanner(Banner banner) {
		conn=C3p0Utils.getConnection();
		String sql="insert into banner(classfirst,classsecond,imgaddress,url) values(?,?,?,?)";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, banner.getClassfirst());
			stmt.setString(2, banner.getClasssecond());
			stmt.setString(3, banner.getImgaddress());
			stmt.setString(4, banner.getUrl());
			stmt.executeUpdate();
			System.out.println("插入成功！");
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
		List<Banner> list=new ArrayList<Banner>();
		conn=C3p0Utils.getConnection();
		String sql="select * from banner";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				int ID=rs.getInt(1);
				String classFirst=rs.getString(2);
				String classSecond=rs.getString(3);
				String imgAddress=rs.getString(4);
				String url=rs.getString(5);
				Banner banner=new Banner(ID,classFirst,classSecond,imgAddress,url);
				list.add(banner);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			C3p0Utils.release(rs, stmt, conn);
		}
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
