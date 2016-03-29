package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//从ServletContext上下文对象中取出在线用户列表
		List<String> users = null;
		Object obj = request.getServletContext().getAttribute("online");
		if(obj==null)
		{
			users = new ArrayList<String>();
			users.add(username);
			request.getServletContext().setAttribute("online", users);
		}
		else
		{
			users = (List<String>)obj;
			users.add(username);
		}
		//把在线用户列表保存到ServletContext中
		request.getSession().setAttribute("username", username);
		response.sendRedirect(request.getContextPath()+"/user.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
