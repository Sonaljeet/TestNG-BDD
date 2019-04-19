/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCM_Setup_AddUser_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;

	public BCM_Setup_AddUser_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[automation_id=\"setUpPage_AdminLink_Img\"]")
	private WebElement adminImageLink;

	public WebElement get_adminImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, adminImageLink, logger) == true) {
			element = adminImageLink;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_CustomerLink_Img\"]")
	private WebElement customerImageLink;

	public WebElement get_customerImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, customerImageLink, logger) == true) {
			element = customerImageLink;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_TechnicianLink_Img\"]")
	private WebElement technicianImageLink;

	public WebElement get_technicianImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, technicianImageLink, logger) == true) {
			element = technicianImageLink;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_NameField\"]")
	private WebElement nameField;

	public WebElement get_nameField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, nameField, logger) == true) {
			element = nameField;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_UserIdField\"]")
	private WebElement userIdField;

	public WebElement get_userIdField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userIdField, logger) == true) {
			element = userIdField;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_PasswordField\"]")
	private WebElement passwordField;

	public WebElement get_passwordField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, passwordField, logger) == true) {
			element = passwordField;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_ConfirmPasswordField\"]")
	private WebElement confirmPasswordField;

	public WebElement get_confirmPasswordField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, confirmPasswordField, logger) == true) {
			element = confirmPasswordField;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_ContactNumberField\"]")
	private WebElement contactNumberField;

	public WebElement get_contactNumberField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, contactNumberField, logger) == true) {
			element = contactNumberField;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_EmailAddressField\"]")
	private WebElement emailAddressField;

	public WebElement get_emailAddressField() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, emailAddressField, logger) == true) {
			element = emailAddressField;
		}
		return element;
	}

	@FindBy(css = "a[automation_id=\"setUpPage_AddButton\"]")
	private WebElement addBUtton;

	public WebElement get_addBUtton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, addBUtton, logger) == true) {
			element = addBUtton;
		}
		return element;
	}

	@FindBy(css = "a[automation_id=\"setUpPage_ClearButton\"]")
	private WebElement clearButton;

	public WebElement get_clearButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, clearButton, logger) == true) {
			element = clearButton;
		}
		return element;
	}

	@FindBy(css = "a[automation_id=\"setUpPage_UpdateButton\"]")
	private WebElement updateButton;

	public WebElement get_updateButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, updateButton, logger) == true) {
			element = updateButton;
		}
		return element;
	}

	@FindBy(css = "a[automation_id=\"setUpPage_DeleteButton\"]")
	private WebElement deleteButton;

	public WebElement get_deleteButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteButton, logger) == true) {
			element = deleteButton;
		}
		return element;
	}

	@FindBy(css = "a[automation_id=\"setUpPage_PreviousButton\"]")
	private WebElement previousButton;

	public WebElement get_previousButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, previousButton, logger) == true) {
			element = previousButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowCfmDeleteAdmin_C_RadBtbOk_input")
	private WebElement deleteYesButton;

	public WebElement get_deleteYesButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteYesButton, logger) == true) {
			element = deleteYesButton;
		}
		return element;
	}

	@FindBy(css = "input[automation_id=\"setUpPage_DeleteNoButton\"]")
	private WebElement deleteNoButton;

	public WebElement get_deleteNoButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteNoButton, logger) == true) {
			element = deleteNoButton;
		}
		return element;
	}

	// Error Messages field
	@FindBy(css = "span[automation_id=\"setUpPage_NameErrorMessage\"]")
	private WebElement errorMessageName;

	public WebElement get_errorMessageName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMessageName, logger) == true) {
			element = errorMessageName;
		}
		return element;
	}

	@FindBy(css = "span[automation_id=\"setUpPage_UserIdErrorMessage\"]")
	private WebElement errorMessageUserId;

	public WebElement get_errorMessageUserId() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMessageUserId, logger) == true) {
			element = errorMessageUserId;
		}
		return element;
	}

	@FindBy(css = "span[automation_id=\"setUpPage_PasswordErrorMessage\"]")
	private WebElement errorMessagePassword;

	public WebElement get_errorMessagePassword() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMessagePassword, logger) == true) {
			element = errorMessagePassword;
		}
		return element;
	}

	@FindBy(css = "span[automation_id=\"setUpPage_ConfirmPasswordErrorMEssage\"]")
	private WebElement errorMessageConfirmPassword;

	public WebElement get_errorMessageConfirmPassword() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMessageConfirmPassword, logger) == true) {
			element = errorMessageConfirmPassword;
		}
		return element;
	}

	@FindBy(css = "span[automation_id=\"setUpPage_EmailAddressErrorMessage\"]")
	private WebElement errorMessageEmail;

	public WebElement get_errorMessageEmail() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMessageEmail, logger) == true) {
			element = errorMessageEmail;
		}
		return element;
	}

	@FindBy(css = "span[automation_id=\"setUpPage_UserAddUpdateSuccessfulMessage\"]")
	private WebElement infoAddUpdateDelete;

	public WebElement get_infoAddUpdateDelete() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, infoAddUpdateDelete, logger) == true) {
			element = infoAddUpdateDelete;
		}
		return element;
	}

	// Grid data elements
	@FindBy(xpath = "//table[@id='ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RG_UserSetup_ctl00']")
	private WebElement gridRows;

	public WebElement get_gridTable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, gridRows, logger)) {
			element = gridRows;
		}
		return element;
	}

	// Checkboxes IDs
	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl03_chkView")
	private WebElement chkViewBCM;

	public WebElement get_chkViewBCM() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBCM, logger) == true) {
			element = chkViewBCM;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl03_chkEdit")
	private WebElement chkEditBCM;

	public WebElement get_chkEditBCM() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBCM, logger) == true) {
			element = chkEditBCM;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl04_chkView")
	private WebElement chkViewSetup;

	public WebElement get_chkViewSetup() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSetup, logger) == true) {
			element = chkViewSetup;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl04_chkEdit")
	private WebElement chkEditSetup;

	public WebElement get_chkEditSetup() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSetup, logger) == true) {
			element = chkEditSetup;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl05_chkView")
	private WebElement chkViewContractInfo;

	public WebElement get_chkViewContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewContractInfo, logger) == true) {
			element = chkViewContractInfo;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl05_chkEdit")
	private WebElement chkEditContractInfo;

	public WebElement get_chkEditContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditContractInfo, logger) == true) {
			element = chkEditContractInfo;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl06_chkView")
	private WebElement chkViewPointDiscovery;

	public WebElement get_chkViewPointDiscovery() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPointDiscovery, logger) == true) {
			element = chkViewPointDiscovery;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl06_chkEdit")
	private WebElement chkEditPointDiscovery;

	public WebElement get_chkEditPointDiscovery() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPointDiscovery, logger) == true) {
			element = chkEditPointDiscovery;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl07_chkView")
	private WebElement chkViewBuildings;

	public WebElement get_chkViewBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBuildings, logger) == true) {
			element = chkViewBuildings;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl07_chkEdit")
	private WebElement chkEditBuildings;

	public WebElement get_chkEditBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBuildings, logger) == true) {
			element = chkEditBuildings;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl08_chkView")
	private WebElement chkViewSystems;

	public WebElement get_chkViewSystems() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSystems, logger) == true) {
			element = chkViewSystems;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl08_chkEdit")
	private WebElement chkEditSystems;

	public WebElement get_chkEditSystems() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSystems, logger) == true) {
			element = chkEditSystems;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl09_chkView")
	private WebElement chkViewCustomSummary;

	public WebElement get_chkViewCustomSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewCustomSummary, logger) == true) {
			element = chkViewCustomSummary;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl09_chkEdit")
	private WebElement chkEditCustomSummary;

	public WebElement get_chkEditCustomSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditCustomSummary, logger) == true) {
			element = chkEditCustomSummary;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl10_chkView")
	private WebElement chkViewEnergyMeter;

	public WebElement get_chkViewEnergyMeter() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEnergyMeter, logger) == true) {
			element = chkViewEnergyMeter;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl10_chkEdit")
	private WebElement chkEditEnergyMeter;

	public WebElement get_chkEditEnergyMeter() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEnergyMeter, logger) == true) {
			element = chkEditEnergyMeter;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl11_chkView")
	private WebElement chkViewUserRole;

	public WebElement get_chkViewUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewUserRole, logger) == true) {
			element = chkViewUserRole;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl11_chkEdit")
	private WebElement chkEditUserRole;

	public WebElement get_chkEditUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditUserRole, logger) == true) {
			element = chkEditUserRole;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl12_chkView")
	private WebElement chkViewAddUser;

	public WebElement get_chkViewAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAddUser, logger) == true) {
			element = chkViewAddUser;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl12_chkEdit")
	private WebElement chkEditAddUser;

	public WebElement get_chkEditAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAddUser, logger) == true) {
			element = chkEditAddUser;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl13_chkView")
	private WebElement chkViewFloorPlan;

	public WebElement get_chkViewFloorPlan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFloorPlan, logger) == true) {
			element = chkViewFloorPlan;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl13_chkEdit")
	private WebElement chkEditFloorPlan;

	public WebElement get_chkEditFloorPlan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditFloorPlan, logger) == true) {
			element = chkEditFloorPlan;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl14_chkView")
	private WebElement chkViewAHU;

	public WebElement get_chkViewAHU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAHU, logger) == true) {
			element = chkViewAHU;
		}
		return element;
	}

	// TODO Get automation ID added in next build for the table element on Add
	// user page
	@FindBy(id = "mCSB_2_container")
	private WebElement addUserGridTable;

	public WebElement get_UserRolesTable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, addUserGridTable, logger)) {
			element = addUserGridTable;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl14_chkEdit")
	private WebElement chkEditAHU;

	public WebElement get_chkEditAHU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAHU, logger) == true) {
			element = chkEditAHU;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl15_chkView")
	private WebElement chkViewVAV;

	public WebElement get_chkViewVAV() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewVAV, logger) == true) {
			element = chkViewVAV;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl15_chkEdit")
	private WebElement chkEditVAV;

	public WebElement get_chkEditVAV() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditVAV, logger) == true) {
			element = chkEditVAV;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl16_chkView")
	private WebElement chkViewACplant;

	public WebElement get_chkViewACplant() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewACplant, logger) == true) {
			element = chkViewACplant;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl16_chkEdit")
	private WebElement chkEditACplant;

	public WebElement get_chkEditACplant() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditACplant, logger) == true) {
			element = chkEditACplant;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl17_chkView")
	private WebElement chkViewBoiler;

	public WebElement get_chkViewBoiler() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBoiler, logger) == true) {
			element = chkViewBoiler;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl17_chkEdit")
	private WebElement chkEditBoiler;

	public WebElement get_chkEditBoiler() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBoiler, logger) == true) {
			element = chkEditBoiler;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl18_chkView")
	private WebElement chkViewAlarm;

	public WebElement get_chkViewAlarm() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAlarm, logger) == true) {
			element = chkViewAlarm;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl18_chkEdit")
	private WebElement chkEditAlarm;

	public WebElement get_chkEditAlarm() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAlarm, logger) == true) {
			element = chkEditAlarm;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl19_chkView")
	private WebElement chkViewTrend;

	public WebElement get_chkViewTrend() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewTrend, logger) == true) {
			element = chkViewTrend;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl19_chkEdit")
	private WebElement chkEditTrend;

	public WebElement get_chkEditTrend() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditTrend, logger) == true) {
			element = chkEditTrend;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl20_chkView")
	private WebElement chkViewSchedule;

	public WebElement get_chkViewSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSchedule, logger) == true) {
			element = chkViewSchedule;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl20_chkEdit")
	private WebElement chkEditSchedule;

	public WebElement get_chkEditSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSchedule, logger) == true) {
			element = chkEditSchedule;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl21_chkView")
	private WebElement chkViewEnergy;

	public WebElement get_chkViewEnergy() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEnergy, logger) == true) {
			element = chkViewEnergy;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl21_chkEdit")
	private WebElement chkEditEnergy;

	public WebElement get_chkEditEnergy() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEnergy, logger) == true) {
			element = chkEditEnergy;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl22_chkView")
	private WebElement chkViewFCU;

	public WebElement get_chkViewFCU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFCU, logger) == true) {
			element = chkViewFCU;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl22_chkEdit")
	private WebElement chkEditFCU;

	public WebElement get_chkEditFCU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditFCU, logger) == true) {
			element = chkEditFCU;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl23_chkView")
	private WebElement chkViewExhaustFan;

	public WebElement get_chkViewExhaustFan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewExhaustFan, logger) == true) {
			element = chkViewExhaustFan;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl23_chkEdit")
	private WebElement chkEditExhaustFan;

	public WebElement get_chkEditExhaustFan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditExhaustFan, logger) == true) {
			element = chkEditExhaustFan;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl24_chkView")
	private WebElement chkViewSumpPump;

	public WebElement get_chkViewSumpPump() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSumpPump, logger) == true) {
			element = chkViewSumpPump;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl24_chkEdit")
	private WebElement chkEditSumpPump;

	public WebElement get_chkEditSumpPump() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSumpPump, logger) == true) {
			element = chkEditSumpPump;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl25_chkView")
	private WebElement chkViewPAU;

	public WebElement get_chkViewPAU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPAU, logger) == true) {
			element = chkViewPAU;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl25_chkEdit")
	private WebElement chkEditPAU;

	public WebElement get_chkEditPAU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPAU, logger) == true) {
			element = chkEditPAU;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl26_chkView")
	private WebElement chkViewMiscellaneous;

	public WebElement get_chkViewMiscellaneous() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewMiscellaneous, logger) == true) {
			element = chkViewMiscellaneous;
		}
		return element;
	}

	@FindBy(id="ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl26_chkEdit")
	private WebElement chkEditMiscellaneous;

	public WebElement get_chkEditMiscellaneous() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditMiscellaneous, logger) == true) {
			element = chkEditMiscellaneous;
		}
		return element;
	}
}
