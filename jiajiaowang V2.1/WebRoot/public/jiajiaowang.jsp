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
    
    <title>My JSP 'jiajiaowang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/jiajiaowang.css">
	
  </head>
  
  <body>
	
	<div class="container">
		
		<!-- 如果用户登陆成功，则头页面选用head2.jsp  否则选用head.jsp -->
		<s:if test="<s:property value='#session.teacherName'/> == null">
			<jsp:include page="/common/head.jsp"></jsp:include>
		</s:if>
		
		<s:else>
			<jsp:include page="/common/head2.jsp"></jsp:include>
		</s:else>
	
		<div class="sh_newrighttop1" style="margin-bottom:5px;">
			<img src="/jiajiaowang/images/index_gg.jpg">
			
			<div class="sh_newmake">
		
				<ul>
					<li class="sh_pleaseTitle">
						<a style="color:#2d1510;" href="/zuojiajiao.php">做家教</a>
					</li>
					<li style="padding-top:15px;">
						<a style="color:#444444;" href="/member/signup1.php">
						<font color="#3d7f07">></font>
						 注册成为教员
						</a>
					</li>
					<li>
						<a style="color:#444444;" href="/xueyuan/">
						<font color="#3d7f07">></font>
						 查询最新学员
						</a>
					</li>
					<li>
						<a style="color:#444444;" href="/zuojiajiao.php">
						<font color="#3d7f07">></font>
						 做家教流程
						</a>
					</li>
				</ul>
		
			</div>
			
			<div class="sh_newplease">
		
				<ul>
					<li class="sh_pleaseTitle">
					<a style="color:#3d7f07;" href="/xueyuan/xuqiu_simple.php">请家教</a>
					</li>
				</ul>
				
				<ul>
					<li style="padding-top:15px;">
						<a href="/help/help_1.php">
						<font color="#3d7f07">></font>
						 请家教流程
						</a>
					</li>
					<li>
						<a href="/help/help_2.php">
						<font color="#3d7f07">></font>
						学员收费标准
						</a>
					</li>
					<li>
						<a href="/teacher/l.html">
						<font color="#3d7f07">></font>
						挑选合适教员
						</a>
					</li>
				</ul>
			
			</div>
		</div>
		
		
		
		<div class="sh_login">
	
			<div class="sh_loginTitle">教员登录</div><br>
			
			<table cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td width="40">
						<div align="right">用户名：</div>
					</td>
					<td width="100">
						<input id="Input" class="inputOver" type="text" style="width:120px" name="username" maxlength="20" onblur="this.className='inputOver'" onfocus="this.className='inputFocus'">
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">密  码：</div>
					</td>
					<td>
						<input id="Input" type="password" style="width:120px" name="password" onblur="this.className='inputOver'" onfocus="this.className='inputFocus'">
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">验证码：</div>
					</td>
					<td>
						<input type="text" size="4" name="vcode">
					</td>
				</tr>
				<tr>
					<td> </td>
					<td class="sh_dlv">
						<input id="" class="sh_loginBut" type="submit" value="" name="">&nbsp;&nbsp;
						<a id="sh_zhuceBut" href="#">马上注册</a>
					</td>
				</tr>
			</table>
		
		</div>
		
		<jsp:include page="/common/foot.jsp"></jsp:include>
	</div>

  </body>
</html>
