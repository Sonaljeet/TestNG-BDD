package mars.JCI.Project.DES.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class DES_Login_Page_Factory {
	
	private WebDriver driver = null;
	private ExtentTest logger = null;
	
	public DES_Login_Page_Factory(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger=logger;
		PageFactory.initElements(driver,this);
		// This initElements method will create all WebElements
		
	}
	
	
	/** The SSL Link WebElement. */
	@FindBy(linkText = "Continue to this website (not recommended).")
	WebElement desSSLLink;

	/**
	 * Gets the SSL link.
	 *
	 * @return the SSL link
	 */
	public WebElement getSSLLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desSSLLink, logger) == true) {
			return this.desSSLLink;
		} else {
			return null;
		}
	}
	
	@FindBy(css="input[id='username']")
	WebElement desUserName;
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desUserName, logger)) {
			return this.desUserName;
		} else {
			return null;
		}

	}
		
	/** The des password. */
	@FindBy(css= "input[id='password']")
	WebElement desPassword;
	/**
	 * Gets the password.
	 * * @return the password
	 */
	public WebElement getPassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desPassword, logger)) {
			return this.desPassword;
		} else {
			return null;
		}

	}
		
	/** The des login button. */
	@FindBy(css="button[class='btn pull-right login-button login-group']")
	WebElement desLoginButton;
	/**
	 * Gets the sign in.
	 *
	 * @return the sign in
	 */
	public WebElement getSignIn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desLoginButton, logger)) {
			return this.desLoginButton;
		} else {
			return null;
		}

	}
		
	/** The des wrong user error text webelement. */
	@FindBy(css = "span[class='login-error-message ng-binding']")
	WebElement desWrongUserError;

	/**
	 * Gets the wrong user error.
	 *
	 * @return the wrong user error
	 */
	public WebElement getWrongUserError() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desWrongUserError, logger)) {
			return this.desWrongUserError;
		} else {
			return null;
		}
	}
		
	/** The des login copyright text. */
	@FindBy(css = "div[class='copyright ng-binding']")
	WebElement desLoginCopyrightText;
	/**
	 * Gets the login copyright text.
	 *
	 * @return the login copyright text
	 */
	public WebElement getLoginCopyrightText() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, desLoginCopyrightText, logger)) {
			return this.desLoginCopyrightText;
		} else {
			return null;
		}
	}
	
	/** The des JCI logo  */
	@FindBy(css = "img[class='login-logo']")
	WebElement JCI_Logo;
	
	/**
	 * Gets the JCI_Logo.
	 *
	 * @return the JCI_Logo
	 */
	public WebElement getJCI_Logo() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, JCI_Logo, logger)) {
			return this.JCI_Logo;
		} else {
			return null;
		}
	}
	
	/** The des DES logo  */
	@FindBy(css = "div[class='login-heading text-center']")
	WebElement DES_logo;
	/**
	 * Gets the JCI_Logo.
	 *
	 * @return the JCI_Logo
	 */
	public WebElement getDES_logo() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, DES_logo, logger)) {
			return this.DES_logo;
		} else {
			return null;
		}
	}

}
