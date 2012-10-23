package com.xiaoluo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoluo.dao.ChannelDAO;
import com.xiaoluo.model.Channel;
import com.xiaoluo.model.VoteOption;
import com.xiaoluo.util.HibernateUtil;

public class ChannelDAOImpl implements ChannelDAO
{
	@Override
	public void saveChannel(Channel channel)
	{
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			session.save(channel);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Channel> getAllChannel()
	{
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		
		List<Channel> list = null;
		
		try
		{
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Channel");
			
			list = (List<Channel>)query.list();
			
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
			HibernateUtil.closeSession(session);
		}
		
		return list;
	}
	
	
	@Override
	public void deleteChannel(int id)
	{
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			Channel channel = (Channel)session.get(Channel.class, id);
			
			session.delete(channel);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
	
	@Override
	public Channel getSingleChannel(int id)
	{
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		
		Channel channel = null;
		
		try
		{
			tx = session.beginTransaction();
			
			channel = (Channel)session.get(Channel.class, id);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
		
		return channel;
	}
	
	@Override
	public void updateChannel(VoteOption voteOption)
	{
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			session.update(voteOption);
			
			tx.commit();
		}
		catch (Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
	
}
