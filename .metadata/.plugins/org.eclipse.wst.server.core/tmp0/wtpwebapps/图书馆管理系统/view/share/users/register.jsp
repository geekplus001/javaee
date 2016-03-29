<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者注册</title>
</head>
<script type="text/javascript">
	 	function check()
	 {
	 var user_name = document.getElementById("user_name").value;
	 var user_age = document.getElementById("tuser_age").value;
	 var user_password1 = document.getElementById("user_password1").value;
	 var user_password2 = document.getElementById("user_password2").value;
	  if(user_name=="")
	 {
	 document.getElementById("err").innerHTML="用户名不能为空";
	 }
	 else  if(user_age=="")
	 {
	 document.getElementById("err").innerHTML="年龄不能为空";
	 }
	 else if(user_password1=="" || user_password2=="")
	 {
	 document.getElementById("err").innerHTML="密码不能为空";
	 }
	 else if(user_password1!=user_password2)
	 {
	 document.getElementById("err").innerHTML="两次密码输入不一致";
	 }
	 else document.getElementById("myform").submit();
	 } 

	var xmlHttp = null;
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //检测是否为Mozilla浏览器
			try {
				xmlHttp = new XMLHttpRequest();
			} 
			catch (e) {
			}
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
	function validatee() {
		var user_name = document.getElementById("user_name").value;
		if (user_name != "") {
			//this   field    trim(field.value).length!=0     trim(field.value)
			//创建Ajax核心对象XMLHttpRequest  
			createXMLHttpRequest();
			var url = "<%=request.getContextPath()%>/UserServlet?userFlag=find&ccc="+user_name;
			//设置请求方式为get,请求的URL,异步提交  
			xmlHttp.open("GET", url, true);
			//将方法地址赋值给onreadystatechange属性  
			xmlHttp.onreadystatechange = callback;
			xmlHttp.send();
		} /* else {
			document.getElementById("spanUserId").innerHTML = "用户名不能为空";
			var btn = document.getElementById("btn");
	     	btn.disabled="true";
		} */
	}
	function callback() {
		//4表示有响应  
		if (xmlHttp.readyState == 4) {
			//200表示请求成功  
			if (xmlHttp.status == 200) {
				document.getElementById("spanUserId").innerHTML =  xmlHttp.responseText;
				/* var btn = document.getElementById("btn");
		     	btn.disabled="true"; */
				
			}  /* else {
				document.getElementById("spanUserId").innerHTML = "用户名必须唯一";
			}  */
		}/*  else {
			alert("请求失败,错误码=" + xmlHttp.status);
		} */

	}
	function again()
	{
		var btn = document.getElementById("btn");
     	btn.removeAttribute("disabled");
	}
</script>
<body>
	<div class="main index"
	style="padding-top: 60px; width: 960px; height: 100%; min-height: 480px; margin: 0 auto; font-size: 14px;">
		<div style="margin: 60px 0 0 0;">
			<div style="float: left; width: 400px;"><%@ include
					file="/view/share/include/imgback.jsp"%></div>
			<div class="content"
			style="width: 560px; float: left; margin: 60px 0 0 0;">
				<form id="myform"
				action="<%=request.getContextPath()%>/UserServlet?userFlag=save"
				method="post">
					<table cellpadding="5px">
						<tr>
							<th width="100">用户名</th>
							<td><input name="user_name" type="text" id="user_name"
								onblur="validatee()" onfocus="again()">*</td>
					</tr>
						<tr>
							<th>性别</th>
							<td><select name="usersex">
									<option value="男" selected="selected">男</option>
									<option value="女">女</option>
							</select></td>
					</tr>
						<tr>
							<th>年龄</th>
							<td><input name="tuserage" type="text" id="tuser_age">*</td>
					</tr>

						<tr>
							<th>密码</th>
							<td><input name="userpassword1" type="password"
								id="user_password1">*</td>
					</tr>
						<tr>
							<th>重复密码</th>
							<td><input name="userpassword2" type="password"
								id="user_password2">*</td>
					</tr>
						<tr>
							<th>个性签名</th>
							<td><input name="userintro" type="text"></td>
					</tr>
						<tr>
							<th><a href="">读者注册协议</a></th>
							<td><input id="btn" type="button" onclick="check()"
								value="同意并注册"></td>
					</tr>
						<tr>
							<th></th>
							<td id="err">带*的不能为空</td>
					</tr>
						<tr>
							<th></th>
							<td id="spanUserId">用户名必须唯一</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
	<div style="clear: float; clear: both;"></div>
	<%@ include file="/view/share/include/bottom2.jsp"%>
</body>
</html>