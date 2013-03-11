package com.xiaoluo.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.City;
import com.xiaoluo.bean.City2;
import com.xiaoluo.bean.University;
import com.xiaoluo.bean.University2;
import com.xiaoluo.service.CityService;
import com.xiaoluo.service.UniversityService;

public class ChangeCityInfoAction extends ActionSupport
{
	private String proId;
	
	private CityService cityService;
	
	private UniversityService universityService;
	
	public String getProId()
	{
		return proId;
	}

	public void setProId(String proId)
	{
		this.proId = proId;
	}

	public CityService getCityService()
	{
		return cityService;
	}

	public void setCityService(CityService cityService)
	{
		this.cityService = cityService;
	}

	public UniversityService getUniversityService()
	{
		return universityService;
	}

	public void setUniversityService(UniversityService universityService)
	{
		this.universityService = universityService;
	}

	@Override
	public String execute() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		
		List<City> cities = this.cityService.getAllCity("from City as c where c.province.id = " + this.proId);
		
		List<University> universities = this.universityService.getAllUniversity("from University as u where u.province.id = " + this.proId);
		
		Gson gson = new Gson();
		
		List<City2> cities2 = new ArrayList<City2>();
		
		List<University2> universities2 = new ArrayList<University2>();
		
		for(City city : cities)
		{
			City2 city2 = new City2();
			
			city2.setId(city.getId());
			
			city2.setCityName(city.getCityName());
			
			cities2.add(city2);
		}
		
		for(University university : universities)
		{
			University2 university2 = new University2();
			
			university2.setId(university.getId());
			
			university2.setUniversityName(university.getUniversityName());
			
			universities2.add(university2);
		}
		
		String cityData = gson.toJson(cities2);
		
		String universityData = gson.toJson(universities2);
		
		// 将cityData 和 universityData 合并成[]类型的json数据类型
		String data = "[" + cityData + "," + universityData + "]";
		
		PrintWriter out = response.getWriter();
		
		out.println(data);
		
		out.flush();

		return null;
	}
}
