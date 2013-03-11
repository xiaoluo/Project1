package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class Province implements java.io.Serializable
{
	private Integer id;
	private String proName;
	private Set<University> universities = new HashSet<University>(0);
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	private Set<City> cities = new HashSet<City>(0);
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getProName()
	{
		return proName;
	}
	public void setProName(String proName)
	{
		this.proName = proName;
	}
	public Set<University> getUniversities()
	{
		return universities;
	}
	public void setUniversities(Set<University> universities)
	{
		this.universities = universities;
	}
	public Set<Teacher> getTeachers()
	{
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers)
	{
		this.teachers = teachers;
	}
	public Set<City> getCities()
	{
		return cities;
	}
	public void setCities(Set<City> cities)
	{
		this.cities = cities;
	}
	
}