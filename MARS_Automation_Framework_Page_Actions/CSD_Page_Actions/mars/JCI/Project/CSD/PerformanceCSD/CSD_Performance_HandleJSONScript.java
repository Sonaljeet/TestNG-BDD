/**
 * 
 */
package mars.JCI.Project.CSD.PerformanceCSD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.ExtentTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

/**
 * @author cdeyso
 *
 */
public class CSD_Performance_HandleJSONScript {
	
	private static ExtentTest logger = null;
	
	public static String project_dir = System.getProperty("user.dir");
	public static String FILENAME = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/PerformanceTest/JMeterScriptJSON.json";
	public static List<String> WDS_StepName = new ArrayList<String>();
	public static List<String> WDS_ScriptLanguage = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_Performance_HandleJSONScript(ExtentTest logger) {
		this.logger = logger;
	}
	
	public static int getNoOfWDSScripts() {
		
		int noOfScripts = 0;
		 JSONParser parser = new JSONParser();
		 
		 try {

	            Object obj = parser.parse(new FileReader(FILENAME));

	            JSONObject jsonObject = (JSONObject) obj;
	            System.out.println("jsonObject : "+jsonObject);
	            
	            JSONArray msg = (JSONArray) jsonObject.get("WebdriverSamplers");
	            noOfScripts = msg.size();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 
		 return noOfScripts;
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public static void readAllScriptFromJSONFile() {
		
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(FILENAME));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("jsonObject : "+jsonObject);
            
            JSONArray msg = (JSONArray) jsonObject.get("WebdriverSamplers");
            System.out.println("msg size"+msg.size());
            Iterator<String> iterator = msg.iterator();
            	for (int i = 0; i < msg.size(); i++) {
            		List<String> textScript = new ArrayList<String>();
					String msg_str = msg.get(i).toString();
					Object obj_2 = parser.parse(msg_str);
					JSONObject jsonObject_2 = (JSONObject) obj_2;
					System.out.println("jsonObject_2 : " + jsonObject_2);
					JSONArray msg_text = (JSONArray) jsonObject_2.get("ScriptText");
					System.out.println("msg_text "+msg_text);
					Iterator<String> iterator_txt = msg_text.iterator();
					while (iterator_txt.hasNext()) {
						//textScript = textScript+iterator_txt.next();
						textScript.add(iterator_txt.next());
						//System.out.println(iterator_txt.next());//iterator_txt.next());
					} 
					System.out.println("textScript "+textScript);
					String script = stringBuilder(textScript);
					System.out.println("==================================================================================");
				}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public static String readScriptFromJSONFile(int scriptNo) {
		
		JSONParser parser = new JSONParser();
		String script = null;
        try {

            Object obj = parser.parse(new FileReader(FILENAME));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("jsonObject : "+jsonObject);
            
            JSONArray msg = (JSONArray) jsonObject.get("WebdriverSamplers");
            System.out.println("msg size"+msg.size());
            Iterator<String> iterator = msg.iterator();
            if(scriptNo < msg.size()){
            	//for (int i = 0; i < msg.size(); i++) {
            		List<String> textScript = new ArrayList<String>();
					String msg_str = msg.get(scriptNo).toString();
					Object obj_2 = parser.parse(msg_str);
					JSONObject jsonObject_2 = (JSONObject) obj_2;
					System.out.println("jsonObject_2 : " + jsonObject_2);
					JSONArray msg_text = (JSONArray) jsonObject_2.get("ScriptText");
					System.out.println("msg_text "+msg_text);
					Iterator<String> iterator_txt = msg_text.iterator();
					while (iterator_txt.hasNext()) {
						//textScript = textScript+iterator_txt.next();
						textScript.add(iterator_txt.next());
						//System.out.println(iterator_txt.next());//iterator_txt.next());
					} 
					System.out.println("textScript "+textScript);
					script = stringBuilder(textScript);
					System.out.println("==================================================================================");
				//}
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return script;
		
	}
	
	public static String stringBuilder(List<String> list) {
		
		StringBuilder sb = new StringBuilder();
			for (String s : list) {
				sb.append(s);
				sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getWDSName(int jsonVal) throws IOException {
		
		String content = new String(Files.readAllBytes(Paths.get(FILENAME))); 
		 
		 Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
		 DocumentContext context = JsonPath.using(conf).parse(content);
		 String json_path = "$..WebdriverSamplers["+jsonVal+"].samplerName" ;
		 WDS_StepName =  context.read(json_path, List.class);
		 //List<String> categories = context.read(json_path, List.class); //.points.samples.val equipment.
		 System.out.println(WDS_StepName);
		
		return WDS_StepName;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getWDSLanguage(int jsonVal) throws IOException {
		
		String content = new String(Files.readAllBytes(Paths.get(FILENAME))); 
		 
		 Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
		 DocumentContext context = JsonPath.using(conf).parse(content);
		 String json_path = "$..WebdriverSamplers["+jsonVal+"].scriptLanguage" ;
		 WDS_ScriptLanguage =  context.read(json_path, List.class);
		 //List<String> categories = context.read(json_path, List.class); //.points.samples.val equipment.
		 System.out.println(WDS_ScriptLanguage);
		
		return WDS_ScriptLanguage;
	}

}
