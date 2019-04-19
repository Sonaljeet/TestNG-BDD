/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_CreateHashTree {

	
	private static ExtentTest logger = null;
	public static  HashTree testPlanTree = null;
	
	public Performance_CreateHashTree(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static HashTree getJMeterHashTree() {
		
		 testPlanTree = new HashTree();
		 
		 logger.log(LogStatus.PASS, "New HashTree To accomodate Test Plans is Created!");
		
		return testPlanTree;
		
	}
}
