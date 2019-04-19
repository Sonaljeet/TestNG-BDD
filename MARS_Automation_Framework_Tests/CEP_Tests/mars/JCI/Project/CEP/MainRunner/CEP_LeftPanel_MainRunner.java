package mars.JCI.Project.CEP.MainRunner;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class CEP_LeftPanel_MainRunner {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\CEP_Master_TestNG.xml");//path to xml..
		testng.setTestSuites(suites);
		testng.run();

	}

}
