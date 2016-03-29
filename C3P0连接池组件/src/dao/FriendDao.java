package dao;

import java.sql.SQLException;
import java.util.List;

import base.PageRoll;
import entity.Friend;

/*
 * 数据访问接口
 */
public interface FriendDao {
	public void save(Friend f)throws SQLException;
	
	public void delete(int id)throws SQLException;
	
	public void update(Friend f)throws SQLException;
	
	public Friend findById(int id)throws SQLException;
	
	public List<Friend> findAll()throws SQLException;
	
	public List<Friend> list(PageRoll pageRoll)throws SQLException;
}
