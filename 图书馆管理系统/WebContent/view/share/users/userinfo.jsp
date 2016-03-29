<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者信息</title>
</head>
<script type="text/javascript">
	function renew(number)
	{
		var nnn = number;
		if(confirm("确认续借吗?"))
		{
			window.location.href = "<%=request.getContextPath()%>/BorrowServlet?borrowservlet=renew&lendnumber="+nnn;
		}
		
	}
	
</script>
<body>
	<h3>读者信息</h3>
	<form
	action="<%=request.getContextPath()%>/view/share/admin/adminlogin.jsp">
		<table>
			<tr>
				<th valign="top">用户编号：</th>
				<td>${sessionScope.user.userNumber }</td>
		</tr>
			<tr>
				<th valign="top">用户名：</th>
				<td>${sessionScope.user.userName }</td>
		</tr>
			<tr>
				<th valign="top">性别：</th>
				<td>${sessionScope.user.userSex }</td>
		</tr>
			<tr>
				<th valign="top">年龄：</th>
				<td>${sessionScope.user.userAge }</td>
		</tr>
			<tr>
				<th valign="top">个性签名：</th>
				<td>${sessionScope.user.userIntro }</td>
		</tr>
			<tr>
				<th valign="top">违约次数：</th>
				<td>${sessionScope.user.userCredit }</td>
		</tr>
			<tr>
				<th valign="top">借阅书单：</th>
				<c:choose>
					<c:when test="${sessionScope.borrows.isEmpty() }">
						<td>无</td>
					</c:when>
					<c:otherwise>
						<td>
							<table border="1">
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
									<th>删除</th>
									<th>续借</th>
							</tr>
								<c:set var="i" value="0"></c:set>
								<c:forEach items="${sessionScope.borrows }" var="bbbb">
									<c:choose>
										<c:when test="${i == sessionScope.fff[i] }">
											<tr bgcolor="#ff0000">
												<td>${bbbb.lendNumber }</td>
												<td>${bbbb.lendBookName }</td>
												<td>${bbbb.lendUser }</td>
												<td>${bbbb.lendDate }</td>
												<td>${bbbb.returnDate }</td>
												<td>${bbbb.borrowPhone }</td>
												<td>${bbbb.borrowerCard }</td>
												<td>${bbbb.borrowNumber }</td>
												<td>${bbbb.renew }</td>
												<td><a href="">删除</a></td>
												<td><a href="javascript:void(0);" onclick="renew(${bbbb.lendNumber })">续借</a></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>${bbbb.lendNumber }</td>
												<td>${bbbb.lendBookName }</td>
												<td>${bbbb.lendUser }</td>
												<td>${bbbb.lendDate }</td>
												<td>${bbbb.returnDate }</td>
												<td>${bbbb.borrowPhone }</td>
												<td>${bbbb.borrowerCard }</td>
												<td>${bbbb.borrowNumber }</td>
												<td>${bbbb.renew }</td>
												<td><a href="">删除</a></td>
												<td><a href="javascript:void(0);" onclick="renew(${bbbb.lendNumber })">续借</a></td>
											</tr>
										</c:otherwise>
									</c:choose>
									<c:set var="i" value="${i+1 }"></c:set>
								</c:forEach>
						</table>
						</td>
					</c:otherwise>
				</c:choose>
		</tr>
			<tr>
				<th valign="top">我要还书：</th>
				<td><input type="submit" value="还书"></td>
		</tr>
			<tr><td><a
					href="<%=request.getContextPath()%>/view/share/users/updateuser.jsp">修改个人资料</a></td></tr>
	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>