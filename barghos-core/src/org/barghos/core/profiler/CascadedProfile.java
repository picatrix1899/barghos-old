package org.barghos.core.profiler;

import java.util.HashMap;
import java.util.Map;

import org.barghos.core.StringUtils;

public class CascadedProfile
{
	public Map<String,CascadedProfile> times = new HashMap<>();
	public double averageDuration;
	public String name;
	
	public void dump(StringBuilder builder, int level)
	{
		if(times.isEmpty())
		{
			StringUtils.repeat("\t", level, builder);
			builder.append(this.name);
			builder.append("\t");
			builder.append(this.averageDuration / 1000l).append("µs");
			builder.append("\t");
			builder.append(this.averageDuration / 1000000l).append("ms");
		}
	}
}
