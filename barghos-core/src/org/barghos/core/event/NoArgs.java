package org.barghos.core.event;

public class NoArgs implements EventArgs
{
	
	private static final NoArgs instance = new NoArgs();
	
	public static NoArgs getInstance()
	{
		return instance;
	}
	
	private NoArgs() {  }
}
