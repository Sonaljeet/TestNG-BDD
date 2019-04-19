package mars.JCI.Project.EQM.Login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.*;


public class EQM_Login_Test extends BaseClass
{
	// Common Class variables
	private static WebDriver driver= null;
	private static ExtentTest logger = null;
	private static EQM_Login_Page_Action EQM_login_page_action = null;

	private static void initializeTest()
	{
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		EQM_login_page_action = new EQM_Login_Page_Action(driver, logger);
	}

	@Test(description = "Verify Error Message For Incorrect password")
	public void verifyErrorMessageForIncorrectPassword(Method method) 
	{
		String errInfo = null;
		boolean testStatus = false;
		initializeTest();
		errInfo = EQM_login_page_action.verifyErrorMessageForBlankPassword("cgupta9", "monday9");

		if (errInfo.contains("We are unable to verify your user ID and/or password. Please verify your information and try again.")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	/*@Test(description = "Verify Error Message For Blank Password")
	public void verifyErrorMessageForBlankPassword(Method method) 
	{
		String errInfo = null;
		boolean testStatus = false;
		initializeTest();
		errInfo = EQM_login_page_action.verifyErrorMessageForBlankPassword("cgupta9", "");

		if (errInfo.contains("We are unable to verify your user ID and/or password. Please verify your information and try again.")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Verify Error Message For Incorrect UserName")
	public void verifyErrorMessageForIncorrectUserName(Method method) 
	{
		String errInfo = null;
		boolean testStatus = false;
		initializeTest();
		errInfo = EQM_login_page_action.verifyErrorMessageForBlankPassword("cgupta", "Cognizant123");

		if (errInfo.contains("We are unable to verify your user ID and/or password. Please verify your information and try again.")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	
	@Test(description = "Verify Error Message For Blank UserName")
	public void verifyErrorMessageForBlankUserName(Method method) 
	{
		String errInfo = null;
		boolean testStatus = false;
		initializeTest();
		errInfo = EQM_login_page_action.verifyErrorMessageForBlankPassword("cgupta", "Cognizant123");

		if (errInfo.contains("We are unable to verify your user ID and/or password. Please verify your information and try again.")) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}


	@Test(description = "Login - Verify user is successfully able to login with correct credentials")
	public void verifySuccessfulLogin(Method method) {
		initializeTest();
		boolean errInfo = false;
		boolean testStatus = false;
		errInfo = EQM_login_page_action.successfulLogin("cgupta9", "Cognizant123");
		System.out.println("errInfo" + errInfo);
		if (errInfo)
		{
			testStatus = true;

		}
		System.out.println("testStatus = " + testStatus);
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}*/
	
	


}








