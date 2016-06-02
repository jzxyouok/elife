package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.Commentreply;
import com.elife.model.beans.Goodscomment;
import com.elife.model.beans.Pager;

/**
 * @author 任创权
 * 编写时间  2016-6-2 上午10:07:06
 * TODO ---
 *
 */
public interface ICommentsDao {
	public Pager<Goodscomment> getCommentsPager(int merchantId, int infos,
			int pager);

	public boolean addComments(Goodscomment goodscomment);

	public boolean addCommentsReply(Commentreply commentreply);

	/**
	 * TODO ---
	 */
	public List<Goodscomment> getGoodsList(int id, double[] dis,
			int page);

	/**
	 * TODO ---
	 */
	public int getGoodsCommentCount();
}
