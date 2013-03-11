package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Authority;
import com.xiaoluo.service.AuthorityService;

public class ListAuthorityAction extends ActionSupport
{
	private AuthorityService authorityService;

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
		List<Authority> authorities = authorityService.getAllAuthority();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("authorities", authorities);
		
		return SUCCESS;
	}
	
}
