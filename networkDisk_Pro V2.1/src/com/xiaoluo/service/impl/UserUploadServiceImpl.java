package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.dao.UserUploadDAO;
import com.xiaoluo.service.UserUploadService;

public class UserUploadServiceImpl implements UserUploadService
{
	private UserUploadDAO userUploadDAO;
	
	public UserUploadDAO getUserUploadDAO()
	{
		return userUploadDAO;
	}

	public void setUserUploadDAO(UserUploadDAO userUploadDAO)
	{
		this.userUploadDAO = userUploadDAO;
	}

	@Override
	public void deleteFile(int id)
	{
		this.userUploadDAO.deleteFile(id);
	}

	@Override
	public List<UserUpload> getAllUpload(String hql)
	{
		return this.userUploadDAO.getAllUpload(hql);
	}

	@Override
	public UserUpload getSingleFile(int id)
	{
		return this.userUploadDAO.getSingleFile(id);
	}

	@Override
	public void saveFile(UserUpload userUpload)
	{
		this.userUploadDAO.saveFile(userUpload);
	}

	@Override
	public void updateFile(UserUpload userUpload)
	{
		this.userUploadDAO.updateFile(userUpload);
	}

}
