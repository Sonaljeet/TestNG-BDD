package mars.automation.framework.TestNGRunnerPkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;
import org.testng.xml.XmlClass;

import mars.automation.framework.NEWLauncher.ClassScanner;

public class XmlSuiteCreation {

	private static String testFolderPath = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Tests";
	private static String testFolderName = "CSD_Tests";

	private static List<XmlClass> testClasses = new ArrayList<XmlClass>();

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

		Map<String, List<String>> classTestMap = ClassScanner.getTestClasses(testFolderPath, testFolderName);
		if (classTestMap != null) {

			for (Map.Entry<String, List<String>> entry : classTestMap.entrySet()) {
				 System.out.println(entry.getKey());
				 
				 Reflections ref = new Reflections(entry.getKey());
				//Class clazz = Class.forName(entry.getKey());
				XmlClass xmlclass = new XmlClass(ref.getClass());
				testClasses.add(xmlclass);
			}
		}
		System.out.println(testClasses);
	}

}
