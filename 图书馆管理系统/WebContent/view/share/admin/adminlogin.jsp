<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
</head>
<body>
	<div
	style="padding-top: 60px; width: 960px; height: 100%; min-height: 480px; margin: 0 auto; font-size: 14px;">
		<div style="margin: 60px 0 0 0;">
			<div style="float: left; width: 400px;"><%@ include
					file="/view/share/include/imgback.jsp"%></div>
			<div style="width: 200px; float: left; margin: 60px 0 0 0;">
				<form action="<%=request.getContextPath() %>/AdminLoginServlet"
				method="post">
					<table>
						<tr>
							<th width="100">管理名</th>
							<td><input name="adminname" type="text"></td>
					</tr>
						<tr>
							<th>密码</th>
							<td><input name="adminpassword" type="password"></td>
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
