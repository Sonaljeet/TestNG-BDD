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

public class BCM_Setup_UserRole_Page_Factory {
	private WebDriver driver = null;
	private ExtentTest logger = null;

	public BCM_Setup_UserRole_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loader")
	private WebElement ImageLoader;

	public WebElement get_ImageLoader() {
		WebElement element = null;
		if (WebElementCommon.isDisplayedByElement(ImageLoader)) {
			element = ImageLoader;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement adminImageLink;

	public WebElement get_adminImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, adminImageLink, logger)) {
			element = adminImageLink;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement CustomerImageLink;

	public WebElement get_CustomerImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerImageLink, logger)) {
			element = CustomerImageLink;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement TechnicianImageLink;

	public WebElement get_TechnicianImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, TechnicianImageLink, logger)) {
			element = TechnicianImageLink;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement SaveButton;

	public WebElement get_SaveButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveButton, logger)) {
			element = SaveButton;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement SaveUpdateMessageInfo;

	public WebElement get_SaveUpdateMessageInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveUpdateMessageInfo, logger)) {
			element = SaveUpdateMessageInfo;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement SaveYesButton;

	public WebElement get_SaveYesButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveYesButton, logger)) {
			element = SaveYesButton;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement SaveNoButton;

	public WebElement get_SaveNoButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveNoButton, logger)) {
			element = SaveNoButton;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement SaveCancelButton;

	public WebElement get_SaveCancelButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveCancelButton, logger)) {
			element = SaveCancelButton;
		}
		return element;
	}

	@FindBy(id = "")
	private WebElement UserRolesDataTable;

	public WebElement get_UserRolesDataTable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserRolesDataTable, logger)) {
			element = UserRolesDataTable;
		}
		return element;
	}
	// Checkboxes

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl03_chkView")
	private WebElement chkViewBCM;

	public WebElement get_chkViewBCM() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBCM, logger) == true) {
			element = chkViewBCM;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl03_chkEdit")
	private WebElement chkEditBCM;

	public WebElement get_chkEditBCM() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBCM, logger) == true) {
			element = chkEditBCM;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl04_chkView")
	
	private WebElement chkViewSetup;

	public WebElement get_chkViewSetup() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSetup, logger) == true) {
			element = chkViewSetup;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl04_chkEdit")
	private WebElement chkEditSetup;

	public WebElement get_chkEditSetup() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSetup, logger) == true) {
			element = chkEditSetup;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl05_chkView")
	private WebElement chkViewContractInfo;

	public WebElement get_chkViewContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewContractInfo, logger) == true) {
			element = chkViewContractInfo;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl05_chkEdit")
	private WebElement chkEditContractInfo;

	public WebElement get_chkEditContractInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditContractInfo, logger) == true) {
			element = chkEditContractInfo;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl06_chkView")
	private WebElement chkViewPointDiscovery;

	public WebElement get_chkViewPointDiscovery() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPointDiscovery, logger) == true) {
			element = chkViewPointDiscovery;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl06_chkEdit")
	private WebElement chkEditPointDiscovery;

	public WebElement get_chkEditPointDiscovery() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPointDiscovery, logger) == true) {
			element = chkEditPointDiscovery;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl07_chkView")
	private WebElement chkViewBuildings;

	public WebElement get_chkViewBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBuildings, logger) == true) {
			element = chkViewBuildings;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl07_chkEdit")
	private WebElement chkEditBuildings;

	public WebElement get_chkEditBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBuildings, logger) == true) {
			element = chkEditBuildings;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl08_chkView")
	private WebElement chkViewSystems;

	public WebElement get_chkViewSystems() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSystems, logger) == true) {
			element = chkViewSystems;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl08_chkEdit")
	private WebElement chkEditSystems;

	public WebElement get_chkEditSystems() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSystems, logger) == true) {
			element = chkEditSystems;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl09_chkView")
	private WebElement chkViewCustomSummary;

	public WebElement get_chkViewCustomSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewCustomSummary, logger) == true) {
			element = chkViewCustomSummary;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl09_chkEdit")
	private WebElement chkEditCustomSummary;

	public WebElement get_chkEditCustomSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditCustomSummary, logger) == true) {
			element = chkEditCustomSummary;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl10_chkView")
	private WebElement chkViewEnergyMeter;

	public WebElement get_chkViewEnergyMeter() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEnergyMeter, logger) == true) {
			element = chkViewEnergyMeter;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl10_chkEdit")
	private WebElement chkEditEnergyMeter;

	public WebElement get_chkEditEnergyMeter() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEnergyMeter, logger) == true) {
			element = chkEditEnergyMeter;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl11_chkView")
	private WebElement chkViewUserRole;

	public WebElement get_chkViewUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewUserRole, logger) == true) {
			element = chkViewUserRole;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl11_chkEdit")
	private WebElement chkEditUserRole;

	public WebElement get_chkEditUserRole() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditUserRole, logger) == true) {
			element = chkEditUserRole;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl12_chkView")
	private WebElement chkViewAddUser;

	public WebElement get_chkViewAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAddUser, logger) == true) {
			element = chkViewAddUser;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl12_chkEdit")
	private WebElement chkEditAddUser;

	public WebElement get_chkEditAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAddUser, logger) == true) {
			element = chkEditAddUser;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl13_chkView")
	private WebElement chkViewFloorPlan;

	public WebElement get_chkViewFloorPlan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFloorPlan, logger) == true) {
			element = chkViewFloorPlan;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl13_chkEdit")
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

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl14_chkEdit")
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

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl15_chkEdit")
	private WebElement chkEditVAV;

	public WebElement get_chkEditVAV() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditVAV, logger) == true) {
			element = chkEditVAV;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl16_chkView")
	private WebElement chkViewAcPlant;

	public WebElement get_chkViewAcPlant() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAcPlant, logger) == true) {
			element = chkViewAcPlant;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl16_chkEdit")
	private WebElement chkEditAcPlant;

	public WebElement get_chkEditAcPlant() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAcPlant, logger) == true) {
			element = chkEditAcPlant;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl17_chkView")
	private WebElement chkViewBoiler;

	public WebElement get_chkViewBoiler() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewBoiler, logger) == true) {
			element = chkViewBoiler;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl17_chkEdit")
	private WebElement chkEditBoiler;

	public WebElement get_chkEditBoiler() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditBoiler, logger) == true) {
			element = chkEditBoiler;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl18_chkView")
	private WebElement chkViewAlarm;

	public WebElement get_chkViewAlarm() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewAlarm, logger) == true) {
			element = chkViewAlarm;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl18_chkEdit")
	private WebElement chkEditAlarm;

	public WebElement get_chkEditAlarm() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditAlarm, logger) == true) {
			element = chkEditAlarm;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl19_chkView")
	private WebElement chkViewTrend;

	public WebElement get_chkViewTrend() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewTrend, logger) == true) {
			element = chkViewTrend;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl19_chkEdit")
	private WebElement chkEditTrend;

	public WebElement get_chkEditTrend() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditTrend, logger) == true) {
			element = chkEditTrend;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl20_chkView")
	private WebElement chkViewSchedule;

	public WebElement get_chkViewSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSchedule, logger) == true) {
			element = chkViewSchedule;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl20_chkEdit")
	private WebElement chkEditSchedule;

	public WebElement get_chkEditSchedule() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSchedule, logger) == true) {
			element = chkEditSchedule;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl21_chkView")
	private WebElement chkViewEnergy;

	public WebElement get_chkViewEnergy() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewEnergy, logger) == true) {
			element = chkViewEnergy;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl21_chkEdit")
	private WebElement chkEditEnergy;

	public WebElement get_chkEditEnergy() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditEnergy, logger) == true) {
			element = chkEditEnergy;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl22_chkView")
	private WebElement chkViewFCU;

	public WebElement get_chkViewFCU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewFCU, logger) == true) {
			element = chkViewFCU;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl22_chkEdit")
	private WebElement chkEditFCU;

	public WebElement get_chkEditFCU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditFCU, logger) == true) {
			element = chkEditFCU;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl23_chkView")
	private WebElement chkViewExhaustFan;

	public WebElement get_chkViewExhaustFan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewExhaustFan, logger) == true) {
			element = chkViewExhaustFan;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl23_chkEdit")
	private WebElement chkEditExhaustFan;

	public WebElement get_chkEditExhaustFan() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditExhaustFan, logger) == true) {
			element = chkEditExhaustFan;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl24_chkView")
	private WebElement chkViewSumpPump;

	public WebElement get_chkViewSumpPump() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewSumpPump, logger) == true) {
			element = chkViewSumpPump;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl24_chkEdit")
	private WebElement chkEditSumpPump;

	public WebElement get_chkEditSumpPump() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditSumpPump, logger) == true) {
			element = chkEditSumpPump;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl25_chkView")
	private WebElement chkViewPAU;

	public WebElement get_chkViewPAU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewPAU, logger) == true) {
			element = chkViewPAU;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl25_chkEdit")
	private WebElement chkEditPAU;

	public WebElement get_chkEditPAU() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditPAU, logger) == true) {
			element = chkEditPAU;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl26_chkView")
	private WebElement chkViewMiscellaneous;

	public WebElement get_chkViewMiscellaneous() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkViewMiscellaneous, logger) == true) {
			element = chkViewMiscellaneous;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RTL_RolesAndRights_ctl26_chkEdit")
	private WebElement chkEditMiscellaneous;

	public WebElement get_chkEditMiscellaneous() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, chkEditMiscellaneous, logger) == true) {
			element = chkEditMiscellaneous;
		}
		return element;
	}
}
