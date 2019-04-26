package org.barghos.archives.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class ZipFile
{
	private java.util.zip.ZipFile base;
	
	public ZipFile(String file) throws IOException
	{
		this.base = new java.util.zip.ZipFile(file);
	}
	
	public ZipFile(File file) throws ZipException, IOException
	{
		this.base = new java.util.zip.ZipFile(file);
	}
	
	public List<String> listEntries(String directory, boolean filesOnly)
	{
		List<String> out = new ArrayList<>();
		
		for(Enumeration<? extends ZipEntry> en = this.base.entries(); en.hasMoreElements();)
		{
			ZipEntry entry = en.nextElement();
			
			if((!directory.equals("") && entry.getName().startsWith(directory)) || directory.equals(""))
				if((filesOnly && !entry.isDirectory()) || !filesOnly)
					out.add(entry.getName());
		}
		
		return out;
	}
	
	public void extractFile(String file, String targetFile)
	{
		File f = new File(targetFile);

		this.base.
		
		extractFile(file, f);
	}
	
	public void extractFile(String file, File f)
	{
		if(!f.exists())
		{
			try
			{
				f.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try(OutputStream sout = new FileOutputStream(f))
		{
			extractFile(file, sout);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void extractFile(String file, OutputStream sout)
	{
		ZipEntry ent = this.base.getEntry(file);

		try(InputStream sin = this.base.getInputStream(ent))
		{
				byte[] buffer = new byte[sin.available()];
				sin.read(buffer);
				sout.write(buffer);
				sout.flush();
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
