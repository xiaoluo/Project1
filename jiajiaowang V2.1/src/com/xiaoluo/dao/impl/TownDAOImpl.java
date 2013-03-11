package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Town;
import com.xiaoluo.dao.TownDAO;

public class TownDAOImpl extends HibernateDaoSupport implements TownDAO
{
	@SuppressWarnings("unchecked")
	public List<Town> getAllTown(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}
	
	public Town getSingleTown(int id)
	{
		return this.getHibernateTemplate().get(Town.class, id);
	}
}
