package com.ben.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.dao.factory.DaoFactory;
import com.ben.vo.Book;

/**
 * Servlet implementation class BookDetailServlet
 */
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookDetailServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String bName = request.getParameter("bookname");
//		String bName = request.getParameter("search");
		try {
			Book bookdetail = DaoFactory.getBookDao().findBookByBookName(bName);
			request.getSession().setAttribute("bookdetail", bookdetail);
			response.sendRedirect(request.getContextPath()+"/view/share/book/bookdetail.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
