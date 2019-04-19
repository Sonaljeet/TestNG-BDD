package mars.JCI.Project.BCMET.Engineering;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCMET_Engineering_CreateNewProjectPage_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	public BCMET_Engineering_CreateNewProjectPage_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "automation_id=\"Engg_CreatePro_Pro_Info_AllTabs\"")
	private WebElement CP_AllTabsTableGrid;
	public WebElement get_CP_AllTabsTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_AllTabsTableGrid, logger)) {
			element = CP_AllTabsTableGrid;
		}
		return element;
	}
	
	@FindBy(id="lblSystemConfig")
	private WebElement CP_EquipmentInfoLink;
	public WebElement get_CP_EquipmentInfoLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_EquipmentInfoLink, logger)) {
			element = CP_EquipmentInfoLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg__CreatePro_Pro_Info_Link\"")
	private WebElement CP_ProjectInformationLink;
	public WebElement get_CP_ProjectInformationLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_ProjectInformationLink, logger)) {
			element = CP_ProjectInformationLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_CreatePro_PanelInfoLink\"")
	private WebElement CP_PanelInfoLink;
	public WebElement get_CP_PanelInfoLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_PanelInfoLink, logger)) {
			element = CP_PanelInfoLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_CreatePro_NetworkInfoLink\"")
	private WebElement CP_NetworkInfoLink;
	public WebElement get_CP_NetworkInfoLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_NetworkInfoLink, logger)) {
			element = CP_NetworkInfoLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_CreatePro_RoomScheduleLink\"")
	private WebElement CP_RoomScheduleLink;
	public WebElement get_CP_RoomScheduleLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_RoomScheduleLink, logger)) {
			element = CP_RoomScheduleLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_CreatePro_ControlProcessLink\"")
	private WebElement CP_ControlProcessLink;
	public WebElement get_CP_ControlProcessLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_ControlProcessLink, logger)) {
			element = CP_ControlProcessLink;
		}
		return element;
	}
	
	@FindBy(id="lnkbtbBacktoProjectList")
	private WebElement CP_BackToProjectListLink;
	public WebElement get_CP_BackToProjectListLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_BackToProjectListLink, logger)) {
			element = CP_BackToProjectListLink;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_Pro_Info_InfoCompleteCheckbox\"")
	private WebElement CP_InfoCompleteCheckbox;
	public WebElement get_CP_InfoCompleteCheckbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_InfoCompleteCheckbox, logger)) {
			element = CP_InfoCompleteCheckbox;
		}
		return element;
	}
	
	@FindBy(css = "div[automation_id=\"Engg_Pro_Info_PopMessageBoxInfo\"]")
	private WebElement CP_PopMessageBoxInfo;
	public WebElement get_CP_PopMessageBoxInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_PopMessageBoxInfo,logger)) {
			element = CP_PopMessageBoxInfo;
		}
		return element;
	}

	@FindBy(css = "automation_id=\"Engg_Pro_Info_PopBoxOkButton\"")
	private WebElement CP_PopBoxOkButton;
	public WebElement get_CP_PopBoxOkButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_PopBoxOkButton,logger)) {
			element = CP_PopBoxOkButton;
		}
		return element;
	}
//Contract Info section	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ProjectName\"]")
	private WebElement ProjectName;
	public WebElement get_ProjectName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ProjectName,logger)) {
			element = ProjectName;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ProjectNumber\"]")
	private WebElement ProjectNumber;
	public WebElement get_ProjectNumber() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ProjectNumber,logger)) {
			element = ProjectNumber;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ProjectManager\"]")
	private WebElement CP_ProjectManager;
	public WebElement get_CP_ProjectManager() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_ProjectManager,logger)) {
			element = CP_ProjectManager;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCProjectInformation_dpProjectStartDate_dateInput")
	private WebElement CP_StartDate;
	public WebElement get_CP_StartDate() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_StartDate,logger)) {
			element = CP_StartDate;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_Branch\"]")
	private WebElement CP_Info_Branch;
	public WebElement get_CP_Info_Branch() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_Info_Branch,logger)) {
			element = CP_Info_Branch;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCProjectInformation_rcbProjectProfile_DropDown")
	private WebElement CP_ProjectProfile;
	public WebElement get_CP_ProjectProfile() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CP_ProjectProfile,logger)) {
			element = CP_ProjectProfile;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCProjectInformation_rcbProjectProfile_Arrow")
	private WebElement ProjectProfileDDArrow;
	public WebElement get_ProjectProfileDDArrow() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ProjectProfileDDArrow,logger)) {
			element = ProjectProfileDDArrow;
		}
		return element;
	}
	
	@FindBy(css = "automation_id=\"Engg_Pro_Info_LastRevDate\"")
	private WebElement LastRevDate;
	public WebElement get_LastRevDate() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, LastRevDate,logger)) {
			element = LastRevDate;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_EnggRevision\"]")
	private WebElement EnggRevision;
	public WebElement get_EnggRevision() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, EnggRevision,logger)) {
			element = EnggRevision;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCProjectInformation_rcbSystemUnitType_DropDown")
	private WebElement SystemUnitsTableGrid;
	public WebElement get_SystemUnitsTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SystemUnitsTableGrid,logger)) {
			element = SystemUnitsTableGrid;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCProjectInformation_rcbSystemUnitType_Arrow")
	private WebElement SystemOfUnitsDropDownArrow;
	public WebElement get_SystemOfUnitsDropDownArrow() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SystemOfUnitsDropDownArrow,logger)) {
			element = SystemOfUnitsDropDownArrow;
		}
		return element;
	}
//Sales Person info	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_SalesPersonName\"]")
	private WebElement SalesPersonName;
	public WebElement get_SalesPersonName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SalesPersonName,logger)) {
			element = SalesPersonName;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_SalesPersonEmail\"]")
	private WebElement SalesPersonEmail;
	public WebElement get_SalesPersonEmail() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SalesPersonEmail,logger)) {
			element = SalesPersonEmail;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_SalesPersonContactNumber\"]")
	private WebElement SalesPersonContactNumber;
	public WebElement get_SalesPersonContactNumber() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SalesPersonContactNumber,logger)) {
			element = SalesPersonContactNumber;
		}
		return element;
	}
//Consultant Firm info	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ConsultantName\"]")
	private WebElement ConsultantName;
	public WebElement get_ConsultantName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ConsultantName,logger)) {
			element = ConsultantName;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ConsultantContactPerson\"]")
	private WebElement ConsultantContactPerson;
	public WebElement get_ConsultantContactPerson() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ConsultantContactPerson,logger)) {
			element = ConsultantContactPerson;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ConsultanEmail\"]")
	private WebElement ConsultanEmail;
	public WebElement get_ConsultanEmail() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ConsultanEmail,logger)) {
			element = ConsultanEmail;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_ConsultantEmailNumber\"]")
	private WebElement ConsultantNumber;
	public WebElement get_ConsultantNumber() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ConsultantNumber,logger)) {
			element = ConsultantNumber;
		}
		return element;
	}
//Customer Info	
	@FindBy(id = "ctl00_bodyPlaceholder_UCProjectInformation_rcbCustomerName_Input")
	private WebElement CustomerName;
	public WebElement get_CustomerName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerName,logger)) {
			element = CustomerName;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_CustomerContactPerson\"]")
	private WebElement CustomerContactPerson;
	public WebElement get_CustomerContactPerson() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerContactPerson,logger)) {
			element = CustomerContactPerson;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_CustomerEmail\"]")
	private WebElement CustomerEmail;
	public WebElement get_CustomerEmail() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerEmail,logger)) {
			element = CustomerEmail;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_CustomerContactNumber\"")
	private WebElement CustomerContactNumber;
	public WebElement get_CustomerContactNumber() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerContactNumber,logger)) {
			element = CustomerContactNumber;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_CustomerSiteAddress\"]")
	private WebElement CustomerSiteAddress;
	public WebElement get_CustomerSiteAddress() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, CustomerSiteAddress,logger)) {
			element = CustomerSiteAddress;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_EstimatorName\"]")
	private WebElement EstimatorName;
	public WebElement get_EstimatorName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, EstimatorName,logger)) {
			element = EstimatorName;
		}
		return element;
	}
	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_SaveContractInfoButton\"]")
	private WebElement SaveContractInfoButton;
	public WebElement get_SaveContractInfoButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SaveContractInfoButton,logger)) {
			element = SaveContractInfoButton;
		}
		return element;
	}
//Facility Details	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_FacilityDetailsSelectorLink\"]")
	private WebElement FacilityDetailsSelectorLink;
	public WebElement get_FacilityDetailsSelectorLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityDetailsSelectorLink,logger)) {
			element = FacilityDetailsSelectorLink;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_FacilityNoOfBuildings\"]")
	private WebElement FacilityNoOfBuildings;
	public WebElement get_FacilityNoOfBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityNoOfBuildings,logger)) {
			element = FacilityNoOfBuildings;
		}
		return element;
	}
	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_FacilityBUildingsAddButton\"]")
	private WebElement FacilityBUildingsAddButton;
	public WebElement get_FacilityBUildingsAddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityBUildingsAddButton,logger)) {
			element = FacilityBUildingsAddButton;
		}
		return element;
	}
	
	@FindBy(css = "div[automation_id=\"Engg_Pro_Info_BuildingsListTableGrid\"]")
	private WebElement BuildingsListTableGrid;
	public WebElement get_BuildingsListTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, BuildingsListTableGrid,logger)) {
			element = BuildingsListTableGrid;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_FacilityNoLevels\"]")
	private WebElement FacilityNoLevels;
	public WebElement get_FacilityNoLevels() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityNoLevels,logger)) {
			element = FacilityNoLevels;
		}
		return element;
	}
	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_FacilityInsertLevelDropDownArrow\"]")
	private WebElement FacilityInsertLevelDropDownArrow;
	public WebElement get_FacilityInsertLevelDropDownArrow() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityInsertLevelDropDownArrow,logger)) {
			element = FacilityInsertLevelDropDownArrow;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_rcbInsertLevel_Input")
	private WebElement FacilityInsertLevelDropDownBox;
	public WebElement get_FacilityInsertLevelDropDownBox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityInsertLevelDropDownBox,logger)) {
			element = FacilityInsertLevelDropDownBox;
		}
		return element;
	}
	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_FacilityInsertLevelAddButton\"]")
	private WebElement FacilityInsertLevelAddButton;
	public WebElement get_FacilityInsertLevelAddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityInsertLevelAddButton,logger)) {
			element = FacilityInsertLevelAddButton;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_FacilityNoOfZones\"]")
	private WebElement FacilityNoOfZones;
	public WebElement get_FacilityNoOfZones() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityNoOfZones,logger)) {
			element = FacilityNoOfZones;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_Pro_Info_FacilityZoneName\"]")
	private WebElement FacilityZoneName;
	public WebElement get_FacilityZoneName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityZoneName,logger)) {
			element = FacilityZoneName;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_rcb_ZoneType_Input")
	private WebElement FacilityZoneLabelDropDownTableGrid;
	public WebElement get_FacilityZoneLabelDropDownTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityZoneLabelDropDownTableGrid,logger)) {
			element = FacilityZoneLabelDropDownTableGrid;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_rcb_ZoneType_Arrow")
	private WebElement FacilityZoneLabelDropDownArrow;
	public WebElement get_FacilityZoneLabelDropDownArrow() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityZoneLabelDropDownArrow,logger)) {
			element = FacilityZoneLabelDropDownArrow;
		}
		return element;
	}
	
	@FindBy(id="rcbApplySimiler_Input")
	private WebElement ApplySimilarDropDownTableGrid;
	public WebElement get_ApplySimilarDropDownTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ApplySimilarDropDownTableGrid,logger)) {
			element = ApplySimilarDropDownTableGrid;
		}
		return element;
	}
	
	@FindBy(css = "a[automation_id=\"Engg_Pro_Info_FacilityZoneAddButton\"]")
	private WebElement FacilityZoneAddButton;
	public WebElement get_FacilityZoneAddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityZoneAddButton,logger)) {
			element = FacilityZoneAddButton;
		}
		return element;
	}
	//Edit button is same for Building, Level and Zone
	@FindBy(id = "ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_imgEditNode")
	private WebElement FacilityBuildingEditIcon;
	public WebElement get_FacilityBuildingEditIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityBuildingEditIcon,logger)) {
			element = FacilityBuildingEditIcon;
		}
		return element;
	}
	//Delete button is same for Building, Level and Zone
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_imgDeleteNode")
	private WebElement FacilityBUildingDeleteIcon;
	public WebElement get_FacilityBUildingDeleteIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilityBUildingDeleteIcon,logger)) {
			element = FacilityBUildingDeleteIcon;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_btnYes_input")
	private WebElement PopupBoxDeleteYesButton;
	public WebElement get_PopupBoxDeleteYesButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopupBoxDeleteYesButton,logger)) {
			element = PopupBoxDeleteYesButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_btnNo_input")
	private WebElement PopupBoxDeleteNoButton;
	public WebElement get_PopupBoxDeleteNoButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopupBoxDeleteNoButton,logger)) {
			element = PopupBoxDeleteNoButton;
		}
		return element;
	}
	///////////////////////////////////////////////
	@FindBy(css = "div[automation_id=\"Engg_Pro_Info_PopMessageBoxInfoBox\"]")
	private WebElement PopMessageBoxInfoBox;
	public WebElement get_PopMessageBoxInfoBox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopMessageBoxInfoBox, logger)) {
			element = PopMessageBoxInfoBox;
		}
		return element;
	}
	
	@FindBy(css = "input[automation_id=\"Engg_ActiveProList_PopOkButton\"]")
	private WebElement PopupBoxOkButton;
	public WebElement get_PopupBoxOkButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, PopupBoxOkButton,logger)) {
			element = PopupBoxOkButton;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_UCFacilityDetails_btnSaveFacilityDetails")
	private WebElement FacilitySaveButton;
	public WebElement get_FacilitySaveButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, FacilitySaveButton,logger)) {
			element = FacilitySaveButton;
		}
		return element;
	}

}
