<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login()
	{
		var loginForm  = document.forms["loginForm"];
		loginForm.name.value = encodeURI(loginForm.name.value);
		loginForm.submit();
	}
</script>
</head>
<body>
	<form action="login-handler.jsp" name = "loginForm" onsubmit = "login()" method = "post">
		username:<input type = "text" name = "name" /><br/>
		password:<input type = "text" name = "pwd" /><br/>
		<input type = "hidden" name = "id" value = "111"/>
		<input type = "submit" value = "登陆" /><br/>
		
	</form>
</body>
</html>