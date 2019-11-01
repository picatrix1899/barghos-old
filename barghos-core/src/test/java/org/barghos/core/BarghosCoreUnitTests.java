package org.barghos.core;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.junit.BeforeClass;

public class BarghosCoreUnitTests
{
	public static boolean ASSERTS_ENABLED = false;
	
	@BeforeClass
	public static void initAssert()
	{
		RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = mxBean.getInputArguments();
		ASSERTS_ENABLED = arguments.contains("-ae");
	}
}
