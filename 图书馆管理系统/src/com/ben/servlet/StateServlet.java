package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StateServlet
 */
public class StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		String href = "";
		PrintWriter out = response.getWriter();
		href = request.getContextPath()+"/index.jsp";
		out.println("<script language='javascript'>alert('登录超时');"
		    	+ "window.location.href='"+ href + "';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
