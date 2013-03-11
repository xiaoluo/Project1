<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signup1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/signup1.css">
	
	<script type="text/javascript">
		function validate()
		{
			var username = document.getElementById("username").value;
			var email = document.getElementById("email").value;
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("repassword").value;
			
			if(username.length < 3)
			{
				alert("用户名长度要大于3位，请重新输入！");
				document.getElementById("username").focus();
				return false;
			}
			if(email.indexOf("@") == -1)
			{
				alert("请输入合法的email！");
				document.getElementById("email").focus();
				return false;
			}
			if(password.length < 6)
			{
				alert("密码的长度要大于6位，请重新输入！");
				document.getElementById("password").focus();
				return false;
			}
			if(password != repassword)
			{
				alert("两次输入的密码不相同，请重新输入！");
				document.getElementById("repassword").focus();
				return false;
			}
			return true;
		}
	</script>
	
  </head>
  
  <body>
	
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
						新教员注册第一步：
						<span>选择用户名、密码、身份</span>
					</h1>			
				</ul>
				
				<form action="teacherLoginAction.action" onsubmit="return validate();">
					<table class="zhuc" width="640" cellspacing="0" cellpadding="0" border="0" style="margin: auto; clear: both;">
						<tr>
							<td width="115">
								<div align="right">
									<span class="xingh">*</span>
									<strong>用 户 名：</strong>
								</div>
							</td>
							<td width="215">
								<input id="username" type="text" style="width: 200px" name="username" value="" size="16" maxlength="16">
							</td>
							<td width="0"></td>
							<td width="290">
								<div id="username_prompt">请输入您的用户名，长度大于3位，登录时候用。</div>
							</td>
						</tr>
						
						<tr>
							<td width="115">
								<div align="right">
									<span class="xingh">*</span>
									<strong>E-mail：</strong>
								</div>
							</td>
							<td width="215">
								<input id="email" type="text" style="width: 200px" name="email" onchange="check_email(this.value)" value="" size="16" maxlength="30">
							</td>
							<td width="0"></td>
							<td width="290">
								<div id="email_prompt">请输入您Email</div>
							</td>
						</tr>
						
						<tr>
							<td>
								<div align="right">
									<span class="xingh">*</span>
									<strong>密    码：</strong>
								</div>
							</td>
							<td>
								<input id="password" type="password" style="width: 200px" name="password" value="" size="16" maxlength="16">
							</td>
							<td width="0"></td>
							<td width="290">密码只能使用字母/数字/下划线,长度大于6位</td>
						</tr>
						
						<tr>
							<td>
								<div align="right">
									<span class="xingh">*</span>
									<strong>重复密码：</strong>
								</div>
							</td>
							<td>
								<input id="repassword" type="password" style="width: 200px" name="repassword" value="" size="16" maxlength="16">
							</td>
							<td width="0"></td>
							<td width="290">同上,请确保2次输入一致</td>
						</tr>
						
						<tr>
							<td>
								<div align="right">
									<span class="xingh">*</span>
									<strong>选择身份：</strong>
								</div>
							</td>
							<td id="shenf" colspan="3">
								<input type="radio" style="margin-right: 10px; border: 0px;" checked="checked" name="teacher_type" value="2">
								在校大学生(研究生) ,不含留学生
								<br>
								<input type="radio" style="margin-right: 10px; border: 0px;" name="teacher_type" value="1">
								教师(在职/进修/离职/退休)
								<br>
								<input type="radio" style="margin-right: 10px; border: 0px;" name="teacher_type" value="3">
								其他(已经毕业离校的人员)
							</td>
						</tr>
						
						<tr>
							<td> </td>
							<td> </td>
							<td colspan="2"> </td>
						</tr>
						
						<tr height="50">
							<td colspan="4">
								<div align="center">
									<input id="" class="next" type="submit" name="" value="">
								</div>
								</td>
						</tr>
						
						<tr>
							<td> </td>
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
				
				<div class="dlright">
					<p>
						已经是会员，请
						<a href="/signin.php">登录</a>
					</p>
					<p> </p>			
				</div>
			</div>
		
		</div>
	
		<jsp:include page="/common/foot.jsp"></jsp:include>
	</div>
	
  </body>
</html>
