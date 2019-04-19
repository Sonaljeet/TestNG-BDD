package mars.JCI.Project.DES.Site;

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

import commonFunctions.WebElementCommon;

public class DES_Site_Page_Factory {
	/** The WebDriver driver. */
	private static WebDriver driver;
	/** The ExtentTest logger. */
	private static ExtentTest logger;

	public DES_Site_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	public static boolean waitForElementPresent(WebDriver driver,WebElement webElement,ExtentTest logger) throws TimeoutException{
		try{
		 // Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(15, TimeUnit.SECONDS)
		       .pollingEvery(1, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);
		   fluentWait.until(ExpectedConditions.visibilityOf(webElement));
		return true;
		}catch (NullPointerException e){
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		
		}catch (TimeoutException e){
			logger.log(LogStatus.ERROR, "Failled! --"+e.getMessage().substring(0,150));
			return false;
		}catch (Exception e){
			logger.log(LogStatus.ERROR, "Failled! --"+e.getMessage().substring(0,150));
			return false;
		}
	}
	
	/**Site Tab element*/
	@FindBy(css="a[automation-id='siteTab']")
	WebElement siteTab;
	
	public WebElement getSiteTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, siteTab, logger) == true) {
			element = siteTab;
		}
		return element;
	}
	
	/**Site Name Textbox*/
	@FindBy(css="input[automation-id='siteName']")
	WebElement siteNameTexBox;
	
	public WebElement getSiteNameTextBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteNameTexBox, logger)==true){
			element=siteNameTexBox;
		}
		return element;
	}
	
	/**Site AbbreviationTexBox*/
	@FindBy(css="input[automation-id='siteAbbreviation']")
	WebElement siteAbbreviationTexBox;
	
	public WebElement getsiteAbbreviationTexBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteAbbreviationTexBox, logger)==true){
			element=siteAbbreviationTexBox;
		}
		return element;
	}

	/**siteAddress1 TexBox*/
	@FindBy(css="input[automation-id='siteAddress1']")
	WebElement siteAddress1TexBox;
	
	public WebElement getsiteAddress1TexBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteAddress1TexBox, logger)==true){
			element=siteAddress1TexBox;
		}
		return element;
	}
	
	/**siteAddress2 TexBox*/
	@FindBy(css="input[automation-id='siteAddress2']")
	WebElement siteAddress2TexBox;
	
	public WebElement getsiteAddress2TexBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteAddress2TexBox, logger)==true){
			element=siteAddress2TexBox;
		}
		return element;
	}

	/**sitedrpdwnSiteCountry TexBox*/
	@FindBy(css="select[automation-id='drpdwnSiteCountry']")
	WebElement sitedrpdwnSiteCountry;
	
	public WebElement getsitedrpdwnSiteCountry(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitedrpdwnSiteCountry, logger)==true){
			element=sitedrpdwnSiteCountry;
		}
		return element;
	}
	
	/**sitedrpdwnsiteStates TexBox*/
	@FindBy(css="select[automation-id='drpdwnsiteStates']")
	WebElement sitedrpdwnsiteStates;
	
	public WebElement getsitedrpdwnsiteStates(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitedrpdwnsiteStates, logger)==true){
			element=sitedrpdwnsiteStates;
		}
		return element;
	}

	/**sitedrpdwnsiteStates TexBox*/
	@FindBy(css="select[automation-id='drpdwnsiteCities']")
	WebElement sitedrpdwnsiteCities;
	
	public WebElement getsitedrpdwnsiteCities(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitedrpdwnsiteCities, logger)==true){
			element=sitedrpdwnsiteCities;
		}
		return element;
	}
	
	/**Site zipcode TexBox*/
	@FindBy(css="input[automation-id='siteZipcode']")
	WebElement siteZipCode;
	
	public WebElement getsiteZipCodeTextbox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteZipCode, logger)==true){
			element=siteZipCode;
		}
		return element;
	}
	
	/**Site start date*/
	@FindBy(css="input[automation-id='siteStartDate']")
	WebElement siteStartDate;
	
	public WebElement getsiteStartDate(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteStartDate, logger)==true){
			element=siteStartDate;
		}
		return element;
	}

	/**Site End date*/
	@FindBy(css="input[automation-id='siteEndDate']")
	WebElement siteEndDate;
	
	public WebElement getsiteEndDate(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteEndDate, logger)==true){
			element=siteEndDate;
		}
		return element;
	}
	
	/**site Latitude*/
	@FindBy(css="input[automation-id='siteLatitude']")
	WebElement siteLatitude;
	
	public WebElement getsiteLatitude(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteLatitude, logger)==true){
			element=siteLatitude;
		}
		return element;
	}
	
	/**site Longitude*/
	@FindBy(css="input[automation-id='siteLongitude']")
	WebElement siteLongitude;
	
	public WebElement getsiteLongitude(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteLongitude, logger)==true){
			element=siteLongitude;
		}
		return element;
	}
	
	/**site Commissioning Date*/
	@FindBy(css="input[automation-id='siteCommissioningDate']")
	WebElement siteCommissioningDate;
	
	public WebElement getsiteCommissioningDate(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteCommissioningDate, logger)==true){
			element=siteCommissioningDate;
		}
		return element;
	}
	
	/**site Allocated kwH*/
	@FindBy(css="input[automation-id='allocatedkwh']")
	WebElement allocatedkwh;
	
	public WebElement getallocatedkwh(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, allocatedkwh, logger)==true){
			element=allocatedkwh;
		}
		return element;
	}
	
	/**site Logo*/
	@FindBy(css="img[id='viewLogo']")
	WebElement siteLogo;
	
	public WebElement getsiteLogo(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteLogo, logger)==true){
			element=siteLogo;
		}
		return element;
	}
	
	/**select site Logo*/
	@FindBy(css="input[automation-id='siteLogo']")
	WebElement selectSiteLogo;
	
	public WebElement getselectSiteLogo(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, selectSiteLogo, logger)==true){
			element=selectSiteLogo;
		}
		return element;
	}
	
	/**site Primary Name*/
	@FindBy(css="input[automation-id='sitePrimaryName']")
	WebElement sitePrimaryName;
	
	public WebElement getsitePrimaryName(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitePrimaryName, logger)==true){
			element=sitePrimaryName;
		}
		return element;
	}
	
	/**site Primary Designation*/
	@FindBy(css="input[automation-id='sitePrimaryDesignation']")
	WebElement sitePrimaryDesignation;
	
	public WebElement getsitePrimaryDesignation(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitePrimaryDesignation, logger)==true){
			element=sitePrimaryDesignation;
		}
		return element;
	}
	
	/**site Primary ContactNumber*/
	@FindBy(css="input[automation-id='sitePrimaryContactNumber']")
	WebElement sitePrimaryContactNumber;
	
	public WebElement getsitePrimaryContactNumber(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitePrimaryContactNumber, logger)==true){
			element=sitePrimaryContactNumber;
		}
		return element;
	}
	
	/**site Primary Email*/
	@FindBy(css="input[automation-id='sitePrimaryEmail']")
	WebElement sitePrimaryEmail;
	
	public WebElement getsitePrimaryEmail(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, sitePrimaryEmail, logger)==true){
			element=sitePrimaryEmail;
		}
		return element;
	}
	
	/**drpdwn Site GatewayId*/
	@FindBy(css="select[automation-id='drpdwnSiteGatewayId']")
	WebElement drpdwnSiteGatewayId;
	
	public WebElement getdrpdwnSiteGatewayId(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, drpdwnSiteGatewayId, logger)==true){
			element=drpdwnSiteGatewayId;
		}
		return element;
	}
	
	/**site Save Button*/
	@FindBy(css="button[automation-id='btnSaveSite']")
	WebElement siteSaveButton;
	
	public WebElement getsiteSaveButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteSaveButton, logger)==true){
			element=siteSaveButton;
		}
		return element;
	}
	
	/** Get success message*/
	@FindBy(css = "div[class='growl-message ng-binding']")
	private WebElement siteSuccessMessage;

	public WebElement getsiteSuccessMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, siteSuccessMessage, logger) == true) 
		{
			element = siteSuccessMessage;
		}
		return element;
	}
	
	/**customer menu*/
	@FindBy(css="span[automation-id='spnCustomer']")
	WebElement customerLabel;
	
	public WebElement getcustomerLabel(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, customerLabel, logger)==true){
			element=customerLabel;
		}
		return element;
	}
	
	/**Add site button*/
	@FindBy(css="button[automation-id='btnAddSite']")
	WebElement siteAddButton;
	
	public WebElement getsiteAddButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteAddButton, logger)==true){
			element=siteAddButton;
		}
		return element;
	}
	
	/**Get the Group*/
	@FindBy(xpath="(//div[@id='treeTemplateDiv'])[2]")
	WebElement firstGroupOfCustomer;
	
	public WebElement getfirstGroupOfCustomer(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, firstGroupOfCustomer, logger)==true){
			element=firstGroupOfCustomer;
		}
		return element;
	}
	
	/**site Delete button*/
	@FindBy(css="button[automation-id='btnDeleteSite']")
	WebElement siteDeleteButton;
	
	public WebElement getsiteDeleteButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteDeleteButton, logger)==true){
			element=siteDeleteButton;
		}
		return element;
	}
	
	/**pop up OK Delete button*/
	@FindBy(id="popup_ok")
	WebElement okDeleteButton;
	
	public WebElement getOkDeleteButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, okDeleteButton, logger)==true){
			element=okDeleteButton;
		}
		return element;
	}
	
	/**pop up CANCEL Delete button*/
	@FindBy(id="popup_cancel")
	WebElement cancelDeleteButton;
	
	public WebElement getcancelDeleteButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, cancelDeleteButton, logger)==true){
			element=cancelDeleteButton;
		}
		return element;
	}
	/**customer dropdown*/
	@FindBy(css="select[automation-id='drpdwnsiteCustomers']")
	WebElement drpdwnsiteCustomers;
	
	public WebElement getdrpdwnsiteCustomers(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, drpdwnsiteCustomers, logger)==true){
			element=drpdwnsiteCustomers;
		}
		return element;
	}
	
}
