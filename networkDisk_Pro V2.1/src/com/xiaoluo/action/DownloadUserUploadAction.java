package com.xiaoluo.action;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.service.UserUploadService;

public class DownloadUserUploadAction extends ActionSupport
{
	private int id;
	
	private InputStream downloadInputStream;
	
	private UserUploadService userUploadService;
	
	private String filename;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public InputStream getDownloadInputStream()
	{
		return downloadInputStream;
	}

	public void setDownloadInputStream(InputStream downloadInputStream)
	{
		this.downloadInputStream = downloadInputStream;
	}

	public UserUploadService getUserUploadService()
	{
		return userUploadService;
	}

	public void setUserUploadService(UserUploadService userUploadService)
	{
		this.userUploadService = userUploadService;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	@Override
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		UserUpload userUpload = this.userUploadService.getSingleFile(id);
		
		String fileFileName = userUpload.getFileFileName();
		
		InputStream uploadInputStream = request.getSession().getServletContext().getResourceAsStream("userUpload/" + fileFileName);
		
		this.downloadInputStream = uploadInputStream;
		
		String fileFileName2 = new String(fileFileName.getBytes("utf-8"), "iso-8859-1");
		
		this.filename = fileFileName2;
		
		return SUCCESS;
	}
}
