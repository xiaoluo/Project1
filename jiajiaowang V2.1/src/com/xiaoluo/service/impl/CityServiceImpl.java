package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.City;
import com.xiaoluo.dao.CityDAO;
import com.xiaoluo.service.CityService;

public class CityServiceImpl implements CityService
{
	private CityDAO cityDAO;
	
	public CityDAO getCityDAO()
	{
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO)
	{
		this.cityDAO = cityDAO;
	}

	public List<City> getAllCity(String hql)
	{
		return this.cityDAO.getAllCity(hql);
	}
	
	public City getSingleCity(int id)
	{
		return this.cityDAO.getSingleCity(id);
	}

}
