package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Teacher;
import com.xiaoluo.dao.TeacherDAO;

public class TeacherDAOImpl extends HibernateDaoSupport implements TeacherDAO
{
	public void deleteTeacher(int id)
	{
		Teacher teacher = this.getHibernateTemplate().get(Teacher.class, id);
		
		this.getHibernateTemplate().delete(teacher);
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}

	public void saveTeacher(Teacher teacher)
	{
		this.getHibernateTemplate().save(teacher);
	}

	public void updateTeacher(Teacher teacher)
	{
		this.getHibernateTemplate().update(teacher);
	}
	
	public Teacher getSingleTeacher(int id)
	{
		return this.getHibernateTemplate().get(Teacher.class, id);
	}

}
