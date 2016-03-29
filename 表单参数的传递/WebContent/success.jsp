<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>正确信息</h2>
	<%
		String name = request.getParameter("name");
		//name = new String(name.getBytes("iso-8859-1"),"utf-8");
		name = URLDecoder.decode(name,"utf-8");
	%>
	欢迎你，<%=name%>
	
	<table border = "1">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>职业</th>
			<th>删除</th>
		</tr>
		<tr>
			<td>小白</td>
			<td>18</td>
			<td>演员</td>
			<td><a href = "#"></a></td>
		</tr>
		<tr>
			<td>威哥</td>
			<td>20</td>
			<td>非著名讲师</td>
			<td><a href = "#"></a></td>
		</tr>
		<tr>
			<td>苍老师</td>
			<td>29</td>
			<td>专业老师</td>
			<td><a href = "#"></a></td>
		</tr>
	</table>
</body>
</html>