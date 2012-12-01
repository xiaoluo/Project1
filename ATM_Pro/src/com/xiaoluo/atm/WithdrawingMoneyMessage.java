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
		jLabel = new JLabel("您要取款金额为");
		jTextField = new JTextField(15);
		jButton1 = new JButton("确认");
		jButton2 = new JButton("修改取款金额");
		
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
						//账户余额
						String remaning = user.getUserAccount().getRemaning();
						
						//取款交易记录
						HistoryTrade historyTrade = new HistoryTrade();
						
						//账户类型为定期账户
						if(AttributeUtil.FIXED.equals(user.getAccountType()))
						{
							//如果余额小于取款金额，提示余额不足，取款服务取消
							if(Double.parseDouble(remaning) < Double.parseDouble(WithdrawingMoneyMessage.this.money))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "您的余额不足，取款服务将取消！", "警告", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//如果余额减去取款金额后剩余金额小于 10元手续费，提示余额不足，转账服务取消
							else if((Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) < 10)
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "您的余额不足以支付转账后的手续费，转账服务将取消！", "警告", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//定期账户每次取款后余额扣除手续费 10元
							else
							{
								String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money) - 10) + "";
								
								user.getUserAccount().setRemaning(newRemaning);
								
								userDAO.updateUser(user);
							}
						}
						
						//账户类型为活期账户
						else if(AttributeUtil.CURRENT.equals(user.getAccountType()))
						{
							//如果余额小于取款金额，提示余额不足，取款服务取消
							if(Double.parseDouble(remaning) < Double.parseDouble(WithdrawingMoneyMessage.this.money))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "您的余额不足，取款服务将取消！", "警告", JOptionPane.WARNING_MESSAGE);
								
								return;
							}
							
							//如果该账户当月取款次数大于5次
							else if(user.getUserAccount().getWithdrawingMoneyCount() > 5)
							{
								//如果余额减去取款金额后剩余金额小于 2元手续费，提示余额不足，转账服务取消
								if((Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) < 2)
								{
									JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "您的余额不足以支付转账后的手续费，转账服务将取消！", "警告", JOptionPane.WARNING_MESSAGE);
									
									return;
								}
								else
								{
									String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money) - 2) + "";
									
									user.getUserAccount().setRemaning(newRemaning);
									
									userDAO.updateUser(user);
								}
							}
							
							//如果该账户当月取款次数   <= 5 次
							else
							{
								String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) + "";
								
								user.getUserAccount().setRemaning(newRemaning);
								
								//先查询出当月已经取款次数，然后再加1
								user.getUserAccount().setWithdrawingMoneyCount(user.getUserAccount().getWithdrawingMoneyCount() + 1);
								
								userDAO.updateUser(user);
							}
						}
						
						//账户类型为信用卡账户
						else
						{
							String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(WithdrawingMoneyMessage.this.money)) + "";
							
							//信用卡只能透支2000元，如果超出2000，提示警告信息
							if(Double.parseDouble(newRemaning) < (-2000))
							{
								JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "您信用卡只能透支2000元，请重新输入取款金额！", "警告", JOptionPane.WARNING_MESSAGE);
								
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
						
						JOptionPane.showMessageDialog(WithdrawingMoneyMessage.this, "取款成功!", "恭喜", JOptionPane.YES_OPTION);
						
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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("取款信息界面"));
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.jTextField.setEditable(false);
		this.add(jPanel);
		this.setTitle("ATM系统");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
