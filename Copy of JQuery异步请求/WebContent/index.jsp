<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src = "./jquery/jquery-1.11.3.js"></script>
<script type="text/javascript" src = "./jquery/jquery-ui.js"></script>
<script type="text/javascript" src = "./jquery/jquery-ui.css"></script>
<link href = "./jquery/jquery-ui.css" rel = "stylesheet"/>


<script type="text/javascript">
	$(function(){
		$("#state").load("MyServlet");
		
		$("#btn").click(function(){
			$.post("PostServlet",function(data){
				$("#div1").html(data);
			});	
		});
	})
</script>


</head>
<body>
	<div id = "state">数据正在加载中。。。</div>
	
	
	<div>
		<input type = "button" id = "btn" value = "刷新"/>
	</div>
	<div id = "div1"></div>
	
</body>
</html>