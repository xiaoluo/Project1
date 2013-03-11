package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.StudentOrder;

public interface StudentOrderDAO
{
	public List<StudentOrder> getAllStudentOrder(String hql);
	
	public void saveStudentOrder(StudentOrder studentOrder);
}
