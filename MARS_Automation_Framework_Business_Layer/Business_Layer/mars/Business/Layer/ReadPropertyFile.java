/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Business.Layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * The Class ReadPropertyFile.
 * 
 */
public class ReadPropertyFile {
	private final Properties property = new Properties();
	private static ReadPropertyFile INSTANCE = null;

	/**
	 * Instantiates a new read property file.
	 *
	 * @param propertyFileName the property file name
	 */
	private ReadPropertyFile(String propertyFileName) {
		// Private constructor to maintain the singleton pattern
		
		try {
			File propFile=new File(propertyFileName);
			//System.out.println("propertyFileName" +propertyFileName);
			InputStream inputstream=new FileInputStream(propFile);
			if (inputstream != null) {
				property.load(inputstream);
			}

		} catch (IOException ioe) {
			System.out.println("=========================");
			System.out.println("Error reading property file. \nError Message \n" +ioe.getMessage());
			System.out.println("=========================");
		}
	}

	// singletone pattern creation to maintain single instance of property file
	//Following method is commented to remove Lazy loading

	/*
	 * private static class ClassHolder { private static final ReadPropertyFile
	 * INSTANCE = new ReadPropertyFile(); }
	 */

	/**
	 * Gets the single instance of ReadPropertyFile.
	 *
	 * @param propertyFile
	 *            {@link String}
	 * @return single instance of ReadPropertyFile
	 */
	public static ReadPropertyFile getInstance(String propertyFile) {
		return INSTANCE = new ReadPropertyFile(propertyFile);
	}

	/**
	 * Gets the property.
	 *
	 * @param key
	 *            the key
	 * @return Property Value
	 */
	public String getProperty(String key) {
		//System.out.println(key);
		String propVal=null;
		try {
			propVal= property.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("=========================");
			System.out.println("Error reading value : " +e.getMessage());
			System.out.println("=========================");
		}
		return propVal;
	}

	/**
	 * Gets the all property names.
	 *
	 * @return the all property names in the property file
	 */
	public Set<String> getAllPropertyNames() {
		return property.stringPropertyNames();
	}

	/**
	 * Contains key.
	 *
	 * @param keyName
	 *            the key name
	 * @return True if key value is found in the property file else false
	 */
	public boolean containsKey(String keyName) {
		boolean contains=false;
		try {
			contains= property.containsKey(keyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("=========================");
			System.out.println("Property "+ keyName +"not found...\n" +e.getMessage());
			System.out.println("=========================");
		}
		return contains;
	}
}
