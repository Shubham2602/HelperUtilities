package AnytoPOJO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmltoString 
{
	public StringBuilder converttoString(String filename) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
		    sb.append(line+"\n");
		}
		
		return sb;
	}
}
