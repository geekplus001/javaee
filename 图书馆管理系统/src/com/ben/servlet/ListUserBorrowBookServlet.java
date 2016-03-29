package com.ben.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.dao.factory.DaoFactory;
import com.ben.vo.Borrow;
import com.ben.vo.User;

/**
 * Servlet implementation class ListUserBorrowBook
 */
public class ListUserBorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUserBorrowBookServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		User user = (User) request.getSession().getAttribute("user");
		try {
			List<Borrow> borrows = DaoFactory.getBorrowDao().findBorrowByLendUserName(user.getUserName());

			
			String time1 = null;
			int i;
			int [] fff = new int[borrows.size()];
			for(i=0;i<borrows.size();i++)
				fff[i] = 100000;
			for(i=0;i<borrows.size();i++)
			{
				if(borrows.get(i).getBorrowNumber()!=0)
				{
					if(borrows.get(i).getReturnDate()==null)
					{
						time1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
					}else {
						time1 = borrows.get(i).getReturnDate();
					}
					String[] time1s = time1.split("-");
					Integer time1s0 = Integer.parseInt(time1s[0]);
					Integer time1s1 = Integer.parseInt(time1s[1]);
//					Integer time1s2 = Integer.parseInt(time1s[2]);
					String time2 = null;
					time2 = borrows.get(i).getLendDate();
					String[] time2s = time2.split("-");
					Integer time2s0 = Integer.parseInt(time2s[0]);
					Integer time2s1 = Integer.parseInt(time2s[1]);
//					Integer time2s2 = Integer.parseInt(time2s[2]);
//					if(borrows.get(i).getReturnDate()==null)
//					{
						if(time1s0-time2s0>0 || time1s1-time2s1>2)
						{
							fff[i] = i;
						}
//					}
				}
				
			}
			
			request.getSession().setAttribute("fff", fff);
			request.getSession().setAttribute("borrows", borrows);
			response.sendRedirect(request.getContextPath()+"/view/share/users/userinfo.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
