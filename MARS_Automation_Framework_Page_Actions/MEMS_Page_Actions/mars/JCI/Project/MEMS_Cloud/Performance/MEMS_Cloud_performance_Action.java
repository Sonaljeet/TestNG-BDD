package mars.JCI.Project.MEMS_Cloud.Performance;

/**
 * 
 */

import java.io.IOException;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;

import com.googlecode.jmeter.plugins.webdriver.config.ChromeDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.RemoteDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.sampler.WebDriverSampler;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions_Performance.Performance_CreateHashTree;
import commonFunctions_Performance.Performance_CreateTestPlan;
import commonFunctions_Performance.Performance_CreateThreadGroupHashTree;
import commonFunctions_Performance.Performance_TestInitializer;
import commonFunctions_Performance.Performance_LoopController;
import commonFunctions_Performance.Performance_REMOTEDriverConfig;
import commonFunctions_Performance.Performance_ThreadGroup;
import commonFunctions_Performance.Performance_UserDefinedVariables;
import commonFunctions_Performance.Performance_clearReportsDirectory;
import commonFunctions_Performance.Performance_GraphsGeneratorListener;
import commonFunctions_Performance.Performance_CHROMEDriverConfig;
import commonFunctions_Performance.Performance_SaveAsJMXFile;
import commonFunctions_Performance.Performance_SaveReportData;
import commonFunctions_Performance.Performance_SetInMotion;
import commonFunctions_Performance.Performance_Sampler_HTTPSampler;
import commonFunctions_Performance.Performance_Sampler_WebDiverSampler;
import kg.apc.jmeter.listener.GraphsGeneratorListener;

/**
 * @author cdeyso
 *
 */
public class MEMS_Cloud_performance_Action {
	
	private static ExtentTest logger = null;
	
	public MEMS_Cloud_performance_Action(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	@SuppressWarnings("static-access")
	public static void SampleHTTPSamplerConfig(int jsonVal) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(1);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(1, 1, loopController, "Performance_RnD");
			Performance_Sampler_HTTPSampler JMhttpSampler = new Performance_Sampler_HTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");
			Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("CSD GGL","CSD Login");
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree.add(sample_Vars);
			//threagGroupTree.add(sample_HTTP);
			threagGroupTree.add(sample_WDS);
			//threagGroupTree.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance_MARS_HTTP");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}

	
	@SuppressWarnings("static-access")
	public static void Peformance_Portfolio_landing_page(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Portfolio landing page after login");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	

	@SuppressWarnings("static-access")
	public static void Performance_meterconfigurationtab(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to populate the meter tree on meter configuration tab");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}

	@SuppressWarnings("static-access")
	public static void Performance_summarydashboard_facility(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Summary dashboard page at Facility level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_portfolio(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at Portfolio level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_facility(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at Facility level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at building level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	@SuppressWarnings("static-access")
	public static void Performance_energyscorecard_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management Scorecard dashboard page at building level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_floor(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management Overview dashboard page at floor level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_meter(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Energy Management Overview dashboard page at meter level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_portfolio(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at Portfolio level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_facility(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at Facility level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at building level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentscorecard_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Equipment Management Scorecard dashboard page at building level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_floor(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance - Verify time taken to load the MEMS Cloud Equipment Management Overview dashboard page at floor level");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_3M_timeline_portfolio(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at Porftolio level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_3M_timeline_facility(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at facility level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_3M_timeline_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at building level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_energydashboard_3M_timeline_floor(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at floor level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_3M_timeline_portfolio(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at Porftolio level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_3M_timeline_facility(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at facility level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}
	
	@SuppressWarnings("static-access")
	public static void Performance_equipmentdashboard_3M_timeline_building(int loopCount,int userThreads,int jsonVal,String filePrefix) 
			throws IOException {
		
		logger.log(LogStatus.INFO, "Starting Performance Testing !");
		
			Performance_clearReportsDirectory clnDir = new Performance_clearReportsDirectory(logger);
			clnDir.clearReportsDirectory();
		
			Performance_TestInitializer initialize = new Performance_TestInitializer(logger);
			StandardJMeterEngine jmeter = initialize.getJMeterEngine();
			Performance_LoopController JMloopController = new Performance_LoopController(logger);
			LoopController loopController = JMloopController.setJMeterLoopController(userThreads);
			Performance_ThreadGroup JMthreadGroup = new Performance_ThreadGroup(logger);
			ThreadGroup threadGroup = JMthreadGroup.setJMeterThreadGroup(loopCount,0, loopController, "MARS_Performance");
			/*JMeterHTTPSampler JMhttpSampler = new JMeterHTTPSampler(logger);
			HTTPSamplerProxy sample_HTTP = JMhttpSampler.setJMeterHTTPSampler("https://csdu-app.johnsoncontrols.com/csd2.0/");*/
			//Performance_UserDefinedVariables jmeterUDV = new Performance_UserDefinedVariables(logger);
			//Arguments sample_Vars = jmeterUDV.setUserDefVarsForWDS("CSD UDV");
			Performance_CHROMEDriverConfig jmeterCDC = new Performance_CHROMEDriverConfig(logger);
			ChromeDriverConfig sample_CDC = jmeterCDC.setJMeterChromeDriverConfig("MEMS Cloud Chrome Init");
			//Performance_REMOTEDriverConfig jmeterRDC = new Performance_REMOTEDriverConfig(logger);
			//RemoteDriverConfig sample_RDC = jmeterRDC.setJMeterRemoteDriverConfig("MEMS Cloud Remote Driver Init");
			Performance_Sampler_WebDiverSampler jmeterWDS= new Performance_Sampler_WebDiverSampler(logger);
			WebDriverSampler sample_WDS = jmeterWDS.setJMeterWDS(jsonVal);
			Performance_GraphsGeneratorListener jmeterGGL = new Performance_GraphsGeneratorListener(logger);
			GraphsGeneratorListener sample_GGL = jmeterGGL.setGGLProperties("MEMS Cloud GGL",filePrefix);
			Performance_CreateTestPlan JMtestPlan = new Performance_CreateTestPlan(logger);
			TestPlan testPlan = JMtestPlan.getJMeterTestPlan("Performance Test Plan");
			HashTree threagGroupTree =Performance_CreateThreadGroupHashTree.getHashTree();
			threagGroupTree.add(testPlan);
			HashTree threagGroupTree2 = threagGroupTree.add(testPlan,threadGroup);
			//threagGroupTree2.add(sample_Vars);
			threagGroupTree2.add(sample_CDC);
			//threagGroupTree2.add(sample_RDC);
			threagGroupTree2.add(sample_WDS);
			threagGroupTree2.add(sample_GGL);
			/*CreateJMeterThreadGroupHashTree JMthreadGroupHT = new CreateJMeterThreadGroupHashTree(logger);
			HashTree threagGroupTree = JMthreadGroupHT.getThreadGroupHashTree(testPlan, threadGroup);
			threagGroupTree.add(sample_HTTP);*/
			
			Performance_SaveAsJMXFile saveJMX = new Performance_SaveAsJMXFile(logger);
			saveJMX.saveConfigsToJMXFile(threagGroupTree, "Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at building level for 3M timeline");
			
			Performance_SaveReportData saveReport = new Performance_SaveReportData(logger);
			saveReport.saveResponseResultsForJMeter(threagGroupTree);
			Performance_SetInMotion startJM = new Performance_SetInMotion(logger);
			startJM.LoadAndExecuteJMeterPerformanceTest(jmeter,threagGroupTree);
			
	}

	
}




