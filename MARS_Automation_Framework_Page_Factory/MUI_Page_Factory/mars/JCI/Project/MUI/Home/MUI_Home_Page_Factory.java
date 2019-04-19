package mars.JCI.Project.MUI.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * A factory for creating MUI_Home_Page_objects.
 */
public class MUI_Home_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/** MUI User Menu element */	
	@FindBy(css = "a[test-id=\"user-menu\"]")
	WebElement muiUserMenu;

	/**
	 * Gets the user menu.
	 *
	 * @return the user menu
	 */
	public WebElement getUserMenu() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiUserMenu, logger)) {
			return this.muiUserMenu;
		} else {
			return null;
		}
	}
	
	/**
	 * Instantiates a new MUI home page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_Home_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}