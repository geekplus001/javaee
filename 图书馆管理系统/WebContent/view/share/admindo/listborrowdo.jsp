<%@page import="java.util.ArrayList"%>
<%@page import="com.ben.vo.Borrow"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理借书</title>
</head>
<style type="text/css">
#div1 {
	margin-left: 1100px;
}
</style>

<body>
	<form action="">
		<h1 align="center">管理借书</h1>
		<div id="div1"><a href="<%=request.getContextPath()%>/view/share/admin/admindo.jsp">返回功能页面</a></div>

		<table align="center" border="1" width="70%">
			<tr>
				<th>借阅编码</th>
				<th>书名</th>
				<th>借阅读者</th>
				<th>借阅日期</th>
				<th>归还日期</th>
				<th>读者电话</th>
				<th>读者ID</th>
				<th>借阅数量</th>
				<th>续借次数</th>
				<th>修改</th>
				<th>删除</th>
		</tr>
			<c:set var="j" value="0"></c:set>
			<c:forEach items="${sessionScope.borrowss }" var="bbb">
				<c:choose>
					<c:when test="${j == sessionScope.fla[j] }">
						<tr bgcolor="#ff0000">
							<td>${bbb.lendNumber }</td>
							<td>${bbb.lendBookName }</td>
							<td>${bbb.lendUser }</td>
							<td>${bbb.lendDate }</td>
							<td>${bbb.returnDate }</td>
							<td>${bbb.borrowPhone }</td>
							<td>${bbb.borrowerCard }</td>
							<td>${bbb.borrowNumber }</td>
							<td>${bbb.renew }</td>
							<td><a href="">修改</a></td>
							<td><a href="">删除</a></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${bbb.lendNumber }</td>
							<td>${bbb.lendBookName }</td>
							<td>${bbb.lendUser }</td>
							<td>${bbb.lendDate }</td>
							<td>${bbb.returnDate }</td>
							<td>${bbb.borrowPhone }</td>
							<td>${bbb.borrowerCard }</td>
							<td>${bbb.borrowNumber }</td>
							<td>${bbb.renew }</td>
							<td><a href="">修改</a></td>
							<td><a href="">删除</a></td>
						</tr>
					</c:otherwise>
				</c:choose>
				<c:set var="j" value="${j+1 }"></c:set>
			</c:forEach>

	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>