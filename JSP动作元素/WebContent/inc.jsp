<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--JSP注释 --%>
	<%
		out.println("征婚启事：1、活的 2、女的 ");
		//request  表示请求对象
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		out.print("<br/>"+name+age);
	%>
</body>
</html>