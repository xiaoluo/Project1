package com.xiaoluo.bean;

import java.util.HashSet;
import java.util.Set;

public class UserAccount
{
	private int id;
	
	private String bankCard;
	
	private String remaning;
	
	private String accountType;
	
	private int passwordErrorCount;
	
	private int withdrawingMoneyCount;

	private User user;
	
	private Set<HistoryTrade> historyTrades = new HashSet<HistoryTrade>();
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getBankCard()
	{
		return bankCard;
	}

	public void setBankCard(String bankCard)
	{
		this.bankCard = bankCard;
	}

	public String getRemaning()
	{
		return remaning;
	}

	public void setRemaning(String remaning)
	{
		this.remaning = remaning;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public int getPasswordErrorCount()
	{
		return passwordErrorCount;
	}

	public void setPasswordErrorCount(int passwordErrorCount)
	{
		this.passwordErrorCount = passwordErrorCount;
	}

	public int getWithdrawingMoneyCount()
	{
		return withdrawingMoneyCount;
	}

	public void setWithdrawingMoneyCount(int withdrawingMoneyCount)
	{
		this.withdrawingMoneyCount = withdrawingMoneyCount;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Set<HistoryTrade> getHistoryTrades()
	{
		return historyTrades;
	}

	public void setHistoryTrades(Set<HistoryTrade> historyTrades)
	{
		this.historyTrades = historyTrades;
	}
	
}
