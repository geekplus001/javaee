<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie[] cookies = request.getCookies();
	String username_password = "";
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			if("studentjspusernamepassword".equals(cookies[i].getName()))
			{
				username_password = cookies[i].getValue();
				break;
			}
		}
	}
	
	if(!username_password.equals(""))
	{
		String[] up = username_password.split("");
	}
%>
	<jsp:forward page="list.jsp"></jsp:forward>
