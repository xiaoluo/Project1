package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class University implements java.io.Serializable
{
	private Integer id;
	private Province province;
	private String universityName;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Province getProvince()
	{
		return province;
	}
	public void setProvince(Province province)
	{
		this.province = province;
	}
	public String getUniversityName()
	{
		return universityName;
	}
	public void setUniversityName(String universityName)
	{
		this.universityName = universityName;
	}
	public Set<Teacher> getTeachers()
	{
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers)
	{
		this.teachers = teachers;
	}
	
}