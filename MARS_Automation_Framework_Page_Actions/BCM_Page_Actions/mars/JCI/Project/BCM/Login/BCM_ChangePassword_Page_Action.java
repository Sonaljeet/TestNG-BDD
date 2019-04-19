/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Login;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.BaseClass;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// TODO: Auto-generated Javadoc
/**
 * Created by cpandeak on 8/16/2016.
 */
public class BCM_ChangePassword_Page_Action extends BaseClass {

	/** The driver. */
	private static WebDriver driver;

	/** The logger. */
	private static ExtentTest logger;

	/** The change pasword page factory. */
	private static BCM_ChangePassword_Page_Factory changePaswordPageFactory = null;

	private static BCM_Login_Page_Action loginPageAction = null;

	/** The Constant EMPTY_STRING. */
	private static final String EMPTY_STRING = "";

	/**
	 * Instantiates a new BC M change password page action.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 */
	public BCM_ChangePassword_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		changePaswordPageFactory = new BCM_ChangePassword_Page_Factory(driver, logger);
	}

	/**
	 * Enter user name.
	 *
	 * @param userName
	 *            the user name
	 */
	public static void enterUserName(String userName) {
		WebElement element = null;
		element = changePaswordPageFactory.getfieldUserName();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, userName);
			logger.log(LogStatus.PASS, "User Name Entered succesfully to User Name WebElement");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
		}
	}

	/**
	 * Enter old password.
	 *
	 * @param oldPassword
	 *            the old password
	 */
	public static void enterOldPassword(String oldPassword) {
		{
			WebElement element = null;
			element = changePaswordPageFactory.getfieldOldPassword();
			if (element != null) {
				WebInputTextBox.SendInputTextBox(driver, element, oldPassword);
				logger.log(LogStatus.PASS, "Old Password Entered succesfully to Old Password field");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Old Password Field Failed");
			}
		}
	}

	/**
	 * Enter new password.
	 *
	 * @param newPassword
	 *            the new password
	 */
	public static void enterNewPassword(String newPassword) {
		{
			WebElement element = null;
			element = changePaswordPageFactory.getfieldNewPassword();
			if (element != null) {
				WebInputTextBox.SendInputTextBox(driver, element, newPassword);
				logger.log(LogStatus.PASS, "Password Entered succesfully to New Password field");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for New Password Field Failed");
			}
		}
	}

	/**
	 * Enter confirm password.
	 *
	 * @param confirmPassword
	 *            the confirm password
	 */
	public static void enterConfirmPassword(String confirmPassword) {
		{
			WebElement element = null;
			element = changePaswordPageFactory.getfieldConfirmPassword();
			if (element != null) {
				WebInputTextBox.SendInputTextBox(driver, element, confirmPassword);
				logger.log(LogStatus.PASS, "Password Entered succesfully to Confirm Password field");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Confirm Password Field Failed");
			}
		}

	}

	/**
	 * Click on btn change password.
	 */
	public static void clickOnBtnChangePassword() {
		WebElement element = null;
		element = changePaswordPageFactory.getbtnChangePassword();
		if (element != null) {
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked Change Password button");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Change Password button Failed");
		}
	}

	/**
	 * Gets the error message.
	 *
	 * @param errorMessage
	 *            the error message
	 * @return the error message
	 */
	public static String getErrorMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		element = changePaswordPageFactory.getdivErrorMessage(errorMessage);
		// WebElementCommon.waitForElementPresent(driver, element, logger);
		if (element != null) {
			WebElementCommon.waitForElementPresent(driver, element, logger);
			// WebElementCommon.waitForTextToAppear(driver, errorMessage,
			// element, logger);
			logger.log(LogStatus.PASS, "HTML", "Successfully found error message which is </br>\"" + errorInfo + "\"");
			return errorInfo;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Error message element");
			return EMPTY_STRING;
		}
	}

	/**
	 * Verify message for blank user name.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyMessageForBlankUserName(String username, String oldPassword, String newPassword,
			String confirmPassword) {

		enterUserName(username);
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		clickOnBtnChangePassword();
		String errMsg = getErrorMessage("Please enter username");

		return errMsg;
	}

	/**
	 * Verify message for blank old password.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyMessageForBlankOldPassword(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		enterUserName(username);
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		clickOnBtnChangePassword();
		String errMsg = getErrorMessage("Please enter old password");

		return errMsg;
	}

	/**
	 * Verify message for blank new password.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyMessageForBlankNewPassword(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		enterUserName(username);
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		clickOnBtnChangePassword();
		String errMsg = getErrorMessage("Please enter new password");

		return errMsg;
	}

	/**
	 * Verify message for blank confirm password.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyMessageForBlankConfirmPassword(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		enterUserName(username);
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		clickOnBtnChangePassword();
		String errMsg = getErrorMessage("Please enter confirm password");

		return errMsg;
	}

	/**
	 * Verify message for all fields blank.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyMessageForAllFieldsBlank(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		return verifyMessageForBlankUserName(username, oldPassword, newPassword, confirmPassword);
	}
	
	public boolean verifyUserLoginAfterChangingPassword(String username, String oldPassword, String newPassword,
			BCM_Login_Page_Action loginPage) {
		boolean testStatus = false;

		enterUserName(username);
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(newPassword);
		clickOnBtnChangePassword();

		WebElementCommon.staticWait(5000);

		loginPage.enterUserName(username);
		loginPage.enterPassword(newPassword);
		loginPage.clickOnLoginButton();

		WebElementCommon.staticWait(5000);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		if (allWindowHandles.size() > 1) {
			for (String childWindow : allWindowHandles) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					testStatus = true;
					driver.switchTo().window(childWindow);
				}
			}
		}
		if (testStatus) {
			logger.log(LogStatus.PASS, "HTML",
					"Test Data Used for login:</br>" + "Username : " + username + "</br>Password : " + newPassword);
		} else {
			logger.log(LogStatus.FAIL, "HTML",
					"Test Data Used for login:</br>" + "Username : " + username + "</br>Password : " + newPassword);
		}
		return testStatus;
	}

	/**
	 * Verify BCM header text.
	 *
	 * @return the string
	 */
	public String verifyBCMHeaderText() {
		WebElement element = null;
		String errInfo = null;
		element = changePaswordPageFactory.getBCMHeader();
		if (element != null) {
			errInfo = element.getText();
			logger.log(LogStatus.PASS, "HTML", "Successfully verified BCM text which is </br>\"" + errInfo + "\"");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find BCM header text on Change Password page");
		}

		return errInfo;
	}

	/**
	 * Verify copy right info.
	 *
	 * @return the string
	 */
	public String verifyCopyRightInfo() {
		WebElement element = null;
		String errInfo = null;
		element = changePaswordPageFactory.gettxtCopyRightInfo();
		if (element != null) {
			errInfo = element.getText();
			logger.log(LogStatus.PASS, "HTML", "Copyright text found is \"</br>\"" + errInfo + "\"");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Copyright text on Change Password page");
		}
		return errInfo;
	}

	/**
	 * Verify change password header text.
	 *
	 * @return the string
	 */
	public String verifyChangePasswordHeaderText() {

		WebElement element = null;
		String errInfo = null;

		element = changePaswordPageFactory.gettxtChangePassword();
		if (element != null) {
			errInfo = element.getText();
			logger.log(LogStatus.PASS, "HTML", "Successfully verified Text which is </br>\"" + errInfo + "\"");
		} else {
			logger.log(LogStatus.FAIL, "HTML", "Failed to get the Text </br>\"" + errInfo + "\"");
		}
		return errInfo;
	}

	/**
	 * Verify image user name.
	 *
	 * @return true, if successful
	 */
	public boolean verifyImageUserName() {
		boolean imageDisplayed = false;
		WebElement element = null;
		element = changePaswordPageFactory.getimgUserName();
		if (element != null) {
			imageDisplayed = true;
		}
		return imageDisplayed;
	}

	/**
	 * Verify image old password.
	 *
	 * @return true, if successful
	 */
	public boolean verifyImageOldPassword() {
		boolean imageDisplayed = false;
		WebElement element = null;
		element = changePaswordPageFactory.getimgOldPassword();
		if (element != null) {
			imageDisplayed = true;
		}
		return imageDisplayed;
	}

	/**
	 * Verify blocked words not allowed in new password.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyBlockedWordsNotAllowedInNewPassword(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		String errInfo = null;
		try {
			WebElement element = null;
			enterUserName(username);
			enterOldPassword(oldPassword);
			enterNewPassword(newPassword);
			enterConfirmPassword(confirmPassword);
			clickOnBtnChangePassword();
			element = changePaswordPageFactory.getdivErrorMessage(
					"The password exists in the Blocked Word List. Please re-enter the password again.");
			if (element != null) {
				errInfo = element.getText();
				logger.log(LogStatus.PASS, "HTML" ,"Successfully verified the error message \"<pre>" + errInfo + "\"</pre></br>Test Data  " +newPassword);
			} else {
				logger.log(LogStatus.FAIL, "Failed to verify the Blocked message text");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errInfo;
	}

	/**
	 * Verify password policy enforced in new password.
	 *
	 * @param username
	 *            the username
	 * @param oldPassword
	 *            the old password
	 * @param newPassword
	 *            the new password
	 * @param confirmPassword
	 *            the confirm password
	 * @return the string
	 */
	public String verifyPasswordPolicyEnforcedInNewPassword(String username, String oldPassword, String newPassword,
			String confirmPassword) {
		String errInfo = null;
		try {
			String message="Password should contain minimum 8 characters at least one upper case letter, one lower case letter, one digit and one special character";
			WebElement element = null;
			errInfo = null;
			enterUserName(username);
			enterOldPassword(oldPassword);
			enterNewPassword(newPassword);
			enterConfirmPassword(confirmPassword);
			clickOnBtnChangePassword();
			Thread.sleep(10000);
			element = changePaswordPageFactory.getdivErrorMessage(message);
			if (element != null) {
				errInfo = element.getText();
				logger.log(LogStatus.PASS, "HTML",
						"Successfully verified the error message </br>\"" + errInfo + "\"</br>" + "Test Data - </br>"
								+ "Username : " + username + "</br>Old Password : " + oldPassword + "</br>New Password : "
								+ newPassword + "</br>Confirm Password : " + confirmPassword);
			} else {
				logger.log(LogStatus.FAIL, "Failed to verify the Password Policy text");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errInfo;
	}

}
