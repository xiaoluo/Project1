package com.xiaoluo.dao.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.dao.UserUploadDAO;

public class UserUploadDAOImpl extends HibernateDaoSupport implements UserUploadDAO
{

	@Override
	public void deleteFile(int id)
	{
		UserUpload userUpload = this.getHibernateTemplate().get(UserUpload.class, id);
		
		String fileFileName = userUpload.getFileFileName();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String root = request.getSession().getServletContext().getRealPath("/userUpload");
		
		File file = new File(root + "/" + fileFileName);
		
		file.delete();
		
		userUpload.getAuthority().getUserUploads().remove(userUpload);
		
		userUpload.setAuthority(null);
		
		this.getHibernateTemplate().delete(userUpload);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserUpload> getAllUpload(String hql)
	{
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public UserUpload getSingleFile(int id)
	{
		return this.getHibernateTemplate().get(UserUpload.class, id);
	}

	@Override
	public void saveFile(UserUpload userUpload)
	{
		this.getHibernateTemplate().save(userUpload);
	}

	@Override
	public void updateFile(UserUpload userUpload)
	{
		this.getHibernateTemplate().update(userUpload);
	}

}
