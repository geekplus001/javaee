<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dao.TeacherDao,dao.impl.TeacherDaoImpl,model.Teacher" %>
<%
	//处理修改业务逻辑
	request.setCharacterEncoding("utf-8");
	//接受请求数据
	String tid = request.getParameter("tid");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String description = request.getParameter("description");
	
	//封装请求数据
	Teacher t = new Teacher(Integer.parseInt(tid),name,description,Integer.parseInt(age));
	TeacherDao dao = new TeacherDaoImpl();
	try{
		dao.update(t);
		response.sendRedirect("list_handler.jsp");
	}catch(SQLException e){
		e.printStackTrace();
	}
%>