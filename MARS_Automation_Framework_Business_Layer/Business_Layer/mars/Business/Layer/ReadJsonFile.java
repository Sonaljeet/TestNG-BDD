/**
 * 
 */
package mars.Business.Layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

/**
 * @author cdeyso
 * @author Souvik Dey
 * 
 * This method is to be used to read a JSON file based on Key/Value Combinations upon the 
 * JSONPath for the desired Keys
 *
 */
public class ReadJsonFile {
	
	/** The location of Json Config File */
	public static String jsonConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/JSONconfig.propertiess";
	
	/** The variable to store the location of the JSON File to be read */
	public static String JSON_filePath = null;
	
	/** The JSON Path to read */
	public static String JSON_path = null;
	
	/** The list of Values that is returned from the JSON after it is read */
	public static List<String> categories = new ArrayList<String>();
	public static List<Double> categoriesDouble = new ArrayList<Double>();
	public static List<Integer> categoriesInteger = new ArrayList<Integer>();
	public static List<Boolean> categoriesBoolean = new ArrayList<Boolean>();
	public static List<String> categories_firstdata = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public static List<String> readJsonFileStatic() {
		
		JSON_filePath = ReadPropertyFile.getInstance(jsonConfigFile).getProperty("json_FILENAME");
		JSON_path = ReadPropertyFile.getInstance(jsonConfigFile).getProperty("json_Path_1");
		
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(JSON_filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categories = context.read(JSON_path, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categories;
	}
	
	/** This Method always returns a list of values, even if there is only a single value 
	 * in the JSON File 
	 * @author SouvikD
	*/
	@SuppressWarnings("unchecked")
	public static List<String> readJsonFileDynamic(String filePath, String jsonPath) {
		
		System.out.println("jsonpath - "+jsonPath);
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categories = context.read(jsonPath, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categories;
		
	}
	//For CEP
	@SuppressWarnings("unchecked")
	public static List<Double> readJsonFileDynamicDouble(String filePath, String jsonPath) {
		
		System.out.println("jsonpath - "+jsonPath);
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categoriesDouble = context.read(jsonPath, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categoriesDouble;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Boolean> readJsonFileDynamicBoolean(String filePath, String jsonPath) {
		
		System.out.println("jsonpath - "+jsonPath);
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categoriesBoolean = context.read(jsonPath, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categoriesBoolean;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer> readJsonFileDynamicInteger(String filePath, String jsonPath) {
		
		System.out.println("jsonpath - "+jsonPath);
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categoriesInteger = context.read(jsonPath, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categoriesInteger;
		
	}
	
	/**
	 * This is the method to split the Value of a single Key into selectable ArrayList upon splitting and resrranging them into an ArrayList
	 * That way we can store Multiple values into the Keys for times where we need multiple data to execute.
	 * 
	 * @author SouvikD
	 * @param values
	 * @return
	 */
	
	public static List<String> convertStringToList(List<String> values){
		
		System.out.println("values : "+values);
		String valuesStringVal = values.toString();
		System.out.println("valuesStringVal size :"+valuesStringVal.length());
		String pattern = "[\\[\\](){}]";
		String reformedString = valuesStringVal.replaceAll(pattern,"");
		System.out.println("reformedString :"+reformedString);
		String[] splitStringArray = reformedString.split(",");
		List<String> splitStringList = new ArrayList<String>();
		for(int i =0;i<splitStringArray.length;i++){
			splitStringList.add(i, splitStringArray[i]);
		}
		System.out.println("splitStringList :"+splitStringList);
		
		return splitStringList;
		
		
	}
	
	
	
	/**
	 * This is the method return the first node of the json key.
	 * @param filePath
	 * @param jsonPath
	 * @return
	 */
	
	public static String readJsonFileDynamic_firstentry(String filePath, String jsonPath) {
		String category_firstmatch="";
		try{
			categories_firstdata=readJsonFileDynamic(filePath, jsonPath);
			category_firstmatch=categories_firstdata.get(0).toString();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		return category_firstmatch;
	}	

}
