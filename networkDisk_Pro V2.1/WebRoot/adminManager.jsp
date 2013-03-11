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
    
    <title>管理员管理界面</title>
    
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
	<h1><font color="blue">管理员权限</font></h1><hr>
	
	<table>
		<tr>
			<td><input type="button" class="button3" value="上传文件" onclick="window.document.location.href='addUpload.jsp?username=<%= request.getParameter("username") %>';"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="查看已上传文件" onclick="window.document.location.href='listAllUploadAction.action?username=<%= request.getParameter("username") %>&authority=admin'"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="查看已注册用户" onclick="window.document.location.href='listAuthorityAction.action?username=<%= request.getParameter("username") %>'"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="审核用户上传文件" onclick="window.document.location.href='auditUserUploadAction.action?username=<%= request.getParameter("username") %>'"></td>
		</tr>
		<tr>
			<td><input type="button" class="button3" value="退出登陆" onclick="window.document.location.href='adminLogin.jsp';"></td>
		</tr>
	</table>

  </body>
</html>
