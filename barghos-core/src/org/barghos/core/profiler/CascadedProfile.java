package org.barghos.core.profiler;

import java.util.HashMap;
import java.util.Map;

public class CascadedProfile
{
	public Map<String,CascadedProfile> times = new HashMap<>();
	public long averageDuration;
}
