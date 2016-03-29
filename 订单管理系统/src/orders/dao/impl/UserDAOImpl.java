package orders.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import orders.utils.db.DBUtils;
import orders.vo.User;

public class UserDAOImpl {
	
	public void deleteById(Integer id)throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from user where userid=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("删除用户编号为【"+id+"】的用户失败");
		}
		finally
		{
			DBUtils.close(null, ps, conn);
		}
	}
	
	public List<User> findAll() throws Exception
	{
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userid,username,createddate,lastmodifydate from user";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
	
			rs = ps.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setCreatedate(rs.getDate(3));
				user.setLastmodifydate(rs.getDate(4));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("查询订单列表失败");
		}
		finally
		{
			DBUtils.close(rs, ps, conn);
		}
		return users;
	}
	
	
	public User findById(Integer id) throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select username,createddate,lastmodifydate from user where userid = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				user = new User();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setCreatedate(rs.getDate(3));
				user.setLastmodifydate(rs.getDate(4));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("查询订单列表失败");
		}
		finally
		{
			DBUtils.close(rs, ps, conn);
		}
		return user;
	}
	
	public void save(User user) throws Exception 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into user(username,password,createddate,lastmodifydate,) values(?,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setDate(3,new java.sql.Date(user.getCreatedate().getTime()));
			ps.setDate(4,new java.sql.Date(user.getLastmodifydate().getTime()));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("添加用户失败");
		}
		finally
		{
			DBUtils.close(null, ps, conn);
		}
	}
	
	
	public void update (User user) throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update user set username=?,password=?,lastmodifydate=? where userid=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setDate(3, new java.sql.Date(user.getLastmodifydate().getTime()));
			ps.setInt(4, user.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("修改用户编号为【"+user.getUserid()+"]的用户失败");
		}
		finally
		{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 根据用户名和密码登陆系统
	 */
	public User login(String username,String password)throws Exception
	{
		java.sql.Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select userid,username,password,createddate,lastmodifydate from user where username=? and password=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next())
			{
				user = new User();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setCreatedate(rs.getDate(4));
				user.setLastmodifydate(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("用户名或则密码错误");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return user;	
	}
}
