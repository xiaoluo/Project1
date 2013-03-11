package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Province;

public interface ProvinceDAO
{
	public List<Province> getAllProvice(String hql);
	
	public Province getSingleProvince(int id);
}
