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
    
    <title>My JSP 'userRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
		function validate()
		{
			var username = document.getElementById("username1").value;
			var password = document.getElementById("password1").value;
			var repassword = document.getElementById("repassword1").value;
			
			if(username.length < 4 || username.length > 10)
			{
				alert("用户名长度应位于4-10之间");
				return false;
			}
			if(password.length < 4 || password.length > 10)
			{
				alert("密码长度应位于4-10之间");
				return false;
			}
			if(password != repassword)
			{
				alert("两次输入密码不相同，请重新输入");
				return false;
			}
			
			alert("恭喜你注册成功，页面将跳转到登陆界面！");
			
			return true;
		}
	
	</script>

  </head>
  
  <body>

	<h1><font color="red">欢迎来到用户注册界面</font></h1><hr>
	
		<form action="userLoginAction.action" onsubmit="return validate();">
		
			用户名: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" id="username1"> <font color="red">(用户名长度位于4-10之间)</font><br> 
			密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password1"> <font color="red">(密码长度位于4-10之间)</font><br> 
			再次输入密码:<input type="password" name="repassword" id="repassword1"><br> 
			
			<input type="submit" value="注册">
			<input type="reset" value="清空">
		
		</form>
		
  </body>
</html>
