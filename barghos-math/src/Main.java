
import org.barghos.math.FastMath;
import org.barghos.math.Maths;

public class Main
{

	public static void main(String[] args)
	{
		double angle = 97.5345345;
		
		double sin1 = Math.sin(angle * Maths.DEG_TO_RAD);
		double sin2 = FastMath.sinDeg(angle);
		
		System.out.println(90 / FastMath.STEP);
		System.out.println(((90 / FastMath.STEP * 8) / 1024 / 1024) + " MB");
		System.out.println(sin1);
		System.out.println(sin2);
	}
}
