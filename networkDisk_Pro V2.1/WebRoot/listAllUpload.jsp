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
    
    <title>文件上传列表界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
	<script type="text/javascript">
	
		function del()
		{
			if(confirm("你确定要删除吗?"))
			{
				return true;
			}
			return false;
		}
		
		
	</script>

  </head>
  
  <body id="body">
	
	<h1><font color="blue">文件列表</font></h1><hr>
	
	<div style="float: inherit;">
	
		<!-- 如果是管理员查看，则会让管理员执行删除操作 -->
		<s:if test="#request.authority == 'admin'">
			<table width="100%" class="table1">
				<tr class="altrow">
					<th>编号</th>
					<th>文件名</th>
					<th>文件大小: (B)</th>
					<th>文件上传日期</th>
					<th>文件下载次数</th>
					<th>×[删除]</th>
				</tr>
				<s:iterator value="#request.uploads" id="upload" status="st">
			
					<tr>
						<th><s:property value="#st.index + 1"/></th>
						<th><a href="downloadAction.action?id=<s:property value="#upload.id" />"><font color="blue"><s:property value="#upload.fileFileName"/></font></a></th>
						<th><s:property value="#upload.fileLength"/></th>
						<th><s:property value="#upload.fileUploadDate"/></th>
						<th><s:property value="#upload.download.downloadCount"/></th>
						<th><a href="deleteUploadAction.action?id=<s:property value="#upload.id" />" onclick="return del();"><font color="red">×[删除]</font></a></th>
					</tr>
			
				</s:iterator>
			</table>
		</s:if>
		<!-- 如果是user用户查看，则没有管理员的操作权限 -->
		<s:else>
			<table width="100%" class="table1">
				<tr class="altrow">
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
		</s:else>
	</div>
	
  </body>
</html>
