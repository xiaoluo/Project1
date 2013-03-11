package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.bean.City;
import com.xiaoluo.bean.Course;
import com.xiaoluo.bean.Province;
import com.xiaoluo.bean.Teacher;
import com.xiaoluo.bean.Town;
import com.xiaoluo.bean.University;
import com.xiaoluo.service.CityService;
import com.xiaoluo.service.CourseService;
import com.xiaoluo.service.ProvinceService;
import com.xiaoluo.service.TeacherService;
import com.xiaoluo.service.TownService;
import com.xiaoluo.service.UniversityService;
import com.xiaoluo.util.TeacherLogin;

public class TeacherLoginAction2 extends ActionSupport
{
	private int teacherId;
	
	private String realName;
	private String gender;
	private String birthday;
	private String major;
	private String highSchool;
	private String identity;
	private String educationalLevel;
	private String idcard;
	private String mobile;
	private String telephone;
	private String qq;
	private String address;
	private String postCode;
	
	private int homePro;
	private int uniSchool;
	private int homeCity;
	private int cityPos;
	private int workPos;
	
	private TeacherService teacherService;
	private ProvinceService provinceService;
	private CityService cityService;
	private TownService townService;
	private UniversityService universityService;
	private CourseService courseService;
	
	public int getTeacherId()
	{
		return teacherId;
	}

	public void setTeacherId(int teacherId)
	{
		this.teacherId = teacherId;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getMajor()
	{
		return major;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getHighSchool()
	{
		return highSchool;
	}

	public void setHighSchool(String highSchool)
	{
		this.highSchool = highSchool;
	}

	public String getIdentity()
	{
		return identity;
	}

	public void setIdentity(String identity)
	{
		this.identity = identity;
	}

	public String getEducationalLevel()
	{
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel)
	{
		this.educationalLevel = educationalLevel;
	}

	public String getIdcard()
	{
		return idcard;
	}

	public void setIdcard(String idcard)
	{
		this.idcard = idcard;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPostCode()
	{
		return postCode;
	}

	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}

	public int getHomePro()
	{
		return homePro;
	}

	public void setHomePro(int homePro)
	{
		this.homePro = homePro;
	}

	public int getUniSchool()
	{
		return uniSchool;
	}

	public void setUniSchool(int uniSchool)
	{
		this.uniSchool = uniSchool;
	}

	public int getHomeCity()
	{
		return homeCity;
	}

	public void setHomeCity(int homeCity)
	{
		this.homeCity = homeCity;
	}

	public int getCityPos()
	{
		return cityPos;
	}

	public void setCityPos(int cityPos)
	{
		this.cityPos = cityPos;
	}

	public int getWorkPos()
	{
		return workPos;
	}

	public void setWorkPos(int workPos)
	{
		this.workPos = workPos;
	}

	public TeacherService getTeacherService()
	{
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService)
	{
		this.teacherService = teacherService;
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

	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
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
			Province province = this.provinceService.getSingleProvince(this.homePro);
			City city = this.cityService.getSingleCity(this.homeCity);
			Town cityPos = this.townService.getSingleTown(this.cityPos);
			Town workPos = this.townService.getSingleTown(this.workPos);
			University university = this.universityService.getSingleUniversity(this.uniSchool);
			Teacher teacher = this.teacherService.getSingleTeacher(this.teacherId);
			
			teacher.setRealName(new String(this.realName.getBytes("iso-8859-1"), "utf-8"));
			teacher.setGender(new String(this.gender.getBytes("iso-8859-1"), "utf-8"));
			teacher.setBirthday(this.birthday);
			teacher.setMajor(new String(this.major.getBytes("iso-8859-1"), "utf-8"));
			teacher.setHighSchool(new String(this.highSchool.getBytes("iso-8859-1"), "utf-8"));
			teacher.setIdentity(new String(this.identity.getBytes("iso-8859-1"), "utf-8"));
			teacher.setEducationalLevel(new String(this.educationalLevel.getBytes("iso-8859-1"), "utf-8"));
			teacher.setIdcard(this.idcard);
			teacher.setMobile(this.mobile);
			teacher.setTelephone(this.telephone);
			teacher.setQq(this.qq);
			teacher.setAddress(new String(this.address.getBytes("iso-8859-1"), "utf-8"));
			teacher.setPostCode(this.postCode);
			teacher.setRegisterDate(new java.sql.Date(new java.util.Date().getTime()));
			
			province.getTeachers().add(teacher);
			city.getTeachers().add(teacher);
			cityPos.getTeachersForCityPos().add(teacher);
			workPos.getTeachersForCityPos().add(teacher);
			university.getTeachers().add(teacher);
			
			teacher.setProvince(province);
			teacher.setCity(city);
			teacher.setTownByCityPos(cityPos);
			teacher.setTownByWorkPos(workPos);
			teacher.setUniversity(university);
			
			this.teacherService.updateTeacher(teacher);
			
			HttpServletRequest request = ServletActionContext.getRequest();
			
			// 得到该注册教员所在城市的所有town
			List<Town> towns = this.townService.getAllTown("from Town as t where t.city.id = " + this.homeCity);
			
			// 得到所有的课程
			List<Course> courses = this.courseService.getAllCourse("from Course");
			
			request.setAttribute("towns", towns);
			
			request.setAttribute("courses", courses);
			
			request.setAttribute("teacherId", this.teacherId);
			
			return SUCCESS;
		}
		
	}
}
