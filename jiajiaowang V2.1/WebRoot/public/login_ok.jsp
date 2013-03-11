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
    
    <title>My JSP 'login_ok.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/signup_ok.css">

  </head>
  
	<body>
	   	
	    <div class="container">
	    
		    <!-- 如果用户没有注册就重定向到signin.jsp界面 -->
			<%
				if(session.getAttribute("teacherName") == null || "".equals(session.getAttribute("teacherName")))
				{
					response.sendRedirect("/jiajiaowang/public/signin.jsp");
				}
			%>	
			
			<!-- 如果用户登陆成功，则头页面选用head2.jsp  否则选用head.jsp -->
			<s:if test="<s:property value='#session.teacherName'/> == null">
				<jsp:include page="/common/head.jsp"></jsp:include>
			</s:if>
			
			<s:else>
				<jsp:include page="/common/head2.jsp"></jsp:include>
			</s:else>
				
			<div id="main">
				
				<div class="RCGcon">
					<table id="cheng_tb" width="640" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td class="cheng_td" width="215">
								<img src="/jiajiaowang/images/csign_03.jpg">
							</td>
							<td width="425">
								<h1>
									<strong>您已登陆成功！</strong>
								</h1>
							</td>
						</tr>
						<tr> </tr>
						<tr>
							<td> </td>
							<td> </td>
						</tr>
						<tr>
							<td class="cheng_sh" width="640" colspan="2">
								您的教员编号是
								<span style="color:#ff8706;"><%= session.getAttribute("teacherId") %></span>
								，目前状态还
								<span style="color:#ff8706;">未通过审核</span>
								。
							</td>
						</tr>
						<tr>
							<td class="cheng_sh" width="640" colspan="2">
								我们将在
								<span style="color:#ff8706;">24小时内人工审核</span>
								您的信息。请耐心等待！
								<br>
								审核通过后，您将可以在线申请订单。谢谢！
							</td>
						</tr>
						<tr>
							<td class="cheng_sh" width="640" colspan="2">
								<span style="color:#ff8706;">你可以点击上方的选项来查看其他教员信息或者学员信息</span>
							</td>
						</tr>
						<tr>
							<td class="cheng_ch" width="640" colspan="2">
								<span style="margin-left:165px;">用户名：<font color="red"><%= session.getAttribute("teacherName") %></font></span>
							</td>
						</tr>
						<tr>
							<td class="cheng_ch" width="640" colspan="2">
								<span style="margin-left:165px; font-size:14px;">
								立即进入
								<a href="#">个人中心</a>
								，进行
								<a href="#">网上认证</a>
								！
								</span>
							</td>
						</tr>
					</table>
					
					<div class="renz">
						<div class="jiaoy">
							<ul>
								<li>
									<a id="ms" href="#">马上认证</a>
								</li>
								<li class="zhaoj">
									<a style="color:#63ad00;" href="#">找家教</a>
								</li>
								<li class="zhaoj">
									<a style="color:#63ad00;" href="#">做家教</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				
			</div>
		
			<jsp:include page="/common/foot.jsp"></jsp:include>
		</div>
		
  </body>
</html>
