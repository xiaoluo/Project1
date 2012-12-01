package com.xiaoluo.atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.ATMUtil;

public class AlterPassword extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JLabel jLabel3;
	
	private JPasswordField jPasswordField1;
	
	private JPasswordField jPasswordField2;
	
	private JPasswordField jPasswordField3;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private UserLogin userLogin;
	
	public AlterPassword(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("������ԭ����");
		jLabel2 = new JLabel("������������");
		jLabel3 = new JLabel("���ٴ���������");
		jPasswordField1 = new JPasswordField(15);
		jPasswordField2 = new JPasswordField(15);
		jPasswordField3 = new JPasswordField(15);
		jButton1 = new JButton("ȷ��");
		jButton2 = new JButton("����");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				String bankCard = AlterPassword.this.userLogin.getjTextField().getText();
				
				String oldPassword = new String(AlterPassword.this.jPasswordField1.getPassword());
				
				String newPassword = new String(AlterPassword.this.jPasswordField2.getPassword());
				
				String newRePassword = new String(AlterPassword.this.jPasswordField3.getPassword());
				
				for(User user : list)
				{
					if(bankCard.equals(user.getBankCard()))
					{
						String password = user.getPassword();
						
						if(!oldPassword.equals(password))
						{
							JOptionPane.showMessageDialog(AlterPassword.this, "�������ԭ���벻��ȷ�����������룡", "����", JOptionPane.ERROR_MESSAGE);
						}
						else if(newPassword.length() != 6 || !ATMUtil.isNumber(newPassword))
						{
							JOptionPane.showMessageDialog(AlterPassword.this, "������������벻�Ϸ������������룡", "����", JOptionPane.ERROR_MESSAGE);
						}
						else if(!newPassword.equals(newRePassword))
						{
							JOptionPane.showMessageDialog(AlterPassword.this, "�������������벻��ͬ�����������룡", "����", JOptionPane.ERROR_MESSAGE);
						}
						else 
						{
							user.setPassword(newPassword);
							
							userDAO.updateUser(user);
							
							JOptionPane.showMessageDialog(AlterPassword.this, "�����޸ĳɹ�", "��ϲ", JOptionPane.YES_OPTION);
							
							new ClientServer(AlterPassword.this.userLogin);
							
							AlterPassword.this.setVisible(false);
						}
					}
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ClientServer(AlterPassword.this.userLogin);
				
				AlterPassword.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("�޸��������"));
		jPanel.add(jLabel1);
		jPanel.add(jPasswordField1);
		jPanel.add(jLabel2);
		jPanel.add(jPasswordField2);
		jPanel.add(jLabel3);
		jPanel.add(jPasswordField3);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
