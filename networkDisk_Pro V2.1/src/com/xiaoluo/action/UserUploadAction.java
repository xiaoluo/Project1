package com.xiaoluo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Authority;
import com.xiaoluo.bean.UserUpload;
import com.xiaoluo.service.AuthorityService;
import com.xiaoluo.util.AuthorityUtil;

public class UserUploadAction extends ActionSupport
{
	private List<File> file;
	
	private List<String> fileFileName;
	
	private int id;
	
	private AuthorityService authorityService;
	
	public List<File> getFile()
	{
		return file;
	}

	public void setFile(List<File> file)
	{
		this.file = file;
	}

	public List<String> getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public AuthorityService getAuthorityService()
	{
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService)
	{
		this.authorityService = authorityService;
	}
	
	@Override
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		ServletContext context = request.getSession().getServletContext();
		
		Authority authority = this.authorityService.getSingleAuthority(id);
		
		for(int i = 0; i < file.size(); i++)
		{
			File file2 = file.get(i);
			
			String file2FileName = fileFileName.get(i);

			//上传文件都放在upload文件夹里面
			String root = context.getRealPath("/userUpload");
			
			UserUpload userUpload = new UserUpload();
			
			InputStream is = new FileInputStream(file2);
			
			OutputStream os = new FileOutputStream(new File(root, file2FileName));
			
			int fileLength = is.available();
			
			@SuppressWarnings("unused")
			int length = 0;
			
			byte[] buffer = new byte[1000];
			
			while(-1 != (length = is.read(buffer, 0, 1000)))
			{
				os.write(buffer);
			}
			
			userUpload.setFileFileName(file2FileName);
			userUpload.setFileLength(fileLength);
			userUpload.setFileUploadDate(new java.sql.Date(new java.util.Date().getTime()));
			userUpload.setIsAudit(AuthorityUtil.NOTAUDIT);

			userUpload.setAuthority(authority);
			authority.getUserUploads().add(userUpload);
			
			this.authorityService.updateAuthority(authority);
			
			is.close();
			os.close();
		}
		
		return SUCCESS;
	}
}
