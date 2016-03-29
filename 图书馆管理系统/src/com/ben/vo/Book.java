package com.ben.vo;

import java.io.Serializable;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookNumber;
	private String bookCategory;
	private String bookName;
	private float bookPrice;
	private String bookAuthor;
	private String bookPublishingHouse;
	private String authorIntroduction;
	private String bookIntroduction;
	private String bookPath;
	private int bookStock;
	private int bookBorrowTime;
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublishingHouse() {
		return bookPublishingHouse;
	}
	public void setBookPublishingHouse(String bookPublishingHouse) {
		this.bookPublishingHouse = bookPublishingHouse;
	}
	public String getAuthorIntroduction() {
		return authorIntroduction;
	}
	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}
	public String getBookIntroduction() {
		return bookIntroduction;
	}
	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}
	public String getBookPath() {
		return bookPath;
	}
	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
	public int getBookBorrowTime() {
		return bookBorrowTime;
	}
	public void setBookBorrowTime(int bookBorrowTime) {
		this.bookBorrowTime = bookBorrowTime;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookCategory=" + bookCategory + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + ", bookAuthor=" + bookAuthor + ", bookPublishingHouse="
				+ bookPublishingHouse + ", authorIntroduction=" + authorIntroduction + ", bookIntroduction="
				+ bookIntroduction + ", bookPath=" + bookPath + ", bookStock=" + bookStock + ", bookBorrowTime="
				+ bookBorrowTime + "]";
	}
	public Book(int bookNumber, String bookCategory, String bookName, float bookPrice, String bookAuthor,
			String bookPublishingHouse, String authorIntroduction, String bookIntroduction, String bookPath,
			int bookStock, int bookBorrowTime) {
		super();
		this.bookNumber = bookNumber;
		this.bookCategory = bookCategory;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublishingHouse = bookPublishingHouse;
		this.authorIntroduction = authorIntroduction;
		this.bookIntroduction = bookIntroduction;
		this.bookPath = bookPath;
		this.bookStock = bookStock;
		this.bookBorrowTime = bookBorrowTime;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
