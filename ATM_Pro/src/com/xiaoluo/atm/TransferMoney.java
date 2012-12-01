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
	
	//被转账者姓名
	private String username;
	
	//被转账者id
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
		jLabel1 = new JLabel("请输入转账卡号");
		jLabel2 = new JLabel("请输入转账金额");
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jButton1 = new JButton("转账");
		jButton2 = new JButton("返回");
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String bankCard = TransferMoney.this.jTextField1.getText();
				
				String money = TransferMoney.this.jTextField2.getText();
				
				if(bankCard.length() != 19 || !ATMUtil.isNumber(bankCard))
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "请输入合法的银行卡卡号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(money.length() ==0 || !ATMUtil.isNumber(money))
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "请输入合法金额", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(Integer.parseInt(money) > 10000)
				{
					JOptionPane.showMessageDialog(TransferMoney.this, "您每次最多只能转账1W，请输入小于1W的金额", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					UserDAO userDAO = new UserDAOImpl();
					
					List<User> list = userDAO.getAllUser();
					
					//得到被转账者的姓名以及银行卡号,并显示转账金额
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
					
					JOptionPane.showMessageDialog(TransferMoney.this, "您输入的卡号不存在，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("转账页面"));
		jPanel.add(jLabel1);
		jPanel.add(jTextField1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField2);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.setTitle("ATM系统");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
