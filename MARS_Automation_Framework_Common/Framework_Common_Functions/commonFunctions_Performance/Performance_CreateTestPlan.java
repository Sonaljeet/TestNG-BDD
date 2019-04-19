/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class Performance_CreateTestPlan {
	
	private static ExtentTest logger = null;
	public static  TestPlan testPlan = null;
	
	public Performance_CreateTestPlan(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static TestPlan getJMeterTestPlan(String testplan_name) {
		
		testPlan = new TestPlan(testplan_name);
		
		 testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
         testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
         testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());
         
		return testPlan;
		
	}

}
