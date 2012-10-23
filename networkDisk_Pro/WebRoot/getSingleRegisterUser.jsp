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
    
    <title>My JSP 'getSingleRegisterUser.jsp' starting page</title>
    
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

	<h1><font color="blue">注册用户详细信息</font></h1><hr>
	<font color="red">(注: 权限1=管理员，权限2=注册用户)</font><br>
	id: <s:property value="#request.authority.id"/><br>
	用户名: <s:property value="#request.authority.authorityName"/><br>
	密码: <s:property value="#request.authority.password"/><br>
	权限: <s:property value="#request.authority.level"/>

  </body>
</html>
