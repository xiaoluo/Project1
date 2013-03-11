package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Authority;
import com.xiaoluo.service.AuthorityService;

public class LoginValidateAction extends ActionSupport
{
	private String checkCode;
	
	private String username;
	
	private String password;
	
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	private AuthorityService authorityService;
	
	public String getCheckCode()
	{
		return checkCode;
	}

	public void setCheckCode(String checkCode)
	{
		this.checkCode = checkCode;
	}
	
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
		
		List<Authority> list = authorityService.getAllAuthority();
		
		for(Authority authority : list)
		{
			if(username.equals(authority.getAuthorityName()) && password.equals(authority.getPassword()))
			{
				this.id = authority.getId();
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				request.setAttribute("id", this.id);
				
				return SUCCESS;
			}
		}
		
		this.addActionError("用户名或密码输入错误，请重新输入！");
		return ERROR;
	}
	
	@Override
	public void validate()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String checkCode2 = (String)session.getAttribute("checkCode");
		
		if(!checkCode.equals(checkCode2))
		{
			this.addActionError("输入的验证码不正确，请重新输入！");
		}
	}
}
