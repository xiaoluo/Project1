package com.xiaoluo.chat.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import com.xiaoluo.chat.util.XMLUtil;

public class ClientConnection extends Thread
{ 
	private Client client;
	
	private String username;
	
	private String hostAddress;
	
	private int port;
	
	private Socket socket;
	
	private InputStream is;
	
	private OutputStream os;
	
	private ChatClient chatClient;
	
	public ClientConnection(Client client, String username, String hostAddress, int port)
	{
		this.client = client;
		this.username = username;
		this.hostAddress = hostAddress;
		this.port = port;
		this.client2Server();
		this.login();
	}
	
	private void client2Server()
	{
		try
		{
			socket = new Socket(this.hostAddress, this.port);
			
			this.is= socket.getInputStream();
			this.os = socket.getOutputStream();
		}
		catch (Exception e)
		{

		}
	}
	
	private void login()
	{
		String xml = XMLUtil.constructLoginXML(this.username);
		try
		{
			this.os.write(xml.getBytes());
			
			this.chatClient = new ChatClient(this);
			this.client.setVisible(false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//客户端向服务器端发送消息
	private void sendMessage(String message)
	{
		try
		{
			this.os.write(message.getBytes());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		
		try
		{
			byte[] buffer = new byte[5000];
			int length = this.is.read(buffer);
			String xml = new String(buffer, 0, length);
			
			List<String> list = XMLUtil.extractServerUserListXML(xml);
			String str = "";
			for(String user : list)
			{
				str += user + "\n";
			}
			this.chatClient.getJTextArea2().setText(str);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
