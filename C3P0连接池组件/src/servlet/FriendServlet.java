package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.PageRoll;
import dao.FriendDao;
import dao.impl.FriendDaoImpl;
import entity.Friend;

/**
 * Servlet implementation class FriendServlet
 */
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FriendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//操作验证
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String method = request.getParameter("method");
		if("list".equals(method))
		{
			list(request, response);
			
		}
		else if("findAll".equals(method))
		{
			findAll(request, response);
		}
		else if("find".equals(method))
		{
			find(request, response);
		}
		else if ("update".equals(method)) {
			update(request, response);
		}
		else if("add".equals(method))
		{
			add(request, response);
		}
		else if("delete".equals(method))
		{
			delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

	/*
	 * --------------自定义的业务逻辑控制方法-------------
	 * 
	 */
	//添加操作
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端数据
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String signture = request.getParameter("signature");
		//封装对象
		Friend f = new Friend( name,sex,signture);
		//调用业务逻辑处理
		FriendDao dao =new FriendDaoImpl();
		
		try {
			dao.save(f);
			//响应客户端
			response.sendRedirect(request.getContextPath()+"/FriendServlet?method=findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//修改操作
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端数据
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				String signture = request.getParameter("signature");
				//封装对象
				Friend f = new Friend( Integer.parseInt(id),name,sex,signture);
				//调用业务逻辑处理
				FriendDao dao =new FriendDaoImpl();
				
				try {
					dao.update(f);
					//响应客户端
					response.sendRedirect(request.getContextPath()+"/FriendServlet?method=findAll");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	//删除操作
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FriendDao dao = new FriendDaoImpl();
		try {
			dao.delete(Integer.parseInt(id));
			response.sendRedirect(request.getContextPath()+"/FriendServlet?method=findAll");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//根据ID查找操作
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FriendDao dao = new FriendDaoImpl();
		try {
			Friend f = dao.findById(Integer.parseInt(id));
			request.setAttribute("friend", f);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查找所有操作 
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendDao dao = new FriendDaoImpl();
		try {
			List<Friend> list = dao.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//分页查询 列表
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//当前页需要从客户端传过来
		//获取当前页
		String currPage = request.getParameter("currPage");
		
		//构造分页组件
		PageRoll pageRoll = new PageRoll();
		
		if(currPage!=null)
		{
			pageRoll.setCurrPage(Integer.parseInt(currPage));
			
		}
		FriendDao dao = new FriendDaoImpl();
		try {
			List<Friend> list = dao.list(pageRoll);
			request.setAttribute("list", list);
			request.setAttribute("pageRoll",pageRoll);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
