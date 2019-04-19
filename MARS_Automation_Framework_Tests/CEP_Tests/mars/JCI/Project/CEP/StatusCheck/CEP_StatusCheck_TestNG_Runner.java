package mars.JCI.Project.CEP.StatusCheck;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.HealthCheck.CEP_HealthCheck_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_StatusCheck_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "TC80048-To check and verify the 'Status/Health check' summary tab")
	public void testSummaryTab() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateSummaryTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Summary Tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "TC80052-To check and verify the default information on  'Status check' summary tab")
	public void testDefaultInfo() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateDefaultInfoForRed();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Information in Summary Tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 2, description = "TC80056-To check and verify the 'Status check' as default selection of dropdown on  'Status/Health check' summary tab")
	public void testFieldForHealthCheck() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateDropDownDefaultValue();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Information in Summary Tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3, description = "TC83794-To check and verify the default information of Status check on change of the color")
	public void testDefaultInformation() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateDefaultInfoForRed();
			objStatusCheck.validateDefaultInfoForGreen();
			objStatusCheck.validateDefaultInfoForGrey();
			objStatusCheck.validateDefaultInfoForYellow();
			objStatusCheck.validateDefaultInfoForOrange();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4, description = "TC80060-To verify the functionality of dropdown field as Status check on 'status/health check' summary tab")
	public void testStatusCheckDropDown() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateDropDown();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Status Check drop down is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 5, description = "TC80082-To check and verify the functionality of 'Diagnostic summary' for the 'Status check'")
	public void testStatusCheckDiagonstic() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_StatusCheck_Page_Action objStatusCheck = new CEP_StatusCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objStatusCheck.validateDiagnosticSummary();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Diagnostic Summary for Status Check is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 6, description = "TC80058-To check and verify the summary on selection of 'Health check' into dropdown")
	public void testSummaryForHealthCheck() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheck_Page_Action objHealthCheck = new CEP_HealthCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objHealthCheck.validateSummaryForHealthCheck();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Health Check summary is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 7, description = "TC80059-To verify the functionality of dropdown field as Health check on 'status/health check' summary tab")
	public void testHealthCheckDropDown() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_HealthCheck_Page_Action objHealthCheck = new CEP_HealthCheck_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			Thread.sleep(15000);
			objHealthCheck.validateDropDown();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Health Check drop down is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}



}
