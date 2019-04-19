package mars.JCI.Project.CEP.PerformanceTesting;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.Performance.CEP_PerformanceTesting_Page_Action;

public class CEP_PerformanceTesting_TestNG_Runner extends BaseClass {
	@Test(priority=0, description = "1.1-Load Testing for Landing Page")
	public void testLoadOfOverview() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForOverivew();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Landing page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority=1, description = "1.2-Load Testing for On Chiller Status Widget")
	public void testLoadOfOnChillerStatusWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForOnChillerStatusWidget();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "On Chiller Status Widget not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=2, description = "1.3-Load Testing for Customer List by Status on click of any color.")
	public void testLoadOfCustomerListByStatus() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForCustomerListByStatus();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Customer List By Status not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=3, description = "1.4-Load Testing for Chiller Information Widget.")
	public void testLoadOfChillerInfoWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfChillerInfoWidget();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Information Widget not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=4, description = "1.5-Load Testing for Status Check/Health Check Widget.")
	public void testLoadOfStatusHealthChkWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfStatusHealthChkWidget();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check/Health Check Widget not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=5, description = "1.6-Load Testing for Moving from customer list by Status widget Chiller information in Landing Page to trend Screen.")
	public void testLoadOfTrends() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForTrends();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=6, description = "1.7-Load Testing for Moving from Status check/Health Check (Status check) in Landing Page to trend Screen.")
	public void testLoadOfTrendsFromStatusChk() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfTrendsFromStatusChk();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=7, description = "2.1-Load Testing for all Widgets in Trends page.")
	public void testLoadOfTrendsForAllWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfAllTrendsWidgets();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=8, description = "2.2-Load Testing for Trends page when transitioning from 5d to 12 H/24H/1W/2W/1M  data.")
	public void testLoadOfTrendsAfterTransition() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfTrendsAfterTransition();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly during transition.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=9, description = "2.3-Load Testing for Trends page when transitioning by moving the slider.")
	public void testLoadOfTrendsTransitionMovingSlider() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForTrendsAfterMovingSlider();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly during transition.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=10, description = "2.4-Load Testing for loading up of Manage Active Points screen in Trends page.")
	public void testLoadOfTrendsManagePoints() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForTrendsManageActivePoints();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Manage Active points not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=11, description = "2.5-Load Testing for adding points and population of the Dashboards after selection of points in Trends page.")
	public void testLoadOfTrendsAfterAddingPoints() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForTrendsAfterAddingPoints();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends page not loaded properly after addition of points.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=12, description = "2.6-Load Testing for expansion of any dashboard in Trends page.")
	public void testLoadOfExpansionOfDashboard() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfDashboradExpansion();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Charts not loaded properly after expansion.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=13, description = "2.7-Load Testing loading of Chiller Snapshot in Trends page.")
	public void testLoadOfTrendsChillerSnapshot() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfChillerSnapshot();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Trends Chiller Snapshot not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=14, description = "2.8-Load Testing of moving to Edit Screen in Chiller Snapshot in Trends page.")
	public void testLoadOfTrendsChillerSnapshotEdit() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfEditChillerSnapshot();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit Chiller Snapshot not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=15, description = "2.9-Load Testing for completion of Save Functionality of Chiller Snapshot report in Trends page.")
	public void testLoadOfTrendsSaveChillerSnapshot() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfSaveChillerSnapshot();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Save PDF not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=16, description = "2.10-Load Testing for transitioning from Chart View to Grid View in Trends page.")
	public void testLoadOfTrendsTransitionFromChartToGrid() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfGridData();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Grid data not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=17, description = "2.11-Load Testing for transitioning from Grid View to Excel CSV Export in Trends page.")
	public void testLoadOfTrendsTransitionFromGridToCSV() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfCSV();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Export to CSV not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=18, description = "2.12-Load Testing for transitioning from Grid View to Pdf in Trends page.")
	public void testLoadOfTrendsTransitionFromGridToPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfTrendPDF();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "PDF not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=19, description = "2.a-Load Testing for transition from Trend to Comparative report widget")
	public void testLoadOfComparativePage() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForComparative();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Comparative page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=20, description = "2.b-Load Testing for Selection of Chart and loading in Comparative report widget")
	public void testLoadOfAddChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadForAddComparativeChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Comparative page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=20, description = "2.d-Load Testing for Expansion of any dashboard in Comparative report widget")
	public void testLoadOfComparativeMaximize() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateCompLoadForMaximizeOfChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Comparative page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=21, description = "2.e-Load Testing for chiller snapshot in Comparative report widget")
	public void testLoadOfComparativeChillerSnapshot() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfChillerSnapshotComp();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Comparative page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=22, description = "2.f-Load Testing for Edit Chiller snapshot in Comparative report widget")
	public void testLoadOfComparativeEditChillerSnapshot() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_PerformanceTesting_Page_Action objPerf = new CEP_PerformanceTesting_Page_Action(driver, logger);
			objLogin.loginToCEPQWithAdmin();
			objPerf.validateLoadOfEditChillerSnapshotComp();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Comparative page not loaded properly.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
