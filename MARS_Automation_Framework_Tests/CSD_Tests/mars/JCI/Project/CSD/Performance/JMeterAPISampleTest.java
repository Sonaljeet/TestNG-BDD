/**
 * 
 */
package mars.JCI.Project.CSD.Performance;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Performance.CSD_Performance_MUILogin_Page_Action;
import mars.JCI.Project.CSD.Performance.CSD_Performance_MUICommand_Page_Action;
import mars.JCI.Project.CSD.Performance.CSD_Performance_MUISearch_Page_Action;
import mars.JCI.Project.CSD.Performance.CSD_Performance_GGL_ScreenShots;
import mars.JCI.Project.CSD.Performance.CSD_Performance_HandleJTLFile;

/**
 * @author cdeyso
 *
 */
public class JMeterAPISampleTest extends BaseClass {
	
	public static int loopCount = 1;
	public static int userThreads = 1;
	

	@SuppressWarnings("static-access")
	@Test(priority=0,description="Running a POC on Performace Test In MARS Framework using JMeter Libraries! -- Login to Metasys UI")
	public static void RunPerformanceTestMUILogin() {
		
		try {
			
			CSD_Performance_MUILogin_Page_Action performance_PA = new CSD_Performance_MUILogin_Page_Action(logger);
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_PA.ExecuteJMeter(loopCount,userThreads);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	//@Test(priority=1,description="Running a POC on Performace Test In MARS Framework using JMeter Libraries! -- Navigate to Metasys UI Command DashBoard!")
	public static void RunPerformanceTestMUICommand() {
		
		try {
			
			CSD_Performance_MUICommand_Page_Action performance_PA = new CSD_Performance_MUICommand_Page_Action(logger);
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_PA.ExecuteJMeter(loopCount,userThreads);
			performance_JTL.clearAllTheStaticArrayLists();
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	//@Test(priority=2,description="Running a POC on Performace Test In MARS Framework using JMeter Libraries! -- Navigate to Metasys UI Search DashBoard!")
	public static void RunPerformanceTestMUISearch() {
		
		try {
			
			CSD_Performance_MUISearch_Page_Action performance_PA = new CSD_Performance_MUISearch_Page_Action(logger);
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_PA.ExecuteJMeter(loopCount,userThreads);
			performance_JTL.clearAllTheStaticArrayLists();
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	//@Test(priority=3,description="Running a POC on Performace Test In MARS Framework using JMeter Libraries! -- Attach all the GraphGeneratorListener Graphs!")
	public static void RunPerformanceTestAttachGGLGraphs() {
		
		try {
			
			CSD_Performance_GGL_ScreenShots performance_GGL = new CSD_Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger);
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	//@Test
	public static void testTest() {
		
		try {
			
			CSD_Performance_HandleJSONScript handle_JSON = new CSD_Performance_HandleJSONScript(logger);
			//AssembleJMeterComponents assembleJmeter = new AssembleJMeterComponents(logger);
			//handle_JSON.readAllScriptFromJSONFile();
			handle_JSON.readScriptFromJSONFile(1);
			//assembleJmeter.SampleHTTPSamplerConfig();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
}
