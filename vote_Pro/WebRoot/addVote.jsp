<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addVote.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
	
	<script type="text/javascript">
	
		$(function()
		{
			$("#button").click(function()
			{	
				 var html = "<label>选项5名称:</label><input type='text' name='voteOptionName'/><br>";
				 
				 $("#div").append($(html));
			})
			
		})
		
		function back()
		{
			window.document.location.href = "admin.jsp";
		}
		
	</script>

  </head>
  
  <body>

	<h3><font color="blue" size="10">新增投票</font></h3><hr>
	
	<center>
		<form action="addVoteAction.action">
			选择投票频道: <select name="channelName">
						<option>NBA</option>
						<option>世界杯</option>
						<option>网球</option>
						<option>斯诺克</option>
					</select><br>
			请输入投票名称：<input type="text" name="voteName"><br>
			选项1名称:<input type="text" name="voteOptionName"><br>
			选项2名称:<input type="text" name="voteOptionName"><br>
			选项3名称:<input type="text" name="voteOptionName"><br>
			选项4名称:<input type="text" name="voteOptionName"><br>
			<div id="div"></div>
			<input type="button" value="新增投票选项" id="button">
			<input type="submit" value="发布">
			<input type="reset" value="重置">
			<input type="button" value="返回" onclick="back();">
		</form>
		
	</center>

  </body>
</html>
