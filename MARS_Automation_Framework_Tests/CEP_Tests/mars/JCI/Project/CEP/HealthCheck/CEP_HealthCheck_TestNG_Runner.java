package mars.JCI.Project.CEP.HealthCheck;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_HealthCheck_TestNG_Runner extends BaseClass {
	@Test(priority = 0, description = "TC80058-To check and verify the summary on selection of 'Health check' into dropdown")
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
	@Test(priority = 1, description = "TC80059-To verify the functionality of dropdown field as Health check on 'status/health check' summary tab")
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
