package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Teacher;
import com.xiaoluo.service.TeacherService;
import com.xiaoluo.util.TeacherLogin;

public class LoginValidateAction extends ActionSupport
{
	private String checkCode;
	
	private String username;
	
	private String password;
	
	private TeacherService teacherService;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	public String getCheckCode()
	{
		return checkCode;
	}

	public void setCheckCode(String checkCode)
	{
		this.checkCode = checkCode;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public TeacherService getTeacherService()
	{
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService)
	{
		this.teacherService = teacherService;
	}

	@Override
	public String execute() throws Exception
	{
		List<Teacher> teachers = this.teacherService.getAllTeacher("from Teacher");
		
		for(Teacher teacher : teachers)
		{
			if(teacher.getUsername().equals(this.username) && teacher.getPassword().equals(this.password))
			{
				session.setAttribute("teacherId", teacher.getId());
				
				session.setAttribute("teacherName", this.username);
				
				// 设置登陆状态为已登陆
				teacher.setIsLogin(TeacherLogin.LOGIN);
				
				this.teacherService.updateTeacher(teacher);
				
				return SUCCESS;
			}
		}
		
		this.addActionError("你输入的用户名或密码不正确，请重新输入！");
		
		return ERROR;
	}
	
	@Override
	public void validate()
	{
		String checkCode2 = (String) session.getAttribute("checkCode");
		
		if(!checkCode2.equals(this.checkCode))
		{
			this.addActionError("你输入的验证码不正确，请重新输入！");
		}
	}
}
