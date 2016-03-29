<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getAuthType();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'error.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-contol" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="refresh" content="3;url=<%=path %>/view/share/login/login.jsp">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td><img alt="" src="<%=path%>/view/images/"></td>
				<td>
					用户名或密码错误，3秒后自动跳回
					若没有自动跳转，请点击一下链接
					<a href="<%=path%>/view/login/login.jsp"></a>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>