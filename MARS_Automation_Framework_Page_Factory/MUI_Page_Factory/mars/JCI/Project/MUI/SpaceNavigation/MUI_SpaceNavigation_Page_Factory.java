package mars.JCI.Project.MUI.SpaceNavigation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MUI_SpaceNavigation_Page_ objects.
 */
public class MUI_SpaceNavigation_Page_Factory {
	
	/** The driver. */
	public WebDriver driver;
	
	/** The logger. */
	private ExtentTest logger;

	// Constructor

	/**
	 * Instantiates a new MU I space navigation page factory.
	 *
	 * @param driver the driver
	 */
	public MUI_SpaceNavigation_Page_Factory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	/** All WebElements are identified by @FindBy and @FindAll annotation. */
	
	@FindBy(css = "*[test-id=\"space-menu current\"]")
	WebElement currentSpaceMenu;

	/**
	 * Gets the current space menu.
	 *
	 * @return the current space menu
	 */
	public WebElement getCurrentSpaceMenu() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, currentSpaceMenu, logger) == true) {
			return this.currentSpaceMenu;
		} else {
			return null;
		}
	}
	
	/** The space header. */
	@FindBy(css = "*[test-id=\"page-title\"]")
	WebElement spaceHeader;

	/**
	 * Gets the space header.
	 *
	 * @return the space header
	 */
	public WebElement getSpaceHeader() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, spaceHeader, logger) == true) {
			return this.spaceHeader;
		} else {
			return null;
		}
	}
	
	/** The ancestor space menu. */
	@FindBy(css = "*[test-id=\"space-menu ancestor\"]")
	WebElement ancestorSpaceMenu;

	/**
	 * Gets the ancestor space menu.
	 *
	 * @return the ancestor space menu
	 */
	public WebElement getAncestorSpaceMenu() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, ancestorSpaceMenu, logger) == true) {
			return this.ancestorSpaceMenu;
		} else {
			return null;
		}
	}
	
	/** The ancestor space menu list. */
	@FindAll(@FindBy(how = How.CSS, using = "li[test-id=\"space-menu ancestor\"]"))
	List<WebElement> ancestorSpaceMenuList;

	/**
	 * Gets the ancestor space menu list.
	 *
	 * @return the ancestor space menu list
	 */
	public List<WebElement> getAncestorSpaceMenuList() {
		return this.ancestorSpaceMenuList;
	}

	/** The child space menu list. */
	@FindAll(@FindBy(css = "li[test-id=\"space-menu child\"]"))
	List<WebElement> childSpaceMenuList;

	/**
	 * Gets the child space menu list.
	 *
	 * @return the child space menu list
	 */
	public List<WebElement> getChildSpaceMenuList() {
		return this.childSpaceMenuList;
	}
	
	@FindBy(css = "li[test-id=\"space-menu child\"]")
	WebElement childSpaceMenu;
	
	public WebElement getChildSpaceMenu() {
		return this.childSpaceMenu;
	}
}
