package mars.automation.framework.TestNGRunnerPkg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import javafx.fxml.FXML;
import mars.automation.framework.NEWLauncher.view.WebUI_AutoController;

public class TestNgRunTests{

	private static TestNG runner = null;
	public static volatile boolean  stopTest = false;
	public static Thread threadTestNgRun = null;

	private static List<String> testNgXmlFile;

	private static String suiteFile = "";// "C:/MARS_GUI_INTEGRATED/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/API_testng.xml";

	static boolean runTest = true;
	
	public static void startTestNgTests(String testXmlFile) {
		suiteFile = testXmlFile;
		startTest(testXmlFile);
	}

	public static void setStopStatus() {
		stopTest = true;
	}

	public static boolean getStopStatus(){
		return stopTest;
	}
	@FXML
	public static void startTest(String testXmlFile) {
		// stopTest = true;
		try {
			suiteFile = testXmlFile;
			if (threadTestNgRun == null) {
				threadTestNgRun = new Thread() {
					@Override
					public void run() {
						
						runTest(testXmlFile);
						}
				};
				System.out.println("New thread starting");
				threadTestNgRun.start();
			}else{
				System.out.println("Thread details: "+Thread.currentThread().getName());
				threadTestNgRun = null;
			}
		} catch (Exception e) {
			System.out.println("Error running test... Start the GUI application again...");
			e.printStackTrace();
		}
		
		
		//return threadTestNgRun;
	}

	
	private static void runTest(String testXmlFile){
		if(!getStopStatus()) {
			System.out.println("Value of stoptest in while loop: "+!stopTest);
			runner = new TestNG();
			System.out.println("1");

			testNgXmlFile = new ArrayList<String>();

			/*File f = new File(suiteFile);
			System.out.println(f.getAbsolutePath());*/

			testNgXmlFile.add(testXmlFile);
			runner.setTestSuites(testNgXmlFile);
			//runTest = !getStopStatus();
			runner.run();

		}
	}
	public static void stopAllTest() {

		if (threadTestNgRun.isAlive()) {
			threadTestNgRun.stop();
			System.out.println("Test Stopped");
			stopTest = false;
		}
	}

	public static List<String> getTestNgXmlSuite() {
		List<String> testngXmlList = new ArrayList<String>();
		List<XmlClass> classes = new ArrayList<XmlClass>();

		XmlSuite suite = new XmlSuite();
		suite.setName("Test Suite");
		XmlTest test = new XmlTest(suite);
		test.setName("Include Exclude Method test");

		XmlClass clz = new XmlClass("testNgRunnerPkg.sampleTestNgPkg");

		XmlInclude methodOne = new XmlInclude("f");

		// Creating a list included methods and adding the methods instances to
		// it
		List<XmlInclude> includes = new ArrayList<XmlInclude>();
		includes.add(methodOne);

		clz.setIncludedMethods(includes);
		classes.add(clz);
		test.setXmlClasses(classes);

		// testngXmlList.add(suite);

		return testngXmlList;

	}
}
