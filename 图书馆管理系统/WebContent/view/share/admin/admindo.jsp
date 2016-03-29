<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
</head>
<style type="text/css">
table {
	margin-top: 80px;
}

caption {
	font-size: 30px;
}

td {
	font-size: 20px;
}
</style>
<body>

	<table summary="管理员操作" align="center" width="48%" height="60%"
	border="3" cellspacing="30px" cellpadding="30px"
	background="<%=request.getContextPath()%>/img/background.jpg">
		<caption>管理员操作</caption>
		<tr></tr>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/view/share/admindo/borrowdo.jsp">确认借书</a></td>
			<td><a
				href="<%=request.getContextPath()%>/view/share/admindo/returndo.jsp">确认还书</a></td>
	</tr>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/UserServlet?userFlag=list">管理用户</a></td>
			<td><a
				href="<%=request.getContextPath()%>/view/share/admindo/bookdo.jsp">管理图书</a></td>
	</tr>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/BorrowServlet?borrowservlet=list">管理借书</a></td>
			<td><a href="<%=request.getContextPath()%>/index.jsp">退出登陆</a></td>
	</tr>
</table>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>