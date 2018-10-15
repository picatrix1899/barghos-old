package org.barghos.core;

import java.util.HashMap;

public class LayoutPropertyBlock
{
	private int maxLengthProperty;
	private int maxLengthValue;
	
	private int paddingTop;
	private int paddingBottom;
	private int paddingLeft;
	private int paddingRight;
	
	private boolean centered;
	private String splitChar;

	
	private HashMap<String, String> properties = new HashMap<String,String>();
	
	
	public int getMaxLineLength()
	{
		int length = 0;
		
		int splitCharLength = this.splitChar.length();
		
		for(String property : properties.keySet())
		{
			int propertyLength = property.length();
			int valueLength = this.properties.get(property).length();
			
			int lineLength = paddingLeft + propertyLength + splitCharLength + valueLength + paddingRight;
			
			if(lineLength > length)
			{
				length = lineLength;
			}
		}
		
		return length;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		
		
		
		return builder.toString();
	}
}
