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
public class BCMET_Admin_UserRole_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;

	/**
	 * 
	 */
	public BCMET_Admin_UserRole_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "rtlRoleAndRight_rtlData")
	private WebElement UserRoleTableGrid;

	public WebElement get_UserRoleTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserRoleTableGrid, logger)) {
			element = UserRoleTableGrid;
		}

		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_rgUserRoleModel_GridData")
	private WebElement RoleDefinitionTableGrid;

	public WebElement get_RoleDefinitionTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, RoleDefinitionTableGrid, logger)) {
			element = RoleDefinitionTableGrid;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_btnAddUserRole_input")
	private WebElement AddButton;

	public WebElement get_AddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, AddButton, logger)) {
			element = AddButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_btnEditUserRole_input")
	private WebElement EditButton;

	public WebElement get_EditButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, EditButton, logger)) {
			element = EditButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_btnDeleteUserRole_input")
	private WebElement DeleteButton;

	public WebElement get_DeleteButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, DeleteButton, logger)) {
			element = DeleteButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_btnCancelUserRole_input")
	private WebElement ClearButton;

	public WebElement get_ClearButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ClearButton, logger)) {
			element = ClearButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_btnSaveUserRole_input")
	private WebElement SaveButton;

	public WebElement get_SaveButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveButton, logger)) {
			element = SaveButton;
		}
		return element;
	}

	@FindBy(id = "popup_ok")
	private WebElement PopUpOkButton;

	public WebElement get_PopUpOkButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopUpOkButton, logger)) {
			element = PopUpOkButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_bodyPlaceholder_rgUserRoleModel_ctl00_ctl04_txtRoleName")
	private WebElement txt_UserRoleName;

	public WebElement get_txt_UserRoleName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, txt_UserRoleName, logger)) {
			element = txt_UserRoleName;
		}
		return element;
	}

	@FindBy(id = "popup_message")
	private WebElement PopMessage;

	public WebElement get_PopMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopMessage, logger)) {
			element = PopMessage;
		}
		return element;
	}
}
