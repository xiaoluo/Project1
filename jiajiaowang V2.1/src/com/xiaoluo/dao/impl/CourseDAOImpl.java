package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Course;
import com.xiaoluo.dao.CourseDAO;

public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO
{
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourse(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}
}
