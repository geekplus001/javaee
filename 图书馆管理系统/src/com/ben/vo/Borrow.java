package com.ben.vo;

import java.io.Serializable;

public class Borrow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3098309234738892410L;
	private int lendNumber;
	private String lendDate;
	private String returnDate; 
	private String lendBookName;
	private String borrowerCard;
	private String borrowPhone;
	private String lendUser;
	private int borrowNumber;
	private int renew;
	public int getLendNumber() {
		return lendNumber;
	}
	public void setLendNumber(int lendNumber) {
		this.lendNumber = lendNumber;
	}
	public String getLendDate() {
		return lendDate;
	}
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getLendBookName() {
		return lendBookName;
	}
	public void setLendBookName(String lendBookName) {
		this.lendBookName = lendBookName;
	}
	public String getBorrowerCard() {
		return borrowerCard;
	}
	public void setBorrowerCard(String borrowerCard) {
		this.borrowerCard = borrowerCard;
	}
	public String getBorrowPhone() {
		return borrowPhone;
	}
	public void setBorrowPhone(String borrowPhone) {
		this.borrowPhone = borrowPhone;
	}
	public String getLendUser() {
		return lendUser;
	}
	public void setLendUser(String lendUser) {
		this.lendUser = lendUser;
	}
	public int getBorrowNumber() {
		return borrowNumber;
	}
	public void setBorrowNumber(int borrowNumber) {
		this.borrowNumber = borrowNumber;
	}
	public int getRenew() {
		return renew;
	}
	public void setRenew(int renew) {
		this.renew = renew;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Borrow [lendNumber=" + lendNumber + ", lendDate=" + lendDate + ", returnDate=" + returnDate
				+ ", lendBookName=" + lendBookName + ", borrowerCard=" + borrowerCard + ", borrowPhone=" + borrowPhone
				+ ", lendUser=" + lendUser + ", borrowNumber=" + borrowNumber + ", renew=" + renew + "]";
	}
	public Borrow(int lendNumber, String lendDate, String returnDate, String lendBookName, String borrowerCard,
			String borrowPhone, String lendUser, int borrowNumber, int renew) {
		super();
		this.lendNumber = lendNumber;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.lendBookName = lendBookName;
		this.borrowerCard = borrowerCard;
		this.borrowPhone = borrowPhone;
		this.lendUser = lendUser;
		this.borrowNumber = borrowNumber;
		this.renew = renew;
	}
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
