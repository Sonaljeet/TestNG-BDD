package mars.JCI.Project.CEP.SmokeTesting;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Trends_Smoke_Page_Action;

public class CEP_Trends_Smoke_TestNG_Runner extends BaseClass {
	@Test(description = "Validat BreadCrumb Sequece in Trends Page")
	public void testBreadCrumbDefaultValue() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(8000);
			objTrends.validateBreadCrumb();
			Thread.sleep(8000);
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "BreadCrumb sequence is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate Active Points for Chiller and display of graphs for selected points")
	public void testChillerPointsAndGraphs() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(5000);
			objTrends.validateDefaultPointAndGraphs();
			Thread.sleep(5000);
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Active Points and Graphs displayed are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate graphs for different metrices")
	public void testGraphsForDiffMetrices() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(5000);
			objTrends.validateGraphsForDiffMetrices();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Graphs for metrices are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate data in graphs and tooltip message")
	public void testGraphValuesAndTooltip() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(8000);
			objTrends.validateGraphData();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data in Graphs and Tooltips are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(description = "Validate data in graphs for previous year")
	public void testGraphValuesForPreviousYr() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(5000);
			objTrends.validatePreviousYearGraphs();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(description = "Validate the comparison of current year graph with that of previous year")
	public void testPreviousYrAndCurrentYrGraphs() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(10000);
			objTrends.compareGraphs();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(description = "Validate Maximize and Minimize of graph")
	public void testMaximizeAndMinimize() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(10000);
			objTrends.validateMaximizeAndMinimize();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(description = "Validate different Chart Options- Grid and Exports")
	public void testGridAndExports() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objTrends.navigateTrendsPage();
			Thread.sleep(10000);
			objTrends.validateDiffChartOptions();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
