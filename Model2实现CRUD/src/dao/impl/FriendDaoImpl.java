package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.ResultSetHandler;
import dao.FriendDao;
import db.JdbcTemplate;
import entity.Friend;

public class FriendDaoImpl implements FriendDao {

	private JdbcTemplate jdbcTemplate;
	public FriendDaoImpl() {
		jdbcTemplate = new JdbcTemplate();
	}
	@Override
	public void save(Friend f) throws SQLException {
		String sql = "insert into friend_tab(name,sex,signature) values(?,?,?)";
		jdbcTemplate.update(sql, f.getName(),f.getSex(),f.getSignature());
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from friend_tab where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Friend f) throws SQLException {
		String sql = "update friend_tab set name = ?,sex = ?,signature = ? where id = ?";
		jdbcTemplate.update(sql, f.getName(),f.getSex(),f.getSignature(),f.getId());
	}

	@Override
	public Friend findById(int id) throws SQLException {
		String sql = "select id,name,sex,signature from friend_tab where id = ?";
		return (Friend) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Friend f = null;
				if(rs.next())
				{
					f = new Friend();
					f.setId(rs.getInt(1));
					f.setName(rs.getString(2));
					f.setSex(rs.getString(3));
					f.setSignature(rs.getString(4));
				}
				return f;
			}
		}, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> findAll() throws SQLException {
		String sql = "select id,name,sex,signature from friend_tab";
		return (List<Friend>) jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Friend> list = new ArrayList<Friend>();
				Friend f = null;
				while(rs.next())
				{
					f = new Friend();
					f.setId(rs.getInt(1));
					f.setName(rs.getString(2));
					f.setSex(rs.getString(3));
					f.setSignature(rs.getString(4));
					list.add(f);
				}
				return list;
			}
		});
	}

}
