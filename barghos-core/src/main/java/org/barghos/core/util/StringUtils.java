package org.barghos.core.util;


public class StringUtils
{
	public static String padLeft(String str, String c, int count)
	{
		for(int i = 0; i < count; i++)
			str = c + str;
		
		return str;
	}
	
	public static String padRight(String str, String c, int count)
	{
		for(int i = 0; i < count; i++)
			str = str + c;
		
		return str;
	}
	
	public static String repeat(String str, int n)
	{
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < n; i++)
			builder.append(str);
		
		return builder.toString();
	}
	
	public static StringBuilder repeat(String str, int n, StringBuilder builder)
	{
		for(int i = 0; i < n; i++)
			builder.append(str);
		return builder;
	}
}
