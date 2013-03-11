package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Authority;
import com.xiaoluo.service.AuthorityService;
import com.xiaoluo.util.AuthorityUtil;

public class UserLoginAction extends ActionSupport
{
	private String username;
	
	private String password;
	
	private String repassword;
	
	private AuthorityService authorityService;

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

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public AuthorityService getAuthorityService()
	{
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService)
	{
		this.authorityService = authorityService;
	}

	@Override
	public String execute() throws Exception
	{
		Authority authority = new Authority();
		
		authority.setAuthorityName(username);
		authority.setPassword(password);
		authority.setLevel(AuthorityUtil.USER);
		
		authorityService.saveAuthority(authority);
		
		return SUCCESS;
	}
	
}	
