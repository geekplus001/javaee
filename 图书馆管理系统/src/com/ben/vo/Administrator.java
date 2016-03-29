package com.ben.vo;

import java.io.Serializable;

public class Administrator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adbName;
	private String adbPassword;
	public String getAdbName() {
		return adbName;
	}
	public void setAdbName(String adbName) {
		this.adbName = adbName;
	}
	public String getAdbPassword() {
		return adbPassword;
	}
	public void setAdbPassword(String adbPassword) {
		this.adbPassword = adbPassword;
	}
	@Override
	public String toString() {
		return "Administrator [adbName=" + adbName + ", adbPassword=" + adbPassword + "]";
	}
	public Administrator(String adbName, String adbPassword) {
		super();
		this.adbName = adbName;
		this.adbPassword = adbPassword;
	}
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
