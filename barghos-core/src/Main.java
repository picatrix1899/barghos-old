import org.barghos.core.tuple.tuple2.Tup2fPool;
import org.barghos.core.tuple.tuple2.api.ITup2f;
import org.barghos.core.tuple.tuple2.api.Tup2;

public class Main
{

	public static void main(String[] args)
	{
		ITup2f t = (ITup2f)Tup2fPool.get();
		Tup2 t2 = t;
		
		Tup2fPool.store(t);
	}

}
