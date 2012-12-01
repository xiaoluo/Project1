package com.xiaoluo.bank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;

public class AlterUserMessage extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JLabel jLabel3;
	
	private JTextField jTextField1;
	
	private JTextField jTextField2;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	public JTextField getjTextField2()
	{
		return jTextField2;
	}

	public AlterUserMessage()
	{
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("�������������֤�źͿ��ţ��������������п�����!", JLabel.CENTER);
		jLabel1.setForeground(Color.BLUE);
		jLabel2 = new JLabel("���֤��");
		jLabel3 = new JLabel("���п���");
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jButton1 = new JButton("ȷ��");
		jButton2 = new JButton("����");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String identityCard = AlterUserMessage.this.jTextField1.getText();
				String bankCard = AlterUserMessage.this.jTextField2.getText();
				
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				/*
				 * ���û��������֤�ź����п��˺���Ϣ����ȷ����ת�������������
				 */
				for(User user : list)
				{
					if(identityCard.equals(user.getIdentityCard()) && bankCard.equals(user.getBankCard()))
					{
						new ResetPassword(AlterUserMessage.this);
						
						AlterUserMessage.this.setVisible(false);
						
						return;
					}
				}
				
				JOptionPane.showMessageDialog(AlterUserMessage.this, "����������֤�Ż򿨺��������������룡", "����", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AdminServer();
				
				AlterUserMessage.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("�˻���Ϣ�������"));
		jPanel.add(jLabel1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField1);
		jPanel.add(jLabel3);
		jPanel.add(jTextField2);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("���к�̨����ϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
