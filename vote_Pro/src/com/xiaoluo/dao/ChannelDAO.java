package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.model.Channel;
import com.xiaoluo.model.VoteOption;

public interface ChannelDAO
{
	public void saveChannel(Channel channel);
	
	public List<Channel> getAllChannel();
	
	public void deleteChannel(int id);
	
	public Channel getSingleChannel(int id);
	
	public void updateChannel(VoteOption voteOption);
}
