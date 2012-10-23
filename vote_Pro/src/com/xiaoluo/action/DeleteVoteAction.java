package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.model.Channel;
import com.xiaoluo.service.ChannelService;
import com.xiaoluo.service.impl.ChannelServiceImpl;

public class DeleteVoteAction extends ActionSupport
{
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String execute() throws Exception
	{
		ChannelService channelService = new ChannelServiceImpl();
		
		channelService.deleteChannel(id);
		
		List<Channel> channels = channelService.getAllChannel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("channel", channels);
		
		return SUCCESS;
	}
}
