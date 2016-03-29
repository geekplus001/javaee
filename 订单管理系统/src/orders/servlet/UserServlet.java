package orders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.dao.factory.DAOFactory;
import orders.vo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String method = request.getParameter("method");
		if("updatePass".equals(method))
		{
			updatePass(request,response);
		}
	}

	private void updatePass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession(false).getAttribute("#user#");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(user==null)
		{
			response.sendRedirect(request.getContextPath()+"/view/share/login/login.jsp");
		}
		else
		{
			String old_pass = request.getParameter("old_pass");
			String new_pass = request.getParameter("new_pass");
			
			if(!old_pass.equals(user.getPassword()))
			{
				out.println("<script>");
				out.println("alert('旧密码不正确')");
				out.println("window.location.href='"+request.getContextPath()+"/view/orders/userManager/set_pass/jsp'");
				out.println("<script>");
			}
			else
			{
				user.setPassword(new_pass);
				try {
					DAOFactory.getUserDAO().update(user);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				out.println("<script>");
				out.println("alert('密码修改完成')");
				out.println("window.location.href='"+request.getContextPath()+"/servlet/OrderServlet'");
				out.println("<script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
