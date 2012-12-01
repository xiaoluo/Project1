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
import javax.swing.JTextField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.AttributeUtil;

public class UserLogin extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JTextField jTextField;
	
	private JPasswordField jPasswordField;
	
	private JButton jButton1;
	
	public JTextField getjTextField()
	{
		return jTextField;
	}

	public UserLogin()
	{
		this.init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField = new JTextField(20);
		jPasswordField = new JPasswordField(20);
		jButton1 = new JButton();
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ATM系统登录界面"));
		
		jLabel1.setText("卡号");
		jLabel2.setText("密码");
		
		jButton1.setText("登录");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String bankCard = UserLogin.this.jTextField.getText();
				String password = new String(UserLogin.this.jPasswordField.getPassword());
				
				if("".equals(bankCard) || "".equals(password))
				{
					JOptionPane.showMessageDialog(UserLogin.this, "卡号或密码不能为空，请输入卡号或密码！", "警告", JOptionPane.WARNING_MESSAGE);
					
					UserLogin.this.jTextField.requestFocus();
					
					return;
				}
				
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				/**
				 *   遍历数据库中所有的User对象，当卡号和密码都输入正确且当前银行卡状态时idle("空闲")状态时，用户登录成功
				 */
				for(User user : list)
				{
					if(bankCard.equals(user.getBankCard()) && password.equals(user.getPassword()) && AttributeUtil.IDLE.equals(user.getStatus()))
					{
						user.setStatus(AttributeUtil.BUSY);
						
						userDAO.updateUser(user);
						
						new ClientServer(UserLogin.this);
						
						UserLogin.this.setVisible(false);
						
						return;
					}
				}
				
				/**
				 *   当用户连续输错账号或密码三次，更新数据库中该银行卡账号的状态，将其状态修改为freeze("冻结"),此时用户需要携带身份证和银行卡去银行后台重置密码
				 */
				for(User user : list)
				{
					if(bankCard.equals(user.getBankCard()))
					{
						int passwordErrorCount = user.getUserAccount().getPasswordErrorCount();
						System.out.println(passwordErrorCount);
						
						if(passwordErrorCount > 2)
						{
							user.setStatus(AttributeUtil.FREEZE);
							userDAO.updateUser(user);
							
							JOptionPane.showMessageDialog(UserLogin.this, "您已经连续输错密码3次,账户已被冻结,请去银行后台重置您的密码", "错误", JOptionPane.ERROR_MESSAGE);
							
							System.exit(0);
						}
						
						user.getUserAccount().setPasswordErrorCount(passwordErrorCount + 1);
						
						userDAO.updateUser(user);
					}
				}
				JOptionPane.showMessageDialog(UserLogin.this, "登陆失败，可能的原因是卡号或密码错误或是账号已经在另一台ATM登陆，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		jPanel.add(jLabel1);
		jPanel.add(jTextField);
		jPanel.add(jLabel2);
		jPanel.add(jPasswordField);
		jPanel.add(jButton1);
		
		this.setTitle("ATM系统");
		this.add(jPanel);
		this.setLocation(400, 200);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new UserLogin();
	}
}
