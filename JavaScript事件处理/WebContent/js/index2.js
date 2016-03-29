function onmousemoveFunc()
{
	var img1 = document.getElementById("img1");
	document.getElementById("info").innerHTML = "鼠标在移动";
}

function onmouseoverFunc()
{
	var img1 = document.getElementById("img1");
	var alt_val = img1.getAttribute("alt");
	document.getElementById("info").innerHTML = alt_val;
}

function onmouseoutFunc()
{
	
	document.getElementById("info").innerHTML = "";
}