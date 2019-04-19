/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_CreateThreadGroupHashTree {

	
	private static ExtentTest logger = null;
	public static  HashTree threadGroupHashTree,firstHashTree = null;
	
	@SuppressWarnings("static-access")
	public Performance_CreateThreadGroupHashTree(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static HashTree getHashTree() {
		
		firstHashTree = new HashTree();
		
		return firstHashTree;
	}
	
	@SuppressWarnings("static-access")
	public static HashTree getThreadGroupHashTree(TestPlan testPlan,ThreadGroup threadGroup){
		
		Performance_CreateHashTree createJMHT = new Performance_CreateHashTree(logger);
		HashTree testPlanTree = createJMHT.getJMeterHashTree();
		//testPlanTree.add(testPlan);
		threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
		
		logger.log(LogStatus.INFO, "Hashtree is updated with Test Plan and Thread Group!");
		
		return threadGroupHashTree;
	}
}
