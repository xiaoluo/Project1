package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.StudentOrder;

public interface StudentOrderService
{	
	public List<StudentOrder> getAllStudentOrder(String hql);
	
	public void saveStudentOrder(StudentOrder studentOrder);
}
