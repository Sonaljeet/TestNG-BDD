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
public class BCMET_Admin_AddUser_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	
	/**
	 * 
	 */
	public BCMET_Admin_AddUser_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_GridData")
	private WebElement AddUserMainDataGrid;
	
	public WebElement get_AddUserMainDataGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, AddUserMainDataGrid, logger)) {
			element = AddUserMainDataGrid;
		}
		return element;
	}
	
	
	@FindBy(id="ctl00_bodyPlaceholder_btnAddUser_input")
	private WebElement addButton;
	
	public WebElement get_AddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, addButton, logger)) {
			element = addButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_btnEditUser_input")
	private WebElement editButton;
	
	public WebElement get_editButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editButton, logger)) {
			element = editButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_btnDeleteUser_input")
	private WebElement deleteButton;
	
	public WebElement get_deleteButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteButton, logger)) {
			element = deleteButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_btnCancelUser_input")
	private WebElement clearButton;
	
	public WebElement get_clearButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, clearButton, logger)) {
			element = clearButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_btnSaveUser_input")
	private WebElement saveButton;
	
	public WebElement get_saveButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, saveButton, logger)) {
			element = saveButton;
		}
		return element;
	}
	
	@FindBy(css="input[automation_id=\"Engg_ActiveProList_PopOkButton\"]")
	private WebElement popupOkButton;
	
	public WebElement get_popupOkButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, popupOkButton, logger)) {
			element = popupOkButton;
		}
		return element;
	}
	
	//automation_id="Engg_Pro_Info_PopMessageBoxInfo"
	
	@FindBy(css="div[automation_id=\"Engg_Pro_Info_PopMessageBoxInfo\"]")
	private WebElement popupMessage;
	
	public WebElement getPopUpMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, popupMessage, logger)) {
			element = popupMessage;
		}
		return element;
	}
	
	@FindBy(id="\"ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName_DropDown\"")
	private WebElement userRoleDropDown;
	
	public WebElement getUserRoleDropDown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userRoleDropDown, logger)) {
			element = userRoleDropDown;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_txtUserName")
	private WebElement UserName;
	public WebElement get_UserName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserName, logger)) {
			element = UserName;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_txtUserId")
	private WebElement UserID;
	public WebElement get_UserID() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserID, logger)) {
			element = UserID;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_txtPassword")
	private WebElement Password;
	public WebElement get_Password() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, Password, logger)) {
			element = Password;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_txtsContactNumber")
	private WebElement ContactNumber;
	public WebElement get_ContactNumber() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ContactNumber, logger)) {
			element = ContactNumber;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_txtEmailId")
	private WebElement EmailId;
	public WebElement get_EmailId() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, EmailId, logger)) {
			element = EmailId;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_imgDefRole")
	private WebElement DefineRoleIcon;
	public WebElement get_DefineRoleIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, DefineRoleIcon, logger)) {
			element = DefineRoleIcon;
		}
		return element;
	}
	/**
	 * @return
	 */
	@FindBy(id="imgBtnCloss")
	private WebElement defineRoleCloseIcon;
	
	public WebElement get_DefineRoleCloseIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, defineRoleCloseIcon, logger)) {
			element = defineRoleCloseIcon;
		}
		return element;
	}
	
	@FindBy(id="popup_ok")
	private WebElement deleteYesButton;
	public WebElement get_deleteYesButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteYesButton, logger)) {
			element = deleteYesButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl03_chkView")
	private WebElement chkViewAdmin;
	
	public WebElement get_chkViewAdmin() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAdmin, logger)) {
			element = chkViewAdmin;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl03_chkEdit")
	private WebElement chkEditAdmin;
	
	public WebElement get_chkEditAdmin() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAdmin, logger)) {
			element = chkEditAdmin;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl04_chkView")
	private WebElement chkViewUserRole;
	
	public WebElement get_chkViewUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewUserRole, logger)) {
			element = chkViewUserRole;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl04_chkEdit")
	private WebElement chkEditUserRole;
	
	public WebElement get_chkEditUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditUserRole, logger)) {
			element = chkEditUserRole;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl05_chkView")
	private WebElement chkViewAddUser;
	
	public WebElement get_chkViewAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAddUser, logger)) {
			element = chkViewAddUser;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl05_chkEdit")
	private WebElement chkEditAddUser;
	
	public WebElement get_chkEditAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAddUser, logger)) {
			element = chkEditAddUser;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl06_chkView")
	private WebElement chkViewMaster;
	
	public WebElement get_chkViewMaster() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewMaster, logger)) {
			element = chkViewMaster;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl06_chkEdit")
	private WebElement chkEditMaster;
	
	public WebElement get_chkEditMaster() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditMaster, logger)) {
			element = chkEditMaster;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl07_chkView")
	private WebElement chkViewEquipment;
	
	public WebElement get_chkViewEquipment() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipment, logger)) {
			element = chkViewEquipment;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl07_chkEdit")
	private WebElement chkEditEquipment;
	
	public WebElement get_chkEditEquipment() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipment, logger)) {
			element = chkEditEquipment;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl08_chkView")
	private WebElement chkViewEquipment_1;
	
	public WebElement get_chkViewEquipment_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipment_1, logger)) {
			element = chkViewEquipment_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl08_chkEdit")
	private WebElement chkEditEquipment_1;
	
	public WebElement get_chkEditEquipment_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipment_1, logger)) {
			element = chkEditEquipment_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl09_chkView")
	private WebElement chkViewEquipmentType;
	
	public WebElement get_chkViewEquipmentType() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipmentType, logger)) {
			element = chkViewEquipmentType;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl09_chkEdit")
	private WebElement chkEditEquipmentType;
	
	public WebElement get_chkEditEquipmentType() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipmentType, logger)) {
			element = chkEditEquipmentType;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl10_chkView")
	private WebElement chkViewComponents;
	
	public WebElement get_chkViewComponents() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewComponents, logger)) {
			element = chkViewComponents;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl10_chkEdit")
	private WebElement chkEditComponents;
	
	public WebElement get_chkEditComponents() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditComponents, logger)) {
			element = chkEditComponents;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl11_chkView")
	private WebElement chkViewParemetersIOPoint;
	
	public WebElement get_chkViewParemetersIOPoint() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewParemetersIOPoint, logger)) {
			element = chkViewParemetersIOPoint;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl11_chkEdit")
	private WebElement chkEditParemetersIOPoint;
	
	public WebElement get_chkEditParemetersIOPoint() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditParemetersIOPoint, logger)) {
			element = chkEditParemetersIOPoint;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl12_chkView")
	private WebElement chkViewParemetersIOPoint_1;
	
	public WebElement get_chkViewParemetersIOPoint_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewParemetersIOPoint_1, logger)) {
			element = chkViewParemetersIOPoint_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl12_chkEdit")
	private WebElement chkEditParemetersIOPoint_1;
	
	public WebElement get_chkEditParemetersIOPoint_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditParemetersIOPoint_1, logger)) {
			element = chkEditParemetersIOPoint_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl13_chkView")
	private WebElement chkViewDevice;
	
	public WebElement get_chkViewDevice() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewDevice, logger)) {
			element = chkViewDevice;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl13_chkEdit")
	private WebElement chkEditDevice;
	
	public WebElement get_chkEditDevice() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditDevice, logger)) {
			element = chkEditDevice;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl14_chkView")
	private WebElement chkViewFieldDevice;
	
	public WebElement get_chkViewFieldDevice() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFieldDevice, logger)) {
			element = chkViewFieldDevice;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl14_chkEdit")
	private WebElement chkEditFieldDevice;
	
	public WebElement get_chkEditFieldDevice() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditFieldDevice, logger)) {
			element = chkEditFieldDevice;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl15_chkView")
	private WebElement chkViewController_1;
	
	public WebElement get_chkViewController_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewController_1, logger)) {
			element = chkViewController_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl15_chkEdit")
	private WebElement chkEditController_1;
	
	public WebElement get_chkEditController_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditController_1, logger)) {
			element = chkEditController_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl16_chkView")
	private WebElement chkViewController_2;
	
	public WebElement get_chkViewController_2() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewController_2, logger)) {
			element = chkViewController_2;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl16_chkEdit")
	private WebElement chkEditController_2;
	
	public WebElement get_chkEditController_2() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditController_2, logger)) {
			element = chkEditController_2;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl17_chkView")
	private WebElement chkViewRouterGateway_1;
	
	public WebElement get_chkViewRouterGateway_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewRouterGateway_1, logger)) {
			element = chkViewRouterGateway_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl17_chkEdit")
	private WebElement chkEditRouterGateway_1;
	
	public WebElement get_chkEditRouterGateway_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditRouterGateway_1, logger)) {
			element = chkEditRouterGateway_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl18_chkView")
	private WebElement chkViewRouterGateway_2;
	
	public WebElement get_chkViewRouterGateway_2() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewRouterGateway_2, logger)) {
			element = chkViewRouterGateway_2;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl18_chkEdit")
	private WebElement chkEditRouterGateway_2;
	
	public WebElement get_chkEditRouterGateway_2() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditRouterGateway_2, logger)) {
			element = chkEditRouterGateway_2;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl19_chkView")
	private WebElement chkViewProfile;
	
	public WebElement get_chkViewProfile() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewProfile, logger)) {
			element = chkViewProfile;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl19_chkEdit")
	private WebElement chkEditProfile;
	
	public WebElement get_chkEditProfile() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditProfile, logger)) {
			element = chkEditProfile;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl20_chkView")
	private WebElement chkViewProfileSummary;
	
	public WebElement get_chkViewProfileSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewProfileSummary, logger)) {
			element = chkViewProfileSummary;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl20_chkEdit")
	private WebElement chkEditProfileSummary;
	
	public WebElement get_chkEditProfileSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditProfileSummary, logger)) {
			element = chkEditProfileSummary;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl21_chkView")
	private WebElement chkViewProfileView;
	
	public WebElement get_chkViewProfileView() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewProfileView, logger)) {
			element = chkViewProfileView;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl21_chkEdit")
	private WebElement chkEditProfileView;
	
	public WebElement get_chkEditProfileView() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditProfileView, logger)) {
			element = chkEditProfileView;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl22_chkView")
	private WebElement chkViewEngineering;
	
	public WebElement get_chkViewEngineering() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEngineering, logger)) {
			element = chkViewEngineering;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl22_chkEdit")
	private WebElement chkEditEngineering;
	
	public WebElement get_chkEditEngineering() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEngineering, logger)) {
			element = chkEditEngineering;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl23_chkView")
	private WebElement chkViewCreateProject;
	
	public WebElement get_chkViewCreateProject() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewCreateProject, logger)) {
			element = chkViewCreateProject;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl23_chkEdit")
	private WebElement chkEditCreateProject;
	
	public WebElement get_chkEditCreateProject() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditCreateProject, logger)) {
			element = chkEditCreateProject;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl24_chkView")
	private WebElement chkViewProjectInfo;
	
	public WebElement get_chkViewProjectInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewProjectInfo, logger)) {
			element = chkViewProjectInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl24_chkEdit")
	private WebElement chkEditProjectInfo;
	
	public WebElement get_chkEditProjectInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditProjectInfo, logger)) {
			element = chkEditProjectInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl25_chkView")
	private WebElement chkViewContractInfo;
	
	public WebElement get_chkViewContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewContractInfo, logger)) {
			element = chkViewContractInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl25_chkEdit")
	private WebElement chkEditContractInfo;
	
	public WebElement get_chkEditContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditContractInfo, logger)) {
			element = chkEditContractInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl26_chkView")
	private WebElement chkViewFacilityDetails;
	
	public WebElement get_chkViewFacilityDetails() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFacilityDetails, logger)) {
			element = chkViewFacilityDetails;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl26_chkEdit")
	private WebElement chkEditFacilityDetails;
	
	public WebElement get_chkEditFacilityDetails() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditFacilityDetails, logger)) {
			element = chkEditFacilityDetails;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl27_chkView")
	private WebElement chkViewEquipmentInfo;
	
	public WebElement get_chkViewEquipmentInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipmentInfo, logger)) {
			element = chkViewEquipmentInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl27_chkEdit")
	private WebElement chkEditEquipmentInfo;
	
	public WebElement get_chkEditEquipmentInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipmentInfo, logger)) {
			element = chkEditEquipmentInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl28_chkView")
	private WebElement chkViewEquipmentConfig;
	
	public WebElement get_chkViewEquipmentConfig() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipmentConfig, logger)) {
			element = chkViewEquipmentConfig;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl28_chkEdit")
	private WebElement chkEditEquipmentConfig;
	
	public WebElement get_chkEditEquipmentConfig() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipmentConfig, logger)) {
			element = chkEditEquipmentConfig;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl29_chkView")
	private WebElement chkViewEquipmentSummary;
	
	public WebElement get_chkViewEquipmentSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEquipmentSummary, logger)) {
			element = chkViewEquipmentSummary;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl29_chkEdit")
	private WebElement chkEditEquipmentSummary;
	
	public WebElement get_chkEditEquipmentSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEquipmentSummary, logger)) {
			element = chkEditEquipmentSummary;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl30_chkView")
	private WebElement chkViewPanelInfo;
	
	public WebElement get_chkViewPanelInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPanelInfo, logger)) {
			element = chkViewPanelInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl30_chkEdit")
	private WebElement chkEditPanelInfo;
	
	public WebElement get_chkEditPanelInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPanelInfo, logger)) {
			element = chkEditPanelInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl31_chkView")
	private WebElement chkViewPanelInfo_1;
	
	public WebElement get_chkViewPanelInfo_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPanelInfo_1, logger)) {
			element = chkViewPanelInfo_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl31_chkEdit")
	private WebElement chkEditPanelInfo_1;
	
	public WebElement get_chkEditPanelInfo_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPanelInfo_1, logger)) {
			element = chkEditPanelInfo_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl32_chkView")
	private WebElement chkViewNetworkInfo;
	
	public WebElement get_chkViewNetworkInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewNetworkInfo, logger)) {
			element = chkViewNetworkInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl32_chkEdit")
	private WebElement chkEditNetworkInfo;
	
	public WebElement get_chkEditNetworkInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditNetworkInfo, logger)) {
			element = chkEditNetworkInfo;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl33_chkView")
	private WebElement chkViewNetworkInfo_1;
	
	public WebElement get_chkViewNetworkInfo_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewNetworkInfo_1, logger)) {
			element = chkViewNetworkInfo_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl33_chkEdit")
	private WebElement chkEditNetworkInfo_1;
	
	public WebElement get_chkEditNetworkInfo_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditNetworkInfo_1, logger)) {
			element = chkEditNetworkInfo_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl34_chkView")
	private WebElement chkViewNetworkDefinition;
	
	public WebElement get_chkViewNetworkDefinition() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewNetworkDefinition, logger)) {
			element = chkViewNetworkDefinition;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl34_chkEdit")
	private WebElement chkEditNetworkDefinition;
	
	public WebElement get_chkEditNetworkDefinition() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditNetworkDefinition, logger)) {
			element = chkEditNetworkDefinition;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl35_chkView")
	private WebElement chkViewRoomSchedule;
	
	public WebElement get_chkViewRoomSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewRoomSchedule, logger)) {
			element = chkViewRoomSchedule;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl35_chkEdit")
	private WebElement chkEditRoomSchedule;
	
	public WebElement get_chkEditRoomSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditRoomSchedule, logger)) {
			element = chkEditRoomSchedule;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl36_chkView")
	private WebElement chkViewRoomSchedule_1;
	
	public WebElement get_chkViewRoomSchedule_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewRoomSchedule_1, logger)) {
			element = chkViewRoomSchedule_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl36_chkEdit")
	private WebElement chkEditRoomSchedule_1;
	
	public WebElement get_chkEditRoomSchedule_1() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditRoomSchedule_1, logger)) {
			element = chkEditRoomSchedule_1;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl37_chkView")
	private WebElement chkViewSubmitals;
	
	public WebElement get_chkViewSubmitals() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSubmitals, logger)) {
			element = chkViewSubmitals;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl37_chkEdit")
	private WebElement chkEditSubmitals;
	
	public WebElement get_chkEditSubmitals() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSubmitals, logger)) {
			element = chkEditSubmitals;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl38_chkView")
	private WebElement chkViewControlProcess;
	
	public WebElement get_chkViewControlProcess() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewControlProcess, logger)) {
			element = chkViewControlProcess;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl38_chkEdit")
	private WebElement chkEditControlProcess;
	
	public WebElement get_chkEditControlProcess() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditControlProcess, logger)) {
			element = chkEditControlProcess;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl39_chkView")
	private WebElement chkViewScheduleView;
	
	public WebElement get_chkViewScheduleView() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewScheduleView, logger)) {
			element = chkViewScheduleView;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl39_chkEdit")
	private WebElement chkEditScheduleView;
	
	public WebElement get_chkEditScheduleView() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditScheduleView, logger)) {
			element = chkEditScheduleView;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl40_chkView")
	private WebElement chkViewAllItemTree;
	
	public WebElement get_chkViewAllItemTree() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAllItemTree, logger)) {
			element = chkViewAllItemTree;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rtlUserRoleAndRight_ctl40_chkEdit")
	private WebElement chkEditAllItemTree;
	
	public WebElement get_chkEditAllItemTree() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAllItemTree, logger)) {
			element = chkEditAllItemTree;
		}
		return element;
	}
}


























