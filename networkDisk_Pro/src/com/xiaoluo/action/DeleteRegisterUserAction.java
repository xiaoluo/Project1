package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.service.AuthorityService;

public class DeleteRegisterUserAction extends ActionSupport
{
	private int id;
	
	private AuthorityService authorityService;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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
		authorityService.deleteAuthority(id);
		
		return SUCCESS;
	}
	
}
