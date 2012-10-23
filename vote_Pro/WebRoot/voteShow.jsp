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
    
    <title>My JSP 'voteShow.jsp' starting page</title>
    
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
		<h3><font color="blue" size="10">请选择你要投票的名称</font></h3>
	</center>

	<table align="center" width="60%" border="1" bordercolor="yellow">
	
		<tr>
			<th>投票序号</th>
			<th>投票名称</th>
		</tr>
		
		<s:iterator value="#request.channels" id="channel" status="st">
			
			<tr>
				<th><s:property value="#st.index + 1"/></th>
				
				<s:iterator value="#channel.votes" id="vote">
					<th><s:a href="doVoteAction.action?id=%{#channel.id}"><s:property value="#vote.voteName"/></s:a></th>
				</s:iterator>
			</tr>
			
		</s:iterator>
	
	</table>

  </body>
</html>
