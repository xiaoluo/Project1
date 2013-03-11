var xmlrequest;
function createXMLHttpRequest() {
  
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
	}
}

//响应用户点击省市
function setCityTowns() {
	
	// 获得id为homePro的select元素中被选中的option的属性为id的值	
	var cityId = $("#city :selected").attr("value");
	createXMLHttpRequest();
	if (xmlrequest) {
		//准备发送请求
		var req = "/jiajiaowang/changeTownInfoAction.action?cityId=" + cityId;
		//打开请求
		xmlrequest.open("get", req, true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getCityTowns;
		//发送请求
		xmlrequest.send();
	}
}

function getCityTowns() {
	//完成
	if (xmlrequest.readyState == 4) {
		//成功返回!
		if (xmlrequest.status == 200) {
			// 获取到返回的数据
			var townData = xmlrequest.responseText;
			
			// 得到的townData是json数据，但是类型是String类型，所以需要通过JSON。parse(townData)将其转换成json类型
			var townData2 = JSON.parse(townData);
			
			// 更新家庭位置
			var home = '<select id="cityPos" name="cityPos" size="1">';
			for(var i = 0; i < townData2.length; i++)
			{
				home += '<option value="' + townData2[i].id + '">' + townData2[i].townName + "</option>";
			}
			home += "</select>";
			$("#change_cityPos").html(home);
			
			// 更新学校位置
			var work = '<select id="workPos" name="workPos" size="1">';
			for(var i = 0; i < townData2.length; i++)
			{
				work += '<option value="' + townData2[i].id + '">' + townData2[i].townName + "</option>";
			}
			work += "</select>";
			$("#change_workPos").html(work);
		}
	}
}

// 响应用户点击省份，来切换城市
function setProCities()
{
	// 获得id为homePro的select元素中被选中的option的属性为id的值	
	var proid = $("#homePro :selected").attr("value");
	createXMLHttpRequest();
	if (xmlrequest) {
		// 判断proid是否为数字，如果不为数字，或者字符串不能转换成数字，isNaN函数返回true，否则返回false
		if(!isNaN(proid))
		{
			//准备发送请求
			var req = "/jiajiaowang/changeCityInfoAction.action?proId=" + proid;
		}
		else
		{
			var req = "/jiajiaowang/changeCityInfoAction.action?proId=18";
		}
		//打开请求
		xmlrequest.open("get", req, true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getProCities;
		//发送请求
		xmlrequest.send(req);
		}
}

function getProCities()
{
	if(xmlrequest.readyState == 4)
		{
			if(xmlrequest.status == 200)
				{
					var data = xmlrequest.responseText;
					// 得到的data是json数据，但是类型是String类型，所以需要通过JSON。parse(cities)将其转换成json类型
					var data2 = JSON.parse(data);
					
					// 从data2中解析出城市的数据
					var cities2 = data2[0];
					
					// 从data2中解析出大学的数据
					var universities = data2[1];
					
					// 更新城市
					var city = '<select id="city" onchange="setCityTowns();" name="homeCity" size="1">';
					for(var i = 0; i < cities2.length; i++)
					{
						city += '<option value="' + cities2[i].id + '">' + cities2[i].cityName + "</option>";
					}
					city += "</select>";
					$("#change_city").html(city);
					
					// 更新大学
					var university = '<select id="college" name="uniSchool" size="1">';
					for(var i = 0; i < universities.length; i++)
					{
						university += '<option value="' + universities[i].id + '">' + universities[i].universityName + "</option>";
					}
					university += "</select>";
					$("#change_college").html(university);
				}
		}
}