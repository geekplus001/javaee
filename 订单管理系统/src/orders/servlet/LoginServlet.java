package orders.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.vo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = DAOFactory.getUserDAO.login(username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user==null)
		{
			response.sendRedirect(request.getContextPath()+"/view/share/error/loginerror.jsp");
		}
		else
		{
			request.getSession().setAttribute("#user#", user);
			response.sendRedirect(request.getContextPath()+"/servlet/OrderServlet?method=list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
