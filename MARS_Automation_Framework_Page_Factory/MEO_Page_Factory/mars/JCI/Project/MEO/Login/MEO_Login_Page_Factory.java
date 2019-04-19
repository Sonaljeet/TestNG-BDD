package mars.JCI.Project.MEO.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MEO_Login_Page_Factory {
	
	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new MEO login page factory.
	 *
	 * @param driver the driver
	 */
	public MEO_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
		
	/** The SSL Link WebElement. */
	@FindBy(linkText = "Continue to this website (not recommended).")
	WebElement meoSSLLink;

	/**
	 * Gets the SSL link.
	 *
	 * @return the SSL link
	 */
	public WebElement getSSLLink() {
		if (commonFunctions.WebElementCommon.
				waitForElementPresent(driver, meoSSLLink, logger) == true) {
			return this.meoSSLLink;
		} else {
			return null;
		}

	}

	
	/** The MEO User Name WebElement. */
	@FindBy(id = "UserName")
	WebElement meoUserName;
	@FindBy(how=How.ID,using="Password")
	WebElement meopassword;
	@FindBy(how=How.XPATH,using="//*[@id='main']/form/div/fieldset/div/div[6]/input")
	WebElement LogOn;
	@FindBy(how=How.XPATH,using="//*[@id='logindisplay']//b")
	WebElement LoggedInUser;
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, meoUserName, logger)) {
			return this.meoUserName;
		} else {
			return null;
		}
	}
	public WebElement getPassword() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, meopassword, logger)) {
				return this.meopassword;
			} else {
				return null;
			}
	}
	public WebElement getLogon() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, LogOn, logger)) {
					return this.LogOn;
				} else {
					return null;
				}
	}
	public WebElement getLoginPageUserText() {
					if (commonFunctions.WebElementCommon.waitForElementPresent(driver, LoggedInUser, logger)) {
						return this.LoggedInUser;
					} else {
						return null;
					}	
		
	}
	
	/** The MEO wrong user error text webelement. */
	@FindBy(css = "div.validation-summary-errors")
	WebElement meoWrongUserError;

	/**
	 * Gets the wrong user error.
	 *
	 * @return the wrong user error
	 */
	public WebElement getWrongUserError() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, meoWrongUserError, logger)) {
			return this.meoWrongUserError;
		} else {
			return null;
		}
	}
	}
