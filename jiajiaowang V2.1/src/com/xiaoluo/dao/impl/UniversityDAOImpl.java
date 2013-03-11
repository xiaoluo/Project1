package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.University;
import com.xiaoluo.dao.UniversityDAO;

public class UniversityDAOImpl extends HibernateDaoSupport implements UniversityDAO
{
	@SuppressWarnings("unchecked")
	public List<University> getAllUniversity(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}
	
	public University getSingleUniversity(int id)
	{
		return this.getHibernateTemplate().get(University.class, id);
	}
}
