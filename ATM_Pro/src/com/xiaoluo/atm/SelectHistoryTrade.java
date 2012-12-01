package com.xiaoluo.atm;

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
import com.xiaoluo.bean.User;
import com.xiaoluo.dao.HistoryTradeDAO;
import com.xiaoluo.dao.UserDAO;
import com.xiaoluo.dao.impl.HistoryTradeDAOImpl;
import com.xiaoluo.dao.impl.UserDAOImpl;

public class SelectHistoryTrade extends JFrame
{
	private JPanel jPanel;
	
	private JTable jTable;
	
	private JButton jButton;
	
	private JScrollPane jScrollPane;
	
	private UserLogin userLogin;
	
	public SelectHistoryTrade(UserLogin userLogin)
	{
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		//表格最上层的显示栏目
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
				new ClientServer(SelectHistoryTrade.this.userLogin);
				
				SelectHistoryTrade.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("历史交易界面"));
		jPanel.add(jButton);
		
		this.getContentPane().add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.NORTH);
		this.setTitle("ATM系统");
		this.setVisible(true);
		this.setLocation(200, 100);
		this.setAlwaysOnTop(true);
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 遍历数据库中所有用户，得到当前银行卡账号，然后查询出该账户所有的交易历史记录，将得到的数据保存到二维数组中
	 * @return  当前银行卡账号的历史交易记录
	 */
	private String[][] getData()
	{
		UserDAO userDAO = new UserDAOImpl();
		HistoryTradeDAO historyTradeDAO = new HistoryTradeDAOImpl();
		
		List<User> list = userDAO.getAllUser();
		
		String bankCard = SelectHistoryTrade.this.userLogin.getjTextField().getText();
		
		String[][] result = null;
		for(User user : list)
		{
			if(bankCard.equals(user.getBankCard()))
			{
				List<HistoryTrade> trades = historyTradeDAO.getSpecialHistoryTrade(bankCard);
				
				result = new String[trades.size()][];
				
				for(int i = 0; i < trades.size(); i++)
				{
					HistoryTrade historyTrade = trades.get(i);
					
					//得到每一条交易记录，将其字段保存在一个一维数组当中
					String[] array = {historyTrade.getId() + "", historyTrade.getBankCard(), historyTrade.getTradeTime() + "", historyTrade.getTradeSum(), historyTrade.getOperation() + ""};

					result[i] = array;
				}
			}
		}
		return result;
	}
	
}
