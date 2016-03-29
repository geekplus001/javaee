<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单明细</title>
<script type="text/javascript">
	window.onload = function(){
		document.mainForm.discounttype.onchange = function(){
			var _discounttype = document.mainForm.discounttype.value;
			if(_discounttype=="1")
			{
				document.mainForm.discount.disabled = "disabled";
				document.mainForm.promotionprice.disabled = "disabled";
				document.mainForm.promotionprice.disabled = "disabled";
			}else if(_discounttype=="2")
			{
				document.mainForm.discount.disabled = "";
				document.mainForm.promotionprice.disabled = "disabled";
				document.mainForm.promotionprice.disabled = "disabled";
			}else if(_discounttype=="3")
			{
				document.mainForm.discount.disabled = "disabled";
				document.mainForm.promotionprice.disabled = "";
				document.mainForm.promotionprice.disabled = "";
			}
			
		}
	}
	function doAdd()
	{
		var temp_discounttype = eval("document.mainForm.discounttype.value");
		var unitnum = eval("document.mainForm.unitnum.value");
		var unitprice = eval("document.mainForm.unitprice.value");
		if(temp_discounttype==1)
		{
			document.mainForm.sum.value = unitnum*unitprice;
		}else if(temp_discounttype==2)
		{
			var discount = eval("document.mainForm.discount.value");
			document.mainForm.sum.value = unitnum*unitprice*discount;
		}else if(temp_discounttype==3)
		{
			var promotionnum = eval("document.mainForm.promotionnum.value");
			var promotionprice = eval("document.mainForm.promotion.value");
			docement.mainForm.sum.value = (unitnum-promotionnum)*unitprice+promotionnum*promotionprice;
		}
		document.mainForm.acton = "<%=request.getContextPath()%>/servlet/orderItemServlet?method=add";
		document.mainForm.submit();
	}
</script>
</head>
<body>
	<form action="" method="post" name="">
		<div align="center"><h2>添加订单</h2></div>
		<table align="center" bgcolor="black" cellpadding="5" cellspacing="1" border="1" width="700px">
			<tr bgcolor="white">
				<td colspan="4">
					当前订单号为:${param.orderid}
					<input type="hidden" name="id" value="${param.orderid }">
				</td>
			</tr>
			<tr bgcolor="white">
				<td>
					货物名称
				</td>
				<td>
					<input name="name"/>
				</td>
				<td>
					折扣类型	
				</td>
				<td>
					<select>
						<option value="1">
							无折扣
						</option>
						<option value="2">
							有折扣
						</option>
						<option value="3">
							促销
						</option>
					</select>
				</td>	
			</tr>
			<tr bgcolor="white">
				<td>
					货物数量
				</td>
				<td>
					<input name="uninum" class="inputtext" type="text" disabled="disabled"/>
				</td>
				<td>
					货物单价
				</td>
				<td>
					<input name="unitprice" class="inputtext" type="text" disabled="disabled"/>
				</td>
			</tr>
			<tr bgcolor="white">
				<td>
					货物总价
				</td>
				<td>
					<input name="sum" class="inputtext" type="text" disabled="disabled"/>
				</td>
				<td>
					折扣率
				</td>
				<td>
					<input name="discount" class="inputtext" type="text" disabled="disabled"/>
				</td>
			</tr>
			<tr bgcolor="white">
				<td>
					促销单价
				</td>
				<td>
					<input name="promotionprice" class="inputtext" type="text" disabled="disabled"/>
				</td>
				<td>
					促销数量
				</td>
				<td>
					<input name="promotionnum" class="inputtext" type="text" disabled="disabled"/>
				</td>
			</tr>
			<tr bgcolor="white">
				<td colspan="4" align="center">
					<input type="button" value="添加" onclick="doAdd()">				
					<input type="button" value="返回" onclick="javascript">				
				</td>
			</tr>
		</table>
	</form>
	<%@ include file = "/view/share/include/bottom.jsp" %>
</body>
</html>