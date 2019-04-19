/**
 * 
 */
package mars.JCI.Project.CSD.Setup.SSF;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_Create_SSF_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SSF_Create_SSF_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		
		PageFactory.initElements(driver, this);
	}
	
	//Method Overload, we are using fluent wait
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}
	}
	
	//The Administration Tab
	@FindBy(css="a[test-id='administration-tab']")
	private WebElement ssfTab_AdministrationLink;
		
	public WebElement get_ssfTab_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_AdministrationLink, logger)){
			return ssfTab_AdministrationLink;
		}else
			return null;
	}
	
	
	//The Site Setup Tab
	@FindBy(css="a[test-id='SiteSetup-tab']")
	private WebElement ssfTab_SiteSetupLink;
	
	public WebElement get_ssfTab_SiteSetupLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SiteSetupLink, logger)){
			return ssfTab_SiteSetupLink;
		}else
			return null;
	}
	
	//The SSF Tab
	@FindBy(css="a[test-id='SSF-tab']")
	private WebElement ssfTab_SSFTabLink;
	
	public WebElement get_ssfTab_SSFTabLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SSFTabLink, logger)){
			return ssfTab_SSFTabLink;
		}else
			return null;
	}
	
	
	//The Create SSF Button
	@FindBy(css="input[value='Create SSF']")
	private WebElement ssfTab_CreateSSFLink;
		
		public WebElement get_ssfTab_CreateSSFLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CreateSSFLink, logger)){
				return ssfTab_CreateSSFLink;
			}else
				return null;
		}
		
	// ##############################  The Contract Information Section  ########################################################
		
	//The Contract Information Section -- Branch Dropdown
	@FindBy(css="select[name='ddlBranch']")
	private WebElement ssfTab_CI_BranchLink;
			
	public WebElement get_ssfTab_CI_BranchLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BranchLink, logger)){
			return ssfTab_CI_BranchLink;
		}else
			return null;
	}
	
	
	//The Contract Information Section  -- Contract Type Dropdown
	@FindBy(css="select[name='ddlContractType']")
	private WebElement ssfTab_CI_ContractTypeLink;
			
	public WebElement get_ssfTab_CI_ContractTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_ContractTypeLink, logger)){
			return ssfTab_CI_ContractTypeLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- PSA Agreement TextBox
	@FindBy(css="input[name='txtPSAAgreement']")
	private WebElement ssfTab_CI_PSAAgreementLink;
			
	public WebElement get_ssfTab_CI_PSAAgreementLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_PSAAgreementLink, logger)){
			return ssfTab_CI_PSAAgreementLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- PO Number TextBox
	@FindBy(css="input[automation-id='txtPONumber']")//name
	private WebElement ssfTab_CI_PONumberLink;
			
	public WebElement get_ssfTab_CI_PONumberLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_PONumberLink, logger)){
			return ssfTab_CI_PONumberLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Connected Chiller Start Date Calender
	@FindBy(css="input[name='PSAStartDate']")
	private WebElement ssfTab_CI_CCStartDateLink;
			
	public WebElement get_ssfTab_CI_CCStartDateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_CCStartDateLink, logger)){
			return ssfTab_CI_CCStartDateLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Connected Chiller End Date Calender
	@FindBy(css="input[name='PSAEndDate']")
	private WebElement ssfTab_CI_CCEndDateLink;
			
	public WebElement get_ssfTab_CI_CCEndDateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_CCEndDateLink, logger)){
			return ssfTab_CI_CCEndDateLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Branch Primary Contact Name TextBox
	@FindBy(css="input[name='txtBranchPContactName']")
	private WebElement ssfTab_CI_BPCNLink;
			
	public WebElement get_ssfTab_CI_BPCNLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BPCNLink, logger)){
			return ssfTab_CI_BPCNLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Branch Primary Contact Phone TextBox
	@FindBy(css="input[automation-id='txtbranchpcontact']")//txtbranchpcontact -- txtBranchPContact
	private WebElement ssfTab_CI_BPCPLink;
			
	public WebElement get_ssfTab_CI_BPCPLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BPCPLink, logger)){
			return ssfTab_CI_BPCPLink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Branch Primary Contact Phone TextBox
	@FindBy(css="input[automation-id='txtBranchPContact']")//txtbranchpcontact -- txtBranchPContact
	private WebElement ssfTab_CI_BPCPLink_Impersonate;
				
	public WebElement get_ssfTab_CI_BPCPLink_Impersonate(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BPCPLink_Impersonate, logger)){
			return ssfTab_CI_BPCPLink_Impersonate;
		}else
			return null;
	}
	
	
	//The Contract Information Section  -- Branch Primary Contact Email Address TextBox
	@FindBy(css="input[automation-id='txtbranchpcontactemail']") //txtbranchpcontactemail -- txtBranchPContactEmail
	private WebElement ssfTab_CI_BPCELink;
			
	public WebElement get_ssfTab_CI_BPCELink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BPCELink, logger)){
			return ssfTab_CI_BPCELink;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Branch Primary Contact Email Address TextBox
	@FindBy(css="input[automation-id='txtBranchPContactEmail']") //txtbranchpcontactemail -- txtBranchPContactEmail
	private WebElement ssfTab_CI_BPCELink_Impersonate;
			
	public WebElement get_ssfTab_CI_BPCELink_Impersonate(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_BPCELink_Impersonate, logger)){
			return ssfTab_CI_BPCELink_Impersonate;
		}else
			return null;
	}
	
	//The Contract Information Section  -- Sales Order #  TextBox
	@FindBy(css="input[automation-id='txtSaleOrder']")
	private WebElement ssfTab_CI_SalesOrderLink;
			
	public WebElement get_ssfTab_CI_SalesOrderLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CI_SalesOrderLink, logger)){
			return ssfTab_CI_SalesOrderLink;
		}else
			return null;
	}
	
	// ##############################  The Shipping Information Section  ########################################################
	
	//The Shipping Information Section  -- Expand  Button
	@FindBy(css="span[id='spanTwo']")
	private WebElement ssfTab_SI_ExpandLink;
			
	public WebElement get_ssfTab_SI_ExpandLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ExpandLink, logger)){
			return ssfTab_SI_ExpandLink;
		}else
			return null;
	}
	
	
	//The Shipping Information Section  -- POP UP  Button
	@FindBy(css="input[id='popup_ok']")
	private WebElement ssfTab_SI_PopUpLink;
			
	public WebElement get_ssfTab_SI_PopUpLink(){
		if(waitForElementPresent(driver, ssfTab_SI_PopUpLink, logger)){
			return ssfTab_SI_PopUpLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- Same As Branch Address CheckBox
	@FindBy(css="input[name='addressType']")
	private WebElement ssfTab_SI_SameAddressTypeLink;
			
	public WebElement get_ssfTab_SI_SameAddressTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_SameAddressTypeLink, logger)){
			return ssfTab_SI_SameAddressTypeLink;
		}else
			return null;
	}
	
	
	//The Shipping Information Section  -- Ship To TextBox
	@FindBy(css="input[name='txtShipTo']")
	private WebElement ssfTab_SI_ShipToLink;
			
	public WebElement get_ssfTab_SI_ShipToLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShipToLink, logger)){
			return ssfTab_SI_ShipToLink;
		}else
			return null;
	}
	
	
	//The Shipping Information Section  -- Address TextBox
	@FindBy(css="input[name='txtShippingAddress']")
	private WebElement ssfTab_SI_ShippingAddressLink;
			
	public WebElement get_ssfTab_SI_ShippingAddressLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingAddressLink, logger)){
			return ssfTab_SI_ShippingAddressLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- Country TextBox
	@FindBy(css="select[name='ddlShippingCounty']")
	private WebElement ssfTab_SI_ShippingCountyLink;
			
	public WebElement get_ssfTab_SI_ShippingCountyLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingCountyLink, logger)){
			return ssfTab_SI_ShippingCountyLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- State / Province* TextBox
	@FindBy(css="select[name='ddlShippingState']")//xpath="//*[@automation-id='ddlShippingState']" --- css="select[name='ddlShippingState']" -- name="ddlShippingState"
	private WebElement ssfTab_SI_ShippingStateLink;
			
	public WebElement get_ssfTab_SI_ShippingStateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingStateLink, logger)){
			return ssfTab_SI_ShippingStateLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- City TextBox
	@FindBy(css="select[automation-id='ddlShippingCity']")//css="select[name='ddlShippingCity']" ----- xpath="//*[@automation-id='ddlShippingCity']"
	private WebElement ssfTab_SI_ShippingCityLink;
			
	public WebElement get_ssfTab_SI_ShippingCityLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingCityLink, logger)){
			return ssfTab_SI_ShippingCityLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- Zip Code TextBox
	@FindBy(css="input[name='txtShippingZipCode']")
	private WebElement ssfTab_SI_ShippingZipCodeLink;
			
	public WebElement get_ssfTab_SI_ShippingZipCodeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingZipCodeLink, logger)){
			return ssfTab_SI_ShippingZipCodeLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- Phone Number TextBox
	@FindBy(css="input[name='txtShippingPhoneNumber']")
	private WebElement ssfTab_SI_ShippingPhoneNumberLink;
			
	public WebElement get_ssfTab_SI_ShippingPhoneNumberLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingPhoneNumberLink, logger)){
			return ssfTab_SI_ShippingPhoneNumberLink;
		}else
			return null;
	}
	
	//The Shipping Information Section  -- Attention To TextBox
	@FindBy(css="input[automation-id='txtAttentionTo']")
	private WebElement ssfTab_SI_ShippingAttentionToLink;
			
	public WebElement get_ssfTab_SI_ShippingAttentionToLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SI_ShippingAttentionToLink, logger)){
			return ssfTab_SI_ShippingAttentionToLink;
		}else
			return null;
	}
	
	// ##############################  The Customer & Site Information Section  ########################################################
	
	//The Customer & Site Information Section  -- Expand Button
	@FindBy(css="span[id='spanThree']")
	private WebElement ssfTab_CSI_ExpandLink;
			
	public WebElement get_ssfTab_CSI_ExpandLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_ExpandLink, logger)){
			return ssfTab_CSI_ExpandLink;
		}else
			return null;
	}
	
	//The Customer NAme TextBox -- To be used in L1 User Role Verifications
	@FindBy(css="input[automation-id='txtCustomerName']")
	private WebElement ssfTab_CSI_CustomerNameLink;
			
	public WebElement get_ssfTab_CSI_CustomerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_CustomerNameLink, logger)){
			return ssfTab_CSI_CustomerNameLink;
		}else
			return null;
	}
	
	//The Customer Facility NAme TextBox -- To be used in L1 User Role Verifications
	@FindBy(css="input[automation-id='txtCustomerName']")
	private WebElement ssfTab_CSI_FacilityNameLink;
			
	public WebElement get_ssfTab_CSI_FacilityNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_FacilityNameLink, logger)){
			return ssfTab_CSI_FacilityNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer Button
	@FindBy(css="input[name='btnSelectCustomer']")
	private WebElement ssfTab_CSI_SelectCustomerLink;
			
	public WebElement get_ssfTab_CSI_SelectCustomerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SelectCustomerLink, logger)){
			return ssfTab_CSI_SelectCustomerLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer -- POP UP -- NEW Customer Selection RadioButton
	@FindBy(css="input[value='New']")
	private WebElement ssfTab_CSI_NewCustomerLink;
				
	public WebElement get_ssfTab_CSI_NewCustomerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_NewCustomerLink, logger)){
			return ssfTab_CSI_NewCustomerLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer -- POP UP -- NEW -- Customer Name Dropdown/TextBox
	@FindBy(css="input[ng-model='SelectedCustomerName']")
	private WebElement ssfTab_CSI_NewCustomerNameLink;
					
	public WebElement get_ssfTab_CSI_NewCustomerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_NewCustomerNameLink, logger)){
			return ssfTab_CSI_NewCustomerNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer -- POP UP -- EXISTING Customer Selection RadioButton
	@FindBy(css="input[name='IsNewCustomer'][value='Existing']")//
	private WebElement ssfTab_CSI_ExistingCustomerLink;
				
	public WebElement get_ssfTab_CSI_ExistingCustomerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_ExistingCustomerLink, logger)){
			return ssfTab_CSI_ExistingCustomerLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer -- POP UP --EXISTING --  Customer Name Dropdown/TextBox
	@FindBy(css="select[name='ddlCustName']")
	private WebElement ssfTab_CSI_ExistingCustomerNameLink;
				
	public WebElement get_ssfTab_CSI_ExistingCustomerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_ExistingCustomerNameLink, logger)){
			return ssfTab_CSI_ExistingCustomerNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer --  Customer Name TextBox
	@FindBy(css="input[automation-id='txtCustomerName']")
	private WebElement ssfTab_CSI_CustomerNameTextBoxLink;
				
	public WebElement get_ssfTab_CSI_CustomerNameTextBoxLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_CustomerNameTextBoxLink, logger)){
			return ssfTab_CSI_CustomerNameTextBoxLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Customer -- POP UP --SET button
	@FindBy(css="input[id='btnSetCustomer']")
	private WebElement ssfTab_CSI_SetCustomerNameLink;
				
	public WebElement get_ssfTab_CSI_SetCustomerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetCustomerNameLink, logger)){
			return ssfTab_CSI_SetCustomerNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility -- Button
	@FindBy(css="input[automation-id='btnSelectFacility']")//btnSelectFacility --- input[name='btnSelectFacility']
	private WebElement ssfTab_CSI_SetFacilityNameLink;
				
	public WebElement get_ssfTab_CSI_SetFacilityNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetFacilityNameLink, logger)){
			return ssfTab_CSI_SetFacilityNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility -- Facility Name TextBox
	@FindBy(css="input[automation-id='txtFacilityName'][name='txtFacilityName']")
	private WebElement ssfTab_CSI_FacilityNameTextBoxLink;
				
	public WebElement get_ssfTab_CSI_FacilityNameTextBoxLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_FacilityNameTextBoxLink, logger)){
			return ssfTab_CSI_FacilityNameTextBoxLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility - -- POP UP --- New Facility -- RadioButton
	@FindBy(css="input[name='IsNewFacility'][value='New']")
	private WebElement ssfTab_CSI_SetNewFacilityNameLink;
				
	public WebElement get_ssfTab_CSI_SetNewFacilityNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetNewFacilityNameLink, logger)){
			return ssfTab_CSI_SetNewFacilityNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility - -- POP UP --- New Facility -- Text Box
	@FindBy(css="input[automation-id='txtSelectedFacilityName']")
	private WebElement ssfTab_CSI_SetNewFacilityNameTextBoxLink;
				
	public WebElement get_ssfTab_CSI_SetNewFacilityNameTextBoxLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetNewFacilityNameTextBoxLink, logger)){
			return ssfTab_CSI_SetNewFacilityNameTextBoxLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility - -- POP UP --- Existing Facility -- RadioButton
	@FindBy(css="input[name='IsNewFacility'][value='Existing']")
	private WebElement ssfTab_CSI_SetExistingFacilityNameLink;
				
	public WebElement get_ssfTab_CSI_SetExistingFacilityNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetExistingFacilityNameLink, logger)){
			return ssfTab_CSI_SetExistingFacilityNameLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility - -- POP UP --- Existing Facility -- DropDown List
	@FindBy(xpath=".//*[@id='FacilityModal']/div/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[3]/select")// .//*[@id='FacilityModal']/div/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[3]/select  -- select[name='ddlFacilityNameT']
	private WebElement ssfTab_CSI_SetExistingFacilityDropDownLink;
				
	public WebElement get_ssfTab_CSI_SetExistingFacilityDropDownLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetExistingFacilityDropDownLink, logger)){
			return ssfTab_CSI_SetExistingFacilityDropDownLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Select Facility - -- POP UP --- Existing Facility -- SET Button
	@FindBy(css="input[id='btnSetFacility']")
	private WebElement ssfTab_CSI_SetFacilityLink;
				
	public WebElement get_ssfTab_CSI_SetFacilityLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SetFacilityLink, logger)){
			return ssfTab_CSI_SetFacilityLink;
		}else
			return null;
	}
	
	
	//The Customer & Site Information Section  -- Customer AR TextBox
	@FindBy(css="input[name='txtCustomerAR']")
	private WebElement ssfTab_CSI_CustomerARLink;
				
	public WebElement get_ssfTab_CSI_CustomerARLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_CustomerARLink, logger)){
			return ssfTab_CSI_CustomerARLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- CustomerTimeZOne TextBox
	@FindBy(css="select[name='ddlCustomerTimeZOne']")
	private WebElement ssfTab_CSI_CustomerTimeZOneLink;
				
	public WebElement get_ssfTab_CSI_CustomerTimeZOneLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_CustomerTimeZOneLink, logger)){
			return ssfTab_CSI_CustomerTimeZOneLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Manitou Account TextBox
	@FindBy(css="input[name='txtManitouAccount']")
	private WebElement ssfTab_CSI_ManitouAccountLink;
				
	public WebElement get_ssfTab_CSI_ManitouAccountLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_ManitouAccountLink, logger)){
			return ssfTab_CSI_ManitouAccountLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- NxGen/ServiceMax ID TextBox
	@FindBy(css="input[name='txtCustomerNextGen']")
	private WebElement ssfTab_CSI_CustomerNextGenLink;
				
	public WebElement get_ssfTab_CSI_CustomerNextGenLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_CustomerNextGenLink, logger)){
			return ssfTab_CSI_CustomerNextGenLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Address TextBox
	@FindBy(css="span > textarea[name='txtFacilityAddress']")
	private WebElement ssfTab_CSI_FacilityAddressLink;
				
	public WebElement get_ssfTab_CSI_FacilityAddressLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_FacilityAddressLink, logger)){
			return ssfTab_CSI_FacilityAddressLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Country DropDown
	@FindBy(css="select[name='ddlFaciltiyCounty']")
	private WebElement ssfTab_CSI_FaciltiyCountyLink;
				
	public WebElement get_ssfTab_CSI_FaciltiyCountyLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_FaciltiyCountyLink, logger)){
			return ssfTab_CSI_FaciltiyCountyLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- State DropDown
	@FindBy(css="select[name='ddlfacilityState']")
	private WebElement ssfTab_CSI_facilityStateLink;
				
	public WebElement get_ssfTab_CSI_facilityStateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_facilityStateLink, logger)){
			return ssfTab_CSI_facilityStateLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- City DropDown
	@FindBy(css="select[name='ddlfacilityCity']")
	private WebElement ssfTab_CSI_facilityCityLink;
				
	public WebElement get_ssfTab_CSI_facilityCityLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_facilityCityLink, logger)){
			return ssfTab_CSI_facilityCityLink;
		}else
			return null;
	}
	
	
	//The Customer & Site Information Section  -- Zip Code TextBox
	@FindBy(css="input[name='txtFacilityZipCode']")
	private WebElement ssfTab_CSI_FacilityZipCodeLink;
				
	public WebElement get_ssfTab_CSI_FacilityZipCodeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_FacilityZipCodeLink, logger)){
			return ssfTab_CSI_FacilityZipCodeLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Site Phone TextBox
	@FindBy(css="input[name='txtSitePhone']")
	private WebElement ssfTab_CSI_SitePhoneLink;
				
	public WebElement get_ssfTab_CSI_SitePhoneLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_SitePhoneLink, logger)){
			return ssfTab_CSI_SitePhoneLink;
		}else
			return null;
	}
	
	//The Customer & Site Information Section  -- Type of Business TextBox
	@FindBy(css="select[name='ddlfacilityVertical']")
	private WebElement ssfTab_CSI_facilityVerticalLink;
				
	public WebElement get_ssfTab_CSI_facilityVerticalLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CSI_facilityVerticalLink, logger)){
			return ssfTab_CSI_facilityVerticalLink;
		}else
			return null;
	}
	
	// #################################################  The Smart Connected Chiller Dashboard Section  #####################################3
	
	//The Smart Connected Chiller Dashboard Section  -- Expand Button
	@FindBy(css="span[id='spanFour']")
	private WebElement ssfTab_SCCDC_ExpandLink;
				
	public WebElement get_ssfTab_SCCDC_ExpandLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_ExpandLink, logger)){
			return ssfTab_SCCDC_ExpandLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- Add User Button
	@FindBy(css="input[id='btnUserSave']")
	private WebElement ssfTab_SCCDC_UserSaveLink;
				
	public WebElement get_ssfTab_SCCDC_UserSaveLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserSaveLink, logger)){
			return ssfTab_SCCDC_UserSaveLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- Add User Button -- L1 Impersonate Edit SSF PAge
	@FindBy(css="input[automation-id='btnAddUser']")
	private WebElement ssfTab_SCCDC_UserSaveLink_Impersonate;
				
	public WebElement get_ssfTab_SCCDC_UserSaveLink_Impersonate(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserSaveLink_Impersonate, logger)){
			return ssfTab_SCCDC_UserSaveLink_Impersonate;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- NAME- TextBox
	@FindBy(css="input[name='txtName']")
	private WebElement ssfTab_SCCDC_UserNameLink;
				
	public WebElement get_ssfTab_SCCDC_UserNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserNameLink, logger)){
			return ssfTab_SCCDC_UserNameLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- User Name - TextBox
	@FindBy(css="input[name='txtUserName'][automation-id='txtUserName']")
	private WebElement ssfTab_SCCDC_UserUserNameLink;
				
	public WebElement get_ssfTab_SCCDC_UserUserNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserUserNameLink, logger)){
			return ssfTab_SCCDC_UserUserNameLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- User Contact Number - TextBox
	@FindBy(css="input[automation-id='txtContactNumber']")
	private WebElement ssfTab_SCCDC_UserContactNoLink;
				
	public WebElement get_ssfTab_SCCDC_UserContactNoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserContactNoLink, logger)){
			return ssfTab_SCCDC_UserContactNoLink;
		}else
			return null;
	}
	
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- User Email - TextBox
	@FindBy(css="input[name='txtUserEmail']")
	private WebElement ssfTab_SCCDC_UserUserEmailLink;
				
	public WebElement get_ssfTab_SCCDC_UserUserEmailLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserUserEmailLink, logger)){
			return ssfTab_SCCDC_UserUserEmailLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- User Name - TextBox
	@FindBy(css="input[name='UserAdminType']")
	private WebElement ssfTab_SCCDC_UserAdminTypeLink;
				
	public WebElement get_ssfTab_SCCDC_UserAdminTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserAdminTypeLink, logger)){
			return ssfTab_SCCDC_UserAdminTypeLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- SAVE - Button
	@FindBy(css="input[value='Save'][name='SaveUseData']")
	private WebElement ssfTab_SCCDC_UserDetailsSaveLink;
				
	public WebElement get_ssfTab_SCCDC_UserDetailsSaveLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserDetailsSaveLink, logger)){
			return ssfTab_SCCDC_UserDetailsSaveLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- Update - Button
	@FindBy(css="input[automation-id='btnUpdateUseData']")
	private WebElement ssfTab_SCCDC_UserDetailsUpdateLink;
				
	public WebElement get_ssfTab_SCCDC_UserDetailsUpdateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserDetailsUpdateLink, logger)){
			return ssfTab_SCCDC_UserDetailsUpdateLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- CLOSE - Button
	@FindBy(css="input[value='Close'][name='btCloseOwnerDevice']")
	private WebElement ssfTab_SCCDC_UserDetailsCloseLink;
				
	public WebElement get_ssfTab_SCCDC_UserDetailsCloseLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserDetailsCloseLink, logger)){
			return ssfTab_SCCDC_UserDetailsCloseLink;
		}else
			return null;
	}
	
	//The Smart Connected Chiller Dashboard Section  -- User Details -- POP UP -- POP UP OK -- CLOSE - Button
	@FindBy(css="input[id='popup_ok']")
	private WebElement ssfTab_SCCDC_UserDetailsPopUpLink;
				
	public WebElement get_ssfTab_SCCDC_UserDetailsPopUpLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SCCDC_UserDetailsPopUpLink, logger)){
			return ssfTab_SCCDC_UserDetailsPopUpLink;
		}else
			return null;
	}
	
	//Check for Existing 
	
	// #################################################  The  Internet Connectivity Section  ######################################
	
	//The Internet Connectivity Section  -- Expand Button
	@FindBy(css="span[id='spanFive']")
	private WebElement ssfTab_IC_ExpandLink;
	
	public WebElement get_ssfTab_IC_ExpandLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_IC_ExpandLink, logger)){
			return ssfTab_IC_ExpandLink;
		}else
			return null;
	}
	
	//The Internet Connectivity Section  -- Connection Type -- Customer Network  RadioButton
	@FindBy(css="input[value='Customer Network']")
	private WebElement ssfTab_IC_CustomerNetworkLink;
	
	public WebElement get_ssfTab_IC_CustomerNetworkLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_IC_CustomerNetworkLink, logger)){
			return ssfTab_IC_CustomerNetworkLink;
		}else
			return null;
	}
	
	//The Internet Connectivity Section  -- Connection Type -- Cell Modem  RadioButton
	@FindBy(css="input[value='Cell Modem']")
	private WebElement ssfTab_IC_CellModemLink;
	
	public WebElement get_ssfTab_IC_CellModemLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_IC_CellModemLink, logger)){
			return ssfTab_IC_CellModemLink;
		}else
			return null;
	}
	
	//The Internet Connectivity Section  -- Connection Type -- Provider Name DropDown
	@FindBy(css="select[name='txProvider']")
	private WebElement ssfTab_IC_ProviderLink;
	
	public WebElement get_ssfTab_IC_ProviderLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_IC_ProviderLink, logger)){
			return ssfTab_IC_ProviderLink;
		}else
			return null;
	}
	
	//The Internet Connectivity Section  -- Connection Type -- Support line TextBox
	@FindBy(css="input[name='txtSupportLine']")
	private WebElement ssfTab_IC_SupportLineLink;
	
	public WebElement get_ssfTab_IC_SupportLineLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_IC_SupportLineLink, logger)){
			return ssfTab_IC_SupportLineLink;
		}else
			return null;
	}
	
	// #################################################  The  Equipment Section  ######################################
	
	//The Equipment Section  -- Expand Button
	@FindBy(css="span[id='spanSix']")
	private WebElement ssfTab_Equip_ExpandLink;
		
	public WebElement get_ssfTab_Equip_ExpandLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ExpandLink, logger)){
			return ssfTab_Equip_ExpandLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Equipment Type DropDown
	@FindBy(css="select[name='ddlEquipmentType']")
	private WebElement ssfTab_Equip_EquipmentTypeLink;
		
	public WebElement get_ssfTab_Equip_EquipmentTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_EquipmentTypeLink, logger)){
			return ssfTab_Equip_EquipmentTypeLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add Button
	@FindBy(css="input[value='Add'][name='btnAddChiller']")
	private WebElement ssfTab_Equip_AddChillerLink;
		
	public WebElement get_ssfTab_Equip_AddChillerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AddChillerLink, logger)){
			return ssfTab_Equip_AddChillerLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Asset Name -- TextBox
	@FindBy(css="input[name='txtAssetName']")
	private WebElement ssfTab_Equip_AssetNameink;
		
	public WebElement get_ssfTab_Equip_AssetNameink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AssetNameink, logger)){
			return ssfTab_Equip_AssetNameink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Unit of Measure -- Metric -- RadioButton
	@FindBy(css="input[value='Metric']")
	private WebElement ssfTab_Equip_MetricLink;
		
	public WebElement get_ssfTab_Equip_MetricLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_MetricLink, logger)){
			return ssfTab_Equip_MetricLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Unit of Measure -- Imperial -- RadioButton
	@FindBy(css="input[value='Imperial']")
	private WebElement ssfTab_Equip_ImperialLink;
		
	public WebElement get_ssfTab_Equip_ImperialLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ImperialLink, logger)){
			return ssfTab_Equip_ImperialLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Make -- DropDown
	@FindBy(css="select[name='ddlMake']")
	private WebElement ssfTab_Equip_AssetMakeLink;
		
	public WebElement get_ssfTab_Equip_AssetMakeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AssetMakeLink, logger)){
			return ssfTab_Equip_AssetMakeLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Model Group -- DropDown
	@FindBy(css="select[name='ddlModelGroup']")
	private WebElement ssfTab_Equip_ModelGroupLink;
		
	public WebElement get_ssfTab_Equip_ModelGroupLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ModelGroupLink, logger)){
			return ssfTab_Equip_ModelGroupLink;
		}else
			return null;
	}	
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Control Panel -- DropDown
	@FindBy(css="select[name='ddlControlPanel']")
	private WebElement ssfTab_Equip_ControlPanelLink;
		
	public WebElement get_ssfTab_Equip_ControlPanelLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ControlPanelLink, logger)){
			return ssfTab_Equip_ControlPanelLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Model -- DropDown
	@FindBy(css="select[name='ddlModel']")
	private WebElement ssfTab_Equip_ModelLink;
		
	public WebElement get_ssfTab_Equip_ModelLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ModelLink, logger)){
			return ssfTab_Equip_ModelLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Model # -- DropDown
	@FindBy(css="input[name='txtModelNo']")
	private WebElement ssfTab_Equip_ModelNoLink;
		
	public WebElement get_ssfTab_Equip_ModelNoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_ModelNoLink, logger)){
			return ssfTab_Equip_ModelNoLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Serial # -- DropDown
	@FindBy(css="input[name='txtSerial']")
	private WebElement ssfTab_Equip_SerialLink;
		
	public WebElement get_ssfTab_Equip_SerialLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_SerialLink, logger)){
			return ssfTab_Equip_SerialLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Asset # -- DropDown
	@FindBy(css="input[name='txtAssetNo']")
	private WebElement ssfTab_Equip_AssetNoLink;
		
	public WebElement get_ssfTab_Equip_AssetNoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AssetNoLink, logger)){
			return ssfTab_Equip_AssetNoLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Asset MAC Address -- DropDown
	@FindBy(css="input[name='txtMacAddress']")
	private WebElement ssfTab_Equip_MacAddressLink;
		
	public WebElement get_ssfTab_Equip_MacAddressLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_MacAddressLink, logger)){
			return ssfTab_Equip_MacAddressLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Connected to local BAS -- YES -- DropDown
	@FindBy(css="input[value='Yes']")
	private WebElement ssfTab_Equip_BASyesLink;
		
	public WebElement get_ssfTab_Equip_BASyesLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_BASyesLink, logger)){
			return ssfTab_Equip_BASyesLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- Connected to local BAS -- NO -- DropDown
	@FindBy(css="input[value='No']")
	private WebElement ssfTab_Equip_BASnoLink;
		
	public WebElement get_ssfTab_Equip_BASnoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_BASnoLink, logger)){
			return ssfTab_Equip_BASnoLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- SAVE -- Button
	@FindBy(css="input[id='btSaveAsset']")
	private WebElement ssfTab_Equip_SaveAssetLink;
		
	public WebElement get_ssfTab_Equip_SaveAssetLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_SaveAssetLink, logger)){
			return ssfTab_Equip_SaveAssetLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- CANCEL -- Button
	@FindBy(css="input[id='btCloseAsset']")
	private WebElement ssfTab_Equip_CloseAssetLink;
		
	public WebElement get_ssfTab_Equip_CloseAssetLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_CloseAssetLink, logger)){
			return ssfTab_Equip_CloseAssetLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- POP UP  -- Button
	@FindBy(css="input[id='popup_ok']")
	private WebElement ssfTab_Equip_AssetPopUpLink;
		
	public WebElement get_ssfTab_Equip_AssetPopUpLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AssetPopUpLink, logger)){
			return ssfTab_Equip_AssetPopUpLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- POP UP  -- UPDATE Button
	@FindBy(css="input[automation-id='btnUpdateAsset']")
	private WebElement ssfTab_Equip_AssetUpdateLink;
		
	public WebElement get_ssfTab_Equip_AssetUpdateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equip_AssetUpdateLink, logger)){
			return ssfTab_Equip_AssetUpdateLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- POP UP  -- Mendatory Fields Section
	@FindBy(css="input[automation-id='btnUpdateAsset']")
	private WebElement ssfTab_Equip_AssetMendatoryLink;
		
	public WebElement get_ssfTab_Equip_AssetMendatoryLink(){
		if(waitForElementPresent(driver, ssfTab_Equip_AssetMendatoryLink, logger)){
			return ssfTab_Equip_AssetMendatoryLink;
		}else
			return null;
	}
	
	
	// #################################################  The  Equipment GRID Section  ######################################
	
	//The Asset Name -- Read the NAMEs -- WebElement of the Table that contains the results!
	@FindBy(css="table[automation-id='tblAssetTable']")
	private WebElement ssfTab_Equipment_AssetTableLink;
		
	public WebElement get_ssfTab_Equipment_AssetTableLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equipment_AssetTableLink, logger)){
			return ssfTab_Equipment_AssetTableLink;
		}else
			return null;
	}
	
	//The Asset Name -- Read the NAMEs -- WebElement of the Table that contains the results!
	@FindBy(css="table[automation-id='tblAssetTable']")
	private WebElement ssfTab_Equipment_AssetNameLink;
		
	public WebElement get_ssfTab_Equipment_AssetNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Equipment_AssetNameLink, logger)){
			return ssfTab_Equipment_AssetNameLink;
		}else
			return null;
	}
	
	// #################################################  The  Bottom Section  ######################################
	
	//The Bottom Section  -- NOTES -- TextBox
	@FindBy(css="textarea[automation-id='txtNotes']")
	private WebElement ssfTab_Bottom_TextNotesLink;
		
	public WebElement get_ssfTab_Bottom_TextNotesLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_TextNotesLink, logger)){
			return ssfTab_Bottom_TextNotesLink;
		}else
			return null;
	}
	
	//The Bottom Section  -- SAVE -- Button
	@FindBy(css="input[automation-id='btnSave']") //input[automation-id='btnSSFSave'] --- input[name='btnSave']
	private WebElement ssfTab_Bottom_SaveBtnLink;
		
	public WebElement get_ssfTab_Bottom_SaveBtnLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SaveBtnLink, logger)){
			return ssfTab_Bottom_SaveBtnLink;
		}else
			return null;
	}
	
	//The Bottom Section  -- SAVE -- GRID SAVE--  Button//btnSSFSave
	@FindBy(css="input[automation-id='btnSSFSave']") //input[automation-id='btnSSFSave'] --- input[name='btnSave']
	private WebElement ssfTab_Bottom_SaveBtnSSFLink;
		
	public WebElement get_ssfTab_Bottom_SaveBtnSSFLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SaveBtnSSFLink, logger)){
			return ssfTab_Bottom_SaveBtnSSFLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- SUBMIT -- Button
	@FindBy(css="input[automation-id='btnSubmit']") // automation-id='btnSubmit' -- value='Submit'
	private WebElement ssfTab_Bottom_SubmitLink;
		
	public WebElement get_ssfTab_Bottom_SubmitLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SubmitLink, logger)){
			return ssfTab_Bottom_SubmitLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- SUBMIT -- SSF SUBMIT -- Button
	@FindBy(css="input[automation-id='btnSSFSubmitted']") // automation-id='btnSubmit' -- value='Submit'
	private WebElement ssfTab_Bottom_SSFGridSubmitLink;
		
	public WebElement get_ssfTab_Bottom_SSFGridSubmitLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SSFGridSubmitLink, logger)){
			return ssfTab_Bottom_SSFGridSubmitLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- CANCEL -- Button
	@FindBy(css="input[value='Cancel']")
	private WebElement ssfTab_Bottom_CancelLink;
		
	public WebElement get_ssfTab_Bottom_CancelLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_CancelLink, logger)){
			return ssfTab_Bottom_CancelLink;
		}else
			return null;
	}
	
	//The Equipment Section  -- Add -- POP UP -- Asset Details -- POP UP  -- Button
	@FindBy(css="input[id='popup_ok']")
	private WebElement ssfTab_SaveConfirmLink;
		
	public WebElement get_ssfTab_SaveConfirmLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SaveConfirmLink, logger)){
			return ssfTab_SaveConfirmLink;
		}else
			return null;
	}
	
	//The END -- Mendatory Fields Section RED Comment 
	@FindBy(css="#accordion > div.panel-body1 > div > div > div:nth-child(2) > div > span > label")
	private WebElement ssfTab_MendatoryFieldsLink;
		
	public WebElement get_ssfTab_MendatoryFieldsLink(){
		if(waitForElementPresent(driver, ssfTab_MendatoryFieldsLink, logger)){
			return ssfTab_MendatoryFieldsLink;
		}else
			return null;
	}
	
}
