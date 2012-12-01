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
import javax.swing.JPasswordField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.ATMUtil;
import com.xiaoluo.util.AttributeUtil;

public class ResetPassword extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JLabel jLabel3;
	
	private JPasswordField jPasswordField1;
	
	private JPasswordField jPasswordField2;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private AlterUserMessage alterUserMessage;
	
	public ResetPassword(AlterUserMessage alterUserMessage)
	{
		this.alterUserMessage = alterUserMessage;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("请在下面重置您的银行卡密码！", JLabel.CENTER);
		jLabel1.setForeground(Color.BLUE);
		jLabel2 = new JLabel("请输入新密码    ");
		jLabel3 = new JLabel("请再次输入密码");
		jPasswordField1 = new JPasswordField(15);
		jPasswordField2 = new JPasswordField(15);
		jButton1 = new JButton("确认");
		jButton2 = new JButton("返回");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String newPassword = new String(ResetPassword.this.jPasswordField1.getPassword());
				String newRePassword = new String(ResetPassword.this.jPasswordField2.getPassword());
				
				if(newPassword.length() != 6 || !ATMUtil.isNumber(newPassword))
				{
					JOptionPane.showMessageDialog(ResetPassword.this, "您输入的新密码不合法，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(!newPassword.equals(newRePassword))
				{
					JOptionPane.showMessageDialog(ResetPassword.this, "您两次输入密码不相同，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					UserDAO userDAO = new UserDAOImpl();
					
					List<User> list = userDAO.getAllUser();
					
					String bankCard = ResetPassword.this.alterUserMessage.getjTextField2().getText();
					
					/*
					 * 在用户输入新的银行卡账号密码后，数据库更新新的密码，并将该银行卡状态由freeze修改为idle
					 */
					for(User user : list)
					{
						if(bankCard.equals(user.getBankCard()))
						{
							user.setPassword(newPassword);
							user.setStatus(AttributeUtil.IDLE);
							user.getUserAccount().setPasswordErrorCount(0);
							
							userDAO.updateUser(user);
							
							JOptionPane.showMessageDialog(ResetPassword.this, "密码重置成功！", "成功", JOptionPane.OK_OPTION);
							
							new AdminServer();
							
							ResetPassword.this.setVisible(false);
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
				new AlterUserMessage();
				
				ResetPassword.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("重置密码界面"));
		jPanel.add(jLabel1);
		jPanel.add(jLabel2);
		jPanel.add(jPasswordField1);
		jPanel.add(jLabel3);
		jPanel.add(jPasswordField2);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("银行后台管理系统");
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setLocation(400, 200);
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
