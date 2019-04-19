/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_Create_SSF_Page_Factory;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_Impersonate_Page_Factory;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_L1UserActions_Page_Factory;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_SSFGrid_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_Impersonate_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SSF_SSFGrid_Page_Factory ssfGridPageFactory = null;
	private static CSD_SSF_Impersonate_Page_Factory ssf_ImpersonatePA = null;
	private static CSD_SSF_Create_SSF_Page_Factory ssfPageFactory = null;
	private static CSD_SSF_L1UserActions_Page_Factory ssfL1PageFactory = null;
	
	public static boolean rejectOrApproveFlag,rejectOrCompleteFlag = true;
	public static String testBranchName,formStatus_Text = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	@SuppressWarnings("static-access")
	public CSD_SSF_Impersonate_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ssfGridPageFactory = new CSD_SSF_SSFGrid_Page_Factory(driver, logger);
		ssf_ImpersonatePA = new CSD_SSF_Impersonate_Page_Factory(driver,logger);
		ssfPageFactory = new CSD_SSF_Create_SSF_Page_Factory(driver, logger);
		ssfL1PageFactory = new CSD_SSF_L1UserActions_Page_Factory(driver, logger);
		
	}
	
	public static int generateRandomTwoDigitNumber() {
		
		Random rand = new Random(); 
		int num = rand.nextInt(99 - 10 + 1) + 10;
		return num;
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	
	//Click the Branch/User Tab Link
	public static void clickOnBranchUserLink(){
		waitForSpinnerToDisappear();
		WebElement element=ssf_ImpersonatePA.get_impersonate_BranchUserLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Branch/User Tab Link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Branch/User Tab Link");
		}
	}
	
	//Search for the User to Impersonate
	public static void searchUserToImpersonate(String userName){
		
		waitForSpinnerToDisappear();
		WebElement element=ssf_ImpersonatePA.get_impersonate_searchUserLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys(userName);
			element.sendKeys(Keys.ENTER);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Desired User to impersonate is entered successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to enter Impersonate User");
		}
	}
	
	//Click on Impersonate User
	public static void clickOnUserToImpersonate(){
		waitForSpinnerToDisappear();
		WebElement element=ssf_ImpersonatePA.get_impersonate_ImpersonateUserLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Impersonate User Icon is clicked Successfully!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Impersonate User");
		}
	}
	
	//Verify Impersonate Home Page is Loaded
	public static void checkImpersonateHomePageLoaded(){
		waitForSpinnerToDisappear();
		WebElement element=ssf_ImpersonatePA.get_impersonate_ImpersonateHomePageLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			//logger.log(LogStatus.INFO, "Impersonate User Icon is clicked Successfully!");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Impersonate Home Page is loaded Successfully!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to load Impersonate Home Page");
		}
	}
	
	
	//Click the Edit Button for the Selected SSF Branch
	public static void editSelectedSSFBranchByL1User(int rowNo) throws InterruptedException{
		
		Thread.sleep(3000);
		waitForSpinnerToDisappear();
		//WebElement element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Edit();
		WebElement element=driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(9) > span.ng-scope > i"));
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit Button Clicked for the Selectetd Branch By the L1 User");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click the Edit Button");
		}
	}
	
	//Verify that the Edit SSF Form Page is Loaded
	public static void verifyEditSSFPageisLoaded(){
		waitForSpinnerToDisappear();
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		if (element !=null) {
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Edit SSF Page is loaded.");
			verifyProperFieldsAreDisabled();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to load Edit SSF Page.");
		}
	}
	
	//Verify if proper Form ID is Displayed on the Edit SSF Form
	
	
	
	
	//Verify if Proper fields are disabled for the L1 user 
	public static void verifyProperFieldsAreDisabled(){
		waitForSpinnerToDisappear();
		WebElement psaAgg_element=ssfPageFactory.get_ssfTab_CI_PSAAgreementLink();
		if (psaAgg_element != null) {
			if (!psaAgg_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "PSA Agreement Textbox is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement branchName_element=ssfPageFactory.get_ssfTab_CI_BranchLink();
			if (!branchName_element.isEnabled()) {
				testBranchName = branchName_element.getAttribute("value");
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Name Dropdown is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement contractType_element=ssfPageFactory.get_ssfTab_CI_ContractTypeLink();
			if (!contractType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Contract Type Dropdown is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement chillerStartDate_element=ssfPageFactory.get_ssfTab_CI_CCStartDateLink();
			if (!chillerStartDate_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Chiller Start Date is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement chillerEndDate_element=ssfPageFactory.get_ssfTab_CI_CCEndDateLink();
			if (!chillerEndDate_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Chiller End Date is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement primaryContact_element=ssfPageFactory.get_ssfTab_CI_BPCNLink();
			if (!primaryContact_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Name is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement primaryContactPhone_element=ssfPageFactory.get_ssfTab_CI_BPCPLink_Impersonate();
			if (!primaryContactPhone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Phone is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement primaryContactEmail_element=ssfPageFactory.get_ssfTab_CI_BPCELink_Impersonate();
			if (!primaryContactEmail_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Email is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipTo_element=ssfPageFactory.get_ssfTab_SI_ShipToLink();
			if (!shipTo_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Ship To is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToAdd_element=ssfPageFactory.get_ssfTab_SI_ShippingAddressLink();
			if (!shipToAdd_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Address is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToCountry_element=ssfPageFactory.get_ssfTab_SI_ShippingCountyLink();
			if (!shipToCountry_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Country is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToState_element=ssfPageFactory.get_ssfTab_SI_ShippingStateLink();
			if (!shipToState_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping State/Province is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToCity_element=ssfPageFactory.get_ssfTab_SI_ShippingCityLink();
			if (!shipToCity_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping City is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToZip_element=ssfPageFactory.get_ssfTab_SI_ShippingZipCodeLink();
			if (!shipToZip_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping ZIP is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement shipToPhone_element=ssfPageFactory.get_ssfTab_SI_ShippingPhoneNumberLink();
			if (!shipToPhone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Phone Number is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement custName_element=ssfPageFactory.get_ssfTab_CSI_CustomerNameLink();
			if (!custName_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Name is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement facilityName_element=ssfPageFactory.get_ssfTab_CSI_FacilityNameLink();
			if (!facilityName_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Facility Name is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement custARNo_element=ssfPageFactory.get_ssfTab_CSI_CustomerARLink();
			if (!custARNo_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer AR Number is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement custTimeZone_element=ssfPageFactory.get_ssfTab_CSI_CustomerTimeZOneLink();
			if (!custTimeZone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Time Zone is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement manitouAccount_element=ssfPageFactory.get_ssfTab_CSI_ManitouAccountLink();
			if (!manitouAccount_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Manitou Account is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement nexGen_element=ssfPageFactory.get_ssfTab_CSI_CustomerNextGenLink();
			if (!nexGen_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "NxGen/ServiceMax ID is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement address_element=ssfPageFactory.get_ssfTab_CSI_FacilityAddressLink();
			if (!address_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Address is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement country_element=ssfPageFactory.get_ssfTab_CSI_FaciltiyCountyLink();
			if (!country_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Country is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement state_element=ssfPageFactory.get_ssfTab_CSI_facilityStateLink();
			if (!state_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "State is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement city_element=ssfPageFactory.get_ssfTab_CSI_facilityCityLink();
			if (!city_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "City is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement zip_element=ssfPageFactory.get_ssfTab_CSI_FacilityZipCodeLink();
			if (!zip_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "ZIP is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement phone_element=ssfPageFactory.get_ssfTab_CSI_SitePhoneLink();
			if (!phone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Phone Number is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement businessType_element=ssfPageFactory.get_ssfTab_CSI_facilityVerticalLink();
			if (!businessType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Type of Business is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement custNetwork_element=ssfPageFactory.get_ssfTab_IC_CustomerNetworkLink();
			if (!custNetwork_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Network is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement cellModem_element=ssfPageFactory.get_ssfTab_IC_CellModemLink();
			if (!cellModem_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Cell Modem is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			/*WebElement modemProvider_element=ssfPageFactory.get_ssfTab_IC_ProviderLink();
			if (!modemProvider_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Modem Provider is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}*/
			WebElement supportLine_element=ssfPageFactory.get_ssfTab_IC_SupportLineLink();
			if (!supportLine_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Support Line is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement equipType_element=ssfPageFactory.get_ssfTab_Equip_EquipmentTypeLink();
			if (!equipType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Equipment Type is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}
			WebElement notes_element=ssfPageFactory.get_ssfTab_Bottom_TextNotesLink();
			if (!notes_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Notes is Disabled for the L1 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L1 User");
			}			
			logger.log(LogStatus.PASS, "All the Proper Fields Are Disabled for the logged in L1 user");
		}else{
			logger.log(LogStatus.FAIL, "Failed to load Edit SSF Page.");
		}
	}
	
	
	//Verify Edit PAge is loaded and check poermissions
	public static void verifyEditSSFPageisLoaded_L2(){
		waitForSpinnerToDisappear();
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		if (element !=null) {
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Edit SSF Page is loaded.");
			verifyProperFieldsAreDisabled_L2();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to load Edit SSF Page.");
		}
	}
	
	//Verify Access Permissions for Logged IN L2 USer 
	public static void verifyProperFieldsAreDisabled_L2(){
		waitForSpinnerToDisappear();
		WebElement psaAgg_element=ssfPageFactory.get_ssfTab_CI_PSAAgreementLink();
		if (psaAgg_element != null) {
			if (!psaAgg_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "PSA Agreement Textbox is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement branchName_element=ssfPageFactory.get_ssfTab_CI_BranchLink();
			if (!branchName_element.isEnabled()) {
				testBranchName = branchName_element.getAttribute("value");
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Name Dropdown is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement contractType_element=ssfPageFactory.get_ssfTab_CI_ContractTypeLink();
			if (!contractType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Contract Type Dropdown is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement chillerStartDate_element=ssfPageFactory.get_ssfTab_CI_CCStartDateLink();
			if (!chillerStartDate_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Chiller Start Date is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement chillerEndDate_element=ssfPageFactory.get_ssfTab_CI_CCEndDateLink();
			if (!chillerEndDate_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Chiller End Date is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement primaryContact_element=ssfPageFactory.get_ssfTab_CI_BPCNLink();
			if (!primaryContact_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Name is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement primaryContactPhone_element=ssfPageFactory.get_ssfTab_CI_BPCPLink_Impersonate();
			if (!primaryContactPhone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Phone is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement primaryContactEmail_element=ssfPageFactory.get_ssfTab_CI_BPCELink_Impersonate();
			if (!primaryContactEmail_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Branch Primary Contact Email is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipTo_element=ssfPageFactory.get_ssfTab_SI_ShipToLink();
			if (!shipTo_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Ship To is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToAdd_element=ssfPageFactory.get_ssfTab_SI_ShippingAddressLink();
			if (!shipToAdd_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Address is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToCountry_element=ssfPageFactory.get_ssfTab_SI_ShippingCountyLink();
			if (!shipToCountry_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Country is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToState_element=ssfPageFactory.get_ssfTab_SI_ShippingStateLink();
			if (!shipToState_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping State/Province is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToCity_element=ssfPageFactory.get_ssfTab_SI_ShippingCityLink();
			if (!shipToCity_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping City is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToZip_element=ssfPageFactory.get_ssfTab_SI_ShippingZipCodeLink();
			if (!shipToZip_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping ZIP is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement shipToPhone_element=ssfPageFactory.get_ssfTab_SI_ShippingPhoneNumberLink();
			if (!shipToPhone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Shipping Phone Number is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement custName_element=ssfPageFactory.get_ssfTab_CSI_CustomerNameLink();
			if (!custName_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Name is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement facilityName_element=ssfPageFactory.get_ssfTab_CSI_FacilityNameLink();
			if (!facilityName_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Facility Name is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement custARNo_element=ssfPageFactory.get_ssfTab_CSI_CustomerARLink();
			if (!custARNo_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer AR Number is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement custTimeZone_element=ssfPageFactory.get_ssfTab_CSI_CustomerTimeZOneLink();
			if (!custTimeZone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Time Zone is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement manitouAccount_element=ssfPageFactory.get_ssfTab_CSI_ManitouAccountLink();
			if (!manitouAccount_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Manitou Account is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement nexGen_element=ssfPageFactory.get_ssfTab_CSI_CustomerNextGenLink();
			if (!nexGen_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "NxGen/ServiceMax ID is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement address_element=ssfPageFactory.get_ssfTab_CSI_FacilityAddressLink();
			if (!address_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Address is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement country_element=ssfPageFactory.get_ssfTab_CSI_FaciltiyCountyLink();
			if (!country_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Country is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement state_element=ssfPageFactory.get_ssfTab_CSI_facilityStateLink();
			if (!state_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "State is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement city_element=ssfPageFactory.get_ssfTab_CSI_facilityCityLink();
			if (!city_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "City is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement zip_element=ssfPageFactory.get_ssfTab_CSI_FacilityZipCodeLink();
			if (!zip_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "ZIP is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement phone_element=ssfPageFactory.get_ssfTab_CSI_SitePhoneLink();
			if (!phone_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Phone Number is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement businessType_element=ssfPageFactory.get_ssfTab_CSI_facilityVerticalLink();
			if (!businessType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Type of Business is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement custNetwork_element=ssfPageFactory.get_ssfTab_IC_CustomerNetworkLink();
			if (!custNetwork_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Customer Network is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement cellModem_element=ssfPageFactory.get_ssfTab_IC_CellModemLink();
			if (!cellModem_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Cell Modem is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			/*WebElement modemProvider_element=ssfPageFactory.get_ssfTab_IC_ProviderLink();
			if (!modemProvider_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Modem Provider is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}*/
			WebElement supportLine_element=ssfPageFactory.get_ssfTab_IC_SupportLineLink();
			if (!supportLine_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Support Line is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement equipType_element=ssfPageFactory.get_ssfTab_Equip_EquipmentTypeLink();
			if (!equipType_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Equipment Type is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}
			WebElement notes_element=ssfPageFactory.get_ssfTab_Bottom_TextNotesLink();
			if (!notes_element.isEnabled()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.INFO, "Notes is Disabled for the L2 User");
			} else {
				logger.log(LogStatus.FAIL, "Permission is not right for the logged in L2 User");
			}			
			logger.log(LogStatus.PASS, "All the Proper Fields Are Disabled for the logged in L2 user");
		}else{
			logger.log(LogStatus.FAIL, "Failed to load Edit SSF Page.");
		}
	}
	
	//Verify if Proper Fields can be edited
	public static void verifyL1UserHasProperEditPermissions(String entryVal) {
		
		waitForSpinnerToDisappear();
		WebElement formStatus = ssfL1PageFactory.get_l1user_SSFFormStatusLink();
		formStatus_Text = formStatus.getText();
		WebElement poNo_element=ssfPageFactory.get_ssfTab_CI_PONumberLink();
		if(poNo_element!=null){
			if (formStatus_Text.contains("Submitted")) {
				
				poNo_element.sendKeys("TestPONo123_Sub");
				String temp_val = poNo_element.getAttribute("value");
				logger.log(LogStatus.PASS, "PO Number is Updated in the Selected Form By the Logged IN L1 User!");
				
			}else if (formStatus_Text.contains("Completed")) {
				
				poNo_element.sendKeys("TestPONo123_Com");
				String temp_val = poNo_element.getAttribute("value");
				logger.log(LogStatus.PASS, "PO Number is Updated in the Selected Form By the Logged IN L1 User!");
				
			}
		}
		waitForSpinnerToDisappear();
		WebElement orderNo_element=ssfPageFactory.get_ssfTab_CI_SalesOrderLink();
		if(orderNo_element!=null){
			String temp_val = orderNo_element.getAttribute("value");
			if(!temp_val.equals("") && orderNo_element.isEnabled()){
				orderNo_element.sendKeys("L1update");
				logger.log(LogStatus.PASS, "Order Number Attribute is Updated by the L1 User");
			}else if(temp_val.equals("") && orderNo_element.isEnabled()){
				orderNo_element.sendKeys("_L1");
				logger.log(LogStatus.PASS, "Order Number Attribute is Updated by the L1 User");
			}
		}
		waitForSpinnerToDisappear();
		WebElement addUser_element=ssfPageFactory.get_ssfTab_SCCDC_UserSaveLink_Impersonate();
		if (addUser_element!=null) {
			//addUser_element.click();
			if (formStatus_Text.contains("Submitted")) {
				
				int randomNo = generateRandomTwoDigitNumber();
				addUser_element.click();
				logger.log(LogStatus.INFO, "Logged in L1 user has permission to add CFA Users.");
				waitForSpinnerToDisappear();
				WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
				if (addUser_name_Element != null && addUser_name_Element.isDisplayed()) {
					addUser_name_Element.sendKeys("L1 User Update"+entryVal+randomNo);
					WebElement addUser_Uname_Element = ssfPageFactory.get_ssfTab_SCCDC_UserContactNoLink();
					addUser_Uname_Element.sendKeys("1234567890");
					WebElement addUser_email_Element = ssfPageFactory.get_ssfTab_SCCDC_UserUserEmailLink();
					addUser_email_Element.sendKeys("L1UserUpdate"+entryVal+randomNo+"@jci.com");
					WebElement addUser_save_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsSaveLink();
					addUser_save_Element.click();
					waitForSpinnerToDisappear();
					WebElement addUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
					addUser_popup_Element.click();
				}
				logger.log(LogStatus.PASS,
						"Logged in L1 user has successfully added a CFA User for the SSF Form.");
			}else if (formStatus_Text.contains("Completed")) {
				
				int randomNo = generateRandomTwoDigitNumber();
				addUser_element.click();
				logger.log(LogStatus.INFO, "Logged in L1 user has permission to add CFA Users.");
				waitForSpinnerToDisappear();
				WebElement addUser_name_Element = ssfPageFactory.get_ssfTab_SCCDC_UserNameLink();
				if (addUser_name_Element != null && addUser_name_Element.isDisplayed()) {
					addUser_name_Element.sendKeys("L1 User Completed"+entryVal+randomNo);
					WebElement addUser_Uname_Element = ssfPageFactory.get_ssfTab_SCCDC_UserContactNoLink();
					addUser_Uname_Element.sendKeys("1234567890");
					WebElement addUser_email_Element = ssfPageFactory.get_ssfTab_SCCDC_UserUserEmailLink();
					addUser_email_Element.sendKeys("L1UserCompleted"+entryVal+randomNo+"@jci.com");
					WebElement addUser_save_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsSaveLink();
					addUser_save_Element.click();
					waitForSpinnerToDisappear();
					WebElement addUser_popup_Element = ssfPageFactory.get_ssfTab_SCCDC_UserDetailsPopUpLink();
					addUser_popup_Element.click();
				}
				logger.log(LogStatus.PASS,
						"Logged in L1 user has successfully added a CFA User for the SSF Form.");
			}else if (formStatus_Text.contains("Rejected by L2")) {
				logger.log(LogStatus.INFO, "Logged in L1 user has permission to add CFA Users. But Wished to Skip this Step.");
			}
		}
		waitForSpinnerToDisappear();
		WebElement L1UserNotes_element=ssfL1PageFactory.get_l1user_editL1UserNotes();
		if (L1UserNotes_element!=null) {
			L1UserNotes_element.sendKeys("\nAutomate Update Made by Logged in L1 User");
			logger.log(LogStatus.PASS, "Logged in L1 user has updated the L1 user Notes Section Successfully");
		}
	}
	
	//Verify if the L1 user has permission to delete the Existing CFA Users for the SSF Form
	public static void verifyUserDeletePermissionForL1User(boolean flag) throws InterruptedException {
		
		int noOfUsers = driver.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr")).size() - 2;
		
		if (flag == true) {
			logger.log(LogStatus.INFO, "The User has decided to check the delete permission for the L1 user on the existing CFA Users!");
			if(noOfUsers > 0){ System.out.println("noOfUsers" +noOfUsers);
				waitForSpinnerToDisappear();
				logger.log(LogStatus.INFO, "The SSF Form Already has some Mapped CFA USers.");
				WebElement deleteUser_Element = driver.findElement(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr:nth-child(2) > td:nth-child(6) > i"));
				if(deleteUser_Element!=null && deleteUser_Element.isEnabled()){
					Thread.sleep(2000);
					waitForSpinnerToDisappear();
					deleteUser_Element.click();
					WebElement delOK_element=ssfL1PageFactory.get_l1user_PopUpOKLink();
					delOK_element.click();
					waitForSpinnerToDisappear();
					WebElement delOKConfirm_element=ssfL1PageFactory.get_l1user_PopUpOKLink();
					delOKConfirm_element.click();
					waitForSpinnerToDisappear();
					int noOfUsersDel = driver.findElements(By.cssSelector("#collapseFour > div > div:nth-child(3) > div > table > tbody > tr")).size() - 2;
					if(noOfUsersDel < noOfUsers){
						logger.log(LogStatus.PASS, "L1 user successfully deleted the mapped CFA User");
					}
				}
			}
		}else if(flag == false){
			logger.log(LogStatus.INFO, "The User has decided to skip checking the delete permission for the L1 user on the existing CFA Users!");
		}
	}
	
	//perform Reject OR Approved operation of the Selected SSF Form
	public static void performSSFFormRejectORApproveOperation(boolean flag) {
		rejectOrApproveFlag = flag;
		if (flag == true) {
			if (formStatus_Text.contains("Submitted")) {
				waitForSpinnerToDisappear();
				WebElement approve_element = ssfL1PageFactory.get_l1user_L1ApproveLink();
				if (approve_element != null) {
					approve_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					approveOK_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (approveOKconfirm_element != null && approveOKconfirm_element.isDisplayed()) {
						approveOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully APPROVED the selected SSF Form");
				} 
			}else if (formStatus_Text.contains("Rejected by L2")) {
				waitForSpinnerToDisappear();
				WebElement approve_element = ssfL1PageFactory.get_l1user_L1ApproveLink();
				if (approve_element != null) {
					approve_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					approveOK_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (approveOKconfirm_element != null && approveOKconfirm_element.isDisplayed()) {
						approveOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully APPROVED the selected SSF Form");
				} 
			} else if (formStatus_Text.contains("Approved")) {
				waitForSpinnerToDisappear();
				WebElement approve_element = ssfL1PageFactory.get_l1user_L1PostApproveSaveLink();
				if (approve_element != null) {
					approve_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					approveOK_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (approveOKconfirm_element != null && approveOKconfirm_element.isDisplayed()) {
						approveOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully APPROVED the selected SSF Form");
				} 
			}else if (formStatus_Text.contains("Completed")) {
				waitForSpinnerToDisappear();
				WebElement approve_element = ssfL1PageFactory.get_l1user_L1PostCompleteSaveLink();
				if (approve_element != null) {
					approve_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					approveOK_element.click();
					waitForSpinnerToDisappear();
					WebElement approveOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (approveOKconfirm_element != null && approveOKconfirm_element.isDisplayed()) {
						approveOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully APPROVED the selected SSF Form");
				} 
			}
		} else if(flag == false){
			if (formStatus_Text.contains("Submitted")) {
				waitForSpinnerToDisappear();
				WebElement reject_element = ssfL1PageFactory.get_l1user_L1RejectLink();
				if (reject_element != null) {
					reject_element.click();
					waitForSpinnerToDisappear();
					WebElement rejectOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					rejectOK_element.click();
					waitForSpinnerToDisappear();
					WebElement rejectOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (rejectOKconfirm_element != null && rejectOKconfirm_element.isDisplayed()) {
						rejectOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully REJECTED the selected SSF Form from Submitted State");
				} 
			}else if (formStatus_Text.contains("Rejected by L2")) {
				waitForSpinnerToDisappear();
				WebElement reject_element = ssfL1PageFactory.get_l1user_L1RejectLink();
				if (reject_element != null) {
					reject_element.click();
					waitForSpinnerToDisappear();
					WebElement rejectOK_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					rejectOK_element.click();
					waitForSpinnerToDisappear();
					WebElement rejectOKconfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
					if (rejectOKconfirm_element != null && rejectOKconfirm_element.isDisplayed()) {
						rejectOKconfirm_element.click();
					}
					logger.log(LogStatus.PASS, "L1 user successfully REJECTED the selected SSF Form from Rejected By L2 state");
				} 
			}else if (formStatus_Text.contains("Approved")) {
				logger.log(LogStatus.INFO, "L1 user DOES NOT have permission to Reject as the Form is in Approved State.");
			}else if (formStatus_Text.contains("Completed")) {
				logger.log(LogStatus.INFO, "L1 user DOES NOT have permission to Reject as the Form is in Completed State.");
			}
		}
	}
	
	//Check if the Status of the Form has changed after the Action
	public static void checkCheckChangeAfterL1Action(String branchName) throws InterruptedException {
		
		if(rejectOrApproveFlag == true){
			if (formStatus_Text.contains("Submitted") && formStatus_Text.contains("Rejected by L2")) {
				logger.log(LogStatus.INFO, "L1 User has SAVED the Form. Checking for related Status Change!");
				waitForSpinnerToDisappear();
				WebElement rightMenu_element = ssfL1PageFactory.get_l1user_rightMenuButtonLink();
				if (rightMenu_element != null && rightMenu_element.isDisplayed()) {
					logger.log(LogStatus.INFO, "Successfully Navigated to the SSF Grid Page for the L1 User");
					WebElement element = ssfGridPageFactory.get_ssfTab_BranchSearch();
					waitForSpinnerToDisappear();
					if (element != null) {
						logger.log(LogStatus.INFO, "Searching Branch Name for the SSF Form just edited!");
						element.sendKeys(branchName);
						Thread.sleep(3000);
						String formStatus = driver
								.findElement(By
										.cssSelector("#scrollDiv > table > tbody > tr:nth-child(1) > td:nth-child(5)"))
								.getText();
						if (formStatus.contains("approved")) {
							logger.log(LogStatus.PASS, "Status is successfully Changed and is Reflecting properly!");
						}
						WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
					} else {
						logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
					}
				} 
			}else if (formStatus_Text.contains("Approved") && formStatus_Text.contains("Completed")) {
				logger.log(LogStatus.INFO, "L1 User has SAVED the Form. Checking for related Status Change!");
				waitForSpinnerToDisappear();
				WebElement rightMenu_element = ssfL1PageFactory.get_l1user_rightMenuButtonLink();
				if (rightMenu_element != null && rightMenu_element.isDisplayed()) {
					logger.log(LogStatus.INFO, "Successfully Navigated to the SSF Grid Page for the L1 User");
					WebElement element = ssfGridPageFactory.get_ssfTab_BranchSearch();
					waitForSpinnerToDisappear();
					if (element != null) {
						logger.log(LogStatus.INFO, "Searching Branch Name for the SSF Form just edited!");
						element.sendKeys(branchName);
						Thread.sleep(3000);
						String formStatus = driver
								.findElement(By
										.cssSelector("#scrollDiv > table > tbody > tr:nth-child(1) > td:nth-child(5)"))
								.getText();
						if (formStatus.contains("approved") || formStatus.contains("completed")) {
							logger.log(LogStatus.PASS, "Status is Reflecting properly!");
						}
						WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
					} else {
						logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
					}
				} 
			}
		}
	}
	
	//Check if the status of the Searched Branch is Eligible for Update
	public static void checkStatusStateForEdit(int rowNo,boolean flag) throws InterruptedException {
		
		Thread.sleep(3000);
		String formStatus = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(5)")).getText();
		if(formStatus.equals("Submitted")){
			logger.log(LogStatus.INFO, "Logged in L1 User has Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			
			editSelectedSSFBranchByL1User(rowNo);
			verifyEditSSFPageisLoaded();
			verifyUserDeletePermissionForL1User(false);
			verifyL1UserHasProperEditPermissions("Submitted");
			performSSFFormRejectORApproveOperation(flag);
			checkCheckChangeAfterL1Action("Automation_TestBranch");
			
		}else if(formStatus.equals("Approved")){
			logger.log(LogStatus.INFO, "Logged in L1 User has Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			
			editSelectedSSFBranchByL1User(rowNo);
			verifyEditSSFPageisLoaded();
			verifyUserDeletePermissionForL1User(false);
			verifyL1UserHasProperEditPermissions("Approved");
			performSSFFormRejectORApproveOperation(flag);
			checkCheckChangeAfterL1Action("Automation_TestBranch");
			
		}else if(formStatus.equals("Completed")){
			logger.log(LogStatus.INFO, "Logged in L1 User has Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			
			editSelectedSSFBranchByL1User(rowNo);
			verifyEditSSFPageisLoaded();
			verifyUserDeletePermissionForL1User(false);
			verifyL1UserHasProperEditPermissions("Completed");
			performSSFFormRejectORApproveOperation(flag);
			checkCheckChangeAfterL1Action("Automation_TestBranch");
			
		}else if(formStatus.equals("Rejected by L2")){
			logger.log(LogStatus.INFO, "Logged in L1 User has Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			
			editSelectedSSFBranchByL1User(rowNo);
			verifyEditSSFPageisLoaded();
			verifyUserDeletePermissionForL1User(false);
			verifyL1UserHasProperEditPermissions("Rejected by L2");
			performSSFFormRejectORApproveOperation(flag);
			checkCheckChangeAfterL1Action("Automation_TestBranch");
			
		}else{
			logger.log(LogStatus.INFO, "Logged in L1 User has NO Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			logger.log(LogStatus.INFO, "Please check on the Previous Steps for the SSF Form Life Cycle!");
		}
	}
	
	//Check for any possible SSF Forms that we could perform Actions Upon -- L1 Actions
	public static void checkForEditableSSFFormsUnderSearchResults(boolean flag) throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_searchResultsGrid_Table();
		waitForSpinnerToDisappear();
		if (element !=null) {
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch Name");
			if(searchResuls_grid >= 1){
				logger.log(LogStatus.INFO, "Checkin for Eligible SSF Form Status for L1 USer to Edit.");
				for (int i = 1; i <= searchResuls_grid; i++) {
					checkStatusStateForEdit(i,flag);
				}
				
			}/*else if(searchResuls_grid == 1){
				logger.log(LogStatus.INFO, "Going ahead with the Validations on the Selected SSF Form");
			}*/else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Branch Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
		
	}
	
	
	//Check for any possible SSF Forms that we could perform Actions Upon -- L2 Actions
	public static void checkForEditableSSFFormsUnderSearchResults_L2(boolean flag) throws InterruptedException {
		
		rejectOrCompleteFlag = flag;
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_searchResultsGrid_Table();
		waitForSpinnerToDisappear();
		if (element !=null) {
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch Name");
			if(searchResuls_grid >= 1){
				System.out.println("searchResuls_grid "+searchResuls_grid);
				logger.log(LogStatus.INFO, "Checking for Eligible SSF Form Status for L2 User to Edit.");
				for (int i = 1; i <= searchResuls_grid; i++) {
					checkStatusStateForEdit_L2(i);
				}
				
			}/*else if(searchResuls_grid == 1){
				logger.log(LogStatus.INFO, "Going ahead with the Validations on the Selected SSF Form");
			}*/else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Branch Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
		
	}

	
	//Check the status of the selected SSF Form and perform edit actions -- L2 User
	public static void checkStatusStateForEdit_L2(int rowNo) throws InterruptedException {

		Thread.sleep(3000);
		String formStatus = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(5)")).getText();
		if(formStatus.equals("Approved")){
			logger.log(LogStatus.INFO, "Logged in L2 User has Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
			
			editSelectedSSFBranchByL2User(rowNo);
			verifyEditSSFPageisLoaded_L2();
			addOwnerDeviceForSSFChiller();
			addL2UserOnboardingComments();
			performRejectOrCompleteOperation(rejectOrCompleteFlag);
			checkCheckChangeAfterL2Action("Automation_TestBranch",rowNo);
			
		}else if(formStatus.equals("Rejected by L2")){
			logger.log(LogStatus.INFO, "Logged in L2 User has NO Scope for Editing on the Selected SSF Form.Form Status is : "+formStatus);
		}
		
	}
	
	
	public static void checkCheckChangeAfterL2Action(String branchName, int rowNo) throws InterruptedException {
		
		if(rejectOrCompleteFlag == true){
			logger.log(LogStatus.INFO, "L2 User has Completed the Form. Checking for related Status Change!");
			waitForSpinnerToDisappear();
			WebElement rightMenu_element=ssfL1PageFactory.get_l1user_rightMenuButtonLink();
			if(rightMenu_element!=null && rightMenu_element.isDisplayed()){
				logger.log(LogStatus.INFO, "Successfully Navigated to the SSF Grid Page for the L1 User");
				WebElement element=ssfGridPageFactory.get_ssfTab_BranchSearch();
				waitForSpinnerToDisappear();
				if (element !=null) {
					logger.log(LogStatus.INFO, "Searching Branch Name for the SSF Form just edited!");
					element.sendKeys(branchName);
					Thread.sleep(3000);
					String formStatus = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(5)")).getText();
					if(formStatus.contains("Completed")){
						logger.log(LogStatus.PASS, "Status is successfully Changed and is Reflecting properly! Status is : "+formStatus);
					}
					WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				}else{
					logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
				}
			}
		}else if(rejectOrCompleteFlag == false){
			logger.log(LogStatus.INFO, "L2 User has Rejected the Form. Checking for related Status Change!");
			waitForSpinnerToDisappear();
			WebElement rightMenu_element=ssfL1PageFactory.get_l1user_rightMenuButtonLink();
			if(rightMenu_element!=null && rightMenu_element.isDisplayed()){
				logger.log(LogStatus.INFO, "Successfully Navigated to the SSF Grid Page for the L1 User");
				WebElement element=ssfGridPageFactory.get_ssfTab_BranchSearch();
				waitForSpinnerToDisappear();
				if (element !=null) {
					logger.log(LogStatus.INFO, "Searching Branch Name for the SSF Form just edited!");
					element.sendKeys(branchName);
					Thread.sleep(3000);
					String formStatus = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(5)")).getText();
					if(formStatus.contains("Rejected by L2")){
						logger.log(LogStatus.PASS, "Status is successfully Changed and is Reflecting properly! Status is : "+formStatus);
					}
					WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				}else{
					logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
				}
			}
		}
		
	}

	//Edit the Selected SSF Form -- L2 Action
	public static void editSelectedSSFBranchByL2User(int rowNo) throws InterruptedException{
		
		Thread.sleep(3000);
		waitForSpinnerToDisappear();
		//WebElement element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Edit();
		WebElement element=driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child("+rowNo+") > td:nth-child(9) > span.ng-scope > i"));
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit Button Clicked for the Selectetd Branch By the L2 User");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click the Edit Button");
		}
	}
	
	public static void addOwnerDeviceForSSFChiller() {
		
		waitForSpinnerToDisappear();
		WebElement ownerDevice_element = ssfL1PageFactory.get_l2user_addOwnerDeviceLink();
		if(ownerDevice_element!=null && ownerDevice_element.isEnabled()){
			logger.log(LogStatus.INFO, "L2 User has permission to add Owner/Device Details to the SSF Form Chiller");
			ownerDevice_element.click();
			waitForSpinnerToDisappear();
			WebElement accID_element = ssfL1PageFactory.get_l2user_ODAccIDLink();
			if(accID_element!=null && accID_element.isDisplayed()){
				accID_element.sendKeys("testID");
			}
			WebElement accPass_element = ssfL1PageFactory.get_l2user_ODAccPassLink();
			if(accPass_element!=null && accPass_element.isDisplayed()){
				accPass_element.sendKeys("testPass");
			}
			WebElement accUpdate_element = ssfL1PageFactory.get_l2user_ODAccUpdateLink();
			accUpdate_element.click();
			waitForSpinnerToDisappear();
			WebElement completeDone_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
			completeDone_element.click();
			logger.log(LogStatus.PASS, "L2 User has successfully updated Owner/Device Details to the SSF Form Chiller");
		}else{
			logger.log(LogStatus.FAIL, "Error Encountered while Adding Chiller Owner Device Details");
		}
	}
	
	public static void addL2UserOnboardingComments() {
		
		waitForSpinnerToDisappear();
		WebElement l2Comments_element = ssfL1PageFactory.get_l2user_l2CommentsLink();
		if(l2Comments_element!=null && l2Comments_element.isEnabled()){
			l2Comments_element.sendKeys("Automated Update made by Logged In L2 User");
			logger.log(LogStatus.PASS, "L2 User has successfully updated Onboarding Comments");
		}else{
			logger.log(LogStatus.FAIL, "L2 User has failed to update onboarding comments");
		}
	}
	
	
	public static void performRejectOrCompleteOperation(boolean flag) {
		
		waitForSpinnerToDisappear();
		if(rejectOrCompleteFlag == true){
			WebElement complete_element = ssfL1PageFactory.get_l2user_l2ConfirmLink();
			complete_element.click();
			waitForSpinnerToDisappear();
			WebElement completeConfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
			completeConfirm_element.click();
			waitForSpinnerToDisappear();
			WebElement completeDone_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
			completeDone_element.click();
			logger.log(LogStatus.PASS, "L2 User has successfully Completed the Selected SSF Form");
		}else if(rejectOrCompleteFlag == false){
			WebElement reject_element = ssfL1PageFactory.get_l2user_l2RejectLink();
			reject_element.click();
			waitForSpinnerToDisappear();
			WebElement rejectConfirm_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
			rejectConfirm_element.click();
			waitForSpinnerToDisappear();
			WebElement rejectDone_element = ssfL1PageFactory.get_l1user_PopUpOKLink();
			rejectDone_element.click();
			logger.log(LogStatus.PASS, "L2 User has successfully Rejected the Selected SSF Form");
		}
	}

}
