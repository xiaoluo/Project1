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
    
    <title>审核用户上传文件界面</title>
    
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
	
	<h1><font color="blue">审核用户上传文件</font></h1><hr>
	
	<div style="float: inherit;">
		<table width="100%" class="table1">
			<tr class="altrow">
				<th>编号</th>
				<th>文件名</th>
				<th>文件大小: (B)</th>
				<th>文件上传日期</th>
				<th>上传用户</th>
				<th>审核</th>
			</tr>
			<s:iterator value="#request.auditUserUploads" id="auditUserUpload" status="st">
		
				<tr>
					<th><s:property value="#st.index + 1"/></th>
					<th><font color="blue"><s:property value="#auditUserUpload.fileFileName"/></font></th>
					<th><s:property value="#auditUserUpload.fileLength"/></th>
					<th><s:property value="#auditUserUpload.fileUploadDate"/></th>
					<th><s:property value="#auditUserUpload.authority.authorityName"/></th>
					<th><input type="button" value="审核" onclick="window.document.location.href='updateUserUploadAction.action?id=<s:property value="#auditUserUpload.id"/>'"></th>
				</tr>
		
			</s:iterator>
		</table>
	</div>
	
  </body>
</html>
