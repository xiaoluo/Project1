package com.xiaoluo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xiaoluo.bean.Province;
import com.xiaoluo.bean.StudentOrder;

public class Test
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		tx.begin();
		
		List<StudentOrder> list = session.createQuery("from StudentOrder").list();
		
		for(StudentOrder order : list)
		{
			System.out.println(order.getSubjectName());
		}
		
		tx.commit();
		
		session.close();
	}
}
