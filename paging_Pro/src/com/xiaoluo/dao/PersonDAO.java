package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Person;

public interface PersonDAO
{
	public List<Person> queryByPage(String hql, int offset, int pageSize);
	
	public int getAllRowCount(String hql);
}
