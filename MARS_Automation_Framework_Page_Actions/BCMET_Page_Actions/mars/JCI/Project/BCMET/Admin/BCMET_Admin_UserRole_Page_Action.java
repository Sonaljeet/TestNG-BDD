/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebRadioButton;

/**
 * @author cpandeak
 *
 */
public class BCMET_Admin_UserRole_Page_Action {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	private BCMET_Admin_UserRole_Page_Factory userRoleFactory = null;

	private BCMET_Admin_AddUser_Page_Action addUserPageAction = null;
	private BCMET_Admin_Page_Action adminPageAction = null;

	private static final By IMAGELOADER = By.id("imgLoadingIcon");

	public BCMET_Admin_UserRole_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		adminPageAction = new BCMET_Admin_Page_Action(driver, logger);
		addUserPageAction = new BCMET_Admin_AddUser_Page_Action(driver, logger);
		userRoleFactory = new BCMET_Admin_UserRole_Page_Factory(driver, logger);

	}

	// Test Methods -- START
	public boolean verifyNewUserRoleCreation(String roleName, String roleDescription) {

		boolean testStatus = false;
		clickOnAddbutton();
		enterUserRoleName(roleName);
		clickOnSavebutton();
		String roleCreationMessage = getPopUpBoxMessage();
		if (roleCreationMessage.contentEquals("User Role details saved successfully")) {
			clickOnPopUpOkButton();
			testStatus = true;
		}

		return testStatus;
	}

	public boolean verifyUserRoleDelete(String roleToDelete) {
		boolean testStatus = false;
		List<WebElement> rows = getRoleDefinitionTableGrid().findElements(By.tagName("tr"));
		if (rows.size() != 0) {
			for (WebElement rowElement : rows) {
				List<WebElement> columns = rowElement.findElements(By.tagName("td"));
				for (WebElement colElement : columns) {
					// System.out.println(colElement.getText());
					if (colElement.getText().trim().contentEquals(roleToDelete.trim())) {
						if (WebRadioButton.SelectRadioButton(columns.get(columns.indexOf(colElement) - 1))) {
							WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
							clickOnDeletebutton();
							clickOnPopUpOkButton();
							String delMsg = getPopUpBoxMessage();
							if (delMsg.contentEquals("User Role Deleted successfully")) {
								testStatus = true;
								break;
								// clickOnPopUpOkButton();
							}
						}
					}
					if (testStatus) {
						break;
					}
				}
			}

		}
		return testStatus;
	}

	public boolean verifyNewRoleVisileInAddUserTab(String UserRoleToCheck) {
		boolean testStatus = false;

		boolean userCreationSTatus = verifyNewUserRoleCreation(UserRoleToCheck, "User role for testing");
		if (userCreationSTatus) {
			adminPageAction.clickOnAddUserLink();
			addUserPageAction.clickOnAddbutton();
			driver.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName")).click();
			WebElement combobox = driver
					.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName_DropDown"));

			List<WebElement> comboboxval = combobox.findElements(By.tagName("li"));
			for (WebElement ddVal : comboboxval) {
				if (ddVal.getText().trim().contentEquals(UserRoleToCheck)) {
					System.out.println("ddVal.getText().trim()=" + ddVal.getText().trim());
					testStatus = true;
					break;
				}
			}
		}
		return testStatus;
	}

	// Test Methods -- END

	// WebElement getters -- START

	public WebElement getUserRoleTableGrid() {
		return userRoleFactory.get_UserRoleTableGrid();
	}

	public WebElement getRoleDefinitionTableGrid() {
		return userRoleFactory.get_RoleDefinitionTableGrid();
	}

	public void clickOnAddbutton() {
		WebElement element = userRoleFactory.get_AddButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Add Button");
		}
	}

	public void clickOnEditbutton() {
		WebElement element = userRoleFactory.get_EditButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Edit Button");
		}
	}

	public void clickOnDeletebutton() {
		WebElement element = userRoleFactory.get_DeleteButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Delete Button");
		}
	}

	public void clickOnClearbutton() {
		WebElement element = userRoleFactory.get_ClearButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Clear button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Clear Button");
		}
	}

	public void clickOnSavebutton() {
		WebElement element = userRoleFactory.get_SaveButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Save button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Save Button");
		}
	}

	public void clickOnPopUpOkButton() {
		WebElement element = userRoleFactory.get_PopUpOkButton();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Ok button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Ok Button");
		}
	}

	public void enterUserRoleName(String userRoleName) {
		WebElement element = userRoleFactory.get_txt_UserRoleName();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, userRoleName);
			logger.log(LogStatus.PASS, "\"" + userRoleName + "\"" + " entered in the User Role field");
		} else {
			logger.log(LogStatus.FAIL, "User role field not found");
		}
	}

	public String getPopUpBoxMessage() {
		WebElement element = userRoleFactory.get_PopMessage();
		String errMessage = null;
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			errMessage = WebElementCommon.getElementText(driver, element, logger).trim();
		}
		return errMessage;
	}
	// WebElement getters -- END

}
