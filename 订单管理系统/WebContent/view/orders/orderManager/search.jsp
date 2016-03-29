<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/style.css">
<title>订单查询</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/OrderServlet?method=search" method="post" name="mainForm">
		<div align="center"><h2>订单查询</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="1" border="1" width="400px">
			<tr bgcolor="white">
				<td>
					订单名称
				</td>
				<td>
					<input name="ordercode" type="text" class="inputtext">
				</td>
			</tr>
			<tr bgcolor="white">
				<td>
					订单金额
				</td>
				<td>
					<input name="sum" type="text" class="inputtext">
				</td>
			</tr>
			<tr bgcolor="white">
				<td>
					配送方式
				</td>
				<td>
					<select name="deliverymethod" class="inputtext">
						<option value="自取">
							自取
						</option>
						<option value="邮寄">
							邮寄
						</option>
						<option value="快递">
							快递
						</option>
					</select>
				</td>
			</tr>
			<tr bgcolor="white">
				<td align="center" colspan="2">
					<input value="查询" class="inputbutton" onclick="document.">
					<input value="重置"  class="inputbutton" onclick="">
					<input value="返回" class="inputbutton" onclick="">
				</td>
			</tr>
		</table>
	</form>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>