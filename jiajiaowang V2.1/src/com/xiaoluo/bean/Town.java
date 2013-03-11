package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class Town implements java.io.Serializable
{
	private Integer id;
	private City city;
	private String townName;
	private Set<Teacher> teachersForWorkPos = new HashSet<Teacher>(0);
	private Set<Teacher> teachersForCityPos = new HashSet<Teacher>(0);
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public City getCity()
	{
		return city;
	}
	public void setCity(City city)
	{
		this.city = city;
	}
	public String getTownName()
	{
		return townName;
	}
	public void setTownName(String townName)
	{
		this.townName = townName;
	}
	public Set<Teacher> getTeachersForWorkPos()
	{
		return teachersForWorkPos;
	}
	public void setTeachersForWorkPos(Set<Teacher> teachersForWorkPos)
	{
		this.teachersForWorkPos = teachersForWorkPos;
	}
	public Set<Teacher> getTeachersForCityPos()
	{
		return teachersForCityPos;
	}
	public void setTeachersForCityPos(Set<Teacher> teachersForCityPos)
	{
		this.teachersForCityPos = teachersForCityPos;
	}
	
}