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
 * @Description: 对代金券表的操作
 */
public interface ICouponDao {
	//增加代金券
	public abstract boolean addCoupon(Coupon coupon);//优惠券的状态设置为默认
	//查询代金券（过期的代金券）
	public abstract List<Coupon> selectCoupon(int page);//查询所有代金券
	public abstract List<Coupon> selectCouponOverdue(int page);//根据代金券到期时间与当前时间比较
	//修改代金券
	public abstract boolean modifyCoupon(Coupon coupon);
	//删除代金券
	public abstract boolean deleteCoupon(int id);
	public abstract boolean deleteCoupons(int[] id); //批量删除
}
