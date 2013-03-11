package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.Authority;
import com.xiaoluo.dao.AuthorityDAO;
import com.xiaoluo.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService
{
	private AuthorityDAO authorityDAO;
	
	public AuthorityDAO getAuthorityDAO()
	{
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO)
	{
		this.authorityDAO = authorityDAO;
	}

	@Override
	public void saveAuthority(Authority authority)
	{
		authorityDAO.saveAuthority(authority);
	}
	
	@Override
	public List<Authority> getAllAuthority()
	{
		return authorityDAO.getAllAuthority();
	}
	
	@Override
	public void deleteAuthority(int id)
	{
		authorityDAO.deleteAuthority(id);
	}
	
	@Override
	public Authority getSingleAuthority(int id)
	{
		return authorityDAO.getSingleAuthority(id);
	}
	
	@Override
	public void updateAuthority(Authority authority)
	{
		authorityDAO.updateAuthority(authority);
	}
}
