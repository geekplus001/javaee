<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%!
	//JSP声明片段:注意（不建议在JSP页面上定义变量或方法）
	int i = 10;
	String name =  "小白";
	public void printName()
	{
		System.out.println(name);
	}
%>
<!-- JSP表达式语法 -->
<%=new java.util.Date() %>
</head>
<body>
	<%
	//JSP脚本
	printName();
	%>
</body>
</html>