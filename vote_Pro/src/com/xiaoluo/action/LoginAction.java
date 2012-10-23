package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private String username;
	
	private String password;
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	@Override
	public void validate()
	{
		if(!("admin".equals(username) && "admin".equals(password)))
		{
			this.addActionError("输入的管理员密码不正确!");
		}
	}
}
