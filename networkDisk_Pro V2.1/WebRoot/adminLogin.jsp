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
    
    <title>管理员登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	
  </head>
  
  <body>

	<div class="container">
		<section id="content">
			<s:actionerror cssStyle="color: red"/>
			<form action="adminAction.action" method="post">
				<h1>管理员登陆</h1>
				<div>
					<input type="text" placeholder="登陆名" required="" name="username" />
				</div>
				<div>
					<input type="password" placeholder="密码" required="" name="password" />
				</div>
				<div style="text-align:center; margin-left:auto; margin-right:auto;">
					<input type="submit" value="登陆"/>
					<a href="#">您是普通会员?</a>
				</div>
			</form>
		</section><!-- content -->
	</div><!-- container -->

  </body>
</html>
