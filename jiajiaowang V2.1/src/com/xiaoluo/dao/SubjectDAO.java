package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Subject;

public interface SubjectDAO
{
	public List<Subject> getAllSubject(String hql);
}
