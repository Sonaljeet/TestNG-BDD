package mars.JCI.Project.VERASYS.SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_SetUp_AccessRight_Page_Factory {
	
	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new AccessRight page factory.
	 *
	 * @param driver the driver
	 */
	
	 public VERASYS_SetUp_AccessRight_Page_Factory(WebDriver driver)
	 {
		 this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	 }
	 
	 /** All WebElements are identified by @FindBy annotation. */
		
		/**
		 * Gets the User's  Tab.
		 *
		 * @return the User's  Tab.
		 */
		
		@FindBy(css ="a[automation-id=tabAdmin]")
		WebElement userTab;
		public WebElement getUserTab() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, userTab, logger)) {
				return this.userTab;
			} else {
				return null;
			}
		}
		
		/**
		 * Gets the Access Right  Tab.
		 *
		 * @return the Access Right  Tab.
		 */
		@FindBy(css ="li[automation-id=autoAccessRightTabId]")
		WebElement accessTab;
		public WebElement getAccessTab() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, accessTab, logger)) {
				return this.accessTab;
			} else {
				return null;
			}
		}
		
		/**
		 * Gets the Role Field on Access Right page.
		 *
		 * @return Role Field.
		 */
		@FindBy(css ="select[automation-id=accessroleroles]")
		WebElement roleName;
		public WebElement getRoleName() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, roleName, logger)) {
				return this.roleName;
			} else {
				return null;
			}
		}
		
		/**
		 * Gets the Access Right Table.
		 *
		 * @return Access Right Table.
		 */
		@FindBy(css ="table[id=accessRoleDetails]")
		WebElement accessTable;
		public WebElement getAccessTable() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, accessTable, logger)) {
				return this.accessTable;
			} else {
				return null;
			}
		}
		
		/**
		 * Gets the Save button.
		 *
		 * @return save button.
		 */
		@FindBy(css ="button[automation-id=btnAccessRightSave]")
		WebElement saveBtn;
		public WebElement getsaveBtn() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveBtn, logger)) {
				return this.saveBtn;
			} else {
				return null;
			}
		}
		
		/**
		 * Gets the Cancel button.
		 *
		 * @return Cancel button.
		 */
		@FindBy(css ="button[automation-id=btnAccessRightCancel]")
		WebElement cancelBtn;
		public WebElement getcancelBtn() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cancelBtn, logger)) {
				return this.cancelBtn;
			} else {
				return null;
			}
		}

}
