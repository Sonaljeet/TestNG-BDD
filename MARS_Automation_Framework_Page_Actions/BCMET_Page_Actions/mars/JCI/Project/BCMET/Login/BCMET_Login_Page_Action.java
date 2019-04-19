package mars.JCI.Project.BCMET.Login;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebPage;

public class BCMET_Login_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static final By IMAGELOADER = By.id("imgLoadingIcon");

	private static BCMET_Login_Page_Factory BcmEtLoginPageFactory = null;

	public BCMET_Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		BcmEtLoginPageFactory = new BCMET_Login_Page_Factory(driver, logger);
	}

	// WebElement getters--START

	private static void enterUserName(String username) {
		WebElement element = null;
		element = BcmEtLoginPageFactory.get_username();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebInputTextBox.SendInputTextBox(driver, element, username);
			logger.log(LogStatus.PASS, "Username \"" + username + "\" successfully entered");
		} else {
			logger.log(LogStatus.FAIL, "Username field not found");
		}
	}

	private static void enterPassword(String password) {
		WebElement element = null;
		element = BcmEtLoginPageFactory.get_password();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebInputTextBox.SendInputTextBox(driver, element, password);
			logger.log(LogStatus.PASS, "Password \"" + password + "\" successfully entered");
		} else {
			logger.log(LogStatus.FAIL, "Password field not found");
		}
	}

	private static void clickOnLoginButton() {
		WebElement element = null;
		element = BcmEtLoginPageFactory.get_btnLogin();

		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Successfully clicked on Login button");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the login button");
		}
	}

	private static String getInfoMessage() {
		WebElement element = null;
		String textString = null;
		element = BcmEtLoginPageFactory.get_ErrorInfo();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.staticWait(1000);
			textString = WebElementCommon.getElementText(driver, element, logger);
			System.out.println("textString"+textString);
			logger.log(LogStatus.PASS, "Successfully found text \"" + textString + "\"");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find Info message");
		}
		return textString;
	}

	private static String getBCMHeaderText() {
		WebElement element = null;
		String textString = null;
		element = BcmEtLoginPageFactory.get_BCMHeader();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			textString = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found text \"" + textString + "\"");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find BCM header text");
		}
		return textString;
	}

	private static String getCopyrightInfoText() {
		WebElement element = null;
		String textString = null;
		element = BcmEtLoginPageFactory.get_copyrightInfo();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			textString = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found text \"" + textString + "\"");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find copyright text");
		}
		return textString;
	}
	// WebElement getters--END

	// Test Methods START
	public boolean successfulLogin(String username, String password) {
		boolean testStatus = false;
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		
		//Create Project
		WebElementCommon.staticWait(1000);
		if (driver.getTitle().trim().equalsIgnoreCase("Create Project")) {
			testStatus = true;
		}
/*		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		if (allWindowHandles.size() > 1) {
			for (String childWindow : allWindowHandles) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					testStatus = true;
					driver.switchTo().window(childWindow);
					WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
					logger.log(LogStatus.PASS, "HTML",
							"Test Data Used :</br>" + "Username : " + username + "</br>Password : " + password);
				}
			}
		}*/
		return testStatus;
	}
	
	public boolean bcmHeaderTextVerification(String bcmHeaderText){
		boolean testStatus = false;
		if (getBCMHeaderText().contentEquals(bcmHeaderText)) {
			testStatus = true;
			logger.log(LogStatus.PASS, "BCM header text verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find BCM header text");
		}
		
		return testStatus;
	}
		
	public boolean copyrightInfoVerification(String copyrightInfo){
		boolean testStatus = false;
		if (getCopyrightInfoText().contentEquals(copyrightInfo)) {
			testStatus = true;
			logger.log(LogStatus.PASS, " Copyright info text verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find copyright info text");
		}
		
		return testStatus;
	}
	
	public boolean allFieldsBlankErrorMsgVerification(String blankErrorMessage){
		boolean testStatus = false;
		enterUserName("");
		enterPassword("");
		clickOnLoginButton();
		if (getInfoMessage().contentEquals(blankErrorMessage)) {
			testStatus = true;
			logger.log(LogStatus.PASS, "Error message verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message text");
		}
		
		return testStatus;
	}
	
	public boolean invalidCredentialsErrorMsgVerification(String invalidCresMessage){
		boolean testStatus = false;
		enterUserName("invalidUserName");
		enterPassword("invalidPassword");
		clickOnLoginButton();
		if (getInfoMessage().contentEquals(invalidCresMessage)) {
			testStatus = true;
			logger.log(LogStatus.PASS, "Error message verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message text");
		}
		
		return testStatus;
	}
	
	public boolean userNameFieldBlankErrMsg(String invalidCresMessage){
		boolean testStatus = false;
		enterUserName("");
		enterPassword("password");
		clickOnLoginButton();
		if (getInfoMessage().contentEquals(invalidCresMessage)) {
			testStatus = true;
			logger.log(LogStatus.PASS, "Error message verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message text");
		}
		
		return testStatus;
	}
	
	public boolean passwordFieldBlankErrMsg(String invalidCresMessage){
		boolean testStatus = false;
		enterUserName("username");
		enterPassword("");
		clickOnLoginButton();
		if (getInfoMessage().contentEquals(invalidCresMessage)) {
			testStatus = true;
			logger.log(LogStatus.PASS, "Error message verified successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message text");
		}
		
		return testStatus;
	}

	// Test Methods END
}
