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

import com.xiaoluo.bean.HistoryTrade;
import com.xiaoluo.dao.HistoryTradeDAO;
import com.xiaoluo.dao.impl.HistoryTradeDAOImpl;

public class SelectAllHistoryTrade extends JFrame
{
	private JPanel jPanel;
	
	private JTable jTable;
	
	private JButton jButton;
	
	private JScrollPane jScrollPane;
	
	public SelectAllHistoryTrade()
	{
		init();
	}
	
	private void init()
	{
		String[] columns = {"序号", "卡号", "交易时间", "交易金额", "交易操作"};
		
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
				
				SelectAllHistoryTrade.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("所有历史交易记录界面"));
		jPanel.add(jButton);
		
		this.getContentPane().add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.NORTH);
		this.setTitle("银行后台管理系统");
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(800, 500);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * 得到所有账户的历史交易记录，保存到一个二维数组中
	 */
	private String[][] getData()
	{
		HistoryTradeDAO historyTradeDAO = new HistoryTradeDAOImpl();
		
		String[][] result = null;
		
		List<HistoryTrade> trades = historyTradeDAO.getAllHistoryTrade();
		
		result = new String[trades.size()][];
		
		for(int i = 0; i < trades.size(); i++)
		{
			HistoryTrade historyTrade = trades.get(i);
			
			String[] array = {historyTrade.getId() + "", historyTrade.getBankCard(), historyTrade.getTradeTime() + "", historyTrade.getTradeSum(), historyTrade.getOperation() + ""};

			result[i] = array;
		}
				
		return result;
	}
	
}
