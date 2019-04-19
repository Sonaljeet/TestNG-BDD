package mars.JCI.Project.CEP.ChillerInformation;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.CustomerListByStatus.CEP_CustomerListByStatus_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;

public class CEP_ChillerInformation_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "TC78910-Verify title of the widget")
	public void testTitleOfTheWidget() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(10000);
			objChillerInfo.validateTitleOfWidget();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Title not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 1, description = "TC78947-Verify default chiller displayed in chiller information")
	public void testDefaultChiller() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objS = new CEP_StatusCheck_Page_Action(driver, logger);
			objS.waitForSpinnerToBeGone();
			objLogin.loginToCEPWithAdmin();
			
			//Thread.sleep(10000);
			objChillerInfo.validateDefaultChiller();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Chiller is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 2, description = "TC78938-View information displayed in Chiller information ")
	public void testDetailsInChillerInfo() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(20000);
			objChillerInfo.validateDefaultDetails();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Details in Chiller Information widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 3, description = "TC79279-Verify data in chiller information to be changed for a chiller when user clicks on geography from left panel tree")
	public void testChillerInfoForGeographies() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(10000);
			objLeftPanel.left_panel_details_loaded();
			objChillerInfo.validateChillerInfoForGeographies();
//			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Information widget for Geographies is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 4, description = "TC79280-Verify data in chiller information to be changed for a chiller when user clicks on country from left panel tree")
	public void testChillerInfoForCountries() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(10000);
			objLeftPanel.left_panel_details_loaded();
			objChillerInfo.validateChillerInfoForCountries();
//			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Information widget for Countries is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 5, description = "TC79281-Verify data in chiller information to be changed for a chiller when user clicks on branch from left panel tree")
	public void testChillerInfoForBranches() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(10000);
			objLeftPanel.left_panel_details_loaded();
			objChillerInfo.validateChillerInfoForBranches();
//			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Information widget for Branches is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 6, description = "TC79277-Verify forward and backward scroll functionality")
	public void testScroll() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
			CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			objChillerInfo.validateScrolls();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Scrolling functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
