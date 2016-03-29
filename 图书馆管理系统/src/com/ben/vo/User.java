package com.ben.vo;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userNumber;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userSex;
	private String userIntro;
	private int userCredit;
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public int getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(int userCredit) {
		this.userCredit = userCredit;
	}
	@Override
	public String toString() {
		return "User [userNumber=" + userNumber + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userAge=" + userAge + ", userSex=" + userSex + ", userIntro=" + userIntro + ", userCredit="
				+ userCredit + "]";
	}
	public User(int userNumber, String userName, String userPassword, int userAge, String userSex, String userIntro,
			int userCredit) {
		super();
		this.userNumber = userNumber;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAge = userAge;
		this.userSex = userSex;
		this.userIntro = userIntro;
		this.userCredit = userCredit;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
