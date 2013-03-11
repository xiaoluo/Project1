package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.University;

public interface UniversityDAO
{
	public List<University> getAllUniversity(String hql);
	
	public University getSingleUniversity(int id);
}
