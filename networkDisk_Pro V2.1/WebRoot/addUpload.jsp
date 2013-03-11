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
    
    <title>管理员添加文件界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
	<script type="text/javascript" src="script/jquery-1.8.1.js"></script>
	<script type="text/javascript">
	
		$(function()
		{
			$("#button1").click(function()
			{
				var file = $("<input type='file' name='file'>");
				var remove2 = $("<input type='button' value='删除''><br>");
				
				$("#div1").append(file).append(remove2);
				
				remove2.click(function()
				{
					file.remove();
					remove2.remove();
				})
			})
			$("#button2").click(function()
			{
				window.document.location.href = "adminManager.jsp?username=<%= request.getParameter("username") %>";
			})
		})
		
		
	
	</script>

  </head>
  
  <body id="body">

	<font color="red" size="4"><%= request.getParameter("username") %>: 欢迎您</font>
	<h2><font color="blue">欢迎来到文件上传界面</font></h2><hr>
	
	<font color="red" size="4" style="font-weight: bold;">请选择您要上传的文件，点击添加将可以一次上传多个文件!</font><br>
	<form action="uploadAction.action" method="post" enctype="multipart/form-data">
	
		<input type="file" name="file">
		<input type="button" value="添加" id="button1">
		<div id="div1"></div><br>
		<input type="submit" value="上传">
		<input type="button" value="返回" id="button2">
	
	</form>

  </body>
</html>
