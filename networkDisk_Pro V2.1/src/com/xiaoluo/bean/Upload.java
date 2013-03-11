package com.xiaoluo.bean;

import java.sql.Date;

public class Upload
{
	private int id;
	
	private String fileFileName;
	
	private int fileLength;
	
	private Date fileUploadDate;
	
	private Download download;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public int getFileLength()
	{
		return fileLength;
	}

	public void setFileLength(int fileLength)
	{
		this.fileLength = fileLength;
	}

	public Date getFileUploadDate()
	{
		return fileUploadDate;
	}

	public void setFileUploadDate(Date fileUploadDate)
	{
		this.fileUploadDate = fileUploadDate;
	}

	public Download getDownload()
	{
		return download;
	}

	public void setDownload(Download download)
	{
		this.download = download;
	}
	
}
