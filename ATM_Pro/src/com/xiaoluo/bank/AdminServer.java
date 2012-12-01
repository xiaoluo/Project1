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
		jButton1 = new JButton("�鿴�����˻���Ϣ");
		jButton2 = new JButton("ע���˻�");
		jButton3 = new JButton("�޸��˻���Ϣ");
		jButton4 = new JButton("����");
		jButton5 = new JButton("�鿴������ʷ����");
		jButton6 = new JButton("�˳�");
		
		// ��ת���鿴�����˻���Ϣ����
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectAllUser();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// ��ת��ע���˺Ž���
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CancelUser();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// ��ת���޸��˻���Ϣ����
		jButton3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AlterUserMessage();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// ��ת����������
		jButton4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreateCard();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// ��ת����ѯ�����˻���ʷ���׼�¼����
		jButton5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new SelectAllHistoryTrade();
				
				AdminServer.this.setVisible(false);
			}
		});
		
		// ϵͳ�Ƴ�����
		jButton6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("�������"));
		
		jPanel.setLayout(new GridLayout(0, 2));
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		jPanel.add(jButton4);
		jPanel.add(jButton5);
		jPanel.add(jButton6);
		
		this.add(jPanel);
		this.setLocation(400, 200);
		this.setTitle("���к�̨����ϵͳ");
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
