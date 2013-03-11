<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
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
	if (document.register.first_subject.value == "") {
		alert("请选择您的可教授科目！");
		return (false);
	} else if (document.register.teach_place.value == "") {
		alert("请选择您的可授课区域！");
		return (false);
	} else if (document.register.teach_place_discrib.value == "") {
		alert("请填写可授课区域详细描述！");
		document.register.teach_place_discrib.focus();
		return (false);
	} else if (document.register.appraise_self.value == "") {
		alert("请填写自我描述或特长展示！");
		document.register.appraise_self.focus();
		return (false);
	} else if (document.register.resume.value == "") {
		alert("请填写教授经历或评价！");
		document.register.resume.focus();
		return (false);
	} else if (document.register.pay.value == "") {
		alert("请填写您的薪水要求！");
		document.register.pay.focus();
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

<style type="text/css">
	h1#red{background-color: yellow;}
</style>
	</head>

	<body>
		<div class="sh_newplease" style="margin: none;">

			<ul>
				<li class="sh_pleaseTitle">
					<a style="color: #3d7f07;" href="/xueyuan/xuqiu_simple.php">请家教</a>
				</li>
			</ul>

			<ul>
				<li style="padding-top: 15px;">
					<a href="/help/help_1.php"> <font color="#3d7f07">> </font>
						请家教流程 </a>
				</li>
				<li>
					<a href="/help/help_2.php"> <font color="#3d7f07">> </font>
						学员收费标准 </a>
				</li>
				<li>
					<a href="/teacher/l.html"> <font color="#3d7f07">> </font>
						挑选合适教员 </a>
				</li>
			</ul>

		</div>

		<div class="sh_newmake">

			<ul>
				<li class="sh_pleaseTitle">
					<a style="color: #2d1510;" href="/zuojiajiao.php">做家教</a>
				</li>
				<li style="padding-top: 15px;">
					<a style="color: #444444;" href="/member/signup1.php"> <font
						color="#3d7f07">></font> 注册成为教员 </a>
				</li>
				<li>
					<a style="color: #444444;" href="/xueyuan/"> <font
						color="#3d7f07">></font> 查询最新学员 </a>
				</li>
				<li>
					<a style="color: #444444;" href="/zuojiajiao.php"> <font
						color="#3d7f07">></font> 做家教流程 </a>
				</li>
			</ul>

		</div>
		
		<h1 id="red">Excercices</h1>
		
	</body>
</html>
