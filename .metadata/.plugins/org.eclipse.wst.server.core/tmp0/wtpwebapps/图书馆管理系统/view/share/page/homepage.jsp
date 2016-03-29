<%@page import="javax.swing.text.html.StyleSheet.ListPainter"%>
<%@page import="com.ben.vo.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ben.dao.factory.DaoFactory"%>
<%@page import="com.ben.vo.Book"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Page-Enter"
	content="revealTrans(duration=1.0,transtion=    12)">
<meta http-equiv="Page-Exit"
	content="revealTrans(duration=1.0,transtion=    12)">
<title>403图书馆</title>
</head>
<script type="text/javascript">
	function aaaclick()
	{
		alert("请先登陆！");
	}
</script>
<style type="text/css">
#iii {
	width: 200px;
	height: 200px;
}

#h1 {
	font-size: 130px;
	font-weight: 450;
	text-align: center;
	font-family: "华文行楷";
	letter-spacing: 80px;
	margin-top: 0px;
	text-decoration: blink;
	color: #f00;
	text-shadow: 1px 1px 0px #212121;
}

th {
	text-align: center;
	font-size: 25px;
}

#table1 {
	min-height: 465px;
	background-color: #44B8EA;
}

#table2 {
	min-height: 465px;
	background-color: #9FD772;
}

#table3 {
	min-height: 465px;
	background-color: #FFBB53;
}

#table4 {
	min-height: 465px;
	background-color: #F98B66;
}

#ttt {
	margin-right: 50px;
}
</style>
<body>
	<%-- <iframe src="<%=request.getContextPath()%>/view/share/include/imgback.jsp" ></iframe> --%>
	<div id="h1">不止读书</div>

	<form action="<%=request.getContextPath()%>/BookDetailServlet"
	method="post" target="_blank"><%@ include
			file="/view/share/include/imgback.jsp"%>
		<table id="ttt" align="right">

			<tr>
				<td>
					<h3>你闻讯而来，我大喜过望———灵彡阁</h3> <br> 本馆所有图书供注册读者免费借阅60天（到期可续）
			</td>

				<td><a target="_blank"
					href="<%=request.getContextPath() %>/view/share/admin/adminlogin.jsp">管理员入口</a><br>
					<a href="<%=request.getContextPath()%>/view/share/users/login.jsp"
					id="a1">登陆</a> <a
					href="<%=request.getContextPath()%>/view/share/users/register.jsp"
					id="a2">注册</a></td>
		</tr>
			<tr>
				<td><input type="text" name="bookname" value="请输入书名"
					onfocus="if(value=='请输入书名'){value=''}"
					onblur="if(value==''){value='请输入书名'}"> <input type="submit"
					value="检索图书"> <!-- document.getElementById("d").focus();光标默认在此 -->
			</td>
		</tr>
	</table> <% 
			int i = 0; 
			int k = 0;
		%> <c:set var="j" value="0"></c:set> <c:forEach
			items="${sessionScope.categories}" var="categorie">
			<hr>
			<table id="table<%=i+1%>" cellpadding="10" width="100%">
				<tr><th colspan="5">${categorie.categoriesName }</th></tr>
				<tr>
					<c:forEach items="${sessionScope.books}" var="book" begin="${j}"
						end="${j  + categorie.categoriesNumber - 1}" varStatus="itj">
						<% k++; %>
						<td align="center"><a href=""><img id="iii"
								onclick="aaaclick()" alt="${book.bookName }"
								src="<%=request.getContextPath() %>${book.bookPath }"></a><br>${book.bookName }
						</td>
						 <c:set var="nn" value="0"></c:set>
						<c:forEach begin="0" end="${categorie.categories-1 }" var="mm">
							<c:set var="nn" value="${sessionScope.categories[mm].categoriesNumber+nn}"></c:set>
						</c:forEach>
						<c:choose>
							<c:when test="${nn==book.bookNumber }">
							<%
								k = 0;
							%>
										
			</tr>
				<tr>
							</c:when>
							<c:otherwise>
								<%
							if(k % 5 == 0){ %>
					
			</tr>
				<tr>
					<%} %>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</tr>
				<c:set var="j" value="${categorie.categoriesNumber + j}"></c:set>
				<%
					++i;
				%>
			</table>
			<br>
			<br>
			<br>
		</c:forEach></form>
	<%@ include file="/view/share/include/bottom.jsp"%>

</body>
</html>