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
    
    <title>个人文件上传列表界面</title>
    
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
		
		//如果文件未经过审核，则提示用户
		function remaind()
		{
			alert("您上传的文件还未经管理员审核，请耐心等候!")
		}
		
		
	</script>

  </head>
  
  <body id="body">

	<h1><font color="blue">个人文件列表</font></h1><hr>
	
	<div style="float: inherit;">
		<table width="100%" class="table1">
			<tr class="altrow">
				<th>编号</th>
				<th>文件名</th>
				<th>文件大小: (B)</th>
				<th>文件上传日期</th>
				<th>×[删除]</th>
				<th>审核状态</th>
			</tr>
			<s:iterator value="#request.userUploads" id="userUpload" status="st">
		
				<tr>
					<s:if test="#userUpload.isAudit==2">
						<th><s:property value="#st.index + 1"/></th>
						<th><a href="javascript: void(0)" onclick="remaind();"><font color="blue"><s:property value="#userUpload.fileFileName"/></font></a></th>
						<th><s:property value="#userUpload.fileLength"/></th>
						<th><s:property value="#userUpload.fileUploadDate"/></th>
						<th><a href="javascript: void(0)"><font color="blue">×[删除]</font></a></th>
						<th><font color="red">未审核</font></th>
					</s:if>
					<s:else>
						<th><s:property value="#st.index + 1"/></th>
						<th><a href="downloadUserUploadAction.action?id=<s:property value="#userUpload.id" />"><font color="blue"><s:property value="#userUpload.fileFileName"/></font></a></th>
						<th><s:property value="#userUpload.fileLength"/></th>
						<th><s:property value="#userUpload.fileUploadDate"/></th>
						<th><a href="deleteUserUploadAction.action?id=<s:property value="#userUpload.id" />" onclick="return del();"><font color="red">×[删除]</font></a></th>
						<th><font color="blue">已审核</font></th>
					</s:else>
				</tr>
		
			</s:iterator>
		</table>
	</div>
	
  </body>
</html>
