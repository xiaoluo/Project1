package com.xiaoluo.action;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Download;
import com.xiaoluo.bean.Upload;
import com.xiaoluo.service.FileUploadService;

public class DownloadAction extends ActionSupport
{
	private int id;
	
	private InputStream downloadInputStream;
	
	private FileUploadService fileUploadService;
	
	private String filename;
	
	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

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
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Upload upload = fileUploadService.getSingleFile(id);
		
		Download download = upload.getDownload();
		
		String fileFileName = upload.getFileFileName();
		
		InputStream uploadInputStream = request.getSession().getServletContext().getResourceAsStream("upload/" + fileFileName);
		
		this.downloadInputStream = uploadInputStream;
		
		String fileFileName2 = new String(fileFileName.getBytes("utf-8"), "iso-8859-1");
		
		this.filename = fileFileName2;
		
		int count = download.getDownloadCount();
		
		download.setDownloadCount(count + 1);
		
		fileUploadService.updateDownload(download);
		
		return SUCCESS;
	}
	
}
