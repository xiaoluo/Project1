package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Download;
import com.xiaoluo.bean.Upload;

public interface FileUploadDAO
{
	public void saveFile(Upload upload);
	
	public List<Upload> getAllUpload();
	
	public void deleteFile(int id);
	
	public Upload getSingleFile(int id);
	
	public void updateDownload(Download download);
}
