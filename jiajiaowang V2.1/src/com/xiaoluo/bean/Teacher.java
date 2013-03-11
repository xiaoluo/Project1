package com.xiaoluo.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements java.io.Serializable
{
	private Integer id;
	private University university;
	private Town townByWorkPos;
	private Province province;
	private City city;
	private Town townByCityPos;
	private String username;
	private String password;
	private String email;
	private Integer teacherType;
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
	private Integer isAudit;
	private Date registerDate;
	private String certificate;
	private String appraiseSelf;
	private String teachPlace;
	private String resume;
	private Integer isLogin;
	private Set<TeacherCourse> teacherCourses = new HashSet<TeacherCourse>(0);
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public University getUniversity()
	{
		return university;
	}
	public void setUniversity(University university)
	{
		this.university = university;
	}
	public Town getTownByWorkPos()
	{
		return townByWorkPos;
	}
	public void setTownByWorkPos(Town townByWorkPos)
	{
		this.townByWorkPos = townByWorkPos;
	}
	public Province getProvince()
	{
		return province;
	}
	public void setProvince(Province province)
	{
		this.province = province;
	}
	public City getCity()
	{
		return city;
	}
	public void setCity(City city)
	{
		this.city = city;
	}
	public Town getTownByCityPos()
	{
		return townByCityPos;
	}
	public void setTownByCityPos(Town townByCityPos)
	{
		this.townByCityPos = townByCityPos;
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
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Integer getTeacherType()
	{
		return teacherType;
	}
	public void setTeacherType(Integer teacherType)
	{
		this.teacherType = teacherType;
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
	public Integer getIsAudit()
	{
		return isAudit;
	}
	public void setIsAudit(Integer isAudit)
	{
		this.isAudit = isAudit;
	}
	public Date getRegisterDate()
	{
		return registerDate;
	}
	public void setRegisterDate(Date registerDate)
	{
		this.registerDate = registerDate;
	}
	public String getCertificate()
	{
		return certificate;
	}
	public void setCertificate(String certificate)
	{
		this.certificate = certificate;
	}
	public String getAppraiseSelf()
	{
		return appraiseSelf;
	}
	public void setAppraiseSelf(String appraiseSelf)
	{
		this.appraiseSelf = appraiseSelf;
	}
	public String getTeachPlace()
	{
		return teachPlace;
	}
	public void setTeachPlace(String teachPlace)
	{
		this.teachPlace = teachPlace;
	}
	public String getResume()
	{
		return resume;
	}
	public void setResume(String resume)
	{
		this.resume = resume;
	}
	
	public Integer getIsLogin()
	{
		return isLogin;
	}
	public void setIsLogin(Integer isLogin)
	{
		this.isLogin = isLogin;
	}
	public Set<TeacherCourse> getTeacherCourses()
	{
		return teacherCourses;
	}
	public void setTeacherCourses(Set<TeacherCourse> teacherCourses)
	{
		this.teacherCourses = teacherCourses;
	}
	
}