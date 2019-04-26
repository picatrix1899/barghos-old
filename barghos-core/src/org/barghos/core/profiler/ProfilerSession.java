package org.barghos.core.profiler;

import java.io.Closeable;
import java.io.IOException;

public class ProfilerSession implements Closeable
{
	private CascadingProfiler profiler;
	private ProfilerSession parent;
	
	public ProfilerSession(CascadingProfiler profiler, ProfilerSession session, String name)
	{
		
	}
	
	@Override
	public void close() throws IOException
	{
		throw new NotImplementedException();
	}
}
