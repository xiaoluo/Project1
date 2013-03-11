<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
  </head>
  
  <body>
		
	<div class="container">
		<section id="content">
			<s:actionerror cssStyle="color: red"/>
			<form action="loginValidateAction.action" method="post">
				<h1>会员登陆</h1>
				<div>
					<input type="text" placeholder="登陆名" required="" name="username" />
				</div>
				<div>
					<input type="password" placeholder="密码" required="" name="password" />
				</div>
				<div>
					<input type="text" placeholder="验证码" required="" name="checkCode" >
				</div>
				<div>
					<img alt="1" src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新">
				</div>
				<div>
					<input type="submit" value="登陆" />
					<input type="button" value="注册" onclick="window.document.location.href='userRegister.jsp'"/>
				</div>
			</form>
		</section><!-- content -->
	</div><!-- container -->
		
  </body>
</html>
