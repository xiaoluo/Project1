package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.dao.impl.ChannelDAOImpl;
import com.xiaoluo.model.Channel;
import com.xiaoluo.model.VoteOption;
import com.xiaoluo.service.ChannelService;

public class ChannelServiceImpl implements ChannelService
{
	ChannelDAOImpl channelDAO = new ChannelDAOImpl();
	
	@Override
	public void saveChannel(Channel channel)
	{
		channelDAO.saveChannel(channel);
	}
	
	@Override
	public List<Channel> getAllChannel()
	{
		return channelDAO.getAllChannel();
	}
	
	@Override
	public void deleteChannel(int id)
	{
		channelDAO.deleteChannel(id);
	}
	
	@Override
	public Channel getSingleChannel(int id)
	{
		return channelDAO.getSingleChannel(id);
	}
	
	
	@Override
	public void updateChannel(VoteOption voteOption)
	{
		channelDAO.updateChannel(voteOption);
	}
	
}
