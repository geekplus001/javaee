import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


public class JdbcDemo {

	//数据库连接地址
		public static String URL = "jdbc:mysql://localhost:3306/test";
		public static String USERNAME = "root";
		public static String PASSWORD = "1359212743";
		public static String DRIVER = "com.mysql.jdbc.Driver";
	/*
	 * 
	 */
	public static Person findById(int id)
	{
		Person p = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select name,age,description from person where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				p = new Person();
				p.setId(id);
				p.setName(rs.getString(1));
				p.setAge(rs.getInt(2));
				p.setDescription(rs.getString(3));
				//把java.sql.Date 与 java.util.Date 之间的转换
//				java.util.Date date = rs.getDate(4);
//				ps.setDate(4, new java.sql.Date(date.getTime()));
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	/*
	 * 
	 */
	public static void delete(int id)
	{
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 使用PreparedStatement更新数据
	 */
	public static void update(Person p)
	{
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update person set name=?,age=?,description=? where id =?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getId());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 使用PreparedStatement插入数据
	 */
	public static void insert(Person p)
	{
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into Person(name,age,description)values(?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			
			ps.executeUpdate();
			
			ps.close();
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
		Person p = new Person(2,"小黑黑",8,"是一个很");
//		insert(p);
//		update(p);
//		delete(2);
		p = findById(1);
		System.out.println(p);
	}

}
