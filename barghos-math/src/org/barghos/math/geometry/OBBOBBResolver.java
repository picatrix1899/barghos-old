package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;

public class OBBOBBResolver
{
	public static boolean iOBBOBB3f(OBB3f a, OBB3f b)
	{
		Point3f aCenter = a.getCenter();
		Point3f bCenter = b.getCenter();
		
		Mat4f modelSpaceA = a.getModelSpaceMatrix();
		Mat4f modelSpaceB = b.getModelSpaceMatrix();
		
		PointSet3f aInSpaceA = a.getTransformedPointSet(modelSpaceA);
		PointSet3f bInSpaceA = b.getTransformedPointSet(modelSpaceA);

		double aMinX = aInSpaceA.getMinX();
		double aMaxX = aInSpaceA.getMaxX();

		double bMinX = bInSpaceA.getMinX();
		double bMaxX = bInSpaceA.getMaxX();

		double aMinY = aInSpaceA.getMinY();
		double aMaxY = aInSpaceA.getMaxY();

		double bMinY = bInSpaceA.getMinY();
		double bMaxY = bInSpaceA.getMaxY();

		double aMinZ = aInSpaceA.getMinZ();
		double aMaxZ = aInSpaceA.getMaxZ();

		double bMinZ = bInSpaceA.getMinZ();
		double bMaxZ = bInSpaceA.getMaxZ();
		
		double aPNX = Vec3f.dot(aCenter, modelSpaceA.getRow(0));
		double bPNX = Vec3f.dot(bCenter, modelSpaceA.getRow(0));
		double aPNY = Vec3f.dot(aCenter, modelSpaceA.getRow(1));
		double bPNY = Vec3f.dot(bCenter, modelSpaceA.getRow(1));
		double aPNZ = Vec3f.dot(aCenter, modelSpaceA.getRow(2));
		double bPNZ = Vec3f.dot(bCenter, modelSpaceA.getRow(2));

		if(aPNX < bPNX)
		{
			if(!(aMaxX > bMinX))
				return false;
		}
		else
		{
			if(!(bMaxX > aMinX))
				return false;
		}
		
		if(aPNY < bPNY)
		{
			if(!(aMaxY > bMinY))
				return false;
		}
		else
		{
			if(!(bMaxY > aMinY))
				return false;
		}
		
		if(aPNZ < bPNZ)
		{
			if(!(aMaxZ > bMinZ))
				return false;
		}
		else
		{
			if(!(bMaxZ > aMinZ))
				return false;
		}

		PointSet3f aInSpaceB = a.getTransformedPointSet(modelSpaceB);
		PointSet3f bInSpaceB = b.getTransformedPointSet(modelSpaceB);
		
		aMinX = aInSpaceB.getMinX();
		aMaxX = aInSpaceB.getMaxX();
		
		bMinX = bInSpaceB.getMinX();
		bMaxX = bInSpaceB.getMaxX();
		
		aMinY = aInSpaceB.getMinY();
		aMaxY = aInSpaceB.getMaxY();
		
		bMinY = bInSpaceB.getMinY();
		bMaxY = bInSpaceB.getMaxY();
		
		aMinZ = aInSpaceB.getMinZ();
		aMaxZ = aInSpaceB.getMaxZ();
		
		bMinZ = bInSpaceB.getMinZ();
		bMaxZ = bInSpaceB.getMaxZ();
		
		aPNX = Vec3f.dot(aCenter, modelSpaceB.getRow(0));
		bPNX = Vec3f.dot(bCenter, modelSpaceB.getRow(0));
		aPNY = Vec3f.dot(aCenter, modelSpaceB.getRow(1));
		bPNY = Vec3f.dot(bCenter, modelSpaceB.getRow(1));
		aPNZ = Vec3f.dot(aCenter, modelSpaceB.getRow(2));
		bPNZ = Vec3f.dot(bCenter, modelSpaceB.getRow(2));
		
		if(aPNX < bPNX)
		{
			if(!(aMaxX > bMinX))
				return false;
		}
		else
		{
			if(!(bMaxX > aMinX))
				return false;
		}
		
		if(aPNY < bPNY)
		{
			if(!(aMaxY > bMinY))
				return false;
		}
		else
		{
			if(!(bMaxY > aMinY))
				return false;
		}
		
		if(aPNZ < bPNZ)
		{
			if(!(aMaxZ > bMinZ))
				return false;
		}
		else
		{
			if(!(bMaxZ > aMinZ))
				return false;
		}
		
		return true;
	}
	
	public static Vec3f rOBBOBB3f(OBB3f a, OBB3f b)
	{
		Point3f aCenter = a.getCenter();
		Point3f bCenter = b.getCenter();
		
		Mat4f modelSpaceA = a.getModelSpaceMatrix();

		PointSet3f aInSpaceA = a.getTransformedPointSet(modelSpaceA);
		PointSet3f bInSpaceA = b.getTransformedPointSet(modelSpaceA);
		
		double aMinX = aInSpaceA.getMinX();
		double aMaxX = aInSpaceA.getMaxX();
		
		double bMinX = bInSpaceA.getMinX();
		double bMaxX = bInSpaceA.getMaxX();
		
		double aMinY = aInSpaceA.getMinY();
		double aMaxY = aInSpaceA.getMaxY();
		
		double bMinY = bInSpaceA.getMinY();
		double bMaxY = bInSpaceA.getMaxY();
		
		double aMinZ = aInSpaceA.getMinZ();
		double aMaxZ = aInSpaceA.getMaxZ();
		
		double bMinZ = bInSpaceA.getMinZ();
		double bMaxZ = bInSpaceA.getMaxZ();

		double aPNX = Vec3f.dot(aCenter, modelSpaceA.getRow(0));
		double bPNX = Vec3f.dot(bCenter, modelSpaceA.getRow(0));
		double aPNY = Vec3f.dot(aCenter, modelSpaceA.getRow(1));
		double bPNY = Vec3f.dot(bCenter, modelSpaceA.getRow(1));
		double aPNZ = Vec3f.dot(aCenter, modelSpaceA.getRow(2));
		double bPNZ = Vec3f.dot(bCenter, modelSpaceA.getRow(2));
		
		double valAX = 0;
		int signAX = 0;
		double valAY = 0;
		int signAY = 0;
		double valAZ = 0;
		int signAZ = 0;
		double valBX = 0;
		int signBX = 0;
		double valBY = 0;
		int signBY = 0;
		double valBZ = 0;
		int signBZ = 0;
		
		if(aPNX < bPNX)
		{
			if(aMaxX > bMinX)
			{
				valAX = aMaxX - bMinX;
				signAX = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxX > aMinX)
			{
				valAX = bMaxX - aMinX;
				signAX = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		if(aPNY < bPNY)
		{
			if(aMaxY > bMinY)
			{
				valAY = aMaxY - bMinY;
				signAY = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxY > aMinY)
			{
				valAY = bMaxY - aMinY;
				signAY = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		if(aPNZ < bPNZ)
		{
			if(aMaxZ > bMinZ)
			{
				valAZ = aMaxZ - bMinZ;
				signAZ = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxZ > aMinZ)
			{
				valAZ = bMaxZ - aMinZ;
				signAZ = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		Mat4f modelSpaceB = b.getModelSpaceMatrix();
		
		PointSet3f aInSpaceB = a.getTransformedPointSet(modelSpaceB);
		PointSet3f bInSpaceB = b.getTransformedPointSet(modelSpaceB);
		
		aMinX = aInSpaceB.getMinX();
		aMaxX = aInSpaceB.getMaxX();
		
		bMinX = bInSpaceB.getMinX();
		bMaxX = bInSpaceB.getMaxX();
		
		aMinY = aInSpaceB.getMinY();
		aMaxY = aInSpaceB.getMaxY();
		
		bMinY = bInSpaceB.getMinY();
		bMaxY = bInSpaceB.getMaxY();
		
		aMinZ = aInSpaceB.getMinZ();
		aMaxZ = aInSpaceB.getMaxZ();
		
		bMinZ = bInSpaceB.getMinZ();
		bMaxZ = bInSpaceB.getMaxZ();
		
		aPNX = Vec3f.dot(aCenter, modelSpaceB.getRow(0));
		bPNX = Vec3f.dot(bCenter, modelSpaceB.getRow(0));
		aPNY = Vec3f.dot(aCenter, modelSpaceB.getRow(1));
		bPNY = Vec3f.dot(bCenter, modelSpaceB.getRow(1));
		aPNZ = Vec3f.dot(aCenter, modelSpaceB.getRow(2));
		bPNZ = Vec3f.dot(bCenter, modelSpaceB.getRow(2));
		
		if(aPNX < bPNX)
		{
			if(aMaxX > bMinX)
			{
				valBX = aMaxX - bMinX;
				signBX = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxX > aMinX)
			{
				valBX = bMaxX - aMinX;
				signBX = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		if(aPNY < bPNY)
		{
			if(aMaxY > bMinY)
			{
				valBY = aMaxY - bMinY;
				signBY = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxY > aMinY)
			{
				valBY = bMaxY - aMinY;
				signBY = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		if(aPNZ < bPNZ)
		{
			if(aMaxZ > bMinZ)
			{
				valBZ = aMaxZ - bMinZ;
				signBZ = -1;
			}
			else
			{
				return new Vec3f();
			}
		}
		else
		{
			if(bMaxZ > aMinZ)
			{
				valBZ = bMaxZ - aMinZ;
				signBZ = 1;
			}
			else
			{
				return new Vec3f();
			}
		}
		
		Vec3f[] v = new Vec3f[6];
		
		Vec3f axisAX = new Vec3f(modelSpaceA.getRow(0).getUniX(), modelSpaceA.getRow(0).getUniY(), modelSpaceA.getRow(0).getUniZ());
		Vec3f axisAY = new Vec3f(modelSpaceA.getRow(1).getUniX(), modelSpaceA.getRow(1).getUniY(), modelSpaceA.getRow(1).getUniZ());
		Vec3f axisAZ = new Vec3f(modelSpaceA.getRow(2).getUniX(), modelSpaceA.getRow(2).getUniY(), modelSpaceA.getRow(2).getUniZ());
		Vec3f axisBX = new Vec3f(modelSpaceB.getRow(0).getUniX(), modelSpaceB.getRow(0).getUniY(), modelSpaceB.getRow(0).getUniZ());
		Vec3f axisBY = new Vec3f(modelSpaceB.getRow(1).getUniX(), modelSpaceB.getRow(1).getUniY(), modelSpaceB.getRow(1).getUniZ());
		Vec3f axisBZ = new Vec3f(modelSpaceB.getRow(2).getUniX(), modelSpaceB.getRow(2).getUniY(), modelSpaceB.getRow(2).getUniZ());
		
		v[0] = Vec3f.mul(axisAX, valAX * signAX, null);
		v[1] = Vec3f.mul(axisAY, valAY * signAY, null);
		v[2] = Vec3f.mul(axisAZ, valAZ * signAZ, null);
		
		v[3] = Vec3f.mul(axisBX, valBX * signBX, null);
		v[4] = Vec3f.mul(axisBY, valBY * signBY, null);
		v[5] = Vec3f.mul(axisBZ, valBZ * signBZ, null);
		
		int index = 0;

		double min = Double.MAX_VALUE;
		Vec3f c;
		double sq;
		
		for(int i = 0; i < 6; i++)
		{
			c = v[i];
			sq = c.squaredLength();
			
			if(sq < min)
			{
				min = sq;
				index = i;
			}
		}
		
		return v[index];
	}
}
