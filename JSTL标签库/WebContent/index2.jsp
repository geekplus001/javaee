<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setAttribute("name", "菜利");
%>
</head>
<body>
	<%--流程控制 标签 --%>
	
	<c:if test="${not empty requestScope.name }">
		欢迎你，${requestScope.name }
	</c:if>
	
	
	<c:set var = "age" value = "18"></c:set>
	<c:choose>
		<c:when test="${age==18 }">和我一样大</c:when>
		<c:when test="${age<18 }">未成年</c:when>
		<c:when test="${age>18 }">欢迎光临</c:when>
		<c:otherwise>不适合</c:otherwise>
	</c:choose>
</body>
</html>