import java.io.IOException;

import AnytoPOJO.UpdateXML;
import AnytoPOJO.XmltoString;
import DateTimeRelated.DateChanger;
import Resources.RandomValueGenerator;

public class Runner 
{
	public static void main(String args[]) throws IOException
	{
		/*String filepath = "question.xml";
		
		UpdateXML updateXML = new UpdateXML();
		updateXML.convert(filepath);
		
		XmltoString xmltoString = new XmltoString();
		System.out.println(xmltoString.converttoString(filepath));*/
		
		RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
		
		System.out.println(randomValueGenerator.generate(6));
	}
}
