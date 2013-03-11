package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Course;
import com.xiaoluo.dao.CourseDAO;
import com.xiaoluo.service.CourseService;

public class CourseServiceImpl implements CourseService
{
	private CourseDAO courseDAO;
	
	public CourseDAO getCourseDAO()
	{
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO)
	{
		this.courseDAO = courseDAO;
	}

	public List<Course> getAllCourse(String hql)
	{
		return this.courseDAO.getAllCourse(hql);
	}
}
