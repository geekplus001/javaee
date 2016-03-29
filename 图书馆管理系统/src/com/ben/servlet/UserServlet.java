package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ben.dao.factory.DaoFactory;
import com.ben.vo.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userFlag = request.getParameter("userFlag");
		if("save".equals(userFlag))
		{
			try {
				savaUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("update".equals(userFlag))
		{
			updateUser(request,response);
		}else if("list".equals(userFlag))
		{
			lookUser(request,response);
		}else if("find".equals(userFlag))
		{
			findUser(request,response);
		}
	}

	private void findUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("ccc");
		try {
			User user = DaoFactory.getUserDao().findUserByUserName(userName);
			if(user!=null)
			{
				out.println("<font color='red'>用户名已存在</font>");
			}
			else
			{
				out.println("<font color='green'>用户名可用</font>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void lookUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<User> users = null;
		try {
			users = DaoFactory.getUserDao().findAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("users", users);
		response.sendRedirect(request.getContextPath()+"/view/share/admindo/userdo.jsp");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String oldPassword = request.getParameter("oldpassword");
		User user = (User) request.getSession().getAttribute("user");
		String newPassword1 = request.getParameter("newpassword1");
		String newPassword2 = request.getParameter("newpassword2");
		Integer newAge = Integer.parseInt(request.getParameter("age"));
		String newSex = request.getParameter("sex_select");
		String newIntro = request.getParameter("intro");
	
		User newUser = null;
		String href = null;
		PrintWriter out = response.getWriter();
		if(oldPassword=="")
		{
			href = request.getContextPath()+"/view/share/users/updateuser.jsp";
			out.println("<script language='javascript'>alert('旧密码不能为空');"
			    	+ "window.location.href='"+ href + "';</script>");
		}
		else 
		{
			if((user.getUserPassword()).equals(oldPassword))
			{
				if(newPassword1=="")
				{

					newUser = new User();
					newUser.setUserNumber(user.getUserNumber());
					newUser.setUserName(user.getUserName());
					newUser.setUserPassword(user.getUserPassword());
					newUser.setUserAge(newAge);
					newUser.setUserSex(newSex);
					newUser.setUserIntro(newIntro);
					try {
						DaoFactory.getUserDao().updateUser(newUser);
						request.getSession().setAttribute("user", newUser);
						href = request.getContextPath()+"/view/share/users/userinfo.jsp";
						out.println("<script language='javascript'>alert('资料更改成功');"
						    	+ "window.location.href='"+ href + "';</script>");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					if(newPassword1.equals(newPassword2))
					{
						newUser = new User();
						newUser.setUserNumber(user.getUserNumber());
						newUser.setUserName(user.getUserName());
						newUser.setUserPassword(newPassword1);
						newUser.setUserAge(newAge);
						newUser.setUserSex(newSex);
						newUser.setUserIntro(newIntro);
						try {
							DaoFactory.getUserDao().updateUser(newUser);
							request.getSession().setAttribute("user", newUser);
							href = request.getContextPath()+"/view/share/users/userinfo.jsp";
							out.println("<script language='javascript'>alert('资料修改成功');"
							    	+ "window.location.href='"+ href + "';</script>");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						href = request.getContextPath()+"/view/share/users/updateuser.jsp";
						out.println("<script language='javascript'>alert('两次新密码不一致');"
						    	+ "window.location.href='"+ href + "';</script>");
					}
				}
			}
			else
			{
				href = request.getContextPath()+"/view/share/users/updateuser.jsp";
				out.println("<script language='javascript'>alert('密码错误');"
				    	+ "window.location.href='"+ href + "';</script>");
			}
		}
	}

	private void savaUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String userPassword1 = request.getParameter("userpassword1");
//		String userPassword2 = request.getParameter("userpassword2");
		String userName = request.getParameter("user_name");
		String userSex = request.getParameter("usersex");
		Integer userAge = Integer.parseInt(request.getParameter("tuserage"));
		String userIntro = request.getParameter("userintro");
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword1);
		user.setUserAge(userAge);
		user.setUserSex(userSex);
		user.setUserIntro(userIntro);
		String href = null;
		PrintWriter out = response.getWriter();
		User user3 = DaoFactory.getUserDao().findUserByUserName(userName);
		if(user3!=null)
		{
			href = request.getContextPath()+"/view/share/users/register.jsp";
			out.println("<script language='javascript'>alert('用户名已存在');"
			    	+ "window.location.href='"+ href + "';</script>");
		}
		else
		{
			try {
				DaoFactory.getUserDao().saveUser(user);
				User user2 = DaoFactory.getUserDao().findUserByUserName(userName);
				request.getSession().setAttribute("user", user2);
				response.sendRedirect(request.getContextPath()+"/view/share/page/realpage.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
