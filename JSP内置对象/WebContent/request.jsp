<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="request-receiver.jsp" method = "post">
		userr<input type = "text" name = "user"/><br/>
		pwdd<input type = "text" name = "pwd"/><br/>
		<input type = "checkbox" name = "likes" value = "睡觉"/>睡觉
		<input type = "checkbox" name = "likes" value = "吃饭"/>吃饭
		<input type = "checkbox" name = "likes" value = "泡妞"/>泡妞
		<br/>
		
		<input type = "submit" value = "登陆"/>
	</form>
	<h2>登陆表单session的使用</h2>
	<form action="<%=request.getContextPath() %>/session.jsp" method = "post">
		userr<input type = "text" name = "user"/><br/>
		pwdd<input type = "text" name = "pwd"/><br/>
		<br/>
		<input type = "submit" value = "登陆"/>
	</form>
	<h2>pageContext对象</h2>
	<%
		//通过pageContexxt上下文对象获取当前页面的其他内置对象
		request.setCharacterEncoding("UTF-8");
		
		pageContext.getRequest();
		pageContext.getRequest();
		pageContext.getSession();
		pageContext.getOut();
		String path = request.getContextPath();
		out.println(path);
	%>
	
	<h2>application对象</h2>

	<%
	//一个应用程序只有一个application对象
	//到服务器关闭时候才销毁
	//所有客户端共享一份
		String serverPath  = application.getContextPath();
		out.println(serverPath);
		application.setAttribute("", "");
	%>
</body>
</html>