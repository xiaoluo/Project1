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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("����Ա��½����"));
		jLabel1.setText("����Ա");
		jLabel2.setText("����");
		jButton.setText("��½");
		jTextField.setText("admin");
		jPasswordField.setText("admin");
		
		/**
		 * ����Ա�˺�����Ĭ��Ϊadmin��������ȷ���½�ɹ�
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
					JOptionPane.showMessageDialog(AdminLogin.this, "�û������벻��ȷ������������", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if(!"admin".equals(password))
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "�������벻��ȷ������������", "����", JOptionPane.ERROR_MESSAGE);
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
		this.setTitle("���к�̨����ϵͳ");
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
