package com.xiaoluo.util;

import java.util.Random;

public class ATMUtil
{
	/**
	 * ���������622��ͷ��19λ�����п�����
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
     *�ж��Ƿ�Ϊ���֣�ȫ�����ַ���true�����򷵻�false
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
     * �ж��Ƿ����С����. ����������true����������false
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
