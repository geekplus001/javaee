<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="new_handler.jsp" method = "post">
		name:<input type = "text" name = "name"/><br/>
		age:<input type = "text" name = "age"/><br/>
		description:<textarea rows="5" cols="20" name = "description"></textarea><br/>
		<input type = "submit" value = "确定"/>
	</form>
</body>
</html>