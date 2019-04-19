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

import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class BCM_Login_Page_Action.
 */
public class BCM_Login_Page_Action {

	/** The driver. */
	private static WebDriver driver;

	/** The logger. */
	private static ExtentTest logger;

	/** The login page. */
	private static BCM_Login_Page_Factory loginPage = null;

	/** The Constant EMPTY_STRING. */
	private final static String EMPTY_STRING = "";

	/** The change password page. */
	// private static BCM_ChangePassword_Page_Factory changePasswordPage = null;

	private static BCM_ChangePassword_Page_Action changePasswordPage = null;

	/**
	 * Instantiates a new BC M login page action.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 */
	public BCM_Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPage = new BCM_Login_Page_Factory(driver, logger);
	}

	/**
	 * @param username
	 */
	public static void enterUserName(String username) {
		WebElement element = null;
		element = loginPage.gettxt_username(username);
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, username);
			logger.log(LogStatus.PASS, "User Name entered successfully in User Name field");
		} else
			logger.log(LogStatus.FAIL, "Failed to find User Name field");
	}

	/**
	 * Enter password.
	 *
	 * @param password
	 *            the password
	 */
	public static void enterPassword(String password) {
		WebElement element = null;
		element = loginPage.gettxt_password();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, password);
			logger.log(LogStatus.PASS, "Password entered successfully in Password field");
		} else
			logger.log(LogStatus.FAIL, "Failed to find password field");
	}

	/**
	 * Click on login button.
	 */
	public static void clickOnLoginButton() {
		WebElement element = null;
		element = loginPage.getbtnLogin();
		if (element != null) {
			element.click();
			//commonFunctions.WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Login button clicked successfully");
		} else
			logger.log(LogStatus.FAIL, "Failed to find Login button");
	}

	/**
	 * Gets the erro message.
	 *
	 * @return the erro message
	 */
	public static String getErroMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = EMPTY_STRING;
		try {
			element = loginPage.gettxtErrorMessage();
			if (element != null) {
				WebElementCommon.staticWait(5000);
				WebElementCommon.waitForElementPresent(driver, element, logger);
				errorInfo = element.getText();
				logger.log(LogStatus.PASS, "Successfully found error message which is </br>\"" + errorInfo + "\"");
				// return errorInfo;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				// return EMPTY_STRING;
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error occured getting the WebElement" + e.getMessage());
			logger.log(LogStatus.FAIL, "Failed to find the Error message element");
		}
		return errorInfo;
	}

	/**
	 * Click on change password link.
	 *
	 * @return the BC M change password page factory
	 */
	public void clickOnChangePasswordLink() {
		try {
			loginPage = new BCM_Login_Page_Factory(driver, logger);
			WebElement element = null;
			element = loginPage.getlinkChangePassword();
			if (element != null) {
				commonFunctions.WebLink.SendClickToLink(driver, element);
				logger.log(LogStatus.PASS, "Change Password Link clicked successfully");
				// changePasswordPage= new
				// BCM_ChangePassword_Page_Action(driver, logger);
			} else {
				logger.log(LogStatus.FAIL, "Failed to find Link Change Password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return changePasswordPage;
	}

	public String firstUserLogin(String username, String password) {
		boolean testStatus = false;
		String windowTitle = "";
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		WebElementCommon.staticWait(5000);

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("allWindowHandles.size()" + allWindowHandles.size());
		if (allWindowHandles.size() > 1) {
			for (String childWindow : allWindowHandles) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					testStatus = true;
					driver.switchTo().window(childWindow);
					windowTitle = driver.getTitle();
					logger.log(LogStatus.PASS, "HTML",
							"Test Data Used :</br>" + "Username : " + username + "</br>Password : " + password);
				}
			}
		}
		return windowTitle;
	}

	/**
	 * Successful login.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the BC M set up home page action
	 */
	public boolean successfulLogin(String username, String password) {

		boolean testStatus = false;
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		WebElementCommon.staticWait(5000);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		// System.out.println("allWindowHandles.size()" +
		// allWindowHandles.size());
		if (allWindowHandles.size() > 1) {
			for (String childWindow : allWindowHandles) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					testStatus = true;
					driver.switchTo().window(childWindow);
					logger.log(LogStatus.PASS, "HTML",
							"Test Data Used :</br>" + "Username : " + username + "</br>Password : " + password);
					// System.out.println("Login successful");
				}
			}
		}
		return testStatus;
	}

	/**
	 * Verify error message for incorrect user name.
	 *
	 * @param username
	 *            the username
	 * @param Password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForIncorrectUserName(String username, String Password) {
		enterUserName(username);
		enterPassword(Password);
		clickOnLoginButton();
		String errInfo = getErroMessage("Invalid Login");
		return errInfo;
	}

	/**
	 * Verify error message for blank user name.
	 *
	 * @param username
	 *            the username
	 * @param Password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForBlankUserName(String username, String Password) {
		enterUserName("");
		enterPassword(Password);
		clickOnLoginButton();
		String errInfo = getErroMessage("Please enter username");
		return errInfo;
	}

	/**
	 * Verify error message for blank password.
	 *
	 * @param username
	 *            the username
	 * @param Password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForBlankPassword(String username, String Password) {
		String errInfo = null;
		enterUserName(username);
		enterPassword("");
		clickOnLoginButton();
		errInfo = getErroMessage("Please enter password");
		return errInfo;
	}

	/**
	 * Verify error message for incorrect password.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForIncorrectPassword(String username, String password) {
		String errInfo = null;
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		errInfo = getErroMessage("Invalid Login");
		return errInfo;
	}

	/**
	 * Verify error message for incorrect user name and password.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForIncorrectUserNameAndPassword(String username, String password) {
		String errInfo = null;
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		errInfo = getErroMessage("Invalid Login");
		return errInfo;
	}

	/**
	 * Verify error message for all fields blank.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForAllFieldsBlank(String username, String password) {
		String errInfo = null;
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		errInfo = getErroMessage("Please enter user name and password");
		return errInfo;
	}
	
	public String llginClick(String username, String password) {
		String errInfo = null;
/*		enterUserName(username);
		enterPassword(password);*/
		clickOnLoginButton();
		errInfo = getErroMessage("Please enter user name and password");
		return errInfo;
	}

	/**
	 * Verify BCM header.
	 *
	 * @return the string
	 */
	public String verifyBCMHeader() {
		String errInfo = null;
		WebElement element;

		element = loginPage.gettxtBuildingControlManager();
		if (element != null) {
			errInfo = element.getText();
		}
		return errInfo;
	}

	/**
	 * Verify user name image is displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyUserNameImageIsDisplayed() {
		boolean imageDisplayed = false;
		WebElement element = null;

		element = loginPage.getimgUsername();
		if (element != null) {
			imageDisplayed = true;
		}
		return imageDisplayed;
	}

	/**
	 * Verify password image is displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyPasswordImageIsDisplayed() {
		boolean imageDisplayed = false;
		WebElement element = null;

		element = loginPage.getimgPassword();
		if (element != null) {
			imageDisplayed = true;
		}
		return imageDisplayed;
	}

	/**
	 * Verify language image is displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLanguageImageIsDisplayed() {
		boolean imageDisplayed = false;
		WebElement element = null;

		element = loginPage.getimgLanguage();
		if (element != null) {
			imageDisplayed = true;
		}
		return imageDisplayed;
	}

	/**
	 * Verify copy right info.
	 *
	 * @return the string
	 */
	public String verifyCopyRightInfo() {
		String errInfo = null;
		WebElement element = null;
		element = loginPage.gettxtCopyrightInfo();
		if (element != null) {
			errInfo = element.getText();
		}
		return errInfo;
	}

	/**
	 * Verifybest viewed text.
	 *
	 * @return the string
	 */
	public String verifybestViewedText() {
		String errInfo = null;
		WebElement element = null;
		element = loginPage.gettxtBestViewedBrowser();
		if (element != null) {
			errInfo = element.getText();
		}
		return errInfo;
	}
}
