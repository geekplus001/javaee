package com.ben.vo;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categories;
	private String categoriesName;
	private int categoriesNumber;
	public int getCategories() {
		return categories;
	}
	public void setCategories(int categories) {
		this.categories = categories;
	}
	public String getCategoriesName() {
		return categoriesName;
	}
	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
	public int getCategoriesNumber() {
		return categoriesNumber;
	}
	public void setCategoriesNumber(int categoriesNumber) {
		this.categoriesNumber = categoriesNumber;
	}
	@Override
	public String toString() {
		return "Category [categories=" + categories + ", categoriesName=" + categoriesName + ", categoriesNumber="
				+ categoriesNumber + "]";
	}
	public Category(int categories, String categoriesName, int categoriesNumber) {
		super();
		this.categories = categories;
		this.categoriesName = categoriesName;
		this.categoriesNumber = categoriesNumber;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
