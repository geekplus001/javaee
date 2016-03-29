package com.ben.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ben.base.ResultSetHandler;
import com.ben.dao.AdminDao;
import com.ben.db.JdbcTemplate;
import com.ben.vo.Administrator;

public class AdminDaoImpl implements AdminDao{

	private JdbcTemplate jdbcTemplate;
	public AdminDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}
	@Override
	public Administrator findByAdminName(String adminName) throws SQLException {
		String sql = "select adbname,adbpassword from administrator where adbname=?";
		return (Administrator) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Administrator administrator = null;
				if(rs.next())
				{
					administrator = new Administrator();
					administrator.setAdbName(rs.getString(1));
					administrator.setAdbPassword(rs.getString(2));
				}
				return administrator;
			}
		}, adminName);
		
	}

}
