package com.xiaoluo.atm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xiaoluo.util.ATMUtil;

public class WithdrawingMoney extends JFrame
{
	private JPanel jPanel1;
	
	private JPanel jPanel2;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private JButton jButton3;
	
	private JButton jButton4;
	
	private JButton jButton5;
	
	private JButton jButton6;
	
	private JButton jButton7;
	
	private JButton jButton8;
	
	private JTextField jTextField;
	
	private UserLogin userLogin;
	
	public WithdrawingMoney(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jLabel1 = new JLabel("您一次最多只能取2000元现金", JLabel.CENTER);
		jLabel2 = new JLabel("请输入取款金额");
		jTextField = new JTextField(10);
		jButton1 = new JButton("500");
		jButton2 = new JButton("1000");
		jButton3 = new JButton("1500");
		jButton4 = new JButton("2000");
		jButton5 = new JButton("取款");
		jButton6 = new JButton("返回");
		jButton7 = new JButton("100");
		jButton8 = new JButton("300");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton1.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton2.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton3.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton4.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton7.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jButton8.getText();
				
				new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jButton5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String money = WithdrawingMoney.this.jTextField.getText();
				
				if(money.length() == 0 ||!ATMUtil.isNumber(money) || !ATMUtil.isContainDot(money))
				{
					JOptionPane.showMessageDialog(WithdrawingMoney.this, "请输入合法的金额", "警告", JOptionPane.WARNING_MESSAGE);	
				}
				else if(Integer.parseInt(money) > 2000)
				{
					JOptionPane.showMessageDialog(WithdrawingMoney.this, "您每次最多只能取2000元，请重新输入您的取款金额", "警告", JOptionPane.WARNING_MESSAGE);	
				}
				else
				{
					new WithdrawingMoneyMessage(WithdrawingMoney.this.userLogin, money);
					
					WithdrawingMoney.this.setVisible(false);
				}
			}
		});
		
		jButton6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ClientServer(WithdrawingMoney.this.userLogin);
				
				WithdrawingMoney.this.setVisible(false);
			}
		});
		
		jPanel1.setLayout(new GridLayout(0, 2, 60, 20));
		jPanel1.setBorder(BorderFactory.createTitledBorder("请选择取款金额"));
		jPanel1.add(jButton7);
		jPanel1.add(jButton8);
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
		jPanel1.add(jButton4);
		
		jPanel2.add(jLabel2);
		jPanel2.add(jTextField);
		jPanel2.add(jButton5);
		jPanel2.add(jButton6);
		
		this.getContentPane().add(jLabel1, BorderLayout.NORTH);
		this.getContentPane().add(jPanel1, BorderLayout.CENTER);
		this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
		
		this.setTitle("ATM系统");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
