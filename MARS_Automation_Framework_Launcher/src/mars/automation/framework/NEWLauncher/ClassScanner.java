package mars.automation.framework.NEWLauncher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.reflections.Reflections;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlTest;

public class ClassScanner {

	public static ArrayList<File> files = new ArrayList<>();

	static Map<String, List<String>> classMethodsMap = new HashMap<String, List<String>>();

	static List<String> methodsName = null;

	//@Test(description = "print method")
	public static Map<String, List<String>>  getTestClasses(String testFolderPath, String testFolderName)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		testFolderPath= "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Tests";
		testFolderName= "CSD_Tests";
		// File folder = new File(System.getProperty("user.dir"));
		File folder = new File(testFolderPath);
		String[] list = folder.list();

		Set<Method> allTestMethods = null;
		Class<?> classType = null;
		String className = "";
		for (int i = 0; i < list.length; i++) {
			if (list[i].equalsIgnoreCase(testFolderName)) {
				ArrayList<File> filearraylist = scanDirectory(folder + "\\"+testFolderName);
				for (File fileobj : filearraylist) {

					String[] Intermediatepath = fileobj.toString().replace("\\", ".").split(testFolderName);
					String classname[] = Intermediatepath[1].substring(1).split(".java");

					classType = Class.forName(classname[0]);
					// System.out.println(classType.getPackage());

					//System.out.println(classType.getName());
					
					
					Method[] allMethods = classType.getDeclaredMethods();
					//System.out.println(classType.getName());
					methodsName = new ArrayList<String>();
					for (Method m : allMethods) {
						
						if (m.isAnnotationPresent(org.testng.annotations.Test.class)) {
							 methodsName.add(m.getName());
							className = classType.getName();
						}
					}
					if (!classMethodsMap.containsKey(className) || !classMethodsMap.isEmpty()) {
						classMethodsMap.put(className, methodsName);
					}
					className="";
				}
				// System.out.println(allTestMethods);
			}

		}
		// System.out.println(classMethodsMap);

/*		
		List<XmlClass> testClasses = new ArrayList<XmlClass>();
		List<XmlInclude> includedTests = new ArrayList<>();
		
		 for(Map.Entry<String, List<String>> entry : classMethodsMap.entrySet()){
			 //List<String> testMethods = entry.getValue();
			 
			 System.out.println("Package: "+entry.getKey()+": "+entry.getValue());
			 XmlClass xmlclass = new XmlClass(entry.getKey());
			 testClasses.add(xmlclass);
			for(String testName: entry.getValue()){
				
				includedTests.add(new XmlInclude(testName));
			}		 
		}*/
		 
		 	
		//System.out.println(includedTests);
		return classMethodsMap; //
	}
	
/*	
	private static void createTestNgXML() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		
		String testFolderPath = "C:/MARS_GUI_INTEGRATED/MARS_FRAMEWORK/MARS_Automation_Framework_Tests";
		String testFolderName = "BCMET_Tests";

		List<XmlClass> testClasses = new ArrayList<XmlClass>();
		Map<String, List<String>> classTestMap = getTestClasses(testFolderPath, testFolderName);

		for (Map.Entry<String, List<String>> entry : classTestMap.entrySet()) {
			 //System.out.println(entry.getKey());
			 
			 Reflections ref = new Reflections(entry.getKey());
			XmlClass xmlclass = new XmlClass(ref.getClass());
			testClasses.add(xmlclass);
		}
		System.out.println(testClasses);
	}*/

	public static ArrayList<File> scanDirectory(String directoryName) {

		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				// System.out.println(file.getAbsolutePath());
				files.add(file);
			} else if (file.isDirectory()) {
				scanDirectory(file.getAbsolutePath());
			}
		}
		// System.out.println(fList);
		return files;
	}

}
