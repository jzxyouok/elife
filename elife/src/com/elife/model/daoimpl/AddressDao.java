package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elife.model.beans.Address;
import com.elife.model.dao.IAddressDAO;
import com.elife.utils.C3p0Utils;

/**
 * @author 任创权
 * 编写时间  2016-6-6 上午10:43:01
 * TODO ---
 *
 */
public class AddressDao implements IAddressDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.elife.model.dao.IAddressDAO#insertAddress(com.elife.model.beans.Address
	 * )
	 */
	@Override
	public boolean insertAddress(Address address) {
		conn = C3p0Utils.getConnection();
		String sql = "insert into address(name,phone,addressexact,status,userid) values(?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, address.getName());
			stmt.setString(2, address.getPhone());
			stmt.setString(3, address.getAddressexact());
			stmt.setString(4, address.isStatus());
			stmt.setInt(5, address.getUserid());
			stmt.executeUpdate();
			// System.out.println("插入成功！");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			C3p0Utils.release(null, stmt, conn);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IAddressDAO#deleteAddress(int)
	 */
	@Override
	public List<Address> deleteAddress(int id) {
		//
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IAddressDAO#modifyAddress(int,
	 * com.elife.model.beans.Address)
	 */
	@Override
	public List<Address> modifyAddress(int id, Address address) {
		//
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.IAddressDAO#selectAllAddress(int)
	 */
	@Override
	public List<Address> selectAllAddress(int id) {
		//  
		List<Address> list = new ArrayList<Address>();
		conn = C3p0Utils.getConnection();
		String sql = "select * from address where userid = '"+id+"'";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String phone = rs.getString(4);
				String addressgeneral = rs.getString(5);
				String addressexact = rs.getString(6);
				String status = rs.getString(7);
				int userid = rs.getInt(8);
				Address address = new Address(ID, name, phone, addressexact,
						status);
				list.add(address);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			C3p0Utils.release(rs, stmt, conn);
		}
	}

}
