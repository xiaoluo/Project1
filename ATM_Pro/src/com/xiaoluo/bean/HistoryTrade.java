package com.xiaoluo.bean;

import java.sql.Timestamp;

public class HistoryTrade
{
	private int id;
	
	private String bankCard;
	
	private Timestamp tradeTime;
	
	private String tradeSum;
	
	private char operation;
	
	private UserAccount userAccount;

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

	public Timestamp getTradeTime()
	{
		return tradeTime;
	}

	public void setTradeTime(Timestamp tradeTime)
	{
		this.tradeTime = tradeTime;
	}

	public String getTradeSum()
	{
		return tradeSum;
	}

	public void setTradeSum(String tradeSum)
	{
		this.tradeSum = tradeSum;
	}

	public char getOperation()
	{
		return operation;
	}

	public void setOperation(char operation)
	{
		this.operation = operation;
	}

	public UserAccount getUserAccount()
	{
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount)
	{
		this.userAccount = userAccount;
	}

}
