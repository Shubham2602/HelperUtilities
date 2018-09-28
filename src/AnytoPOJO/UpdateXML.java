package AnytoPOJO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import DateTimeRelated.DateChanger;

public class UpdateXML 
{
	public void convert(String filepath, List<String> listOfNodesToBeChanged)
	{

	        try {
	        		        	
	        	DateChanger dateChanger = new DateChanger();
	        	
	        	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	    		Document doc = docBuilder.parse(filepath);

	    		NodeList list = doc.getChildNodes();
	    		List<Node> nodelist = (List<Node>) list;
	    		
	    		for(Node n : nodelist)
	    		{
	    			System.out.println(n.getNodeName());
	    		}
	    		
	    		System.out.println();
	    		
	    		for(String s : listOfNodesToBeChanged)
	    		{
	    			//NodeList list = doc.getChildNodes();
	    			
	    		}
	    		
	    		// Get the root element
	    		Node question = doc.getFirstChild();

	    		// Get the staff element by tag name directly
	    		Node answers = doc.getElementsByTagName("answers").item(0);
	    		
	    		//NodeList list = answers.getChildNodes();
	    		
	    		for (int i = 0; i < list.getLength(); i++) {
	    			
	                       Node node = list.item(i);

	    		   // get the salary element, and update the value
	    		   if ("date".equals(node.getNodeName())) {
	    			node.setTextContent(dateChanger.datechange());
	    		   }
	    		}

	    		// write the content into xml file
	    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    		Transformer transformer = transformerFactory.newTransformer();
	    		DOMSource source = new DOMSource(doc);
	    		StreamResult result = new StreamResult(new File(filepath));
	    		transformer.transform(source, result);

	    		System.out.println("Done");
	        } 
	        catch(Exception exp){
	        	exp.getMessage();
	        }
	}
	
	
}
