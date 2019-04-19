package mars.Business.Layer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author cdeyso
 * @author Souvik Dey
 * 
 * This method is to be used to Write and update a JSON file based on Key/Value Combinations 
 * 
 *
 */


public class WriteJsonFile {
	
	/** The variable to store the location of the JSON File to be read */
	public static String JSON_filePath = null;
	
	/** 
	 * 
	 * This Method always perform the updation of the json file and inserts the mentioned 
	 * KEY and VALUE pair into the mentioned File and inside the same JSON object .
	 * 
	 * 
	 */
	
	@SuppressWarnings("resource")
	public static void writeJSONFileDynamic(String filePath, String keyString, String valueString) 
			throws JsonIOException, JsonSyntaxException, IOException {
		
		File file = new File(filePath);
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(new FileReader(file));
		JsonObject jsonObj = (JsonObject) obj;
		jsonObj.addProperty(keyString, valueString);
		FileWriter fileWrite = new FileWriter(file);
		fileWrite.write(jsonObj.toString());
		fileWrite.flush();
		System.out.println("Existing JSON File is updated with the mentioned Entries!");
	}

	
}
