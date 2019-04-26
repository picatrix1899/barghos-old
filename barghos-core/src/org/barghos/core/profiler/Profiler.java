package org.barghos.core.profiler;

import java.util.HashMap;
import java.util.Map;

public class Profiler
{
	private Map<String, Profile> profiles = new HashMap<>();
	
	public Profiler()
	{
		
	}
	
	public void StartProfile(String profile)
	{
		if(!profiles.containsKey(profile)) this.profiles.put(profile, new Profile());
		
		this.profiles.get(profile).start();
	}
	
	public void StopProfile(String profile)
	{
		this.profiles.get(profile).stop();
	}
	
	public String dump()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("PROFILER-RESULTS\n");
		builder.append("{\n");
		
		for(Map.Entry<String,Profile> set : profiles.entrySet())
		{
			builder.append("\t").append(set.getKey()).append("\t\t").append(set.getValue().getAverageTime()).append("ns\t\t").append((set.getValue().getAverageTime() / 1000l)).append("µs\t\t").append((set.getValue().getAverageTime() / 1000000l)).append("ms\n");	
		}
		
		builder.append("}\n");
		
		return builder.toString();
	}
}
