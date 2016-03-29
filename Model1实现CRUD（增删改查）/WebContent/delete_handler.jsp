<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dao.TeacherDao,dao.impl.TeacherDaoImpl,model.Teacher" %>
<%
	//接受请求数据
	String tid = request.getParameter("tid");
	
	TeacherDao dao = new TeacherDaoImpl();
	try{
		dao.delete(Integer.parseInt(tid));
		response.sendRedirect("list_handler.jsp");
	}catch(SQLException e){
		e.printStackTrace();
	}
%>