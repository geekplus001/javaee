package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import db.DBUtils;

public class ProcedureDemo {

	public static void callProcedure()
	{
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "{call javaProcDemo(?,?)}";
		try
		{
			conn = DBUtils.getConnection();
			cs = conn.prepareCall(sql);
			cs.setString(1,"̬��");
			cs.registerOutParameter(2, Types.VARCHAR);//ע��ڶ�������Ϊ�������
			
			boolean b = cs.execute();
			System.out.println(b);
			
			//��ȡ�洢���̵ķ��ؽ����
			while(b)
			{
				rs = cs.getResultSet();
				while(rs.next())
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String pwd = rs.getString(3);
					System.out.println("id = "+id+",name = "+name+",pwd = "+pwd);
				}
				//��ȡ����Ľ����
				b = cs.getMoreResults();
			}
			
			System.out.println(cs.getString(2));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(rs, cs, conn);
		}
	}
	
	public static void main(String[] args) {
		callProcedure();
	}

}
