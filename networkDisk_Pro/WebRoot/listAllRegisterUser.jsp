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
    
    <title>My JSP 'listAllRegisterUser.jsp' starting page</title>
    
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
			if(confirm("你确定要删除该注册用户吗?"))
			{
				return true;
			}
			return false;
		}
	
	</script>

  </head>
  
  <body>

	<h1><font color="red">已注册用户列表</font></h1><hr>
	
	<table border="1" bordercolor="yellow" align="center" width="50%">
	
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>用户权限(2=注册用户)</th>
			<th>删除</th>
		</tr>
		
		<s:iterator value="#request.authorities" id="authority" status="st">
		
			<tr>
				<th><s:property value="#st.index + 1"/></th>
				<th><a href="getSingleRegisterUserAction.action?id=<s:property value="#authority.id"/>"><s:property value="#authority.authorityName"/></a></th>
				<th><s:property value="#authority.level"/></th>
				<th><a href="deleteRegisterUserAction.action?id=<s:property value="#authority.id"/>" onclick="return del();"><font color="red">×[删除]</font></a></th>
			</tr>
		
		</s:iterator>
	
	</table>

  </body>
</html>
