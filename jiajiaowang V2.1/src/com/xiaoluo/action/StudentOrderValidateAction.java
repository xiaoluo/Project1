package com.xiaoluo.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.StudentOrder;
import com.xiaoluo.service.StudentOrderService;

public class StudentOrderValidateAction extends ActionSupport
{
	private String subjectName;
	private String courseName;
	private String stuGender;
	private String grade;
	private String details;
	private String everyweek;
	private String everytime;
	private String teaGender;
	private String teaType;
	private String teaFee;
	private String contact;
	private String mobile;
	private String area;
	private String areaCross;
	private String checkCode;
	
	private StudentOrderService studentOrderService;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public String getStuGender()
	{
		return stuGender;
	}

	public void setStuGender(String stuGender)
	{
		this.stuGender = stuGender;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public String getDetails()
	{
		return details;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}

	public String getEveryweek()
	{
		return everyweek;
	}

	public void setEveryweek(String everyweek)
	{
		this.everyweek = everyweek;
	}

	public String getEverytime()
	{
		return everytime;
	}

	public void setEverytime(String everytime)
	{
		this.everytime = everytime;
	}

	public String getTeaGender()
	{
		return teaGender;
	}

	public void setTeaGender(String teaGender)
	{
		this.teaGender = teaGender;
	}

	public String getTeaType()
	{
		return teaType;
	}

	public void setTeaType(String teaType)
	{
		this.teaType = teaType;
	}

	public String getTeaFee()
	{
		return teaFee;
	}

	public void setTeaFee(String teaFee)
	{
		this.teaFee = teaFee;
	}

	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getAreaCross()
	{
		return areaCross;
	}

	public void setAreaCross(String areaCross)
	{
		this.areaCross = areaCross;
	}

	public String getCheckCode()
	{
		return checkCode;
	}

	public void setCheckCode(String checkCode)
	{
		this.checkCode = checkCode;
	}

	public StudentOrderService getStudentOrderService()
	{
		return studentOrderService;
	}

	public void setStudentOrderService(StudentOrderService studentOrderService)
	{
		this.studentOrderService = studentOrderService;
	}

	@Override
	public String execute() throws Exception
	{
		StudentOrder studentOrder = new StudentOrder();
		
		studentOrder.setSubjectName(this.subjectName);
		studentOrder.setCourseName(this.courseName);
		studentOrder.setStuGender(this.stuGender);
		studentOrder.setGrade(this.grade);
		studentOrder.setDetails(this.details);
		studentOrder.setEveryweek(this.everyweek);
		studentOrder.setEverytime(this.everytime);
		studentOrder.setTeaGender(this.teaGender);
		studentOrder.setTeaType(this.teaType);
		studentOrder.setTeaFee(this.teaFee);
		studentOrder.setContact(this.contact);
		studentOrder.setMobile(this.mobile);
		studentOrder.setArea(this.area);
		studentOrder.setAreaCross(this.areaCross);
		
		this.studentOrderService.saveStudentOrder(studentOrder);
		
		return SUCCESS;
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
