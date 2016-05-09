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
 * @author 高远</n> 编写时期 2016-4-13 下午7:53:05</n> TODO</n> 邮箱：wgyscsf@163.com</n>
 *         博客 http://blog.csdn.net/wgyscsf</n>
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
		String sql = "insert into Classthree values(null,?,?,?)";
		Object[] param = { classthree.getName(), classthree.getClasssecondid(),
				classthree.getRemark() };
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
	public List<Classone> getFirstClass() {
		String sql = "select * from Classone";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Classone> classoneList = queryRunner.query(sql,
					new BeanListHandler<Classone>(Classone.class));

			return classoneList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

		String sql = "select * from Goods where id = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			Goods goods = queryRunner.query(sql, new BeanHandler<Goods>(
					Goods.class), id);
			return goods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

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
			if (rs.next()) {
				int index = rs.getInt(1);
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
					new BeanListHandler<Goods>(Goods.class),
					PageUtils.getParam1(page), ParamUtils.PERPAGE);
			// 返回之前，我们获取商家名字
			for (Goods goods : goodsList) {
				String name = getBusinessNameById(goods.getBusinessid());
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
			return -1 + "";
		}

	}

	@Override
	public List<Goodsimg> getGoodsImgByGoodsId(int id) {
		String sql = "select * from Goodsimg where goodsid=?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Goodsimg> goodsimgList = queryRunner.query(sql,
					new BeanListHandler<Goodsimg>(Goodsimg.class), id);

			return goodsimgList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateGoods(Goods goods) {
		String sql = "update goods set name=?,description=?,price=?,stock=?,oldprice=?,businessid=?,threeclassid=?,remark=? where id = ?";
		Object[] param = { goods.getName(), goods.getDescription(),
				goods.getPrice(), goods.getStock(), goods.getOldprice(),
				goods.getBusinessid(), goods.getThreeclassid(),
				goods.getRemark(), goods.getId() };

		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateGoodsClass(Goodsclass goodsclass) {
		String sql = "update goodsclass set goodsid=?,classthreeid=?,remark=? where id = ?";
		Object[] param = { goodsclass.getGoodsid(),
				goodsclass.getClassthreeid(), goodsclass.getRemark(),
				goodsclass.getId() };

		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateGoodsImg(Goodsimg gs) {
		String sql = "insert into goodsimg values(null,?,?,?)";
		Object[] param = { gs.getImgaddress(), gs.getGoodsid(), gs.getRemark() };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteGoodsByGoodsId(int goodsid) {
		String sql = "delete from Goodsimg where goodsid = ?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

		try {
			queryRunner.update(sql, goodsid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delGood(Connection conn, int id) {
		PreparedStatement ps = null;
		String sql = "delete from goods where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delImgs(Connection conn, int id) {
		PreparedStatement ps = null;
		String sql = "delete from goodsimg where goodsid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delGoodsClass(Connection conn, int id) {
		PreparedStatement ps = null;
		String sql = "delete from goodsclass where goodsid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 这里具体排行根据rank字段:1:销量由低到高；2：销量由高到低；3：库存由低到高；4：库存由高到低；
	 * 5：现价由低到高；6：现价由高到低；7：原价由低到高；8：原价由高到低。
	 */
	// select * from goods order by name asc limit 0,1;
	@Override
	public List<Goods> getGoodsListByRank(int page, String rank) {
		String placeHolder = "";
		if (rank.equals("1")) {
			placeHolder = "sale asc";
		} else if (rank.equals("2")) {
			placeHolder = "sale desc";
		} else if (rank.equals("3")) {
			placeHolder = "stock asc";
		} else if (rank.equals("4")) {
			placeHolder = "stock desc";
		} else if (rank.equals("5")) {
			placeHolder = "price asc";
		} else if (rank.equals("6")) {
			placeHolder = "price desc";
		} else if (rank.equals("7")) {
			placeHolder = "oldprice asc";
		} else if (rank.equals("8")) {
			placeHolder = "oldprice desc";
		} else {
			placeHolder = "name asc";
		}
		/*
		 * 特别注意，placeHolder不能使用占位符，原因：怀疑占位符之间如果没有“，”，就不能连着使用占位符，可以使用传统的拼接方式
		 */
		String sql = "select * from goods order by " + placeHolder
				+ " limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Goods> goodsList = queryRunner.query(sql,
					new BeanListHandler<Goods>(Goods.class),
					PageUtils.getParam1(page), ParamUtils.PERPAGE);
			// 返回之前，我们获取商家名字
			for (Goods goods : goodsList) {
				String name = getBusinessNameById(goods.getBusinessid());
				goods.setUsername(name);
			}
			return goodsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Classsecond> getSecondClassByClassOneId(int id) {
		String sql = "select * from Classsecond where classoneid=?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Classsecond> classsecondList = queryRunner.query(sql,
					new BeanListHandler<Classsecond>(Classsecond.class), id);

			return classsecondList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Classthree> getThridClassByClassSecondId(int id) {
		String sql = "select * from Classthree where classsecondid=?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Classthree> classthreeList = queryRunner.query(sql,
					new BeanListHandler<Classthree>(Classthree.class), id);

			return classthreeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
