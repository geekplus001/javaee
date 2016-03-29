package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.ResultSetHandler;
import dao.PersonDAO;
import db.DBUtils;
import db.JdbcTemplate;
import domain.Person;
/*
 * PersonDAO的具体实现类
 */
public class PersonDAOImpl  implements PersonDAO{

	private JdbcTemplate jdbcTenplete;
	
    public PersonDAOImpl() {
		jdbcTenplete = new JdbcTemplate();
	}
	/*
	 * 实现添加的方法
	 * @see dao.PersonDAO#add(domain.Person)
	 */
	@Override
	public void add(Person p) throws SQLException {
	
		String sql = "insert into person(name,age ,description)value(?,?,?)";
		jdbcTenplete.update(sql, p.getName(),p.getAge(),p.getDescription());
	}

	@Override
	public void update(Person p) throws SQLException {
		
		String sql = "update person set name=?,age=?,description=? where id = ?";
		jdbcTenplete.update(sql, p.getName(),p.getAge(),p.getDescription());
	
	}

	@Override
	public void delete(int id) throws SQLException {
		
		String sql = "delete from person where id = ?";
		jdbcTenplete.update(sql, id);
	}

	@Override
	public Person findById(final int id) throws SQLException {
		
		String sql = "select name,age,description from person where id = ?";
		return (Person)jdbcTenplete.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException{
				Person p = new Person();
				if(rs.next())
				{
					p = new Person();
					p.setId(id);
					p.setName(rs.getString(1));
					p.setAge(rs.getInt(2));
					p.setDescription(rs.getString(3));
				}
				return p;
			}
		}, id);
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() throws SQLException {
		
		String sql = "select id,name,age,description from person";
		return (List<Person>)jdbcTenplete.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Person> persons = new ArrayList<Person>();
				Person p =null;
				while(rs.next())
				{
					p = new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAge(rs.getInt(3));
					p.setDescription(rs.getString(4));
					persons.add(p);
				}
			
				return persons;
			}
		});
		
	}

}
