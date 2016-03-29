<%@page import="bean.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	session.setAttribute("user", "小白");


	user u = new user();
	u.setName("小黑");
	u.setSex("男");
	session.setAttribute("userbean", u);
%>
</head>
<body>
	<%-- EL表达式语法 --%>
	${10+5}
	<%
		String user = (String)session.getAttribute("user");
			
	%>
	<%=user %>
	<%--EL表达式从session中取值 --%>
	user name:${sessionScope.user}
	<br/><br/>
	
	<%--EL表达式的. [] 用法 --%>
	userbean sex 点运算符:${sessionScope.userbean.sex }
	<br/>
	userbean sex 中括号运算符:${sessionScope.userbean["sex"] }
	<br/>
	userbean 是否为空:${empty sessionScope.userbean }
	<br/>
	<%--EL表达式的隐含对象 --%>
	<%--request.setCharacterEncoding("utf-8"); --%>
	根路径：${pageContext.request.contextPath }
	<br/>
	
	
	<%
		Cookie c = new Cookie("username","admin");
		response.addCookie(c);
		
		Cookie[] cookies = request.getCookies();
		
	
	%>
	Cookie username = ${cookie.username.value }
</body>
</html>