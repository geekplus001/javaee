<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取请求数据
	//设置post请求方式的编码
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	String [] likes = request.getParameterValues("likes");
	for(int i = 0;i<likes.length;i++)
	{
		System.out.print(likes[i]);
	}
	if("xb".equals(name)&&"123".equals(pwd))
	{
		request.setAttribute("sex", "男");
		//out.print("登陆成功");
		request.getRequestDispatcher("request-success.jsp").forward(request,response);
	}
	else{
		//out.println("登陆失败");
		response.setCharacterEncoding("UTF-8");//设置响应的编码
		//设置内容类型
		response.setContentType("text/html;charset UTF-8");
		response.sendRedirect("response.jsp");//页面跳转，重定向
	}
%>