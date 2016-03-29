package 查询操作与ResultSet接口;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQueryDemo {

	public static String URL = "jdbc:mysql://localhost:3306/test";
	public static String USERNAME = "root";
	public static String PASSWORD = "1359212743";
	public static String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void query()
	{
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select id,name,age,description from person";
			Statement state = conn.createStatement();
			//执锟叫诧拷询锟斤拷锟斤拷锟截斤拷锟斤拷锟�
			ResultSet rs = state.executeQuery(sql);
			while(rs.next())
			{
//				rs.getInt("id");
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String description = rs.getString(4);
				System.out.println("id="+id+",name="+name+",age="+age+"description="+description);
				
			}
			rs.close();
			state.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		query();
		
	}

}
