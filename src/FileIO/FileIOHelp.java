package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FileIOHelp 
{
	public void fileToDirectoryCopier(File source,File destination, List<String> filesToBeCopied) throws IOException
	{

		System.out.println("Copying from one folder to another");
		if(source.isDirectory())
			{
				System.out.println("Inside source directory");
				File[] allFiles = source.listFiles();
				for(File file : allFiles)
				{
					System.out.println("Copying file : " + file.getName());
					for(String fileToBeCopied : filesToBeCopied)
					{
						if(file.isFile() && file.getAbsolutePath().contains(fileToBeCopied))
						{
							System.out.println("File confirmed for copy");
							if(destination.isDirectory())
							{
								String command = "xcopy "+file.getAbsolutePath()+" "+destination.getPath(); 
								Process process = Runtime.getRuntime().exec(command);
								System.out.println("File " + file.getName() + " was copied");
							}
							else
								System.out.println("Destination is not a directory");
							
						}
					}
				}
			}
	}
	
	public Map<String,String> propertyFileReader(File propertyFile) throws FileNotFoundException, IOException
	{
		Map<String,String> properties = new HashMap<String,String>();
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(propertyFile));
		
		Iterator itr = prop.keySet().iterator();
		while(itr.hasNext())	
		{
			String key = itr.next().toString();
			properties.put(key,prop.getProperty(key));
		}
		return properties;
	}
	
	
}
