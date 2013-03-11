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
    
    <title>注册用户管理界面</title>
    
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

	<font color="red" size="4"><%= request.getParameter("username") %>: 欢迎您</font>
	<h1><font color="blue">用户权限</font></h1><hr>
	
	<table>
		<tr>
			<td><input type="button" class="button3" value="上传文件" onclick="window.document.location.href='addUserUpload.jsp?username=<s:property value="username"/>&id=<s:property value="id"/>';"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="查看管理员已上传文件" onclick="window.document.location.href='listAllUploadAction.action?authority=user'"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="管理自己上传的文件" onclick="window.document.location.href='listUserUploadAction.action?id=<%= request.getAttribute("id") %>'"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="退出登陆" onclick="window.document.location.href='userLogin.jsp'"></td>
		</tr>
	</table>

  </body>
</html>
