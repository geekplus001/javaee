<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加图书</title>
</head>

<script type="text/javascript">
	function check()
	{
		 var bookname = document.getElementById("bookname").value;
		 var bookprice = document.getElementById("bookprice").value;
		 var authorname = document.getElementById("authorname").value;
		 var publishinghouse = document.getElementById("publishinghouse").value;
		 var authorintro = document.getElementById("authorintro").value;
		 var bookintro = document.getElementById("bookintro").value;
		 var bookstock = document.getElementById("bookstock").value;
		  if(bookname=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>书名不能为空</font>";
		 }
		 else  if(bookprice=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>价格不能为空</font>";
		 }
		 else if(authorname=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>书作者不能为空</font>";
		 }
		 else if(publishinghouse=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>出版社不能为空</font>";
		 }
		 else if(authorintro=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>作者简介不能为空</font>";
		 }
		 else if(bookintro=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>书籍简介不能为空</font>";
		 }
		 else if(bookstock=="")
		 {
		 document.getElementById("err").innerHTML="<font color='red'>数量不能为空</font>";
		 }
		 else document.getElementById("myform").submit();
		 
	}
</script>

<style type="text/css">
table {
	margin-top: 30px;
}
</style>
<body>
	<form id="myform" action="<%=request.getContextPath() %>/BookServlet?method=add"
	method="post" enctype="multipart/form-data">
		<table align="center" cellpadding="10px">
			<tr>
				<th valign="top">选择书类：</th>
				<td><select name="bookcategory">
						<c:forEach items="${sessionScope.categories }" var="cate">
							<option value="${cate.categoriesName }">${cate.categoriesName }</option>
						</c:forEach>
				</select></td>
		</tr>
			<tr>
				<th valign="top">书名：</th>
				<td><input type="text" name="bookname" id="bookname"></td>
		</tr>
			<tr>
				<th valign="top">价格：</th>
				<td><input type="text" name="bookprice" id="bookprice"></td>
		</tr>
			<tr>
				<th valign="top">作者：</th>
				<td><input type="text" name="authorname" id="authorname"></td>
		</tr>
			<tr>
				<th valign="top">出版社：</th>
				<td><input type="text" name="publishinghouse" id="publishinghouse"></td>
		</tr>
			<tr>
				<th valign="top">作者简介：</th>
				<td><textarea rows="4" cols="50" id="authorintro" name="authorintro"></textarea>
			</td>
		</tr>
			<tr>
				<th valign="top">图书简介：</th>
				<td><textarea rows="6" cols="50" name="bookintro" id="bookintro"></textarea></td>
		</tr>
			<tr>
				<th valign="top">数量：</th>
				<td><input type="text" name="bookstock" id="bookstock"></td>
		</tr>
			<tr>
				<th valign="top">上传图片</th>
				<td><input type="file" name="upfile" id="upfile"></td>
		</tr>
			<tr>
				<th valign="top"></th>
				<td><input type="button" value="确认增加" onclick="check()"></td>
		</tr>
		<tr>
			<th></th>
			<td id="err"></td>
		</tr>
	</table>
</form>
</body>
</html>