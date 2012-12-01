package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.HistoryTrade;

public interface HistoryTradeDAO
{
	public List<HistoryTrade> getAllHistoryTrade();
	
	public List<HistoryTrade> getSpecialHistoryTrade(String bankCard);
}
