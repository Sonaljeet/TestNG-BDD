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
public class Performance_SetlnMotion {

	private static ExtentTest logger = null;
	
	public Performance_SetlnMotion(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static void LoadAndExecuteJMeterPerformanceTest(StandardJMeterEngine jmeter,  HashTree testPlanTree) {
		
		
		try {
			jmeter.configure(testPlanTree);//testPlanTree
			jmeter.run();
			
			logger.log(LogStatus.PASS, "JMeter Configurationsa are Executed for Performance Testing!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FATAL, "Something Went Horribly Wrong while Executing the JMeter Performance Test!");
		}
		
	}
}
