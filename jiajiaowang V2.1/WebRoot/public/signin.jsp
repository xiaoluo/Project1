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
    
    <title>My JSP 'signin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/signin.css">

  </head>
  
  <body>
	
	<div class="container">
		<jsp:include page="/common/head.jsp"></jsp:include>
	
		<div id="main">
		
			<form action="loginValidateAction.action" method="post">
				<div class="LOGIN">
					<div class="LOGINtop"></div>
					<div class="LOGINcon">
						<h1>用户登录</h1>
						<!-- 验证不通过时提示错误信息 -->
						<div style="text-align: center; color: red; font-size: 14px;"><s:actionerror/></div>
						<table width="962" cellspacing="0" cellpadding="0" border="0" style="margin-top:40px; margin-bottom:60px">
							<tr>
								<td width="411">
									<div align="right">用 户 名：</div>
								</td>
								<td width="551">
									<input type="text" onfocus="this.className='inputFocus'" onblur="this.className='inputOver'" name="username" style="width: 150px;">
								</td>
							</tr>
							<tr>
								<td>
									<div align="right">密    码：</div>
								</td>
								<td>
									<input type="password" onfocus="this.className='inputFocus'" onblur="this.className='inputOver'" name="password" style="width: 150px;">
								</td>
							</tr>
							<tr>
								<td>
									<div align="right">验 证 码：</div>
								</td>
								<td>
									<input type="text" ;="" style=" width:80px" name="checkCode">
									<img width="60" height="17" align="absmiddle" src="/jiajiaowang/createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新">
								</td>
							</tr>
							<tr>
								<td> </td>
								<td>
									<input id="" class="LOGIN_btn" type="submit" name="search_btn" value="登录">&nbsp;&nbsp;
									<a style="line-height:40px;" href="/jiajiaowang/public/signup1.jsp">教员注册</a>&nbsp;
									<a style="line-height:40px;" href="#">找回密码</a>
								</td>
							</tr>
						</table>
					</div>
					
					<div class="LOGINbot"></div>
				</div>
			</form>
		
		</div>
		
		<jsp:include page="/common/foot.jsp"></jsp:include>
	</div>

  </body>
</html>
