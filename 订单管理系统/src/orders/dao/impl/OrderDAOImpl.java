package orders.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.bind.v2.model.core.ID;

import orders.dao.IOrderDAO;
import orders.utils.db.DBUtils;
import orders.vo.DiscountOrderItem;
import orders.vo.Order;
import orders.vo.OrderItem;
import orders.vo.PromotionOrderItem;

public class OrderDAOImpl implements IOrderDAO{

	@Override
	public void save(Order order) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into torder(ordercode,buyer,deliverymethod,sum,createddate,lastmodifydate) values(?,?,?,?,?,?)";
		Connection conn = DBUtils.getConnection();
		runner.update(conn,sql,order.getOrderCode(),order.getBuyer(),
				order.getDeliveryMethod(),order.getSum(),
				new Date(order.getCreateDate()),
				new Date(order.getLastModifyDate()));
		conn.close();
	} 

	@SuppressWarnings("resource")
	@Override
	//更新订单总金额
	public void updateSum(Integer id) throws Exception {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Double sum = 0.0;
		String sql1 = "select sum(sum) as s from orderitem where orderid=?";
		String sql2 = "update torder set sum=? where orderid=?";
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				sum = rs.getDouble("s");
			}
			ps = conn.prepareStatement(sql2);
			ps.setDouble(1, sum);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw new Exception("修改编号为");
		}
		finally
		{
			DBUtils.close(null, ps, conn);
		}
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from torder where orderid=?";
		Connection conn = DBUtils.getConnection();
		runner.update(conn,sql,id);
		conn.close();
	}

	@Override
	public Order findById(Integer id) throws Exception {
		String sql = "select orderid,ordercode,deliverymethod,sum,createddate,lastmodifydate from torder where id=?";
		Connection conn = DBUtils.getConnection();
		Order order = runner.query(conn,sql,new BeanListHandler<Order>(Order.class),id);
		conn.close();
		return order;
	}

	@Override
	public List<Order> findByBuyer(String username) throws Exception {
		String sql = "select orderid,ordercode,deliverymethod,sum,lastmodifydate from torder where buyer=?";
		Connection conn = DBUtils.getConnection();
		List<Order> orders = runner.query(conn,sql,new BeanListHandler<Order>(Order.class),username);
		conn.close();
		return orders;
	}

	@Override
	public List<Order> search(String ordercode, Double sum, String deliverymethod) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("select orderid,ordercode,deliverymethod,sum,lastmodifydate from torder where 1=1");
		if(ordercode!=null && !"".equals(ordercode))
		{
			sql.append(" and ordercode like '%");
			sql.append(ordercode);
			sql.append("%'");
		}
		if(sum!=null)
		{
			sql.append(" and sum=");
			sql.append(sum);
		}
		if(deliverymethod != null && !"".equals(ordercode))
		{
			sql.append(" and deliverymethod='");
			sql.append(deliverymethod);
			sql.append("'");
		}
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next())
			{
				Order order =  new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderCode(rs.getString(2));
				order.setDeliveryMethod(rs.getString(3));
				order.setSum(rs.getDouble(4));
				order.setLastModifyDate(rs.getDate(5));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("条件查询订单列表失败");
		}
		finally
		{
			DBUtils.close(rs, ps, conn);
		}
		return orders;
	}

	@Override
	public void update(Order order) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update torder set ordercode=?,deliverymethod=?,sum=?,lastmodifydate=?,ordercode=?";
		Connection conn = DBUtils.getConnection();
		runner.update(conn,sql,order.getOrderCode(),
				order.getDeliveryMethod(),order.getSum(),
				new Date(order.getLastModifyDate()),order.getOrderCode());
		conn.close();
	}

	/*
	 * 添加订单明细(non-Javadoc)
	 * @see orders.dao.IOrderDAO#save(orders.vo.OrderItem)
	 */
	@Override
	public void save(OrderItem orderItem) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		conn  = DBUtils.getConnection();
		//有折扣
		if(orderItem.getDiscountType()==2)
		{
			DiscountOrderItem ditem = (DiscountOrderItem) orderItem;
			sql.append("insert into orderitem(orderid,name,discounttype,unitnum,unitprice,sum,discount) values(?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, ditem.getOrderId());
			ps.setString(2, ditem.getName());
			ps.setInt(3, ditem.getDiscountType());
			ps.setInt(4, ditem.getUnitNum());
			ps.setDouble(5, ditem.getUnitPrice());
			ps.setDouble(6, ditem.getSum());
			ps.setDouble(7, ditem.getDidcount());
		}
		//促销
		else if(orderItem.getDiscountType()==3)
		{
			PromotionOrderItem piItem = (PromotionOrderItem)orderItem;
			sql.append("insert into orderitem(orderid,name,didcounttype,unitnum,unitprice,sum,promotionprice,promotionnum) values(?,?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, piItem.getOrderId());
			ps.setString(2, piItem.getName());
			ps.setInt(3, piItem.getDiscountType());
			ps.setInt(4, piItem.getUnitNum());
			ps.setDouble(5, piItem.getUnitPrice());
			ps.setDouble(6, piItem.getSum());
			ps.setDouble(7, piItem.getPromotionPrice());
			ps.setInt(8, piItem.getPromotionNum());
		}
		else {
				sql.append("insert into orderitem(orderid,name,discounttype,unitnum,unitprice,sum) values(?,?,?,?,?,?)");
				ps = conn.prepareStatement(sql.toString());
				ps.setInt(1, orderItem.getOrderId());
				ps.setString(2,orderItem.getName());
				ps.setInt(3, orderItem.getDiscountType());
				ps.setInt(4, orderItem.getUnitNum());
				ps.setDouble(5, orderItem.getUnitPrice());
				ps.setDouble(6, orderItem.getSum());
		}
		
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("添加订单明细列表失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
}
