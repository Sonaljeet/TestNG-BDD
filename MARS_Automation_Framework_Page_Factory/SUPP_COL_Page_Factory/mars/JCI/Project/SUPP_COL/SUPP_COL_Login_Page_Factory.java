package mars.JCI.Project.SUPP_COL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * A factory for creating SUPP_COL_Login_Page_ objects.
 */
public class SUPP_COL_Login_Page_Factory {
	
	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new EQM login page factory.
	 *
	 * @param driver the driver
	 */
	public SUPP_COL_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
		
	/** The SSL Link WebElement. */
	@FindBy(linkText = "Continue to this website (not recommended).")
	WebElement suppcolSSLLink;

	/**
	 * Gets the SSL link.
	 *
	 * @return the SSL link
	 */
	public WebElement getSSLLink() {
		if (commonFunctions.WebElementCommon.
				waitForElementPresent(driver, suppcolSSLLink, logger) == true) {
			return this.suppcolSSLLink;
		} else {
			return null;
		}

	}

	/** The eqm User Name WebElement. */
	@FindBy(id = "UserNameClone0")
	WebElement eqmUserName;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eqmUserName, logger)) {
			return this.eqmUserName;
		} else {
			return null;
		}

	}

	/** The eqm password. */
	@FindBy(name = "Password")
	WebElement eqmPassword;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public WebElement getPassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eqmPassword, logger)) {
			return this.eqmPassword;
		} else {
			return null;
		}

	}

	/** The eqm login button. */
	@FindBy(css = "button[test-id=\"login-btn\"]")
	WebElement eqmLoginButton;

	/**
	 * Gets the sign in.
	 *
	 * @return the sign in
	 */
	public WebElement getSignIn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eqmLoginButton, logger)) {
			return this.eqmLoginButton;
		} else {
			return null;
		}

	}
	
	/** The eqm wrong user error text webelement. */
	@FindBy(css = ".field-validation-message.ng-binding")
	WebElement eqmWrongUserError;

	/**
	 * Gets the wrong user error.
	 *
	 * @return the wrong user error
	 */
	public WebElement getWrongUserError() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eqmWrongUserError, logger)) {
			return this.eqmWrongUserError;
		} else {
			return null;
		}
	}
	
	/** The eqm login copyright text. */
	@FindBy(css = "div[test-id=\"login-copyright-text\"]")
	WebElement eqmLoginCopyrightText;
	
	/**
	 * Gets the login copyright text.
	 *
	 * @return the login copyright text
	 */
	public WebElement getLoginCopyrightText() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eqmLoginCopyrightText, logger)) {
			return this.eqmLoginCopyrightText;
		} else {
			return null;
		}
	}

}
