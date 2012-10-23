package com.xiaoluo.action;

import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoluo.model.Channel;
import com.xiaoluo.model.Vote;
import com.xiaoluo.model.VoteOption;
import com.xiaoluo.service.ChannelService;
import com.xiaoluo.service.impl.ChannelServiceImpl;

public class AccountVoteAction extends ActionSupport
{
	private int id;
	
	private String voteOption;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getVoteOption()
	{
		return voteOption;
	}

	public void setVoteOption(String voteOption)
	{
		this.voteOption = voteOption;
	}

	@Override
	public String execute() throws Exception
	{
		HttpServletRequest  request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ChannelService channelService = new ChannelServiceImpl();
		
		Channel channel = channelService.getSingleChannel(id);
		
		Set<Vote> votes = channel.getVotes();
		
		for(Vote vote : votes)
		{
			
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies)
			{
				if(String.valueOf(vote.getId()).equals(cookie.getValue()))
				{
					response.sendRedirect("repeatSubmit.jsp");
				}
				else
				{
					Cookie cookie2 = new Cookie("hasVote" + vote.getId(), String.valueOf(vote.getId()));
					
					response.addCookie(cookie2);
				}
			}
			
			Set<VoteOption> voteOptions = vote.getOptions();
			
			for(VoteOption option : voteOptions)
			{
				String voteOption2 = new String(voteOption.getBytes("iso-8859-1"), "utf-8");
				
				if(voteOption2.equals(option.getVoteOptionName()))
				{
					int optionTicketNum = option.getTicketNum();
					
					int result = optionTicketNum + 1; 
					
					option.setTicketNum(result);
					
					channelService.updateChannel(option);
				}
			}
			
			request.setAttribute("voteOptions", voteOptions);
			
		}
		
		return SUCCESS;
	}
}
