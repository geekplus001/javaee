<%@page import="com.ben.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户资料</title>
</head>
<style type="text/css">
table {
	margin-top: 100px;
}

caption {
	font-size: 20px;
	font-weight: bolder;
}
</style>
<%
	User user = (User)request.getSession().getAttribute("user");
	String userSex = user.getUserSex();
	/* System.out.println(userSex); */
%>
<script type="text/javascript">
	
	/* 	var sex_select= document.getElementById("sex_select").options;;
		for (var i = 0; i < sex.options.length; i++) { 
			if("${sessionScope.user.userSex }"==sex_select[i].value )
			{
				sex_select[i].selected = true;
			}
		} */
		function selectt(){
			if(<%=userSex.equals("女") %>)
			{
				var sex_select= document.getElementById("sex_select");
				sex_select.value="女";
			}
			
		
		}
		
	<%-- sex.value = <%=userSex%>; --%>
	<%-- <%System.out.println(userSex);%> --%>
	<%-- document.all.sex.value = <%=userSex%>; --%>
	 
</script>
<body onload="selectt()">
	<form id="myform"
	action="<%=request.getContextPath()%>/UserServlet?userFlag=update"
	method="post">
		<table align="center">
			<caption>修改用户资料</caption>
			<tr>
				<td><br> <br></td>
		</tr>
			<tr>
				<th valign="top">旧密码</th>
				<td><input type="password" name="oldpassword"></td>
		</tr>
			<tr>
				<th valign="top">新密码</th>
				<td><input type="password" name="newpassword1"></td>
		</tr>
			<tr>
				<th valign="top">重复新密码</th>
				<td><input type="password" name="newpassword2"></td>
		</tr>
			<tr>
				<th valign="top">性别</th>
				<td><select id="sex_select" name="sex_select">
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>
		</tr>
			<tr>
				<th valign="top">年龄</th>
				<td><input type="text" name="age"
					value="${sessionScope.user.userAge }"></td>
		</tr>
			<tr>
				<th valign="top">个性签名</th>
				<td><input type="text" name="intro"
					value="${sessionScope.user.userIntro }"></td>
		</tr>
			<tr>
				<th valign="top"></th>
				<td><input type="submit" value="提交"></td>
		</tr>
			<tr>
				<td></td>
				<td>旧密码不能为空</td>
		</tr>
			<tr>
				<td></td>
				<td>新密码为空则只修改其他内容</td>
		</tr>
	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>