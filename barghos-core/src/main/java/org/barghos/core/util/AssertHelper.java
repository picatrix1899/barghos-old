package org.barghos.core.util;

import org.barghos.core.exception.ArgumentNullException;

public class AssertHelper
{
	public static boolean argumentNotNull(Object o, String name)
	{
		if(o == null) throw new ArgumentNullException(name);
		return true;
	}
}
