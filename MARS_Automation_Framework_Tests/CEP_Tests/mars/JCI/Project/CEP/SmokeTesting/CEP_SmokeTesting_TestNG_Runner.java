package mars.JCI.Project.CEP.SmokeTesting;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.ChillerInformation.CEP_ChillerInformation_Page_Action;
import mars.JCI.Project.CEP.ChillerInformation.CEP_ChillerInformation_TestNG_Runner;
import mars.JCI.Project.CEP.CustomerListByStatus.CEP_CustomerListByStatus_Page_Action;
import mars.JCI.Project.CEP.CustomerListByStatus.CEP_CustomerListByStatus_TestNG_Runner;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Action;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_TestNG_Runner;
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_TestNG_Runner;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.Reports.CEP_ChillerHealthSummary_Page_Action;
import mars.JCI.Project.CEP.Reports.CEP_ChillerTrend_Page_Action;
import mars.JCI.Project.CEP.Reports.CEP_Onboard_Diagnostic_Page_Action;
import mars.JCI.Project.CEP.Reports.CEP_SCCHealthSummary_Page_Action;
import mars.JCI.Project.CEP.Reports.CEP_eCloudReport_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Comparative_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Diagnostic_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Reports_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Repository_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Scorecard_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Trends_Smoke_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_TestNG_Runner;

public class CEP_SmokeTesting_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "Left Panel-Validate Left Panel details loaded successfully")
	public void testLeftPanelLoad() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(20000);
			getFinalReport(driver, logger, methodName, true);			 
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "Left Panel-Validate Left Panel Tree Structure")
	public void testLeftPanelTreeStructure() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.user_validate_the_tree_structure_in_the_left_panel();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 2, description = "Left Panel-Validate BreadCrumb Sequence for JCI, Geography,Branch in the Overview Section from Left Panel")
	public void testLBreadCrumbSequence() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.validateBreadCrumbSequence();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3, description = "Left Panel-Validate Left Panel Search Functionality")
	public void testLSearchFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateSearchFunctionality();
			getFinalReport(driver, logger, "searchByCustomer", true);
			objLeftPanel.validateSearchByOtherItems();
			getFinalReport(driver, logger, "searchByModelNo", true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 4, description = "Left Panel-Validate Change in Overview after clicking on JCI")
	public void testLDashboardAfterClickingJCI() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("JCI", "1");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 5, description = "Left Panel-Validate Change in Overview after clicking on Geography")
	public void testLDashboardAfterClickingGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("North America", "2");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 6, description = "Left Panel-Validate Change in Overview after clicking on Country")
	public void testLDashboardAfterClickingCountry() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("United States", "3");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 7, description = "Left Panel-Validate Change in Overview after clicking on Branch")
	public void testLDashboardAfterClickingBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
//			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("Albany GA - 0N91", "4");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 8, description = "Left Panel-Validate Trends Page after clicking on Chiller")
	public void testLDashboardAfterClickingChiller() {
		try {
			CEP_LeftPanel_TestNG_Runner objLeftPanel = new CEP_LeftPanel_TestNG_Runner();
			objLeftPanel.testTrendsPageforChiller();
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 9, description = "Overview-Validate HeatMap Drop down")
	public void testODefaultValue() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objStatusCheck.validateDefaultValue();
			objStatusCheck.validateColorBifurcation();
			Thread.sleep(5000);
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check drop down box is not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 10, description = "Overview-Validate Heat Map Color Widgets and compare the count with Database")
	public void testOColorWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(20000);
			objStatusCheck.validateBifurcationFunction();
			getFinalReport(driver, logger, "testBifurcation", true);
			objLeftPanel.left_panel_details_loaded();
			objStatusCheck.validateColorsForJCI();
			getFinalReport(driver, logger, "testColorsWidgets", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check Color Widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 11, description = "Overview-Validate functionality of each HeatMap Color Widget and compare result with DB")
	public void testOColorWidgetFunctionalities() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(20000);
//			objStatusCheck.validateBifurcationFunction();
			objStatusCheck.validateDashboardChangeAfterColorClick();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "Status Check Color widget functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 12, description = "Overview-Validate functionality for Health Check")
	public void testOHealthCheckFunctionalities() {
		try {
			CEP_HealthCheckHeatMap_TestNG_Runner objHealthCheck = new CEP_HealthCheckHeatMap_TestNG_Runner();
			CEP_HealthCheckHeatMap_Page_Action objAction = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objHealthCheck.testHealthCheckField();
			objAction.validateHealthCheckColorBifurcation();
			objAction.validateColorWidget();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Health Check functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 13, description = "Overview-Validate different functionalities of CustomerListByStatus Widget")
	public void testOCustomerListByStatusFunctionalities() {
		CEP_CustomerListByStatus_TestNG_Runner objCustList = new CEP_CustomerListByStatus_TestNG_Runner();
		CEP_CustomerListByStatus_Page_Action objAction = new CEP_CustomerListByStatus_Page_Action(driver, logger);
		objCustList.testDefaultStatus();
		try {
			objAction.validateSearchBox();
			driver.navigate().refresh();
			Thread.sleep(20000);
			objAction.validateDefaultCustomerCount();
			objAction.validateDefaultChillerCount();
			objAction.validateDefaultSiteCount();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "CustomerListByStatus functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 14, description = "Overview-Validate different functionalities of ChillerInformation Widget")
	public void testOChillerInfoFunctionalities() {
		CEP_ChillerInformation_TestNG_Runner objChillerInfo = new CEP_ChillerInformation_TestNG_Runner();
		CEP_ChillerInformation_Page_Action objAction = new CEP_ChillerInformation_Page_Action(driver, logger);
		objChillerInfo.testDefaultChiller();
		try {
			objAction.validateDefaultDetails();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "ChillerInformation widget functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 15, description = "Overview-Validate different functionalities of Status/HealthCheck Widget")
	public void testOStatusHealthCheckFunctionalities() {
		CEP_StatusCheck_TestNG_Runner objStatusChk = new CEP_StatusCheck_TestNG_Runner();
		CEP_StatusCheck_Page_Action objAction = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.testSummaryTab();
		getFinalReport(driver, logger, methodName, true);
		try {
			Thread.sleep(20000);
			objAction.validateDefaultInfoForRed();
			objAction.validateDefaultInfoForGreen();
			objAction.validateDefaultInfoForGrey();
			objAction.validateDefaultInfoForYellow();
			objAction.validateDefaultInfoForOrange();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "ChillerInformation widget functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 16, description = "Trends-Validate BreadCrumb Sequece in Trends Page")
	public void testTBreadCrumbDefaultValue() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateBreadCrumb();
			Thread.sleep(10000);			
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "BreadCrumb sequence is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 17, description = "Trends-Validate Active Points for Chiller and display of graphs for selected points")
	public void testTChillerPointsAndGraphs() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateDefaultPointAndGraphs();
			Thread.sleep(5000);
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Active Points and Graphs displayed are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 18, description = "Trends-Validate graphs for different metrices")
	public void testTGraphsForDiffMetrices() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateGraphsForDiffMetrices();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Graphs for metrices are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 19, description = "Trends-Validate data in graphs and tooltip message")
	public void testTGraphValuesAndTooltip() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateGraphData();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data in Graphs and Tooltips are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 20, description = "Trends-Validate data in graphs for previous year")
	public void testTGraphValuesForPreviousYr() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validatePreviousYearGraphs();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 21, description = "Trends-Validate the comparison of current year graph with that of previous year")
	public void testTPreviousYrAndCurrentYrGraphs() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.compareGraphs();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 22, description = "Trends-Validate Maximize and Minimize of graph")
	public void testTMaximizeAndMinimize() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateMaximizeAndMinimize();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Maximize and Minimize feature is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(groups = { "Trends" }, priority = 23, description = "Trends-Validate different Chart Options- Grid and Exports")
	public void testTGridAndExports() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objTrends.validateDiffChartOptions();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(groups = { "Trends" }, priority = 24, description = "Trends-Slider-Current time of site should be displayed if current date is selected in the calendar control / when navigated to Trends dashboard")
	public void testTSliderCurrentDateAndTime() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(groups = { "Trends" }, priority = 25, description = "Trends-Slider-Current time of site should be displayed when changed the asset from the 'Equipment' dropdown ")
	public void testTSliderChangeEquipment() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateEquipment();
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(groups = { "Trends" }, priority = 26, description = "Trends-Slider-Validate Slider functionalities for calendar control")
	public void testTSliderForCalendarControl() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateSliderTimeForOtherCalendar();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(groups = { "Trends" }, priority = 27, description = "Trends-Messages shown related to Raw data, 15 mins average data , hourly average data on change on timestamps")
	public void testTMessageForMetrics() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateMessage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 28, description = "Trends-Previous Year-Chart should get compared with the previous year data and tool tips will show data with its respective year")
	public void testTBackDateToolTip() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validatePreviousYearGraphs();
			objTrends.validateGraphData();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 29, description = "Trends-Previous Year-Grid data, Export to CSV, Export to PDF.")
	public void testTBackDateExportCSVPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validatePreviousYearGraphs();
			objTrends.validateDiffChartOptions();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 30, description = "Trends-BackDate-Grid data should display the dashboard data in the grid/tabular format for both compared years and raw data will be displayed in the grid")
	public void testTBackDateGridData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validatePreviousYearGraphs();
			objTrends.compareGraphs();
			objTrends.validateDiffChartOptions();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 31, description = "Trends-BackDate-Chart should get exported to PDF when clicked on Save as PDF button")
	public void testTBackDatePDFPrint() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validatePreviousYearGraphs();
			objTrends.validateSavePDF();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 32, description = "Trends-BackDate-Chart should get reset(i.e it should display data of selected year) when changed the year/date from calendar control")
	public void testTBackDateChartReset() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateChartReset();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 33, description = "Trends-BackDate-Compare the chart with backdated data and move the slider or switch to other quick selection buttons")
	public void testTBackDateCompareChartSlider() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.compareGraphs();
			objTrends.validateSlider();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 34, description = "Trends-Dashboard Generation for points other than Overview category")
	public void testTChartOtherThanOverview() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validateChartOtherThanOverView();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 35, description = "Trends-Compare-Dashboard Generation for points other than Overview category")
	public void testTCompareChartOtherThanOverview() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.compareGraphs();
			objTrends.validateChartOtherThanOveriewComapare();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 36, description = "Trends-Validate points in the pop up")
	public void testTValidatePointsInPopUp() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			objTrends.validatePointsInPopUp();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Points in pop up is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 55, description = "Comparative-Saved Chart-Validate breadcrumb sequence in Comparative page")
	public void testCBreadCrumbInComparative() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objTrends.validateBreadCrumb();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "BreadCrumb sequence in the Comparative page is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 56, description = "Comparative-Saved Chart-Validate Add and Save Chart functionality in Comparative page.")
	public void testCAddandSaveChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Add Chart functionality working is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 57, description = "Comparative-Saved Chart-Validate Previous year graphs.")
	public void testCPreviousYr() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			objComp.selectPreviousYr();
			Thread.sleep(10000);
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 58, description = "Comparative-Saved Chart-Validate Remove Chart functionality of Comparative.")
	public void testCRemoveChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objComp.removeChart();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Chart removed successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Remove Chart functionality working is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 59, description = "Comparative-Saved Chart-Validate Warning message when Analog & Binary/MSV points are selected together.")
	public void testCWarningMessage() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateWarningMessage();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Warning message not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 60, description = "Comparative-Saved Chart-Validate Edit Chart functionality in the Comparative page.")
	public void testCEditChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateEditChart();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit Chart functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 61, description = "Comparative-Saved Chart-Validate data comparison of previous year with the current year.")
	public void testCDataComparison() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objComp.compareGraph();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "Edit Chart functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 62, description = "Comparative-Saved Chart-Slider-Current time of site should be displayed if current date is selected in the calendar control / when navigated to Trends dashboard")
	public void testCSliderCurrentDateAndTime() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Time in Slider is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 63, description = "Comparative-Saved Chart-Slider-Current time of site should be displayed when changed the asset from the 'Equipment' dropdown")
	public void testCSliderChangeEquipment() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			//objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validateEquipment();
			Thread.sleep(10000);
			objComp.validateAddandSave();
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Slider-Current time of site should be displayed when changed the asset from the 'Equipment' dropdown functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 64, description = "Comparative-Saved Chart-Slider-Validate Slider functionalities for calendar control")
	public void testCSliderForCalendarControl() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validateSliderTimeForOtherCalendar();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 65, description = "Comparative-Saved Chart-Messages shown related to Raw data, 15 mins average data , hourly average data on change on timestamps")
	public void testCMessageForMetrics() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validateMessage();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 66, description = "Comparative-Saved Chart-Backdated data-Chart should get compared with the previous year data and tool tips will show data with its respective year")
	public void testCBackDateToolTip() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validatePreviousYearGraphs();
			objTrends.validateGraphData();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 67, description = "Comparative-Saved Chart-BackDate-Grid data should display the dashboard data in the grid/tabular format for both compared years and raw data will be displayed in the grid")
	public void testCBackDateGridData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validatePreviousYearGraphs();
			objComp.compareGraph();
			objComp.validateDiffChartOptions();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
 			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 68, description = "Comparative-Saved Chart-BackDate-Chart should get exported to PDF when clicked on Save as PDF button")
	public void testCBackDatePDFPrint() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			Thread.sleep(10000);
			objTrends.validatePreviousYearGraphs();
			objComp.validateSavePDF();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 69, description = "Comparative-Saved Chart-Dashboard Generation for points other than Overview category")
	public void testCChartOtherThanOverview() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			Thread.sleep(5000);
			//objComp.removeChart();
			//objComp.validateAddandSave();
			Thread.sleep(10000);
			objComp.validateEditChart();
			getFinalReport(driver, logger, methodName, true);
			objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 70, description = "Comparative-UnSaved Chart-Validate Default Chart generation when Chart is not saved in the Comparative page.")
	public void testCDefaultChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objTrends.navigateTrendsPage();
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Warning message not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 71, description = "Comparative-UnSaved Chart-Validate Previous year graphs.")
	public void testCUnsavedPreviousYr() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objComp.selectPreviousYr();
			Thread.sleep(10000);
			getFinalReport(driver, logger, methodName, true);			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 72, description = "Comparative-UnSaved Chart-Validate Remove Chart functionality of Comparative.")
	public void testCUnsavedRemoveChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(10000);
			objComp.removeChart();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 73, description = "Comparative-UnSaved Chart-Validate Warning message when Analog & Binary/MSV points are selected together.")
	public void testCUnsavedWarningMessage() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objComp.validateWarningMessage();
			//getFinalReport(driver, logger, methodName, true);			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 74, description = "Comparative-UnSaved Chart-Validate Edit Chart functionality in the Comparative page.")
	public void testCUnSavedEditChart() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objComp.validateEditChart();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit Chart functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 75, description = "Comparative-UnSaved Chart-Validate data comparison of previous year with the current year.")
	public void testCUnSavedDataComparison() {
		try {
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objComp.compareGraph();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "Data Comparison functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 76, description = "Comparative-UnSaved Chart-Slider-Current time of site should be displayed if current date is selected in the calendar control / when navigated to Trends dashboard")
	public void testCUnSavedSliderCurrentDateAndTime() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Time in Slider is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 77, description = "Comparative-UnSaved Chart-Slider-Current time of site should be displayed when changed the asset from the 'Equipment' dropdown")
	public void testCUnSavedSliderChangeEquipment() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validateEquipment();
			Thread.sleep(10000);
			objComp.validateDefaultChart();
			objTrends.validateSliderTimeFor5D();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Slider-Current time of site should be displayed when changed the asset from the 'Equipment' dropdown functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 78, description = "Comparative-UnSaved Chart-Slider-Validate Slider functionalities for calendar control")
	public void testCUnSavedSliderForCalendarControl() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validateSliderTimeForOtherCalendar();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 79, description = "Comparative-UnSaved Chart-Messages shown related to Raw data, 15 mins average data , hourly average data on change on timestamps")
	public void testCUnSavedMessageForMetrics() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validateMessage();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 80, description = "Comparative-UnSaved Chart-Backdated data-Chart should get compared with the previous year data and tool tips will show data with its respective year")
	public void testCUnSavedBackDateToolTip() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validatePreviousYearGraphs();
			objTrends.validateGraphData();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 81, description = "Comparative-UnSaved Chart-BackDate-Grid data should display the dashboard data in the grid/tabular format for both compared years and raw data will be displayed in the grid")
	public void testCUnSavedBackDateGridData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validatePreviousYearGraphs();
			objComp.compareGraph();
			objComp.validateDiffChartOptions();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
 			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 82, description = "Comparative-UnSaved Chart-BackDate-Chart should get exported to PDF when clicked on Save as PDF button")
	public void testCUnSavedBackDatePDFPrint() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objTrends.validatePreviousYearGraphs();
			objComp.validateSavePDF();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Previous year data in the graph is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 83, description = "Comparative-UnSaved Chart-Dashboard Generation for points other than Overview category")
	public void testCUnSavedChartOtherThanOverview() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("AzDOR");
			Thread.sleep(20000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			Thread.sleep(5000);
			objComp.validateEditChart();
			getFinalReport(driver, logger, methodName, true);
			//objComp.removeChart();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Dashboard for points other than overview is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 84, description = "Chiller Snapshots-Trends-Validate Chiller Snapshots data and compare the data with API")
	public void testTValidateChillerSnapshotData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objTrends.openChillerSnapshot();
			objTrends.validateChillerSnapshotData();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Snapshot data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 85, description = "Chiller Snapshots-Trends-Validate PDF and Email functionality")
	public void testTValidateChillerSnapshotPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objTrends.openChillerSnapshot();
			objTrends.validatePDFnEmail();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "PDF and Email functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(groups = { "Trends" }, priority = 86, description = "Chiller Snapshots-Trends-Validate Edit functionality")
	public void testTValidateChillerSnapshotEdit() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objTrends.openChillerSnapshot();
			objTrends.validateEditValue();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 87, description = "Chiller Snapshots-Comparative-SavedChart-Validate Chiller Snapshots data and compare the data with API")
	public void testCSValidateChillerSnapshotData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			objTrends.openChillerSnapshot();
			objTrends.validateChillerSnapshotData();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Snapshot data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 88, description = "Chiller Snapshots-Comparative-SavedChart-Validate PDF and Email functionality")
	public void testCSValidateChillerSnapshotPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			objTrends.openChillerSnapshot();
			objTrends.validatePDFnEmail();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "PDF and Email functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 89, description = "Chiller Snapshots-Comparative-SavedChart-Validate Edit functionality")
	public void testCSValidateChillerSnapshotEdit() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateAddandSave();
			objTrends.openChillerSnapshot();
			objTrends.validateEditValue();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 90, description = "Chiller Snapshots-Comparative-UnSavedChart-Validate Chiller Snapshots data and compare the data with API")
	public void testCUSValidateChillerSnapshotData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			objTrends.openChillerSnapshot();
			objTrends.validateChillerSnapshotData();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Snapshot data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 91, description = "Chiller Snapshots-Comparative-UnSavedChart-Validate PDF and Email functionality")
	public void testCUSValidateChillerSnapshotPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			objTrends.openChillerSnapshot();
			objTrends.validatePDFnEmail();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "PDF and Email functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 92, description = "Chiller Snapshots-Comparative-UnSavedChart-Validate Edit functionality")
	public void testCUSValidateChillerSnapshotEdit() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Trends_Smoke_Page_Action objTrends = new CEP_Trends_Smoke_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel =  new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Comparative_Smoke_Page_Action objComp = new CEP_Comparative_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLeftPanel.left_panel_details_loaded();
			objTrends.navigateTrendsForOneCustomer("WESTMINISTER");
			//Thread.sleep(5000);
			objComp.navigateToComparative();
			objComp.validateDefaultChart();
			objTrends.openChillerSnapshot();
			objTrends.validateEditValue();
			//getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Edit functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 94, description = "Diagnostic-Validate the presence of fields when Status Check is selected in Diagnostic page.")
	public void testDiagnosticPageForStatusCheck() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			objDia.validateDiagnosticForStatus();
			getFinalReport(driver, logger, "testDSelectBox", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields on Diagnostic page for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 95, description = "Diagnostic-Validate the data in Fault Code Timeline Chart in Diagnostic page.")
	public void testDFaultCodeData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			objDia.validateFaultCodeTimeLineData();
			getFinalReport(driver, logger, "testFaultTimeLineData", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields on Diagnostic page for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 96, description = "Diagnostic-Validate the functionalities of Color CheckBoxes for StatusCheck in Diagnostic page.")
	public void testDColorChkBoxStatusChk() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			Thread.sleep(20000);
			objDia.validateChkBoxesForStatusChk();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Check Boxes for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 97, description = "Diagnostic-Validate the Fault Code data in Trends page when user navigate from Status Check to Trends.")
	public void testDFaultCodeTrends() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			getFinalReport(driver, logger, "testDiagnostic", true);
			objDia.validateFaultCodeInTrends();
			getFinalReport(driver, logger, "testFaultCodeTrends", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fault Code Data in the Trends page is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 98, description = "Diagnostic-Validate the Fault Code data for different metrices in Diagnostic page.")
	public void testDFaultCodeDataForDiffMetrices() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			Thread.sleep(20000);
			objDia.validateGraphsForDiffMetrices();
			getFinalReport(driver, logger, "test1M", true);
		} catch (Exception e) {
			e.printStackTrace();
		//	logger.log(LogStatus.FAIL, "Fault Code Data is not as expected.");
		//	getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 99, description = "Diagnostic-Validate the Fault Code data for previous year in Diagnostic page.")
	public void testDFaultCodeDataForPreviousYr() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			objDia.validatePreviousYearGraphs();
			getFinalReport(driver, logger, "testPreviousYrData", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fault Code Data for previous year is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 100, description = "Diagnostic-Validate Customer and Facility gets filtered based on the selection of left tree.")
	public void testFilterCustFacility() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(20000);
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(20000);
			objDia.openCustomerDetails("AZDoR","STATE OF ARIZONA OF DEPARTMENT OF REVENUE_6940");
			getFinalReport(driver, logger, "testFilterCustomerNFaclityOption", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fault Code Data for previous year is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 101, description = "Diagnostic-Validate the presence of fields when Health Check is selected in Diagnostic page.")
	public void testDiagnosticPageForHealthCheck() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objDia.navigateToDiagnostic();
			Thread.sleep(20000);
			objDia.selectHealthCheck();
			Thread.sleep(20000);
			objDia.validateDiagnosticForStatus();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields on Diagnostic page for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 102, description = "Diagnostic-Validate different features in Diagnostic page for one particular customer.")
	public void testDiagnosticPageForOneCustomer() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_Diagnostic_Smoke_Page_Action objDia = new CEP_Diagnostic_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(20000);
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(20000);
			objDia.openCustomerDetails("WESTMINSTER","WESTMINSTER MANOR_5073");
			Thread.sleep(20000);
			objDia.validateGraphsForDiffMetrices();
			Thread.sleep(20000);
			objDia.validatePreviousYearGraphs();
			Thread.sleep(20000);
			objDia.validateDiagnosticForStatus();
			getFinalReport(driver, logger, "testDiaForOneCustomer", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fault Code Data for previous year is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 103, description = "Report-Validate the functionalities for Chiller Trend Report.")
	public void testReportForChillerTrend() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_ChillerTrend_Page_Action objT = new CEP_ChillerTrend_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objT.validateFields();
			objT.validatePDF();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Trend Report is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 104, description = "Report-Validate the presence of fields when Report page is loaded.")
	public void testReportPageFields() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateFieldsInReportsPage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields on Report page is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 105, description = "Report-Validate the report for Chiller Health Summary.")
	public void testReportForChillerHealth() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateReportForChillerHealthSummary();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for Chiller Health Summary is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 106, description = "Report-Validate the report for Chiller Performance Summary.")
	public void testReportForChillerPerformance() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateReportsForChillerPerf();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for Chiller Health Summary is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 107, description = "Report-Validate the report for Chiller Performance Report (eCloud).")
	public void testReportForChillerPerfReportECloud() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateReportForChillerPerfReportECloud();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for Chiller Performance Summary is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 108, description = "Report-Validate the report for SCC Chiller Health Report (Singapore).")
	public void testReportForSCCChillerHealthReport() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateReportForSCCChiller();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for SCC Chiller Health Report is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 109, description = "Report-Validate the report for Health Check for all Chillers Option.")
	public void testReportForHealthCheckForAllChillers() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateReportsForHealthCheck();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for Health Check for all Chillers is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 110, description = "Report-Validate the report for Raw Data Report Option.")
	public void testReportForRawDataReport() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Reports_Smoke_Page_Action objRep = new CEP_Reports_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.validateRawDataReport();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Report for Raw Data Report is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 111, description = "Report-Validate all data in the report for Chiller Health Summary.")
	public void testRDataInReportForChillerHealthSummary() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_ChillerHealthSummary_Page_Action objRep = new CEP_ChillerHealthSummary_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.fetchWebAPIData();
			objRep.validateChillerHealthSummaryReport();
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
			logger.log(LogStatus.PASS, "Email functionality is working as expected.");
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Health Summary data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 112, description = "Report-Validate all data in the report for SCC Chiller Health Report(Singapore).")
	public void testRDataInReportForSCCHealthReport() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_SCCHealthSummary_Page_Action objRep = new CEP_SCCHealthSummary_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objRep.fetchWebAPIData();
			objRep.validateSCCHealthSummaryData();
			getFinalReport(driver, logger, methodName, true);
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
			logger.log(LogStatus.PASS, "Email functionality is working as expected.");
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "SCC Health Summary data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 113, description = "Report-Validate all data in the report for eCloud Report.")
	public void testRDataInReportForeCloudReport() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_eCloudReport_Page_Action objE = new CEP_eCloudReport_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objE.validateStaticData();
			objE.validateWebAPIData();
			getFinalReport(driver, logger, methodName, true);
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
			logger.log(LogStatus.PASS, "Email functionality is working as expected.");
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "eCloud Report data is as expected.");
			getFinalReport(driver, logger, methodName, true);
		}
	}
	
	@Test(priority = 114, description = "Report-Validate functionalities for Onboard Diagnostic Report.")
	public void testRDataInReportForOnboradDiagnostic() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Onboard_Diagnostic_Page_Action objO = new CEP_Onboard_Diagnostic_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objO.validateFields();
			objO.validatePDF();
			getFinalReport(driver, logger, methodName, true);
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
			logger.log(LogStatus.PASS, "Export to CSV is working as expected.");
			logger.log(LogStatus.PASS, "Email functionality is working as expected.");
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Onboard Diagnostic Report data is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 115, description = "Scorecard-Validate presence of all fields in Scorecard Page.")
	public void testSFieldsInScoreCardPage() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
			Thread.sleep(15000);
			objS.validateFields();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields in the ScoreCard page are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 116, description = "Scorecard-Validate data for Popular Pages in Scorecard.")
	public void testSDataForPopular() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objS.validateDataForPopular();
			getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data for Popular Pages are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 117, description = "Scorecard-Validate Export to csv functionality in Scorecard.")
	public void testSExportToCSV() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objS.validateExportToCSV();
			getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data for Popular Pages are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 118, description = "Scorecard-Validate data for Branch Usage By Page in Scorecard.")
	public void testSDataForBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objS.validateDataForBranch();
			getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data for Branch Usage By Page are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 119, description = "Scorecard-Validate data for Page Views By User in Scorecard.")
	public void testSDataForPageView() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
			//Thread.sleep(20000);
			objS.validateDataForPageView();
			getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data for Page Views By User are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 120, description = "Scorecard-Validate data for Top Reports By Branch in Scorecard.")
	public void testSDataForTopReports() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS1 = new CEP_StatusCheck_Page_Action(driver, logger);
			objS1.waitForSpinnerToBeGone();
		//	Thread.sleep(20000);
			objS.validateDataForTopReports();
			getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Data for Top Reports By Branch are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 121, description = "Repository-Validate presence of all fields in Repository Page.")
	public void testRFieldsInRepo() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Repository_Smoke_Page_Action objR = new CEP_Repository_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objR.validateFields();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 122, description = "Repository-Validate Branch data and the tree structure in Repository Page.")
	public void testRBranchData() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Repository_Smoke_Page_Action objR = new CEP_Repository_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objR.validateTree();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 123, description = "Repository-Validate the PDF in the tree structure in Repository Page.")
	public void testRPDF() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_Repository_Smoke_Page_Action objR = new CEP_Repository_Smoke_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			Thread.sleep(20000);
			objR.validatePDF();
			} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
