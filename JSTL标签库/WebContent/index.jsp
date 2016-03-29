<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setAttribute("name", "结衣");
%>
</head>
<body>
	<%--输出标签 --%>
	<c:out value="${requestScope.name }"></c:out>
	<%--定义变量标签 --%>
	<c:set var = "age" value = "18"></c:set>
	
	${age }
</body>
</html>