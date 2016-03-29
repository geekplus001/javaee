package dao;
//data access object
import java.sql.SQLException;

import domain.Person;

public interface PersonDAO {
	
	public void add(Person p) throws SQLException;
		
	public void update(Person p )throws SQLException;
	
	public void delete(int id)throws SQLException;
	
	public Person findById(int id)throws SQLException;
	
	//≤È’“À˘”–
	public java.util.List<Person> findAll() throws SQLException;
}
