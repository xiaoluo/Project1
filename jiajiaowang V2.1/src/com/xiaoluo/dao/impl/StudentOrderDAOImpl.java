package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.StudentOrder;
import com.xiaoluo.dao.StudentOrderDAO;

public class StudentOrderDAOImpl extends HibernateDaoSupport implements StudentOrderDAO
{
	@SuppressWarnings("unchecked")
	public List<StudentOrder> getAllStudentOrder(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}

	public void saveStudentOrder(StudentOrder studentOrder)
	{
		this.getHibernateTemplate().save(studentOrder);
	}

}
