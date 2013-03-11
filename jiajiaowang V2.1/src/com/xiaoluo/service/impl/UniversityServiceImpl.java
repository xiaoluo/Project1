package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.University;
import com.xiaoluo.dao.UniversityDAO;
import com.xiaoluo.service.UniversityService;

public class UniversityServiceImpl implements UniversityService
{	
	private UniversityDAO universityDAO;
	
	public UniversityDAO getUniversityDAO()
	{
		return universityDAO;
	}

	public void setUniversityDAO(UniversityDAO universityDAO)
	{
		this.universityDAO = universityDAO;
	}

	public List<University> getAllUniversity(String hql)
	{
		return this.universityDAO.getAllUniversity(hql);
	}
	
	public University getSingleUniversity(int id)
	{
		return this.universityDAO.getSingleUniversity(id);
	}

}
