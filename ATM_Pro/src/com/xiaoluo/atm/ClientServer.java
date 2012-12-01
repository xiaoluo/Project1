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
		jButton1 = new JButton("存款");
		jButton2 = new JButton("取款");
		jButton3 = new JButton("查询余额");
		jButton4 = new JButton("转账");
		jButton5 = new JButton("修改密码");
		jButton6 = new JButton("查看历史交易");
		jButton7 = new JButton("退卡");
		
		/*
		 * 跳转到存款界面
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
		 * 跳转到取款界面
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
		 * 跳转到查询余额界面 
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
		 * 跳转到转账界面 
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
		 *  跳转到修改密码界面
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
		 * 跳转到查询历史交易界面
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
		 *  退出ATM系统，当用户退出时将该银行卡账号的状态更新为idle状态
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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ATM服务界面"));
		jPanel.setLayout(new GridLayout(0, 2, 50, 30));
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		jPanel.add(jButton4);
		jPanel.add(jButton5);
		jPanel.add(jButton6);
		jPanel.add(jButton7);
		
		this.setTitle("ATM系统");
		this.add(jPanel);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
