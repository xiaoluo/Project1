package com.xiaoluo.util;

public class AttributeUtil
{
	//账户类型：活期账户
	public static final String CURRENT = "活期账户";
	
	//账户类型：定期账户
	public static final String FIXED = "定期账户";
	
	//账户类型：信用卡账户
	public static final String CREDIT = "信用卡账户";
	
	//银行卡状态： 繁忙 (使用中, 该银行卡号已经登录)
	public static final String BUSY = "busy";
	
	//银行卡状态：空闲 (未使用中， 该银行卡号还未登录)
	public static final String IDLE = "idle";
	
	//银行卡状态： 冻结中 (冻结中， 该银行卡号被冻结)
	public static final String FREEZE = "freeze";
	
	//账户操作： 存款
	public static final char DEPOSIT = 'C';
	
	//账户操作： 取款
	public static final char WITHDRAWING = 'Q';
	
	//账户操作： 转账
	public static final char TRANSFER = 'Z';
	
	//账户操作： 接受转账
	public static final char RECEIVE_TRANSFER = 'J';
	
}
