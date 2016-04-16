package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



import com.elife.model.beans.Business;
import com.elife.model.beans.Classone;
import com.elife.model.beans.Classsecond;
import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.beans.Goodsimg;
import com.elife.model.beans.Pager;
import com.elife.model.dao.IGoodsDao;
import com.elife.utils.C3p0Utils;
import com.elife.utils.PageUtils;
import com.elife.utils.ParamUtils;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午7:53:05</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class GoodsDao implements IGoodsDao {

	private static final String TAG = "GoodsDao";

	@Override
	public boolean addFirstClass(Classone classone) {

		return false;
	}

	@Override
	public boolean addSecondClass(Classsecond classsecond) {

		return false;
	}

	@Override
	public boolean addThreeClass(Classthree classthree) {

		return false;
	}

	@Override
	public List<Classone> getFirstClass() {

		return null;
	}

	@Override
	public List<Classsecond> getSecondClass() {

		return null;
	}

	@Override
	public List<Classthree> getThreeClass() {
		List<Classthree> classthrees = new ArrayList<Classthree>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Utils.getConnection();
		String sql = "select * from classthree";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Classthree classthree = new Classthree(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getString(4));
				classthrees.add(classthree);

			}
			return classthrees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			C3p0Utils.release(rs, ps, conn);
		}
	}

	@Override
	public Classone getFirstClassById(int id) {

		return null;
	}

	@Override
	public Classsecond getSecondClassById(int id) {

		return null;
	}

	@Override
	public Classthree getThreeClassById(int id) {

		return null;
	}

	@Override
	public boolean updateFirstClassById(Classone classone) {

		return false;
	}

	@Override
	public boolean updateSecondClassById(Classsecond classsecond) {

		return false;
	}

	@Override
	public boolean updateThreeClassById(Classthree classthree) {

		return false;
	}

	@Override
	public int getGoodsCount() {
		String sql = "select count(*) from goods";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		
		try {
			long totalRecordNum = (Long) queryRunner.query(sql,
					new ScalarHandler(1));
			return (int) totalRecordNum;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	

	

	@Override
	public List<Goods> getGoodsByMerchant(int businessid) {

		return null;
	}

	@Override
	public Goods getGoodsById(int id) {

		return null;
	}

	@Override
	public boolean updateGoodsById(Goods goods) {

		return false;
	}

	@Override
	public boolean toggleGoodsById(int id) {

		return false;
	}

	@Override
	public int addGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Utils.getConnection();
		String sql = "insert into goods values(null,?,?,?,?,?,null,null,?,null,?)";// 注意，倒数第二个是个多余的字段，到时候要删除
		try {
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getDescription());
			ps.setDouble(3, goods.getPrice());
			ps.setInt(4, goods.getStock());
			ps.setDouble(5, goods.getOldprice());
			ps.setInt(6, goods.getBusinessid());
			ps.setString(7, goods.getRemark());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()){
				int index=rs.getInt(1);
				System.out.println(TAG + ":" + index);
				return index;
			}

			else
				return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3p0Utils.release(rs, ps, conn);
		}
		return -1;

	}

	@Override
	public boolean addGoodsClass(Goodsclass goodsclass) {
		String sql = "insert into goodsclass values(null,?,?,?)";
		Object[] param = { goodsclass.getGoodsid(),
				goodsclass.getClassthreeid(), goodsclass.getRemark() };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addGoodsImg(Goodsimg goodsimg) {
		String sql = "insert into goodsimg values(null,?,?,?)";
		Object[] param = { goodsimg.getImgaddress(), goodsimg.getGoodsid(),
				goodsimg.getRemark() };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Goods> getGoodsByStock(int page, boolean bl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getGoodsList(int page) {
		
		String sql = "select * from goods limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Goods> goodsList = queryRunner.query(sql,
					new BeanListHandler<Goods>(Goods.class),PageUtils.getParam1(page),ParamUtils.PERPAGE);
			//返回之前，我们获取商家名字
			for (Goods goods : goodsList) {
				String name=getBusinessNameById(goods.getBusinessid());
				goods.setUsername(name);
			}
			return goodsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Goods> getGoodsBySale(int page, boolean bl) {
		
		
		
		return null;
	}

	@Override
	public Pager<Goods> getGoodsPager(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBusinessNameById(int id) {
		String sql = "select * from business where id = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Business business = queryRunner.query(sql,
					new BeanHandler<Business>(Business.class), id);
			return business.getUsername();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1+"";
		}

		
	}

}
