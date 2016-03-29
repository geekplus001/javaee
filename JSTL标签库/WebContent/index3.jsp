<%@page import="vo.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	List<User> users = new ArrayList<User>();	
	User u1 = new User("小白","不定",18);
	User u2 = new User("依依","女",24);
	User u3 = new User("君君","女",23);
	users.add(u1);
	users.add(u2);
	users.add(u3);
	request.setAttribute("users", users);
%>
</head>
<body>
	<table border = "1">
		<tr>
			<th>name</th>
			<th>sex</th>
			<th>age</th>
			<th>状态值</th>
		</tr>
		<%--
			VarStatus状态：
			index 索引 从零开始
			count 从一开始 当前遍历次数
			current 当前正在迭代的对象
			first 是否第一个
			last 是否最后一个
		 --%>
		<tr>
			<c:forEach items = "${requestScope.users }" var = "user" varStatus = "status">
				<tr>
					<td>${user.name }</td>
					<td>${user.sex }</td>
					<td>${user.age }</td>
					<td>
						index:${status.index }<br/>
						count：${status.count }<br/>
						current：${status.current }<br/>
						first：${status.first }<br/>
						last：${status.last }<br/>
					</td>
				</tr>
			</c:forEach>
		</tr>

	</table>
	<br/><br/><br/>
		<c:set var = "likes" value = "吃饭，睡觉，泡妞"></c:set>
		<c:forTokens items="${likes }" delims="，" var = "val">
			${val }<br/>
		</c:forTokens>
</body>
</html>