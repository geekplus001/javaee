package dao;
//data access object
import java.sql.SQLException;

import domain.Person;

public interface PersonDAO {
	
	public void add(Person p) throws SQLException;
		
	public void update(Person p )throws SQLException;
	
	public void delete(int id)throws SQLException;
	
	public Person findById(int id)throws SQLException;
	
	//查找所有
	public java.util.List<Person> findAll() throws SQLException;
	
	//查询所有记录
	public long personCount()throws SQLException;
}
