package mars.JCI.Project.CEP.HeatMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_HealthCheckHeatMap_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "TC79764-To check and verify the 'Health check' field")
	public void testHealthCheckField() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Health Check option is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 1, description = "TC79767-To verify the functionality of dropdown field as Health check on dashboard")
	public void testHealthCheckFieldFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			//Thread.sleep(3000);
			logger.log(LogStatus.PASS, "Bifurcation of the dashboard is as expected.");
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "Bifurcation of the dashboard is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 2, description = "TC79768-To check and verify the Heat map bifurcation based on 3 colors")
	public void testHeatMapBifurcation() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			objHealthCheck.validateHealthCheckColorBifurcation();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Heat map bifurcation for Health Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 3, description = "TC79769-To check and verify the functionality of color widget on health check tab")
	public void testColorWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			objHealthCheck.validateColorWidget();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Heat map bifurcation for Health Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 4, description = "TC79777-To check and verify the Health check count of respective color widget")
	public void testCountOfColorWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel=new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			objLeftPanel.left_panel_details_loaded();
			objHealthCheck.healthCheckTotalCountOfGreen();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Health Check Count for Color Widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 5, description = "TC79778-To check and verify the default color widget of 'health check'")
	public void testDefaultColor() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			objHealthCheck.defaultColorWidget();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Color Widget for Health Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 6, description = "TC79780-To verify state of the 'Health Check' to be changed to default selected tab after refreshing of page")
	public void testStatusAfterRefresh() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			driver.navigate().refresh();
			logger.log(LogStatus.PASS, "Page refreshed successfully.");
			objHealthCheck.selectHealthCheck();
			objHealthCheck.defaultColorWidget();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Color Widget for Health Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 7, description = "TC79782-To check and verify the count of chillers against the particular category")
	public void testCountOfChillers() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objHealthCheck.selectHealthCheck();
			objHealthCheck.healthCheckTotalCountOfGreen();
			logger.log(LogStatus.PASS, "Count of chillers for each category is as expeceted.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Count of chillers for each category is not as expeceted.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 8, description = "TC79783-To verify color widgets of the 'Health Check' to be changed as per 'Geography'")
	public void testCountOfChillersForGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel=new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objLeftPanel.left_panel_details_loaded();
			objHealthCheck.selectHealthCheck();
			objHealthCheck.validateGreenCountGeography();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color Widget of 'Health Check' is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 9, description = "TC79784- To verify color widgets of the 'Health Check' to be changed as per 'Country'")
	public void testCountOfChillersForCountry() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel=new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objLeftPanel.left_panel_details_loaded();
			objHealthCheck.selectHealthCheck();
			objHealthCheck.validateGreenCountCountry();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color Widget of 'Health Check' is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 10, description = "TC79785- To verify color widgets of the 'Health Check' to be changed as per 'Branch'")
	public void testCountOfChillersForBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel=new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_HealthCheckHeatMap_Page_Action objHealthCheck = new CEP_HealthCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(5000);
			objLeftPanel.left_panel_details_loaded();
			objHealthCheck.selectHealthCheck();
			objHealthCheck.validateGreenCountBranch();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color Widget of 'Health Check' is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}


}
