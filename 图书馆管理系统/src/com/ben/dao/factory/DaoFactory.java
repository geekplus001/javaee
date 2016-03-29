package com.ben.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ben.dao.AdminDao;
import com.ben.dao.BookDao;
import com.ben.dao.BorrowDao;
import com.ben.dao.CategoryDao;
import com.ben.dao.UserDao;

public class DaoFactory {

	private static Properties config = null;
	static{
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/ben/dao/factory/dao.properties");
		config = new Properties();
		try {
			config.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BookDao getBookDao()
	{
		String instance = config.getProperty("bookdaoF");
		BookDao bookDao = null;
		try {
			bookDao = (BookDao) Class.forName(instance).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookDao;
	}
	
	public static BorrowDao getBorrowDao()
	{
		String instance  = config.getProperty("borrowdaoF");
		BorrowDao borrowDao = null;
		try {
			borrowDao = (BorrowDao) Class.forName(instance).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrowDao;
	}
	public static UserDao getUserDao()
	{
		String instance = config.getProperty("userdaoF");
		UserDao userDao = null;
		try {
			userDao = (UserDao) Class.forName(instance).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userDao;
	}
	
	
	public static CategoryDao getCategoryDao()
	{
		String instance = config.getProperty("categorydaoF");
		CategoryDao categoryDao = null;
		try {
			categoryDao = (CategoryDao) Class.forName(instance).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return categoryDao;
	}
	
	public static AdminDao getAdminDao()
	{
		String instance = config.getProperty("admindaoF");
		AdminDao adminDao  = null;
		
		try {
			adminDao = (AdminDao) Class.forName(instance).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return adminDao;
	}
	
}
