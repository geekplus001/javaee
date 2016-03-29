package orders.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.dao.factory.DAOFactory;
import orders.vo.Order;
import orders.vo.User;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("list".equals(method))
		{
			list(request,response);
		}
		else if ("add".equals(method)) {
			add(request,response);
		}
		else if ("search".equals(method)) {
			search(request,response);
		}
		else if ("delete".equals(method)) {
			delete(request,response);
		}
	}
	//删除订单
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String orderid = request.getParameter("id");
		try {
			DAOFactory.getOrderDAO().deleteById(Integer.valueOf(orderid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/servlet/OrderServlet?method=list.jsp");
	}
	//订单查询
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String ordercode = request.getParameter("ordercode");
		String deliverymethod = request.getParameter("deliverymethod");
		
		Double sum = null;
		if(sum!=null && !"".equals(sum))
		{
			sum = Double.parseDouble(request.getParameter("sum"));
			
		}
		List<Order> orderlist = null;
		try {
			orderlist = DAOFactory.getOrderDAO().search(ordercode,sum,deliverymethod);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("orderlist",orderlist);
		request.getRequestDispatcher("/view/orders/orderManagar/list.jsp").forward(request,response);
	}
	//添加订单功能
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//从客户端请求数据
		String ordercode = request.getParameter("ordercode");
		String deliverymethod = request.getParameter("deliverymethod");
		//封装请求数据
		Order order = new Order();
		order.setOrderCode(ordercode);
		order.setDeliveryMethod(deliverymethod);
		User user = (User)request.getSession(false).getAttribute("#user#");
		order.setSum(0.0);
		order.setCreateDate(new java.util.Date());
		order.setLastModifyDate(new java.util.Date());
		try {
			DAOFactory.getOrderDAO().save(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/servlet/OrderServlet?method=list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		User user = (User) request.getSession().getAttribute("#user#");
		
		if(user==null)
		{
			response.sendRedirect(request.getContextPath()+"/view/share/login/login.jsp");
		}
		else
		{
			List<Order> orderlist = null;
			try {
				orderlist = DAOFactory.getOrderDAO().findByBuyer(user.getUsername());
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("orderlist", orderlist);
			request.getRequestDispatcher("view/orders/orderManager/list.jsp").forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
