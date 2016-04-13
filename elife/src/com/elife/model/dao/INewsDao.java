/**
 * 
 */
package com.elife.model.dao;

import java.util.List;

import com.elife.model.beans.News;
import com.elife.model.beans.Newscomment;

/**
 * @ClassName: INewsDao
 * @author 张凯 E-mail: cloudpluie.github.io
 * @date: 2016-4-12 上午11:35:58 
 * @Description: TODO
 */
public interface INewsDao {
	//增加活动
	public abstract boolean addNews(String content);
	//删除活动
	public abstract boolean deleteNews(int id);
	//查看某一个活动浏览人数
	public abstract int selectNewsReadNum(int id);
	//查看所有活动（根据浏览人数排序）（根据状态）（根据发表时间）（查看某一活动的所有评论）（根据谁发布的活动）
	public abstract List<News> selectAllNews();
	public abstract List<News> selectAllNews(int status);
	public abstract List<News> selectAllNewsByTime(String time);
	public abstract List<Newscomment> selectNewsComment(int id); //通过活动ID
	public abstract List<News> selectAllNewsByUserName(String username);
	//修改活动信息（修改状态）
	public abstract boolean modifyNewsStatus(int id);
}
