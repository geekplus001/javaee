function isAge()
{
	var age = document.getElementById("age").value;
	if(/^[0-9]{1,3}$/.test(age))
		{
			document.getElementById("info1").innerHTML = "年龄合法";
		}
	else
		{
			document.getElementById("info1").innerHTML = "请输入一到三位的数字";
		}
}


function isNumber()
{
	var number = document.getElementById("number").value;
	if(/^\d*\.?\d+$/.test(number))
		{
			document.getElementById("info2").innerHTML = "数字合法";
		}
	else
		{
			document.getElementById("info2").innerHTML = "数字不合法";
		
		}
	
}

function isId()
{
	var id = document.getElementById("id").value;
	if(/^\d{15}$/.test(id)||/^\d{17}(?:\d|x)$/.test(id))
		{
			document.getElementById("info3").innerHTML = "身份证号码合法";
		}
	else
		{
			document.getElementById("info3").innerHTML = "身份证号码不合法";
		
		}
	
}

function isEmail()
{
	var ss = document.getElementById("email").value;

	if(/^\w+([+-.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+*)$/.test(ss))
		{
			document.getElementById("info4").innerHTML = "邮箱合法";
		}
	else
		{
			document.getElementById("info4").innerHTML = "邮箱不合法";
		
		}
	
}