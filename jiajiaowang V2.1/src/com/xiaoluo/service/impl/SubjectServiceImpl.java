package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Subject;
import com.xiaoluo.dao.SubjectDAO;
import com.xiaoluo.service.SubjectService;

public class SubjectServiceImpl implements SubjectService
{
	private SubjectDAO subjectDAO;
	
	public SubjectDAO getSubjectDAO()
	{
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO)
	{
		this.subjectDAO = subjectDAO;
	}

	public List<Subject> getAllSubject(String hql)
	{
		return this.subjectDAO.getAllSubject(hql);
	}

}
