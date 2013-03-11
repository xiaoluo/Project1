package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.service.UserUploadService;

public class ListUserUploadAction extends ActionSupport
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
		List<UserUpload> userUploads = this.userUploadService.getAllUpload("from UserUpload as u where u.authority.id = " + this.id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("userUploads", userUploads);
		
		return SUCCESS;
	}
}
