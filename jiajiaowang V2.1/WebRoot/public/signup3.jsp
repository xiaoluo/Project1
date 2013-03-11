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
    
    <title>My JSP 'signup3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function CheckValue(register) {
			document.register.first_subject.value = "";//初始化
			for (i = 0; i < document.register.MyFirstJob.length; i++) {
				document.register.first_subject.value = document.register.first_subject.value
						+ document.register.MyFirstJob.options[i].value + ",";
				if (i > 15) {
					alert("您选择的科目超过了15个！请适当删除部分科目！");
					return (false);
				}
			}
			document.register.teach_place.value = "";//初始化
			for (i = 0; i < document.register.SecondTeachPlace.length; i++) {
				document.register.teach_place.value = document.register.teach_place.value
						+ document.register.SecondTeachPlace.options[i].value + ",";
				if (i > 17) {
					alert("您选择的授课区域超过了18个！请适当删除部分区域！");
					return (false);
				}
			}
			if (document.register.first_subject.value == "") 
			{
				alert("请选择您的可教授科目！");
				return (false);
			} 
			else if (document.register.teach_place.value == "") 
			{
				alert("请选择您的可授课区域！");
				return (false);
			} 
			else if(document.getElementById("certificate").value == "")
			{
				alert("请填写所获证书！");
				document.getElementById("certificate").focus();
				return (false);
			}
			else if (document.getElementById("appraiseSelf").value == "") {
				alert("请填写自我描述或特长展示！");
				document.getElementById("appraiseSelf").focus();
				return (false);
			} else if (document.register.resume.value == "") {
				alert("请填写教授经历或评价！");
				document.register.resume.focus();
				return (false);
			} else if (document.getElementById("pay").value == "") {
				alert("请填写您的薪水要求！");
				document.getElementById("pay").focus();
				return (false);
			}
			return true;
		}
		var flag;
		function addloc(locs, mylocs) {
			if (mylocs.length > 17)
				alert('您选择的项目超过18个了！请删除部分项目再选！');
			else {
				for ( var x = 0; x < locs.length; x++) {
					var opt = locs.options[x];
					if (opt.selected) {
						flag = true;
						for ( var y = 0; y < mylocs.length; y++) {
							var myopt = mylocs.options[y];
							if (myopt.value == opt.value)
								flag = false;
						}
						if (flag)
							mylocs.options[mylocs.options.length] = new Option(
									opt.text, opt.value, 0, 0);
					}
				}
			}
		}
		function delloc(locs, mylocs) {
			for ( var x = mylocs.length - 1; x >= 0; x--) {
				var opt = mylocs.options[x];
				if (opt.selected)
					mylocs.options[x] = null;
			}
		}
	</script>
	
	<link rel="stylesheet" type="text/css" href="css/signup3.css">

  </head>
  
  <body>
	<!-- 如果用户没有注册就重定向到signin.jsp界面 -->
	<%
		if(session.getAttribute("teacherName") == null || "".equals(session.getAttribute("teacherName")))
		{
			response.sendRedirect("/jiajiaowang/public/signin.jsp");
		}
	%>	
	<div class="container">
			<div id="head">
			<div class="headLogo">
				<a href="/">
				<img border="0" src="/jiajiaowang/images/newtoplogo.jpg" alt="家教114">
				</a>
			</div>
			<div class="headLogin">
				<ul>
					<a style="color:#000;" rel="nofollow" href="/help/jiajiao_fee.php">资费说明</a>
					|
					<a style="color:#000;" rel="nofollow" href="/help/fukuan.php">付款方式</a>
				</ul>
			</div>
		</div>
	
		<div id="main">
			<form action="teacherLoginAction3.action" onsubmit="return CheckValue(this);" name="register">
				<!-- 填写了第一个注册界面信息的教员id -->
				<input type="hidden" name="teacherId" value="<s:property value='#request.teacherId'/>">
				
				<!-- 将用户选择的所教科目发送给服务器端 -->
				<input type="hidden" name="first_subject" value="134">
				<div class="RTGcon">
					<ul class="RTGbg" style="background:none;">
						<h1>
							<img style="margin-right:5px;" src="/jiajiaowang/images/yuan_12.gif">
							新教员注册第三步:
							<span>
							填写家教信息
							<span style="color:#FF0000; font-size:14px;">（重要!）</span>
							</span>
						</h1>
						<ul class="RTGconMes" style="text-align: left;">
							<span id="tish">【提示】</span>
							您所填信息越详细就越有利于检索，也就越容易获得学员的预约,所以请您务必如实、详尽地填写以下各拦。其中红色星号（
							<span style="color:#FF0000">*</span>
							）为必填。
						</ul>
					</ul>
					<table class="refTable" width="660" cellspacing="0" cellpadding="0" border="0" style="clear:both;">
						<tr>
							<td class="teach" style="color: rgb(255, 255, 255);" colspan="2">
								<strong>家教信息</strong>
							</td>
						</tr>
						<tr class="tred">
							<td width="130" style="padding-top:10px;">
								<div align="right">
									<div align="right">
										<span style="color:#FF0000">*</span>
										<strong>可教科目</strong>
										<br>
										<span style="line-height:18px; ">
											(最多选
											<span style="color:#FF0000">15</span>
											项
											<br>
											多余部分将
											<br>
											被系统自动
											<br>
											<span style="margin-right:30px;">丢弃)</span>
										</span>
									</div>
								</div>
							</td>
							<td style="padding-top:10px;">
								<select class="kemu" name="FirstJob" size="7">
								<!-- 遍历出所有的课程 -->
									<s:iterator value="#request.courses" id="course">
										<option value="<s:property value="#course.courseName"/>"><s:property value="#course.courseName"/></option>
									</s:iterator>
								</select>
								<div align="center" style="float:left; margin-left:15px; margin-right:15px; margin-top:30px;">
									<input type="button" style="margin-bottom:15px;" name="FTianJia2" onclick="JavaScript:addloc(document.register.FirstJob,document.register.MyFirstJob)" value="选取>>">
									<br>
									<input type="button" name="FShanChu" onclick="JavaScript:delloc(document.register.FirstJob,document.register.MyFirstJob)" value="<<删除">
								</div>
								<select style="width:140px; float:left" name="MyFirstJob" size="7" multiple="multiple"> </select>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color:#FF0000">*</span>
									<strong>所获证书</strong>
								</div>
								<div align="center"></div>
							</td>
							<td>
								<ul>比如：英语四级六级证书、计算机等级证书、钢琴考级证书等等。</ul>
								<textarea id="certificate" class="zhengs" style="height:50px; width:400px;" name="certificate" cols="35" rows="5"></textarea>
							</td>
						</tr>
						<tr class="tred">
							<td>
								<div align="right">
									<span style="color:#FF0000">*</span>
									<strong>
									自我描述
									<br>
									特长展示
									</strong>
								</div>
								<div align="center"></div>
							</td>
							<td>
								<ul>
								展示实力，增加你的魅力！比如你竞赛中获得过什么奖项，取得过什么出色
								<br>
								的成绩，有哪些过硬的证书之类。【请不要使用空格，尽量使用逗号来代替
								<br>
								("，")请控制在600字以内， 超过文字被自动删除.】
								</ul>
								<textarea id="appraiseSelf" class="zhengs" style="height:80px; width:400px" name="appraiseSelf" cols="35" rows="5"></textarea>
							</td>
						</tr>
						<tr class="tgreen">
							<td style="text-align:left; line-height:20px;" colspan="2">
								<ul>
									<span style="color:#FF0000 ;margin-left:60px;">注意：</span>
									以下可授课家长以及家教114，给家长推荐的重要的参考，请务必认真查阅地
									<br>
									<span style="margin-left:60px;">图，然后填写。</span>
								</ul>
							</td>
						</tr>
						<tr class="tred">
							<td>
								<div align="right">
									<span style="color:#FF0000">*</span>
									<strong>授课区域</strong>
									<br>
									<span style="line-height:18px;">
									(最多选
									<span style="color:#FF0000">18</span>
									项
									<br>
									多余部分将
									<br>
									被系统自动
									<br>
									<span style="margin-right:30px;"> 丢弃)</span>
									</span>
								</div>
							</td>
							<td>
								<select class="kemu" name="FirstTeachPlace" size="7">
								<!-- 根据教员选择的城市遍历出该城市所有的town -->
									<s:iterator value="#request.towns" id="town">
										<option value="<s:property value="#town.townName"/>"><s:property value="#town.townName"/></option>
									</s:iterator>
								</select>
								<!-- 将用户选择的授课区域发送给服务器端 -->
								<input type="hidden" name="teach_place" value="">
								<div style="float:left; margin-left:15px; margin-right:15px; margin-top:30px; ">
								<input type="button" style="margin-bottom:15px;" onclick="JavaScript:addloc(document.register.FirstTeachPlace,document.register.SecondTeachPlace)" name="FTianJia" value="选取>>">
								<br>
								<input type="button" name="FShanChu" onclick="JavaScript:delloc(document.register.FirstTeachPlace,document.register.SecondTeachPlace)" value="<<删除">
								</div>
								<select style="width:140px; float:left" name="SecondTeachPlace" size="7" multiple="multiple"> </select>
							</td>
						</tr>
						<tr class="tgreen">
							<td>
								<div align="right">
									<span style="color:#FF0000">*</span>
									<strong>
									家教简历
									<br>
									学员评价
									<br>
									教学成果
									</strong>
								</div>
								<div align="center"></div>
							</td>
							<td>
							<ul>
							这些内容是对你教学水平最有力和最直接的反映！是学员选择你的一项重要
							<br>
							依据。格式如：
							<li>(1)2005年10月，长宁区初三英语，期终学员从全班第40名上升至第5名。</li>
							<li>(2)2005年11月，黄 浦区高一数学，期终学员从50人分上升至90分。</li>
							<li>（字数600字以内）</li>
							</ul>
							<textarea id="resume" class="zhengs" style="width:400px; height:80px;" name="resume" cols="35" rows="5"></textarea>
							</td>
						</tr>
						<tr class="tred">
							<td>
								<div align="right">
								<span style="color:#FF0000">*</span>
								<strong>薪水要求</strong>
								</div>
							</td>
							<td>
								<textarea class="zhengs" style="width:400px; height:50px" name="pay" cols="70" rows="2" id="pay">执行家教网薪水标准。</textarea>
							</td>
						</tr>
					</table>
					<table class="wanc" width="670" cellspacing="0" cellpadding="0" border="0">
						<tr id="next_dx">
							<td>
								<input id="" class="next_f" type="button" onclick="javascript:history.go(-1);" name="" value="">
							</td>
							<td>
								<input id="" class="next_x" type="submit" name="" value="">
							</td>
							<td>
								<input id="" class="next_t" type="button" onclick="location.href='/member/signup_ok.php';" name="" value="">
							</td>
						</tr>
					</table>
				</div>
			</form>	
			
			<div id="box_right">
				<div class="YTright">
					<p class="one">1.选择用户名、 密码 、身份</p>
					<p class="two">2.填写个人基本信息</p>
					<p class="three">3.填写家教信息</p>
				</div>
			</div>
		</div>
		
		<jsp:include page="/common/foot.jsp"></jsp:include>
	</div>
	
  </body>
</html>
