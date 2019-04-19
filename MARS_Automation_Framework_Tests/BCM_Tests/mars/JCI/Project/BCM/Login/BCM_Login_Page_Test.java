
/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/

package mars.JCI.Project.BCM.Login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Constants.TextConstants;

public class BCM_Login_Page_Test extends BaseClass {
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static BCM_Login_Page_Action bcm_login_page_action = null;

	private static void initializeTest() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		bcm_login_page_action = new BCM_Login_Page_Action(driver, logger);
	}
	
	@Test(description = "Login - Verify error message if all fields are blank", priority = 1)
	public void verifyErrorMessageForAllFieldsBlank(Method method) {
		initializeTest();
		String errMsg = bcm_login_page_action.verifyErrorMessageForAllFieldsBlank("", "");

		boolean testStatus = false;
		if (errMsg.equalsIgnoreCase("Please enter user name and password")) {
			testStatus = true;
		}
		System.out.println(method.getAnnotation(Test.class).description());
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify error message for blank username", priority = 1)
	public void verifyMessageForBlankUserName(Method method) {
		initializeTest();
		String errMsg = bcm_login_page_action.verifyErrorMessageForBlankUserName("", "test");

		boolean testStatus = false;
		if (errMsg.equalsIgnoreCase("Please enter username")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify error message for Incorrect username", priority = 1)
	public void verifyMessageForIncorrectUserName(Method method) {
		initializeTest();
		String errMsg = bcm_login_page_action.verifyErrorMessageForIncorrectUserName("test", "test");
		boolean testStatus = false;

		if (errMsg.equalsIgnoreCase(TextConstants.LOGIN_INVALID_LOGIN_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify error message for blank password", priority = 1)
	public void verifyMessageForBlankPassword(Method method) {
		initializeTest();

		String errMsg = bcm_login_page_action.verifyErrorMessageForBlankPassword("Admin", "");
		boolean testStatus = false;
		if (errMsg.equalsIgnoreCase("Please enter password")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify error message for Incorrect password", priority = 1)
	public void verifyMessageForIncorrectPassword(Method method) {
		initializeTest();
		String errMsg = bcm_login_page_action.verifyErrorMessageForIncorrectPassword("test", "test");
		boolean testStatus = false;

		if (errMsg.equalsIgnoreCase(TextConstants.LOGIN_INVALID_LOGIN_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);

	}

	//@Test(description = "Login - Verify BCM header text", priority = 1)
	public void verifyBCMHeaderText(Method method) {
		initializeTest();

		String errMsg = bcm_login_page_action.verifyBCMHeader();

		boolean testStatus = false;
		if (errMsg.equalsIgnoreCase("Building Control Manager")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify copyright info", priority = 1)
	public void verifyCopyRightInfo(Method method) {
		initializeTest();
		boolean testStatus = false;
		String errMsg = bcm_login_page_action.verifyCopyRightInfo();

		if (errMsg.equalsIgnoreCase(TextConstants.LOGIN_COPYRIGHT_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify best viewed text", priority = 1)
	public void verifyBestViewedInfo(Method method) {
		initializeTest();
		String errInfo = null;
		boolean testStatus = false;
		errInfo = bcm_login_page_action.verifybestViewedText();
		if (errInfo.equalsIgnoreCase(TextConstants.LOGIN_BESTVIEWED_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify user is successfully able to login with correct credentials", priority = 2)
	public void verifySuccessfulLogin(Method method) {
		initializeTest();
		boolean errInfo = false;
		boolean testStatus = false;
		errInfo = bcm_login_page_action.successfulLogin("bcmsysagent", "Aug@2016");
		System.out.println("errInfo" + errInfo);
		if (errInfo) {
			testStatus = true;

		}
		System.out.println("testStatus = " + testStatus);
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	//@Test(description = "Login - Verify for first login, user should be asked to change password", priority = 2)
	public void firstUserLogin(Method method) {
		initializeTest();
		String errInfo = null;
		boolean testStatus = false;
		errInfo = bcm_login_page_action.firstUserLogin("pandey", "Password@1");
		if (errInfo.equalsIgnoreCase("Change Password")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
}
