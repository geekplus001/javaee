package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcTxDemo {

	//数据库连接地址
		public static String URL = "jdbc:mysql://localhost:3306/test";
		public static String USERNAME = "root";
		public static String PASSWORD = "1359212743";
		public static String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void txTest()
	{
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			conn.setAutoCommit(false);
			
			String sql1 = "insert into user(name,pwd)values(?,?)";
			String sql2 = "update user set pwd=? where name=?";
		    java.sql.PreparedStatement ps = conn.prepareStatement(sql1);
		    ps.setString(1, "ry");
		    ps.setString(2, "123");
		    
		    ps.executeUpdate();
		    ps = conn.prepareStatement(sql2);
		    ps.setString(1, "123");
		    ps.setString(2, "vince");
		    
		    ps.executeUpdate();
			
		    conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();//回滚
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		txTest();
	}

}
