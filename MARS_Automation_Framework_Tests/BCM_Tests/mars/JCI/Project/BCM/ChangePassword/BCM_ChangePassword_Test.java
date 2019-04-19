/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.ChangePassword;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Constants.TextConstants;
import mars.JCI.Project.BCM.Login.BCM_ChangePassword_Page_Action;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_ChangePassword_Test extends BaseClass {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static BCM_ChangePassword_Page_Action changePasswordActionPage = null;
	private static BCM_Login_Page_Action loginPage = null;

	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPage = new BCM_Login_Page_Action(driver, logger);
		changePasswordActionPage = new BCM_ChangePassword_Page_Action(driver, logger);
	}

	@Test(description = "Change Password - Verify BCM text on change password page", priority=1)
	public void verifyBCMHeaderText(Method method) {
		initialize();
		loginPage.clickOnChangePasswordLink();

		boolean testStatus = false;
		String errMsg = changePasswordActionPage.verifyBCMHeaderText();

		if (errMsg != null && errMsg.equalsIgnoreCase(TextConstants.CHANGEPASSWORD_BCM_HEADER_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Change Password - Verify Change password text", priority=1)
	public void verifyChangePasswordText(Method method) {
		initialize();
		loginPage.clickOnChangePasswordLink();

		String errInfo = null;
		boolean testStatus = false;

		errInfo = changePasswordActionPage.verifyChangePasswordHeaderText();
		if (errInfo != null && errInfo.equalsIgnoreCase(TextConstants.CHANGEPASSWORD_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	
	@Test(description = "Change Password - Verify Copyright info is displayed", priority=1)
	public void verifyCopyRightInfo(Method method) {
		initialize();
		loginPage.clickOnChangePasswordLink();

		String errInfo = null;
		boolean testStatus = false;

		errInfo = changePasswordActionPage.verifyCopyRightInfo();
		if (errInfo != null && errInfo.equalsIgnoreCase(TextConstants.CHANGEPASSWORD_COPYRIGHT_TEXT)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Change Password - Verify Password policy is enforced in new password" , dataProvider="PasswordPolicyData", priority=2)
	public void verifyPasswordPolicy(String username, String oldPassword, String newPassword, String confirmPassword,
			Method method) {

		initialize();
		loginPage.clickOnChangePasswordLink();

		String errInfo = null;
		boolean testStatus = false;

		errInfo = changePasswordActionPage.verifyPasswordPolicyEnforcedInNewPassword(username, oldPassword, newPassword,
				confirmPassword);

		if (errInfo != null && errInfo.equalsIgnoreCase(TextConstants.CHANGEPASSWORD_PASSWORD_POLICY_MESSAGE)) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Change Password - Verify Blocked keywords are not used in password", dataProvider="BlockedKeywordsList", priority=2)
	public void verifyBlockedWordsPolicy(String username, String oldPassword, String newPassword,
			String confirmPassword, Method method) {
		initialize();
		loginPage.clickOnChangePasswordLink();

		String errInfo = null;
		boolean testStatus = false;
		String testName=

		errInfo = changePasswordActionPage.verifyBlockedWordsNotAllowedInNewPassword(username, oldPassword, newPassword,
				confirmPassword);
		if (errInfo != null && errInfo.equalsIgnoreCase(TextConstants.CHANGEPASSWORD_BLOCKED_KEYWORD_MESSAGE)) {
			testStatus = true;
		}
		//String methodName= method.getAnnotation(Test.class).description()+" for test data- "+confirmPassword;
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	@Test(description = "Change Password - Verify user can login successfully after password is changed", priority=3)
	public void verifyUserLoginAftePasswordChange(Method method){
		initialize();
		boolean testStatus=false;
		boolean errInfo=false;
		loginPage.clickOnChangePasswordLink();
		errInfo = changePasswordActionPage.verifyUserLoginAfterChangingPassword("test1", "Dec@2016", "Jan@2017", loginPage);
		
		if (errInfo) {
			testStatus=true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	@DataProvider(name="BlockedKeywordsList")
	public Object[][] getlockedKeywordsList(Method method){
		return new Object[][]{
			{"test1","Aug@2016","ABCD","ABCD"},
			{"test1","Aug@2016", "Alarms","Alarms"},
			{"test1","Aug@2016", "Controls", "Controls"},
			{"test1","Aug@2016", "Guest", "Guest"},
			{"test1","Aug@2016", "Johnson", "Johnson"},
			{"test1","Aug@2016", "Metasys", "Metasys"},
			{"test1","Aug@2016", "Supervisor", "Supervisor"},
			{"test1","Aug@2016", "XMG", "XMG"},
			{"test1","Aug@2016", "Admin", "Admin"},	
			{"test1","Aug@2016", "Apple", "Apple"},
			{"test1","Aug@2016", "Demo", "Demo"},	
			{"test1","Aug@2016", "HVAC", "HVAC"},
			{"test1","Aug@2016", "LetMeIn", "LetMeIn"},
			{"test1","Aug@2016", "Password", "Password"},
			{"test1","Aug@2016", "Test", "Test"},		
			{"test1","Aug@2016", "Adobe", "Adobe"},
			{"test1","Aug@2016", "ChangeMe", "ChangeMe"},	
			{"test1","Aug@2016", "Donald", "Donald"},
			{"test1","Aug@2016", "Jci", "Jci"},		
			{"test1","Aug@2016", "Lucky", "Lucky"},
			{"test1","Aug@2016", "Qwerty", "Qwerty"},		
			{"test1","Aug@2016", "Welcome", "Welcome"}
		};
	}
	
	
	@DataProvider(name="PasswordPolicyData")
	public Object[][] getPasswordpolicyData(Method method){
		return new Object[][]{
			{"test1","Aug@2016", "E1gh@t", "E1gh@t"},//Minimum password length is 8 characters
			{"test1","Aug@2016", "E1g @twewwe", "E1g @twewwe"}, //No spaces are allowed.
			{"test1","Aug@2016", "e1gh@twewew", "e1gh@twewew"}, //At least one upper case alphabetical character is required
			{"test1","Aug@2016", "E1GH@TABC", "E1GH@TABC"}, //At least one lower case alphabetical character is required
			{"test1","Aug@2016", "EIGHTCHARacTER$", "EIGHTCHARacTER$"}, //At least one numeric digit is required
			{"test1","Aug@2016", "EIGTCHARACsss" , "EIGTCHARACsss"},//At least one of the following special characters is required: @, #, !, ?, $, %, .,s-.
		};
	}
}
