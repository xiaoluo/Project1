package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Upload;
import com.xiaoluo.service.FileUploadService;

public class ListAllUploadAction extends ActionSupport
{
	private String authority;
	
	private FileUploadService fileUploadService;

	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	public FileUploadService getFileUploadService()
	{
		return fileUploadService;
	}

	public void setFileUploadService(FileUploadService fileUploadService)
	{
		this.fileUploadService = fileUploadService;
	}
	
	@Override
	public String execute() throws Exception
	{
		List<Upload> uploads = fileUploadService.getAllUpload();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("uploads", uploads);
		
		return SUCCESS;
	}
}
