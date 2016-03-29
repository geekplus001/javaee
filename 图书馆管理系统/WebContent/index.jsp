<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<%-- <jsp:forward page="<%=request.getContextPath() %>/BookServlet">
		<jsp:param value="listImg" name="method"/>
	</jsp:forward>  --%>
	<%
	 	//request.setAttribute("method", "listImg");
		//request.getRequestDispatcher(request.getContextPath()+"/BookServlet").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=listImg");
	%>
</body>
</html>