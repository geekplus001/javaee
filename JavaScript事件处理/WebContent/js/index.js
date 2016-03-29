function onfocusFunc()
{
	document.getElementById("name_info").innerHTML = "请输入名字";
}

function checkboxFunc(){
	//document.getElementById("likes")
	var myform = document.forms["myform"];
	var _likes = myform.likes;
	var s = "";
	for(i = 0;i<_likes.length;i++){
		if(_likes[i].checked)
			{
				s = s + _likes[i].value +",";
			}
		
	}
	alert(s);
}

function radioboxFunc()
{
	var myform = document.forms["myform"];
	var sex_value = myform.sex; 
	//alert(sex_value);
	for(var i = 0;i<sex_value.length;i++){
		if(sex_value[i].checked)
			{
				alert(sex_value[i].value);
			}
		
	}
	
}

function selectFunc()
{
	var myform = document.forms("myform");
	var select_city = myform.city;
	//alert(select_city.value);
	var  options = select_city.options;
	for(var i = 0;i<options.length;i++)
		{
			alert(options[i].value);
		}
	
}