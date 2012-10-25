package com.xiaoluo.chat.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Server extends JFrame
{
	private JLabel jLabel1;

	private JLabel jLabel2;

	private JLabel jLabel3;

	private JButton jButton;

	private JPanel jPanel1;

	private JPanel jPanel2;

	private JScrollPane jScrollPane;

	private JTextArea jTextArea;

	private JTextField jTextField;
	
	private Map<String, ServerMessageThread> map = new HashMap<String, ServerMessageThread>();
	
	public Map<String, ServerMessageThread> getMap()
	{
		return map;
	}

	public Server(String name)
	{
		super(name);

		this.initComponents(); //initialize UI
	}
	
	public JLabel getJLabel2()
	{
		return jLabel2;
	}

	public JButton getJButton()
	{
		return jButton;
	}

	public JTextArea getJTextArea()
	{
		return jTextArea;
	}

	public JTextField getJTextField()
	{
		return jTextField;
	}

	private void initComponents()
	{
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		
		jTextField = new JTextField(10);
		jButton = new JButton();
		jScrollPane = new JScrollPane();
		jTextArea = new JTextArea();
		

		jPanel1.setBorder(BorderFactory.createTitledBorder("��������Ϣ"));
		jPanel2.setBorder(BorderFactory.createTitledBorder("�����û��б�"));

		jTextField.setText("5000");
		
		jLabel1.setText("������״̬");
		jLabel2.setText("ֹͣ");
		jLabel2.setForeground(new Color(204, 0, 51));
		jLabel3.setText("�˿ں�");

		jButton.setText("����������");
		
		jButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Server.this.execut(e);
			}
		});
		
		
		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jTextField);
		jPanel1.add(jButton);

		jTextArea.setEditable(false); //�������û��ֶ��޸������û��б�
		jTextArea.setRows(20);
		jTextArea.setColumns(30);
		jTextArea.setForeground(new Color(0, 51, 204));

		jScrollPane.setViewportView(jTextArea); //��JTextArea���õ�JScrollPane��

		jPanel2.add(jScrollPane);

		this.getContentPane().add(jPanel1, BorderLayout.NORTH);
		this.getContentPane().add(jPanel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
	
	private void execut(ActionEvent e)
	{
		int port = Integer.parseInt(jTextField.getText());
		new ServerConnection(this, port).start();
	}


	public static void main(String[] args)
	{
		new Server("������");
	}
}