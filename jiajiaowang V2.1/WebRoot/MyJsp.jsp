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

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function change_node_id(val) {
	var list = eval( {
		"1" : {
			"134" : "\u5e7c\u6559",
			"143" : "\u5c0f\u5b66\u5965\u6570",
			"100" : "\u5c0f\u5b66\u6570\u5b66",
			"102" : "\u5c0f\u5b66\u82f1\u8bed",
			"109" : "\u5c0f\u5b66\u8bed\u6587",
			"300" : "\u5c0f\u5b66\u966a\u8bfb",
			"542" : "\u661f\u7ea7\u82f1\u8bed",
			"242" : "\u966a\u73a9\u966a\u8bfb",
			"241" : "\u5b66\u524d\u6559\u80b2"
		},
		"2" : {
			"186" : "\u521d\u4e2d\u5965\u6570",
			"110" : "\u521d\u4e00\u521d\u4e8c\u82f1\u8bed",
			"111" : "\u521d\u4e00\u521d\u4e8c\u6570\u5b66",
			"118" : "\u521d\u4e00\u521d\u4e8c\u5316\u5b66",
			"101" : "\u521d\u4e00\u521d\u4e8c\u7269\u7406",
			"129" : "\u521d\u4e00\u521d\u4e8c\u8bed\u6587",
			"112" : "\u521d\u4e09\u82f1\u8bed",
			"119" : "\u521d\u4e09\u6570\u5b66",
			"126" : "\u521d\u4e09\u7269\u7406",
			"120" : "\u521d\u4e09\u5316\u5b66",
			"130" : "\u521d\u4e09\u8bed\u6587",
			"164" : "\u521d\u4e2d\u5386\u53f2",
			"173" : "\u521d\u4e2d\u5730\u7406"
		},
		"3" : {
			"114" : "\u9ad8\u4e00\u9ad8\u4e8c\u82f1\u8bed",
			"121" : "\u9ad8\u4e00\u9ad8\u4e8c\u6570\u5b66",
			"127" : "\u9ad8\u4e00\u9ad8\u4e8c\u7269\u7406",
			"122" : "\u9ad8\u4e00\u9ad8\u4e8c\u5316\u5b66",
			"115" : "\u9ad8\u4e09\u82f1\u8bed",
			"124" : "\u9ad8\u4e09\u6570\u5b66",
			"128" : "\u9ad8\u4e09\u7269\u7406",
			"125" : "\u9ad8\u4e09\u5316\u5b66",
			"135" : "\u9ad8\u4e09\u8bed\u6587",
			"156" : "\u9ad8\u4e2d\u5386\u53f2",
			"174" : "\u9ad8\u4e2d\u5730\u7406",
			"541" : "\u4fe1\u606f\u79d1\u6280",
			"543" : "\u7406\u7efc",
			"544" : "\u6587\u7efc"
		},
		"4" : {
			"132" : "\u82f1\u8bed\u53e3\u8bed",
			"137" : "\u65b0\u6982\u5ff5\u82f1\u8bed",
			"154" : "\u725b\u6d25\u82f1\u8bed",
			"217" : "\u6258\u798f",
			"170" : "\u96c5\u601d",
			"171" : "\u5546\u52a1\u82f1\u8bed",
			"105" : "\u65e5\u8bed",
			"180" : "\u97e9\u8bed",
			"161" : "\u5fb7\u8bed",
			"175" : "\u6cd5\u8bed",
			"203" : "\u610f\u5927\u5229\u8bed",
			"155" : "\u897f\u73ed\u7259\u8bed",
			"236" : "\u963f\u62c9\u4f2f\u8bed",
			"225" : "\u5bf9\u5916\u6c49\u8bed",
			"244" : "sbs\u82f1\u8bed",
			"248" : "\u4fc4\u8bed",
			"346" : "\u8461\u8404\u7259\u8bed"
		},
		"5" : {
			"131" : "\u94a2\u7434",
			"144" : "\u7535\u5b50\u7434",
			"108" : "\u5c0f\u63d0\u7434",
			"224" : "\u5c0f\u53f7",
			"219" : "\u82ad\u857e\u821e",
			"213" : "\u5409\u4ed6",
			"209" : "\u6c11\u65cf\u821e",
			"197" : "\u5355\u7c27\u7ba1",
			"196" : "\u8428\u514b\u65af",
			"195" : "\u58f0\u4e50",
			"193" : "\u5927\u53f7",
			"182" : "\u89c6\u5531\u7ec3\u8033",
			"166" : "\u53e4\u7b5d",
			"159" : "\u624b\u98ce\u7434",
			"157" : "\u7435\u7436",
			"153" : "\u957f\u7b1b",
			"280" : "\u5706\u53f7",
			"274" : "\u6253\u51fb\u4e50",
			"273" : "\u5927\u63d0\u7434",
			"249" : "\u4e8c\u80e1",
			"240" : "\u53e4\u7434",
			"332" : "\u4e2d\u63d0\u7434"
		},
		"6" : {
			"176" : "\u9ad8\u7b49\u6570\u5b66",
			"142" : "\u7f51\u7403",
			"141" : "\u4e52\u4e53\u7403",
			"140" : "\u6e38\u6cf3",
			"233" : "\u6cb9\u753b",
			"231" : "\u7d20\u63cf",
			"215" : "\u56f4\u68cb",
			"192" : "\u4e2d\u56fd\u753b",
			"179" : "\u56fd\u9645\u8c61\u68cb",
			"138" : "\u7fbd\u6bdb\u7403",
			"167" : "\u4e2d\u56fd\u8c61\u68cb",
			"160" : "\u5361\u901a\u753b",
			"158" : "\u4e66\u6cd5",
			"147" : "\u7f8e\u672f",
			"139" : "\u8dc6\u62f3\u9053",
			"261" : "\u6c34\u5f69",
			"265" : "\u6f2b\u753b",
			"279" : "\u7a7a\u624b\u9053",
			"298" : "SAT"
		}
	});
	var select = document.getElementById("node_id2");
	select.options.length = 0;
	select.options[select.options.length] = new Option('--请选择--', '');
	for ( var name in list[val]) {
		select.options[select.options.length] = new Option(list[val][name],
				name);
	}
}
</script>
	</head>

	<body>
		<select class="kemu" name="FirstJob" size="7">
									<option value="幼教">幼教</option>
									<option value="小学奥数">小学奥数</option>
									<option value="小学数学">小学数学</option>
									<option value="小学英语">小学英语</option>
									<option value="小学语文">小学语文</option>
									<option value="小学陪读">小学陪读</option>
									<option value="星级英语">星级英语</option>
									<option value="陪玩陪读">陪玩陪读</option>
									<option value="学前教育">学前教育</option>
									<option value=""></option>
									<option value="初中奥数">初中奥数</option>
									<option value="初一初二英语">初一初二英语</option>
									<option value="初一初二数学">初一初二数学</option>
									<option value="初一初二化学">初一初二化学</option>
									<option value="初一初二物理">初一初二物理</option>
									<option value="初一初二语文">初一初二语文</option>
									<option value="初三英语">初三英语</option>
									<option value="初三数学">初三数学</option>
									<option value="初三物理">初三物理</option>
									<option value="初三化学">初三化学</option>
									<option value="初三语文">初三语文</option>
									<option value="初中历史">初中历史</option>
									<option value="初中地理">初中地理</option>
									<option value=""></option>
									<option value="高一高二英语">高一高二英语</option>
									<option value="高一高二数学">高一高二数学</option>
									<option value="高一高二物理">高一高二物理</option>
									<option value="高一高二化学">高一高二化学</option>
									<option value="高三英语">高三英语</option>
									<option value="高三数学">高三数学</option>
									<option value="高三物理">高三物理</option>
									<option value="高三化学">高三化学</option>
									<option value="高三语文">高三语文</option>
									<option value="高中历史">高中历史</option>
									<option value="高中地理">高中地理</option>
									<option value="信息科技">信息科技</option>
									<option value="理综">理综</option>
									<option value="文综">文综</option>
									<option value=""></option>
									<option value="英语口语">英语口语</option>
									<option value="新概念英语">新概念英语</option>
									<option value="牛津英语">牛津英语</option>
									<option value="托福">托福</option>
									<option value="雅思">雅思</option>
									<option value="商务英语">商务英语</option>
									<option value="日语">日语</option>
									<option value="韩语">韩语</option>
									<option value="德语">德语</option>
									<option value="法语">法语</option>
									<option value="意大利语">意大利语</option>
									<option value="西班牙语">西班牙语</option>
									<option value="阿拉伯语">阿拉伯语</option>
									<option value="对外汉语">对外汉语</option>
									<option value="sbs英语">sbs英语</option>
									<option value="俄语">俄语</option>
									<option value="葡萄牙语">葡萄牙语</option>
									<option value=""></option>
									<option value="钢琴">钢琴</option>
									<option value="电子琴">电子琴</option>
									<option value="小提琴">小提琴</option>
									<option value="小号">小号</option>
									<option value="芭蕾舞">芭蕾舞</option>
									<option value="吉他">吉他</option>
									<option value="民族舞">民族舞</option>
									<option value="单簧管">单簧管</option>
									<option value="萨克斯">萨克斯</option>
									<option value="声乐">声乐</option>
									<option value="大号">大号</option>
									<option value="视唱练耳">视唱练耳</option>
									<option value="古筝">古筝</option>
									<option value="手风琴">手风琴</option>
									<option value="琵琶">琵琶</option>
									<option value="长笛">长笛</option>
									<option value="圆号">圆号</option>
									<option value="打击乐">打击乐</option>
									<option value="大提琴">大提琴</option>
									<option value="二胡">二胡</option>
									<option value="古琴">古琴</option>
									<option value="中提琴">中提琴</option>
									<option value=""></option>
									<option value="高等数学">高等数学</option>
									<option value="网球">网球</option>
									<option value="乒乓球">乒乓球</option>
									<option value="游泳">游泳</option>
									<option value="油画">油画</option>
									<option value="素描">素描</option>
									<option value="围棋">围棋</option>
									<option value="中国画">中国画</option>
									<option value="国际象棋">国际象棋</option>
									<option value="羽毛球">羽毛球</option>
									<option value="中国象棋">中国象棋</option>
									<option value="卡通画">卡通画</option>
									<option value="书法">书法</option>
									<option value="美术">美术</option>
									<option value="跆拳道">跆拳道</option>
									<option value="水彩">水彩</option>
									<option value="漫画">漫画</option>
									<option value="空手道">空手道</option>
									<option value="SAT">SAT</option>
									<option value=""></option>
								</select>
	</body>
</html>
