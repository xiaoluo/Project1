package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.StudentOrder;
import com.xiaoluo.dao.StudentOrderDAO;
import com.xiaoluo.service.StudentOrderService;

public class StudentOrderServiceImpl implements StudentOrderService
{
	private StudentOrderDAO studentOrderDAO;
	
	public StudentOrderDAO getStudentOrderDAO()
	{
		return studentOrderDAO;
	}

	public void setStudentOrderDAO(StudentOrderDAO studentOrderDAO)
	{
		this.studentOrderDAO = studentOrderDAO;
	}

	public List<StudentOrder> getAllStudentOrder(String hql)
	{
		return this.studentOrderDAO.getAllStudentOrder(hql);
	}

	public void saveStudentOrder(StudentOrder studentOrder)
	{
		this.studentOrderDAO.saveStudentOrder(studentOrder);
	}

}
