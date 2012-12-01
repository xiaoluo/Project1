package com.xiaoluo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.util.HibernateUtil;

public class UserDAOImpl implements UserDAO
{
	@Override
	public void saveUser(User user)
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.close(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser()
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		List<User> list = null;
		try
		{
			tx = session.beginTransaction();
			
			list = session.createQuery("from User").list();
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.close(session);
		}
		
		return list;
	}
	
	@Override
	public void updateUser(User user)
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			session.update(user);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.close(session);
		}
	}
	
	@Override
	public User getSingleUser(int id)
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		User user = null;
		try
		{
			tx = session.beginTransaction();
			
			user = (User)session.get(User.class, id);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.close(session);
		}
		
		return user;
	}
	
	@Override
	public void deleteUser(int id)
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			User user = (User) session.get(User.class, id);
			
			session.delete(user);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.close(session);
		}		
	}
	
}
