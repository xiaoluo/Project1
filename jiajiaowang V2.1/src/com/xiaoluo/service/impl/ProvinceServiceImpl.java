package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Province;
import com.xiaoluo.dao.ProvinceDAO;
import com.xiaoluo.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService
{
	private ProvinceDAO provinceDAO;
	
	public ProvinceDAO getProvinceDAO()
	{
		return provinceDAO;
	}

	public void setProvinceDAO(ProvinceDAO provinceDAO)
	{
		this.provinceDAO = provinceDAO;
	}

	public List<Province> getAllProvince(String hql)
	{
		return this.provinceDAO.getAllProvice(hql);
	}
	
	public Province getSingleProvince(int id)
	{
		return this.provinceDAO.getSingleProvince(id);
	}

}
