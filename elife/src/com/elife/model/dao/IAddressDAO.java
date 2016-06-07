package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Address;

/**
 * @author 任创权
 * 编写时间  2016-6-6 上午10:34:04
 * TODO ---
 *
 */
public interface IAddressDAO {
	/**
	 * 传入Address对象 TODO ---
	 */
	public abstract boolean insertAddress(Address address);

	/**
	 * 传入地址id TODO ---
	 */
	public abstract List<Address> deleteAddress(int id);

	/**
	 * 传入地址id和Address对象 TODO ---
	 */
	public abstract List<Address> modifyAddress(int id, Address address);

	/**
	 * 传入用户id TODO ---
	 */
	public abstract List<Address> selectAllAddress(int id);

}
