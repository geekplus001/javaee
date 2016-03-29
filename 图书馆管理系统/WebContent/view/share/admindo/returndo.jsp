<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>还书</title>
</head>
<%
	String time = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
%>

<style type="text/css">
table {
	margin-top: 130px;
}
</style>
<script type="text/javascript">
	 function check()
	 {
		 var book_name = document.getElementById("book_name").value;
		 var lend_user = document.getElementById("lend_user").value;
		 if(book_name=="")
		 {
			 document.getElementById("err").innerHTML="书名不能为空";
		 }
		 else if(lend_user=="")
		 {
			 document.getElementById("err").innerHTML="用户名不能为空";
		 }
		 else document.getElementById("myform").submit();
	 }
</script>
<body>
	<form id="myform"
	action="<%=request.getContextPath()%>/BorrowServlet?borrowservlet=returning&returndatee=<%=time %>"
	method="post">
		<table align="center" cellpadding="10px">
			<tr>
				<th valign="top">借阅书名</th>
				<td><input id="book_name" type="text" name="bookname"></td>
		</tr>
			<tr>
				<th valign="top">借阅读者</th>
				<td><input type="text" id="lend_user" name="lenduser"></td>
		</tr>
			<tr>
				<th valign="top">归还日期</th>
				<td><input type="text" value="<%=time %>" disabled="true"></td>
		</tr>
			<tr>
				<th>归还数量</th>
				<td><select id="number" name="number">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
		</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" value="y" name="credit">是否违约</td>
		</tr>
			<tr>
				<td><input type="button" value="确认归还" onclick="check()">
			</td>
				<td><a href="<%=request.getContextPath()%>/view/share/admin/admindo.jsp">返回功能页面</a></td>
		</tr>
			<tr>
				<th></th>
				<td id="err"></td>
		</tr>
	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>