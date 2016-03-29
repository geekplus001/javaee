package com.ben.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ben.base.ResultSetHandler;
import com.ben.dao.BorrowDao;
import com.ben.db.JdbcTemplate;
import com.ben.vo.Borrow;

public class BorrowDaoImpl implements BorrowDao{

	private JdbcTemplate jdbcTemplate; 
	public BorrowDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}
	@Override
	public void saveBorrow(Borrow borrow) throws SQLException {
		String sql = "insert into borrow(lenddate,lendbookname,borrowercard,borrowerphone,lenduser,borrownumber) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, borrow.getLendDate(),borrow.getLendBookName(),borrow.getBorrowerCard(),borrow.getBorrowPhone(),borrow.getLendUser(),borrow.getBorrowNumber());
	}

	@Override
	public void deleteBorrowByBorrowName(String borrowName,String lendUser) throws SQLException {
		String sql = "delete from borrow where lendbookname=? and lenduser=?";
		jdbcTemplate.update(sql, borrowName,lendUser);
	}

	@Override
	public void updateBorrow(Borrow borrow) throws SQLException {
		String sql = "update borrow set returndate=?,borrownumber=? where lendnumber=?";
		jdbcTemplate.update(sql, borrow.getReturnDate(),borrow.getBorrowNumber(),borrow.getLendNumber());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> findBorrowByBorrowName(String borrowName,String lendUser) throws SQLException {
		String sql = "select lendnumber,lenddate,returndate,lendbookname,borrowercard,borrowerphone,lenduser,borrownumber,renew from borrow where lendbookname=? and lenduser=?";
		return ((List<Borrow>) jdbcTemplate.query(sql, new ResultSetHandler() {
					
					@Override
					public Object doHandler(ResultSet rs) throws SQLException {
						List<Borrow> borrows = new ArrayList<Borrow>();
						Borrow borrow = null;
						while(rs.next())
						{
							borrow = new Borrow();
							borrow.setLendNumber(rs.getInt(1));
							borrow.setLendDate(rs.getString(2));
							borrow.setReturnDate(rs.getString(3));
							borrow.setLendBookName(rs.getString(4));
							borrow.setBorrowerCard(rs.getString(5));
							borrow.setBorrowPhone(rs.getString(6));
							borrow.setLendUser(rs.getString(7));
							borrow.setBorrowNumber(rs.getInt(8));
							borrow.setRenew(rs.getInt(9));
							borrows.add(borrow);
						}
						return borrows;
					}
				},borrowName,lendUser));		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> findAllBorrow() throws SQLException {
		String sql = "select lendnumber,lenddate,returndate,lendbookname,borrowercard,borrowerphone,lenduser,borrownumber,renew from borrow";
		return (List<Borrow>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Borrow> borrows = new ArrayList<Borrow>();
				Borrow borrow = null;
				while(rs.next())
				{
					borrow = new Borrow();
					borrow.setLendNumber(rs.getInt(1));
					borrow.setLendDate(rs.getString(2));
					borrow.setReturnDate(rs.getString(3));
					borrow.setLendBookName(rs.getString(4));
					borrow.setBorrowerCard(rs.getString(5));
					borrow.setBorrowPhone(rs.getString(6));
					borrow.setLendUser(rs.getString(7));
					borrow.setBorrowNumber(rs.getInt(8));
					borrow.setRenew(rs.getInt(9));
					borrows.add(borrow);
				}
				return borrows;
			}
		});
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> findBorrowByLendUserName(String lendUserName) throws SQLException {
		String sql = "select lendnumber,lenddate,returndate,lendbookname,borrowercard,borrowerphone,lenduser,borrownumber,renew from borrow where lenduser=?";
		return (List<Borrow>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Borrow> borrows = new ArrayList<Borrow>();
				Borrow borrow = null;
				while(rs.next())
				{
					borrow = new Borrow();
					borrow.setLendNumber(rs.getInt(1));
					borrow.setLendDate(rs.getString(2));
					borrow.setReturnDate(rs.getString(3));
					borrow.setLendBookName(rs.getString(4));
					borrow.setBorrowerCard(rs.getString(5));
					borrow.setBorrowPhone(rs.getString(6));
					borrow.setLendUser(rs.getString(7));
					borrow.setBorrowNumber(rs.getInt(8));
					borrow.setRenew(rs.getInt(9));
					borrows.add(borrow);
				}
				return borrows;
			}
		}, lendUserName);
	}
	@Override
	public Borrow findBorrowByLendNumber(int lendNumber) throws SQLException {
		
		String sql = "select lendnumber,lenddate,returndate,lendbookname,borrowercard,borrowerphone,lenduser,borrownumber,renew from borrow where lendnumber=?";
		return (Borrow) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Borrow borrow = null;
				if(rs.next())
				{
					borrow = new Borrow();
					borrow.setLendNumber(rs.getInt(1));
					borrow.setLendDate(rs.getString(2));
					borrow.setReturnDate(rs.getString(3));
					borrow.setLendBookName(rs.getString(4));
					borrow.setBorrowerCard(rs.getString(5));
					borrow.setBorrowPhone(rs.getString(6));
					borrow.setLendUser(rs.getString(7));
					borrow.setBorrowNumber(rs.getInt(8));
					borrow.setRenew(rs.getInt(9));
				}
				return borrow;
			}
		},lendNumber);
		
	}
	@Override
	public void renewing(Borrow borrow) throws SQLException {
		String sql = "update borrow set renew=?,lenddate=? where lendnumber=?";
		jdbcTemplate.update(sql, borrow.getRenew(),borrow.getLendDate(),borrow.getLendNumber());
	}

}
