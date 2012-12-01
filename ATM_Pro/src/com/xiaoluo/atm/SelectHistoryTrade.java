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
		//������ϲ����ʾ��Ŀ
		String[] columns = {"���", "����", "����ʱ��", "���׽��", "���ײ���"};
		
		jPanel = new JPanel();
		jButton = new JButton("����");
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
		
		jPanel.setBorder(BorderFactory.createTitledBorder("��ʷ���׽���"));
		jPanel.add(jButton);
		
		this.getContentPane().add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.NORTH);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(200, 100);
		this.setAlwaysOnTop(true);
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * �������ݿ��������û����õ���ǰ���п��˺ţ�Ȼ���ѯ�����˻����еĽ�����ʷ��¼�����õ������ݱ��浽��ά������
	 * @return  ��ǰ���п��˺ŵ���ʷ���׼�¼
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
					
					//�õ�ÿһ�����׼�¼�������ֶα�����һ��һά���鵱��
					String[] array = {historyTrade.getId() + "", historyTrade.getBankCard(), historyTrade.getTradeTime() + "", historyTrade.getTradeSum(), historyTrade.getOperation() + ""};

					result[i] = array;
				}
			}
		}
		return result;
	}
	
}
