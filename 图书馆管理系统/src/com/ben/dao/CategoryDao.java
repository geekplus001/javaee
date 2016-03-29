package com.ben.dao;

import java.sql.SQLException;
import java.util.List;

import com.ben.vo.Category;


public interface CategoryDao {
	public void saveCategory(Category category)throws SQLException;
	
	public void deleteCategoryByName(String categoryName)throws SQLException;
	
	public void updateCategoryNumber(int newNumber,String categoryName)throws SQLException;
	
	public Category findCategoryByName(String categoryName)throws SQLException; 
	
	public List<Category> findAllCategory()throws SQLException;
	
	public Category findCategoryById(int categoryId)throws SQLException;
}
