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
		jLabel = new JLabel("请输入存款金额");
		jTextField = new JTextField(10);
		jButton1 = new JButton("确定");
		jButton2 = new JButton("返回");
		
		/**
		 *  遍历数据库中所有用户，得到当前登录的用户。首先查询出该账户的余额，然后根据用户输入的金额，更新该账户的余额，同时增加一条存款交易记录
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
				
				JOptionPane.showMessageDialog(DepositeMoney.this, "存款成功!", "恭喜", JOptionPane.YES_OPTION);
				
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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("存款界面"));
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("ATM系统");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
