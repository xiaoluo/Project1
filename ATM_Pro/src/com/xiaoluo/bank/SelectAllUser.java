package com.xiaoluo.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xiaoluo.bean.User;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.UserDAOImpl;

public class SelectAllUser extends JFrame
{
	private JPanel jPanel;
	
	private JTable jTable;
	
	private JButton jButton;
	
	private JScrollPane jScrollPane;
	
	public SelectAllUser()
	{
		init();
	}
	
	private void init()
	{
		String[] columns = {"序号", "身份证号", "卡号", "姓名", "密码", "账户类型", "银行卡使用状态"};
		
		jPanel = new JPanel();
		jButton = new JButton("返回");
		jTable = new JTable(getData(), columns);
		
		jScrollPane = new JScrollPane(jTable);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		jButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AdminServer();
				
				SelectAllUser.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("所有账户信息界面"));
		jPanel.add(jButton);
		
		this.getContentPane().add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.NORTH);
		this.setTitle("银行后台管理系统");
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(1000, 500);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * 得到所有账户的信息，保存到一个二维数组中
	 */
	private String[][] getData()
	{
		UserDAO userDAO = new UserDAOImpl();
		
		String[][] result = null;
		
		List<User> list = userDAO.getAllUser();
		
		result = new String[list.size()][];
		
		for(int i = 0; i < list.size(); i++)
		{
			User user = list.get(i);
			
			String[] array = {user.getId() + "", user.getIdentityCard(), user.getBankCard(), user.getName(), user.getPassword(), user.getAccountType(), user.getStatus()};

			result[i] = array;
		}
				
		return result;
	}
	
}
