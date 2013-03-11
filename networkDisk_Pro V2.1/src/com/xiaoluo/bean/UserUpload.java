package com.xiaoluo.bean;

import java.util.Date;

public class UserUpload
{
	private int id;
	
	private String fileFileName;
	
	private int fileLength;
	
	private Date fileUploadDate;
	
	private int isAudit;
	
	private Authority authority;

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

	public int getIsAudit()
	{
		return isAudit;
	}

	public void setIsAudit(int isAudit)
	{
		this.isAudit = isAudit;
	}

	public Authority getAuthority()
	{
		return authority;
	}

	public void setAuthority(Authority authority)
	{
		this.authority = authority;
	}
	
}
