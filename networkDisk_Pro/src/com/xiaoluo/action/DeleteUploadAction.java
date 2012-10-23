package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.service.FileUploadService;

public class DeleteUploadAction extends ActionSupport
{
	private int id;
	
	private FileUploadService fileUploadService;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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
		fileUploadService.deleteFile(id);
		
		return SUCCESS;
	}
	
}
