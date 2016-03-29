<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.TeacherDao,dao.impl.TeacherDaoImpl,model.Teacher" %>
<%
	//从请求对象中获取客户端发送过来的数据
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String description = request.getParameter("description");
	
	//封装请求数据并调用添加业务
	Teacher t = new Teacher(name,description,Integer.parseInt(age));
	TeacherDao dao = new TeacherDaoImpl();
	
	try{
		dao.add(t);
		response.sendRedirect("list_handler.jsp");
	}catch(SQLException e){
		e.printStackTrace();
		
	}
	
%>