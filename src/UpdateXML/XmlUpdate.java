package UpdateXML;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUpdate 
{
	public static void connectToXML()
	{
		Document doc=null;
		DocumentBuilder docBuilder;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
		docBuilder = docFactory.newDocumentBuilder();
		
		doc = docBuilder.parse("question.xml");
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NodeList list = doc.getChildNodes();
		Node node  = list.item(0);
		NodeList question_tag = node.getChildNodes();
		NodeList question = question_tag.item(1).getChildNodes();
		for(int i=0;i<question.getLength();i++)
		{
			if(question.item(i).getNodeName().equalsIgnoreCase("id"))
			{
				NodeList id_list = question.item(i).getChildNodes();
				for(int j = 0;j<id_list.getLength();j++)
				{
					id_list.item(j).setTextContent("//Set value from DB here");
				}
			}
		}
		
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("question.xml")));
		} catch (Exception e) {
			System.out.println("Issue");
		}
		
	}
	
	public static void main(String[] args)
	{
		connectToXML();
	}
}
