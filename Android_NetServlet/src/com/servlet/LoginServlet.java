package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//{"login":"success","user":[{"id":1,"username":"ben","password":"123","role":"admin"}]}
		if("ben".equals(username)&&"123".equals(password))
		{
			User user = new User(1,"ben","123","admin");
			JsonObject jo = new JsonObject();
			jo.getUser().add(user);
			jo.setLogin("success");
			Gson gson = new Gson();
			String json = gson.toJson(jo);
			out.println(json.toString());
		}
		else
		{
			//{"login":"error"}
			String json = "{\"login\":\"error\"}";
			out.println(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
