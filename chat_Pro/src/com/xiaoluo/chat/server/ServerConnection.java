package com.xiaoluo.chat.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.xiaoluo.chat.util.XMLUtil;

public class ServerConnection extends Thread
{
	private Server server;
	
	private ServerSocket serverSocket;
	
	private Socket socket;
	
	private int port;
	public ServerConnection(Server server, int port)
	{
		this.server = server;
		this.port = port;
		
		try
		{
			this.serverSocket = new ServerSocket(this.port);
			
			this.server.getJLabel2().setText("运行");
			this.server.getJButton().setEnabled(false);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this.server, "端口号被占用", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				this.socket = this.serverSocket.accept();
				
				ServerMessageThread serverMessageThread = new ServerMessageThread(this.server, this.socket);
				
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				byte[] buffer = new byte[5000];
				int length = is.read(buffer);
				String loginXML = new String(buffer, 0 , length);
				
				String username = XMLUtil.extractLoginXML(loginXML);
				
				this.server.getMap().put(username, serverMessageThread);
				
				serverMessageThread.updateServerUserList();
				
				serverMessageThread.start();
			}
		}
		catch (Exception e)
		{

		}
	}
}
