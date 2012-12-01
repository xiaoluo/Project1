package com.xiaoluo.atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;

public class SelectRemaning extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel;
	
	private JLabel jLabel2;
	
	private JTextField jTextField;
	
	private JButton jButton;
	
	private UserLogin userLogin;
	
	public SelectRemaning(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		String bankCard = SelectRemaning.this.userLogin.getjTextField().getText();
		
		jPanel = new JPanel();
		jLabel = new JLabel("您的余额为：");
		jLabel2 = new JLabel(bankCard, JLabel.CENTER);
		jTextField = new JTextField(10);
		jButton = new JButton("返回");
		
		UserDAO userDAO = new UserDAOImpl();
		
		List<User> list = userDAO.getAllUser();
		
		for(User user : list)
		{
			if(bankCard.equals(user.getBankCard()))
			{
				SelectRemaning.this.jTextField.setText(user.getUserAccount().getRemaning());
			}
		}
		
		jButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ClientServer(SelectRemaning.this.userLogin);
				
				SelectRemaning.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("余额查询界面"));
		
		jPanel.add(jLabel2);
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton);
		
		this.add(jPanel);
		this.setTitle("ATM系统");
		this.setLocation(400, 200);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(400, 150);
		this.jTextField.setEditable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
