<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>修改好友信息</h2>
	<form action="FriendServlet" method = "post">
	<input type = "hidden" name = "method" value =  "update"/>
		<table>
			<tr><td>Id</td></tr>
			<tr><td><input type = "text" name = "id" readonly = "readonly" value = "${friend.id }"/></td></tr>
			<tr>
				<td>Name:</td>
				<td><input type = "text" name = "name" value = "${friend.name }"/></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><input type = "text" name = "sex" value = "${friend.sex }"/></td>
			</tr>
			<tr>
				<td>Signature:</td>
				<td><input type = "text" name = "signature" value = "${friend.signature }"/></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "提交"/>
					<input type = "reset" value = "重置"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>