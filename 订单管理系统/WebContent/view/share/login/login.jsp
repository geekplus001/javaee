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
<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-contol" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
</head>
<body bgcolor="#0066CC">
	<div id="contentdiv">
	<div align="center" id = "headdiv"> </div>
	<div>
	<br/><br/>
	<form action="<%=path%>/servlet/LoginServlet" name="loginForm" method="post">
		<table align="center" border="0">
			<tr>
				<td>用户账号：</td>
				<td><input type="text" name="username" class="inputtext"></td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="password" name="password" class="inputtext"></td>
			</tr>
			<tr>
				<td>
					自动登陆时间：
				</td>
				<td>
					<input type="radio" name="auto_login" value="1">一周
					<input type="radio" name="auto_login" value="2">一个月
					<input type="radio" name="auto_login" value="3">三个月
					<input type="radio" name="auto_login" value="4">一年
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登陆">
					<input type="button" value="注册">
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	
</body>
</html>