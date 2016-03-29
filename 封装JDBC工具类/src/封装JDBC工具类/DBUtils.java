package 封装JDBC工具类;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
 * 锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
 */
public class DBUtils {
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String DRIVER;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("锟斤拷装JDBC锟斤拷锟斤拷锟斤拷.db-config");
	
	private DBUtils()
	{
		
	}
	
	//使锟矫撅拷态锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	static 
	{
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//锟斤拷锟斤拷一锟斤拷锟斤拷取锟斤拷锟捷匡拷锟斤拷锟接的凤拷锟斤拷
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("锟斤拷取锟斤拷锟斤拷失锟杰ｏ拷");
		}
		return conn;
	}
	
	/*
	 * 锟截憋拷锟斤拷锟捷匡拷锟斤拷锟斤拷
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
