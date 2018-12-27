package UpdateXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class Pranay 
{

		
		public static DocumentBuilderFactory docFcatory=null;
		public static  DocumentBuilder docBuilder=null;
		public static  Document doc=null;
		
		public static  String fileWrite="F:\\xmlFile.xml";
		
		  public static void main(String[] arg) throws Throwable {
			  
			  try{
				  docFcatory=DocumentBuilderFactory.newInstance();
				  docBuilder=docFcatory.newDocumentBuilder();
				  doc=docBuilder.newDocument();
				  
				  Element root=doc.createElement("S2SDDDnf:MPEDDDnfBlkDirDeb");
				  
				  root.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:schemaLocation", "urn:S2SDDDnf:xsd:$MPESSSnfBlkDirDeb MPESSSnfBlkDirDeb.xsd");
				  root.setAttribute("xmlns:S2SDDDnf", "urn:S2SDDDnf:xsd:$MPEDDDnfBlkDirDeb");
				  root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
				  
//				  Element one=doc.createElement("S2SDDDnf:SndgInst");
//				  one.appendChild(doc.createAttribute("EBAPFRPAXXX"));
//				  root.appendChild(one);
				
				  doc.appendChild(root);
				  TransformerFactory transformerFactory=TransformerFactory.newInstance();
				  Transformer transformer=transformerFactory.newTransformer();
				  DOMSource source=new DOMSource(doc);
				  StreamResult result=new StreamResult(new File(fileWrite));
				  transformer.transform(source, result);
				  System.out.println("File is created");
			  }
			  catch(Exception e){
				  System.out.println(e.getMessage());
			  }
			  
			  }
	}


