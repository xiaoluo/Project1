package com.xiaoluo.chat.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Set;

import com.xiaoluo.chat.util.XMLUtil;

public class ServerMessageThread extends Thread
{
	private Server server;
	
	private InputStream is;
	
	private OutputStream os;
	
	public ServerMessageThread(Server server, Socket socket)
	{
		this.server = server;
		try
		{
			this.is = socket.getInputStream();
			this.os = socket.getOutputStream();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//更新在线用户列表
	//先更新服务器端的，再更新客户端的
	public void updateServerUserList()
	{
		Set<String> set = this.server.getMap().keySet();
		
		String str = "";
		
		for(String user : set)
		{
			str += user + "\n";
		}
		this.server.getJTextArea().setText(str);
		
		Collection<ServerMessageThread> cols = this.server.getMap().values();
		
		//遍历与每一个客户端对应的线程，向每一个客户端发送在线用户列表
		for(ServerMessageThread smt : cols)
		{
			smt.sendMessage(XMLUtil.constructUserList(set));
		}
	}
	
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
}
