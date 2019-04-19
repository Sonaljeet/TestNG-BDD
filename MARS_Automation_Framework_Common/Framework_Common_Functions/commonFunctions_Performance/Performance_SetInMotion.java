/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_SetInMotion {

	private static ExtentTest logger = null;
	
	public Performance_SetInMotion(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static void LoadAndExecuteJMeterPerformanceTest(StandardJMeterEngine jmeter,  HashTree testPlanTree) {
		
		
		try {
			jmeter.configure(testPlanTree);//testPlanTree
			jmeter.run();
			
			logger.log(LogStatus.PASS, "Performance Configurations are Executed for Testing!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FATAL, "Something Went Horribly Wrong while Executing the Performance Test!");
		}
		
	}
}
