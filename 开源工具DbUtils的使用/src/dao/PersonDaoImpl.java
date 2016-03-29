package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import db.DBUtils;
import domain.Person;

public class PersonDaoImpl implements PersonDAO {

	private QueryRunner runner = null;
	public PersonDaoImpl() {
		runner = new QueryRunner();
	}
	@Override
	public void add(Person p) throws SQLException {
		String sql = "insert into person(name,age,description)values(?,?,?)";
		runner.update(DBUtils.getConnection(),sql,p.getName(),p.getAge(),p.getDescription());
		
	}

	@Override
	public void update(Person p) throws SQLException {
		String sql = "update person set name = ?,age = ?,description = ? where id = ?";
		runner.update(DBUtils.getConnection(),sql,p.getName(),p.getAge(),p.getDescription(),p.getId());
		
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from person where id = ?";
		runner.update(DBUtils.getConnection(),sql, id);
	}

	@Override
	/*
	 * 使用beanHandler查询一个对象(non-Javadoc)
	 * @see dao.PersonDAO#findById(int)
	 */
	public Person findById(int id) throws SQLException {
		String sql = "select name,age,description from person where id = ?";
		Person p = runner.query(DBUtils.getConnection(), sql,
				new BeanHandler<Person>(Person.class),id);
		return p;
	}

	@Override
	public List<Person> findAll() throws SQLException {
		String sql  = "select name,age,description from person";
		List<Person> persons = runner.query(DBUtils.getConnection(), sql,
				new BeanListHandler<Person>(Person.class));
		return persons;
	}
	
	@Override
	public long personCount() throws SQLException
	{
		String sql = "select count(id) from person";
		return (long) runner.query(DBUtils.getConnection(),sql, new ScalarHandler<Long>());
	}

}
