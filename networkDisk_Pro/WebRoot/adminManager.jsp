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
    
    <title>My JSP 'adminManager.jsp' starting page</title>
    
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

	<font color="red" size="4"><%= request.getParameter("username") %>: 欢迎您</font>
	<h1><font color="blue">管理员权限</font></h1><hr>
	
	<a href="addUpload.jsp?username=<s:property value="username"/>">上传文件</a><br><br>
	<a href="listAllUploadAction.action">查看已上传文件</a><br><br>
	<a href="listAuthorityAction.action">查看已注册用户</a>

  </body>
</html>
