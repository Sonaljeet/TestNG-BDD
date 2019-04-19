package mars.JCI.Project.MEMSCloud.Performance;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Performance.CSD_Performance_HandleJTLFile;
import mars.JCI.Project.MEMS_Cloud.Performance.MEMS_Cloud_performance_Action;

public class MEMS_Cloud_Performance_Test extends BaseClass  {

	public static int loopCount = 1;
	public static int userThreads = 1;
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Portfolio landing page after login")
	public static void Performance_Portfolio_landing_page() {
		
		try {
			
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Peformance_Portfolio_landing_page(loopCount,userThreads,0,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to populate the meter tree on meter configuration tab")
	public static void Performance_meterconfigurationtab() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_meterconfigurationtab(loopCount,userThreads,1,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Summary dashboard page at Facility level")
	public static void Performance_summarydashboard_facility() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_summarydashboard_facility(loopCount,userThreads,2,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at Portfolio level")
	public static void Performance_energydashboard_portfolio() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_portfolio(loopCount,userThreads,3,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at Facility level")
	public static void Performance_energydashboard_facility() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_facility(loopCount,userThreads,4,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management overview dashboard page at building level")
	public static void Performance_energydashboard_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_building(loopCount,userThreads,5,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management Scorecard dashboard page at building level")
	public static void Performance_energyscorecard_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energyscorecard_building(loopCount,userThreads,6,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management Overview dashboard page at floor level")
	public static void Performance_energydashboard_floor() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_floor(loopCount,userThreads,7,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Energy Management Overview dashboard page at meter level")
	public static void Performance_energydashboard_meter() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_meter(loopCount,userThreads,8,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at Portfolio level")
	public static void Performance_equipmentdashboard_portfolio() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_portfolio(loopCount,userThreads,9,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at Facility level")
	public static void Performance_equipmentdashboard_facility() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_facility(loopCount,userThreads,10,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Equipment Management overview dashboard page at building level")
	public static void Performance_equipmentdashboard_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_building(loopCount,userThreads,11,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Equipment Management Scorecard dashboard page at building level")
	public static void Performance_equipmentscorecard_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentscorecard_building(loopCount,userThreads,12,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance - Verify time taken to load the MEMS Cloud Equipment Management Overview dashboard page at floor level")
	public static void Performance_equipmentdashboard_floor() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_floor(loopCount,userThreads,13,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at Porftolio level for 3M timeline")
	public static void Performance_energydashboard_3M_timeline_portfolio() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_3M_timeline_portfolio(loopCount,userThreads,14,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at facility level for 3M timeline")
	public static void Performance_energydashboard_3M_timeline_facility() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_3M_timeline_facility(loopCount,userThreads,15,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at building level for 3M timeline")
	public static void Performance_energydashboard_3M_timeline_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_3M_timeline_building(loopCount,userThreads,16,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Energy Management overview  dashboard page  widgets at floor level for 3M timeline")
	public static void Performance_energydashboard_3M_timeline_floor() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_energydashboard_3M_timeline_floor(loopCount,userThreads,17,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at Porftolio level for 3M timeline")
	public static void Performance_equipmentdashboard_3M_timeline_portfolio() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_3M_timeline_portfolio(loopCount,userThreads,18,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at facility level for 3M timeline")
	public static void Performance_equipmentdashboard_3M_timeline_facility() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_3M_timeline_facility(loopCount,userThreads,19,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	@SuppressWarnings("static-access")
	@Test(priority=1,description="Performance-Verify time taken to load the MEMS Cloud Equipment Management overview  dashboard page  widgets at building level for 3M timeline")
	public static void Performance_equipmentdashboard_3M_timeline_building() {
		
		try {
			
			MEMS_Cloud_performance_Action assembleJmeter = new MEMS_Cloud_performance_Action(logger);
			assembleJmeter.Performance_equipmentdashboard_3M_timeline_building(loopCount,userThreads,20,"Landing page");
			CSD_Performance_HandleJTLFile performance_JTL = new CSD_Performance_HandleJTLFile(logger);
			performance_JTL.ReadReportsJTLFile();
			performance_JTL.calculateThroughput();
			performance_JTL.calculateTotalTimeTaken();//getTheFinalEndTime();
			performance_JTL.sentKiloBytesPerSec();
			performance_JTL.getMinTimeTaken();
			
			logger.log(LogStatus.INFO, "Concluded Performance Testing !");	
			
			commonFunctions_Performance.Performance_GGL_ScreenShots performance_GGL = new commonFunctions_Performance.Performance_GGL_ScreenShots(logger);
			performance_GGL.getAllGraphsNames();
			performance_GGL.addGGLGraphsToReport(logger,"Landing page");
			
			//getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	
}
