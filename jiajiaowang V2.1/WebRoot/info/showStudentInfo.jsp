<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showStudentInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/showStudentInfo.css">

  </head>
  
  <body>
  		<div class="container">
			  <jsp:include page="/common/head.jsp"></jsp:include>	
			  
			  <div id="main">
			  		<div id="box_left">
			  			<div class="LBtopNav" style="margin-bottom: 10px;">
			  				<a href="/">首页</a>
							<span>>></span>
							<span class="LBtopElect">广州家教兼职</span>
			  			</div>
			  			<div style="margin-bottom: 10px;"></div>
			  			<div class="pleaseTtile"> 学员信息库 </div>
			  			<div class="pleaseTtileRight"></div>
			  		</div>
			  		<table class="plInfoTable" width="720" cellspacing="0" cellpadding="0" border="0">
			  			<tr style="background-color:#f1f8e4">
			  				<td width="60" align="center">
								<strong>订单号</strong>
							</td>
							<td width="50" align="center">
								<strong>性别</strong>
							</td>
							<td width="110" align="center">
								<strong>求教科目</strong>
							</td>
							<td width="300" align="center">
								<strong>学员要求</strong>
							</td>
							<td width="80" align="center">
								<strong>区域</strong>
							</td>
							<td width="70" align="center">
								<strong>时间</strong>
							</td>
							<td width="50" align="center">
								<strong>查看</strong>
							</td>
			  			</tr>
			  			<tr style="background-color:#f7faf2">
			  				<td align="center">97273</td>
							<td align="center">男</td>
							<td align="center">托福</td>
							<td align="center">想学托福，还可以（ 没有课本，想出国） </td>
							<td align="center">越秀</td>
							<td align="center">03-06</td>
							<td align="center">
								<a href="/xueyuan/d-97273.html">查看</a>
							</td>
			  			</tr>
			  		</table>
			  		<div id="box_right">
			  			<a title="注册广州家教兼职" href="/member/signup1.php">
							<img border="0" alt="注册广州家教兼职" style="float: left;" src="/jiajiaowang/images/newTeacher_btn.jpg">
						</a>
						<div class="pleaseExp">
							<div class="pleaseExpCon">
								<h1>广州家教信息</h1>
								家教114广州家教信息网，是最专业的广州家教信息发布网站，提供大量的家教信息服务，为找家教、做家教提供专业平台。
								家教114还提供广州家教招聘服务，家教市场不断的扩大，家教老师的综合水平以在不断的提高，家教114在广州家教招聘老师的力度以在加大，竭力为孩子选配最合适的老师。
								目前，广州家教广告竞争比较激烈，家教114在广州家教广告的投放，主要是为了给学员教员更多机会，家教114是广州家教的首选。 
							</div>
							<div class="pleaseExpBot"></div>
						</div>
			  		</div>
			  </div>
			  
			  <jsp:include page="/common/foot.jsp"></jsp:include>	
  		</div>
  </body>
</html>
