<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="<%=request.getContextPath()%>/view/js/util.js"></script>
<title>订单详情</title>
<script language="JavaScript">
	function doView(itemId)
	{
		document.mainForm.itemid.value=itemId;
		document.mainForm.action="<%=request.getContextPath()%>/servlet/OrderItemServlet?method=view&itemid="+itemId;
		document.mainForm.submit();
	}
	function doDelte(itemId,orderId)
	{
		document.mainForm.itemid.value=itemId;
		document.mainForm.action="<%=request.getContextPath()%>/servlet/OrderItemServlet?method=delete&itemid="+itemId+"&id="+orderId;
		document.mainForm.submit();
	}
	function checkForm()
	{
		if(checkNull(document.mainForm.ordercode,"订单名称"))
		{
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<form action="" method="post" name="mainForm">
		<input type="hidden" name="itemid" value=""/>
		<div align="center"><h2>订单详情</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="1" border="1" width="700px"> 
			<tr bgcolor="white">
				<th colspan="4" align="center">订单详情</th>
			</tr>
			<tr bgcolor="white">
				<td>订单编号</td>
				<td>${requestScope.order.orderId }</td>
				<td>订单名称</td>
				<td>${requestScope.order.orderCode}</td>
			</tr>
			<tr bgcolor="white">
				<td>订单配送方式</td>
				<td>${requestScope.order.deliveryMethod }</td>
				<td>订单金额</td>
				<td>${requestScope.order.sum }</td>
			</tr>
			<tr bgcolor="white">
				<td>订单创建日期</td>
				<td>${requestScope.order.createdDate }</td>
				<td>订单最后修改日期</td>
				<td>${requestScope.order.lastModifyDate }</td>
			</tr>
			<tr bgcolor="white">
				<th colspan="4">订单明细</th>
				
			</tr>
			<tr bgcolor="white">
				<td colspan="4">
					<table align="center" bgcolor="black" cellpadding="5" cellspacing="1" border="1" width="700px">
						<tr bgcolor="white">
							<th>货物名称</th>
							<th>货物数量</th>
							<th>明细金额</th>
							<th colspan="2">操作</th>
						</tr>				
						<c:forEach var="list" items="${requestScope.order.orderItems }">
							<tr bgcolor="white">
								<td>${list.name }</td>
								<td>${list.unitNum }</td>
								<td>${list.sum }</td>
								<td><a href="#" onclick="doView('${list.itemId}')"><img alt="" src="<%=request.getContextPath()%>/view/images/" title="查看/修改"></a></td>
								<td><a href="#" onclick="doDelte('${list.itemId}','${requestScope.order.orderId }')"><img alt="" src="<%=request.getContextPath()%>/view/images/"></a></td>
							</tr>
						</c:forEach>	
					</table>
				</td>			
			</tr>
			<tr bgcolor="white">
				<td colspan="4" align="center">
					<c:choose>
						<c:when test="${requestScope.order.orderId!=0 }">
							<input type="button" value="添加明细" class="inputbutton" onclick="document.location.href='<%=request.getContextPath()%>/view/orders/orderItemManager/new.jsp?orderid=${requestScope.order.orderId }'">
						</c:when>
					</c:choose>
					<input type="button" value="订单列表" class="inputbutton" onclick="document.location.href='<%=request.getContextPath()%>/servlet/OrderServlet?method=list'">
				</td>
			</tr>
		</table>
		<input name="searchMode" type="hidden" value="false"/>
		<input name="orderMode" type="hidden" value="${requestScope. order.orderCode}"/>
	</form>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>