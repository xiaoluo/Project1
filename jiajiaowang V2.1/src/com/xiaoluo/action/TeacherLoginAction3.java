package com.xiaoluo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.Teacher;
import com.xiaoluo.bean.TeacherCourse;
import com.xiaoluo.service.TeacherService;
import com.xiaoluo.util.TeacherAudit;
import com.xiaoluo.util.TeacherLogin;

public class TeacherLoginAction3 extends ActionSupport
{
	private int teacherId;
	
	private String appraiseSelf;
	private String certificate;
	private String resume;
	private String teach_place;
	private String first_subject;
	
	private TeacherService teacherService;
	
	public int getTeacherId()
	{
		return teacherId;
	}

	public void setTeacherId(int teacherId)
	{
		this.teacherId = teacherId;
	}

	public String getAppraiseSelf()
	{
		return appraiseSelf;
	}

	public void setAppraiseSelf(String appraiseSelf)
	{
		this.appraiseSelf = appraiseSelf;
	}

	public String getCertificate()
	{
		return certificate;
	}

	public void setCertificate(String certificate)
	{
		this.certificate = certificate;
	}

	public String getResume()
	{
		return resume;
	}

	public void setResume(String resume)
	{
		this.resume = resume;
	}

	public String getTeach_place()
	{
		return teach_place;
	}

	public void setTeach_place(String teachPlace)
	{
		teach_place = teachPlace;
	}

	public String getFirst_subject()
	{
		return first_subject;
	}

	public void setFirst_subject(String firstSubject)
	{
		first_subject = firstSubject;
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
		// 如果没有teacherId，则重定向到登陆界面
		if(this.teacherId == 0)
		{
			return ERROR;
		}
		else if(this.teacherService.getSingleTeacher(this.teacherId).getIsLogin() != TeacherLogin.LOGIN)
		{
			return ERROR;
		}
		else
		{
			Teacher teacher = this.teacherService.getSingleTeacher(this.teacherId);
			
			teacher.setAppraiseSelf(new String(this.appraiseSelf.getBytes("iso-8859-1"), "utf-8"));
			teacher.setCertificate(new String(this.certificate.getBytes("iso-8859-1"), "utf-8"));
			teacher.setResume(new String(this.resume.getBytes("iso-8859-1"), "utf-8"));
			
			String teachPlace = new String(this.teach_place.getBytes("iso-8859-1"), "utf-8");
			String firstSubject = new String(this.first_subject.getBytes("iso-8859-1"), "utf-8");
			
			// 以,分隔符将数据划分开
			StringTokenizer teachPlace2 = new StringTokenizer(teachPlace, ",");
			StringTokenizer firstSubjet2 = new StringTokenizer(firstSubject, ",");
			
			List<String> teachPlaces = new ArrayList<String>();
			List<String> firstSubjets = new ArrayList<String>();
			
			// 循环得到的字符串，将各个String对象添加到list中
			while(teachPlace2.hasMoreTokens())
			{
				teachPlaces.add(teachPlace2.nextToken());
			}
			while(firstSubjet2.hasMoreTokens())
			{
				firstSubjets.add(firstSubjet2.nextToken());
			}
			
			// 一个teacher对应多个teacherCourse
			for(String course : firstSubjets)
			{
				TeacherCourse teacherCourse = new TeacherCourse();
				teacherCourse.setCourseName(course);
				
				teacher.getTeacherCourses().add(teacherCourse);
				teacherCourse.setTeacher(teacher);
			}
			
			String areas = " ";
			
			for(int i = 0; i < teachPlaces.size(); i++)
			{
				areas += teachPlaces.get(i) + "  ";
			}
			
			teacher.setTeachPlace(areas);
			
			// 新注册教员都是未审核通过状态
			teacher.setIsAudit(TeacherAudit.NOT_AUDIT);
			
			this.teacherService.updateTeacher(teacher);
			
			return SUCCESS;
		}
	}
}
