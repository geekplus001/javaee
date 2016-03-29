<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
<title>修改密码</title>
<script type="text/javascript">
	function checkPass()
	{
		var old_pass = document.mainForm.old_pass.value;
		if(old_pass=="")
		{
			document.getElementById("error_old_pass").innerHTML="旧密码不能为空";
			return false;
		}
		var new_pass = document.mainForm.new_pass.value;
		if(new_pass=="")
		{
			document.getElementById("error_new_pass").innerHTML="新密码不能为空";
			return false;
			
		}
		if(new_pass.length<6)
		{
			document.getElementById("error_new_pass").innerHTML="密码长度不能小于六位";
			return false;
		}
		var new_pass2 = document.mainForm.new_pass2.value;
		if(new_pass2!=new_pass)
		{
			document.getElementById("error_new_pass2").innerHTML="两次输入的新密码不一致";
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/UserServlet" method = "post" name="mainForm">
		<input type="hidden" name="method" value="updatePass">
		<div align="center"><h2>修改密码</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="2" border="">
			<tr bgcolor="white">
				<td width="100">
					旧密码
				</td>
				<td width="200">
					<input name="old_pass" type="password" class="inputtext">
				</td>
				<td width="300"><div id="error_old_pass"></div></td>
			</tr>
			<tr bgcolor="white">
				<td>
					新密码
				</td>
				<td>
					<input name="new_pass" type="password" class="inputtext">
				</td>
				<td><div id="error_new_pass"></div></td>
			</tr>
			<tr bgcolor="white">
				<td>
					重复密码
				</td>
				<td>
					<input name="new_pass2" type="password" class="inputtext">
				</td>
				<td><div id="error_new_pass2"></div></td>
			</tr>
			<tr bgcolor="white">
				<td align="center" colspan="3">
					<input value="提交" type="submit">
					<input value="重置" type="submit">
					<input value="返回" type="submit">
				</td>
			</tr>
		</table>
	</form>
		<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>