package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo {
	//���ݿ����ӵ�ַ
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
			System.out.println("�ɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * �������
	 */
	public static void insert()
	{
		
		try {
			//1���������ݿ���������
			
			Class.forName(DRIVER);
			//2����ȡ���ݿ�����
			
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//����SQL���
			
			String sql = "insert into person(name,age,description) values('С��',18,'һ�����������������')";
			//4������һ��Statementʵ������������SQL�������壩
			
			Statement state = conn.createStatement();
			//5��ִ��SQL���
			
			state.executeUpdate(sql);
			
			//6���ر�����
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
