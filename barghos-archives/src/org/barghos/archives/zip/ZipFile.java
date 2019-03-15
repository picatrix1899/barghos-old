package org.barghos.archives.zip;

import java.io.File;
import java.io.IOException;
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
	
	public void extractFile(String file, String target, String targetFile)
	{
		ZipEntry ent = this.base.getEntry(file);
		
		File o = new File(target, ent.);
		
		InputStream in = this.base.getInputStream(ent);
		OutputStream out = new FileOutputStream()
	}
}
