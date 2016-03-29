package com.ben.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ben.base.PageRoll;
import com.ben.base.ResultSetHandler;
import com.ben.dao.BookDao;
import com.ben.db.JdbcTemplate;
import com.ben.vo.Book;

public class BookDaoImpl implements BookDao{
	private JdbcTemplate jdbcTemplate;
	public BookDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public void saveBook(Book book) throws SQLException {
		String sql = "insert into "
				+ "book(booknumber,bookcategory,bookname,bookprice,bookauthor,bookpublishinghouse,authorintroduction,bookintroduction,bookpath,bookstock) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,book.getBookNumber(), book.getBookCategory(),book.getBookName(),book.getBookPrice(),book.getBookAuthor(),book.getBookPublishingHouse(),book.getAuthorIntroduction(),book.getBookIntroduction(),book.getBookPath(),book.getBookStock());
	}

	@Override
	public void deleteBookByBookName(String bookName) throws SQLException {

		String sql = "delete from book where bookname=?";
		jdbcTemplate.update(sql, bookName);
	}

	@Override
	public void updateBook(Book book) throws SQLException {

		String sql = "update book set bookprice=?,bookpublishinghouse=?,bookintroduction=?,bookstock=?,bookborrowtime=? where bookname=?";
		jdbcTemplate.update(sql, book.getBookPrice(),book.getBookPublishingHouse(),book.getBookIntroduction(),book.getBookStock(),book.getBookBorrowTime(),book.getBookName());
	}

	@Override
	public Book findBookByBookName(String bookName) throws SQLException {
		String sql = "select booknumber,bookcategory,bookname,bookprice,bookauthor,bookpublishinghouse,authorintroduction,bookintroduction,bookpath,bookstock,bookborrowtime from book where bookname=?";
		return (Book) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Book book = null;
				if(rs.next())
				{
					book = new Book();
					book.setBookNumber(rs.getInt(1));
					book.setBookCategory(rs.getString(2));
					book.setBookName(rs.getString(3));
					book.setBookPrice(rs.getFloat(4));
					book.setBookAuthor(rs.getString(5));
					book.setBookPublishingHouse(rs.getString(6));
					book.setAuthorIntroduction(rs.getString(7));
					book.setBookIntroduction(rs.getString(8));
					book.setBookPath(rs.getString(9));
					book.setBookStock(rs.getInt(10));
					book.setBookBorrowTime(rs.getInt(11));
				}
				return book;
			}
		}, bookName);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBook() throws SQLException {
		String sql = "select booknumber,bookcategory,bookname,bookprice,bookauthor,bookpublishinghouse,authorintroduction,bookintroduction,bookpath,bookstock,bookborrowtime from book";
		return (List<Book>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Book> books = new ArrayList<Book>();
				Book book = null;
				while(rs.next())
				{
					book = new Book();
					book.setBookNumber(rs.getInt(1));
					book.setBookCategory(rs.getString(2));
					book.setBookName(rs.getString(3));
					book.setBookPrice(rs.getFloat(4));
					book.setBookAuthor(rs.getString(5));
					book.setBookPublishingHouse(rs.getString(6));
					book.setAuthorIntroduction(rs.getString(7));
					book.setBookIntroduction(rs.getString(8));
					book.setBookPath(rs.getString(9));
					book.setBookStock(rs.getInt(10));
					book.setBookBorrowTime(rs.getInt(11));
					books.add(book);
				}
 				return books;
			}
		});
		
	}

	@Override
	public List<Book> listRoll(PageRoll pageRoll) throws SQLException {
		String sql1 = "select categoriesnumber from category";
		String sql2 = "select bookcategory,bookname,bookprice,bookauthor,bookpublishinghouse,authorintroduction,bookintroduction,bookpath,bookstock from book limit ?,?";
		int count = (int) jdbcTemplate.query(sql1, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				if(rs.next())
				{
					int count = rs.getInt(1);
					return count;
				}
				return null;
			}
		});
		pageRoll.setTotalCount(count);
		
		@SuppressWarnings("unchecked")
		List<Book> lists = (List<Book>) jdbcTemplate.query(sql2, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Book> lists = new ArrayList<Book>();
				Book book = null;
				while(rs.next())
				{
					book = new Book();
					book.setBookCategory(rs.getString(1));
					book.setBookName(rs.getString(2));
					book.setBookPrice(rs.getFloat(3));
					book.setBookAuthor(rs.getString(4));
					book.setBookPublishingHouse(rs.getString(5));
					book.setAuthorIntroduction(rs.getString(6));
					book.setBookIntroduction(rs.getString(7));
					book.setBookPath(rs.getString(8));
					book.setBookStock(rs.getInt(9));
					lists.add(book);
				}
 				return lists;
			}
			
		}, (pageRoll.getCurrPage()-1)*pageRoll.getPageSize(),pageRoll.getPageSize());
		return lists;
	}

	@Override
	public void addBookNumber(int newNumber, String bookName) throws SQLException {
		String sql = "update book set booknumber=? where bookname=?";
		jdbcTemplate.update(sql, newNumber,bookName);
	}

	

}
