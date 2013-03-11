package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.Town;

public interface TownService
{
	public List<Town> getAllTown(String hql);
	
	public Town getSingleTown(int id);
}
