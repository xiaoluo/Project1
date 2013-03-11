package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.service.UserUploadService;
import com.xiaoluo.util.AuthorityUtil;

public class UpdateUserUploadAction extends ActionSupport
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
		UserUpload userUpload = this.userUploadService.getSingleFile(this.id);
		
		userUpload.setIsAudit(AuthorityUtil.ISAUDIT);
		
		this.userUploadService.updateFile(userUpload);
		
		return SUCCESS;
	}
}
