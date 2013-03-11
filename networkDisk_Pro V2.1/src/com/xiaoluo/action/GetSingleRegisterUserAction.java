package com.xiaoluo.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Authority;
import com.xiaoluo.service.AuthorityService;

public class GetSingleRegisterUserAction extends ActionSupport
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
		Authority authority = authorityService.getSingleAuthority(id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("authority", authority);
		
		return SUCCESS;
	}
	
}
