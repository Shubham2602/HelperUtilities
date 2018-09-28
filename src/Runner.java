import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AnytoPOJO.UpdateXML;
import AnytoPOJO.XmltoString;
import DateTimeRelated.DateChanger;
import FileIO.FileIOHelp;
import Resources.RandomValueGenerator;

public class Runner 
{
	public static void main(String args[]) throws IOException
	{
		UpdateXML updateXML = new UpdateXML();
		List<String> list = new ArrayList<String>();
		
		list.add("answers");
		updateXML.convert("question.xml",list);
		
		XmltoString xmltoString = new XmltoString();
		System.out.println(xmltoString.converttoString("question.xml"));
		
		RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
		
		System.out.println(randomValueGenerator.generate(6));
		
	
	
		List<String> listOfFilesToBeCopied = new ArrayList<String>();
		listOfFilesToBeCopied.add("Word1.docx");
		listOfFilesToBeCopied.add("Notepad1.txt");
		
		File source = new File("F:\\Champions\\source");
		File destination = new File("F:\\IEDriverServer.exe");
		
		FileIOHelp fileIOHelp = new FileIOHelp();
		
		fileIOHelp.fileToDirectoryCopier(source, destination, listOfFilesToBeCopied);
		
	}
}
