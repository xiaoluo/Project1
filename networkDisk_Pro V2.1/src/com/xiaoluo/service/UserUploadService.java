package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.UserUpload;

public interface UserUploadService
{
	public void saveFile(UserUpload userUpload);
	
	public List<UserUpload> getAllUpload(String hql);
	
	public void deleteFile(int id);
	
	public UserUpload getSingleFile(int id);
	
	public void updateFile(UserUpload userUpload);
}
