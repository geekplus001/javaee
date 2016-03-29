<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dao.TeacherDao,dao.impl.TeacherDaoImpl,model.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String tid = request.getParameter("tid");
	TeacherDao dao = new TeacherDaoImpl();
	Teacher t = dao.findById(Integer.parseInt(tid));
%>
</head>
<body>
<h2>修改信息</h2>
<form action="update_handler.jsp" method = "post">
		tid:<input type = "text" name = "tid" value = "<%=t.getTid()%>" readonly = "readonly"/><br/>
		name:<input type = "text" name = "name" value = "<%=t.getName() %>" /><br/>
		age:<input type = "text" name = "age" value = "<%=t.getAge()%>"/><br/>
		description:<textarea rows="5" cols="20" name = "description"><%=t.getDescription()%></textarea><br/>
		<input type = "submit" value = "确定"/>
	</form>
</body>
</html>