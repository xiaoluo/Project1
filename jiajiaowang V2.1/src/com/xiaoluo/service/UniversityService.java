package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.University;

public interface UniversityService
{
	public List<University> getAllUniversity(String hql);
	
	public University getSingleUniversity(int id);
}
