package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class Subject implements java.io.Serializable
{
	private Integer id;
	private String subjectName;
	private Set<Course> courses = new HashSet<Course>(0);
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getSubjectName()
	{
		return subjectName;
	}
	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}
	public Set<Course> getCourses()
	{
		return courses;
	}
	public void setCourses(Set<Course> courses)
	{
		this.courses = courses;
	}
	
}