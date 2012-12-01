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
import javax.swing.JTextField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.ATMUtil;

public class TransferMoney extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JTextField jTextField1;
	
	private JTextField jTextField2;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private UserLogin userLogin;
	
	//��ת��������
	private String username;
	
	//��ת����id
	private int afterId;
	
	public JTextField getjTextField1()
	{
		return jTextField1;
	}

	public JTextField getjTextField2()
	{
		return jTextField2;
	}

	public String getUsername()
	{
		return username;
	}

	public int getAfterId()
	{
		return afterId;
	}

	public TransferMoney(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("������ת�˿���");
		jLabel2 = new JLabel("������ת�˽��");
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jButton1 = new JButton("ת��");
		jButton2 = new JButton("����");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String bankCard = TransferMoney.this.jTextField1.getText();
				
				String money = TransferMoney.this.jTextField2.getText();
				
				if(bankCard.length() != 19 || !ATMUtil.isNumber(bankCard))
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "������Ϸ������п�����", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if(money.length() ==0 || !ATMUtil.isNumber(money))
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "������Ϸ����", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if(Integer.parseInt(money) > 10000)
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "��ÿ�����ֻ��ת��1W��������С��1W�Ľ��", "����", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					UserDAO userDAO = new UserDAOImpl();
					
					List<User> list = userDAO.getAllUser();
					
					//�õ���ת���ߵ������Լ����п���,����ʾת�˽��
					for(User user : list)
					{
						if(bankCard.equals(user.getBankCard()))
						{
							TransferMoney.this.username = user.getName();
							
							TransferMoney.this.afterId = user.getId();
							
							new TransferMessage(TransferMoney.this.userLogin, TransferMoney.this);
							
							TransferMoney.this.setVisible(false);
							
							return;
						}
					}
					
					JOptionPane.showMessageDialog(TransferMoney.this, "������Ŀ��Ų����ڣ�����������", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ClientServer(TransferMoney.this.userLogin);
				
				TransferMoney.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ת��ҳ��"));
		jPanel.add(jLabel1);
		jPanel.add(jTextField1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField2);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
