package com.elife.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.elife.model.beans.Classone;
import com.elife.model.beans.Classsecond;
import com.elife.model.beans.Classthree;
import com.elife.model.beans.Goods;
import com.elife.model.beans.Goodsclass;
import com.elife.model.dao.IGoodsDao;
import com.elife.utils.C3p0Utils;

/**
 * @author 高远</n>
 * 编写时期  2016-4-13 下午7:53:05</n>
 * TODO</n>
 * 邮箱：wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class GoodsDao implements IGoodsDao {

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

		return 0;
	}

	@Override
	public List<Goods> getGoodsByStock(int page) {

		return null;
	}

	@Override
	public List<Goods> getGoodsBySale(int page, boolean bl) {

		return null;
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
	public boolean addGoods(Goods goods) {

		return false;
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

}
