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

public class BCM_Setup_Buildings_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;

	public BCM_Setup_Buildings_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_radtxtProjectName")
	private WebElement projectName;

	public WebElement get_projectName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, projectName, logger)) {
			element = projectName;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rcb_DateTimeFormat_Arrow")
	private WebElement dateFormatArrowIcon;

	public WebElement get_dateFormatArrowIcon(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, dateFormatArrowIcon, logger)) {
			element = dateFormatArrowIcon;
		}
		return element;
	}

	@FindBy(className = "rcbList")
	private WebElement dateFormatDropDownList;

	public WebElement get_dateFormatDropDownList(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, dateFormatDropDownList, logger)) {
			element = dateFormatDropDownList;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_radtxtNumOfBuildings")
	private WebElement numberOfBuildings;

	public WebElement get_numberOfBuildings(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, numberOfBuildings, logger)) {
			element = numberOfBuildings;
		}
		return element;
	}

	@FindBy(className = "ruButton ruBrowse")
	private WebElement browseImageButton;

	public WebElement get_browseImageButton(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, browseImageButton, logger)) {
			element = browseImageButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadBtnSubmit_input")
	private WebElement saveProjectDetailsButton;

	public WebElement get_saveProjectDetailsButton(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, saveProjectDetailsButton, logger)) {
			element = saveProjectDetailsButton;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblMsgBuilding")
	private WebElement saveUpdateSuccessInfo;

	public WebElement get_saveUpdateSuccessInfo(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, saveUpdateSuccessInfo, logger)) {
			element = saveUpdateSuccessInfo;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblEnterProjName")
	private WebElement errorMsgProjectName;

	public WebElement get_errorMsgProjectName(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgProjectName, logger)) {
			element = errorMsgProjectName;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblNumOfBuildings")
	private WebElement errorMsgNoOfBuildings;

	public WebElement get_errorMsgNoOfBuildings() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgNoOfBuildings, logger)) {
			element = errorMsgNoOfBuildings;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblMsgDateTime")
	private WebElement errorMsgDateFormat;

	public WebElement get_errorMsgDateFormat() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgDateFormat, logger)) {
			element = errorMsgDateFormat;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll")
	private WebElement buildingListTableGrid;

	public WebElement get_buildingListTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, buildingListTableGrid, logger)) {
			element = buildingListTableGrid;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_imgBtnDeleteBuilding_0")
	private WebElement deleteBuildingIcon;

	public WebElement get_deleteBuildingIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteBuildingIcon, logger)) {
			element = deleteBuildingIcon;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_imgBtnUpdateBuilding_0")
	private WebElement editBuildingNameIcon;

	public WebElement get_editBuildingNameIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editBuildingNameIcon, logger)) {
			element = editBuildingNameIcon;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowEditBudingLable_C_radtxtEditBuildingLable")
	private WebElement editBuildingNameInPopUp;

	public WebElement get_editBuildingNamePopUp() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editBuildingNameInPopUp, logger)) {
			element = editBuildingNameInPopUp;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowEditBudingLable_C_RadBtnUpdateBuildingLable_input")
	private WebElement editBuildingUpdateButtonInPopUp;

	public WebElement get_editBuildingUpdateButtonInPopUp() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editBuildingUpdateButtonInPopUp, logger)) {
			element = editBuildingUpdateButtonInPopUp;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowEditBudingLable_C_btnBuildngLabel")
	private WebElement editBuildingCancelButtonInPopUp;

	public WebElement get_editBuildingCancelButtonInPopUp() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editBuildingCancelButtonInPopUp, logger)) {
			element = editBuildingCancelButtonInPopUp;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_Section")
	private WebElement sectionTableGrid;

	public WebElement get_sectionTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, sectionTableGrid, logger)) {
			element = sectionTableGrid;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_radtxtNumOfFloors")
	private WebElement numberOfFloors;

	public WebElement get_numberOfFloors() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, numberOfFloors, logger)) {
			element = numberOfFloors;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RCB_NumOfSections_DropDown")
	private WebElement numberOfSectionsDDList;

	public WebElement get_numberOfSectionsDDList() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, numberOfSectionsDDList, logger)) {
			element = numberOfSectionsDDList;
		}	
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RCB_NumOfSections_Arrow")
	private WebElement numberOfSectionsDDArrowIcon;

	public WebElement get_numberOfSectionsDDArrowIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, numberOfSectionsDDArrowIcon, logger)) {
			element = numberOfSectionsDDArrowIcon;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_radtxtFloorLable")
	private WebElement floorLableTextInput;

	public WebElement get_floorLableTextInput() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, floorLableTextInput, logger)) {
			element = floorLableTextInput;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_imgBtnAddFloor")
	private WebElement addFloorLableIcon;

	public WebElement get_addFloorLableIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, addFloorLableIcon, logger)) {
			element = addFloorLableIcon;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblEnterNumOfFloors")
	private WebElement enterFloorErrorMessage;

	public WebElement get_enterFloorErrorMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, enterFloorErrorMessage, logger)) {
			element = enterFloorErrorMessage;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_radtxtZoneName")
	private WebElement sectionLableTextInput;

	public WebElement get_sectionLableTextInput() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, sectionLableTextInput, logger)) {
			element = sectionLableTextInput;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rcb_ZoneType_Arrow")
	private WebElement sectionLableDDArrowIcon;

	public WebElement get_sectionLableDDArrowIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, sectionLableDDArrowIcon, logger)) {
			element = sectionLableDDArrowIcon;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rcb_ZoneType_DropDown")
	private WebElement sectionLableDDList;

	public WebElement get_sectionLableDDList() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, sectionLableDDList, logger)) {
			element = sectionLableDDList;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblEnterZoneLable")
	private WebElement errorMsgSectionLable;

	public WebElement get_errorMsgSectionLable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgSectionLable, logger)) {
			element = errorMsgSectionLable;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblSelectApplySimilar")
	private WebElement errorMsgApplySimilar;

	public WebElement get_errorMsgApplySimilar() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgApplySimilar, logger)) {
			element = errorMsgApplySimilar;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rcb_ApplySimilar_Arrow")
	private WebElement applySimilarDDArrowIcon;

	public WebElement get_applySimilarArrowIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, applySimilarDDArrowIcon, logger)) {
			element = applySimilarDDArrowIcon;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rcb_ApplySimilar_DropDown")
	private WebElement applySimilarDDList;

	public WebElement get_applySimilarDDList() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, applySimilarDDList, logger)) {
			element = applySimilarDDList;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_imgBtnAddZone")
	private WebElement applySimilarPlusIcon;

	public WebElement get_applySimilarPlusIcon() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, applySimilarPlusIcon, logger)) {
			element = applySimilarPlusIcon;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel")
	private WebElement floorsTableGrid;

	public WebElement get_floorsTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, floorsTableGrid, logger)) {
			element = floorsTableGrid;
		} 
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblValueNotAllowed")
	private WebElement errorMsgNoOfSection;

	public WebElement get_errorMsgNoOfSection() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, element, logger)) {

		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowConfirmationMsg_Building_C_RadBtn_Build_Ok_input")
	private WebElement deleteBuildingYesBtn;

	public WebElement get_deleteBuildingYesBtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteBuildingYesBtn, logger)) {
			element = deleteBuildingYesBtn;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowConfirmationMsg_Building_C_btnBuildConfrm")
	private WebElement deleteBuildingNoBtn;

	public WebElement get_deleteBuildingNoBtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteBuildingNoBtn, logger)) {
			element = deleteBuildingNoBtn;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblBuildingDelete")
	private WebElement errorMsgdeleteBuilding;

	public WebElement get_errorMsgdeleteBuilding() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgdeleteBuilding, logger)) {
			element = errorMsgdeleteBuilding;
		}
		return element;
	}

	@FindBy(id = "MainMessagebuildingform")
	private WebElement errorMsgAllerrGrid;

	public WebElement get_errorMsgAllErrGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgAllerrGrid, logger)) {
			element = errorMsgAllerrGrid;
		}	
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblMsg_FloorZone")
	private WebElement errorMsgFloorZone;

	public WebElement get_errorMsgFloorZone() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgFloorZone, logger)) {
			element = errorMsgFloorZone;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblSelectBuilding")
	private WebElement errorMsgSelectBuilding;

	public WebElement get_errorMsgSelectBuilding() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgSelectBuilding, logger)) {
			element = errorMsgSelectBuilding;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_CanNotDeleteBuildFloor")
	private WebElement ErrorMsgCannotDeleteBuilding;

	public WebElement get_ErrorMsgCannotDeleteBuilding() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ErrorMsgCannotDeleteBuilding, logger)) {
			element = ErrorMsgCannotDeleteBuilding;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_NotDeleteFloor")
	private WebElement errorMsgNotDeleteFloor;

	public WebElement get_errorMsgNotDeleteFloor() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, errorMsgNotDeleteFloor, logger)) {
			element = errorMsgNotDeleteFloor;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnUpdateFloor_0")
	private WebElement editFloorLableIcon;
	
	public WebElement get_editFloorLableIcon(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editFloorLableIcon, logger)) {
			element = editFloorLableIcon;
		}
		return element;
	}
	
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowEditFloorLevel_C_radtxtEditFloorLable")
	private WebElement editFloorNameInPopUp;
	
	public WebElement get_editFloorNameInPopUp(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editFloorNameInPopUp, logger)) {
			element = editFloorNameInPopUp;
		}
		return element;
	}
	
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowEditFloorLevel_C_RadBtnUpdateFloorLable_input")
	private WebElement updateButtonFloorNameInPopUp;
	
	public WebElement get_updateButtonFloorNameInPopUp(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, updateButtonFloorNameInPopUp, logger)) {
			element = updateButtonFloorNameInPopUp;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnDeleteFloor_0")
	private WebElement deleteFloorIcon;
	
	public WebElement get_deleteFloorIcon(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteFloorIcon, logger)) {
			element = deleteFloorIcon;
		}
		return element;
	}
	//ContentPlaceHolder1_ContentPlaceHolder2_DL_Section_imgBtnUpdateSection_0
	
	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_Section_imgBtnUpdateSection_0")
	private WebElement editSectionLablePencilIcon;
	
	public WebElement get_updateSectionLablePencilIcon(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editSectionLablePencilIcon, logger)) {
			element = editSectionLablePencilIcon;
		}
		return element;
	}
	
	//ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowUpdateSection_C_radtxtUpdateSection
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowUpdateSection_C_radtxtUpdateSection")
	private WebElement editSectionNameInPopUp;
	
	public WebElement get_editSectionNameInPopUp(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, editSectionNameInPopUp, logger)) {
			element = editSectionNameInPopUp;
		}
		return element;
	}
	
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowUpdateSection_C_RadBtnUpdateSectionLable_input")
	private WebElement updateButtonSectionNameInPopUp;
	
	public WebElement get_updateButtonSectionNameInPopUp(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, updateButtonSectionNameInPopUp, logger)) {
			element = updateButtonSectionNameInPopUp;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_DL_Section_imgBtnDeleteZones_0")
	private WebElement deleteSectionIcon;
	
	public WebElement get_deleteSectionIcon(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, deleteSectionIcon, logger)) {
			element = deleteSectionIcon;
		}
		return element;
	}
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowConfirmationMsg_Floor_C_RadBtbOk_input")
	private WebElement floorDeleteYesButtonInPopUp;
	public WebElement get_floorDeleteYesButtonInPopUp(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, floorDeleteYesButtonInPopUp, logger)) {
			element = floorDeleteYesButtonInPopUp;
		}
		return element;
	}
	
	
	
}
