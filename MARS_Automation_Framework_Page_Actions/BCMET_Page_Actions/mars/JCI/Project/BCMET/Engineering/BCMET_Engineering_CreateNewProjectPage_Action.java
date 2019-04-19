package mars.JCI.Project.BCMET.Engineering;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;

public class BCMET_Engineering_CreateNewProjectPage_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static final By IMAGELOADER = By.id("imgLoadingIcon");
	
	private static BCMET_Engineering_CreateNewProjectPage_Factory createNewProjectFactory = null;
	
	public BCMET_Engineering_CreateNewProjectPage_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		createNewProjectFactory = new BCMET_Engineering_CreateNewProjectPage_Factory(driver, logger);
	}
	//Test Methods -- START
	public boolean verifyContractInfoSaveSuccess(String saveMessage) {
		
		boolean testStatus= false;
		
		enterProjectName("Pro1");
		enterProjectNumber("1005");
		enterProjectManager("ProManager");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("Johnson controls PLC");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@jciplc.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		
		if (getPopMessageBoxInfoText().trim().contentEquals("Contract Information details saved successfully")) {
			System.out.println(getPopMessageBoxInfoText().trim());
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		return testStatus;
	}
	
	public boolean verifyMandatoryFieldsErrorMessage() {
		boolean testStatus = false;
		String mandatoryFieldErroMessageText = "Please enter project name"+"Please enter project number"
												+"Please enter project manager"+"Please select system of units"+
												"Please enter customer name";
		
		String actualMessage = "";
		clickOnSaveButton();
		
		String[] allErrorMesage = getPopMessageBoxInfoText().split("-");
		System.out.println("Size = "+allErrorMesage.length);
		
		for (int i = 1; i < allErrorMesage.length; i++) {
			actualMessage=actualMessage+allErrorMesage[i].trim();
		}
		
		System.out.println("actualMessage="+actualMessage);
		System.out.println("mandatoryFieldErroMessageText="+mandatoryFieldErroMessageText);
		
		if (actualMessage.contains(mandatoryFieldErroMessageText)) {

			testStatus= true;
		}
		System.out.println("testStatus ="+testStatus);
		return testStatus;
	}

	public boolean verifyNewBuildingAddSuccess() {
		boolean testStatus = false;
		enterProjectName("New Building");
		enterProjectNumber("1003");
		enterProjectManager("NewMgr");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		if (driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_lblNode")).getText().equalsIgnoreCase("Building 1")) {
			clickOnFacilitySaveButton();
			System.out.println(driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_lblNode")).getText());
			if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
				testStatus = true;
				clickOnCOnfirmationPopBoxOkButton();
			}
		}
		return testStatus;
	}
	
	public boolean verifyExistingBuildingNameChange(String newBuildingName) throws InterruptedException {
		boolean testStatus = false;
		
		enterProjectName("Existing Building Rename");
		enterProjectNumber("8293283");
		enterProjectManager("NewMgr");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName(newBuildingName);
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickOnEditIcon();
		Thread.sleep(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		
		WebElement editBuildingTemp = driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_txtEditText"));
		WebElementCommon.waitForElementPresent(driver, editBuildingTemp, logger);
		editBuildingTemp = driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_txtEditText"));
		
		Thread.sleep(2000);
		
		for(int i=0; i<newBuildingName.length(); i++) {
			editBuildingTemp.sendKeys(Keys.DELETE);
		}
		editBuildingTemp.sendKeys(newBuildingName);
		//editBuildingTemp.click();
		//Thread.sleep(3000);
		clickOnFacilitySaveButton();
		clickOnFacilitySaveButton();
		
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		
		return testStatus;
	}
	
	public boolean verifyErrorMsgForMoreThan50Building() {
		boolean testStatus = false;
		
		enterProjectName("50 Building");
		enterProjectNumber("10010");
		enterProjectManager("50Mgr");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@cust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("61");
		clickOnAddBuildingsButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Valid range of Building count is 1 to 50")) {
			logger.log(LogStatus.PASS, "Error message \""+getPopMessageBoxInfoText().trim()+"\" found successfully");
			clickOnCOnfirmationPopBoxOkButton();
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyDeleteExistingBuilding() {
		boolean testStatus = false;
		enterProjectName("Delete Building");
		enterProjectNumber("1009");
		enterProjectManager("DeleteMgr");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		if (driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_lblNode")).getText().equalsIgnoreCase("Building 1")) {
			clickOnFacilitySaveButton();
			clickOnCOnfirmationPopBoxOkButton();
			clickOnBuildingByName("Building 1");
			clickOnDeleteIcon();
			clickOnPopUpBoxDeleteYesButton();
			clickOnFacilitySaveButton();
			if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
				clickOnCOnfirmationPopBoxOkButton();
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyNewLevelAddToBuilding(String levelName) {
		boolean testStatus = false;
		enterProjectName("New Level");
		enterProjectNumber("10011");
		enterProjectManager("NewMgrLvl");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnFacilitySaveButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		return testStatus;
	}
	
	public boolean verifyErrMsgForMoreThan120Levels(int noOfLevels) {
		boolean testStatus = false;
		enterProjectName("120 Level");
		enterProjectNumber("10012");
		enterProjectManager("NewLvl");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("121");
		clickOnAddLevelsButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Valid range of Level count per Building is 1 to 120")) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyExistingLevelNameChange(String newLevelName) {
		boolean testStatus = false;
		
		enterProjectName("Existing level Rename");
		enterProjectNumber("10014");
		enterProjectManager("NewLvl");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("new Customer");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		
		//Click on Edit icon for level
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_imgEditNode")).click();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		
		WebElement editlevelTemp = driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_txtEditText"));
		WebElementCommon.waitForElementPresent(driver, editlevelTemp, logger);
		editlevelTemp = driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_txtEditText"));
		WebElementCommon.staticWait(3000);
		for(int i=0; i<"Level 5".length(); i++) {
			editlevelTemp.sendKeys(Keys.DELETE);
		}
		editlevelTemp.sendKeys("New Level");
		clickOnFacilitySaveButton();
		clickOnFacilitySaveButton();
		
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		
		return testStatus;
	}
	
	public boolean verifyErrMsgForExistingLevelDelete() {
		boolean testStatus = false;
		enterProjectName("Level Delete");
		enterProjectNumber("10015");
		enterProjectManager("ExistingLvl");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("new Customer");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		//click on level name
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_lblNode")).click();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		//Click On Level delete Node
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_imgDeleteNode")).click();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(2000);
		clickOnPopUpBoxDeleteYesButton();
		clickOnFacilitySaveButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		return testStatus;
	}
	
	public boolean verifyMoreThan120LevelsAdd() {
		boolean testStatus= false;
		
		enterProjectName("Max Level");
		enterProjectNumber("10015");
		enterProjectManager("ExistingLvl");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("new Customer");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		
		//click on first level name
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_lblNode")).click();
		
		enterNoOfZones("121");
		clickOnAddLevelsButton();
		
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		
		return testStatus;
	}
	
	public boolean verifyNewZoneAddToLevel(String zoneName) {
		boolean testStatus = false;
		enterProjectName("New Zone");
		enterProjectNumber("100121");
		enterProjectManager("NewMgrZone");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("1");
		enterZoneLabelInputBox("Zone");
		clickOnZoneAddButton();
		clickOnFacilitySaveButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		return testStatus;
	}
	
	public boolean verifyExistingZoneNameChange(String newZoneNae) {
		boolean testStatus = false;
		enterProjectName("ZoneChange");
		enterProjectNumber("100130");
		enterProjectManager("NewMgrZone");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("1");
		enterZoneLabelInputBox("Zone");
		clickOnZoneAddButton();
		
		//click on first zone name
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_lblNode")).click();
		//Click Zone Edit icon
		WebElementCommon.staticWait(3000);
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_imgEditNode")).click();
		WebElementCommon.staticWait(3000);
		
		//Find editable zone text box
		WebElement tempLevelElement =driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_txtEditText"));
		WebElementCommon.staticWait(3000);
		//tempLevelElement =driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_txtEditText"));
		for (int i = 0; i < "Zone A".length(); i++) {
			tempLevelElement.sendKeys(Keys.DELETE);
		}
		tempLevelElement.sendKeys("Rename Zone");
		clickOnFacilitySaveButton();
		clickOnFacilitySaveButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus = true;
			clickOnCOnfirmationPopBoxOkButton();
		}
		return testStatus;
	}
	
	public boolean verifyExistingZoneDelete() {
		boolean testStatus = false;
		enterProjectName("Zone Delete");
		enterProjectNumber("100122");
		enterProjectManager("NewMgrZone");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("1");
		enterZoneLabelInputBox("Zone");
		clickOnZoneAddButton();
		
		//click on first zone name
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_lblNode")).click();
		//Click Zone Delete icon
		WebElementCommon.staticWait(1000);
		driver.findElement(By.id("ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_imgDeleteNode")).click();
		WebElementCommon.staticWait(3000);
		clickOnPopUpBoxDeleteYesButton();
		clickOnFacilitySaveButton();
		if (getPopMessageBoxInfoText().trim().contentEquals("Facility details saved successfully")) {
			testStatus= true;
			clickOnCOnfirmationPopBoxOkButton();
		}

		return testStatus;
	}
	
	public boolean verifyErrMsgForMoreThan16Zones(int noOfZones) {
		boolean testStatus = false;
		//Valid range of zone count per Level is 1 to 16
		enterProjectName("Max Zone");
		enterProjectNumber("100132");
		enterProjectManager("NewMgrZone");
		enterStartDate("10/10/2016");
		enterBranch("Yerwada");
		selectProjectProfile("Please Select");
		//enterEngRevision("Revision 1");
		selectSystemOfUnits("Metric");
		enterSalesPersonName("Sales person 1");
		enterSalesPersonEmail("salesPerson1@xyz.com");
		enterSalesPersonContactNumber("892329389");
		
		enterConsultantPersonName("Consultant Person 1");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultantEmail@abc.com");
		enterConsultantContact("83293923");
		
		enterCustomerName("New Build Cust");
		enterCustomerContactPersonName("Customer Contact person");
		enterCustomerEmail("customer@newcust.com");
		enterCustomerContactNumber("89239239");
		enterCustomerSiteAddress("Street 3, berkely Road, portland, USA-81281");
		
		enterEstimatorEngInfo("Estimator 1");
		
		clickOnSaveButton();
		//testStatus = true;
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("19");
		enterZoneLabelInputBox("Zone");
		clickOnZoneAddButton();
		WebElementCommon.staticWait(2000);

		if (getPopMessageBoxInfoText().trim().contentEquals("Valid range of zone count per Level is 1 to 16")) {
			testStatus = true;
		}
		
		return testStatus;
	}
	
	
	public boolean saveContractAndFacilityDetail() {
		boolean testStatus = false;
		
		enterProjectName("SaveContractInfo");
		enterProjectNumber("1001");
		enterProjectManager("BCM");
		enterStartDate("17/02/2017");
		enterBranch("Branch");
		selectProjectProfile("Please Select");
		//enterEngRevision("JCI");
		selectSystemOfUnits("Metric");
		
		//Sales Person info
		enterSalesPersonName("Sales P1");
		enterSalesPersonEmail("salesPerson@xyz.com");
		enterSalesPersonContactNumber("298402342");
		
		//Consultant Firm Info
		enterConsultantPersonName("Consultant Name");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultant@xyz.com");
		enterConsultantContact("928374293");
		
		//Customer Info
		enterCustomerName("Customer");
		enterCustomerContactPersonName("Customer contact person");
		enterCustomerEmail("Customer@email.com");
		enterCustomerContactNumber("892749243");
		enterCustomerSiteAddress("JCI, Avenue road");
		
		enterEstimatorEngInfo("Estimator");
		clickOnSaveButton();
		clickOnCOnfirmationPopBoxOkButton();
		
		//Facility Details
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("2");
		enterZoneLabelInputBox("Zone");
		selectApplySimilar("Selected Level");
		clickOnZoneAddButton();
		clickOnFacilitySaveButton();
		clickOnCOnfirmationPopBoxOkButton();

		return testStatus=true;
		
	}
	
	public boolean enterContractInfoDetails() {
		boolean testStatus = false;
		
		enterProjectName("EnterContractInfo");
		enterProjectNumber("1002");
		enterProjectManager("BCM");
		enterStartDate("17/02/2017");
		enterBranch("Branch");
		selectProjectProfile("Please Select");
		//enterEngRevision("JCI");
		selectSystemOfUnits("Metric");
		
		//Sales Person info
		enterSalesPersonName("Sales P1");
		enterSalesPersonEmail("salesPerson@xyz.com");
		enterSalesPersonContactNumber("298402342");
		
		//Consultant Firm Info
		enterConsultantPersonName("Consultant Name");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultant@xyz.com");
		enterConsultantContact("928374293");
		
		//Customer Info
		enterCustomerName("Customer");
		enterCustomerContactPersonName("Customer contact person");
		enterCustomerEmail("Customer@email.com");
		enterCustomerContactNumber("892749243");
		enterCustomerSiteAddress("JCI, Avenue road");
		
		enterEstimatorEngInfo("Estimator");
		clickOnSaveButton();
		clickOnCOnfirmationPopBoxOkButton();
		

		return testStatus;
		
	}
	
	public boolean facilityDetailsCheck() {
		boolean testStatus = false;
		
		enterContractInfoDetails();
		clickOnFacilityDetailsTab();
		enterNoOfBuildings("1");
		clickOnAddBuildingsButton();
		clickOnBuildingByName("Building 1");
		enterNoOfLevels("1");
		clickOnAddLevelsButton();
		clickOnLevelByNameInABuilding("Building 1", "Level 1");
		enterNoOfZones("2");
		enterZoneLabelInputBox("Zone");
		selectApplySimilar("Selected Level");
		clickOnZoneAddButton();
		clickOnFacilitySaveButton();
		clickOnCOnfirmationPopBoxOkButton();
		return testStatus;
	}
	
	
	//This is a supportive method to randomly create testData to save in contract info
	public String createDummyTestDataForProject(){
		boolean testStatus = false;
		String projectName = enterProjectName("P"+WebElementCommon.getDateAndTimeAsString());
		enterProjectNumber(WebElementCommon.getDateAndTimeAsString());
		enterProjectManager("BCM");
		enterStartDate("17/02/2017");
		enterBranch("Branch");
		selectProjectProfile("Please Select");
		//enterEngRevision("JCI");
		selectSystemOfUnits("Metric");
		
		//Sales Person info
		enterSalesPersonName("Sales P1");
		enterSalesPersonEmail("salesPerson@xyz.com");
		enterSalesPersonContactNumber("298402342");
		
		//Consultant Firm Info
		enterConsultantPersonName("Consultant Name");
		enterConsultantContactPerson("Consultant Contact Person");
		enterConsultantEmail("consultant@xyz.com");
		enterConsultantContact("928374293");
		
		//Customer Info
		enterCustomerName("Customer");
		enterCustomerContactPersonName("Customer contact person");
		enterCustomerEmail("Customer@email.com");
		enterCustomerContactNumber("892749243");
		enterCustomerSiteAddress("JCI, Avenue road");
		
		enterEstimatorEngInfo("Estimator");
		clickOnSaveButton();
		
		if (getPopMessageBoxInfoText().equalsIgnoreCase("Contract Information details saved successfully")) {
			clickOnCOnfirmationPopBoxOkButton();
			
			clickOnFacilityDetailsTab();
			
			enterNoOfBuildings("1");
			clickOnAddBuildingsButton();
			clickOnBuildingByName("Building 1");
			enterNoOfLevels("1");
			clickOnAddLevelsButton();
			clickOnLevelByNameInABuilding("Building 1", "Level 1");
			enterNoOfZones("1");
			enterZoneLabelInputBox("Zone");
			clickOnZoneAddButton();
			
			clickOnFacilitySaveButton();
			if (getPopMessageBoxInfoText().equalsIgnoreCase("Facility details saved successfully")) {
				clickOnCOnfirmationPopBoxOkButton();
				testStatus = true;
			}
		}
		final String status = testStatus + ":"+ projectName;
		return status;
	}
	
	
	public String clickOnBuildingByName(String buildingName){
		
		//Had to hard code the first building id due to the way BCMET UI is developed for creating
		//the Facility tree
		//There is no nesting in the table and its almost impossible to locate level and zone for a 
		//building.
		String buildingId = "ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_lblNode";
		WebElement facilityTableGrid= getFacilityBuildingsDataGrid();
		WebElement building1=facilityTableGrid.findElement(By.id(buildingId));
		if (building1.getText().trim().contentEquals(buildingName)) {
			building1.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Building \""+buildingName +"\" selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "\""+buildingName+ "\" not found in Facility list");
		}
		return buildingId;
	}
	
	public String clickOnLevelByNameInABuilding(String buildingName, String levelNameToSearch){
		String levelId = "ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_lblNode";
		//clickOnBuildingByName(buildingName);
		WebElement level = driver.findElement(By.id(levelId));
		
		if (level.getText().trim().contentEquals(levelNameToSearch.trim())){
			level.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Level \""+levelNameToSearch +"\" selected successfully");
		}else {
			logger.log(LogStatus.FAIL, "\""+levelNameToSearch +"\""+" not found in the building\""+buildingName+ "\" in Facility list");
		}
		return levelId;			
	}
	
	public boolean clickOnZoneByNameInALevel(String buildingName, String zoneName){
		boolean ZoneFound = false;
		String zoneID = "ctl00_bodyPlaceholder_UCFacilityDetails_rtvFacility_i0_i0_i0_i0_lblNode";
		WebElement ZoneWebElement = driver.findElement(By.id(zoneID));
		if (ZoneWebElement.getText().trim().contentEquals(zoneName.trim())) {
			ZoneWebElement.click();
			ZoneFound= true;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Zone \""+zoneName +"\" selected successfully");
		}else {
				logger.log(LogStatus.FAIL, "\""+zoneName +"\""+" not found in the building\""+buildingName+ "\" in Facility list");
			}
		return ZoneFound;			
	}
	
	public void clickOnEquipmentInfoLink() {
		WebElement element = createNewProjectFactory.get_CP_EquipmentInfoLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Equipment Information Link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Equipment Information link");
		}
	}
		
	public void clickOnPanelInfoLink() {
		WebElement element = createNewProjectFactory.get_CP_PanelInfoLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Panel info link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Panel info link");
		}
	}
	
	public void clickOnNetworkInfoLink() {
		WebElement element = createNewProjectFactory.get_CP_NetworkInfoLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Network Info Link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Network Info link");
		}
	}

	
	public void clickOnRoomScheduleLink() {
		WebElement element = createNewProjectFactory.get_CP_RoomScheduleLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Room Schedule Link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Room Schedule Link ");
		}
	}
	
	public void clickOnControlProcessLink() {
		WebElement element = createNewProjectFactory.get_CP_ControlProcessLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Control Process Link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Control Process Link");
		}
	}
	
	public void clickOnBackToProjectListLink() {
		WebElement element = createNewProjectFactory.get_CP_BackToProjectListLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "BackTo Project List Link clicked success");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find BackTo Project List Link");
		}
	}
	
	public void clickOnInfoCompleteCheckbox() {
		WebElement element = createNewProjectFactory.get_CP_InfoCompleteCheckbox();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.INFO, "Info Complete Checkbox Checked successfully");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.INFO, "Unable to find Info Complete Checkbox");
		}
	}
	
	public String getPopMessageBoxInfoText() {
		WebElement element = createNewProjectFactory.get_CP_PopMessageBoxInfo();
		String errorMsgTxt = null;
		if (element != null) {
			errorMsgTxt = element.getText();
			System.out.println("errorMsgText : "+errorMsgTxt);
		}
		return errorMsgTxt.trim();
	}
	//
	public void clickOnPopBoxOkButton() {
		WebElement element = createNewProjectFactory.get_CP_PopBoxOkButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Popup Ok button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Popup Ok button not found");
		}
	}
	
	public void clickOnCOnfirmationPopBoxOkButton() {
		WebElement element = createNewProjectFactory.get_PopupBoxOkButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Popup Ok button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Popup Ok button not found");
		}
	}
	
	public String enterProjectName(String projectName) {
		WebElement element = createNewProjectFactory.get_ProjectName();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, projectName);
			logger.log(LogStatus.PASS, "\""+projectName+"\" entered sucessfully in Project Name field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Project Name field");
		}
		return projectName;
	}
	
	public void enterProjectNumber(String projectNumber) {
		WebElement element = createNewProjectFactory.get_ProjectNumber();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, projectNumber);
			logger.log(LogStatus.PASS, "\""+projectNumber+"\" entered sucessfully in Project Number field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Project Number field");
		}
	}
	
	public void enterProjectManager(String projectManager) {
		WebElement element = createNewProjectFactory.get_CP_ProjectManager();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, projectManager);
			logger.log(LogStatus.PASS, "\""+projectManager+"\" entered sucessfully in Project Manager field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Project Manager field");
		}
	}
	
	public void enterBranch(String branchName) {
		WebElement element = createNewProjectFactory.get_CP_Info_Branch();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, branchName);
			logger.log(LogStatus.PASS, "\""+branchName+"\" entered sucessfully in Branch field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Branch field");
		}
	}
	//TODO Use selector to select the value from drop down list
	public void selectProjectProfile(String profileName) {
		WebElement element = createNewProjectFactory.get_ProjectProfileDDArrow();
		if (element !=null) {
			
			WebButton.Button_Click(driver, element);
			WebElement element1 = createNewProjectFactory.get_CP_ProjectProfile();
			List<WebElement> dropDownValues = element1.findElements(By.tagName("li"));
			
			for(WebElement ddValue : dropDownValues) {
				String visibleValue = ddValue.getText();
				System.out.println("visibleValue : "+visibleValue);
				if (profileName.trim().toLowerCase().contentEquals(visibleValue.trim().toLowerCase())) {
					System.out.println("Text Found");
					ddValue.click();
					logger.log(LogStatus.PASS, "\""+profileName+"\" selected sucessfully in Profile dropdown");
					WebElementCommon.staticWait(2000);
					break;
				}
			}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Project Profile field");
		}
	}
	
	
	/**
	 * Enter start date MM/DD/YYYY.
	 *
	 * @param startDate the start date
	 */
	public void enterStartDate(String startDate) {
		WebElement element = createNewProjectFactory.get_CP_StartDate();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, startDate);
			logger.log(LogStatus.PASS, "\""+startDate+"\" entered sucessfully in Start Date field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Start Date field");
		}
	}
	
	public void enterEngRevision(String enggRevision) {
		WebElement element = createNewProjectFactory.get_EnggRevision();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, enggRevision);
			logger.log(LogStatus.PASS, "\""+enggRevision+"\" entered sucessfully in Engg. Revision field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Eng Revision field");
		}
	}
	//TODO Use selector to select the value from drop down list
	public void selectSystemOfUnits(String systemOfUnits) {
		WebElement element = createNewProjectFactory.get_SystemOfUnitsDropDownArrow();
		if (element !=null) {
			WebButton.Button_Click(driver, element);
			WebElement ddTableGrid = createNewProjectFactory.get_SystemUnitsTableGrid();
			List<WebElement> dropDownValues = ddTableGrid.findElements(By.tagName("li"));
			for(WebElement ddValue : dropDownValues) {
				String visibleText = ddValue.getText();
				System.out.println("System of units values : "+visibleText);
				if (systemOfUnits.trim().toLowerCase().contentEquals(visibleText.trim().toLowerCase())) {
					ddValue.click();
					logger.log(LogStatus.PASS, "\""+systemOfUnits+"\" selected sucessfully in System Of Units field");
					break;
				}
			}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else {
			logger.log(LogStatus.FAIL, "Failed to find System Of Units field");
		}
	}
	//Sales person getters
	public void enterSalesPersonName(String salesPersonName) {
		WebElement element = createNewProjectFactory.get_SalesPersonName();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, salesPersonName);
			logger.log(LogStatus.PASS, "\""+salesPersonName+"\" entered sucessfully in Sales Person Name field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Sales Person Name field");
		}
	}
	
	public void enterSalesPersonEmail(String salesPersonEmail) {
		WebElement element = createNewProjectFactory.get_SalesPersonEmail();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, salesPersonEmail);
			logger.log(LogStatus.PASS, "\""+salesPersonEmail+"\" entered sucessfully in Sales Person Email field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Sales Person Email field");
		}
	}
	
	public void enterSalesPersonContactNumber(String salesPersonContactNumber) {
		WebElement element = createNewProjectFactory.get_SalesPersonContactNumber();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, salesPersonContactNumber);
			logger.log(LogStatus.PASS, "\""+salesPersonContactNumber+"\" entered sucessfully in Sales Person Contact Number field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Sales Person Contact Number field");
		}
	}
	
	//Consultant Firm
	public void enterConsultantPersonName(String ConsultantPersonName) {
		WebElement element = createNewProjectFactory.get_ConsultantName();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, ConsultantPersonName);
			logger.log(LogStatus.PASS, "\""+ConsultantPersonName+"\" entered sucessfully in Consultant Name field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Consultant Name field");
		}
	}
	
	public void enterConsultantContactPerson(String ConsultantContactPerson) {
		WebElement element = createNewProjectFactory.get_ConsultantContactPerson();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, ConsultantContactPerson);
			logger.log(LogStatus.PASS, "\""+ConsultantContactPerson+"\" entered sucessfully in Consultant Contact Person field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Consultant Contact Person field");
		}
	}
	
	public void enterConsultantEmail(String ConsultantPersonEmail) {
		WebElement element = createNewProjectFactory.get_ConsultanEmail();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, ConsultantPersonEmail);
			logger.log(LogStatus.PASS, "\""+ConsultantPersonEmail+"\" entered sucessfully in Consultant Email field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Consultant Email field");
		}
	}
	
	public void enterConsultantContact(String ConsultantPersonContact) {
		WebElement element = createNewProjectFactory.get_ConsultantNumber();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, ConsultantPersonContact);
			logger.log(LogStatus.PASS, "\""+ConsultantPersonContact+"\" entered sucessfully in Consultant Contact field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Consultant Contact field");
		}
	}
	//Customer Information
	public void enterCustomerName(String CustomerName) {
		WebElement element = createNewProjectFactory.get_CustomerName();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerName);
			logger.log(LogStatus.PASS, "\""+CustomerName+"\" entered sucessfully in Customer Name field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Name field");
		}
	}
	
	public void enterCustomerContactPersonName(String CustomerContactPersonName) {
		WebElement element = createNewProjectFactory.get_CustomerContactPerson();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerContactPersonName);
			logger.log(LogStatus.PASS, "\""+CustomerContactPersonName+"\" entered sucessfully in Customer contact field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer contact person field");
		}
	}
	
	public void enterCustomerEmail(String CustomerEmail) {
		WebElement element = createNewProjectFactory.get_CustomerEmail();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerEmail);
			logger.log(LogStatus.PASS, "\""+CustomerEmail+"\" entered sucessfully in Customer Email field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Email field");
		}
	}
	
	public void enterCustomerContactNumber(String CustomerContactNumber) {
		WebElement element = createNewProjectFactory.get_CustomerContactNumber();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerContactNumber);
			logger.log(LogStatus.PASS, "\""+CustomerContactNumber+"\" entered sucessfully in Customer Contact Number field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Contact Number field");
		}
	}
	
	public void enterCustomerSiteAddress(String CustomerSiteAddress) {
		WebElement element = createNewProjectFactory.get_CustomerSiteAddress();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, CustomerSiteAddress);
			logger.log(LogStatus.PASS, "\""+CustomerSiteAddress+"\" entered sucessfully in Customer Site Address field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Site Address field");
		}
	}
	
	//Estimator Engineer Information
	public void enterEstimatorEngInfo(String EstimatorEngInfo) {
		WebElement element = createNewProjectFactory.get_EstimatorName();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, EstimatorEngInfo);
			logger.log(LogStatus.PASS, "\""+EstimatorEngInfo+"\" entered sucessfully in Estimator Name field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Estimator Name field");
		}
	}
	
	public void clickOnSaveButton() {
		WebElement element = createNewProjectFactory.get_SaveContractInfoButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Save button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the save button");
		}
	}
	
	//Facility details field
	public void clickOnFacilityDetailsTab() {
		WebElement element = createNewProjectFactory.get_FacilityDetailsSelectorLink();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Facility Details Tab clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the save button");
		}
	}	
	public void enterNoOfBuildings(String noOfBuildings) {
		WebElement element = createNewProjectFactory.get_FacilityNoOfBuildings();
		if (element !=null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, noOfBuildings);
			logger.log(LogStatus.PASS, "\""+noOfBuildings+"\" entered sucessfully in No Of Buildings field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find No Of Buildings field");
		}
	}
	
	public void clickOnAddBuildingsButton() {
		WebElement element = createNewProjectFactory.get_FacilityBUildingsAddButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add(building) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Building Add button");
		}
	}
	
	public void enterNoOfLevels(String noOfLevels) {
		WebElement element = createNewProjectFactory.get_FacilityNoLevels();
		if (element != null && element.isEnabled()) {
			WebInputTextBox.SendInputTextBox(driver, element, noOfLevels);
			logger.log(LogStatus.PASS, "\""+noOfLevels+"\" entered sucessfully in No Of Levels field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the No Of Levels field or it is not enabled");
		}
	}
	//TODO Implement the drop down value selection
	public void selectInsertLevel(String levelToSelect) {
		
	}
	
	public void clickOnAddLevelsButton() {
		WebElement element = createNewProjectFactory.get_FacilityInsertLevelAddButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add(level) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Level Add button");
		}
	}
	
	public void enterNoOfZones(String noOfZones) {
		WebElement element = createNewProjectFactory.get_FacilityNoOfZones();
		if (element != null && element.isEnabled()) {
			WebInputTextBox.SendInputTextBox(driver, element, noOfZones);
			logger.log(LogStatus.PASS, "\""+noOfZones+"\" entered sucessfully in No Of Zones field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the No Of Zones field or it is not enabled");
		}
	}
	
	public void enterZoneLabelInputBox(String zoneLabel) {
		WebElement element = createNewProjectFactory.get_FacilityZoneName();
		if (element != null && element.isEnabled()) {
			WebInputTextBox.SendInputTextBox(driver, element, zoneLabel);
			logger.log(LogStatus.PASS, "\""+zoneLabel+"\" entered sucessfully in No Of Zones field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the No Of Zones field or it is not enabled");
		}
	}
	
	//TODO Zone label dropdown list
	public void selectZoneLabel(String zoneLabel) {
		String dropDownGridID = "ctl00_bodyPlaceholder_UCFacilityDetails_rcb_ZoneType_DropDown";
		WebElement tableGrid = driver.findElement(By.id(dropDownGridID));
		List<WebElement> dropDownValues = tableGrid.findElements(By.tagName("li"));
		
		for(WebElement value : dropDownValues) {
			String stringValue = value.getText();
			if (stringValue.trim().toLowerCase().contentEquals(zoneLabel.trim().toLowerCase())) {
				logger.log(LogStatus.PASS, "\""+zoneLabel+"\""+ " selected from Zone Label drop down");
				break;
			}
		}
		
	}
	
	//TODO Zone label dropdown list
	public void selectApplySimilar(String applySimilarValue) {
		String dropDownGridID = "rcbApplySimiler_DropDown";
		WebElement tableGrid = driver.findElement(By.id(dropDownGridID));
		List<WebElement> dropDownValues = tableGrid.findElements(By.tagName("li"));
		
		for(WebElement value : dropDownValues) {
			String stringValue = value.getText();
			if (stringValue.trim().toLowerCase().contentEquals(applySimilarValue.trim().toLowerCase())) {
				logger.log(LogStatus.PASS, "\""+applySimilarValue+"\""+ " selected from Apply Similar drop down");
				break;
			}
		}
	}
	
	public void clickOnZoneAddButton() {
		WebElement element = createNewProjectFactory.get_FacilityZoneAddButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add(Zone) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Zone Add button");
		}
	}
	
	
	public void clickOnFacilitySaveButton() {
		WebElement element = createNewProjectFactory.get_FacilitySaveButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Save(Facility) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Facility Save button");
		}
	}
	
	public WebElement getFacilityBuildingsDataGrid() {
		return createNewProjectFactory.get_BuildingsListTableGrid();
	}
	
///////////////adajosiaoshooasdjaslkda asjidaoisjdoasdasda
	
	//asdasidoaisdhaoihdoasas
	
	public void clickOnEditIcon() {
		WebElement element =createNewProjectFactory.get_FacilityBuildingEditIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit(Icon) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Edit icon");
		}
	}
	
	public void clickOnDeleteIcon() {
		WebElement element =createNewProjectFactory.get_FacilityBUildingDeleteIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete(Icon) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Delete icon");
		}
	}
	
	//get_PopupBoxDeleteYesButton
	public void clickOnPopUpBoxDeleteYesButton() {
		WebElement element =createNewProjectFactory.get_PopupBoxDeleteYesButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete(Yes) button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Delete(Yes) icon");
		}
	}


	//Contract Information -- END
	
	//Field Devices -- START
	
	//Field Devices -- END
	
	
	//Getters for Test Methods -- END
}




























