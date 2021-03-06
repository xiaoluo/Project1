package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.Teacher;

public interface TeacherService
{
	public void saveTeacher(Teacher teacher);
	
	public void updateTeacher(Teacher teacher);
	
	public void deleteTeacher(int id);
	
	public List<Teacher> getAllTeacher(String hql);
	
	public Teacher getSingleTeacher(int id);
}
