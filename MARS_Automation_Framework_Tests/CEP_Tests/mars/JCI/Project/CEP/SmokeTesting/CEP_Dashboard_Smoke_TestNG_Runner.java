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
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_TestNG_Runner;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_TestNG_Runner;

public class CEP_Dashboard_Smoke_TestNG_Runner extends BaseClass {
	@Test(description = "Validate HeatMap Drop down")
	public void testDefaultValue() {
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
	
	@Test(description = "Validate Heat Map Color Widgets and compare the count with Database")
	public void testColorWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(5000);
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
	@Test(description = "Validate functionality of each HeatMap Color Widget and compare result with DB")
	public void testColorWidgetFunctionalities() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(10000);
			objStatusCheck.validateBifurcationFunction();
			objStatusCheck.validateDashboardChangeAfterColorClick();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check Color widget functionalities is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate functionality for Health Check")
	public void testHealthCheckFunctionalities() {
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
	@Test(description = "Validate different functionalities of CustomerListByStatus Widget")
	public void testCustomerListByStatusFunctionalities() {
		CEP_CustomerListByStatus_TestNG_Runner objCustList = new CEP_CustomerListByStatus_TestNG_Runner(); 
		CEP_CustomerListByStatus_Page_Action objAction = new CEP_CustomerListByStatus_Page_Action(driver,logger); 
		objCustList.testDefaultStatus();
		try {
			objAction.validateSearchBox();
			driver.navigate().refresh();
			Thread.sleep(10000);
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
	@Test(description = "Validate different functionalities of ChillerInformation Widget")
	public void testChillerInfoFunctionalities() {
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
	@Test(description = "Validate different functionalities of Status/HealthCheck Widget")
	public void testStatusHealthCheckFunctionalities() {
		CEP_StatusCheck_TestNG_Runner objStatusChk = new CEP_StatusCheck_TestNG_Runner(); 
		CEP_StatusCheck_Page_Action objAction = new CEP_StatusCheck_Page_Action(driver, logger); 
		objStatusChk.testSummaryTab();
		getFinalReport(driver, logger, methodName, true);
		try {
			Thread.sleep(15000);
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
}
