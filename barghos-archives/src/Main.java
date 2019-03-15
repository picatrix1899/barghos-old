import java.io.IOException;
import java.util.List;

import org.barghos.archives.zip.ZipFile;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
			ZipFile f = new ZipFile("test.zip");
			
			List<String> s = f.listEntries("", true);
			
			for(String ss : s)
			{
				System.out.println(ss);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
