package com.xiaoluo.atm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.AttributeUtil;

public class ClientServer extends JFrame
{
	private JPanel jPanel;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private JButton jButton3;
	
	private JButton jButton4;
	
	private JButton jButton5;
	
	private JButton jButton6;
	
	private JButton jButton7;
	
	private UserLogin userLogin;
	
	public ClientServer(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jButton1 = new JButton("���");
		jButton2 = new JButton("ȡ��");
		jButton3 = new JButton("��ѯ���");
		jButton4 = new JButton("ת��");
		jButton5 = new JButton("�޸�����");
		jButton6 = new JButton("�鿴��ʷ����");
		jButton7 = new JButton("�˿�");
		
		/*
		 * ��ת��������
		 */
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new DepositeMoney(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 * ��ת��ȡ�����
		 */
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new WithdrawingMoney(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 * ��ת����ѯ������ 
		 */
		jButton3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectRemaning(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 * ��ת��ת�˽��� 
		 */
		jButton4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new TransferMoney(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 *  ��ת���޸��������
		 */
		jButton5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AlterPassword(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 * ��ת����ѯ��ʷ���׽���
		 */
		jButton6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectHistoryTrade(ClientServer.this.userLogin);
				
				ClientServer.this.setVisible(false);
			}
		});
		
		/*
		 *  �˳�ATMϵͳ�����û��˳�ʱ�������п��˺ŵ�״̬����Ϊidle״̬
		 */
		jButton7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				for(User user : list)
				{
					if(AttributeUtil.BUSY.equals(user.getStatus()))
					{
						user.setStatus(AttributeUtil.IDLE);
						
						userDAO.updateUser(user);
					}
				}
				
				new UserLogin();
				
				ClientServer.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ATM�������"));
		jPanel.setLayout(new GridLayout(0, 2, 50, 30));
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		jPanel.add(jButton4);
		jPanel.add(jButton5);
		jPanel.add(jButton6);
		jPanel.add(jButton7);
		
		this.setTitle("ATMϵͳ");
		this.add(jPanel);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
