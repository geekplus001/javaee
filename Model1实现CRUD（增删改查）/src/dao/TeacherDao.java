package dao;

import java.sql.SQLException;
import java.util.List;

import model.Teacher;
/*
 * DAO½Ó¿Ú
 */
public interface TeacherDao {
	public void add(Teacher t)throws SQLException;
	
	public void delete(int tid)throws SQLException;
	
	public void update(Teacher t)throws SQLException;
	
	public Teacher findById(int tid)throws SQLException;
	
	public List<Teacher> findAll()throws SQLException;
}
