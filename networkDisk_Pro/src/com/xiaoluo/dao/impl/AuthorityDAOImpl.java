package com.xiaoluo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaoluo.bean.Authority;
import com.xiaoluo.dao.AuthorityDAO;

public class AuthorityDAOImpl extends HibernateDaoSupport implements AuthorityDAO
{
	@Override
	public void saveAuthority(Authority authority)
	{
		this.getHibernateTemplate().save(authority);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> getAllAuthority()
	{
		List<Authority> list = this.getHibernateTemplate().find("from Authority");
		
		return list;
	}
	
	@Override
	public void deleteAuthority(int id)
	{
		Authority authority = this.getHibernateTemplate().get(Authority.class, id);
		
		this.getHibernateTemplate().delete(authority);
	}
	
	@Override
	public Authority getSingleAuthority(int id)
	{
		return this.getHibernateTemplate().get(Authority.class, id);
	}
	
}
