<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理用户</title>
</head>
<style type="text/css">
#div1 {
	margin-left: 1100px;
}
</style>
<body>
	<form action="">
		<h1 align="center">管理用户</h1>
		<div id="div1"><a href="<%=request.getContextPath()%>/view/share/admin/admindo.jsp">返回功能页面</a></div>
		<table align="center" border="1" width="56%">
			<tr>
				<th>用户编号</th>
				<th>用户名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>个性签名</th>
				<th>违约次数</th>
				<th>修改</th>
				<th>删除</th>
		</tr>
			<c:forEach items="${sessionScope.users }" var="uuu">
				<tr>
					<td>${uuu.userNumber }</td>
					<td>${uuu.userName }</td>
					<td>${uuu.userSex }</td>
					<td>${uuu.userAge }</td>
					<td>${uuu.userIntro }</td>
					<td>${uuu.userCredit }</td>
					<td><a
						href="<%=request.getContextPath()%>/view/share/users/updateuser.jsp">修改</a></td>
					<td><a href="">删除</a></td>
				</tr>
			</c:forEach>
	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>