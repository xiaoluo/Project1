package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Town;
import com.xiaoluo.dao.TownDAO;
import com.xiaoluo.service.TownService;

public class TownServiceImpl implements TownService
{
	private TownDAO townDAO;
	
	public TownDAO getTownDAO()
	{
		return townDAO;
	}

	public void setTownDAO(TownDAO townDAO)
	{
		this.townDAO = townDAO;
	}

	public List<Town> getAllTown(String hql)
	{
		return this.townDAO.getAllTown(hql);
	}

	public Town getSingleTown(int id)
	{
		return this.townDAO.getSingleTown(id);
	}
	
}
