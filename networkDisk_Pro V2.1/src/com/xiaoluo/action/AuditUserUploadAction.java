package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.service.UserUploadService;

public class AuditUserUploadAction extends ActionSupport
{
	private UserUploadService userUploadService;
	
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
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<UserUpload> auditUserUploads = this.userUploadService.getAllUpload("from UserUpload as u where u.isAudit = 2");
		
		request.setAttribute("auditUserUploads", auditUserUploads);
		
		return SUCCESS;
	}
}
