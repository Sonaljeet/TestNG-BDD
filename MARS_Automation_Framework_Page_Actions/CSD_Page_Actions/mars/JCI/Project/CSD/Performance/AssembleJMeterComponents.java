/**
 * 
 */
package mars.JCI.Project.CSD.Performance;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsJmeter.JMeterComponents.JMeterHTTPSampler;
import commonFunctions_Performance.Performance_CreateHashTree;
import commonFunctions_Performance.Performance_CreateTestPlan;
import commonFunctions_Performance.Performance_CreateThreadGroupHashTree;
import commonFunctions_Performance.Performance_Testlnitializer;
import commonFunctions_Performance.Performance_LoopController;
import commonFunctions_Performance.Performance_ThreadGroup;
import commonFunctions_Performance.Performance_SaveAsJMXFile;
import commonFunctions_Performance.Performance_SaveReportData;
import commonFunctions_Performance.Performance_SetlnMotion;

/**
 * @author cdeyso
 *
 */
public class AssembleJMeterComponents {
	
	private static ExtentTest logger = null;
	
	public AssembleJMeterComponents(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	@SuppressWarnings("static-access")
	public static void SampleHTTPSamplerConfig() {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_Testlnitializer initialize = new Performance_Testlnitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(1);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(1, 1, loopController, "Souvik RnD");
			JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://10.117.26.13/UI");
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Souvik Test Plan");
			Performance_CreateThreadGroupHashTree JMthreadGroupHT = new Performance_CreateThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Souvik_MARS");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetlnMotion startJM = new Performance_SetlnMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}

}




















