/**
 * 
 */
package commonFunctions_Performance;



import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.testelement.TestElement;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Business.Layer.ReadPropertyFile;

/**
 * @author cdeyso
 *
 */
public class Performance_UserDefinedVariables {
	
	private static ExtentTest logger = null;
	public static  Arguments sampleUSV = null;
	private static String performancePropFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/preformanceConfig.properties";
	
	
	public Performance_UserDefinedVariables(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static Arguments setUserDefVarsForWDS(String udvName) {
		
		try {
			
			sampleUSV = new Arguments();
			sampleUSV.setName(udvName);
			sampleUSV.setEnabled(true);
			sampleUSV.addArgument("csd_url", ReadPropertyFile.getInstance(performancePropFile).getProperty("performanceURL"), "=", "CSD Login URL -- TEST");
			sampleUSV.addArgument("username", ReadPropertyFile.getInstance(performancePropFile).getProperty("appUSER"), "=", "CSD Login USER -- TEST");
			sampleUSV.addArgument("password", ReadPropertyFile.getInstance(performancePropFile).getProperty("appPASS"), "=", "CSD Login PASS -- TEST");
			sampleUSV.setProperty(TestElement.TEST_CLASS, Arguments.class.getName());
			sampleUSV.setProperty(TestElement.GUI_CLASS, ArgumentsPanel.class.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return sampleUSV;
	}

}
