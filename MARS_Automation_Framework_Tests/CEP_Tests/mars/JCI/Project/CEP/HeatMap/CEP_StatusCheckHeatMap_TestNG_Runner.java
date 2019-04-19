package mars.JCI.Project.CEP.HeatMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_StatusCheckHeatMap_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "TC79164-To check and verify the 'Status/Health check' tab")
	public void testStatusCheckSection() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Status Check tab is as expected.");
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "TC79167-To check and verify the dropdown field on Status/Health check tab")
	public void testDefaultValue() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objStatusCheck.validateDefaultValue();
			Thread.sleep(5000);
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check drop down box is not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 2, description = "TC79170-To verify the functionality of dropdown field on status/Health check dashboard")
	public void testHeatMapBifurcation() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(5000);
			objStatusCheck.validateColorBifurcation();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Heat map bifurcation for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3, description = "TC79171-To check and verify the 'Heat Map' on 'Status/Health Status' tab")
	public void testBifurcationFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(5000);
			objStatusCheck.validateBifurcationFunction();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Heat map bifurcation for Health Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 4, description = "TC79173,TC79174&TC79184-To check and verify the Heat map bifurcation based on 5 colors")
	public void testColorsInHeatMapForJCI() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(5000);
			objLeftPanel.left_panel_details_loaded();
			objStatusCheck.validateColorsForJCI();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Heat Map Bifurcation is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 5, description = "TC79185&79233-To check and verify the functionality of color widget")
	public void testColorWidgetFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(10000);
			objStatusCheck.validateRedColorWidgetDetails();
			objStatusCheck.validateGreenColorWidgetDetails();
			objStatusCheck.validateYellowColorWidgetDetails();
			objStatusCheck.validateOrangeColorWidgetDetails();
			objStatusCheck.validateGreyColorWidgetDetails();

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Functionlity of color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 6, description = "TC79245-To verify color widgets of the 'Status Check' to be changed as per 'Geography'")
	public void testColorWidgetCountForGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(3000);
			objStatusCheck.validateColorWidgetGeography();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color widgets for Geography is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 7, description = "TC79250- To verify color widgets of the 'Status Check' to be changed as per 'Country'")
	public void testColorWidgetCountForCountry() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(3000);
			objStatusCheck.validateColorWidgetCountry();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color widgets for Country is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 8, description = "TC79252-  To verify color widgets of the 'Status Check' to be changed as per 'Branch'")
	public void testColorWidgetCountForBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_StatusCheckHeatMap_Page_Action objStatusCheck = new CEP_StatusCheckHeatMap_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(3000);
			objStatusCheck.validateColorWidgetBranch();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Color widgets for Branch is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
