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
    
    <title>My JSP 'userLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		
		<center>  		
			<h1><font color="blue">欢迎来到小罗的网盘下载系统</font></h1><hr>
		
			
			<font color="red" size="4">请输入你的用户名和密码：</font><br><br>
			
			<form action="loginValidateAction.action">
			
				<s:actionerror cssStyle="color: red"/>
			
				用户名： <input type="text" name="username"><br>
				密码：    &nbsp; <input type="password" name="password"><br>
				
				请输入验证码 :&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="checkCode">
				<img alt="1" src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新"><br><br>
				
				<input type="submit" value="登陆">&nbsp;
				<input type="reset" value="重置"><br><br/>
				
				<font color="red">还没有用户名或密码?</font>&nbsp;&nbsp;&nbsp;
				<a href="userRegister.jsp">注册</a>
			
			</form>
			
		</center>
		
  </body>
</html>
