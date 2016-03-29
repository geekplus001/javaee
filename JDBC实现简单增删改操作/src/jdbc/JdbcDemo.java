package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo {
	//数据库连接地址
	public static String URL = "jdbc:mysql://localhost:3306/test";
	public static String USERNAME = "root";
	public static String PASSWORD = "1359212743";
	public static String DRIVER = "com.mysql.jdbc.Driver";
	/*
	 * 
	 */
	public static void update()
	{
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update person set age = 19 where id = 0";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
			state.close();
			conn.close();
			System.out.println("成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 插入操作
	 */
	public static void insert()
	{
		
		try {
			//1、加载数据库驱动程序
			
			Class.forName(DRIVER);
			//2、获取数据库连接
			
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//构造SQL语句
			
			String sql = "insert into person(name,age,description) values('小白',18,'一个猥琐但不下流的人')";
			//4、构造一个Statement实例（用来发送SQL语句的载体）
			
			Statement state = conn.createStatement();
			//5、执行SQL语句
			
			state.executeUpdate(sql);
			
			//6、关闭连接
			state.close();
			conn.close();
			
			System.out.println("success!");
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
//		insert();
		update();
	}

}
