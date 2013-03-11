package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.Province;

public interface ProvinceService
{
	public List<Province> getAllProvince(String hql);
	
	public Province getSingleProvince(int id);
}
