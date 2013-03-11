package com.xiaoluo.bean;

public class Download
{
	private int id;
	
	private String fileFileName;
	
	private int downloadCount;
	
	private Upload upload;

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

	public int getDownloadCount()
	{
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount)
	{
		this.downloadCount = downloadCount;
	}

	public Upload getUpload()
	{
		return upload;
	}

	public void setUpload(Upload upload)
	{
		this.upload = upload;
	}
	
}
