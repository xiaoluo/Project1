package com.xiaoluo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoluo.bean.HistoryTrade;
import com.xiaoluo.dao.HistoryTradeDAO;
import com.xiaoluo.util.HibernateUtil;

public class HistoryTradeDAOImpl implements HistoryTradeDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryTrade> getAllHistoryTrade()
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		List<HistoryTrade> list = null;
		try
		{
			tx = session.beginTransaction();
			
			list = session.createQuery("from HistoryTrade").list();
			
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

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryTrade> getSpecialHistoryTrade(String bankCard)
	{
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		
		List<HistoryTrade> list = null;
		try
		{
			tx = session.beginTransaction();
			
			list = session.createQuery("from HistoryTrade as h where h.bankCard = " + bankCard).list();
			
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
}
