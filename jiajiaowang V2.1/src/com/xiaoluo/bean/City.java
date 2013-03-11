package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class City implements java.io.Serializable
{
	private Integer id;
	private Province province;
	private String cityName;
	private Set<Town> towns = new HashSet<Town>(0);
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
	public String getCityName()
	{
		return cityName;
	}
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	public Set<Town> getTowns()
	{
		return towns;
	}
	public void setTowns(Set<Town> towns)
	{
		this.towns = towns;
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