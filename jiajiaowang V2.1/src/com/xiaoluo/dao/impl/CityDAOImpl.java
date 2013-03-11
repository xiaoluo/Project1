package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.City;
import com.xiaoluo.dao.CityDAO;

public class CityDAOImpl extends HibernateDaoSupport implements CityDAO
{
	@SuppressWarnings("unchecked")
	public List<City> getAllCity(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}
	
	public City getSingleCity(int id)
	{
		return this.getHibernateTemplate().get(City.class, id);
	}
}
