package com.xiaoluo.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.model.Channel;
import com.xiaoluo.service.ChannelService;
import com.xiaoluo.service.impl.ChannelServiceImpl;

public class DoVoteAction extends ActionSupport
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
		
		Channel channel = channelService.getSingleChannel(id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("channel", channel);
		
		return SUCCESS;
	}
}
