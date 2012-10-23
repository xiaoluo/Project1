package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Download;
import com.xiaoluo.bean.Upload;
import com.xiaoluo.dao.FileUploadDAO;
import com.xiaoluo.service.FileUploadService;

public class FileUploadServiceImpl implements FileUploadService
{
	private FileUploadDAO fileUploadDAO;
	
	public FileUploadDAO getFileUploadDAO()
	{
		return fileUploadDAO;
	}

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO)
	{
		this.fileUploadDAO = fileUploadDAO;
	}

	@Override
	public void saveFile(Upload upload)
	{
		fileUploadDAO.saveFile(upload);
	}
	
	@Override
	public List<Upload> getAllUpload()
	{
		return fileUploadDAO.getAllUpload();
	}

	@Override
	public void deleteFile(int id)
	{
		fileUploadDAO.deleteFile(id);
	}
	
	@Override
	public Upload getSingleFile(int id)
	{
		return fileUploadDAO.getSingleFile(id);
	}
	
	@Override
	public void updateDownload(Download download)
	{
		fileUploadDAO.updateDownload(download);
	}
}
