function validate2()
{
	var realName = document.getElementById("realName").value;
	var birthday = document.getElementById("birthday").value;
	var major = document.getElementById("major").value;
	var homePro = document.getElementById("homePro").value;
	var highSchool = document.getElementById("highSchool").value;
	var identity = document.getElementById("identity").value;
	var educationalLevel = document.getElementById("educationalLevel").value;
	var college = document.getElementById("college").value;
	var idcard = document.getElementById("idcard").value;
	var city = document.getElementById("city").value;
	var cityPos = document.getElementById("cityPos").value;
	var work_pos = document.getElementById("workPos").value;
	var mobile = document.getElementById("mobile").value;
	var telephone = document.getElementById("telephone").value;
	var qq = document.getElementById("qq").value;
	var address = document.getElementById("address").value;
	var postCode = document.getElementById("postCode").value;
	
	if(realName == "")
	{
		alert("请输入真实姓名！");
		return false;
	}
	if(birthday == "")
	{
		alert("请选择出生年月！");
		return false;
	}
	if(major == "")
	{
		alert("请填写专业名称！");
		return false;
	}
	if(homePro == "")
	{
		alert("请选择现居省份！");
		return false;
	}
	if(highSchool  == "")
	{
		alert("请填写你的高中学校名称！");
		return false;
	}
	if(identity == "")
	{
		alert("请选择你目前的身份！");
		return false;
	}
	if(educationalLevel == "")
	{
		alert("请选择你目前的学历！");
		return false;
	}
	if(college == "")
	{
		alert("请选择你所在大学！");
		return false;
	}
	if(idcard.length != 18 && idcard.length != 15)
	{
		alert("请输入合法的身份证号码！");
		return false;
	}
	if(isNaN(idcard))
	{
		alert("请输入合法的身份证号码！");
		return false;
	}
	if(city == "")
	{
		alert("请选择现居城市！");
		return false;
	}
	if(cityPos == "")
	{
		alert("请选择家庭位置！");
		return false;
	}
	if(workPos == "")
	{
		alert("请选择工作位置！");
		return false;
	}
	if(mobile.length != 11)
	{
		alert("请填写合法的手机号码！");
		return false;
	}
	if(isNaN(mobile))
	{
		alert("请填写合法的手机号码！");
		return false;
	}
	if(telephone == "")
	{
		alert("请填写合法的电话号码！");
		return false;
	}
	if(isNaN(telephone))
	{
		alert("请填写合法的电话号码！");
		return false;
	}
	if(qq == "")
	{
		alert("请输入你的QQ！");
		return false;
	}
	if(qq.length > 12)
	{
		alert("请填写合法的QQ！");
		return false;
	}
	if(isNaN(qq))
	{
		alert("请填写合法的QQ！");
		return false;
	}		
	if(address == "")
	{
		alert("请填写通讯地址！");
		return false;
	}
	if(postCode == "")
	{
		alert("请填写合法的邮编！");
		return false;
	}
	if(isNaN(postCode))
	{
		alert("请填写合法的邮编！");
		return false;
	}
	return true;
}

function checkSubmit() {
	if (document.getElementById("courseName").value == "") 
	{
		alert("请选择您的求教学科。");
		document.getElementById("courseName").focus();
		return false;
	}
	if (document.getElementById("grade").value == "")
	{
		alert("请选择您的学员年级。");
		return false;
	}
	if (document.getElementById("details").value == "") 
	{
		alert("请填写学员详情。");
		document.getElementById("details").focus();
		return false;
	}
	if (document.getElementById("tea_fee").value == "")
	{
		alert("请填写课时费。");
		document.getElementById("tea_fee").focus();
		return false;
	}
	if (document.getElementById("contact").value == "") 
	{
		alert("请输入联系人。");
		document.getElementById("contact").focus();
		return false;
	}
	var m = document.getElementById("mobile");
	if (m.value == "") 
	{
		alert("请输入你的手机号码！");
		m.focus();
		return false;
	}
	var reg = /^(?:13\d|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|4|5|6|7|8|9]|147)-?\d{5}(\d{3}|\*{3})$/;
	if (reg.test(m.value) == false)
	{
		alert("请输入正确的手机号码！");
		m.focus();
		return false;
	}
	if (document.getElementById("area_cross").value == "") 
	{
		alert("请输入交叉路口。");
		document.getElementById("area_cross").focus();
		return false;
	}
	if(document.getElementById("checkCode").value == "")
	{
		alert("请输入验证码。");
		document.getElementById("checkCode").focus();
		return false;
	}
	return true;
}