/**
 * 
 */
package mars.Business.Layer;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.xml.sax.SAXException;

/**
 * @author cdeyso
 *
 */
public class ReadXMLFile {
	
	/** The location of XML Config File */
	public static String xmlConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/XMLconfig.propertiess";
	
	/** The variable to store the location of the XML File to be read */
	public static String XML_filePath = null;
	
	/**
	 * Method to Read an XML File statically i.e hardcoding the values to be read from the File.
	 * 
	 */
	public static void readXMLFileStatic() {
		
		  try {

			  	XML_filePath = ReadPropertyFile.getInstance(xmlConfigFile).getProperty("xml_FILENAME");
				File fXmlFile = new File(XML_filePath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);

				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();

				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName("item_fully_qualified_reference");

				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
						System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
						System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
						System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		
	}
	
	/**
	 * TODO -- to create a method that gets all the elements inside a node in an XML File (Dynamic)
	 * @return 
	 * 
	 * 
	 */
	
	public static List<String> getXPATHData(Document doc, XPath xpath,String xmlXPath) {
		
		List<String> list = new ArrayList<>();
    	try {
            //create XPathExpression object
            XPathExpression expr =
                xpath.compile(xmlXPath); ///Data() -- /Plant/HighLevel/Node[@Name='Node0']/InputTo/text()
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
		
	}
	
	
	/**
	 * Method to get the Initialization done for all the Components for reading the XPath for the XML File
	 * 
	 * @param xmlFileLoc - The location of the desired XML File
	 * @param xmlXPath - The custom Xpath String directing to the desired Element to be read from the XML File
	 * @return Returns the List of values present at the mentioned node in the Xpath and blank if nothing is present.
	 */
	@SuppressWarnings("unused")
	private static List<String> readXMLFileUsingXPATH(String xmlFileLoc,String xmlXPath) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        List<String> names = new ArrayList<String>();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFileLoc);

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            
            names = getXPATHData(doc, xpath, xmlXPath);
            System.out.println("Values are :" + Arrays.toString(names.toArray()));

            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return names;
	}

	
	/**
	 * TODO -- to create a method that gets all the attributes inside an element in a node in an XML File (Dynamic)
	 */
}
