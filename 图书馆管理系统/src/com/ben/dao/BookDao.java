package com.ben.dao;

import java.sql.SQLException;
import java.util.List;

import com.ben.base.PageRoll;
import com.ben.vo.Book;


/*
 * 数据访问接口
 */
public interface BookDao {
	public void saveBook(Book book)throws SQLException;
	
	public void deleteBookByBookName(String bookName)throws SQLException;
	
	public void updateBook(Book book)throws SQLException;
	
	public Book findBookByBookName(String bookName)throws SQLException;
	
	public List<Book> findAllBook()throws SQLException;
	
	public List<Book> listRoll(PageRoll pageRoll)throws SQLException;
	
	public void addBookNumber(int newNumber,String bookName)throws SQLException;
}
