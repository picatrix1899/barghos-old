import org.barghos.math.Maths;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec3fAxis;

public class Main
{

	public static void main(String[] args)
	{
		Vec3f v1 = new Vec3f(Vec3fAxis.AXIS_X);
		Vec3f v2 = new Vec3f(Vec3fAxis.AXIS_NY);
		Vec3f v3 = new Vec3f(Vec3fAxis.AXIS_NX);
		
		double cosAngle1 = getCos(v2, v1);
		double cosAngle2 = getCos(v2, v3);
		
		System.out.println(cosAngle1 * Maths.RAD_TO_DEG);
		System.out.println(cosAngle2 * Maths.RAD_TO_DEG);
	}
	
	public static double getCos(Vec3f a, Vec3f b)
	{
		double combinedLength = a.length() * b.length();
		Vec3f cross = Vec3f.cross(a, b, null);

		double sin = cross.length() / combinedLength;
		double cos = a.dot(b) / combinedLength;
		
		Vec3f n = cross.normal(null);
		
		double sign = n.dot(cross);
	
		double out = Math.atan2(sin, cos);
		
		if(sign < 0) out = -out;
		
		return out;
	}
}
