package org.barghos.core.profiler;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CascadingProfiler
{

	private ThreadLocal<Map<String,CascadedProfile>> profiles = new ThreadLocal<>();
	private ThreadLocal<CascadedProfile> current = new ThreadLocal<>();
	
	public CascadingProfiler()
	{
		
	}
	
	public ProfilerSession start(String profile)
	{
		Map<String,CascadedProfile> prof = this.profiles.get();
		
		if(!prof.containsKey(profile))
		{
			CascadedProfile profile = new CascadedProfile(null);
		}
	}
	
	public void finished(ProfilerSession session)
	{
		
	}
	
	public class CascadedProfile
	{
		public Map<String,CascadedProfile> times = new HashMap<>();
		public long averageDuration;
		public CascadedProfile parent;
		
		public CascadedProfile(CascadedProfile parent)
		{
			this.parent = parent;
		}

		public String dump()
		{
			
		}
	}
	
	public class ProfilerSession implements Closeable
	{
		private CascadingProfiler profiler;
		private ProfilerSession parent;
		private long startTime;
		private long duration;
		private String name;
		private HashMap<String,Long> times = new HashMap<>();
		
		public ProfilerSession(CascadingProfiler profiler, ProfilerSession session, String name)
		{
			this.profiler = profiler;
			this.parent = session;
			this.name = name;
			this.startTime = System.nanoTime();
		}
		
		@Override
		public void close() throws IOException
		{
			this.duration = System.nanoTime() - this.startTime;
			if(this.parent != null)
				this.parent.finished(this);
			else
				this.profiler.finished(this);
		}
		
		public void finished(ProfilerSession session)
		{	
			this.times.put(session.name, session.duration);
		}
		
		public Map<String,Long> getTimes()
		{
			return this.times;
		}
	}
}
