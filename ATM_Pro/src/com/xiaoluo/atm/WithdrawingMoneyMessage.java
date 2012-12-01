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

import com.xiaoluo.bean.HistoryTrade;
import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.AttributeUtil;

public class WithdrawingMoneyMessage extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel;
	
	private JTextField jTextField;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private UserLogin userLogin;
	
	private String money;
	
	public WithdrawingMoneyMessage(UserLogin userLogin, String money)
	{
		this.userLogin = userLogin;
		
		this.money = money;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel = new JLabel("��Ҫȡ����Ϊ");
		jTextField = new JTextField(15);
		jButton1 = new JButton("ȷ��");
		jButton2 = new JButton("�޸�ȡ����");
		
		jTextField.setText(WithdrawingMoneyMessage.this.money);
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				String bankCard = WithdrawingMoneyMessage.this.userLogin.getjTextField().getText();
				
				for(User user : list)
				{
					if(bankCard.equals(user.getBankCard()))
					{
						//�˻����
						String remaning = user.getUserAccount().getRemaning();
						
						//ȡ��׼�¼
						HistoryTrade historyTrade = new HistoryTrade();
						
						//�˻�����Ϊ�����˻�
						if(AttributeUtil.FIXED.equals(user.getAccountType()))
						{
							//������С��ȡ�����ʾ���㣬ȡ�����ȡ��
							if(Double.parseDouble(remaning) < Double.parseDouble(WithdrawingMoneyMessage.this.money))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "�������㣬ȡ�����ȡ����", "����", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//�������ȥȡ�����ʣ����С�� 10Ԫ�����ѣ���ʾ���㣬ת�˷���ȡ��
							else if((Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) < 10)
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "����������֧��ת�˺�������ѣ�ת�˷���ȡ����", "����", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//�����˻�ÿ��ȡ������۳������� 10Ԫ
							else
							{
								String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money) - 10) + "";
								
								user.getUserAccount().setRemaning(newRemaning);
								
								userDAO.updateUser(user);
							}
						}
						
						//�˻�����Ϊ�����˻�
						else if(AttributeUtil.CURRENT.equals(user.getAccountType()))
						{
							//������С��ȡ�����ʾ���㣬ȡ�����ȡ��
							if(Double.parseDouble(remaning) < Double.parseDouble(WithdrawingMoneyMessage.this.money))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "�������㣬ȡ�����ȡ����", "����", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//������˻�����ȡ���������5��
							else if(user.getUserAccount().getWithdrawingMoneyCount() > 5)
							{
								//�������ȥȡ�����ʣ����С�� 2Ԫ�����ѣ���ʾ���㣬ת�˷���ȡ��
								if((Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) < 2)
								{
									JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "����������֧��ת�˺�������ѣ�ת�˷���ȡ����", "����", JOptionPane.WARNING_MESSAGE);
									
									return;
								}
								else
								{
									String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money) - 2) + "";
									
									user.getUserAccount().setRemaning(newRemaning);
									
									userDAO.updateUser(user);
								}
							}
							
							//������˻�����ȡ�����   <= 5 ��
							else
							{
								String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) + "";
								
								user.getUserAccount().setRemaning(newRemaning);
								
								//�Ȳ�ѯ�������Ѿ�ȡ�������Ȼ���ټ�1
								user.getUserAccount().setWithdrawingMoneyCount(user.getUserAccount().getWithdrawingMoneyCount() + 1);
								
								userDAO.updateUser(user);
							}
						}
						
						//�˻�����Ϊ���ÿ��˻�
						else
						{
							String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) + "";
							
							//���ÿ�ֻ��͸֧2000Ԫ���������2000����ʾ������Ϣ
							if(Double.parseDouble(newRemaning) < (-2000))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "�����ÿ�ֻ��͸֧2000Ԫ������������ȡ���", "����", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							user.getUserAccount().setRemaning(newRemaning);
							
							userDAO.updateUser(user);
						}
						
						historyTrade.setBankCard(bankCard);
						historyTrade.setOperation(AttributeUtil.WITHDRAWING);
						historyTrade.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						historyTrade.setTradeSum(WithdrawingMoneyMessage.this.money);
						historyTrade.setUserAccount(user.getUserAccount());
						
						user.getUserAccount().getHistoryTrades().add(historyTrade);
						
						userDAO.updateUser(user);
						
						JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "ȡ��ɹ�!", "��ϲ", JOptionPane.YES_OPTION);
						
						new ClientServer(WithdrawingMoneyMessage.this.userLogin);
						
						WithdrawingMoneyMessage.this.setVisible(false);
					}
				}
				
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new WithdrawingMoney(WithdrawingMoneyMessage.this.userLogin);
				
				WithdrawingMoneyMessage.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("ȡ����Ϣ����"));
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.jTextField.setEditable(false);
		this.add(jPanel);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
