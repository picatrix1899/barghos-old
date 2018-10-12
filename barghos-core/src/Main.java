import java.nio.FloatBuffer;

import org.barghos.core.BufferUtils;
import org.barghos.core.event.Event;
import org.barghos.core.event.NoArgs;

public class Main
{

	public static void main(String[] args)
	{
		float[] f = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f};
		
		FloatBuffer buffer = BufferUtils.wrapFlippedFloatBuffer(f);
		System.out.println(buffer);
		
		
		Event<NoArgs> test = new Event<NoArgs>();
		
	}

}
