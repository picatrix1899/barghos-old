package org.barghos.math.vector;

import org.barghos.math.vector.vec3.Vec3;

public class VectorInterpolation
{
	public static Vec3 lerp(Vec3 v1, Vec3 v2, float alpha, Vec3 res)
	{
		if(res == null) res = new Vec3();
		
		res.setX(v1.getX() + alpha * (v2.getX() - v1.getX()));
		res.setY(v1.getY() + alpha * (v2.getY() - v1.getY()));
		res.setZ(v1.getZ() + alpha * (v2.getZ() - v1.getZ()));
		
		return res;
	}
	
	public static Quat lerp(Quat q1, Quat q2, float alpha, Quat res)
	{
		if(res == null) res = new Quat();
		
		res.setX(q1.getX() + alpha * (q2.getX() - q1.getX()));
		res.setY(q1.getY() + alpha * (q2.getY() - q1.getY()));
		res.setZ(q1.getZ() + alpha * (q2.getZ() - q1.getZ()));
		res.setW(q1.getW() + alpha * (q2.getW() - q1.getW()));
		
		return res.normal();
	}
	
	public static Quat slerp(Quat q1, Quat q2, float alpha, Quat res)
	{
		if(res == null) res = new Quat();
		
		q1 = q1.normal(QuatPool.get());
		q2 = q2.normal(QuatPool.get());
		
		float dot = q1.dot(q2);
		
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
			float theta_0 = (float)Math.acos(dot);
			float theta = theta_0 * alpha;
			float sin_theta = (float)Math.sin(theta);
			float sin_theta_0 = (float)Math.sin(theta_0);
			
			float s0 = (float)Math.cos(theta) - dot * sin_theta / sin_theta_0;
			float s1 = sin_theta / sin_theta_0;
			
			res.x = q1.x * s0 + q2.x * s1;
			res.y = q1.y * s0 + q2.y * s1;
			res.z = q1.z * s0 + q2.z * s1;
			res.w = q1.w * s0 + q2.w * s1;
		}
		
		QuatPool.store(q1, q2);
		
		return res.normal();
	}
}
