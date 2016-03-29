package 封装JDBC工具类;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	/*
	 * 锟斤拷询锟侥凤拷锟斤拷
	 */
	public static void findAll()
	{
		//通锟斤拷锟斤拷锟斤拷锟斤拷锟饺★拷锟斤拷菘锟斤拷锟斤拷锟�
		Connection conn = DBUtils.getConnection();
		String sql = "select id,name,age,description from person";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Person p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setDescription(rs.getString(4));
				System.out.println(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(rs, ps, conn);
		}
	}
	
	public static void main(String[] args) {
		findAll();
	}

}
