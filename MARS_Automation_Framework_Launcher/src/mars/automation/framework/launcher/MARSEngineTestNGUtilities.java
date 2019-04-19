/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.automation.framework.launcher;

import javafx.fxml.FXML;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpandeak on 7/22/2016.
 */
public class MARSEngineTestNGUtilities {

	private static TestNG runner;
	private static volatile boolean stopTest1;
	public static Thread testngRunner = null;

	private static List<String> testNgXmlFile;
	 private static String suiteFile ="C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\testNG-ExperimentBCM.xml";
	 //"C:\\Users\\cpandeak\\IdeaProjects\\AllFormControls\\src\\testng.xml";
	//private static String suiteFile = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\testNG-Experiment.xml";

	/**
	 * Start test.
	 *
	 * @return the threada
	 */
	@FXML
	public static Thread startTest() {
		stopTest1 = MARSEngineController.stopTest;
		Thread testngRunner = new Thread() {
			@Override
			public void run() {
				System.out.println("Inside startTest() = " + !stopTest1);
				if (!stopTest1) {
					runner = new TestNG();
					testNgXmlFile = new ArrayList<String>();
					testNgXmlFile.add(suiteFile);
					runner.setTestSuites(testNgXmlFile);
					runner.run();
					System.out.println("if StopTest = " + stopTest1);
				}
			}
		};
		testngRunner.start();
		return testngRunner;
	}

}
