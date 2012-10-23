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
import com.xiaoluo.bean.Download;
import com.xiaoluo.bean.Upload;
import com.xiaoluo.service.FileUploadService;

public class UploadAction extends ActionSupport
{
	private List<File> file;
	
	private List<String> fileFileName;

	private FileUploadService fileUploadService;
	
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
	
	public FileUploadService getFileUploadService()
	{
		return fileUploadService;
	}

	public void setFileUploadService(FileUploadService fileUploadService)
	{
		this.fileUploadService = fileUploadService;
	}

	@Override
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		ServletContext context = request.getSession().getServletContext();
		
		for(int i = 0; i < file.size(); i++)
		{
			File file2 = file.get(i);
			
			String file2FileName = fileFileName.get(i);

			//上传文件都放在upload文件夹里面
			String root = context.getRealPath("/upload");
			
			Upload upload = new Upload();
			Download download = new Download();
			
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
			
			upload.setFileFileName(file2FileName);
			upload.setFileLength(fileLength);
			upload.setFileUploadDate(new java.sql.Date(new java.util.Date().getTime()));

			download.setFileFileName(file2FileName);
			download.setUpload(upload);
			upload.setDownload(download);
			
			fileUploadService.saveFile(upload);
			
			is.close();
			os.close();
		}
		
		return SUCCESS;
	}
}
