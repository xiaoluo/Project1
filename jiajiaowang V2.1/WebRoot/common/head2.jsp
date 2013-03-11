<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
  </head>
  
  <body>

	<div id="headnew">
	
		<div class="headLogonew">
			<a href="#" title="广州家教">
				<img border="0" title="广州家教" src="/jiajiaowang/images/newtoplogo.jpg" alt="广州家教">
			</a>
			<div id="newstation">广州</div>
			<div class="newstation_img"></div>
			<div class="newtopslip">
				<div class="newtopcity">
					<a title="家教网" href="#">
						<img border="0" alt="家教网">
					</a>
				</div>
				<a title="家教网" href="#"></a>
			
				<div class="newtop_middle">教育的艺术不在传授，而在鼓舞和唤醒</div>
			</div>
			
			<ul class="newtop_right">
				<li>
				<%= session.getAttribute("teacherName") %>教员,欢迎您! &nbsp;&nbsp;
				<a class="navtop" href="/member/">个人中心</a>
				|&nbsp;&nbsp;
				<a class="navtop" href="/signout.php">退出</a>&nbsp;&nbsp;
				<a class="navtop" href="/help/jiajiao_fee.php">家教价格</a>
				|
				<a class="navtop" href="/help/fukuan.php">付款方式</a>
				|
				<a class="navtop" href="/zuojiajiao.php">做家教流程</a>
				</li>
				<li class="newphone">全国统一家教咨询热线</li>
				<li class="newphone new_lc">4006-179-958</li>
				<li class="time">
			</ul>
			
			<ul class="newnav">
				<li id="newnavfirst"> </li>
				<li>
					<a id="dangqian" href="#">广州家教</a>
				</li>
				<li>
					<a href="#">挑选老师</a>
				</li>		
				<li>
					<a href="#">挑选学员</a>
				</li>	
				<li> </li>
				<li>
					<a href="/jiajiaowang/public/reservation.jsp">预约>></a>
				</li>
			</ul>
			
		</div>
		
	</div>

  </body>
</html>
