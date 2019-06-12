package org.barghos.math.vector;


public class VectorInterpolation
{
	public static Vec3f lerp(Vec3f v1, Vec3f v2, double alpha, Vec3f res)
	{
		if(res == null) res = new Vec3f();
		
		res.x = (float)(v1.x + alpha * (v2.x - v1.x));
		res.y = (float)(v1.y + alpha * (v2.y - v1.y));
		res.z = (float)(v1.z + alpha * (v2.z - v1.z));
		
		return res;
	}
	
	public static Quat lerp(Quat q1, Quat q2, double alpha, Quat res)
	{
		if(res == null) res = new Quat();
		
		res.x = (float)(q1.x + alpha * (q2.x - q1.x));
		res.y = (float)(q1.y + alpha * (q2.y - q1.y));
		res.z = (float)(q1.z + alpha * (q2.z - q1.z));
		res.w = (float)(q1.w + alpha * (q2.w - q1.w));
		
		return res.normal();
	}
	
	public static Quat slerp(Quat q1, Quat q2, double alpha, Quat res)
	{
		if(res == null) res = new Quat();

		q1 = q1.normal(null);
		q2 = q2.normal(null);
		
		double dot = q1.dot(q2);
		
		if(dot < 0)
		{
			q1 = q1.inverse();
			dot = -dot;
		}

		if(dot > 0.9995)
		{
			lerp(q1, q2, alpha, res);
		}
		else
		{
			double theta_0 = Math.acos(dot);
			double theta = theta_0 * alpha;
			double sin_theta = Math.sin(theta);
			double sin_theta_0 = Math.sin(theta_0);
			
			double s0 = Math.cos(theta) - dot * sin_theta / sin_theta_0;
			double s1 = sin_theta / sin_theta_0;
			
			res.x = q1.x * s0 + q2.x * s1;
			res.y = q1.y * s0 + q2.y * s1;
			res.z = q1.z * s0 + q2.z * s1;
			res.w = q1.w * s0 + q2.w * s1;
		}
		
		return res;
	}
}
