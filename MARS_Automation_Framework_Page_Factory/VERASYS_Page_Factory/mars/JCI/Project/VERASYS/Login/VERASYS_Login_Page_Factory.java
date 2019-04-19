package mars.JCI.Project.VERASYS.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_Login_Page_Factory {
	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Verasys login page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
		
	

	
	/** The MEO User Name WebElement. */
	@FindBy(id = "username")
	WebElement verasysUserName;
	@FindBy(id="password")
	WebElement verasyspassword;
	@FindBy(how=How.TAG_NAME,using="button")
	WebElement logInButton;
	@FindBy(css="a[automation-id='tabCust']")
	WebElement setUpScreen;
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public WebElement getUserName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, verasysUserName, logger)) {
			return this.verasysUserName;
		} else {
			return null;
		}
	}
	public WebElement getPassword() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, verasyspassword, logger)) {
				return this.verasyspassword;
			} else {
				return null;
			}
	}
	public WebElement getLogInButton() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, logInButton, logger)) {
					return this.logInButton;
				} else {
					return null;
				}
	}
	public WebElement getSetUpScreen() {
					if (commonFunctions.WebElementCommon.waitForElementPresent(driver, setUpScreen, logger)) {
						return this.setUpScreen;
					} else {
						return null;
					}	
		
	}
	
	/** Wrong user error text webelement. */
	@FindBy(xpath = "/html/body/div/div/div/form/fieldset/div[4]/span[2]")
	WebElement wrongUserError;

	/**
	 * Gets the wrong user error.
	 *
	 * @return the wrong user error
	 */
	public WebElement getWrongUserError() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, wrongUserError, logger)) {
			return this.wrongUserError;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the profile drop down.
	 *
	 * @return drop down
	 */
	@FindBy(css = "a.dropdown-toggle:nth-child(1)")
	WebElement profileDropDown;

	public WebElement getProfileDropDown() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, profileDropDown, logger)) {
			return this.profileDropDown;
		} else {
			return null;
		}
	}

	/**
	 * Gets the logout button.
	 *
	 * @return logout button
	 */
	@FindBy(css = "a[href='/Home/Logout']")
	WebElement logoutbtn;

	public WebElement getLogoutbtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, logoutbtn, logger)) {
			return this.logoutbtn;
		} else {
			return null;
		}
	}
	

	/**
	 * Gets the logout Page.
	 *
	 * @return logout Page
	 */
	@FindBy(xpath= "//div[contains(@class,'page-header')]/h1")
	WebElement logoutPage;

	public WebElement getLogoutPage() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, logoutPage, logger)) {
			return this.logoutPage;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Setup drop down.
	 *
	 * @return Setup drop down
	 */
	@FindBy(css = "ul:nth-of-type(2)>li>a.dropdown-toggle:nth-of-type(1)")
	//@FindBy(xpath = "/html/body/div/div/div/div/div/ul[2]/li/ul/li/a")
	WebElement setupDropDown;

	public WebElement getSetupOption() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, setupDropDown, logger)) {
			return this.setupDropDown;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Setup icon.
	 *
	 * @return Setup icon
	 */
	@FindBy(css = "ul:nth-of-type(2)>li>ul.dropdown-menu:nth-of-type(1)")
	//@FindBy(xpath = "/html/body/div/div/div/div/div/ul[2]/li/ul/li/a/p")
	WebElement setupIcon;

	public WebElement getSetupIcon() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, setupIcon, logger)) {
			return this.setupIcon;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the loading element.
	 *
	 * @return loading element
	 */
	@FindBy(css = "tab-ui")
	WebElement loadingTab;

	public WebElement getLoadingTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, loadingTab, logger)) {
			return this.loadingTab;
		} else {
			return null;
		}
	}
	
}
