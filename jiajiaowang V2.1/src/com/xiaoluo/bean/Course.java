package com.xiaoluo.bean;

public class Course implements java.io.Serializable
{
	private Integer id;
	private Subject subject;
	private String courseName;
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Subject getSubject()
	{
		return subject;
	}
	public void setSubject(Subject subject)
	{
		this.subject = subject;
	}
	public String getCourseName()
	{
		return courseName;
	}
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
}