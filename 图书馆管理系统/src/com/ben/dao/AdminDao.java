package com.ben.dao;

import java.sql.SQLException;

import com.ben.vo.Administrator;

public interface AdminDao {
	public Administrator findByAdminName(String adminName)throws SQLException;
}
