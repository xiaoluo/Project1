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
import com.xiaoluo.bean.UserAccount;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.AttributeUtil;

public class DepositeMoney extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel;
	
	private JTextField jTextField;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private UserLogin userLogin;
	
	public DepositeMoney(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel = new JLabel("����������");
		jTextField = new JTextField(10);
		jButton1 = new JButton("ȷ��");
		jButton2 = new JButton("����");
		
		/**
		 *  �������ݿ��������û����õ���ǰ��¼���û������Ȳ�ѯ�����˻�����Ȼ������û�����Ľ����¸��˻�����ͬʱ����һ�����׼�¼
		 */
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserDAO userDAO = new UserDAOImpl();
				
				String bankCard = DepositeMoney.this.userLogin.getjTextField().getText();
				
				List<User> list = userDAO.getAllUser();
				
				for(User user : list)
				{
					if(bankCard.equals(user.getBankCard()))
					{
						UserAccount userAccount = user.getUserAccount();
						
						HistoryTrade historyTrade = new HistoryTrade();
						
						String sum = DepositeMoney.this.jTextField.getText();
						String oldSum = userAccount.getRemaning();
						
						String newSum = Double.parseDouble(sum) + Double.parseDouble(oldSum) + "";
						
						historyTrade.setBankCard(bankCard);
						historyTrade.setOperation(AttributeUtil.DEPOSIT);
						historyTrade.setTradeSum(sum);
						historyTrade.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						historyTrade.setUserAccount(userAccount);
						
						userAccount.getHistoryTrades().add(historyTrade);
						
						userAccount.setRemaning(newSum);
						
						userAccount.setUser(user);
						
						user.setUserAccount(userAccount);
						
						userDAO.updateUser(user);
					}
				}
				
				JOptionPane.showMessageDialog(DepositeMoney.this, "���ɹ�!", "��ϲ", JOptionPane.YES_OPTION);
				
				new ClientServer(userLogin);
				
				DepositeMoney.this.setVisible(false);
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ClientServer(DepositeMoney.this.userLogin);
				
				DepositeMoney.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("������"));
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
