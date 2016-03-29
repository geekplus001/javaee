<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者登陆</title>
<%
		String usernamee = "";
		String passwordd = "";
		//获取当前站点所有cookies
		Cookie [] cookies  = request.getCookies();
		for(int i = 0;i<cookies.length;i++)
		{
			if("usernameb".equals(cookies[i].getName()))
			{
				
				usernamee = URLDecoder.decode(cookies[i].getValue(), "utf-8");
			}
			if("userpasswordb".equals(cookies[i].getName()))
			{
				
				passwordd = URLDecoder.decode(cookies[i].getValue(), "utf-8");
			}
		}
	%>
</head>
<body>
	<div
	style="padding-top: 60px; width: 960px; height: 100%; min-height: 480px; margin: 0 auto; font-size: 14px;">
		<div style="margin: 60px 0 0 0;">
			<div style="float: left; width: 400px;"><%@ include
					file="/view/share/include/imgback.jsp"%></div>
			<div style="width: 200px; float: left; margin: 60px 0 0 0;">
				<form action="<%=request.getContextPath() %>/LoginServlet"
				method="post">
					<table>
						<tr>
							<th width="100">用户名</th>
							<td><input name="username" type="text"
								value="<%=usernamee%>"></td>
					</tr>
						<tr>
							<th>密码</th>
							<td><input name="userpassword" type="password"
								value="<%=passwordd%>"></td>
					</tr>
						<tr>
							<td><input type="checkbox" name="cookiee" value="1">
						</td>
							<td>一周内免登陆</td>
					</tr>
						<tr>
							<th></th>
							<td><button type="submit" style="">确定</button></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</div>
	<!-- <div style="clear:float;clear:both;"></div> -->
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>