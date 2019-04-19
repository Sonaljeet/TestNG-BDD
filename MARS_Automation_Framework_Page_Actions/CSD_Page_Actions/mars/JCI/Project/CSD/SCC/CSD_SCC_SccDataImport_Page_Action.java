package mars.JCI.Project.CSD.SCC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import jxl.read.biff.BiffException;
import mars.Business.Layer.ReadJsonFile;
import mars.JCI.Project.CSD.Setup.SCC.CSD_SCC_Data_Import_Page_Factory;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetailsTab_Page_Action;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetails_DataValidation_Master;
import mars.JCI.Project.CSD.SCC.CSD_SCC_DataValidation_Master;

public class CSD_SCC_SccDataImport_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SCC_Data_Import_Page_Factory csdSCCDataImportPF = null;
	private static CSD_SCC_DataValidation_Master csdSCCDataValMaster = null;
	private static CSD_PointDetailsTab_Page_Action csdPointDetailsPA = null;
	private static CSD_PointDetails_DataValidation_Master csdPtDetDataVal = null;
	private static CSD_SCC_PointDetails_Page_Action csdSCCPtDetPA = null;
	
	public static String sccTestDataJSON = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/SCC/SCC_DataImport_TestData.json";
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	public static String[] existing_owner_device_info = new String[5];
	
	public static boolean newOrExistingFlag,modelChangedOrNot = true;
	
	@SuppressWarnings("static-access")
	public CSD_SCC_SccDataImport_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		csdSCCDataImportPF = new CSD_SCC_Data_Import_Page_Factory(driver, logger);
		csdSCCDataValMaster = new CSD_SCC_DataValidation_Master(driver,logger);
		csdPointDetailsPA = new CSD_PointDetailsTab_Page_Action(driver, logger);
		csdSCCPtDetPA = new CSD_SCC_PointDetails_Page_Action(driver, logger);
	}

	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	//Get a Random Number between a provided range for further Random Cross Testing.
	public static int getRamdomNoBetweenRange(int min,int max) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	//To Select the specified textfrom the drop Down
	public static void selectByDesiredIndex(WebElement element, int index) {
		
		try {
			System.out.println("element "+element+"index "+index);
			new Select(element).selectByIndex(index);
			System.out.println("Option No."+index+" is Selected");
			logger.log(LogStatus.INFO, "Option No."+index+" is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}
	
	//To get all the Values under a dropdown 
	public static List<String> getAllOptions(WebElement element) {
	    List<String> options = new ArrayList<String>();
	    for (WebElement option : new Select(element).getOptions()) {
	        String txt = option.getText();
	        if (option.getAttribute("value") != "") options.add(option.getText());
	    }
	    return options;
	}
	
	//Get Selected Option From DropDown
	public static String getSelectedOptionFromDropDown(WebElement element) {
		
		Select sel_element_Val = new Select(element);
		String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
		return element_Val_text;
	}

	
	//To Select the specified textfrom the drop Down
	public static void selectByVisibleText(WebElement element, String text) {
		
		try {
			System.out.println("element "+element+"text "+text);
			new Select(element).selectByVisibleText(text);
			System.out.println(text.toUpperCase()+" Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
		}
	}
	
	//====================================================================================================================
	
	
	//Navigate to SCC Data Import Selection Page
	public static void clickOnSCCDataImportTabLink(){
		
		waitForSpinnerToDisappear();
		WebElement admin_element = csdSCCDataImportPF.get_sccTab_AdministrationLink();
		if(admin_element!=null){
			admin_element.click();
			logger.log(LogStatus.PASS, "Clicked on Administraation Link.");
			waitForSpinnerToDisappear();
			WebElement scc_element = csdSCCDataImportPF.get_sccTab_SCCLink();
			if(scc_element!=null){
				scc_element.click();
				logger.log(LogStatus.PASS, "Clicked on SCC Link");
				waitForSpinnerToDisappear();
				WebElement sccDataImport_element = csdSCCDataImportPF.get_sccTab_SCCDataImportLink();
				if(sccDataImport_element!=null){
					sccDataImport_element.click();
					logger.log(LogStatus.PASS, "Clicked on SCC Data Import Link.");
				}else{
					logger.log(LogStatus.FAIL, "Failed to Click on SCC Data Import Link.");
				}
			}else{
				logger.log(LogStatus.FAIL, "Failed to Click on SCC Link.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to Click on Administration Link.");
		}
	}
	
	
	//Select Existing Data Source for Template Validation
	public static void selectDataSourceForSetup(){
		waitForSpinnerToDisappear();
		WebElement element=csdSCCDataImportPF.get_sccTab_DataSourceLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			List<String> dataSource_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Data_Source_DDL");
			System.out.println("dataSource_name : "+dataSource_name);
			selectByVisibleText(element, dataSource_name.get(0));
			logger.log(LogStatus.PASS, "Existing Data Source for Template Validation Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Data Source Link");
		}
	}
	
	
	//Select Equipment Type for Template Validation
	public static void selectEquipmentTypeForSetup(){
		WebElement element=csdSCCDataImportPF.get_sccTab_EquipmentTypeLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			List<String> eqpType_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Equipment_Type_DDL");
			selectByVisibleText(element, eqpType_name.get(0));
			logger.log(LogStatus.PASS, "Equipment Type for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Equipment Type for Template Validation Link");
		}
	}
	
	
	//Select Customer for Template Validation -- Only Existing 
	public static void selectCustomerNameForSetup(){
		WebElement element=csdSCCDataImportPF.get_sccTab_CustomerLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			List<String> custName_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Customer_Name_DDL");
			selectByVisibleText(element, custName_name.get(0));
			logger.log(LogStatus.PASS, "Customer Name for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Customer Name for Template Validation Link");
		}
	}
	
	
	//Select Facility for Template Validation -- Only Existing 
	public static void selectFacilityNameForSetup() 
			throws InterruptedException{
		WebElement element=csdSCCDataImportPF.get_sccTab_FacilityLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			List<String> facility_options = getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = getRamdomNoBetweenRange(2, random_range_lim);
					selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Facility Name for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Facility Name for Template Validation Link");
		}
	}
	
	
	//Select SCC DETAILS whether NEW/EXISTING -- Choose based on FLAG
	@SuppressWarnings("static-access")
	public static void selectSCCDeatilsNatureNewORExisting(boolean flag) 
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		newOrExistingFlag = flag;
		
		if(flag == true){
			logger.log(LogStatus.INFO, "SCC Details are getting populated for NEW Chiller");
			selectNEWChiller();
			setNewChillerNAME();
			setNewChillerOWNER();
			setNewChillerDEVICE();
			setNewChillerMODEL();
			setNewChillerREPORTINGUNIT();
			setNewChillerMACID();
			clickImportButton();
			
			
		}else if(flag == false){
			logger.log(LogStatus.INFO, "SCC Details are getting populated for EXISTING Chiller");
			
			selectEXISTINGChiller();
			setExistingChillerNAME();
			validateOwnerDeviceForSelectedChiller();
			changeAssetModelType(); // Perform the change of Model Type for the selected asset
			clickImportButton();
			csdSCCDataValMaster.saveSelectedChillerPointsFromDB(existing_owner_device_info);
			validateImportSuccessfulAtUI();
			
			
		}
	}
	
	//----------------- NEW CHiller Setup ----------------------------------------------------------------------------------------------
	
	//Select NEW Chiller RadioButton
	public static void selectNEWChiller() {
		
		waitForSpinnerToDisappear();
		WebElement newChiller_element = csdSCCDataImportPF.get_sccTab_sccNewEquipmentTypeLink();
		if(newChiller_element!=null ){
			if (newChiller_element.isSelected()) {
				logger.log(LogStatus.PASS, "NEW Radio Button option is already selected.");
			}else{
			newChiller_element.click();
			logger.log(LogStatus.PASS, "NEW Radio Button option is selected successfully");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find select NEW Chiller option.");
		}
	}
	
	//New Chiller -- Set Name for the Equipment 
	public static void setNewChillerNAME() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerName_element = csdSCCDataImportPF.get_sccTab_sccNewEquipmentNameLink();
		if(newChillerName_element!=null){
			waitForSpinnerToDisappear();
			List<String> chillerName_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Details_Chiller_New");
			selectByVisibleText(newChillerName_element, chillerName_name.get(0));
			logger.log(LogStatus.PASS, "New Chiller Name for Template Validation entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update New Name for the Chiller.");
		}
	}
	
	//New Chiller -- Set Owner Entry for the Equipment
	public static void setNewChillerOWNER() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerOwner_element = csdSCCDataImportPF.get_sccTab_EquipmentOwnerLink();
		if(newChillerOwner_element!=null){
			waitForSpinnerToDisappear();
			List<String> chillerOwner_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Chiller_Owner_New");
			selectByVisibleText(newChillerOwner_element, chillerOwner_name.get(0));
			logger.log(LogStatus.PASS, "New Chiller Owner for Template Validation entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update New Owner for the Chiller.");
		}
	}
	
	//New Chiller -- Set Device Entry for the Equipment
	public static void setNewChillerDEVICE() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerDevice_element = csdSCCDataImportPF.get_sccTab_EquipmentDeviceLink();
		if(newChillerDevice_element!=null){
			waitForSpinnerToDisappear();
			List<String> chillerDevice_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Chiller_Device_New");
			selectByVisibleText(newChillerDevice_element, chillerDevice_name.get(0));
			logger.log(LogStatus.PASS, "New Chiller Device for Template Validation entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update New Device for the Chiller.");
		}
	}
	
	//New Chiller -- Set Model Entry for the Equipment
	public static void setNewChillerMODEL() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerModel_element = csdSCCDataImportPF.get_sccTab_EquipmentModelddLink();
		if(newChillerModel_element!=null){
			List<String> chillerModel_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Chiller_Model_DDL");
			selectByVisibleText(newChillerModel_element, chillerModel_name.get(0));
			logger.log(LogStatus.PASS, "New Chiller Model Type for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update New Model for the Chiller.");
		}
	}
	
	//New Chiller -- Set Reporting Unit Entry for the Equipment
	public static void setNewChillerREPORTINGUNIT() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerRepoUnit_element = csdSCCDataImportPF.get_sccTab_EquipmentRepoUnitlLink();
		if(newChillerRepoUnit_element!=null){
			List<String> chillerRepoUnit_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_Reporting_Unit_DDL");
			selectByVisibleText(newChillerRepoUnit_element, chillerRepoUnit_name.get(0));
			logger.log(LogStatus.PASS, "New Reporting Unit Type for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update Reporting Unit for the Chiller.");
		}
	}
	
	//New Chiller -- Set MAC ID Entry for the Equipment
	public static void setNewChillerMACID() {
		
		waitForSpinnerToDisappear();
		WebElement newChillerMacID_element = csdSCCDataImportPF.get_sccTab_EquipmentMacIDLink();
		if(newChillerMacID_element!=null){
			waitForSpinnerToDisappear();
			List<String> chillerMacID_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..SCC_MacID");
			selectByVisibleText(newChillerMacID_element, chillerMacID_name.get(0));
			logger.log(LogStatus.PASS, "New Chiller Device MAC ID for Template Validation entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to update New MAC ID for the Chiller.");
		}
	}
	
	// -------------------------------
	
	

	//----------------- Existing CHiller Setup ----------------------------------------------------------------------------------------------
	
	//Select EXISTING Chiller RadioButton
	public static void selectEXISTINGChiller(){
		WebElement element=csdSCCDataImportPF.get_sccTab_sccExisitngEquipmentTypeLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "RadioButton for Existing Chiller under SCC Details for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find RadioButton for Existing Chiller under SCC Details for Template Validation Link");
		}
	}
	
	//Existing Chiller -- Select Existing Equipment 
	public static void setExistingChillerNAME() 
			throws InterruptedException{
		WebElement element=csdSCCDataImportPF.get_sccTab_sccEquipmentddSelectLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			List<String> facility_options = getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = getRamdomNoBetweenRange(2, random_range_lim);
					selectByDesiredIndex(element, random_index);
				}
			}
			logger.log(LogStatus.PASS, "Asset Name for Template Validation selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Asset Name for Template Validation Link");
		}
	}
	
	//Existing Chiller -- Get the Details From the Owner and Device TextBoxes for Validation
	public static String[] validateOwnerDeviceForSelectedChiller() 
			throws InterruptedException{
		Thread.sleep(3000);
		WebElement element_owner=csdSCCDataImportPF.get_sccTab_EquipmentOwnerLink();
		WebElement element_device=csdSCCDataImportPF.get_sccTab_EquipmentDeviceLink();
		WebElement element_macid = csdSCCDataImportPF.get_sccTab_EquipmentMacIDLink();
		WebElement element_model = csdSCCDataImportPF.get_sccTab_EquipmentDeviceModelLink();
		WebElement element_repoUnit = csdSCCDataImportPF.get_sccTab_EquipmentRepoUnitlLink();
		//Insert mac id and reporting value check .
		String owner_name,device_name,macid_value,model_value,repoUnit_value = null;
		//String[] owner_device_info = new String[3];
		waitForSpinnerToDisappear();
		if (element_owner !=null) {
			waitForSpinnerToDisappear();
			owner_name = element_owner.getAttribute("value");
			System.out.println(owner_name);
			existing_owner_device_info[0] = owner_name;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Owner Name for Template Validation selected successfully : "+owner_name);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Owner Name for Template Validation Link");
		}
		if (element_device !=null) {
			waitForSpinnerToDisappear();
			device_name = element_device.getAttribute("value");
			System.out.println(device_name);
			existing_owner_device_info[1] = device_name;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Device Name for Template Validation selected successfully : "+device_name);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Device Name for Template Validation Link");
		}
		if (element_macid !=null) {
			waitForSpinnerToDisappear();
			macid_value = element_macid.getAttribute("value");
			System.out.println(macid_value);
			existing_owner_device_info[2] = macid_value;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "MacID Value for Template Validation selected successfully : "+macid_value);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find MacID Value for Template Validation Link");
		}
		if (element_model !=null) {
			waitForSpinnerToDisappear();
			model_value = getSelectedOptionFromDropDown(element_model);
			System.out.println(model_value);
			existing_owner_device_info[3] = model_value;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Model Value for Template Validation selected successfully : "+model_value);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Model Value for Template Validation Link");
		}
		if (element_repoUnit !=null) {
			waitForSpinnerToDisappear();
			repoUnit_value = getSelectedOptionFromDropDown(element_repoUnit);
			System.out.println(repoUnit_value);
			existing_owner_device_info[4] = repoUnit_value;
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Report Unit Value for Template Validation selected successfully : "+repoUnit_value);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Model Value for Template Validation Link");
		}
			
		System.out.println("existing_owner_device_info - "+existing_owner_device_info[0]+" "+existing_owner_device_info[1]+" "+existing_owner_device_info[2]+" "+existing_owner_device_info[3]+" "+existing_owner_device_info[4]);
		return existing_owner_device_info;
	}
	
	
	//Optional Functionality to check if the point details change upon changing the Asset Model Type 
	public static void changeAssetModelType() {
		
		if (newOrExistingFlag == false) {
			
			WebElement assetModel_element = csdSCCDataImportPF.get_sccTab_EquipmentModelddLink();
			if(assetModel_element!=null){
				List<String> assetModelTypes = getAllOptions(assetModel_element);
				String selectedModelType = getSelectedOptionFromDropDown(assetModel_element);
				int assetModelTypes_size = assetModelTypes.size();
				if(assetModelTypes_size > 1){
					logger.log(LogStatus.INFO, "Changing the Model Type for the Selected Asset.");
					if (selectedModelType.equals("YCAL-With 1314 Board_ 4800 Baud_ 2 Refrigerant Circuits")) {
						List<String> eqpType_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON,
								"$..SCC_NewChillerModelType_2");
						selectByVisibleText(assetModel_element, eqpType_name.get(0));
					}else if (selectedModelType.equals("CVHE-With Standard Starter or Competetive Solid State Starter")) {
						List<String> eqpType_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON,
								"$..SCC_NewChillerModelType_1");
						selectByVisibleText(assetModel_element, eqpType_name.get(0));
					}
					//selectByDesiredIndex(assetModel_element, getRamdomNoBetweenRange(1, assetModelTypes_size));
					System.out.println("The New Selected Asset Model Type is : "+getSelectedOptionFromDropDown(assetModel_element));
					logger.log(LogStatus.PASS, "The New Selected Asset Model Type is : "+getSelectedOptionFromDropDown(assetModel_element));
					modelChangedOrNot = false;
				}else{
					logger.log(LogStatus.FAIL, "Error encountered in loading the Asset Model Type DropDown.");
				}
			}else{
				logger.log(LogStatus.FAIL, "Error Encountered in identifying the element for Asset Model Type.");
			}
		}else{
			logger.log(LogStatus.INFO, "User chose to skip the validation of changeAssetModelType.");
		}
	}
	
	
	
	// -------------------------------
	
	// SCC Details -- Import Button
	public static void clickImportButton() {
		
		waitForSpinnerToDisappear();
		WebElement importButton_element = csdSCCDataImportPF.get_sccTab_ImportTemplatePointsLink();
		if(importButton_element!=null){
			waitForSpinnerToDisappear();
			importButton_element.click();
			waitForSpinnerToDisappear();
			WebElement popUp_element = csdSCCDataImportPF.get_sccTab_PopUpButtonLink();
			popUp_element.click();
			
			logger.log(LogStatus.PASS, "Import Button clicked successfully.");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Import Button.");
		}
		
	}
	
	//Check if after Import the Point Table is populated on the UI 
	public static void validateImportSuccessfulAtUI() {
		
		waitForSpinnerToDisappear();
		List<WebElement> pointsTable_element_list = csdSCCDataImportPF.get_sccTab_outputFQRPointImportResultLink();
		if(pointsTable_element_list.size() > 0){
			System.out.println("Points are reflected in the Table");
			logger.log(LogStatus.INFO, "Points are reflected in the Table!");
		}
	}
	
	
	//Compare the Selected Chiller's Points that are imported from the Template into the UI with the Eligible points from the DB
	@SuppressWarnings("static-access")
	public static void validateTemplatePointsWithDBForSelectedEquipment() 
			throws IOException, InterruptedException, ClassNotFoundException, BiffException, SQLException{
		
		
		WebElement FQR_element = csdSCCDataImportPF.get_sccTab_inputFQRPointNameLink();
		int assetPointsSize = csdSCCDataValMaster.assetPointNames.size();
		System.out.println("assetPointsSize - "+assetPointsSize);
		logger.log(LogStatus.INFO, "Total number of Points mapped are - "+assetPointsSize);
		//WebElement FQR_element_output = sccPageFactory.get_sccTab_outputFQRPointNameLink();
		for (int i = 0; i < assetPointsSize; i++) {
			String CellGetContent = csdSCCDataValMaster.assetPointNames.get(i);
			System.out.println(CellGetContent);
			FQR_element.clear();
			FQR_element.sendKeys(CellGetContent);
			FQR_element.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			try {

				WebElement FQR_element_output = csdSCCDataImportPF.get_sccTab_outputFQRPointNameLink();
				WebElement FQR_Status_output = csdSCCDataImportPF.get_sccTab_outputFQRPointStatusLink();
				//System.out.println("FQR_element_output "+FQR_element_output);
				if(FQR_element_output != null)
				{
					if (FQR_element_output.getText().equals(CellGetContent)) {
						System.out.println("FQR_element_output.getText() : "+FQR_element_output.getText());
						System.out.println(CellGetContent+" -- is a Valid Point for the Selected Chiller!");
						logger.log(LogStatus.PASS, CellGetContent+" -- is a Valid Point for the Selected Chiller!");
						if (modelChangedOrNot == false) {
							if(FQR_Status_output.getText().equalsIgnoreCase("new")){
								System.out.println("Status change is reflecting!");
								logger.log(LogStatus.PASS, "After model Change proper Status is Getting reflected : "+FQR_Status_output.getText());
							}
						}
					}
				}
				else
				{
					System.err.println(CellGetContent+" -- is NOT a Relevant Point for the Selected Chiller!");
					logger.log(LogStatus.INFO, CellGetContent+" -- is NOT a Relevant Point for the Selected Chiller!");
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.err.println(CellGetContent+" -- is NOT a Relevant Point for the Selected Chiller! -- Inside CATCH");
				logger.log(LogStatus.FAIL, CellGetContent+" -- is NOT a Valid Point for the Selected Chiller!");
			}
		}
		logger.log(LogStatus.INFO, "Successfully Completed Validating the Points Imported.");
		//driver.switchTo().defaultContent();
		//csdSCCDataImportPF.get_sccTab_AdministrationLink().click();
	}
	
	
	
	//Check if the same points are reflected under the Manage Active Points Section of the Point Details Tab.
	@SuppressWarnings("static-access")
	public static void validatePointDetailsTabEntries() 
			throws InterruptedException, ClassNotFoundException, SQLException, IOException, BiffException {
		
		/*waitForSpinnerToDisappear();
		csdPointDetailsPA.clickOnDashboardLink();
		String chiller_model = csdPointDetailsPA.getChillerModelDetails();
		csdPointDetailsPA.clickPointDetailsTab();
		csdPointDetailsPA.clickManageActivePointsButton();
		String asset_det_id = csdPointDetailsPA.getAssetAttributeID();
		csdPtDetDataVal.GetModelIdForChillerModel(chiller_model);
		csdPtDetDataVal.GetChillerAttributeDetails();*/
		
		waitForSpinnerToDisappear();
		
		//CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
		csdPointDetailsPA.clickOnDashboardLink();
		/*csdPointDetailsPA.clickOnRightMenuButton();
		csdPointDetailsPA.enterRequiredProject();
		csdPointDetailsPA.selectRequiredProject();
		csdPointDetailsPA.selectRequiredChillerSite();
		csdPointDetailsPA.selectRequiredChillerEquipment();*/
		String chiller_model = csdPointDetailsPA.getChillerModelDetails();
		//csdPointDetailsPA.clickPointDetailsTab();
		String asset_det_id = csdPointDetailsPA.getAssetAttributeID();
		int model_id = csdPointDetailsPA.GetModelIdForChillerModel(chiller_model);
		csdPointDetailsPA.GetChillerAttributeDetails(model_id);
		csdPointDetailsPA.getAssetDetailsForSelectedChiller(asset_det_id);
		csdPointDetailsPA.GetEligibleChillerPointHeadersFromSheet();//GetEligibleChillerPointHeadersFromSheet -- GetChillerPointHeadersFromSheet
		csdPointDetailsPA.CloseDBConnection();
		
	}
	
	
	//Validate the Values from the sheet with the static variables for validating the proper import of Points
	@SuppressWarnings("static-access")
	public static void validateProperPointImport() 
			throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		
		csdSCCPtDetPA.clickOnDashboardLink();
		csdSCCPtDetPA.clickPointDetailsTab();
		csdSCCPtDetPA.performPointValidation();
		
		/*System.out.println("csdSCCDataValMaster.assetPointNames; -- "+csdSCCDataValMaster.assetPointNames);
		System.out.println("csdSCCDataValMaster.dbNameList; -- "+csdSCCDataValMaster.dbNameList);
		System.out.println("csdSCCDataValMaster.dbNameList.size - "+csdSCCDataValMaster.dbNameList.size());
		System.out.println("csdSCCDataValMaster.assetPointNames.size - "+csdSCCDataValMaster.assetPointNames.size());
		if(csdSCCDataValMaster.dbNameList.containsAll(csdSCCDataValMaster.assetPointNames)){
			System.out.println("csdSCCDataValMaster.dbNameList.size - "+csdSCCDataValMaster.dbNameList.size());
			System.out.println("csdSCCDataValMaster.assetPointNames.size - "+csdSCCDataValMaster.assetPointNames.size());
			System.out.println("All the Points are reflected on the Point Details Tab as well.");
			logger.log(LogStatus.PASS, "All the Points are reflected on the Point Details Tab as well.");
		}*/
		
		//csdPointDetailsPA.pointNamesList;
		
		System.out.println("csdSCCDataValMaster.assetPointNames; -- "+csdSCCDataValMaster.assetPointNames);
		System.out.println("csdSCCPtDetPA.pointNamesList; -- "+csdSCCPtDetPA.pointNamesList);
		System.out.println("csdSCCPtDetPA.pointNamesList.size - "+csdSCCPtDetPA.pointNamesList.size());
		System.out.println("csdSCCDataValMaster.assetPointNames.size - "+csdSCCDataValMaster.assetPointNames.size());
		if(csdSCCPtDetPA.pointNamesList.containsAll(csdSCCDataValMaster.assetPointNames)){
			System.out.println("csdSCCPtDetPA.pointNamesList.size - "+csdSCCPtDetPA.pointNamesList.size());
			System.out.println("csdSCCDataValMaster.assetPointNames.size - "+csdSCCDataValMaster.assetPointNames.size());
			System.out.println("All the Points are reflected on the Point Details Tab as well.");
			logger.log(LogStatus.PASS, "All the Points are reflected on the Point Details Tab as well.");
		}
	}
}
