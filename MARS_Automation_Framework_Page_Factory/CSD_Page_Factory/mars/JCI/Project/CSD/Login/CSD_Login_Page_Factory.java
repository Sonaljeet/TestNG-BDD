package mars.JCI.Project.CSD.Login;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class CSD_Login_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new CSD login page factory.
	 *
	 * @param driver the driver
	 */
	public CSD_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
		
	/** The SSL Link WebElement. */
	@FindBy(linkText = "Continue to this website (not recommended).")
	WebElement muiSSLLink;

	/**
	 * Gets the SSL link.
	 *
	 * @return the SSL link
	 */
	public WebElement getSSLLink() {
		if (commonFunctions.WebElementCommon.
				waitForElementPresent(driver, muiSSLLink, logger) == true) {
			return this.muiSSLLink;
		} else {
			return null;
		}

	}

	
	/** The MUI User Name WebElement. */
	@FindBy(id = "cred_userid_inputtext")
	WebElement csdUserName;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, csdUserName, logger)) {
			return this.csdUserName;
		} else {
			return null;
		}

	}

	/** The mui password. */
	@FindBy(id = "cred_password_inputtext")
	WebElement csdPassword;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public WebElement getPassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, csdPassword, logger)) {
			return this.csdPassword;
		} else {
			return null;
		}

	}

	/** The mui login button. */
	@FindBy(id = "cred_sign_in_button")
	WebElement csdLoginButton;

	/**
	 * Gets the sign in.
	 *
	 * @return the sign in
	 */
	public WebElement getSignIn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, csdLoginButton, logger)) {
			return this.csdLoginButton;
		} else {
			return null;
		}

	}

}
