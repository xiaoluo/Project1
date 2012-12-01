package com.xiaoluo.bean;

public class User
{
	private int id;
	
	private String identityCard;
	
	private String bankCard;
	
	private String name;
	
	private String password;
	
	private String accountType;
	
	private String status;

	private UserAccount userAccount;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getIdentityCard()
	{
		return identityCard;
	}

	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	}

	public String getBankCard()
	{
		return bankCard;
	}

	public void setBankCard(String bankCard)
	{
		this.bankCard = bankCard;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
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
