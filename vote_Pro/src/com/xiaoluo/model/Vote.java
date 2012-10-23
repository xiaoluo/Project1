package com.xiaoluo.model;

import java.util.HashSet;
import java.util.Set;

public class Vote
{
	private int id;
	
	private String voteName;
	
	private Channel channel;

	private Set<VoteOption> options = new HashSet<VoteOption>();
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getVoteName()
	{
		return voteName;
	}

	public void setVoteName(String voteName)
	{
		this.voteName = voteName;
	}

	public Channel getChannel()
	{
		return channel;
	}

	public void setChannel(Channel channel)
	{
		this.channel = channel;
	}

	public Set<VoteOption> getOptions()
	{
		return options;
	}

	public void setOptions(Set<VoteOption> options)
	{
		this.options = options;
	}

}
