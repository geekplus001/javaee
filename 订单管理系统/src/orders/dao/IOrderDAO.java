package orders.dao;

import java.util.List;

import orders.vo.Order;
import orders.vo.OrderItem;

public interface IOrderDAO {
	public void save(Order order) throws Exception;
	
	public void save(OrderItem orderItem) throws Exception;
	
	public void update(Order order)throws Exception;
	
	public void updateSum(Integer id) throws Exception;
	
	public void deleteById(Integer id) throws Exception;
	
	public Order findById(Integer id) throws Exception;
	
	public List<Order> findByBuyer(String username) throws Exception;
	
	public List<Order> search(String ordercode,Double sum,String deliverymethod) throws Exception;

	
}
