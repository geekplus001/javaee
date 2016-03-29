package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.ResultSetHandler;
import dao.TeacherDao;
import db.JdbcTemplate;
import model.Teacher;
/*
 * DAO的实现类
 */
public class TeacherDaoImpl implements TeacherDao {

	private JdbcTemplate jdbcTemplate;
	public TeacherDaoImpl() {
		jdbcTemplate  = new JdbcTemplate();
	}
	/*
	 * 添加操作(non-Javadoc)
	 * @see dao.TeacherDao#add(model1.Teacher)
	 */
	@Override
	public void add(Teacher t) throws SQLException {
		String sql = "insert into teacher(name,description,age)value(?,?,?)";
		jdbcTemplate.update(sql, t.getName(),t.getDescription(),t.getAge());
	}

	@Override
	public void delete(int tid) throws SQLException {
		String sql = "delete from teacher where tid = ?";
		jdbcTemplate.update(sql, tid);
	}

	@Override
	public void update(Teacher t) throws SQLException {
		String sql = "update teacher set name = ?,description = ?,age = ? where tid=?";
		jdbcTemplate.update(sql, t.getName(),t.getDescription(),t.getAge(),t.getTid());
	}

	@Override
	public Teacher findById(final int tid) throws SQLException {
		String sql = "select name,description,age from teacher where tid = ?";
		return	(Teacher)jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Teacher t = null;
				if(rs.next())
				{
					t = new Teacher();
					t.setTid(tid);
					t.setName(rs.getString(1));
					t.setDescription(rs.getString(2));
					t.setAge(rs.getInt(3));
				}
				return t;
			}
		}, tid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAll() throws SQLException {
		String sql = "select tid,name,description,age from teacher";
		
		return	(List<Teacher>)jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Teacher> teachers = new ArrayList<Teacher>();
				Teacher t = null;
				while(rs.next())
				{
					t = new Teacher();
					t.setTid(rs.getInt(1));
					t.setName(rs.getString(2));
					t.setDescription(rs.getString(3));
					t.setAge(rs.getInt(4));
					teachers.add(t);
				}
				return teachers;
			}
		});
	}

}
