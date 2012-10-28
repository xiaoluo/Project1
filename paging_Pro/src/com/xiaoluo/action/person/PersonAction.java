package com.xiaoluo.action.person;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.PageBean;
import com.xiaoluo.service.PersonService;
import com.xiaoluo.service.impl.PersonServiceImpl;

public class PersonAction extends ActionSupport
{
	private PersonService personService = new PersonServiceImpl();
	
	private int page;
	
	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	@Override
	public String execute() throws Exception
	{
		//表示每页显示5条记录，page表示当前网页
		PageBean pageBean = personService.getPageBean(5, page);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("pageBean", pageBean);
		
		return SUCCESS;
	}
}
