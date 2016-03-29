package com.ben.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ben.base.ResultSetHandler;
import com.ben.dao.UserDao;
import com.ben.db.JdbcTemplate;
import com.ben.vo.User;

public class UserDaoImpl implements UserDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public void saveUser(User user) throws SQLException {

		String sql = "insert into user(username,usersex,userage,userpassword,userintro) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUserName(),user.getUserSex(),user.getUserAge(),user.getUserPassword(),user.getUserIntro());
	}

	@Override
	public void deleteUserByName(String userName) throws SQLException {

		String sql = "delete from user where username=?";
		jdbcTemplate.update(sql, userName);
	}

	@Override
	public void updateUser(User  user) throws SQLException {

		String sql = "update user set usersex=?,userage=?,userpassword=?,userintro=? where username=?";
		jdbcTemplate.update(sql, user.getUserSex(),user.getUserAge(),user.getUserPassword(),user.getUserIntro(),user.getUserName());
	}

	@Override
	public User findUserByUserName(String userName) throws SQLException {
		String sql = "select usernumber,username,usersex,userage,userpassword,userintro,usercredit from user where username=?";
		return (User) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				User user = null;
				if(rs.next())
				{
					user = new User();
					user.setUserNumber(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserSex(rs.getString(3));
					user.setUserAge(rs.getInt(4));
					user.setUserPassword(rs.getString(5));
					user.setUserIntro(rs.getString(6));
					user.setUserCredit(rs.getInt(7));
					
				}
				
				return user;
			}
		},  userName);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() throws SQLException {
		String sql = "select usernumber,username,usersex,userage,userpassword,userintro,usercredit from user";
		return (List<User>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				User user = null;
				while(rs.next())
				{
					user = new User();
					user.setUserNumber(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserSex(rs.getString(3));
					user.setUserAge(rs.getInt(4));
					user.setUserPassword(rs.getString(5));
					user.setUserIntro(rs.getString(6));
					user.setUserCredit(rs.getInt(7));
					users.add(user);
				}
				return users;
			}
		});
		
	}

	@Override
	public void updateUserCredit(String userName,int userCredit) throws SQLException {
		String sql = "update user set usercredit=? where username=?";
		jdbcTemplate.update(sql, userCredit,userName);
	}

//	@Override
//	public void updateUserBorrow(String userName) throws SQLException {
//		String sql = "update user set userborrow=? where username=?";
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
//	}

}
