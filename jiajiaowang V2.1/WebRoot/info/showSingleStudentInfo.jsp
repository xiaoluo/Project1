<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showSingleStudentInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/showSingleStudentInfo.css">

  </head>
  
  <body>

	<div class="container">
		
		<jsp:include page="/common/head.jsp"></jsp:include>
		
		<div id="main">
			<div id="box_left">
				<div class="LBtopNav" style="margin-bottom: 10px;">
					<a href="/">首页</a>
					<span>>></span>
					<a href="/xueyuan/">广州家教兼职</a>
					<span>>></span>
					<span class="LBtopElect">97145号学员信息</span>
				</div>
				<div class="xue_bg">
					<h1>
						学员订单 
						<font style="color:#ff8505;">97145 </font>
						 详细情况
					</h1>
					<p class="xue_sm">
						请合适的注册教员尽快网上申请，如果还不是我们的教员，请先
						<a id="xue_zhu" href="/member/signup1.php">注册</a>
						。如果还未认证，请尽快认证！
					</p>
					<p>
						<font color="red">欢迎广大老师和大学生教员在线预约，恕不接受电话预约！</font>
					</p>
				</div>
				<div class="pleaseTtile" style="text-align: center; position: relative;">
					<span style="font-size: 12px; margin-left: 10px; font-weight: bold;">97145号学员基本信息</span>
				</div>
				<div class="pleaseTtileRight"></div>
				<table class="plInfoTable xue_table" width="720" cellspacing="0" cellpadding="0" border="0">
					<tr class="xue_lv">
						<td width="135">
							<div align="right">订 单 号：</div>
						</td>
						<td width="220">97145</td>
						<td width="128">
							<div align="right">求教科目：</div>
						</td>
						<td width="237">小学语文钢琴</td>
					</tr>
					<tr class="xue_qi">
						<td>
							<div align="right">学员情况：</div>
						</td>
						<td>男 五年级</td>
						<td>
							<div align="right">课 时 费：</div>
						</td>
						<td>100/小时协商（120-150元/小时）</td>
					</tr>
					<tr class="xue_lv">
						<td>
							<div align="right">教员资质：</div>
						</td>
						<td>专职教师</td>
						<td>
							<div align="right">教员性别：</div>
						</td>
						<td>均可</td>
					</tr>
					<tr class="xue_qi">
						<td>
							<div align="right">授课区域：</div>
						</td>
						<td>番禺</td>
						<td>
							<div align="right">区域详情：</div>
						</td>
						<td>南村镇政府附近  </td>
					</tr>
					<tr class="xue_lv">
						<td width="128">
							<div align="right">可授课时间：</div>
						</td>
						<td colspan="3">
							周末上课
							<p class="tea_cishu"> 每周： 1次    每次：2小时 </p>
						</td>
					</tr>
					<tr class="xue_qi">
						<td width="128">
							<div align="right">学员详情：</div>
						</td>
						<td colspan="3">	阅读理解跟写作。（小女孩学过2年，家里有钢琴，6岁，周末上课） </td>
					</tr>
					<tr class="xue_lv">
						<td width="128">
							<div align="right">教员要求：</div>
						</td>
						<td colspan="3">	教龄比较长，在职的老师（T96481） </td>
					</tr>
				</table>
				<div class="newplApply">
					<div class="newpl_shen">
						<h1>请注意，若您对此订单感兴趣，请立即申请！</h1>
						<div align="center">
							<input class="plInfoApply_btn" type="button" style="margin-right:5px" value="立即申请" onclick="javascript:location.href='/yuyue.php?id=97273'">
						</div>
					</div>
				</div>
			</div>
			
			<div id="box_right">
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
