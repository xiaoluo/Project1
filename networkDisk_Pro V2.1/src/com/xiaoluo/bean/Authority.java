package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class Authority
{
	private int id;
	
	private String authorityName;
	
	private int level;
	
	private String password;
	
	private Set<UserUpload> userUploads = new HashSet<UserUpload>();
	
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

	public Set<UserUpload> getUserUploads()
	{
		return userUploads;
	}

	public void setUserUploads(Set<UserUpload> userUploads)
	{
		this.userUploads = userUploads;
	}

}
