package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MUI_Change_Password_Page_Factory {
	
	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/**
	 * Instantiates a new MUI change password page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_Change_Password_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	/** The mui change password page old password field. */
	@FindBy(css = "input[test-id=\"old-password-field\"]")
	WebElement muiOldPasswordField;
	
	/**
	 * Gets the old password field on mui change password page.
	 *
	 * @return the old password field
	 */
	public WebElement getOldPasswordField() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiOldPasswordField, logger)) {
			return this.muiOldPasswordField;
		} else {
			return null;
		}
	}
	
	/** The mui change password page new password field. */
	@FindBy(css = "input[test-id=\"new-password-field\"]")
	WebElement muiNewPasswordField;
	
	/**
	 * Gets the New password field on mui change password page.
	 *
	 * @return the New password field
	 */
	public WebElement getNewPasswordField() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiNewPasswordField, logger)) {
			return this.muiNewPasswordField;
		} else {
			return null;
		}
	}
	
	/** The mui change password page confirm password field. */
	@FindBy(css = "input[testid=\"confirm-password-field\"]")
	WebElement muiConfirmPasswordField;
	
	/**
	 * Gets the confirm password field on mui change password page.
	 *
	 * @return the Confirm password field
	 */
	public WebElement getConfirmPasswordField() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiConfirmPasswordField, logger)) {
			return this.muiConfirmPasswordField;
		} else {
			return null;
		}
	}
	
	/** The mui change password page cancel update password button. */
	@FindBy(css = "button[test-id=\"cancel-update-password-btn\"]")
	WebElement muiCancelUpdatePasswordButton;
	
	/**
	 * Gets the cancel update password button on mui change password page.
	 *
	 * @return the cancel update password button
	 */
	public WebElement getCancelUpdatePasswordButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiCancelUpdatePasswordButton, logger)) {
			return this.muiCancelUpdatePasswordButton;
		} else {
			return null;
		}
	}
	
	/** The mui change password page update password button. */
	@FindBy(css = "button[test-id=\"update-password-btn\"]")
	WebElement muiUpdatePasswordButton;
	
	/**
	 * Gets the update password button on mui change password page.
	 *
	 * @return the update password button
	 */
	public WebElement getUpdatePasswordButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiUpdatePasswordButton, logger)) {
			return this.muiUpdatePasswordButton;
		} else {
			return null;
		}
	}
	
	/** The mui change password page change password alert text. */
	@FindBy(css = "div[test-id=\"change-password-alert\"]")
	WebElement muiChangePasswordAlert;
	
	/**
	 * Gets the change password alert webelement on mui change password page.
	 *
	 * @return the change password alert WebElement
	 */
	public WebElement getChangePasswordAlert() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiChangePasswordAlert, logger)) {
			return this.muiChangePasswordAlert;
		} else {
			return null;
		}
	}
}
