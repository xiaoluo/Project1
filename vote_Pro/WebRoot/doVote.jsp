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
    
    <title>My JSP 'doVote.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function showVote()
		{
			window.document.location.href="displyVoteResult.jsp";
		}
	
	</script>

  </head>
  
  <body>

	
	<s:iterator value="#request.channel.votes" id="vote">
		
		<font color="blue" size="5"><s:property value="#vote.voteName"/></font><br><hr>
		
			<form action="accountVoteAction.action">
			
				<s:iterator value="#vote.options" id="option">
				
						<input type="radio" name="voteOption" value="<s:property value="#option.voteOptionName"/>"><s:property value="#option.voteOptionName"/><br>
					
				</s:iterator><br>
				
				<input type="button" value="查看投票结果" onclick="showVote();">
				
				<input type="submit" value="投票">&nbsp;
				
				<input type="hidden" name="id" value="<s:property value="#request.channel.id"/>">
				
				<input type="reset" value="重置">
				
			</form>
			
	</s:iterator>
	
  </body>
</html>
