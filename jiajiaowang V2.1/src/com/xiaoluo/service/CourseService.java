package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.Course;

public interface CourseService
{
	public List<Course> getAllCourse(String hql);
}
