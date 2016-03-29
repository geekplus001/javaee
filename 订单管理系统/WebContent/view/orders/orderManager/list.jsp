<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
<title>订单列表</title>

<script language="JavaScript">
	function doView(OrderId)
	{
		document.mainForm.action="<%=request.getContextPath()%>/servlet/OrderItemServlet?method=item&id="+orderId;
		document.mainForm.submit();
	}
	function doDelete(orderId)
	{
		document.mainForm.action="<%=request.getContextPath()%>/servlet/OrderItemServlet?method=delete&id="+orderId;
		document.mainForm.submit();
	}
	function showAll()
	{ 
		windows.location.href = "<%=request.getContextPath()%>/servlet/OrderServlet?method=list";
	}
	
</script>
</head>
<body>
	<form action="" name = "mainForm" method = "post">
		<div align="center"><h2 align="center">订单列表</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="1" border="1" width="700px">
			<tr bgcolor="white">
				<td colspan="5" align="center">
					欢迎你&nbsp;&nbsp;[${sessionScope["#user#"].username}]&nbsp;|<a href="<%=request.getContextPath()%>/view/orders/userManager/set_pass.jsp">[修改密码]</a>&nbsp;<a href="<%=request.getContextPath()%>/servlet/LogoutServlet">[退出系统]</a>
				</td>
				
				<td colspan="2" align="center">
					<input type="button" value="显示全部" onclick="showAll()" class="inputbutton">
					&nbsp;&nbsp;
					<input class="inputbutton" type="button" value="查询" onclick="document.location.href='<%=request.getContextPath()%>/view/orders/orderManager/search.jsp'">
					&nbsp;&nbsp;
					<input class="inputbutton" type="button" value="新增" onclick="document.location.href='<%=request.getContextPath()%>/view/orders/orderManager/new.jsp'">
					
				</td>
			</tr>
			<tr bgcolor="white">
				<th>
					订单号
				</th>
				<th>
					订单名称
				</th>
				<th>
					订单配送方式
				</th>
				<th>
					订单总额
				</th>
				<th>
					订单修订日期
				</th>
				<th colspan="2" align="center">
					订单操作
				</th>
			</tr>
			<c:forEach var="list" items="${requestScope.orderlist}">
				<tr bgcolor="white">
					<td>
						${list.orderId }
					</td>
					<td>
						${list.orderCode }
					</td>
					<td>
						${list.deliverymethod }
					</td>
					<td>
						${list.sum }
					</td>
					<td>
						${list.lastModifyDate }
					</td>
					<td>
						<a href="#" onclick="doView('${list.orderId}')"><img alt="" src="<%=request.getContextPath()%>/view/images/" title="查看订单"></a>
					</td>
					<td>
						<a href="#" onclick="doDelete('${list.orderId}')"><img alt="" src="<%=request.getContextPath()%>/view/images/" title="删除"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>