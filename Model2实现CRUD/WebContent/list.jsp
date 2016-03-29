<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>好友列表</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Sex</th>
			<th>Signature</th>
			<th>操作</th>
		</tr>
		<c:forEach items = "${requestScope.list }" var = "friend"> 
			<tr>
				<td>${friend.id }</td>
				<td>${friend.name }</td>
				<td>${friend.sex }</td>
				<td>${friend.signature }</td>
				<td>
					<a href = "FriendServlet?method=find&id=${friend.id }">修改</a>|
					<a href = "FriendServlet?method=delete&id=${friend.id }">删除</a>|
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan  = "4"><a href = "new.jsp">添加</a></td>
		</tr>
	</table>
</body>
</html>