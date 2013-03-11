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
    
    <title>用户注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	
	<script type="text/javascript">

		function validate()
		{
			var username = document.getElementById("username1").value;
			var password = document.getElementById("password1").value;
			var repassword = document.getElementById("repassword1").value;
			
			if(username == "")
			{
				alert("对不起，请填写用户名！");
				document.getElementById("username1").focus();
				return false;
			}
			if(username.length < 4 || username.length > 10)
			{
				alert("用户名长度应位于4-10之间!");
				document.getElementById("username1").focus();
				return false;
			}
			if(password.length < 4 || password.length > 15)
			{
				alert("密码为空或者密码格式不合法，密码长度在4位到15位之间，请重新输入！");
				document.getElementById("password1").focus();
				return false;
			}
			if(password != repassword)
			{
				alert("两次输入密码不相同，请重新输入!");
				document.getElementById("repassword1").focus();
				return false;
			}
			
			alert("恭喜你注册成功，页面将跳转到登陆界面！");
			
			return true;
		}
	</script>
  </head>
  
  <body id="body">

	 <div><font id="font1">欢迎来到注册界面，请填写好您的用户信息</font></div>
			<br/>
			<div >
				<form action="userLoginAction.action" id ="form1" name="form1" method="post" onsubmit="return validate();" target="_top" >
					<table width="100%" align="center" border="0" cellpadding="0" cellspacing="1">
					  <tr height="29">
						<td align="right"><font id="font1">用  户  名：</font></td>
						<td><input name="username" id="username1" size="40"/></td>
					  </tr>
					  <tr height="29">
						<td align="right"><font id="font1">密码：</font></td>
						<td><input type="password" name="password" id="password1" size="40"/></td>
					  </tr>
					  </tr>
					  <tr height="29">
						<td align="right"><font id="font1">确认密码：</font></td>
						<td><input type="password" name="repassword" id="repassword1" size="40"/></td>
					  </tr>
						<td height="40" colspan="2" align="center">
							<input type="submit" value="" class="button1"/>
							<input type="reset" value="重置" class="button2"/>
						</td>
					  </tr>
					</table>
				</form>		
			</div>
   		</div>
  </body>
</html>
