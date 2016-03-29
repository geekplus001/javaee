package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.dao.factory.DaoFactory;
import com.ben.vo.Book;
import com.ben.vo.Borrow;
import com.ben.vo.User;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.bcel.internal.generic.IREM;

/**
 * Servlet implementation class BorrowServlet
 */
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BorrowServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String borrowServlet = request.getParameter("borrowservlet");
		if("list".equals(borrowServlet))
		{
			listBorrowed(request,response);
		}else if("borrowing".equals(borrowServlet))
		{
			borrowing(request,response);
		}else if("returning".equals(borrowServlet))
		{
			returning(request,response);
		}else if("checkuser".equals(borrowServlet))
		{
			checkUser(request,response);
		}else if("renew".equals(borrowServlet))
		{
			renew(request,response);
		}
		
	}

	private void renew(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String href = "";
		PrintWriter out = response.getWriter();
		Integer lendId = Integer.parseInt(request.getParameter("lendnumber")); 
		try {
			Borrow borrow = DaoFactory.getBorrowDao().findBorrowByLendNumber(lendId);
			int renew = borrow.getRenew();
			if(renew==1)
			{
				href = request.getContextPath()+"/view/share/users/userinfo.jsp";
				out.println("<script language='javascript'>alert('每本书只能续借一次');"
						+"window.location.href='"+href+"';</script>");
			}
			else
			{
				if(borrow.getBorrowNumber()==0)
				{
					href = request.getContextPath()+"/view/share/users/userinfo.jsp";
					out.println("<script language='javascript'>alert('此书已归还');"
							+"window.location.href='"+href+"';</script>");
				}
				else {
					borrow.setLendDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
					borrow.setRenew(1);
					DaoFactory.getBorrowDao().renewing(borrow);
					href = request.getContextPath()+"/ListUserBorrowBookServlet";
					out.println("<script language='javascript'>alert('续借成功');"
							+"window.location.href='"+href+"';</script>");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String lendUser = request.getParameter("lenduser");
		String bookName = request.getParameter("bookname");
//		String tt = "";
		try {
			User user = DaoFactory.getUserDao().findUserByUserName(lendUser);
			Book book = DaoFactory.getBookDao().findBookByBookName(bookName);
		
			if(book==null)
			{
//				request.getSession().setAttribute("ffff", t);
				out.println("图书不存在");
			}
			else if(user==null)
			{
//				request.getSession().setAttribute("ffff", t);
				out.println("用户不存在");
			}
			else if(book.getBookStock()==0)
			{
				out.println("本书库存为0");
			}
			else
			{
				List<Borrow> borrows = DaoFactory.getBorrowDao().findBorrowByLendUserName(lendUser);
				if(borrows.size()>0)
				{
					
//					request.getSession().setAttribute("ffff", tt);
					String borrowPhone = borrows.get(0).getBorrowPhone();
					String borrowCard = borrows.get(0).getBorrowerCard();
					Integer credit = user.getUserCredit();
					if(credit>=3)
					{
						out.println(borrowPhone+"-"+borrowCard+"-"+"用户违约超三次");
					}
					else
					{
						out.println(borrowPhone+"-"+borrowCard);
					}
					
//					request.getSession().setAttribute("borrowPhone", borrowPhone);
//					request.getSession().setAttribute("borrowCard", borrowCard);		
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void returning(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String href = "";
		PrintWriter out = response.getWriter();
		String bookName = request.getParameter("bookname");
		String lendUser = request.getParameter("lenduser");
		String returnDate = request.getParameter("returndatee");
		String number = request.getParameter("number");
		Integer num = Integer.parseInt(number);
		String credit = request.getParameter("credit");
		int userCredit;
		try {
			ArrayList<Borrow> borrows = (ArrayList<Borrow>) DaoFactory.getBorrowDao().findBorrowByBorrowName(bookName, lendUser);
			if(borrows.isEmpty())
			{
				href = request.getContextPath()+"/view/share/admindo/returndo.jsp";
				out.println("<script language='javascript'>alert('用户名或书名错误');"
						+"window.location.href='"+href+"';</script>");
			}
			else {
					for(int i=0;i<borrows.size();i++)
					{
						if(borrows.get(i).getBorrowNumber()==0)
						{
							continue;
						}
						else
						{
							if("y".equals(credit))
							{
								User user = DaoFactory.getUserDao().findUserByUserName(lendUser);
								userCredit = user.getUserCredit()+1;
								DaoFactory.getUserDao().updateUserCredit(lendUser, userCredit);
							}
							borrows.get(i).setReturnDate(returnDate);
							borrows.get(i).setBorrowNumber(borrows.get(i).getBorrowNumber()-num);
							DaoFactory.getBorrowDao().updateBorrow(borrows.get(i));
							Book book = DaoFactory.getBookDao().findBookByBookName(bookName);
							book.setBookStock(book.getBookStock()+num);
							DaoFactory.getBookDao().updateBook(book);
							href = request.getContextPath()+"/view/share/admindo/returndo.jsp";
							out.println("<script language='javascript'>alert('还书成功');"
									+"window.location.href='"+href+"';</script>");
							break;
						}
					}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void borrowing(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		String href = "";
		PrintWriter out = response.getWriter();
		Borrow borrow  = new Borrow();
		String bookName = request.getParameter("bookname");
		String lendUser = request.getParameter("lenduser");
//		String lendDate = (String) request.getAttribute("lenddate");
		String lendDate = request.getParameter("lenddatee");
		String userPhone = request.getParameter("userphone");
		String userID = request.getParameter("userID");
		String number = request.getParameter("number");
		Integer num = Integer.parseInt(number);
		borrow.setLendBookName(bookName);
		borrow.setLendUser(lendUser);
		borrow.setLendDate(lendDate);
		borrow.setBorrowPhone(userPhone);
		borrow.setBorrowerCard(userID);
		borrow.setBorrowNumber(num);
		
		try {
			DaoFactory.getBorrowDao().saveBorrow(borrow);
			Book book = DaoFactory.getBookDao().findBookByBookName(bookName);
			href = request.getContextPath()+"/view/share/admindo/borrowdo.jsp";
			if(book==null)
			{
				out.println("<script language='javascript'>alert('图书不存在');"
						+"window.location.href='"+href+"';</script>");
			}
			book.setBookBorrowTime(book.getBookBorrowTime()+num);
			book.setBookStock(book.getBookStock()-num);
			DaoFactory.getBookDao().updateBook(book);
			
			out.println("<script language='javascript'>alert('借阅成功');"
					+"window.location.href='"+href+"';</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void listBorrowed(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		try {
			List<Borrow> borrowss = DaoFactory.getBorrowDao().findAllBorrow();
			
			String time1 = null;
			
				int i;
				int [] fla = new int[borrowss.size()];
				for(i=0;i<borrowss.size();i++)
					fla[i] = 100000;
				for(i=0;i<borrowss.size();i++)
				{
					if(borrowss.get(i).getBorrowNumber()!=0)
					{
						if(borrowss.get(i).getReturnDate()==null)
						{
							time1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
							
						}
						else {
							time1 = borrowss.get(i).getReturnDate();
						}
						String[] time1s = time1.split("-");
						Integer time1s0 = Integer.parseInt(time1s[0]);
						Integer time1s1 = Integer.parseInt(time1s[1]);
//						Integer time1s2 = Integer.parseInt(time1s[2]);
						String time2 = null;
						time2 = borrowss.get(i).getLendDate();
						String[] time2s = time2.split("-");
						Integer time2s0 = Integer.parseInt(time2s[0]);
						Integer time2s1 = Integer.parseInt(time2s[1]);
//						Integer time2s2 = Integer.parseInt(time2s[2]);
//						if(borrowss.get(i).getReturnDate()==null)
//						{
							if(time1s0-time2s0>0 || time1s1-time2s1>2)
							{
								fla[i] = i;
							}
//						}
					}
					
					
				}
			request.getSession().setAttribute("fla", fla);
			request.getSession().setAttribute("borrowss", borrowss);
			response.sendRedirect(request.getContextPath()+"/view/share/admindo/listborrowdo.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
