package com.xiaoluo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.model.Channel;
import com.xiaoluo.service.ChannelService;
import com.xiaoluo.service.impl.ChannelServiceImpl;

public class VoteShowAction extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		ChannelService channelService = new ChannelServiceImpl();
		
		List<Channel> channels = channelService.getAllChannel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("channels", channels);
		
		return SUCCESS;
	}
}
