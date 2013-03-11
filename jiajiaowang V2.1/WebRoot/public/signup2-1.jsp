<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signup2-1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/signup2-1.css">
	<script type="text/javascript" src="script/jquery-1.8.1.js"></script>
	<script type="text/javascript" src="script/ajax.js"></script>
	<script type="text/javascript" src="script/validate.js"></script>

  </head>
  
  <body>
  	<!-- 如果用户没有注册就重定向到signin.jsp界面 -->
	<%
		if(session.getAttribute("teacherName") == null || "".equals(session.getAttribute("teacherName")))
		{
			response.sendRedirect("/jiajiaowang/public/signin.jsp");
		}
	%>	
	<div class="container">
			<div id="head">
			<div class="headLogo">
				<a href="/">
				<img border="0" src="/jiajiaowang/images/newtoplogo.jpg" alt="家教114">
				</a>
			</div>
			<div class="headLogin">
				<ul>
					<a style="color:#000;" rel="nofollow" href="/help/jiajiao_fee.php">资费说明</a>
					|
					<a style="color:#000;" rel="nofollow" href="/help/fukuan.php">付款方式</a>
				</ul>
			</div>
		</div>
		
		<div id="main">
			<div class="RTGcon">
				<ul class="RTGbg">
					<h1>
						<img style="margin-right: 5px;" src="/jiajiaowang/images/yuan_12.gif">
						新教员注册第二步：
						<span>填写个人基本信息</span>
					</h1>			
				</ul>
				
				<p class="RTGconMes" style="text-align: left;">
					<span id="tshi">【提示】</span>
						您所填信息越详细就越有利于检索，也就越容易获得学员的预约所以请您务必如实、详尽地填写以下各 拦。其中红色星号（
					<span style="color: #FF0000">*</span>
						）为必填您选择的是社会工作者身份,若有误请返回更改。
					<br>
					<span id="txing">【教员接单提醒】</span>
						学员若以某些理由让您先支付押金或向您借钱之类，请提高警惕，小心上当受骗，并请及时和我们联系。
				</p>
				
				<form action="teacherLoginAction2.action" onsubmit="return validate2();">
					<!-- 填写了第一个注册界面信息的教员id -->
					<input type="hidden" name="teacherId" value="<s:property value='#request.teacherId'/>">
					<table class="regTable" width="660" cellspacing="0" cellpadding="0" border="0" style="clear: both;">
						<tr>
							<td class="basic" colspan="4">
								<strong>基本信息</strong>
							</td>
						</tr>
						<tr class="tred">
							<td width="125">
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>真实姓名：</strong>
								</div>
							</td>
							<td colspan="3">
								<input id="realName" type="text" name="realName" size="20" maxlength="15">
								<span style="color: #FF0000">注意：一经填写不得修改，与证件不符，将不能通过认证</span>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
										<strong>
										<span style="margin-right: 25px;">性</span>
										别：
									</strong>
								</div>
							</td>
							<td width="199">
								<input type="radio" style="border: none" name="gender" value="1" checked="checked">
								男
								<input type="radio" style="border: none; margin-left: 20px;" name="gender" value="2">
								女
							</td>
							<td width="122">
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>出生年份：</strong>
								</div>
							</td>
							<td width="212">
								<select id="birthday" style="width: 150px;" name="birthday" size="1">
									<option value="" selected="selected">选择年份</option>
									<option value="1930">1930</option>
									<option value="1931">1931</option>
									<option value="1932">1932</option>
									<option value="1933">1933</option>
									<option value="1934">1934</option>
									<option value="1935">1935</option>
									<option value="1936">1936</option>
									<option value="1937">1937</option>
									<option value="1938">1938</option>
									<option value="1939">1939</option>
									<option value="1940">1940</option>
									<option value="1941">1941</option>
									<option value="1942">1942</option>
									<option value="1943">1943</option>
									<option value="1944">1944</option>
									<option value="1945">1945</option>
									<option value="1946">1946</option>
									<option value="1947">1947</option>
									<option value="1948">1948</option>
									<option value="1949">1949</option>
									<option value="1950">1950</option>
									<option value="1951">1951</option>
									<option value="1952">1952</option>
									<option value="1953">1953</option>
									<option value="1954">1954</option>
									<option value="1955">1955</option>
									<option value="1956">1956</option>
									<option value="1957">1957</option>
									<option value="1958">1958</option>
									<option value="1959">1959</option>
									<option value="1960">1960</option>
									<option value="1961">1961</option>
									<option value="1962">1962</option>
									<option value="1963">1963</option>
									<option value="1964">1964</option>
									<option value="1965">1965</option>
									<option value="1966">1966</option>
									<option value="1967">1967</option>
									<option value="1968">1968</option>
									<option value="1969">1969</option>
									<option value="1970">1970</option>
									<option value="1971">1971</option>
									<option value="1972">1972</option>
									<option value="1973">1973</option>
									<option value="1974">1974</option>
									<option value="1975">1975</option>
									<option value="1976">1976</option>
									<option value="1977">1977</option>
									<option value="1978">1978</option>
									<option value="1979">1979</option>
									<option value="1980">1980</option>
									<option value="1981">1981</option>
									<option value="1982">1982</option>
									<option value="1983">1983</option>
									<option value="1984">1984</option>
									<option value="1985">1985</option>
									<option value="1986">1986</option>
									<option value="1987">1987</option>
									<option value="1988">1988</option>
									<option value="1989">1989</option>
									<option value="1990">1990</option>
									<option value="1991">1991</option>
									<option value="1992">1992</option>
									<option value="1993">1993</option>
									<option value="1994">1994</option>
									<option value="1995">1995</option>
									<option value="1996">1996</option>
									<option value="1997">1997</option>
									<option value="1998">1998</option>
									<option value="1999">1999</option>
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2011</option>
								</select>
							</td>
						</tr>
						<tr class="tred">
							<td>
								<div align="right">
									<span style="COLOR: #ff0000">*</span>
									<strong>
									<span style="margin-right: 25px;">专</span>
									业：
									</strong>
								</div>
							</td>
							<td>
								<input id="major" name="major" size="20" maxlength="30">
							</td>
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>现居省份：</strong>
								</div>
							</td>
							<td>
								<select id="homePro" style="width: 150px;" name="homePro" size="1" onchange="setProCities();">
									<option value="" selected="selected">请选择</option>
									<s:iterator value="#request.provinces" id="province">
										<option value="<s:property value="#province.id"/>"><s:property value="#province.proName"/></option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>高中母校：</strong>
								</div>
							</td>
							<td>
								<input id="highSchool" type="text" name="highSchool" size="20" maxlength="30">
							</td>
							<td>
								<div align="right">
									<span style="COLOR: #ff0000">*</span>
									<strong>目前身份：</strong>
								</div>
							</td>
							<td>
								<select id="identity" style="width: 150px;" name="identity" size="1">
									<option selected="selected" value="">选择身份</option>
									<option value="自学考试生">自学考试生</option>
									<option value="函授（网络）学生">函授（网络）学生</option>
									<option value="成教学生">成教学生</option>
									<option value="大专在读学生">大专在读学生</option>
									<option value="本科大一学生">本科大一学生</option>
									<option value="本科大二学生">本科大二学生</option>
									<option value="本科大三学生">本科大三学生</option>
									<option value="本科大四学生">本科大四学生</option>
									<option value="本科大五学生">本科大五学生</option>
									<option value="在读硕士生">在读硕士生</option>
									<option value="硕士进修老师">硕士进修老师</option>
									<option value="在读博士生">在读博士生</option>
									<option value="其他学生">其他学生</option>
								</select>
							</td>
						</tr>
						<tr> </tr>
						<tr class="tred">
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>目前学历：</strong>
								</div>
							</td>
							<td>
								<select id="educationalLevel" style="width: 150px;" name="educationalLevel" size="1">
									<option selected="selected" value="">选择学历</option>
									<option value="大专以下">大专以下</option>
									<option value="大专在读">大专在读</option>
									<option value="大专毕业">大专毕业</option>
									<option value="本科在读">本科在读</option>
									<option value="本科毕业">本科毕业</option>
									<option value="硕士在读">硕士在读</option>
									<option value="硕士毕业">硕士毕业</option>
									<option value="博士在读">博士在读</option>
									<option value="博士毕业">博士毕业</option>
								</select>
							</td>
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>就读高校：</strong>
								</div>
							</td>
							<td>
								<div id="change_college">
									<select id="college" name="uniSchool" size="1">
										<option value="" selected="selected">请选择</option>
										<s:iterator value="#request.universities" id="university">
											<option value="<s:property value="#university.id"/>"><s:property value="#university.universityName"/></option>
										</s:iterator>
									</select>
								</div>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>身份证/护照：</strong>
								</div>
							</td>
							<td>
								<input id="idcard" name="idcard" size="20" maxlength="40">
							</td>
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>现居城市：</strong>
								</div>
							</td>
							<td>
								<div id="change_city">
									<select id="city" onchange="setCityTowns();" name="homeCity" size="1">
										<option value="" selected="selected">请选择</option>
										<s:iterator value="#request.cities" id="city">
											<option value="<s:property value="#city.id"/>"><s:property value="#city.cityName"/></option>
										</s:iterator>
									</select>
								</div>
							</td>
						</tr>
					</table>
					<table class="regTable" width="660" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td class="basic" colspan="4">
								<strong>联系方式</strong>
							</td>
						</tr>
						<tr class="tred">
							<td width="125">
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>家庭位置：</strong>
								</div>
							</td>
							<td>
								<div id="change_cityPos">
									<select id="cityPos" name="cityPos">
										<option value="" selected="selected">请选择</option>
										<s:iterator value="#request.towns" id="town">
											<option value="<s:property value="#town.id"/>"><s:property value="#town.townName"/></option>
										</s:iterator>
									</select>
								</div>
							</td>
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>学校位置：</strong>
								</div>
							</td>
							<td>
								<div id="change_workPos">
									<select id="workPos" name="workPos">
										<option value="" selected="selected">请选择</option>
										<s:iterator value="#request.towns" id="town">
											<option value="<s:property value="#town.id"/>"><s:property value="#town.townName"/></option>
										</s:iterator>
									</select>
								</div>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>
										<span style="margin-right: 25px;">手</span>
										机：
									</strong>
								</div>
							</td>
							<td width="222">
								<input type="text" name="mobile" size="20" maxlength="11" id="mobile">
							</td>
							<td width="105">
							<div align="right">
								<span style="color: #FF0000"> *</span>
									<strong>
										<span style="margin-right: 25px;">电</span>
										话：
									</strong>
								</div>
							</td>
							<td width="206">
								<input type="text" name="telephone" size="20" maxlength="80" id="telephone">
							</td>
						</tr>
						<tr class="tred">
							<td>
								<div align="right">
									<strong>
									<span style="margin-right: 10px;">MSN/</span>
									QQ：
									</strong>
								</div>
							</td>
							<td>
								<input id="qq" type="text" size="20" name="qq">
							</td>
							<td>
								<div align="right"></div>
							</td>
							<td> </td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
								<span style="color: #FF0000">*</span>
								<strong>通信地址：</strong>
								</div>
							</td>
							<td>
								<input id="address" type="text" name="address" size="30">
							</td>
							<td>
								<div align="right">
									<span style="color: #FF0000">*</span>
									<strong>
									<span style="margin-right: 25px;">邮</span>
									编：
									</strong>
								</div>
							</td>
							<td>
								<input id="postCode" type="text" name="postCode" size="20" maxlength="6">
							</td>
						</tr>
					</table>
					<table class="wanc" width="670" cellspacing="0" cellpadding="0" border="0">				
										<tr id="next_dx">
							<td></td>
							<td>
								<input id="" class="next_x" type="submit" name="" value="">
							</td>
							<td>
								<input id="" class="next_t" type="button" onclick="location.href='/member/signup4.php';" name="" value="">
							</td>
						</tr>
					</table>
				</form>
			</div>	
			
			<div id="box_right">
				<div class="YTright">
					<p class="one">1.选择用户名、 密码 、身份</p>
					<p class="two">2.填写个人基本信息</p>
					<p class="three">3.填写家教信息</p>
				</div>
			</div>
		</div>
		
		<jsp:include page="/common/foot.jsp"></jsp:include>
	</div>
	
  </body>
</html>
