<%@ page language="java" import="java.util.*, com.xiaoluo.model.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showVoteResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		function del()
		{
			if(confirm("确定要删除吗?"))
			{
				return true;
			}
			return false;
		}
	
	</script>

  </head>
  
  <body>

	<h3><font color="blue" size="10">投票管理</font></h3><hr>
	
	<table width="80%" align="center" border="1">
	
		<tr>
			<th>投票序号</th>
			<th>投票名称</th>
			<th>投票选项1</th>
			<th>投票选项2</th>
			<th>投票选项3</th>
			<th>投票选项4</th>
			<th>删除	  </th>
		</tr>
		
		<s:iterator value="#request.channel" id="channel" status="st">
		
			<tr>
				<th><s:property value="#st.index + 1"/></th>
				
					<s:iterator value="#channel.votes" id="vote">
					
						<th><s:property value="#vote.voteName"/></th>
						
							<s:iterator value="#vote.options" id="option">
								<th><s:property value="#option.voteOptionName"/></th>
							</s:iterator>
				
					</s:iterator>
					
				<th><s:a href="deleteVoteAction.action?id=%{#channel.id}" onclick="return del()">
				<font color="red">×[删除]</font></s:a></th>
				
			</tr>
			
		</s:iterator>
	
	</table>

  </body>
</html>
