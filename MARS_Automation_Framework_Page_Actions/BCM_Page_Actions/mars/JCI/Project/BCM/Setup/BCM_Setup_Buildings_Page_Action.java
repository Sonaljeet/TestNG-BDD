/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebLink;
import commonFunctions.WebPage;
import commonFunctions.WebTable;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;
import mars.JCI.Projects.BCM.TextConstants.TextConstants;

public class BCM_Setup_Buildings_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCM_Login_Page_Action loginAction = null;
	private static BCM_Setup_Home_Page_Action setupHomeAction = null;
	private static BCM_Setup_Buildings_Page_Factory buildingsFactory = null;
	private static final By IMAGELOADER = By.id("loader");
	
	public BCM_Setup_Buildings_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		
		loginAction = new BCM_Login_Page_Action(driver, logger);
		setupHomeAction = new BCM_Setup_Home_Page_Action(driver, logger);
		buildingsFactory = new BCM_Setup_Buildings_Page_Factory(driver, logger);
	}
	
	//Test Method --START
	public boolean verifyErrorMessageForBlankProjectDetailsField(){
		boolean testStatus = false;
		buildingsFactory.get_projectName().clear();
		buildingsFactory.get_dateFormatArrowIcon().click();
		
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));

		WebLink.SendClickToLink(driver, dateFormatList.get(0));
		getNoOfBuildingsField().clear();
		clickOnSaveButton();
		WebElementCommon.staticWait(2000);
		
		if (getProjectNameErrorMessage().trim().contains(TextConstants.Buildings_BlankProjectName) &&
			getDateFormatErrorMessage().trim().contains(TextConstants.Buildings_BlankDateFormat) &&
			getNoOfBuildingsErrorMessage().trim().contains(TextConstants.Buildings_BlankNoOfBuildings)) {
			
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyProjectDetailsCanBeAddedSuccessfully(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(2000);
		if (getSaveUpdateSuccessMessage().trim().contains(TextConstants.Buildings_ProjectInfoSaveMessage) || 
			getSaveUpdateSuccessMessage().trim().contains(TextConstants.Buildings_ProjectInfoUpdateMessage)) {
			testStatus = true;
		}
		return testStatus;
		
	}
	
	public boolean verifyProjectDetailsCanBeUpdatedSuccessfully(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(2000);
		if (getSaveUpdateSuccessMessage().trim().contains(TextConstants.Buildings_ProjectInfoUpdateMessage)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyErrorMessageForMoreThan50Buildings(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(2000);
		if (getNoOfBuildingsErrorMessage().trim().contains(TextConstants.Buildings_ExceedNoOfBuildings)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyErrorMessageForMoreThan120Floors(String projectName, String dateFormat, String numberOfBuildings, String numberOfFloors, String floorLabel){
		boolean testStatus = false;
		
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(2000);
		
		getNumberOfFloorsField().clear();
		getNumberOfFloorsField().sendKeys(numberOfFloors);
		
		
		getFloorLableTextInput().clear();
		getFloorLableTextInput().sendKeys(floorLabel);
		
		clickOnAddFloorLabelIcon();
		WebElementCommon.staticWait(3000);
		
		if (getFloorErrorMessage().trim().contains(TextConstants.Buildings_ExceedNoOfFloorsMessage)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyExistingBuildingCanBeDeleted(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);

		getNumberOfFloorsField().clear();
		getNumberOfFloorsField().sendKeys("5");
		getFloorLableTextInput().clear();
		getFloorLableTextInput().sendKeys("F");
		clickOnAddFloorLabelIcon();
		WebElementCommon.staticWait(2000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("file-manager")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);

		clickOnDeleteBuildingIcon();
		WebElementCommon.staticWait(3000);
		
		clickOnDeleteYesButton();
		WebElementCommon.staticWait(3000);
		
		if (getBuildingDeleteErrorMessage().contains(TextConstants.Buildings_DeleteBuildingSuccessMessage)) {
			testStatus = true;
		}
		return testStatus;
		
	}
	
	public boolean verifyExistingBuildingNameCanBeEdited(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		clickOnEditBuildingIcon();
		WebElementCommon.staticWait(2000);
		
		getEditBuildingNameFieldInPopUp("Building 1");
		clickOnUpdateButtonInEditBuildingNamePopUp();
		WebElementCommon.staticWait(2000);
		
		if (getBuildingNameUpdateInfoMessage().trim().contains(TextConstants.Buildings_BuildingNameLableUpdateMessage)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyNewFloorCanBeAddedSuccessfully(String projectName, String dateFormat, String numberOfBuildings, String noOfFloors, String floorLabel){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		getNumberOfFloorsField().clear();
		getNumberOfFloorsField().sendKeys(noOfFloors);
		
		getFloorLableTextInput().clear();
		getFloorLableTextInput().sendKeys(floorLabel);
		
		clickOnAddFloorLabelIcon();
		WebElementCommon.staticWait(1000);

		if (geterrorMsgFloorZone().trim().contains(TextConstants.Buildings_NewFloorAddSuccessMessage) || 
				geterrorMsgFloorZone().trim().contains(TextConstants.Buildings_NewFloorAddSuccessMessage_1)) {
			testStatus= true;
		}
		return testStatus;
	}
	
	public boolean verifyExistingFloorNameCanBeEdited(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_lblLevel_Floor_0")));
		clickOnEditFloorLabelIcon();
		WebElementCommon.staticWait(3000);
		
		getFloorLableTextInputInPopUp().clear();
		getFloorLableTextInputInPopUp().sendKeys("TF1");
		clickOnUpdateFloorLabelButton();
		WebElementCommon.staticWait(2000);
		
		if (getBuildingNameUpdateInfoMessage().trim().contains(TextConstants.Buildings_FloorNameLabelUpdateMessage)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyExistingFloorCanBeDeleted(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(2000);
		
		clickOnSectionDDArrowIcon();
		WebLink.SendClickToLink(driver, getNumberOfSectionDropDownListValues().get(4));
		
		getSectionLableTextInput().sendKeys("Section");
		clickOnSectionLabelDDArrowIcon();
		WebLink.SendClickToLink(driver, getSectionLableDdList().get(2));
		
		clickOnApplySimilarDDArrowIcon();
		WebLink.SendClickToLink(driver, getApplySimilarDDList().get(1));
		clickOnApplySimilarPlusIcon();
		WebElementCommon.staticWait(3000);
		
		WebLink.SendClickToLink(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(2000);
		
		clickOnDeleteFloorIcon();
		WebElementCommon.staticWait(3000);
		
		clickOnFloorDeleteYesButtonInPopUp();
		WebElementCommon.staticWait(3000);
		
		if (getBuildingNameUpdateInfoMessage().trim().contains(TextConstants.Buildings_FloorDeletedSuccessMessage)) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyExistingSectionNameCanBeEdited(String projectName, String dateFormat, String numberOfBuildings){
		boolean testStatus = false;
		getProjectName().clear();
		getProjectName().sendKeys(projectName);
		
		getDateFormatArrowIcon().click();
		WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
		List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
		WebLink.SendClickToLink(driver, dateFormatList.get(2));
		
		getNoOfBuildingsField().clear();
		getNoOfBuildingsField().sendKeys(numberOfBuildings);
		clickOnSaveButton();
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		WebButton.Button_Click(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		
		WebLink.SendClickToLink(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(3000);
		
		clickOnSectionDDArrowIcon();
		getNumberOfSectionDropDownListValues().get(2).click();
		
		getSectionLableTextInput().clear();
		getSectionLableTextInput().sendKeys("Section");
		
		
		clickOnSectionLabelDDArrowIcon();
		getSectionLableDdList().get(2).click();
		
		clickOnApplySimilarDDArrowIcon();
		getApplySimilarDDList().get(1).click();
		clickOnApplySimilarPlusIcon();
		
		WebLink.SendClickToLink(driver, getsectionTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_Section_lblSectionName_0")));
		clickOnEditSectionIcon();
		WebElementCommon.staticWait(2000);
		
		getSectionNameTextInputInPopUp().clear();
		getSectionNameTextInputInPopUp().sendKeys("Sec1");
		clickOnUpdateButtonSectionLableNameInPopUp();
		WebElementCommon.staticWait(2000);
		
		if (TextConstants.Buildings_SectionNameUpdateSuccessMessage.contains(geterrorMsgFloorZone().trim())) {
			
			testStatus = true;
		}
		return testStatus;
		
	}
	public boolean verifyExistingSectionCanBeDeleted(String projectName, String dateFormat, String numberOfBuildings){
			boolean testStatus = false;
			getProjectName().clear();
			getProjectName().sendKeys(projectName);
			
			getDateFormatArrowIcon().click();
			WebElement dateFormatElement =driver.findElement(By.className("rcbList"));
			List<WebElement> dateFormatList= dateFormatElement.findElements(By.tagName("li"));
			WebLink.SendClickToLink(driver, dateFormatList.get(2));
			
			getNoOfBuildingsField().clear();
			getNoOfBuildingsField().sendKeys(numberOfBuildings);
			clickOnSaveButton();
			WebElementCommon.staticWait(1000);
			
			WebLink.SendClickToLink(driver, getBuildingsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingScroll_lblBuildName_0")));
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.staticWait(1000);
			
			WebButton.Button_Click(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.staticWait(1000);
			
			WebLink.SendClickToLink(driver, getFloorsTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_BuildingSetUp_FloorLevel_imgBtnFloorLevel_0")));
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.staticWait(3000);
			
			clickOnSectionDDArrowIcon();
			getNumberOfSectionDropDownListValues().get(2).click();
			
			getSectionLableTextInput().clear();
			getSectionLableTextInput().sendKeys("Section");
			
			
			clickOnSectionLabelDDArrowIcon();
			getSectionLableDdList().get(2).click();
			
			clickOnApplySimilarDDArrowIcon();
			getApplySimilarDDList().get(1).click();
			clickOnApplySimilarPlusIcon();
			WebElementCommon.staticWait(2000);
			
			WebLink.SendClickToLink(driver, getsectionTableGrid().findElement(By.id("ContentPlaceHolder1_ContentPlaceHolder2_DL_Section_lblSectionName_0")));
			clickOnDeleteSectionIcon();
			WebElementCommon.staticWait(2000);
			
			if (geterrorMsgFloorZone().trim().contains(TextConstants.Buildings_SectionDeletedSuccessMessage)) {
				
				testStatus = true;
			}
			return testStatus;
	}
	//get_floorDeleteYesButtonInPopUp
	//Test Method --END
	
	//WebElement getters--START
	
	private static void clickOnFloorDeleteYesButtonInPopUp(){
		WebElement element = null;
		element = buildingsFactory.get_floorDeleteYesButtonInPopUp();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete Floor Yes button clicked succesfully");
		}else{
			logger.log(LogStatus.FAIL, "Delete Floor Yes button not found");
		}
	}
	
	private static void clickOnDeleteSectionIcon(){
		WebElement element = null;
		element = buildingsFactory.get_deleteSectionIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete Section Icon clicked succesfully");
		}else{
			logger.log(LogStatus.FAIL, "Delete Section Icon not found");
		}
	}
	
	private static void clickOnEditSectionIcon(){
		WebElement element = null;
		element = buildingsFactory.get_updateSectionLablePencilIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit Section Label button clicked succesfully");
		}else{
			logger.log(LogStatus.FAIL, "Edit Section Label button not found");
		}
	}
	
	private static void clickOnUpdateButtonSectionLableNameInPopUp(){
		WebElement element = null;
		element = buildingsFactory.get_updateButtonSectionNameInPopUp();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Update button clicked succesfully");
		}else{
			logger.log(LogStatus.FAIL, "Update button not found");
		}
	}
	
	private static WebElement getSectionNameTextInputInPopUp(){
		WebElement element = null;
		element = buildingsFactory.get_editSectionNameInPopUp();
		if (element != null) {
			logger.log(LogStatus.PASS, "Section Name Field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Section Name Field not found");
		}
		return element;
	}	
	
	private static void clickOnDeleteFloorIcon(){
		WebElement element = null;
		element = buildingsFactory.get_deleteFloorIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete Floor button clicked succesfully");
		}else{
			logger.log(LogStatus.FAIL, "Delete Floor button not found");
		}
	}
	
	private static WebElement getProjectName(){
		WebElement element = null;
		element = buildingsFactory.get_projectName();
		if (element != null) {
			logger.log(LogStatus.PASS, "Project Name Field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Project Name Field not found");
		}
		return element;
	}
	
	private static WebElement getNoOfBuildingsField(){
		WebElement element = null;
		element = buildingsFactory.get_numberOfBuildings();
		if (element != null) {
			logger.log(LogStatus.PASS, "NoOfBuildings Field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "NoOfBuildings Field not found");
		}
		return element;
	}
	
	private static WebElement getDateFormatArrowIcon(){
		return buildingsFactory.get_dateFormatArrowIcon();
	}
	
	private static WebElement clickOnImageBrowseButton(){
		WebElement element = null;
		element = buildingsFactory.get_browseImageButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Browse Image button found sucessfully");
		}else{
			logger.log(LogStatus.FAIL, "Browse Image button not found");
		}
		return element;
	}
	
	private static void clickOnSaveButton(){
		WebElement element = null;
		element = buildingsFactory.get_saveProjectDetailsButton();
		if (element !=null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Save button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Save button not found");
		}
	}
	
	private static String getSaveUpdateSuccessMessage(){
		String infoMsg = null;
		WebElement element = null;
		element = buildingsFactory.get_saveUpdateSuccessInfo();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			infoMsg = WebElementCommon.getElementText(driver, element, logger).trim();
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the error message");
		}
		return infoMsg;
	}
	
	
	private static String getProjectNameErrorMessage(){
		WebElement element = null;
		String errMsg = null;
		element = buildingsFactory.get_errorMsgProjectName();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			errMsg = WebElementCommon.getElementText(driver, element, logger);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the error message");
		}
		return errMsg;
	}
	
	private static String getDateFormatErrorMessage(){
		WebElement element = null;
		String errMsg = null;
		element = buildingsFactory.get_errorMsgDateFormat();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			errMsg = WebElementCommon.getElementText(driver, element, logger);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the error message");
		}
		return errMsg;
	}
	
	private static String getNoOfBuildingsErrorMessage(){
		WebElement element = null;
		String errMsg = null;
		element = buildingsFactory.get_errorMsgNoOfBuildings();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			errMsg = WebElementCommon.getElementText(driver, element, logger);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the error message");
		}
		return errMsg;
	}
	
	private static WebElement getBuildingsTableGrid(){
		WebElement element = null;
		element = buildingsFactory.get_buildingListTableGrid();
		return element;
	}
	
	private static boolean clickOnDeleteBuildingIcon(){
		boolean testStatus = false;
		WebElement element = buildingsFactory.get_deleteBuildingIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			testStatus = true;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete building icon clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Delete builing Icon");
		}
		return testStatus;
	}
	
	private static boolean clickOnEditBuildingIcon(){
		boolean testStatus = false;
		WebElement element = buildingsFactory.get_editBuildingNameIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			testStatus = true;
			logger.log(LogStatus.PASS, "Edit building icon clicked successfully");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit builing Icon");
		}
		return testStatus;
	}
	
	private static boolean getEditBuildingNameFieldInPopUp(String newBuildingName){
		boolean testStatus = false;
		WebElement element = buildingsFactory.get_editBuildingNamePopUp();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, newBuildingName);
			testStatus = true;
			logger.log(LogStatus.PASS, "Text\"" +newBuildingName +"\"" +" successfully entered in building name field");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Building name field");
		}
		return testStatus;
	}
	
	private static boolean clickOnUpdateButtonInEditBuildingNamePopUp(){
		WebElement element = null;
		boolean testStatus = false;
		element = buildingsFactory.get_editBuildingUpdateButtonInPopUp();
		if (element !=null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Update button clicked successfully");
			testStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Update button");
		}
		return testStatus;
	}
	
	private static WebElement getsectionTableGrid(){
		return buildingsFactory.get_sectionTableGrid();
	}
	
	private static WebElement getNumberOfFloorsField(){
		WebElement element = null;
		element = buildingsFactory.get_numberOfFloors();
		if (element !=null) {
			logger.log(LogStatus.PASS, "Number.of Floors field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Number.of Floors field not found");
		}
		return element;
	}
	
	private static void clickOnSectionDDArrowIcon(){
		WebElement element = buildingsFactory.get_numberOfSectionsDDArrowIcon();
		if (element !=null) {
			logger.log(LogStatus.PASS, "Successfully found the Section Lable drop down list");
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Section Lable drop down list not found");
		}
	}
	
	private static List<WebElement> getNumberOfSectionDropDownListValues(){
		WebElement element = buildingsFactory.get_numberOfSectionsDDList();
		List<WebElement> dropDownValues = element.findElements(By.tagName("li"));
		System.out.println("Section dropdown list size "+dropDownValues.size());
		
		return dropDownValues;
	}
	
	private static WebElement getFloorLableTextInput(){
		WebElement element = buildingsFactory.get_floorLableTextInput();
		if (element != null) {
			logger.log(LogStatus.PASS, "Floor label input field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Floor label input field not found");
		}
		return element;
	}
	
	private static void clickOnAddFloorLabelIcon(){
		WebElement element = null;
		
		element = buildingsFactory.get_addFloorLableIcon();
		if (element != null) {
			logger.log(LogStatus.PASS, "Add Floor icon clicked successfully");
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Add Floor icon not found");
		}
	}
	
	private static String getFloorErrorMessage(){
		String errMsg = null;
		WebElement element = buildingsFactory.get_enterFloorErrorMessage();
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger);
			System.out.println("errMsg"+ errMsg);
		}
		return errMsg;
	}
	
	private static WebElement getSectionLableTextInput(){
		WebElement element = buildingsFactory.get_sectionLableTextInput();
		if (element != null) {
			logger.log(LogStatus.PASS, "Section label input field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Section label input field not found");
		}
		return element;
	}
	
	private static void clickOnSectionLabelDDArrowIcon(){
		WebElement element = buildingsFactory.get_sectionLableDDArrowIcon();
		if (element !=null) {
			logger.log(LogStatus.PASS, "Successfully found the Section Lable drop down list");
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Section Lable drop down list not found");
		}
	}
	
	private static List<WebElement> getSectionLableDdList(){
		WebElement element = buildingsFactory.get_sectionLableDDList();
		List<WebElement> sectionLabelList = element.findElements(By.tagName("li"));
		
		return sectionLabelList;
	}
	
	private static String getSectionLableErrorMessage(){
		String errMsg = null;
		WebElement element = buildingsFactory.get_errorMsgSectionLable();
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger).trim();
		}
		return errMsg;
	}
	
	private static String getApplySimilarErrorMessage(){
		String errMsg = null;
		WebElement element = buildingsFactory.get_errorMsgApplySimilar();
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger).trim();
		}
		return errMsg;
	}
	
	private static void clickOnApplySimilarDDArrowIcon(){
		WebElement element = buildingsFactory.get_applySimilarArrowIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Apply similar drop down");
		}
	}
	
	private static List<WebElement> getApplySimilarDDList(){
		WebElement element = buildingsFactory.get_applySimilarDDList();
		List<WebElement> applySimilarDDList = element.findElements(By.tagName("li"));
		
		return applySimilarDDList;
	}
	
	private static void clickOnApplySimilarPlusIcon(){
		WebElement element = buildingsFactory.get_applySimilarPlusIcon();
		
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebElementCommon.staticWait(1000);
			logger.log(LogStatus.PASS, "Sucessfully clicked on Apply Similar + icon");
		}else{
			logger.log(LogStatus.PASS, "Failed to find Apply Similar + icon");
		}
	}
	
	private static WebElement getFloorsTableGrid(){
		return buildingsFactory.get_floorsTableGrid();
	}
	
	private static String getErrorMessageNoOfSection(){
		WebElement element = buildingsFactory.get_errorMsgNoOfSection();
		String errMsg = null;
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger);
		}
		
		return errMsg;
	}
	
	private static void clickOnDeleteYesButton(){
		WebElement element = buildingsFactory.get_deleteBuildingYesBtn();
		
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Yes button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Yes button");
		}
	}
	
	private static void clickOnDeleteNoButton(){
		WebElement element = buildingsFactory.get_deleteBuildingNoBtn();
		
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "No button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find No button");
		}
	}
	
	private static List<WebElement> getMainErrormsgDiv(){
		WebElement element = buildingsFactory.get_errorMsgAllErrGrid();
		List<WebElement> allErrorElements = element.findElements(By.tagName("id"));
		
		return allErrorElements;
	}
	
	private static String getBuildingDeleteErrorMessage(){
		String errMsg = null;
		WebElement element = buildingsFactory.get_errorMsgdeleteBuilding();
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger).trim();
		}
		return errMsg;
	}
	
	private static String getBuildingNameUpdateInfoMessage(){
		String errMsg = null;
		WebElement element = buildingsFactory.get_errorMsgFloorZone();
		if (element != null) {
			errMsg = WebElementCommon.getElementText(driver, element, logger).trim();
			System.out.println("Update building message =" + errMsg);
		}
		return errMsg;
	}
	
	private static void clickOnEditFloorLabelIcon(){
		WebElement element = null;
		element = buildingsFactory.get_editFloorLableIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit Building lable icon clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Building lable icon");
		}
	}
	
	private static WebElement getFloorLableTextInputInPopUp(){
		WebElement element = buildingsFactory.get_editFloorNameInPopUp();
		if (element != null) {
			logger.log(LogStatus.PASS, "Floor label input field found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Floor label input field not found");
		}
		return element;
	}
	
	private static void clickOnUpdateFloorLabelButton(){
		WebElement element = null;
		element = buildingsFactory.get_updateButtonFloorNameInPopUp();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Update Button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Update Button");
		}
	}
	
	private static String geterrorMsgFloorZone(){
		WebElement element = null;
		String errMsg = null;
		element = buildingsFactory.get_errorMsgFloorZone();
		if (element != null) {
			errMsg = element.getText();
			System.out.println("errMsg "+errMsg);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Section Update message found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Section Update message");
		}
		return errMsg;
	}
	
	
	//WebElement getters--END
}
