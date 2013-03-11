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
    
    <title>My JSP 'reservation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="css/reservation.css">
	
	<script type="text/javascript" src="script/public.js"></script>
	<script type="text/javascript" src="script/validate.js"></script>
	
  </head>
  
  <body>
	
	<div class="container">
		<jsp:include page="/common/head.jsp"></jsp:include>
	
		<div id="main">
			<div id="box_left">
				<div class="LBtopNav">
					<a href="/">首页</a>
					<span>>></span>
					<span class="LBtopElect">广州地区请家教</span>
				</div>
				
			<form action="studentOrderValidateAction.action" onsubmit="return checkSubmit();" method="post">
				<div class="Jb-top"></div>
				<div class="Jb-center">
					<table width="100%" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td class="line1" height="30" colspan="5">请填写学员的基本信息</td>
						</tr>
						<tr>
							<td width="12%" height="30" align="right">求教学科：</td>
							<td width="16%" height="35">
								<select id="subjectName" onchange="change_node_id(this.value)" name="subjectName" style="width:100px">
									<option value="" selected="selected">-请选择-</option>
									<option value="小学">小学</option>
									<option value="初中">初中</option>
									<option value="高中">高中</option>
									<option value="语言">语言</option>
									<option value="音乐">音乐</option>
									<option value="其他">其他</option>
								</select>
							</td>
							<td width="18%" height="35">
								<select id="courseName" name="courseName" style="width:100px">
									<option value="">--请选择--</option>
								</select>
							</td>
							<td width="23%" height="30">
								学员性别：
								<label>
									<input type="radio" value="男" name="stuGender" checked="checked">
									男
								</label>
								<label>
									<input type="radio" value="女" name="stuGender">
									女
								</label>
							</td>
							<td width="31%" height="30">
								学员年级：
								<select name="grade" id="grade">
									<option selected="selected" value="">请选择</option>
									<option value="学前">学前</option>
									<option value="一年级">一年级</option>
									<option value="二年级">二年级</option>
									<option value="三年级">三年级</option>
									<option value="四年级">四年级</option>
									<option value="五年级">五年级</option>
									<option value="六年级">六年级</option>
									<option value="初一">初一</option>
									<option value="初二">初二</option>
									<option value="初三">初三</option>
									<option value="高一">高一</option>
									<option value="高二">高二</option>
									<option value="高三">高三</option>
									<option value="成人">成人</option>
								</select>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">学员详情：</td>
							<td height="35" colspan="4">
								<label for="textarea"></label>
								<textarea id="details" style="height: 60px; width: 350px;" name="details" cols="20" rows="3"></textarea>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">上课时间：</td>
							<td height="35" style="padding-top:10px; padding-bottom:10px;" colspan="4">
								<p>
									每周  
									<label>
										<input type="radio" value="1次" name="everyweek" checked="checked">
									</label>
									1次 
									<label>
										<input type="radio" value="2次" name="everyweek">
									</label>
									2次 
									<label>
										<input type="radio" value="3次" name="everyweek">
									</label>
									3次 
									<label>
										<input type="radio" value="5次" name="everyweek">
									</label>
									5次 
									<label>
										<input type="radio" value="7次" name="everyweek">
									</label>
									7次
								</p>
								<p>
									每次  
									<label>
										<input type="radio" value="1小时" name="everytime" checked="checked">
									</label>
									1小时 
									<label>
										<input type="radio" value="1.5小时" name="everytime">
									</label>
									1.5小时 
									<label>
										<input type="radio" value="2小时" name="everytime">
									</label>
									2小时 
									<label>
										<input type="radio" value="3小时" name="everytime">
									</label>
									3小时  
								</p>
							</td>
						</tr>
						<tr>
							<td height="20" align="right" colspan="5"> </td>
						</tr>
						<tr>
							<td class="line2" height="30" colspan="5">请填写您对教员的要求</td>
						</tr>
						<tr>
							<td height="35" align="right">教员性别：</td>
							<td height="35" colspan="2">
								<p>
									<label>
										<input type="radio" checked="checked" value="均可" name="teaGender">
									均可
									</label>
									<label>
										<input type="radio" value="男" name="teaGender">
									男
									</label>
									<label>
										<input type="radio" value="女" name="teaGender">
									女
									</label>
								</p>
							</td>
							<td height="35" colspan="3">
								资格要求：
								<label>
									<input type="radio" checked="checked" value="均可" name="teaType">
								均可
								</label>
								<label>
									<input type="radio" value="专职老师" name="teaType">
								专职老师
								</label>
								<label>
									<input type="radio" value="大学生" name="teaType">
								大学生
								</label>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">课 时 费：</td>
							<td height="35" colspan="4">
								<input id="tea_fee" type="text" name="teaFee" size="25" maxlength="40">
								<span id="ff4e00">例如：X元/小时，X元/天，X元/月</span>
							</td>
						</tr>
						<tr>
							<td height="25" align="right" colspan="5"> </td>
						</tr>
						<tr>
							<td class="line3" height="30" colspan="5">请填写您对的联系方式</td>
						</tr>
						<tr>
							<td height="35" align="right">联 系 人：</td>
							<td height="35" colspan="4">
								<input id="contact" type="text" name="contact" size="10" maxlength="40">
								<span id="ff4e00">例如：罗先生</span>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">移动电话：</td>
							<td height="35" colspan="4">
								<input id="mobile" type="text" name="mobile" size="25" maxlength="40">
								<span id="ff4e00">便于短信通知，该信息不会在网上公布</span>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">所在区域：</td>
							<td height="35" colspan="4">
								<select id="zone_id" name="area">
									<option value="越秀">越秀</option>
									<option value="南沙">南沙</option>
									<option value="增城">增城</option>
									<option value="从化">从化</option>
									<option value="番禺">番禺</option>
									<option value="花都">花都</option>
									<option value="黄埔">黄埔</option>
									<option value="白云">白云</option>
									<option value="天河">天河</option>
									<option value="荔湾">荔湾</option>
									<option value="海珠">海珠</option>
									<option value="萝岗">萝岗</option>								
								</select>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">交叉路口：</td>
							<td height="35" colspan="4">
								<input id="area_cross" type="text" name="areaCross" size="25" maxlength="40">
								<span id="ff4e00">请填写交叉路或小区</span>
							</td>
						</tr>
						<tr>
							<td height="35" align="right">验 证 码：</td>
							<td height="35" colspan="2">
								<input type="text" size="6" name="checkCode" id="checkCode">
								<img align="absmiddle" width="60" height="18" src="/jiajiaowang/createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新">
							</td>
							<td>
								<!-- 验证不通过时提示错误信息 -->
								<div style="color: red; font-size: 14px; text-align: left;"><s:actionerror/></div>
							</td>
						</tr>
						<tr>
							<td height="40" align="center" style="padding-bottom:10px;" colspan="5">
								<input class="please_btn" type="submit" style="margin-right: 5px;" value="确  定">
							</td>
						</tr>
					</table>
				</div>
			</form>
			</div>
			
			<div id="box_right">
				<div class="pleaseExp">
					<div class="pleaseExpCon">
						<h1>广州请家教服务</h1>
						家教114广州请家教服务，提供广州1对1个性化家教方案，特聘各大名牌大学学生教员以及各区重点中学在职老师，经过精心挑选、严格认证，让家长100%放心请家教。
						<br>
						广州请家教服务热线：4006-179-958 
					</div>
					<div class="pleaseExpBot"></div>
				</div>
				<div class="pleaseService">
					<div class="pleaseServiceCon">
						<h1>服务优势</h1>
						<ul>
							<li>教学资源丰富，对教员严格把关</li>
							<li>首推星级家教，服务最为规范</li>
							<li>星级教员万里挑一，教学成功率高</li>
							<li>1万名本地专业教师，专业师资最强</li>
							<li>8万名教员自主挑选，大学生教员最多</li>
						</ul>
					</div>
					<div class="pleaseServiceBot"></div>
				</div>
			</div>
		</div>	
		
		<jsp:include page="/common/foot.jsp"></jsp:include>	
	</div>

  </body>
</html>
