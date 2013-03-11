package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Teacher;
import com.xiaoluo.dao.TeacherDAO;
import com.xiaoluo.service.TeacherService;

public class TeacherServiceImpl implements TeacherService
{
	private TeacherDAO teacherDAO;
	
	public TeacherDAO getTeacherDAO()
	{
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO)
	{
		this.teacherDAO = teacherDAO;
	}

	public void deleteTeacher(int id)
	{
		this.teacherDAO.deleteTeacher(id);
	}

	public List<Teacher> getAllTeacher(String hql)
	{
		return this.teacherDAO.getAllTeacher(hql);
	}

	public void saveTeacher(Teacher teacher)
	{
		this.teacherDAO.saveTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher)
	{
		this.teacherDAO.updateTeacher(teacher);
	}
	
	public Teacher getSingleTeacher(int id)
	{
		return this.teacherDAO.getSingleTeacher(id);
	}

}
