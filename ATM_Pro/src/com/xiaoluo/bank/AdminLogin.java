package com.xiaoluo.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JTextField jTextField;
	
	private JPasswordField jPasswordField;
	
	private JButton jButton;

	public AdminLogin()
	{
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField = new JTextField(10);
		jPasswordField = new JPasswordField(10);
		jButton = new JButton();
		
		jPanel.setBorder(BorderFactory.createTitledBorder("管理员登陆界面"));
		jLabel1.setText("管理员");
		jLabel2.setText("密码");
		jButton.setText("登陆");
		jTextField.setText("admin");
		jPasswordField.setText("admin");
		
		/**
		 * 管理员账号密码默认为admin，输入正确则登陆成功
		 */
		jButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String username = AdminLogin.this.jTextField.getText();
				
				String password = new String(AdminLogin.this.jPasswordField.getPassword());
				
				if(!"admin".equals(username))
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "用户名输入不正确，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(!"admin".equals(password))
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "密码输入不正确，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					new AdminServer();
					
					AdminLogin.this.setVisible(false);
				}
			}
		});
		
		jPanel.add(jLabel1);
		jPanel.add(jTextField);
		jPanel.add(jLabel2);
		jPanel.add(jPasswordField);
		jPanel.add(jButton);
		
		this.add(jPanel);
		this.setTitle("银行后台管理系统");
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new AdminLogin();
	}
}
