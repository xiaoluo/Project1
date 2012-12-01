package com.xiaoluo.bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminServer extends JFrame
{
	private JPanel jPanel;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private JButton jButton3;
	
	private JButton jButton4;
	
	private JButton jButton5;
	
	private JButton jButton6;
	
	public AdminServer()
	{
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jButton1 = new JButton("查看所有账户信息");
		jButton2 = new JButton("注销账户");
		jButton3 = new JButton("修改账户信息");
		jButton4 = new JButton("开户");
		jButton5 = new JButton("查看所有历史交易");
		jButton6 = new JButton("退出");
		
		// 跳转到查看所有账户信息界面
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectAllUser();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// 跳转到注销账号界面
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CancelUser();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// 跳转到修改账户信息界面
		jButton3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AlterUserMessage();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// 跳转到开户界面
		jButton4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreateCard();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// 跳转到查询所有账户历史交易记录界面
		jButton5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectAllHistoryTrade();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// 系统推出界面
		jButton6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("服务界面"));
		
		jPanel.setLayout(new GridLayout(0, 2));
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		jPanel.add(jButton4);
		jPanel.add(jButton5);
		jPanel.add(jButton6);
		
		this.add(jPanel);
		this.setLocation(400, 200);
		this.setTitle("银行后台管理系统");
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
