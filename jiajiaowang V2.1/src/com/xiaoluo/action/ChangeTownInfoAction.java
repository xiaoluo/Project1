package com.xiaoluo.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Town;
import com.xiaoluo.bean.Town2;
import com.xiaoluo.service.TownService;

public class ChangeTownInfoAction extends ActionSupport
{
	private String cityId;
	
	private TownService townService;

	public String getCityId()
	{
		return cityId;
	}

	public void setCityId(String cityId)
	{
		this.cityId = cityId;
	}

	public TownService getTownService()
	{
		return townService;
	}

	public void setTownService(TownService townService)
	{
		this.townService = townService;
	}
	
	@Override
	public String execute() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		
		List<Town> towns = this.townService.getAllTown("from Town as t where t.city.id = " + this.cityId);
		
		List<Town2> towns2 = new ArrayList<Town2>();
		
		for(Town town : towns)
		{
			Town2 town2 = new Town2();
			
			town2.setId(town.getId());
			
			town2.setTownName(town.getTownName());
			
			towns2.add(town2);
		}
		
		Gson gson = new Gson();
		
		String townData = gson.toJson(towns2);
		
		PrintWriter out = response.getWriter();
		
		out.println(townData);
		
		out.flush();
		
		return null;
	}
}
