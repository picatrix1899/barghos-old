package org.barghos.math.pool;

import org.barghos.core.Check;
import org.barghos.core.LeakDetectionPool;
import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.math.vector.Vec3f;

public class Vec3fPool
{

	private static final Pool<Vec3f> pool = new LeakDetectionPool<Vec3f>(Vec3f.class);
	
	private Vec3fPool() { }
	
	public static void start() { ((LeakDetectionPool<Vec3f>) pool).startSession(); }
	public static void stop()
	{
		((LeakDetectionPool<Vec3f>) pool).stopSession(); 
	
		int leakage = ((LeakDetectionPool<Vec3f>) pool).leakedEntities();
		
		if(leakage > 0) System.out.println(leakage);
			
	}
	
	
	public static Vec3f get() { return pool.get().set(0.0); }
	public static Vec3f get(ITup3fR v) { assert(v != null); return pool.get().set(v); }
	public static Vec3f get(ITup3dR v) { assert(v != null); return pool.get().set(v); }
	public static Vec3f get(double scalar) { return pool.get().set(scalar); }
	public static Vec3f get(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void store(Vec3f... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
