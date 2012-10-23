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
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
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
	
		<h1><font color="red">欢迎来到小罗的网盘下载系统</font></h1><hr>
		
		<s:actionerror cssStyle="color: red"/>
		<s:form action="adminAction.action">
		
			<s:textfield name="username" label="管理员"></s:textfield>
			<s:password name="password" label="密码"></s:password>
			
			<s:submit value="登陆"></s:submit>
			<s:reset value="重置"></s:reset>
		
		</s:form>


	</center>

  </body>
</html>
