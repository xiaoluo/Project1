package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Town;

public interface TownDAO
{
	public List<Town> getAllTown(String hql);
	
	public Town getSingleTown(int id);
}
