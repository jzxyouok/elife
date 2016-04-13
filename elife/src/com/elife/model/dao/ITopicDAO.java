package com.elife.model.dao;
/**
 * @author 叶梦雅
 *E-mail:1277918272@qq.com
 * ${tags}
 */
import java.util.List;

import com.elife.model.beans.Topic;

public interface ITopicDAO {
	//查看某个话题
	public abstract Topic selectTopicByid(int id);
	//根据话题名称查询话题
	public abstract Topic selectTopicByname(String name);
	//根据创建时间范围查询某时间段内的话题
	public abstract List<Topic> selectTopic(String starttime,String endtime,int nowpage);
	//查询根据话题讨论的人数对话题进行排序（查询出最热话题）
	public abstract List<Topic> selectAllTopicByJoin(boolean bl, int nowpage);
	//查询没有通过审核的话题
	public abstract List<Topic> selectNockTopic(int status, int nowpage);
	//查询所有的话题信息
	public abstract List<Topic> selectAllTopic(int page);

	//审核话题,修改状态status
	public abstract boolean updateTopic(Topic topic);


	// 删除话题
	public abstract boolean deleteTopicByid(int id);

	// 删除话题
	public abstract boolean deleteTopicByname(String name);
}
