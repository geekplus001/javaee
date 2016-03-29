package com.ben.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ben.vo.Book;
import com.ben.vo.User;

public class PageFilter implements Filter {

    public PageFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		ArrayList<Book> books = new ArrayList<>();
		books = (ArrayList<Book>) session.getAttribute("books");
		String href = "";
		PrintWriter out = response.getWriter();
//		httpServletRequest.getRequestURL(); 
//		String path = httpServletRequest.getServletPath() ;
//		String path2 = httpServletRequest.getContextPath()+"/index.jsp";
//		if(path.equals(path2))
//		{
//			return;
//		}else 
		if(books.isEmpty())
		{
//			href = httpServletRequest.getContextPath()+"/index.jsp";
//			out.println("<script language='javascript'>alert('连接超时');"
//			    	+ "window.location.href='"+ href + "';</script>");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/StateServlet");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
