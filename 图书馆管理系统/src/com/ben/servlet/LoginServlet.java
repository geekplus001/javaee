package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ben.dao.factory.DaoFactory;
import com.ben.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("userpassword");
		String href = "";
		User user = null;
		
		try {
			user = DaoFactory.getUserDao().findUserByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user==null)
		{
			href = request.getContextPath()+"/view/share/users/login.jsp";
			out.println("<script language='javascript'>alert('用户名不存在');"
			    	+ "window.location.href='"+ href + "';</script>");
			//request.getRequestDispatcher(request.getContextPath()+"/view/share/users/login.jsp").forward(request, response);
		}
		else
		{
			if(user.getUserPassword().equals(userPassword))
			{
				String cookiee = request.getParameter("cookiee");
				if("1".equals(cookiee))
				{
					
					
					Cookie nameCookie = new Cookie("usernameb",URLEncoder.encode(userName, "utf-8"));
					nameCookie.setMaxAge(60*60*24*7);
					Cookie pwdCookie = new Cookie("userpasswordb",URLEncoder.encode(userPassword, "utf-8"));
					pwdCookie.setMaxAge(60*60*24*7);
					response.addCookie(nameCookie);
					response.addCookie(pwdCookie);
				}
//				List<Category> categories;
//				List<Book> books;
				try {
					user = DaoFactory.getUserDao().findUserByUserName(userName);
					request.getSession().setAttribute("user", user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect(request.getContextPath()+"/view/share/page/realpage.jsp");
				
				
				
			}
			else 
			{
				
				href = request.getContextPath()+"/view/share/users/login.jsp";
				out.println("<script language='javascript'>alert('密码错误');"
				    	+ "window.location.href='"+ href + "';</script>");
			}
		}
		
	}

}
