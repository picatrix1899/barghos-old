package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;

public class OBBOBBResolver
{
	public static boolean iOBBOBB3f(OBB3f a, OBB3f b)
	{
		Point3 aCenter = a.getCenter();
		Point3 bCenter = b.getCenter();
		
		Mat4f modelSpaceA = a.getModelSpaceMatrix();
		Mat4f modelSpaceB = b.getModelSpaceMatrix();
		
		PointSet3f aInSpaceA = a.getTransformedPointSet(modelSpaceA);
		PointSet3f bInSpaceA = b.getTransformedPointSet(modelSpaceA);

		float aMinX = aInSpaceA.getMinX();
		float aMaxX = aInSpaceA.getMaxX();

		float bMinX = bInSpaceA.getMinX();
		float bMaxX = bInSpaceA.getMaxX();

		float aMinY = aInSpaceA.getMinY();
		float aMaxY = aInSpaceA.getMaxY();

		float bMinY = bInSpaceA.getMinY();
		float bMaxY = bInSpaceA.getMaxY();

		float aMinZ = aInSpaceA.getMinZ();
		float aMaxZ = aInSpaceA.getMaxZ();

		float bMinZ = bInSpaceA.getMinZ();
		float bMaxZ = bInSpaceA.getMaxZ();
		
		float aPNX = aCenter.dot(modelSpaceA.getRow(0));
		float bPNX = bCenter.dot(modelSpaceA.getRow(0));
		float aPNY = aCenter.dot(modelSpaceA.getRow(1));
		float bPNY = bCenter.dot(modelSpaceA.getRow(1));
		float aPNZ = aCenter.dot(modelSpaceA.getRow(2));
		float bPNZ = bCenter.dot(modelSpaceA.getRow(2));

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
		
		aPNX = aCenter.dot(modelSpaceB.getRow(0));
		bPNX = bCenter.dot(modelSpaceB.getRow(0));
		aPNY = aCenter.dot(modelSpaceB.getRow(1));
		bPNY = bCenter.dot(modelSpaceB.getRow(1));
		aPNZ = aCenter.dot(modelSpaceB.getRow(2));
		bPNZ = bCenter.dot(modelSpaceB.getRow(2));
		
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
	
	public static Vec3 rOBBOBB3f(OBB3f a, OBB3f b)
	{
		Point3 aCenter = a.getCenter();
		Point3 bCenter = b.getCenter();
		
		Mat4f modelSpaceA = a.getModelSpaceMatrix();

		PointSet3f aInSpaceA = a.getTransformedPointSet(modelSpaceA);
		PointSet3f bInSpaceA = b.getTransformedPointSet(modelSpaceA);
		
		float aMinX = aInSpaceA.getMinX();
		float aMaxX = aInSpaceA.getMaxX();
		
		float bMinX = bInSpaceA.getMinX();
		float bMaxX = bInSpaceA.getMaxX();
		
		float aMinY = aInSpaceA.getMinY();
		float aMaxY = aInSpaceA.getMaxY();
		
		float bMinY = bInSpaceA.getMinY();
		float bMaxY = bInSpaceA.getMaxY();
		
		float aMinZ = aInSpaceA.getMinZ();
		float aMaxZ = aInSpaceA.getMaxZ();
		
		float bMinZ = bInSpaceA.getMinZ();
		float bMaxZ = bInSpaceA.getMaxZ();

		float aPNX = aCenter.dot(modelSpaceA.getRow(0));
		float bPNX = bCenter.dot(modelSpaceA.getRow(0));
		float aPNY = aCenter.dot(modelSpaceA.getRow(1));
		float bPNY = bCenter.dot(modelSpaceA.getRow(1));
		float aPNZ = aCenter.dot(modelSpaceA.getRow(2));
		float bPNZ = bCenter.dot(modelSpaceA.getRow(2));
		
		float valAX = 0;
		int signAX = 0;
		float valAY = 0;
		int signAY = 0;
		float valAZ = 0;
		int signAZ = 0;
		float valBX = 0;
		int signBX = 0;
		float valBY = 0;
		int signBY = 0;
		float valBZ = 0;
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
		
		aPNX = aCenter.dot(modelSpaceB.getRow(0));
		bPNX = bCenter.dot(modelSpaceB.getRow(0));
		aPNY = aCenter.dot(modelSpaceB.getRow(1));
		bPNY = bCenter.dot(modelSpaceB.getRow(1));
		aPNZ = aCenter.dot(modelSpaceB.getRow(2));
		bPNZ = bCenter.dot(modelSpaceB.getRow(2));
		
		if(aPNX < bPNX)
		{
			if(aMaxX > bMinX)
			{
				valBX = aMaxX - bMinX;
				signBX = -1;
			}
			else
			{
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
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
				return new Vec3();
			}
		}
		
		Vec3[] v = new Vec3[6];
		
		Vec3 axisAX = new Vec3(modelSpaceA.getRow(0).getX(), modelSpaceA.getRow(0).getY(), modelSpaceA.getRow(0).getZ());
		Vec3 axisAY = new Vec3(modelSpaceA.getRow(1).getX(), modelSpaceA.getRow(1).getY(), modelSpaceA.getRow(1).getZ());
		Vec3 axisAZ = new Vec3(modelSpaceA.getRow(2).getX(), modelSpaceA.getRow(2).getY(), modelSpaceA.getRow(2).getZ());
		Vec3 axisBX = new Vec3(modelSpaceB.getRow(0).getX(), modelSpaceB.getRow(0).getY(), modelSpaceB.getRow(0).getZ());
		Vec3 axisBY = new Vec3(modelSpaceB.getRow(1).getX(), modelSpaceB.getRow(1).getY(), modelSpaceB.getRow(1).getZ());
		Vec3 axisBZ = new Vec3(modelSpaceB.getRow(2).getX(), modelSpaceB.getRow(2).getY(), modelSpaceB.getRow(2).getZ());
		
		v[0] = axisAX.mul(valAX * signAX, null);
		v[1] = axisAY.mul(valAY * signAY, null);
		v[2] = axisAZ.mul(valAZ * signAZ, null);
		
		v[3] = axisBX.mul(valBX * signBX, null);
		v[4] = axisBY.mul(valBY * signBY, null);
		v[5] = axisBZ.mul(valBZ * signBZ, null);
		
		int index = 0;

		double min = Double.MAX_VALUE;
		Vec3 c;
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
