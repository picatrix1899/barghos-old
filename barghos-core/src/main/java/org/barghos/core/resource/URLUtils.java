package org.barghos.core.resource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils
{

	public static URL URLFromFile(File f)
	{
		try
		{
			return f.toURI().toURL();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static URL URLFromFile(String f)
	{
		try
		{
			return new File(f).toURI().toURL();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static URL URLFromEmbededFile(Class<?> clazz, String f)
	{
		return clazz.getResource(f);
	}
}
