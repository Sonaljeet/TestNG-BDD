package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MUI_Login_Page_ objects.
 */
public class MUI_Login_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new MUI login page factory.
	 *
	 * @param driver the driver
	 */
	public MUI_Login_Page_Factory(WebDriver driver) {
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
	@FindBy(id="UserNameClone0")  // "cred_userid_inputtext"
	WebElement muiUserName;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiUserName, logger)) {
			return this.muiUserName;
		} else {
			return null;
		}

	}

	/** The mui password. */
	@FindBy(name = "Password")  //id = "cred_password_inputtext" 
	WebElement muiPassword;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public WebElement getPassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiPassword, logger)) {
			return this.muiPassword;
		} else {
			return null;
		}

	}

	/** The mui login button. */
	@FindBy(css = "button[test-id=\"login-btn\"]") // id= "cred_sign_in_button"
	WebElement muiLoginButton;

	/**
	 * Gets the sign in.
	 *
	 * @return the sign in
	 */
	public WebElement getSignIn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiLoginButton, logger)) {
			return this.muiLoginButton;
		} else {
			return null;
		}

	}


	/** The mui wrong user error text webelement. */
	@FindBy(css = "div[class=\"login-text login-error\"]")
	WebElement muiWrongUserError;

	/**
	 * Gets the wrong user error.
	 *
	 * @return the wrong user error
	 */
	public WebElement getWrongUserError() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiWrongUserError, logger)) {
			return this.muiWrongUserError;
		} else {
			return null;
		}
	}
	
	/** The mui login copyright text. */
	@FindBy(css = "div[test-id=\"login-copyright-text\"]")
	WebElement muiLoginCopyrightText;
	
	/**
	 * Gets the login copyright text.
	 *
	 * @return the login copyright text
	 */
	public WebElement getLoginCopyrightText() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiLoginCopyrightText, logger)) {
			return this.muiLoginCopyrightText;
		} else {
			return null;
		}
	}

}
