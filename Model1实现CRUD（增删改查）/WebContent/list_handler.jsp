<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.TeacherDao,dao.impl.TeacherDaoImpl,model.Teacher"%>
<%
	TeacherDao dao = new TeacherDaoImpl();
	List<Teacher> teachers = dao.findAll();
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师信息列表</title>

</head>
<body>
	<h2>老师信息列表</h2>
	<div><a href = "new.jsp">添加</a></div>
	<table border = "1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<%
			for(int i=0;i<teachers.size();i++){
				Teacher t = teachers.get(i);
		%>
			
			<tr>
				<td><%=t.getTid() %></td>
				<td><%=t.getName() %></td>
				<td><%=t.getAge() %></td>
				<td><%=t.getDescription() %></td>
				<td>
					<a href = "update.jsp?tid=<%=t.getTid() %>">修改</a>|
					<a href = "delete_handler.jsp?tid=<%=t.getTid() %>">删除</a>
				</td>
			</tr>	
		<%	}
		%>
	</table>
</body>
</html>