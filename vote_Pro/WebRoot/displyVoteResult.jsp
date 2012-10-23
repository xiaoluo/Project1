<%@ page language="java" import="java.util.*, java.io.*, org.jfree.chart.ChartUtilities, com.xiaoluo.model.*" pageEncoding="UTF-8"%>
<%@ page import="java.awt.*"%>  
<%@ page import="org.jfree.chart.axis.CategoryAxis, org.jfree.data.category.*"%>  
<%@ page import="org.jfree.chart.axis.ValueAxis"%>  
<%@ page import="org.jfree.chart.ChartFactory"%>  
<%@ page import="org.jfree.chart.JFreeChart"%>  
<%@ page import="org.jfree.chart.labels.ItemLabelPosition"%>  
<%@ page import="org.jfree.chart.labels.ItemLabelAnchor"%>  
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>  
<%@ page import="org.jfree.chart.plot.CategoryPlot"%>  
<%@ page import="org.jfree.chart.renderer.category.BarRenderer3D"%>  
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>  
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>  
<%@ page import="org.jfree.ui.TextAnchor"%>  
<%@ page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator, org.jfree.chart.title.TextTitle"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displyVoteResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	
	<h3><font color="red" size="5">投票结果</font></h3><hr>
	
		<% if(request.getAttribute("voteOptions") == null)
		{
			out.println("<font color='blue' size='5'>你还没有投票,请投票！</font>");
			
			return;
		}
		%>
	
	<s:iterator value="#request.voteOptions" id="voteOption">
	
		<s:property value="#voteOption.voteOptionName"/>: &nbsp;&nbsp; <s:property value="#voteOption.ticketNum"/><br>
	
	</s:iterator>

	<% 
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
	
		Set<VoteOption> set = (Set<VoteOption>)request.getAttribute("voteOptions");
		
		for(VoteOption option : set)
		{
			dataset2.addValue(option.getTicketNum(), "", option.getVoteOptionName());
		}
	
		CategoryDataset dataset = dataset2;

		JFreeChart chart = ChartFactory.createBarChart3D("投票结果显示图", "得票数", "选项名称",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
	
		plot.setBackgroundAlpha(1.0f);
		
		plot.setBackgroundPaint(Color.WHITE);
		
		Font font = new Font("Console", Font.CENTER_BASELINE, 20);
		
		chart.setTitle(new TextTitle("投票结果显示图", font));
		
		chart.getLegend().setItemFont(font);
		
		plot.getDomainAxis().setLabelFont(font);
		
		plot.getDomainAxis().setTickLabelFont(font);
		
		plot.getRangeAxis().setLabelFont(font);
		
		try
		{
			ChartUtilities.writeChartAsJPEG(new FileOutputStream(request.getSession().getServletContext().getRealPath("/") + "imag/voteResultShow.jpeg"), 1.0f, chart, 600, 400);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	%>

		<img alt="1" src="imag/voteResultShow.jpeg">

  </body>
</html>
