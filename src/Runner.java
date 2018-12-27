import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import AnytoPOJO.UpdateXML;
import AnytoPOJO.XmltoString;
import DateTimeRelated.DateAsYouLike;
import DateTimeRelated.DateChanger;
import FileIO.FileIOHelp;
import Resources.DBCOnn;
import Resources.RandomValueGenerator;

public class Runner 
{
	public static void main(String args[]) throws IOException, SQLException
	{
	/*	UpdateXML updateXML = new UpdateXML();
		List<String> list = new ArrayList<String>();
		
		list.add("answers");
		updateXML.convert("question.xml",list);
		
		XmltoString xmltoString = new XmltoString();
		System.out.println(xmltoString.converttoString("question.xml"));
		
		RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
		
		System.out.println(randomValueGenerator.generate(6));
		
	*/
	
		List<String> listOfFilesToBeCopied = new ArrayList<String>();
		listOfFilesToBeCopied.add("Word1.docx");
		listOfFilesToBeCopied.add("Notepad1.txt");
		
		File source = new File("F:\\Champions\\source");
		File destination = new File("F:\\FFOutput");
		
		FileIOHelp fileIOHelp = new FileIOHelp();
		
		fileIOHelp.fileToDirectoryCopier(source, destination, listOfFilesToBeCopied);
		
		/*FileIOHelp fileIOHelp = new FileIOHelp();
		File configFile = new File("Config.properties");
		
		Map<String,String> map = fileIOHelp.propertyFileReader(configFile);
		
		System.out.println(map.get("id"));*/
		
		/*DateAsYouLike dt = new DateAsYouLike();
	
		String statement = "payt20181007786543";
		
		Map<String,String> map = dt.statementFragmenter(statement);
		
		System.out.println(map.get("yymmdd"));
		System.out.println(map.get("mmdd"));
*/	
		StringBuffer sb = new StringBuffer();
		
		DBCOnn db = new DBCOnn();
		String ls = db.connect("select st from statement");
		/*
		for(String s : ls)
		{
			String statement = s;
			DateAsYouLike dt = new DateAsYouLike();
			Map<String,String> map = dt.statementFragmenter(statement);
			
			sb.append("//$"+map.get("yymmdd")+":"+map.get("mmdd"));
		}
		*/
		
	}
}
