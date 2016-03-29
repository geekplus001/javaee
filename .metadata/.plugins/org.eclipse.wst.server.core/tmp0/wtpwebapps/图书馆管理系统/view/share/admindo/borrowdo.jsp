<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借书</title>
</head>
<%
	
	String time = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
%>

<style type="text/css">
table {
	margin-top: 130px;
}
</style>
<script type="text/javascript">
	 function check()
	 {
		 var book_name = document.getElementById("book_name").value;
		 var lend_user = document.getElementById("lend_user").value;
		 var user_phone = document.getElementById("userphone").value;
		 var user_ID = document.getElementById("userID").value;
		 if(book_name=="")
		 {
			 document.getElementById("err").innerHTML="书名不能为空";
		 }
		 else if(lend_user=="")
		 {
			 document.getElementById("err").innerHTML="用户名不能为空";
		 }
		 else if(user_phone=="")
		 {
			 document.getElementById("err").innerHTML="电话不能为空";
		 }
		 else if(user_ID=="")
		 {
		 	document.getElementById("err").innerHTML="ID不能为空";
		 }
		 else document.getElementById("myform").submit();
	 } 
	 
	 
	 
	 
	 
	 var xmlHttp = null;
		function createXMLHttpRequest() {
			if (window.XMLHttpRequest) { //检测是否为Mozilla浏览器
					xmlHttp = new XMLHttpRequest();
			}
			else if (window.ActiveXObject) { //检测是否为IE浏览器
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("不支持ajax");
					}

				}

			}
		}
		function validateee() {
			var lend_username = document.getElementById("lend_user").value;
			var book_name = document.getElementById("book_name").value;
				//this   field    trim(field.value).length!=0     trim(field.value)
				//创建Ajax核心对象XMLHttpRequest  
				createXMLHttpRequest();
				var url = "<%=request.getContextPath()%>/BorrowServlet?borrowservlet=checkuser&bookname="+book_name+"&lenduser="+lend_username;
				//设置请求方式为get,请求的URL,异步提交  
				xmlHttp.open("GET", url, true);
				//将方法地址赋值给onreadystatechange属性  
				xmlHttp.onreadystatechange = callback;
				xmlHttp.send();
		}
		function callback() {
			//4表示有响应  
			if (xmlHttp.readyState == 4) {
				//200表示请求成功  
				if (xmlHttp.status == 200) {
					/*  var data = encodeURIComponent(xmlHttp.responseText) ; 
					 var str1 = encodeURIComponent("此书不存在") ;
					 var str2 = encodeURIComponent("此用户不存在") ; */
					 
					/*  if(data==str1)
					 {
						 document.getElementById("che").innerHTML = "<font color='red'>"
								+ data + "</font>";
					 }
					 else if(data==str2)
					 {
						 document.getElementById("che").innerHTML = "<font color='red'>"
								+ data + "</font>";
					 }
					 else
					 {
						 document.getElementById("userphone").innerHTML = data;
					 } */
					 
					 
					 var data = xmlHttp.responseText;
					 var datas=new Array();
					 datas=data.split("-");
					 if(datas.length==2)
					 {
						 document.getElementById("userphone").value = datas[0];
						 document.getElementById("userID").value =datas[1];		 
				 	 }
					 else if(datas.length==3)
					 {
						 document.getElementById("userphone").value = datas[0];
						 document.getElementById("userID").value =datas[1];
						 document.getElementById("credit").innerHTML = "<font color='red'>"
								+ datas[2] + "</font>";
					 }
					 else{
						 document.getElementById("che").innerHTML = "<font color='red'>"
								+ data + "</font>";
					 }
						
							
					<%--  <% 
						 String che = (String)request.getSession().getAttribute("ffff");
						 String userP = (String)request.getSession().getAttribute("borrowPhone");
						 String  userC =(String)request.getSession().getAttribute("borrowCard");
						 System.out.println(che);
					 %>
					 var chee = <%=che%>;
					if(<%=che.equals("无记录")%>)
					{
						document.getElementById("che").innerHTML = "<font color='red'>"
							+ data + "</font>"
					}
					else
					{
						document.getElementById("userphone").innerHTML = <%=userP%>;
						document.getElementById("userID").innerHTML = <%=userC%>;
					} --%>
				}  
			}/*  else {
				alert("请求失败,错误码=" + xmlHttp.status);
			} */

		}
</script>
<body>

	<form id="myform"
	action="<%=request.getContextPath()%>/BorrowServlet?borrowservlet=borrowing&lenddatee=<%=time %>"
	method="post">
		<!-- 传递多个参数也可用input hidden代替 -->
		<table cellpadding="10px" align="center">
			<tr>
				<th valign="top">借阅书名</th>
				<td><input type="text" name="bookname" id="book_name"></td>
		</tr>
			<tr>
				<th valign="top">借阅读者</th>
				<td><input type="text" name="lenduser" id="lend_user"
					onblur="validateee()"></td>
		</tr>
			<tr>
				<th valign="top">借阅日期</th>
				<td><input type="text" name="lenddate" value="<%=time %>"
					disabled="true"></td>
		</tr>

			<tr>
				<th valign="top">读者电话</th>
				<td><input type="text" name="userphone" id="userphone"></td>
		</tr>
			<tr>
				<th valign="top">读者ID</th>
				<td><input type="text" name="userID" id="userID"></td>
		</tr>
			<tr>
				<th>借阅数量</th>
				<td><select id="number" name="number">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
		</tr>
			<tr>
				<td><input type="button" value="确认借阅" onclick="check()">
			</td>
				<td><a href="<%=request.getContextPath()%>/view/share/admin/admindo.jsp">返回功能页面</a></td>
		</tr>
			<tr>
				<th></th>
				<td id="err"></td>
		</tr>
			<tr>
				<th></th>
				<td id="che"></td>
		</tr>
			<tr>
				<td></td>
				<td><div id="credit"></div></td>
		</tr>
	</table>
</form>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>