/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import commonFunctions.WebLink;

/**
 * @author cpandeak
 *
 */
public class BCMET_Admin_Page_Action {
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCMET_Admin_Page_Factory adminPageFactory = null;
	private static final By IMAGELOADER = By.id("imgLoadingIcon");
	
	/**
	 * 
	 */
	public BCMET_Admin_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver= driver;
		this.logger = logger;
		adminPageFactory = new BCMET_Admin_Page_Factory(driver, logger);
	}
	
	//WebElement getters -- START
	
	private static WebElement getUserRoleLink() {
		return adminPageFactory.get_UserRoleLink();
	}
	
	private static WebElement getAddUUserLink() {
		return adminPageFactory.get_AddUserLink();
	}
	//WebElement getters -- END
	
	public void clickOnUserRoleLink() {
		WebElement element = null;
		element = getUserRoleLink();
		
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "User Role link clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the User Role Link");
		}
	}
	
	public void clickOnAddUserLink() {
		WebElement element = null;
		element = getAddUUserLink();
		
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add User link clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Add User Link");
		}
	}
	
}


