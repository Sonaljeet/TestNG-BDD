/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

/**
 * @author cpandeak
 *
 */
public class BCMET_Admin_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	
	/**
	 * 
	 */
	public BCMET_Admin_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="linkUserRole")
	private WebElement UserRoleLink;
	
	public WebElement get_UserRoleLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserRoleLink, logger)) {
			element = UserRoleLink;
		}
		return element;
	}
	@FindBy(id="linkAddUser")
	private WebElement AddUserLink;
	
	public WebElement get_AddUserLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, AddUserLink, logger)) {
			element = AddUserLink;
		}
		return element;
	}
	
}




























