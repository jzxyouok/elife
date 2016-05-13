package com.elife.model.dao;
/**
 * @author 叶梦雅
 *E-mail:1277918272@qq.com
 * ${tags}
 */
import java.util.List;

import com.elife.model.beans.Admin;

public interface IAdminDAO {
	//查询某个管理员信息
	public abstract Admin selectAdminByid(int id);
	//根据管理员名字查询
	public abstract Admin selectAdminByuname(String username);
	//查询所有的管理员信息
	public abstract List<Admin> selectAllAdmin(int page);
	//查询根据管理员等级排序
	public abstract List<Admin> selectTopicBylevel(int id,int page);
	
	//添加管理员
	public abstract boolean addAdmin(Admin admin);
	//删除管理员
	public abstract boolean deleteAdmin(int id);
	//修改管理员信息
	public abstract boolean updateAdminByid(Admin admin,int id);
}
