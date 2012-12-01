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

public class TransferMessage extends JFrame
{
	private JPanel jPanel;
	
	private JLabel jLabel1;
	
	private JLabel jLabel2;
	
	private JLabel jLabel3;
	
	private JTextField jTextField1;
	
	private JTextField jTextField2;

	private JTextField jTextField3;
	
	private JButton jButton1;
	
	private JButton jButton2;
	
	private UserLogin userLogin;
	
	private TransferMoney transferMoney;
	
	public TransferMessage(UserLogin userLogin, TransferMoney transferMoney)
	{
		this.transferMoney = transferMoney;
		
		this.userLogin = userLogin;
		
		init();
	}
	
	private void init()
	{
		jPanel = new JPanel();
		jLabel1 = new JLabel("��ת���߿���");
		jLabel2 = new JLabel("��ת��������");
		jLabel3 = new JLabel("ת�˽��");
		jTextField1 = new JTextField(20);
		jTextField2 = new JTextField(20);
		jTextField3 = new JTextField(22);
		jButton1 = new JButton("ȷ��");
		jButton2 = new JButton("�޸���Ϣ");
		
		String name = TransferMessage.this.transferMoney.getUsername();
		
		String afterBankCard = TransferMessage.this.transferMoney.getjTextField1().getText();
		
		String money = TransferMessage.this.transferMoney.getjTextField2().getText();
		
		jTextField1.setText(afterBankCard);
		jTextField2.setText(name);
		jTextField3.setText(money);
		
		jButton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String beforeBankCard = TransferMessage.this.userLogin.getjTextField().getText();
				
				//��ת�˵�id
				int afterId = TransferMessage.this.transferMoney.getAfterId();
				
				UserDAO userDAO = new UserDAOImpl();
				
				List<User> list = userDAO.getAllUser();
				
				for(User user : list)
				{
					if(beforeBankCard.equals(user.getBankCard()))
					{
						//ת���ߵĽ��׼�¼
						HistoryTrade historyTrade1 = new HistoryTrade();
						
						//��ת���ߵĽ��׼�¼
						HistoryTrade historyTrade2 = new HistoryTrade();
						
						//ת����ת��ǰ�����
						String remaning = user.getUserAccount().getRemaning();
						
						//ת�˽��
						String sum = TransferMessage.this.transferMoney.getjTextField2().getText();
						
						//������С��ת�˽���ʾ���㣬ת�˷���ȡ��
						if(Double.parseDouble(remaning) < Double.parseDouble(sum))
						{
							JOptionPane.showMessageDialog(TransferMessage.this, "�������㣬ת�˷���ȡ����", "����", JOptionPane.WARNING_MESSAGE);
						}
						
						//�������ȥת�˽���ʣ����С��ת�˽��  * 1%�������ѣ���ʾ���㣬ת�˷���ȡ��
						else if((Double.parseDouble(remaning) - Double.parseDouble(sum)) < Double.parseDouble(sum) * 0.01)
						{
							JOptionPane.showMessageDialog(TransferMessage.this, "����������֧��ת�˺�������ѣ�ת�˷���ȡ����", "����", JOptionPane.WARNING_MESSAGE);
						}
						
						//ת�˳ɹ���ת���߿۳�ת�˽���Ѿ�ת�������ѣ������ߵõ�ת�˽��
						else
						{
							//ͨ����ת���ߵ�id�õ����˻�
							User user2 = userDAO.getSingleUser(afterId);
							
							//��ת���ߵ����
							String user2Remaning = user2.getUserAccount().getRemaning();
							
							//ת����ת�˺��ʣ����
							String newRemaning = (Double.parseDouble(remaning) - Double.parseDouble(sum) - Double.parseDouble(sum) * 0.01) + "";
							
							//��ת���߽���ת�˺�Ľ��
							String newUser2Remaning = (Double.parseDouble(user2Remaning) + Double.parseDouble(sum)) + "";
							
							//����ת���ߵĽ��׼�¼
							historyTrade1.setBankCard(beforeBankCard);
							historyTrade1.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							historyTrade1.setTradeSum(sum);
							historyTrade1.setOperation(AttributeUtil.TRANSFER);
							
							//���±�ת���ߵĽ��׼�¼
							historyTrade2.setBankCard(TransferMessage.this.transferMoney.getjTextField1().getText());
							historyTrade2.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
							historyTrade2.setTradeSum(sum);
							historyTrade2.setOperation(AttributeUtil.RECEIVE_TRANSFER);
							
							historyTrade1.setUserAccount(user.getUserAccount());
							historyTrade2.setUserAccount(user2.getUserAccount());
							user.getUserAccount().getHistoryTrades().add(historyTrade1);
							user2.getUserAccount().getHistoryTrades().add(historyTrade2);
							
							user.getUserAccount().setRemaning(newRemaning);
							user2.getUserAccount().setRemaning(newUser2Remaning);
							
							userDAO.updateUser(user);
							userDAO.updateUser(user2);
							
							JOptionPane.showMessageDialog(TransferMessage.this, "ת�˳ɹ�", "��ϲ", JOptionPane.YES_OPTION);
							
							new ClientServer(TransferMessage.this.userLogin);
							
							TransferMessage.this.setVisible(false);
						}
					}
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new TransferMoney(TransferMessage.this.userLogin);
				
				TransferMessage.this.setVisible(false);
			}
		});
		
		jPanel.setBorder(BorderFactory.createTitledBorder("��˶�ת����Ϣ"));
		jPanel.add(jLabel1);
		jPanel.add(jTextField1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField2);
		jPanel.add(jLabel3);
		jPanel.add(jTextField3);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		
		this.add(jPanel);
		this.jTextField1.setEditable(false);
		this.jTextField2.setEditable(false);
		this.jTextField3.setEditable(false);
		this.setTitle("ATMϵͳ");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setAlwaysOnTop(true);
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
