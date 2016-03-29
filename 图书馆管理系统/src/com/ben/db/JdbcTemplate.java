package com.ben.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ben.base.ResultSetHandler;

public class JdbcTemplate {
	public int update(String sql,Object ... objects)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(objects!=null)
			{
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i+1,objects[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		finally
		{
			DBUtils.close(null, ps, conn);
		}
		
	}
	
	
	
	/*
	 */
	public Object query(String sql,ResultSetHandler handler,Object ... args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(args!=null)
			{
				for (int  i = 0;  i < args.length;  i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			rs = ps.executeQuery();
			return handler.doHandler(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally
		{
			DBUtils.close(rs, ps, conn);
		}
	}
	
}
