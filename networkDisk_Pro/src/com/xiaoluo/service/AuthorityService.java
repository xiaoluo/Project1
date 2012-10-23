package com.xiaoluo.service;

import java.util.List;

import com.xiaoluo.bean.Authority;

public interface AuthorityService
{
	public void saveAuthority(Authority authority);
	
	public List<Authority> getAllAuthority();
	
	public Authority getSingleAuthority(int id);
	
	public void deleteAuthority(int id);
}
