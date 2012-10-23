package com.xiaoluo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.model.Channel;
import com.xiaoluo.model.Vote;
import com.xiaoluo.model.VoteOption;
import com.xiaoluo.service.impl.ChannelServiceImpl;

public class AddVoteAction extends ActionSupport
{
	private String channelName;
	
	private String voteName;
	
	private String[] voteOptionName;
	
	public String getChannelName()
	{
		return channelName;
	}

	public void setChannelName(String channelName)
	{
		this.channelName = channelName;
	}

	public String getVoteName()
	{
		return voteName;
	}

	public void setVoteName(String voteName)
	{
		this.voteName = voteName;
	}

	public String[] getVoteOptionName()
	{
		return voteOptionName;
	}

	public void setVoteOptionName(String[] voteOptionName)
	{
		this.voteOptionName = voteOptionName;
	}

	public String saveChannel() throws Exception
	{
		ChannelServiceImpl channelService = new ChannelServiceImpl();
		
		String channelName1 = new String(channelName.getBytes("iso-8859-1"), "utf-8");
		String voteName1 = new String(voteName.getBytes("iso-8859-1"), "utf-8");
		
		Channel channel = new Channel();
		Vote vote = new Vote();
		
		channel.setChannelName(channelName1);
		vote.setVoteName(voteName1);
		
		channel.getVotes().add(vote);
		vote.setChannel(channel);
		
		for(String optionName : voteOptionName)
		{
			String voteOptionName1 = new String(optionName.getBytes("iso-8859-1"), "utf-8");
			VoteOption voteOption = new VoteOption();
			voteOption.setVoteOptionName(voteOptionName1);
			
			vote.getOptions().add(voteOption);
			voteOption.setVote(vote);
		}
		
		channelService.saveChannel(channel);
		
		return SUCCESS;
		
	}
}
