package com.xiaoluo.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xiaoluo.atm.UserLogin;
import com.xiaoluo.bean.User;
import com.xiaoluo.bean.UserAccount;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;
import com.xiaoluo.util.ATMUtil;
import com.xiaoluo.util.AttributeUtil;

public class CreateCard extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JLabel jLabel3;
	
	private JLabel jLabel4;
	
	private JTextField jTextField1;
	
	private JTextField jTextField2;
	
	private JPasswordField jPasswordField1;
	
	private JPasswordField jPasswordField2;
	
	@SuppressWarnings("unchecked")
	private JComboBox jComboBox;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	public CreateCard()
	{
		this.init();
	}
	
	@SuppressWarnings("unchecked")
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jPasswordField1 = new JPasswordField(20);
		jPasswordField2 = new JPasswordField(20);
		jButton1 = new JButton();
		jButton2 = new JButton();
		jComboBox = new JComboBox();
		
		jLabel1.setText("姓名        ");
		jLabel2.setText("身份证    ");
		jLabel3.setText("密码        ");
		jLabel4.setText("确认密码");
		jComboBox.addItem("活期账户");
		jComboBox.addItem("定期账户");
		jComboBox.addItem("信用卡账户");
		jButton1.setText("确认");
		jButton2.setText("退出");
		
		jPanel.setBorder(BorderFactory.createTitledBorder("银行卡办理界面"));
		jPanel.add(jLabel1);
		jPanel.add(jTextField1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField2);
		jPanel.add(jLabel3);
		jPanel.add(jPasswordField1);
		jPanel.add(jLabel4);
		jPanel.add(jPasswordField2);
		jPanel.add(jComboBox);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String name = CreateCard.this.jTextField1.getText();
				String identityCard = CreateCard.this.jTextField2.getText();
				String password = new String(CreateCard.this.jPasswordField1.getPassword());
				String repassword = new String(CreateCard.this.jPasswordField2.getPassword());
				String accountType = (String)CreateCard.this.jComboBox.getSelectedItem();
				
				if("".equals(name))
				{
					JOptionPane.showMessageDialog(CreateCard.this, "请输入姓名！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(identityCard.length() != 18 || !ATMUtil.isNumber(identityCard))
				{
					JOptionPane.showMessageDialog(CreateCard.this, "您输入的身份证不合法，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(password.length() != 6 || !ATMUtil.isNumber(password))
				{
					JOptionPane.showMessageDialog(CreateCard.this, "您输入的密码不合法，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if(!password.equals(repassword))
				{
					JOptionPane.showMessageDialog(CreateCard.this, "您两次输入密码不正确，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//通过随机数生成以622开头的19位银行卡卡号
					String bankCard = ATMUtil.createBankCard();
					
					User user = new User();
					UserAccount userAccount = new UserAccount();
					UserDAO userDAO = new UserDAOImpl();
					
					user.setName(name);
					user.setPassword(password);
					user.setIdentityCard(identityCard);
					user.setBankCard(bankCard);
					user.setAccountType(accountType);
					user.setStatus(AttributeUtil.IDLE);
					
					userAccount.setAccountType(accountType);
					userAccount.setBankCard(bankCard);
					userAccount.setRemaning("0");
					userAccount.setPasswordErrorCount(0);
					userAccount.setWithdrawingMoneyCount(0);
					userAccount.setUser(user);
					user.setUserAccount(userAccount);
					
					userDAO.saveUser(user);
					
					JOptionPane.showMessageDialog(CreateCard.this, "恭喜您开户成功，您的卡号为：" + bankCard, "恭喜", JOptionPane.OK_OPTION);
					
					new UserLogin();
					CreateCard.this.setVisible(false);
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		this.setTitle("银行后台管理系统");
		this.add(jPanel);
		this.setAlwaysOnTop(true);
		this.setLocation(400, 200);
		this.setVisible(true);
		this.setSize(350, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
