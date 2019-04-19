package mars.JCI.Project.CSD.SCC;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.JCI.Project.CSD.Setup.SCC.CSD_SCC_RAP_Test_Alarm_Page_Factory;

public class CSD_SCC_RAP_Test_Alarm_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SCC_RAP_Test_Alarm_Page_Factory scc_rapTestAlarm_pf = null;
	private static CSD_SCC_SccDataImport_Page_Action scc_sccDataImp_pf = null;
	private static CSD_SCC_DataValidation_Master scc_DataValMaster = null;
	public static String sccTestDataJSON = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/SCC/SCC_DataImport_TestData.json";
	
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	@SuppressWarnings("static-access")
	public CSD_SCC_RAP_Test_Alarm_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		scc_rapTestAlarm_pf = new CSD_SCC_RAP_Test_Alarm_Page_Factory(driver, logger);
		scc_sccDataImp_pf = new CSD_SCC_SccDataImport_Page_Action(driver, logger);
		scc_DataValMaster = new CSD_SCC_DataValidation_Master(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	
	

	//====================================================================================================================
	
	
	
	//Navigate to RAP Test Alarm Selection Page
	public static void clickOnRAPTestAlarmTabLink() {
		
		waitForSpinnerToDisappear();
		WebElement admin_element = scc_rapTestAlarm_pf.get_rapTA_AdministrationLink();
		if(admin_element!=null){
			admin_element.click();
			logger.log(LogStatus.PASS, "Clicked on Administraation Link.");
			waitForSpinnerToDisappear();
			WebElement scc_element = scc_rapTestAlarm_pf.get_rapTA_SCCLink();
			if(scc_element!=null){
				scc_element.click();
				logger.log(LogStatus.PASS, "Clicked on SCC Link");
				waitForSpinnerToDisappear();
				WebElement sccrta_element = scc_rapTestAlarm_pf.get_rapTA_RAPTestAlarmLink();
				if(sccrta_element!=null){
					sccrta_element.click();
					logger.log(LogStatus.PASS, "Clicked on RAP Test Alarm Link.");
				}else{
					logger.log(LogStatus.FAIL, "Failed to Click on RAP Test Alarm Link.");
				}
			}else{
				logger.log(LogStatus.FAIL, "Failed to Click on SCC Link.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to Click on Administration Link.");
		}
		
	}
	
	//Select The desired customer from the DropDown
	@SuppressWarnings("static-access")
	public static void selectDesiredCustomerFromDropDown() {
		
		waitForSpinnerToDisappear();
		WebElement element=scc_rapTestAlarm_pf.get_rapTA_CustomerDDLLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			List<String> dataSource_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..RTA_Customer_Name");
			System.out.println("dataSource_name : "+dataSource_name);
			scc_sccDataImp_pf.selectByVisibleText(element, dataSource_name.get(0));
			logger.log(LogStatus.PASS, "Existing Data Source for RAP Test Alarm Setup Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Data Source Link");
		}
	}
	
	//Select The desired Facility from the DropDown upon customer selection.
	@SuppressWarnings("static-access")
	public static void selectFacilityNameForSetup() 
			throws InterruptedException{
		WebElement element=scc_rapTestAlarm_pf.get_rapTA_FacilityDDLLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			List<String> facility_options = scc_sccDataImp_pf.getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					scc_sccDataImp_pf.selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = scc_sccDataImp_pf.getRamdomNoBetweenRange(2, random_range_lim);
					scc_sccDataImp_pf.selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Facility Name for configuring RAP Test Alarm selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Facility Name for configuring RAP Test Alarm");
		}
	}
	
	
	//Select The desired Asset from the DropDown upon Facility selection.
	@SuppressWarnings("static-access")
	public static void selectAssetNameForSetup() 
			throws InterruptedException{
		waitForSpinnerToDisappear();
		WebElement element=scc_rapTestAlarm_pf.get_rapTA_AssetDDLLink();
		if (element !=null) {
			Thread.sleep(3000);
			waitForSpinnerToDisappear();
			List<String> facility_options = scc_sccDataImp_pf.getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					scc_sccDataImp_pf.selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = scc_sccDataImp_pf.getRamdomNoBetweenRange(2, random_range_lim);
					scc_sccDataImp_pf.selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Asset Name for configuring RAP Test Alarm selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Asset Name for configuring RAP Test Alarm");
		}
	}
	
	//Check the Owner Device details for the selected Asset.
	public static void validateOwnerDeviceForSelectedAsset() {
		
		waitForSpinnerToDisappear();
		WebElement ownerName_element=scc_rapTestAlarm_pf.get_rapTA_OwnerNameLink();
		if(ownerName_element!=null){
			String ownerName = ownerName_element.getText();
			System.out.println("ownerName - "+ownerName);
			logger.log(LogStatus.INFO, "The Owner for the selected Asset is : "+ownerName);
		}else{
			logger.log(LogStatus.FAIL, "Error encountered while reading the Owner Details");
		}
		WebElement deviceName_element=scc_rapTestAlarm_pf.get_rapTA_DeviceNameLink();
		if(deviceName_element!=null){
			String deviceName = deviceName_element.getText();
			System.out.println("deviceName - "+deviceName);
			logger.log(LogStatus.INFO, "The Device for the selected Asset is : "+deviceName);
		}else{
			logger.log(LogStatus.FAIL, "Error encountered while reading the Device Details");
		}
	}

	
	//Check the Validity of the Selected Asset Details 
	@SuppressWarnings("static-access")
	public static void validateAssetDetailsFromDB() 
			throws ClassNotFoundException, SQLException {
		
		scc_DataValMaster.checkProfileForLoggedInUser("souvik");
		
		
	}
}
