package com.xiaoluo.model;

import java.util.HashSet;
import java.util.Set;

public class Channel
{
	private int id;
	
	private String channelName;
	
	private Set<Vote> votes = new HashSet<Vote>();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getChannelName()
	{
		return channelName;
	}

	public void setChannelName(String channelName)
	{
		this.channelName = channelName;
	}

	public Set<Vote> getVotes()
	{
		return votes;
	}

	public void setVotes(Set<Vote> votes)
	{
		this.votes = votes;
	}
}
