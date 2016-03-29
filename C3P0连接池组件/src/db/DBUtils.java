package db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 数据库操作工具类
 */
public class DBUtils {
//	public static String URL;
//	public static String USERNAME;
//	public static String PASSWORD;
//	public static String DRIVER;
//	
//	private static ResourceBundle rb = ResourceBundle.getBundle("db-config");
//	
//	private DBUtils()
//	{
//		
//	}
//	
//	//使用静态块加载驱动程序
//	static 
//	{
//		URL = rb.getString("jdbc.url");
//		USERNAME = rb.getString("jdbc.username");
//		PASSWORD = rb.getString("jdbc.password");
//		DRIVER = rb.getString("jdbc.driver");
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	//定义一个获取数据库连接的方法
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			//创建数据源（C3P0组件）
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			DataSource ds =  new ComboPooledDataSource("dbInfo");
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取链接失败！");
		}
		return conn;
	}
	
	/*
	 * 关闭数据库链接
	 */
	public static void close(ResultSet rs,Statement state,Connection conn)
	{
		
		
			try {
				if(rs!=null)
					rs.close();
				if(state!=null)
				{
					state.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
