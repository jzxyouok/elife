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
	public abstract Topic selectTopicByname(int name);
	//根据创建时间范围查询某时间段内的话题
	public abstract Topic selectTopic(String starttime,String endtime);
	//查询根据话题讨论的人数对话题进行排序（查询出最热话题）
	public abstract List<Topic> selectAllTopicBynumber(int id);
	//查询没有通过审核的话题
	public abstract Topic selectNockTopic(int status,Topic topic);
	//查询所有的话题信息
	public abstract List<Topic> selectAllTopic();


	//审核话题,修改状态status
	public abstract boolean checkTopic(int id,Topic topic);

	//禁用图文消息
	public abstract boolean deleteTopicByid(int id);
	public abstract boolean deleteTopicByname(int name);
}
