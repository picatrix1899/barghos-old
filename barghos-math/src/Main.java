
import org.barghos.math.geometry.OBB3f;
import org.barghos.math.geometry.OBBOBBResolver;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Quat;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec3fAxis;

public class Main
{

	public static void main(String[] args)
	{
//		double angle = 97.5345345;
//		
//		double sin1 = Math.sin(angle * Maths.DEG_TO_RAD);
//		double sin2 = FastMath.sinDeg(angle);
//		
//		System.out.println(90 / FastMath.STEP);
//		System.out.println(((90 / FastMath.STEP * 8) / 1024 / 1024) + " MB");
//		System.out.println(sin1);
//		System.out.println(sin2);
//		
//		
//		System.out.println(Math.sqrt(2));
//		
//		Mat4f m = Mat4f.rotation(Quat.getFromAxis(Vec3fAxis.AXIS_Y, 40));
//		
//		System.out.println(m.getRow(0));
//		System.out.println(m.getRow(2));
//		System.out.println(m.transform(Vec3fAxis.AXIS_X,(Vec3f) null));
		
//		OBB3f a = new OBB3f(new Vec3f(0, 9, -31.5), new Vec3f(4, 9, 4), Mat4f.identity());
//		OBB3f b = new OBB3f(new Vec3f(0, 5, -40), new Vec3f(7, 5, 0), Mat4f.rotation(Quat.getFromAxis(Vec3fAxis.AXIS_Y, 45)));
//		
//		OBBOBBResolver.iOBBOBB3f(a, b);
		
		double c = -7500.000954;
		double v = -833.3333731;
		double r = c + v;
		
		float f = (float)c;
		
		double d1 = f;
		
		System.out.println(f);
		System.out.println(d1);
	}
}
