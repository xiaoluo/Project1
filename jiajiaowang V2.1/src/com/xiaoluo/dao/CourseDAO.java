package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Course;

public interface CourseDAO
{	
	public List<Course> getAllCourse(String hql);
}	
