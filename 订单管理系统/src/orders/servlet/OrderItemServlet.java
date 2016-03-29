package orders.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.dao.factory.DAOFactory;
import orders.vo.DiscountOrderItem;
import orders.vo.Order;
import orders.vo.OrderItem;
import orders.vo.PromotionOrderItem;

@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderItemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("item".equals(method))
		{
			item(request,response);
		}else if("add".equals(method))
		{
			add(request,response);
		}else if("delete".equals(method))
		{
			delete(request,response);
		}else if("view".equals(method))
		{
			view(request,response);
		}else if("update".equals(method))
		
		{
			update(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	//查看订单明细信息
	private void view(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String itemid = request.getParameter("itemid");
		OrderItem orderitem;
		try {
			orderitem = DAOFactory.getOrderItemDAO().findById(Integer.valueOf(itemid));
			request.setAttribute("item", orderitem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("/view/orders/orderItemManager").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
    //添加订单明细功能
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String discounttype = request.getParameter("discounttype");
		String unitnum = request.getParameter("unitnum");
		String sum = request.getParameter("sum");
		String unitprice = request.getParameter("unitprice");
		String discount = request.getParameter("discount");
		String promotionprice = request.getParameter("promotionprice");
		String promotionnum = request.getParameter("promotionnum");
		String orderid = request.getParameter("orderid");
		
		OrderItem orderItem = null;
		//有折扣
		if("2".endsWith(discounttype))
		{
			orderItem = new DiscountOrderItem();
			DiscountOrderItem ditem = (DiscountOrderItem)orderItem;
			ditem.setOrderId(Integer.valueOf(orderid));
			ditem.setName(name);
			ditem.setDiscountType(Integer.valueOf(discounttype));
			ditem.setSum(Double.valueOf(sum));
			ditem.setUnitNum(Integer.valueOf(unitnum));
			ditem.setUnitPrice(Double.valueOf(unitprice));
			ditem.setDidcount(Double.valueOf(discount));
		}
		//促销
		else  if("3".equals(discounttype)){
			orderItem = new PromotionOrderItem();
			PromotionOrderItem pitem = (PromotionOrderItem)orderItem;
			pitem.setOrderId(Integer.valueOf(orderid));
			pitem.setName(name);
			pitem.setDiscountType(Integer.valueOf(discounttype));
			pitem.setUnitNum(Integer.valueOf(unitnum));
			pitem.setUnitPrice(Double.valueOf(unitprice));
			pitem.setSum(Double.valueOf(sum));
			pitem.setPromotionNum(Integer.valueOf(unitnum));
			pitem.setPromotionPrice(Double.valueOf(unitprice));
		}
		//无折扣
		else {
			orderItem = new OrderItem();
			orderItem.setOrderId(Integer.valueOf(orderid));
			orderItem.setName(name);
			orderItem.setDiscountType(Integer.valueOf(discounttype));
			orderItem.setUnitNum(Integer.valueOf(unitnum));
			orderItem.setUnitPrice(Double.valueOf(unitprice));
			orderItem.setSum(Double.valueOf(sum));
			
		}
		try {
			//添加订单明细
			DAOFactory.getOrderItemDAO().save(orderItem);
			//更新订单的总金额
			DAOFactory.getOrderDAO().updateSum(Integer.valueOf(orderid));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.getRequestDispatcher("/servlet/OrderItemServlet？method=item").forward(request, response);
	}
	//查看订单详情
	private void item(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String orderid =  request.getParameter("id");
		try
		{
			Order order = DAOFactory.getOrderDAO().findById(Integer.valueOf(orderid));
			List<OrderItem> orderItems = DAOFactory.getOrderItemDAO().findByOrderId(Integer.valueOf(orderid));
			order.setOrderItems(orderItems);
			request.setAttribute("order",order);
			request.getRequestDispatcher("/view/orders/orderItemManager/list.jsp").forward(request,response);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
