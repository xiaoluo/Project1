package com.xiaoluo.dao.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Download;
import com.xiaoluo.bean.Upload;
import com.xiaoluo.dao.FileUploadDAO;

public class FileUploadDAOImpl extends HibernateDaoSupport implements FileUploadDAO
{
	@Override
	public void saveFile(Upload upload)
	{
		this.getHibernateTemplate().save(upload);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Upload> getAllUpload()
	{
		List<Upload> list = this.getHibernateTemplate().find("from Upload");
		
		return list;
	}
	
	@Override
	public void deleteFile(int id)
	{
		Upload upload = this.getHibernateTemplate().get(Upload.class, id);
		
		String fileFileName = upload.getFileFileName();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String root = request.getSession().getServletContext().getRealPath("/upload");
		
		File file = new File(root + "/" + fileFileName);
		
		file.delete();
		
		this.getHibernateTemplate().delete(upload);
	}
	
	@Override
	public Upload getSingleFile(int id)
	{
		return this.getHibernateTemplate().get(Upload.class, id);
	}
	
	@Override
	public void updateDownload(Download download)
	{
		this.getHibernateTemplate().update(download);
	}
}
