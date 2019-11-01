package org.barghos.core.profiler;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.barghos.core.StringUtils;

public class CascadingProfiler
{

	private ThreadLocal<CascadingProfile> root = new ThreadLocal<>();
	private ThreadLocal<Stack<ProfilingSession>> sessions = new ThreadLocal<>();
	private ThreadLocal<Boolean> isEnabled = new ThreadLocal<>();
	private double offset;
	
	public CascadingProfiler(double offset)
	{
		this.offset = offset;
	}
	
	public void isEnabled(boolean b)
	{
		this.isEnabled.set(b);
	}
	
	public void start(String name)
	{
		if(this.isEnabled.get() == null || !this.isEnabled.get()) return;
		if(this.root.get() == null) this.root.set(new CascadingProfile("", this.offset));
		if(this.sessions.get() == null) this.sessions.set(new Stack<>());
		
		CascadingProfile profile;
		
		if(this.sessions.get().isEmpty())
		{
			profile = this.root.get().getOrCreateSubProfile(name);
		}
		else
		{
			profile = this.sessions.get().peek().getProfile().getOrCreateSubProfile(name);
		}
		
		ProfilingSession session = profile.start();
		
		this.sessions.get().push(session);
	}
	
	public ProfilingSession startSession(String name)
	{
		if(this.isEnabled.get() == null || !this.isEnabled.get()) return new DummyProfilingSession();
		if(this.root.get() == null) this.root.set(new CascadingProfile("", this.offset));
		if(this.sessions.get() == null) this.sessions.set(new Stack<>());
		
		CascadingProfile profile;
		
		if(this.sessions.get().isEmpty())
		{
			profile = this.root.get().getOrCreateSubProfile(name);
		}
		else
		{
			profile = this.sessions.get().peek().getProfile().getOrCreateSubProfile(name);
		}
		
		ProfilingSession session = profile.start();
		
		this.sessions.get().push(session);
		return session;
	}
	
	public void stop(String name)
	{
		if(this.isEnabled.get() == null || !this.isEnabled.get()) return;
		this.sessions.get().peek().close();
	}
	
	public String toString()
	{
		if(this.isEnabled.get() == null || !this.isEnabled.get()) return "";
		StringBuilder builder = new StringBuilder();
		
		builder.append("PROFILER-RESULTS\n");
		builder.append("{\n");
		
		if(!this.root.get().getProfiles().isEmpty())
		{
			for(CascadingProfile p : this.root.get().getProfiles().values())
			{
				build(0, p, builder);
			}
		}
		
		builder.append("}\n");
		
		return builder.toString();
	}
	
	private void build(int indent, CascadingProfile profile, StringBuilder builder)
	{
		if(indent > 0)
			StringUtils.repeat("\t", indent, builder);
		
		builder.append(profile.name).append("\t")
			.append((profile.time / 1000000000.0)).append("s | ")
			.append(profile.time / 1000000.0).append("ms | ")
			.append(profile.time / 1000.0d).append("µs | ")
			.append(profile.time).append("ns")
			.append("\n");
		
		if(!profile.getProfiles().isEmpty())
		{
			for(CascadingProfile p : profile.profiles.values())
			{
				build(indent + 1, p, builder);
			}
		}
	}
	
	public void finished()
	{
		this.sessions.get().pop();
	}
	
	public class CascadingProfile
	{
		
		private Map<String,CascadingProfile> profiles = new HashMap<>();
		private long startTime;
		private double time;
		private String name;
		private double offset;
			
		public CascadingProfile(String name, double offset)
		{
			this.name = name;
			this.offset = offset;
		}
		
		public Map<String,CascadingProfile> getProfiles()
		{
			return this.profiles;
		}
		
		public CascadingProfile getOrCreateSubProfile(String name)
		{
			CascadingProfile profile;
			
			if(profiles.containsKey(name))
			{
				profile = this.profiles.get(name);
			}
			else
			{
				profile = new CascadingProfile(name, this.offset);
				this.profiles.put(name, profile);
			}
			
			return profile;
		}
		
		public ProfilingSession start()
		{
			this.startTime = System.nanoTime();
			
			return new ProfilingSession(this);
		}
		
		public void stop()
		{
			double newTime = System.nanoTime() - this.startTime;
			
			if(time == 0)
				time = newTime;
			
			if(newTime < time - offset || time + offset < newTime)
			{
				time = (time + newTime) * 0.5;
			}
			
			if(this.time > 0.0)
			{
				this.time = (this.time + newTime) / 2.0;
			}
			else
			{
				this.time = newTime;
			}
		}
		
		public double getTime()
		{
			return this.time;
		}
		
		public String getName()
		{
			return this.name;
		}
	}

	public class ProfilingSession implements Closeable
	{
		private CascadingProfile profile;

		public ProfilingSession(CascadingProfile profile)
		{
			this.profile = profile;
		}
		
		public CascadingProfile getProfile()
		{
			return this.profile;
		}
		
		@Override
		public void close()
		{
			this.profile.stop();
			finished();
		}
	}
	
	public class DummyProfilingSession extends ProfilingSession
	{

		public DummyProfilingSession()
		{
			super(null);
		}
		
		public void close() { }
	}
}
