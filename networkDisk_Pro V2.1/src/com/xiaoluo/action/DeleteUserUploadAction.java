package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.service.UserUploadService;

public class DeleteUserUploadAction extends ActionSupport
{
	private int id;
	
	private UserUploadService userUploadService;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public UserUploadService getUserUploadService()
	{
		return userUploadService;
	}

	public void setUserUploadService(UserUploadService userUploadService)
	{
		this.userUploadService = userUploadService;
	}

	@Override
	public String execute() throws Exception
	{
		this.userUploadService.deleteFile(this.id);
		
		return SUCCESS;
	}
}
