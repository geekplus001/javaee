package com.ben.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ben.base.ResultSetHandler;
import com.ben.dao.CategoryDao;
import com.ben.db.JdbcTemplate;
import com.ben.vo.Category;

public class CategoryDaoImpl implements CategoryDao{
	private JdbcTemplate jdbcTemplate;
	
	public CategoryDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public void saveCategory(Category category) throws SQLException {
		String sql = "insert into category(categories,categoriesname,categoriesnumber) values(?,?,?)";
		jdbcTemplate.update(sql, category.getCategories(),category.getCategoriesName(),category.getCategoriesNumber());
	}

	@Override
	public void deleteCategoryByName(String categoryName) throws SQLException {
		String sql = "delete from category where categoriesname=?";
		jdbcTemplate.update(sql, categoryName);
	}
	
	@Override
	public void updateCategoryNumber(int newNumber,String categoryName) throws SQLException {
		String sql = "update category set categoriesnumber=? where categoriesname=?";
		jdbcTemplate.update(sql, newNumber,categoryName);
	}
	@Override
	public Category findCategoryByName(String categoryName) throws SQLException {
		String sql  = "select categories,categoriesname,categoriesnumber from category where categoriesname=?";
		return (Category) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Category category = null;
				if(rs.next())
				{
					category = new Category();
					category.setCategories(rs.getInt(1));
					category.setCategoriesName(rs.getString(2));
					category.setCategoriesNumber(rs.getInt(3));
				}
				return category;
			}
		}, categoryName);
		
	}
	@Override
	public Category findCategoryById(int categoryId) throws SQLException {
		String sql = "select categories,categoriesname,categoriesnumber from category where categories=?";
		return(Category)jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Category category = null;
				if(rs.next())
				{
					category = new Category();
					category.setCategories(rs.getInt(1));
					category.setCategoriesName(rs.getString(2));
					category.setCategoriesNumber(rs.getInt(3));
				}
				return category;
			}
		}, categoryId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategory() throws SQLException {
		String sql = "select categories,categoriesname,categoriesnumber from category";
		return (List<Category>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Category> categories  = new ArrayList<Category>();
				Category category = null;
				while(rs.next())
				{
					category = new Category();
					category.setCategories(rs.getInt(1));
					category.setCategoriesName(rs.getString(2));
					category.setCategoriesNumber(rs.getInt(3));
					categories.add(category);
				}
				return categories;
			}
		});
		
	}
}
