package com.xiaoluo.model;

public class VoteOption
{
	private int id;
	
	private String voteOptionName;
	
	private int ticketNum;
	
	private Vote vote;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getVoteOptionName()
	{
		return voteOptionName;
	}

	public void setVoteOptionName(String voteOptionName)
	{
		this.voteOptionName = voteOptionName;
	}

	public int getTicketNum()
	{
		return ticketNum;
	}

	public void setTicketNum(int ticketNum)
	{
		this.ticketNum = ticketNum;
	}

	public Vote getVote()
	{
		return vote;
	}

	public void setVote(Vote vote)
	{
		this.vote = vote;
	}
}
