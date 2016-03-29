<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
<script language="javascript" src="<%=request.getContextPath()%>/view/js/util.js"></script>
<script language="JavaScript">
	function doAdd()
	{
		if(checkForm())
		{
			document.mainForm.submit();
		}
		
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
	<form action="<%=request.getContextPath()%>/servlet/orderServlet?method=add" method="post" name="mainForm">
		<div align="center"><h2>新增订单</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="1">
			<tr bgcolor="white">
				<td colspan="2" align="center">
					订单详情
				</td>
			</tr>
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
					订单配送方式
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
				<td colspan="4" align="center">
					<input class="inputbutton" type="button" value="保存" onclick="doAdd()">
					<input class="inputbutton" type="button" value="返回" onclick="javascript:history.back();">
				</td>
			</tr>
		</table>
	</form>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>