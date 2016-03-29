<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	if("admin".equals(name) && "123".equals(pwd)){
		//把用户名保存到当前会话对象中
		System.out.println(session.getId());
		//设置有效时间(30分钟)
		//session.setMaxInactiveInterval(1000*60*30);
		session.setAttribute("name", name);
		response.sendRedirect("session-success.jsp");
		
	}
	else{
		response.sendRedirect("response.jsp");
	}
%>