package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.City;

public interface CityService
{
	public List<City> getAllCity(String hql);
	
	public City getSingleCity(int id);
}
