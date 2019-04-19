package commonFunctionsAPI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class CommonAPI_Functions {
	public static Properties properties;
	public static String FILENAME = "";
	private static ExtentTest logger = null;

	public CommonAPI_Functions(ExtentTest logger) {
		this.logger = logger;
	}

	public static void Get_API_Request(String URI, String Authorization, String methodName) throws Exception {
		logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).get(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile(APIResponse, methodName);
		logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");
	}

	public static void Get_API_Request(String URI, Header header_content_type, String methodName) throws Exception {
		logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header(header_content_type).get(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_XMLfile(APIResponse, methodName);
		// logger.log(LogStatus.INFO, "<object type='application/json'
		// data='"+FILENAME+"' width='100%' height='100%'
		// JSON.stringify(data)></object>");
	}

	// Overloaded for CEP Project
	public static void Get_API_Request(String URI, String Authorization, String HeaderParameter1,
			String HeaderParameterValue1, String HeaderParameter2, String HeaderParameterValue2, String methodName)
			throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				//.urlEncodingEnabled(false)
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).header(HeaderParameter1, HeaderParameterValue1)
				.header(HeaderParameter2, HeaderParameterValue2).get(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
		logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");
	}
	public static int responseCode=0;
	// Overloaded for CEP Project
	public static void Get_API_Request_TimeSeries(String URI, String Authorization, String HeaderParameter1,
			String HeaderParameterValue1, String HeaderParameter2, String HeaderParameterValue2, String methodName)
			throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).header(HeaderParameter1, HeaderParameterValue1)
				.header(HeaderParameter2, HeaderParameterValue2).get(URI);
		responseCode = API_response.getStatusCode();
		if (API_response.getStatusCode() == 200) {
			System.out.println(API_response.getStatusCode());
			String APIResponse = API_response.asString();
			WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
			//logger.log(LogStatus.PASS, "ResponseCode for TimeSeries API is " + API_response.getStatusCode());
		} else {
		//	throw new Exception("ResponseCode for TimeSeries API is " + API_response.getStatusCode());
		}
		/*logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");*/
	}
	public static int Get_API_ResponseCode_TimeSeries(String URI, String Authorization, String HeaderParameter1,
			String HeaderParameterValue1, String HeaderParameter2, String HeaderParameterValue2, String methodName)
			throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).header(HeaderParameter1, HeaderParameterValue1)
				.header(HeaderParameter2, HeaderParameterValue2).get(URI);
	/*	if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}*/
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
		return API_response.getStatusCode();
		/*logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");*/
	}
	// Overloaded for CEP Project
	public static void Get_API_Request_TimeSeries(String URI,String methodName)
			throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.get(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
		/*logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");*/
	}
	// Overloaded for CEP Project
	public static String POST_API_Request(String URI, String Authorization, String header_content_type,
			String request_body, String methodName) throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).and().header("content-type", header_content_type)
				.body(request_body).post(URI);
		if (API_response.getStatusCode() == 200) {
			System.out.println(API_response.getStatusCode());
			//logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
		logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");
		return API_response.asString();
	}
	
	public static String POST_API_Request(String URI, String header_content_type,
			String request_body, String methodName) throws Exception {
		//logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("content-type", header_content_type)
				.body(request_body).post(URI);
		if (API_response.getStatusCode() == 200) {
			System.out.println(API_response.getStatusCode());
			//logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile_CEP(APIResponse, methodName);
		/*logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");*/
		return API_response.asString();
	}
	
	public static String POST_API_Request(String URI, String Authorization, Header header_content_type,
			String request_body, String methodName) throws Exception {
		logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header("Authorization", Authorization).and().header(header_content_type).body(request_body).post(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_Jsonfile(APIResponse, methodName);
		logger.log(LogStatus.INFO, "<object type='application/json' data='" + FILENAME
				+ "' width='100%' height='100%' JSON.stringify(data)></object>");
		return API_response.asString();
	}

	public static String POST_API_Request(String URI, Header header_content_type, String request_body,
			String methodName) throws Exception {
		logger.log(LogStatus.PASS, "Execution for " + methodName + " has started");
		Response API_response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.header(header_content_type).body(request_body).post(URI);
		if (API_response.getStatusCode() == 200) {
			logger.log(LogStatus.PASS, "ResponseCode for API is " + API_response.getStatusCode());
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		String APIResponse = API_response.asString();
		WriteAPI_Response_to_XMLfile(APIResponse, methodName);
		// logger.log(LogStatus.INFO, "<object type='application/xml'
		// data='"+FILENAME+"' width='100%' height='100%'
		// JSON.stringify(data)></object>");
		return API_response.asString();
	}

	public static void WriteAPI_Response_to_Jsonfile(String API_ResponseData, String methodName) throws Exception {
		FILENAME = properties.getProperty("Jsonresponse_filepath") + methodName + ".json";
		File file = new File(FILENAME);
		if (file.exists()) {
			file.delete();
		} else {
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(FILENAME);
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write(API_ResponseData);
		buffer.close();
	}

	// Write API Response to JSONFile for CEP
	public static void WriteAPI_Response_to_Jsonfile_CEP(String API_ResponseData, String methodName) throws Exception {
		String configFile = BaseClass.TruncatePath
				+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
		FILENAME = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..APICommon.jsonresponseFilepath") + methodName + ".json";
		File file = new File(FILENAME);
		if (file.exists()) {
			file.delete();
		} else {
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(FILENAME);
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write(API_ResponseData);
		buffer.close();
	}

	public static void WriteAPI_Response_to_XMLfile(String API_ResponseData, String methodName) throws Exception {
		// FILENAME
		// =properties.getProperty("Jsonresponse_filepath")+methodName+".xml";
		// File file = new File(FILENAME);
		File file = new File("C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml");
		if (file.exists()) {
			file.delete();
		} else {
			file.createNewFile();
		}
		FileWriter writer = new FileWriter("C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml");
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write(API_ResponseData);
		buffer.close();
	}

	public static void loadProperties() throws Exception {
		properties = new Properties();
		FileInputStream input = new FileInputStream(new File(BaseClass.TruncatePath
				+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/apiconfig.properties"));
		properties.load(input);
	}

	public static String GetToken(String methodName) throws Exception {
		String Access_token = "";
		List<String> Access_tokens = ReadJsonFile.readJsonFileDynamic(FILENAME,
				properties.getProperty("Access_Token_jsonpath"));
		if (Access_tokens.size() > 0) {
			Access_token = Access_tokens.get(0);
			if (Access_token != null && (!Access_token.equals("")) && (!(Access_token.equals("null")))) {
				logger.log(LogStatus.PASS, "Access_token =" + Access_token);
			} else {
				logger.log(LogStatus.FAIL, "Access_token is BLANK");
			}
			logger.log(LogStatus.PASS, "Execution for " + methodName + " has Completed");
		} else {
			logger.log(LogStatus.FAIL, "Data for Requested API is not found");
		}
		return Access_token;
	}

	public static String ReadJobidXMLFile(String methodname)
			throws ParserConfigurationException, SAXException, IOException {
		String JobID = "";
		try {
			String Success = "";
			int Sucessflag = 0;
			/*
			 * DocumentBuilderFactory dbfac =
			 * DocumentBuilderFactory.newInstance(); File fXmlFile = new
			 * File("C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml"
			 * ); DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			 * Document doc = docBuilder.parse(fXmlFile); XmlPath xml=new
			 * XmlPath(doc.toString()); String
			 * data=xml.get("ServiceResultOfGuid.Data");
			 * System.out.println("data is" +data); return data;
			 */

			// XML_filePath =
			// ReadPropertyFile.getInstance(xmlConfigFile).getProperty("xml_FILENAME");
			String XML_filePath = "C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml";
			File fXmlFile = new File(XML_filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("ServiceResultOfGuid");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					// System.out.println("Data : " +
					// eElement.getAttribute("Data"));
					// System.out.println("First Name : " + ((Node)
					// eElement.getElementsByTagName("Data")).getTextContent());
					System.out.println("Sucess : " + eElement.getElementsByTagName("Success").item(0).getTextContent());
					Success = eElement.getElementsByTagName("Success").item(0).getTextContent();

					System.out.println("JobID : " + eElement.getElementsByTagName("Data").item(0).getTextContent());
					JobID = eElement.getElementsByTagName("Data").item(0).getTextContent();

					if (!(Success.equalsIgnoreCase("")) && (Success.equalsIgnoreCase("true"))) {
						logger.log(LogStatus.PASS, "Success tag value  is true in API response");
						Sucessflag = 1;
					} else {
						logger.log(LogStatus.FAIL, "Success tag value is false in API response");
					}

					if (!(JobID.equalsIgnoreCase("")) && (Sucessflag == 1)) {
						logger.log(LogStatus.PASS, "JobID  is Present in API response");
						logger.log(LogStatus.PASS, "JobID is:= " + JobID);
					} else {
						logger.log(LogStatus.FAIL, "JobID  is not Present in API response");
					}

					logger.log(LogStatus.INFO, "Execution for " + methodname + " is completed");
					// System.out.println("Nick Name : " +
					// eElement.getElementsByTagName("nickname").item(0).getTextContent());
					// System.out.println("Salary : " +
					// eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return JobID;

	}

	public static String ReadJobStatusXMLFile(Method methodname)
			throws ParserConfigurationException, SAXException, IOException {
		try {
			String JobID = "", Success = "";
			/*
			 * DocumentBuilderFactory dbfac =
			 * DocumentBuilderFactory.newInstance(); File fXmlFile = new
			 * File("C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml"
			 * ); DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			 * Document doc = docBuilder.parse(fXmlFile); XmlPath xml=new
			 * XmlPath(doc.toString()); String
			 * data=xml.get("ServiceResultOfGuid.Data");
			 * System.out.println("data is" +data); return data;
			 */

			// XML_filePath =
			// ReadPropertyFile.getInstance(xmlConfigFile).getProperty("xml_FILENAME");
			String XML_filePath = "C:\\Sachin Funde\\JCI Automation work data\\APIXmlresponsedata.xml";
			File fXmlFile = new File(XML_filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Data");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Data : " + eElement.getAttribute("Key"));
					// System.out.println("First Name : " + ((Node)
					// eElement.getElementsByTagName("Data")).getTextContent());
					System.out.println("Sucess : " + eElement.getElementsByTagName("Success").item(0).getTextContent());
					Success = eElement.getElementsByTagName("Success").item(0).getTextContent();

					System.out.println("JobID : " + eElement.getElementsByTagName("Data").item(0).getTextContent());
					JobID = eElement.getElementsByTagName("Data").item(0).getTextContent();

					if (!(Success.equalsIgnoreCase("")) && (Success.equalsIgnoreCase("true"))) {
						logger.log(LogStatus.INFO, "Success  is true in API response");
					} else {
						logger.log(LogStatus.FAIL, "Success  is not true in API response");
					}

					if (!(JobID.equalsIgnoreCase(""))) {
						logger.log(LogStatus.INFO, "Jobid  is Present in API response");
						logger.log(LogStatus.PASS, "Jobid is " + JobID);
					} else {
						logger.log(LogStatus.FAIL, "Jobid  is not Present in API response");
					}
					logger.log(LogStatus.INFO, "Execution for " + methodname + " is completed");
					// System.out.println("Nick Name : " +
					// eElement.getElementsByTagName("nickname").item(0).getTextContent());
					// System.out.println("Salary : " +
					// eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
			return JobID;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return FILENAME;

	}

}