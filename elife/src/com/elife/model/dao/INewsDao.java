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
 * @Description: 对滚动新闻表的操作
 */
public interface INewsDao {
	//增加新闻
	public abstract boolean addNews(News news,int page);
	//删除新闻
	public abstract boolean deleteNews(int id);
	//查看某一个新闻浏览人数
	public abstract int selectNewsReadNum(int id);
	//查看所有新闻（根据浏览人数排序）（根据状态）（根据发表时间）（查看某一新闻的所有评论）（根据谁发布的新闻）
	public abstract List<News> selectAllNews(int page);
	public abstract List<News> selectAllNews(int status,int page);
	public abstract List<News> selectAllNewsByTime(String time,int page);
	public abstract List<Newscomment> selectNewsComment(int id); //通过活动ID
	public abstract List<News> selectAllNewsByUserName(String username);
	//修改新闻信息（修改状态）
	public abstract boolean modifyNewsStatus(int id);
}
