//检验控件值是否为空
function checkNull(obj,name)
{
	if(name=="undefined") return true;
	if(obj.value.length == 0)
	{
		alert(name + "不能为空！");
		obj.focus();
		obj.select();
		return false;
		
	}
	return true;
}

//检查控件值是否为空，没有提示，只是做个判断
function isNull(obj)
{
	if(name=="undefined") return true;
	if(obj.value.length == 0)
	{
		return false;
	}
	return true;
}

//检验控件长度
function checkLength(obj,name,minLens,maxLens)
{
	if(minLens==null||minLens=="underfined") minLens = 0;
	if(maxLens==null||maxLens=="underfined") maxLens = 100000;
	
	var tlen = obj.value.length;
	if(tlen == 0 || (tlen>=minLens && tlen<=maxLens))
	{
		return true;
	}
	if(minLens<maxLens)
	{
		alert(name + "的长度必须在" + minLens + "位和" + maxLens + "位之间");
	}
	else
	{
		alert(name + "的长度必须是" + maxLens + "位zhixia");
	}
	obj.focus();
	obj.select();
	return false;
}

//检查不超过（或等于）n位的数字
function ChKDigit(obj,n,flag)
{
	var num=obj.value;
	if(num=="") return true;
	for(var i=0;i<num.length;i++)
	{
		if(isDigit(num.charAt(i))==false)
		{
			alert("请输入数字");
			return false;
		}
	}
	if(flag)
	{
		if(num.length!=n)
		{
			alert("请输入"+n+"位数字");
			return false;
		}
	}
	else
	{
		if(num.length>n)
		{
			alert("请输入不超过"+n+"位的数字");
			return false;
		}
	}
	return false;
}

function isDigit(theNum)
{
	var theMask = "0123456789";
	if(theNum=="")
	{
		return true;
	}
	else if(theMask.indexOf(theNum)==-1)
	{
		return false;
	}
	return true;
}

//检验控件数字
function checkNumber(obj,name,min,max,decLens)
{
	if(name=="undefined") return true;
	tlen = obj.value.length;
	var dPoint = obj.value.indexOf(".");
	if(dPoint!=-1 && decLens==0)
	{
		alert(name+"的值必须为整数");
		obj.focus();
		obj.select();
		return false;
	}
	str1 = "+-0123456789";
	str2 = "0123456789.";
	for(i=0;i<=obj.value.length-;i++)
	{
		char1 = obj.value.subString();
		if(i==0)
		{
			if(str1.indexOf(char1)==)
			{
				
			}
		}
	}
}