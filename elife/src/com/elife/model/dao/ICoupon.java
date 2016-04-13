/**
 * 
 */
package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Coupon;

/**
 * @ClassName: ICoupon
 * @author 张凯 E-mail: cloudpluie.github.io
 * @date: 2016-4-12 上午11:39:03 
 * @Description: TODO
 */
public interface ICoupon {
	//增加代金券
	public abstract boolean addCoupon(String no,double value,int status,String endtime);//优惠券的状态设置为默认
	//查询代金券（过期的代金券）
	public abstract List<Coupon> selectCoupon();
	public abstract List<Coupon> selectCouponOverdue();
	//删除代金券
	public abstract boolean deleteCoupon(int id);
	public abstract boolean deleteCoupons(int[] id); //批量删除
}
