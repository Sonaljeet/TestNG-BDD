package mars.automation.framework.TestNGRunnerPkg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunTestNgSuite extends Thread{

	private static RunTestNgSuite INSTANCE = null;
	
	private static TestNG runner = null;
	public static boolean stopTest = false;
	public static Thread threadTestNgRun = null;

	private static List<String> testNgXmlFile;

	private static String suiteFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/BCMET_Experiment_TestNG.xml";

	
	private RunTestNgSuite(){
		
	}
	
	public static RunTestNgSuite getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new RunTestNgSuite();
		}
		return INSTANCE;
	}
	
	public void run(){
		
		if (!RunTestNgSuite.stopTest) {
			while (!RunTestNgSuite.stopTest) {
				runner = new TestNG();
				testNgXmlFile = new ArrayList<String>();
				File f = new File(suiteFile);
				System.out.println(f.getAbsolutePath());
				testNgXmlFile.add(suiteFile);
				runner.setTestSuites(testNgXmlFile);
				runner.run();
			}

		}
	}
	
}
