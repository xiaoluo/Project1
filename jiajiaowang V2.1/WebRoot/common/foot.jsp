<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="css/foot.css">
	<link rel="stylesheet" type="text/css" href="css/common.css">

  </head>
  
  <body>

	<div id="foot">
		
		<div class="footTop">
			<a rel="nofollow" href="#" target="_blank">关于我们</a>
			<a rel="nofollow" href="#" target="_blank">版权申明</a>
			<a rel="nofollow" href="#" target="_blank">免责申明</a>
			<a rel="nofollow" href="#" target="_blank">隐私保护</a>
			<a rel="nofollow" href="#" target="_blank">用户协议</a>
			<a rel="nofollow" href="#" target="_blank">资费说明</a>
			<a rel="nofollow" target="_blank" href="#">付款方式</a>
			<a rel="nofollow" href="#" target="_blank">联系我们</a>
		</div>
		
		<div class="footBottom">
			<br>
			© 2013－2015 版权所有：广东商学院软件工程1班-家教网 www.jiajiaowang.com | 
			<a href="#" style="color:#666666">家教网</a>
	 		| 地址：广州市海珠区仑头路21号
		</div>
		<br>
			中华人民共和国企业法人营业执照 注册号：310115001145352 | 中华人民共和国组织机构代码证 编号：31011535209-2 | 粤ICP备09062748号
	</div>

	<div class="newbottomlink">
		<p class="topMargin10">
		<img alt="广州网络警察报警平台" src="/jiajiaowang/images/gzpolice.jpg">
		<img alt="公共信息安全网络监察" src="/jiajiaowang/images/fl2.gif">
		<img alt="经营性网站备案信息" src="/jiajiaowang/images/fl3.gif">
		<img alt="不良信息举报中心" src="/jiajiaowang/images/fl4.gif">
		<img alt="中国文明网传播文明" src="/jiajiaowang/images/fl5.gif">
		</p>
	</div>

  </body>
</html>
