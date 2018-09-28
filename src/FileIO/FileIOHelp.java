package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
						if(file.isFile() && file.getName().equalsIgnoreCase(fileToBeCopied))
						{
							System.out.println("File confirmed for copy");
							if(destination.isDirectory())
							{
								String command = "xcopy "+source.getPath()+" "+destination.getPath(); 
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
}
