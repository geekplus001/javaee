package com.ben.dao;

import java.sql.SQLException;
import java.util.List;

import com.ben.vo.User;

public interface UserDao {
	public void saveUser(User user)throws SQLException;
	
	public void deleteUserByName(String userName)throws SQLException;
	
	public void updateUser(User user)throws SQLException;
	
	public User findUserByUserName(String userName)throws SQLException; 
	
	public List<User> findAllUser()throws SQLException;
	
	public void updateUserCredit(String userName,int userCredit)throws SQLException;
	
//	public void updateUserBorrow(String userName)throws SQLException;
}
