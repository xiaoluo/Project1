package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.Authority;

public interface AuthorityDAO
{
	public void saveAuthority(Authority anthority);
	
	public List<Authority> getAllAuthority();
	
	public Authority getSingleAuthority(int id);
	
	public void deleteAuthority(int id);
	
	public void updateAuthority(Authority authority);
}
