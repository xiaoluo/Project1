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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ATMϵͳ��¼����"));
		
		jLabel1.setText("����");
		jLabel2.setText("����");
		
		jButton1.setText("��¼");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String bankCard = UserLogin.this.jTextField.getText();
				String password = new String(UserLogin.this.jPasswordField.getPassword());
				
				if("".equals(bankCard) || "".equals(password))
				{
					JOptionPane.showMessageDialog(UserLogin.this, "���Ż����벻��Ϊ�գ������뿨�Ż����룡", "����", JOptionPane.WARNING_MESSAGE);
					
					UserLogin.this.jTextField.requestFocus();
					
					return;
				}
				
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				/**
				 *   �������ݿ������е�User���󣬵����ź����붼������ȷ�ҵ�ǰ���п�״̬ʱidle("����")״̬ʱ���û���¼�ɹ�
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
				 *   ���û���������˺Ż��������Σ��������ݿ��и����п��˺ŵ�״̬������״̬�޸�Ϊfreeze("����"),��ʱ�û���ҪЯ�����֤�����п�ȥ���к�̨��������
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
							
							JOptionPane.showMessageDialog(UserLogin.this, "���Ѿ������������3��,�˻��ѱ�����,��ȥ���к�̨������������", "����", JOptionPane.ERROR_MESSAGE);
							
							System.exit(0);
						}
						
						user.getUserAccount().setPasswordErrorCount(passwordErrorCount + 1);
						
						userDAO.updateUser(user);
					}
				}
				JOptionPane.showMessageDialog(UserLogin.this, "��½ʧ�ܣ����ܵ�ԭ���ǿ��Ż������������˺��Ѿ�����һ̨ATM��½�����������룡", "����", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		jPanel.add(jLabel1);
		jPanel.add(jTextField);
		jPanel.add(jLabel2);
		jPanel.add(jPasswordField);
		jPanel.add(jButton1);
		
		this.setTitle("ATMϵͳ");
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
