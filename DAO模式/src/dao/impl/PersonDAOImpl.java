package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import db.DBUtils;
import domain.Person;
/*
 * PersonDAO的具体实现类
 */
public class PersonDAOImpl  implements PersonDAO{

	/*
	 * 实现添加的方法
	 * @see dao.PersonDAO#add(domain.Person)
	 */
	@Override
	public void add(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into person(name,age ,description)value(?,?,?)";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	@Override
	public void update(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update person set name=?,age=?,description=? where id = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from person where id = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	@Override
	public Person findById(int id) throws SQLException {
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		String sql = "select name,age,description from person where id = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				p = new Person();
				p.setId(id);
				p.setName(rs.getString(1));
				p.setAge(rs.getInt(2));
				p.setDescription(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("根据ID查询数据失败");
		}
		  finally{
		DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	@Override
	public List<Person> findAll() throws SQLException {
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		List<Person> persons = new ArrayList<Person>();
		String sql = "select name,age,description from person";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setDescription(rs.getString(4));
				persons.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据失败");
		}
		finally{
			DBUtils.close(rs, ps, conn);
			}

		return persons;
	}

}
