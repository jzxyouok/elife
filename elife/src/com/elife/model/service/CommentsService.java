package com.elife.model.service;

import java.util.List;

import com.elife.model.beans.Commentreply;
import com.elife.model.beans.Goodscomment;
import com.elife.model.beans.Pager;
import com.elife.model.dao.ICommentsDao;
import com.elife.model.daoimpl.CommentsDao;
import com.elife.utils.PageUtils;
import com.elife.utils.ParamUtils;

/**
 * @author 任创权
 * 编写时间  2016-6-2 上午10:06:28
 * TODO ---
 *
 */
public class CommentsService {

	/**
	 * TODO ---
	 */
	public Pager<Goodscomment> getGoodsPager(int id, int infos,
			int page) {
		ICommentsDao commentsDao = new CommentsDao();
		Pager<Goodscomment> p = new Pager<Goodscomment>();
		double[] dis = new double[2];
		dis = getDis(infos);// 获取规定区间
		List<Goodscomment> goodsList = commentsDao
				.getGoodsList(id,
 dis, page);// 过去List参数
		int count = commentsDao.getGoodsCommentCount();// 获取总条数

		p.setNowPager(page);// 设置当前页
		p.setPerSize(ParamUtils.PERPAGE);// 设置每页大小
		p.setTotalRecordNum(count);// 设置总条数
		p.setTotalPageNum(PageUtils.getPagersByNums(count));// 设置总页数
		p.setObjects(goodsList);// 封装信息list
		return p;
	}

	/**
	 * TODO ---
	 */
	private double[] getDis(int infos) {
		double[] dis = new double[2];
		// 开始好评差评逻辑判断
		if (infos == 0) {
			dis[0] = ParamUtils.BOTTOM;
			dis[1] = ParamUtils.TOP;

		} else if (infos == 1) {
			dis[0] = ParamUtils.BOTTOM;
			dis[1] = ParamUtils.BAD;

		} else if (infos == 2) {
			dis[0] = ParamUtils.BAD;
			dis[1] = ParamUtils.MIDDLE;

		} else if (infos == 3) {
			dis[0] = ParamUtils.MIDDLE;
			dis[1] = ParamUtils.TOP;
		}
		return dis;
	}

	/**
	 * TODO ---
	 */
	public boolean add(Goodscomment goodscomment) {
		ICommentsDao commentsDao = new CommentsDao();
		return commentsDao.addComments(goodscomment);
	}

	/**
	 * TODO ---
	 */
	public boolean addReply(Commentreply commentreply) {
		ICommentsDao commentsDao = new CommentsDao();
		return commentsDao.addCommentsReply(commentreply);
	}

}
