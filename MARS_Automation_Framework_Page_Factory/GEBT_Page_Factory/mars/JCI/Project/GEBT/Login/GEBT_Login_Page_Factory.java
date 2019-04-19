package mars.JCI.Project.GEBT.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating GEBT_Login_Page_ objects.
 */
public class GEBT_Login_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new GEBT login page factory.
	 *
	 * @param driver the driver
	 */
	public GEBT_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
		
	/** The SSL Link WebElement. */
	@FindBy(linkText = "Continue to this website (not recommended).")
	WebElement gebtSSLLink;

	/**
	 * Gets the SSL link.
	 *
	 * @return the SSL link
	 */
	public WebElement getSSLLink() {
		if (commonFunctions.WebElementCommon.
				waitForElementPresent(driver, gebtSSLLink, logger) == true) {
			return this.gebtSSLLink;
		} else {
			return null;
		}

	}

	/** The GEBT User Name WebElement. */
	@FindBy(id = "UserNameClone0")
	WebElement gebtUserName;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, gebtUserName, logger)) {
			return this.gebtUserName;
		} else {
			return null;
		}

	}

	/** The GEBT password. */
	@FindBy(name = "Password")
	WebElement gebtPassword;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public WebElement getPassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, gebtPassword, logger)) {
			return this.gebtPassword;
		} else {
			return null;
		}

	}

	/** The GEBT login button. */
	@FindBy(css = "button[test-id=\"login-btn\"]")
	WebElement gebtLoginButton;

	/**
	 * Gets the sign in.
	 *
	 * @return the sign in
	 */
	public WebElement getSignIn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, gebtLoginButton, logger)) {
			return this.gebtLoginButton;
		} else {
			return null;
		}

	}
}
