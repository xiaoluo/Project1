package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.City;
import com.xiaoluo.bean.Province;
import com.xiaoluo.bean.Teacher;
import com.xiaoluo.bean.Town;
import com.xiaoluo.bean.University;
import com.xiaoluo.service.CityService;
import com.xiaoluo.service.ProvinceService;
import com.xiaoluo.service.TeacherService;
import com.xiaoluo.service.TownService;
import com.xiaoluo.service.UniversityService;
import com.xiaoluo.util.TeacherLogin;
import com.xiaoluo.util.TeacherType;

public class TeacherLoginAction extends ActionSupport
{
	private String username;
	private String password;
	private String email;
	private ProvinceService provinceService;
	private CityService cityService;
	private TownService townService;
	private UniversityService universityService;
	private TeacherService teacherService;
	
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public ProvinceService getProvinceService()
	{
		return provinceService;
	}

	public void setProvinceService(ProvinceService provinceService)
	{
		this.provinceService = provinceService;
	}

	public CityService getCityService()
	{
		return cityService;
	}

	public void setCityService(CityService cityService)
	{
		this.cityService = cityService;
	}

	public TownService getTownService()
	{
		return townService;
	}

	public void setTownService(TownService townService)
	{
		this.townService = townService;
	}

	public UniversityService getUniversityService()
	{
		return universityService;
	}

	public void setUniversityService(UniversityService universityService)
	{
		this.universityService = universityService;
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
		Teacher teacher = new Teacher();
		teacher.setUsername(this.username);
		teacher.setPassword(this.password);
		teacher.setEmail(this.email);
		teacher.setTeacherType(TeacherType.STUDENT_TYPE);
		teacher.setIsLogin(TeacherLogin.LOGIN);
		
		this.teacherService.saveTeacher(teacher);
		
		List<Province> provinces = this.provinceService.getAllProvince("from Province");
		List<City> cities = this.cityService.getAllCity("from City as c where c.province.id = 18");
		List<Town> towns = this.townService.getAllTown("from Town as t where t.city.id = 272");
		List<University> universities = this.universityService.getAllUniversity("from University as u where u.province.id = 18");
		
		int teacherId = teacher.getId();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("provinces", provinces);
		request.setAttribute("cities", cities);
		request.setAttribute("towns", towns);
		request.setAttribute("universities", universities);
		request.setAttribute("teacherId", teacherId);
		
		request.getSession().setAttribute("teacherName", this.username);
		request.getSession().setAttribute("email", this.email);
		request.getSession().setAttribute("teacherId", teacherId);
		
		return SUCCESS;
	}
}
