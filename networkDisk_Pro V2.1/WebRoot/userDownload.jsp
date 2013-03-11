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
    
    <title>用户下载界面</title>
    
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

	<h1><font color="blue">文件列表</font></h1><hr>
	
	<table width="100%" class="table1">
			<tr>
				<th>编号</th>
				<th>文件名</th>
				<th>文件大小: (B)</th>
				<th>文件上传日期</th>
				<th>文件下载次数</th>
			</tr>
		<s:iterator value="#request.uploads" id="upload" status="st">
		
			<tr>
				<th><s:property value="#st.index + 1"/></th>
				<th><a href="downloadAction.action?id=<s:property value="#upload.id" />"><font color="blue"><s:property value="#upload.fileFileName"/></font></a></th>
				<th><s:property value="#upload.fileLength"/></th>
				<th><s:property value="#upload.fileUploadDate"/></th>
				<th><s:property value="#upload.download.downloadCount"/></th>
			</tr>
		
		</s:iterator>
	</table>

  </body>
</html>
