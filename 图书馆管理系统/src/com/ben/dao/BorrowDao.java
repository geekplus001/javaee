package com.ben.dao;

import java.sql.SQLException;
import java.util.List;

import com.ben.vo.Borrow;

public interface BorrowDao {
	public void saveBorrow(Borrow borrow)throws SQLException;
	
	public void deleteBorrowByBorrowName(String borrowName,String lendUser)throws SQLException;
	
	public void updateBorrow(Borrow borrow)throws SQLException;
	
	public List<Borrow>  findBorrowByBorrowName(String borrowName,String lendUser)throws SQLException;
	
	public List<Borrow> findAllBorrow()throws SQLException;
	
	public List<Borrow> findBorrowByLendUserName(String lendUserName)throws SQLException;
	
	public Borrow findBorrowByLendNumber(int lendNumber)throws SQLException;
	
	public void renewing(Borrow borrow)throws SQLException;
}	
