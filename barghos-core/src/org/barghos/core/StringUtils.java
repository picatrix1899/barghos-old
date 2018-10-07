package org.barghos.core;


public class StringUtils
{
	public static String padLeft(String str, String c, int count)
	{
		for(int i = 0; i < count; i++)
		{
			str = c + str;
		}
		
		return str;
	}
	
	public static String padRight(String str, String c, int count)
	{
		for(int i = 0; i < count; i++)
		{
			str = str + c;
		}
		
		return str;
	}
}
