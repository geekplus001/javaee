package db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ���ݿ����������
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
//	//ʹ�þ�̬�������������
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
	//����һ����ȡ���ݿ����ӵķ���
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			//��������Դ��C3P0�����
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			DataSource ds =  new ComboPooledDataSource("dbInfo");
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ����ʧ�ܣ�");
		}
		return conn;
	}
	
	/*
	 * �ر����ݿ�����
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
