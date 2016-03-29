package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.dao.factory.DaoFactory;
import com.ben.vo.Administrator;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String adminName = request.getParameter("adminname");
		String adminPassword = request.getParameter("adminpassword");
		Administrator administrator = null;
		PrintWriter out = response.getWriter();
		String href = "";
		
		try {
			administrator = DaoFactory.getAdminDao().findByAdminName(adminName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(administrator==null)
		{
			
			href = request.getContextPath()+"/view/share/admin/adminlogin.jsp";
			out.println("<script language='javascript'>alert('账户不存在');"
					+"window.location.href='"+href+"';</script>");
		}
		else if(adminPassword.equals(administrator.getAdbPassword()))
		{
			response.sendRedirect(request.getContextPath()+"/view/share/admin/admindo.jsp");
			request.getSession().setAttribute("admin", administrator);
		}
		else {
			href = request.getContextPath()+"/view/share/admin/adminlogin.jsp";
			out.println("<script language='javascript'>alert('密码错误');"
					+"window.location.href='"+href+"';</script>");
		}
		
	}


}
