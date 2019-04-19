//<<<<<<< HEAD:MARS_Automation_Framework_Common/Framework_Common_Functions/commonFunctions_Performance/Performance_SaveAsJMXFile.java
/**
 * 
 */
package commonFunctions_Performance;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jmeter.save.SaveService;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_SaveAsJMXFile {

	
	private static ExtentTest logger = null;
	public static String projdir = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/TestResources/PerformanceTest/MEMS_Cloud_JMX files";
	
	@SuppressWarnings("static-access")
	public Performance_SaveAsJMXFile(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	// save generated test plan to JMeter's .jmx file format
	public static void saveConfigsToJMXFile(HashTree testPlanTree, String jmx_Filename){	
	    try {
			  SaveService.saveTree(testPlanTree, new FileOutputStream(projdir+"\\"+jmx_Filename+".jmx"));
			  logger.log(LogStatus.PASS, "System has saved the Configurations into "+jmx_Filename+".jmx file for Reference!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.log(LogStatus.FAIL, "Something went terribly Wrong While Saving the Configurations into the jmx file!");
			} 
	}
}
