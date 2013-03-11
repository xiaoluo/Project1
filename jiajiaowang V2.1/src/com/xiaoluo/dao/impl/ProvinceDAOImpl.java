package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Province;
import com.xiaoluo.dao.ProvinceDAO;

public class ProvinceDAOImpl extends HibernateDaoSupport implements ProvinceDAO
{
	@SuppressWarnings("unchecked")
	public List<Province> getAllProvice(String hql)
	{
		List<Province> provinces = this.getHibernateTemplate().find(hql);
		
		return provinces;
	}
	
	public Province getSingleProvince(int id)
	{
		return this.getHibernateTemplate().get(Province.class, id);
	}
}
