package com.xiaoluo.bean;

public class Authority
{
	private int id;
	
	private String authorityName;
	
	private int level;
	
	private String password;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAuthorityName()
	{
		return authorityName;
	}

	public void setAuthorityName(String authorityName)
	{
		this.authorityName = authorityName;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
