package mars.JCI.Project.DES.Home;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DES_Home_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;

	/** The ExtentTest logger. */
	private static ExtentTest logger;

	public DES_Home_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger)
			throws TimeoutException {
		try {
			// Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					// Wait for the condition with timeout 30 seconds
					.withTimeout(15, TimeUnit.SECONDS)
					// poll interval of 1 seconds.
					.pollingEvery(1, TimeUnit.SECONDS)
					// ignore the NoSuchElementException
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		}
	}

	/** DES log out menu element */
	@FindBy(css = "li[automation-id='displayLogoutOption']")
	WebElement logoutMenu;

	/**
	 * Gets the log out menu.
	 *
	 * @return the log out menu
	 */
	public WebElement getlogoutMenu() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, logoutMenu, logger)) {
			return this.logoutMenu;
		} else {
			return null;
		}
	}

	/** DES Log out menu element */
	@FindBy(css = "li[test_id='logoutApplication']")
	WebElement logoutButton;
	/**
	 * Gets the log out button.
	 *
	 * @return the log out button
	 */
	public WebElement logoutButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, logoutButton, logger)) {
			return this.logoutButton;
		} else {
			return null;
		}
	}
	
	/** DES change password link */
	@FindBy(css = "li[automation-id='changePasswordApplication']")
	WebElement ChangePasswordButton;
	/**
	 * Gets the log out button.
	 *
	 * @return the log out button
	 */
	public WebElement ChangePasswordButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, ChangePasswordButton, logger)) {
			return this.ChangePasswordButton;
		} else {
			return null;
		}
	}

	/** DES Change password menu element */
	@FindBy(css = "li[automation-id='changePasswordApplication']")
	WebElement changePassword;
	/**
	 * Gets the log out button.
	 *
	 * @return the log out button
	 */
	public WebElement getchangePassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, changePassword, logger)) {
			return this.changePassword;
		} else {
			return null;
		}
	}
	/** DES MAP element */
	@FindBy(xpath = "//div[@id='map']")
	WebElement map;

	/**
	 * Gets the MAP menu.
	 *
	 * @return the MAP menu
	 */
	public WebElement getMapPage() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, map, logger)) {
			return this.map;
		} else {
			return null;
		}
	}

	/** DES HomePage Heading element */
	@FindBy(id = "titlePortfolioName")
	WebElement MapPageHeading;

	/**
	 * Gets the HomePageHeading.
	 *
	 * @return the HomePageHeading.
	 */
	public WebElement getMapPageHeading() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, MapPageHeading, logger)) {
			return this.MapPageHeading;
		} else {
			return null;
		}
	}

	/** DES Site Markers element */
	@FindBy(xpath = "//*[@id='map']/div/div/div[1]/div[4]/div[3]/div[5]/img")
	List<WebElement> SiteMarkers;

	/**
	 * Gets the SiteMarkers.
	 *
	 * @return the SiteMarkers.
	 */
	public List<WebElement> getMapSiteMarkers() {
		if (waitForElementPresent(driver, MapPageHeading, logger)) {
			return this.SiteMarkers;
		} else {
			return null;
		}
	}

	/** DES Navigation element */
	@FindBy(css = "span[id='layoutPopover']")
	WebElement navigationMenu;

	/**
	 * Gets the navigation pop up menu
	 *
	 * @return the navigation pop up menu.
	 */
	public WebElement getnavigationMenu() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, navigationMenu, logger)) {
			return this.navigationMenu;
		} else {
			return null;
		}
	}

	/** DES Navigation element from Customer page */
	@FindBy(css = "span[id='layoutPopover']")
	WebElement navigationMenufromCustomer;

	/**
	 * Gets the navigation pop up menu
	 *
	 * @return the navigation pop up menu.
	 */
	public WebElement getnavigationMenuFromCustomer() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, navigationMenufromCustomer, logger)) {
			return this.navigationMenufromCustomer;
		} else {
			return null;
		}
	}

	/** DES Customer tab */
	@FindBy(css = "a[automation-id='custTab']")
	WebElement customertab;

	/**
	 * Gets the navigation pop up menu
	 *
	 * @return the navigation pop up menu.
	 */
	public WebElement getCustomertab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customertab, logger)) {
			return this.customertab;
		} else {
			return null;
		}
	}

	/** DES Setup button element */
	@FindBy(css = "a[automation-id='navigateSetup']") // "i[class='fa fa-gear
														// fa-2x']")//"a[test_id='navigateSetup']")
	WebElement setupbtn;

	/**
	 * Gets the setupbtn pop up menu
	 * 
	 * @return the setupbtn pop up menu.
	 */
	public WebElement getSetupbtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, setupbtn, logger)) {
			return this.setupbtn;
		} else {
			return null;
		}
	}

	/** DES MAP button element */
	@FindBy(css = "a[test_id='navigateFromSetupToMap']") // "i[class='fa fa-gear
															// fa-2x']")//"a[test_id='navigateSetup']")
	WebElement navigateFromSetupToMap;

	/**
	 * Gets the navigateFromSetupToMap pop up menu
	 * 
	 * @return the navigateFromSetupToMap pop up menu.
	 */
	public WebElement getMapbtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, navigateFromSetupToMap, logger)) {
			return this.navigateFromSetupToMap;
		} else {
			return null;
		}
	}

	/** DES view detail link element */
	@FindBy(id = "sitePopup")
	WebElement viewDetailsLink;

	/**
	 * Gets the setupbtn pop up menu
	 * 
	 * @return the setupbtn pop up menu.
	 */
	public WebElement getviewDetailsLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, viewDetailsLink, logger)) {
			return this.viewDetailsLink;
		} else {
			return null;
		}
	}

	/** Getting marker with Data available */
	@FindBy(xpath = "(//div[@title='Cody Test 2']//img)[1]")
	WebElement getMarker;

	public WebElement getMarkerSite() {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, getMarker, logger)) {
			return this.getMarker;
		} else {
			return null;
		}
	}

	/** Getting marker with Data available */
	@FindBy(css = "span[class='user-name-top ng-binding']")
	WebElement loggedUser;

	/**
	 * Gets the Logged in user Name
	 * 
	 * @return the Logged in user Name.
	 */
	public WebElement getloggedUser() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, loggedUser, logger)) {
			return this.loggedUser;
		} else {
			return null;
		}
	}

}
