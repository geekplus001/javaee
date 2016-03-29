package orders.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
	private static Properties config = null;
	static{
		InputStream input  = Thread.currentThread().getContextClassLoader().getResourceAsStream("orders/dao/factory/dao.properties");
		config = new Properties();
		try {
			config.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ���ض���DAO����
	 */
	public static IOrderDao getOrderDAO() throws Exception
	{
		String instance = config.getProperty("orders.dao.IOrderDAO");
		IOrderDAO orderDAO = null;
		try
		{
			orderDAO = (IOrderDAO)Class.forName(instance).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return orderDAO;
	}
	/*
	 *�����û�DAO����
	 */
	public static IUserDAO getUserDAO() throw Exception
	{
		String instance = config.getProperty("orders.dao.IUserDAO");
		IUserDAO userDAO = null;
		try
		{
			userDAO = (IUserDAO)Class.forName(instance).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return userDAO;
	}
	/*
	 * ���ض�����ϸDAO����
	 */
	public static IOrderItemDAO getOrderItemDAO() throws Exception
	{
		String instance = config.getProperty("orders.dao.IOrderItemDAO");
		IOrderItemDAO orderItemDAO = null;
		try {
			orderItemDAO = (IOrderItemDAO)Class.forName(instance).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return orderItemDAO;
	}
}
