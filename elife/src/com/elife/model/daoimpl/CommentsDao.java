package com.elife.model.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.elife.model.beans.Commentreply;
import com.elife.model.beans.Goodscomment;
import com.elife.model.beans.Pager;
import com.elife.model.dao.ICommentsDao;
import com.elife.utils.C3p0Utils;
import com.elife.utils.PageUtils;
import com.elife.utils.ParamUtils;

/**
 * @author 任创权
 * 编写时间  2016-6-2 上午10:17:11
 * TODO ---
 *
 */
public class CommentsDao implements ICommentsDao {

	/* (non-Javadoc)
	 * @see com.elife.model.dao.ICommentsDao#getCommentsPager(int, int, int)
	 */
	@Override
	public Pager<Goodscomment> getCommentsPager(int merchantId, int infos,
			int pager) {
		//  
		return null;
	}

	/* (non-Javadoc)
	 * @see com.elife.model.dao.ICommentsDao#addComments(com.elife.model.beans.Goodscomment)
	 */
	@Override
	public boolean addComments(Goodscomment goodscomment) {
		String sql = "insert into Goodscomment values(null,?,?,?,?,?,?,?,?)";
		Object[] param = { goodscomment.getContent(),
				goodscomment.getGoodsgrade(), goodscomment.getBusinessgrade(),
				goodscomment.getExpressgrade(), goodscomment.getTime(),
				goodscomment.getGoodsid(), goodscomment.getUserid(),
				goodscomment.getRemark() };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.elife.model.dao.ICommentsDao#addCommentsReply(com.elife.model.beans.Commentreply)
	 */
	@Override
	public boolean addCommentsReply(Commentreply commentreply) {
		String sql = "insert into Goodscomment values(null,?,?,?,?,?,?)";
		Object[] param = { commentreply.getContent(), commentreply.getTime(),
				commentreply.getIdentity(), commentreply.getUserid(),
				commentreply.getCommentid(), commentreply.getRemark() };
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			queryRunner.update(sql, param);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.ICommentsDao#getGoodsList(java.lang.String, int,
	 * int)
	 */
	@Override
	public List<Goodscomment> getGoodsList(int goodsid, double[] dis,
			int page) {

		String sql = "select * from Goodscomment where goodsid=? and (goodsgrade+businessgrade+expressgrade)/3> "
				+ dis[0]
				+ " (goodsgrade+businessgrade+expressgrade)<3="
				+ dis[1] + " limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Goodscomment> goodscomments = queryRunner.query(sql,
					new BeanListHandler<Goodscomment>(Goodscomment.class),
					goodsid,
					PageUtils.getParam1(page), ParamUtils.PERPAGE);

			return goodscomments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elife.model.dao.ICommentsDao#getGoodsCommentCount()
	 */
	@Override
	public int getGoodsCommentCount() {
		String sql = "select count(*) from goodscomment";
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

}
