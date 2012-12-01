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

public class CancelUser extends JFrame
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

	public CancelUser()
	{
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("请输入您的身份证号和卡号，来注销您的该账户!", JLabel.CENTER);
		jLabel1.setForeground(Color.BLUE);
		jLabel2 = new JLabel("身份证号");
		jLabel3 = new JLabel("银行卡号");
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jButton1 = new JButton("确认");
		jButton2 = new JButton("返回");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String identityCard = CancelUser.this.jTextField1.getText();
				String bankCard = CancelUser.this.jTextField2.getText();
				
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				/*
				 * 当用户输入身份证和银行卡号信息都正确后，提示用户是否注销该账户
				 */
				for(User user : list)
				{
					if(identityCard.equals(user.getIdentityCard()) && bankCard.equals(user.getBankCard()))
					{
						//如果选择确定注销该账户，该账户信息从数据库中删除
						if(JOptionPane.showConfirmDialog(CancelUser.this, "您确定要注销该账户吗？", "注销", JOptionPane.OK_CANCEL_OPTION) == 0)
						{
							userDAO.deleteUser(user.getId());
							
							JOptionPane.showMessageDialog(CancelUser.this, "账户注销成功！", "成功", JOptionPane.OK_OPTION);
							
							new AdminServer();
							
							CancelUser.this.setVisible(false);
							
							return;
						}
						//点击取消，账户不会被注销
						else
						{
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(CancelUser.this, "您输入的身份证号或卡号有误，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AdminServer();
				
				CancelUser.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("账户注销界面"));
		jPanel.add(jLabel1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField1);
		jPanel.add(jLabel3);
		jPanel.add(jTextField2);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("银行后台管理系统");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}