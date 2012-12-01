package com.xiaoluo.util;

import java.util.Random;

public class ATMUtil
{
	/**
	 * 随机生成以622开头的19位的银行卡卡号
	 * @return bankCard
	 */
	public static String createBankCard()
	{
		String str = "0123456789";
		
		char[] value = new char[19];
		value[0] = '6';
		value[1] = '2';
		value[2] = '2';
		
		Random random = new Random();
		
		for(int i = 3; i < value.length; i++)
		{
			value[i] = str.charAt(random.nextInt(10));
		}
		
		return new String(value);
	}
	
    /**
     *判断是否为数字，全是数字返回true，否则返回false
     */
    public static boolean isNumber(String str)
    {
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 判读是否包含小数点. 不包含返回true，包含返回false
     */
    public static boolean isContainDot(String money)
    {
    	if(money.indexOf(".") != -1)
    	{
    		return false;
    	}
    	
    	return true;
    }
    
}
