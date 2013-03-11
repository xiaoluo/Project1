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

		<title>My JSP 'MyJsp2.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">

function checkSubmit() {
	var form = document.form;
	if (form.node_id2.value == "") {
		alert("请选择您的求教学科。");
		form.node_id2.focus();
		return false;
	}
	if (!$('input:radio[name=stu_gender]').is(':checked')) {
		alert("请选择学员性别。");
		return false;
	}
	if (form.stu_nianji.value == "") {
		alert("请选择您的学员年级。");
		form.stu_nianji.focus();
		return false;
	}
	if (form.stu_desc.value == "") {
		alert("请填写学员详情。");
		form.stu_desc.focus();
		return false;
	}
	if (!$('input:radio[name=everyweek]').is(':checked')) {
		alert("请选择每周上课次数。");
		return false;
	}
	if (!$('input:radio[name=everytime]').is(':checked')
			&& form.everytime_other.value == "") {
		alert("请选择每次上课时间。");
		return false;
	}
	if (form.tea_fee.value == "") {
		alert("请填写课时费。");
		form.tea_fee.focus();
		return false;
	}
	if (form.contact.value == "") {
		alert("请输入联系人。");
		form.contact.focus();
		return false;
	}
	var m = document.getElementById("mobile");
	if (m.value == "") {
		alert("请输入你的手机号码！");
		form.mobile.focus();
		return false;
	}
	var reg = /^(?:13\d|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|4|5|6|7|8|9]|147)-?\d{5}(\d{3}|\*{3})$/;
	if (reg.test(m.value) == false) {
		alert("请输入正确的手机号码！");
		form.mobile.focus();
		return false;
	}
	if (form.area_cross.value == "") {
		alert("请输入交叉路口。");
		form.area_cross.focus();
		return false;
	}
	form.action = "xuqiu_ok.php";
	form.submit();
	return true;
}
</script>

	</head>

	<body>
		This is my JSP page.
		<br>
	</body>
</html>
