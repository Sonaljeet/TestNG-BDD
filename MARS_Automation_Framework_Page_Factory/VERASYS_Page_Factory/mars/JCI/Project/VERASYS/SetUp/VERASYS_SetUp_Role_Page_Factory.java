package mars.JCI.Project.VERASYS.SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_SetUp_Role_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Verasys Role page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_SetUp_Role_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	 * Gets the Role  Tab.
	 *
	 * @return the Role  Tab.
	 */
	@FindBy(css ="li[automation-id=autoRoleTabId]")
	WebElement roleTab;
	public WebElement getRoleTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, roleTab, logger)) {
			return this.roleTab;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Role Field on Role page.
	 *
	 * @return Role Field on Role page.
	 */
	@FindBy(css ="input[automation-id=txtrolePageRoles]")
	WebElement roleName;
	public WebElement getRoleName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, roleName, logger)) {
			return this.roleName;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the description Input field.
	 *
	 * @return the description Input field.
	 */
	@FindBy(css ="input[automation-id=txtRoleDescription]")
	WebElement roleDescription;
	public WebElement getRoleDescription() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, roleDescription, logger)) {
			return this.roleDescription;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Gets the Add button.
	 *
	 * @return the Add button.
	 */
	@FindBy(css ="button[automation-id=btnAddRole]")
	WebElement addRoleBtn;
	public WebElement getAddBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, addRoleBtn, logger)) {
			return this.addRoleBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Cancel button on Role page.
	 *
	 * @return the cancel btn.
	 */
	@FindBy(css ="button[automation-id=btnCancelRole]")
	WebElement cancelRoleBtn;
	public WebElement getCancelBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cancelRoleBtn, logger)) {
			return this.cancelRoleBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Update button.
	 *
	 * @return the update button.
	 */
	@FindBy(css ="button[automation-id=btnUpdateRole]")
	WebElement updateRoleBtn;
	public WebElement getUpdateBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, updateRoleBtn, logger)) {
			return this.updateRoleBtn;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Gets the Delete button.
	 *
	 * @return the Delete button.
	 */
	@FindBy(css ="button[automation-id=btnDeleteRole]")
	WebElement deleteRoleBtn;
	public WebElement getDeleteBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, deleteRoleBtn, logger)) {
			return this.deleteRoleBtn;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@id='customergrid']//table/tbody")
	WebElement custGrid;
	/**
	 * Gets Customer grid.
	 *
	 * @return Customer grid tbody.
	 */
	public WebElement getCustGrid() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, custGrid, logger)) {
			return this.custGrid;
		} else {
			return null;
		}
}
	
	/**
	 * Gets the Search box for Role Name.
	 *
	 * @return the Search box for Role Name.
	 */
	@FindBy(css ="input[id=RoleName]")
	WebElement searchRoleName;
	public WebElement getSearchRole() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchRoleName, logger)) {
			return this.searchRoleName;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Search box for Description.
	 *
	 * @return the Search box for Description.
	 */
	@FindBy(css ="input[id=Description]")
	WebElement searchDescription;
	public WebElement getSearchDescription() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchDescription, logger)) {
			return this.searchDescription;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets ok button on confirmation screen to delete role.
	 *
	 * @return ok button.
	 */
	@FindBy(css ="button[automation-id=btnroleSubmit]")
	WebElement okBtnCnf;
	public WebElement getOKBtnCnf() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, okBtnCnf, logger)) {
			return this.okBtnCnf;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets No button on confirmation screen to delete role.
	 *
	 * @return No button.
	 */
	@FindBy(css ="button[automation-id=btnroleCancel]")
	WebElement noBtnCnf;
	public WebElement getNOBtnCnf() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, noBtnCnf, logger)) {
			return this.noBtnCnf;
		} else {
			return null;
		}
	}
}
