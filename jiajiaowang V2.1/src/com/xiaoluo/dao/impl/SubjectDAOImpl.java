package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Subject;
import com.xiaoluo.dao.SubjectDAO;

public class SubjectDAOImpl extends HibernateDaoSupport implements SubjectDAO
{
	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubject(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}
}
