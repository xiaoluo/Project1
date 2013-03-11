package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.City;

public interface CityDAO
{
	public List<City> getAllCity(String hql);
	
	public City getSingleCity(int id);
}
