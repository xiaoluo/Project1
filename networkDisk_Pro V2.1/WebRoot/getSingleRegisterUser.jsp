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
    
    <title>个人注册信息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/common.css">
  </head>
  
  <body id="body">
	<h1><font color="blue">注册用户详细信息</font></h1><hr>
	<font color="red" style="font-weight: bold;">(注: 权限1=管理员，权限2=注册用户)</font><br><br>
	
	<table class="table1" width="30%">
		<tr>
			<td>id: </td>
			<th><s:property value="#request.authority.id"/></th>
		</tr>
		<tr>
			<td>用户名: </td>
			<th><s:property value="#request.authority.authorityName"/></th>
		</tr>
		<tr>
			<td>密码: </td>
			<th><s:property value="#request.authority.password"/></th>
		</tr>
		<tr>
			<td>权限: </td>
			<th><s:property value="#request.authority.level"/></th>
		</tr>
	</table>

  </body>
</html>
