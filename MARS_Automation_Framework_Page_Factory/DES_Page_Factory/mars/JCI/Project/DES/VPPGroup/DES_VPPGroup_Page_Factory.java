package mars.JCI.Project.DES.VPPGroup;

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

public class DES_VPPGroup_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	
	public DES_VPPGroup_Page_Factory(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
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
	
	/**VPP Group Tab element*/
	@FindBy(css="a[automation-id='geoTab']")
	WebElement groupTab;
	
	public WebElement getgroupTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, groupTab, logger) == true) {
			element = groupTab;
		}
		return element;
	}
	
	/**VPP Group Name element*/
	@FindBy(css="input[automation-id='geographyGrpName']")
	WebElement groupNameTextbox;
	
	public WebElement getgroupNameTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, groupNameTextbox, logger) == true) {
			element = groupNameTextbox;
		}
		return element;
	}
	
	/**VPP Group/geography Abbreviation element*/
	@FindBy(css="input[automation-id='geographyAbbreviation']")
	WebElement groupAbbriviationTextbox;
	
	public WebElement getgroupAbbriviationTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, groupAbbriviationTextbox, logger) == true) {
			element = groupAbbriviationTextbox;
		}
		return element;
	}
	
	/**VPP Group/geography Country element*/
	@FindBy(css="select[automation-id='drpdwnCountry']")
	WebElement groupCountryDropdown;
	
	public WebElement getgroupCountryDropdown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, groupCountryDropdown, logger) == true) {
			element = groupCountryDropdown;
		}
		return element;
	}
	
	/**VPP Group/geography Save button element*/
	@FindBy(css="button[automation-id='btngeographySave']")
	WebElement groupSaveButton;
	
	public WebElement getgroupSaveButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, groupSaveButton, logger) == true) {
			element = groupSaveButton;
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
	
	/**Add Group button*/
	@FindBy(css="button[automation-id='btngeographyAdd']")
	WebElement groupAddButton;
	
	public WebElement getgroupAddButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, groupAddButton, logger)==true){
			element=groupAddButton;
		}
		return element;
	}
	
	/**Group Delete button*/
	@FindBy(css="button[automation-id='btngeographydelete']")
	WebElement groupDeleteButton;
	
	public WebElement getgroupDeleteButton(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, groupDeleteButton, logger)==true){
			element=groupDeleteButton;
		}
		return element;
	}
	
	/**customer dropdown*/
	@FindBy(css="select[automation-id='drpdwncustomer']")
	WebElement drpdwnCustomers;
	
	public WebElement getdrpdwnCustomers(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, drpdwnCustomers, logger)==true){
			element=drpdwnCustomers;
		}
		return element;
	}

	/** Get success message*/
	@FindBy(css = "div[class='growl-message ng-binding']")
	private WebElement vppGroupSuccessMessage;

	public WebElement getsiteSuccessMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, vppGroupSuccessMessage, logger) == true) 
		{
			element = vppGroupSuccessMessage;
		}
		return element;
	}

	
	@FindBy(css = "input[id='popup_ok']")
	private WebElement okButton;
	public WebElement getOkButton() {
		// TODO Auto-generated method stub
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, okButton, logger) == true) 
		{
			element = okButton;
		}
		return element;
	}
	
	@FindBy(css = "input[id='popup_cancel']")
	private WebElement cancelButton;
	public WebElement getcancelButton() {
		// TODO Auto-generated method stub
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, cancelButton, logger) == true) 
		{
			element = cancelButton;
		}
		return element;
	}
	
	@FindBy(css="div[id='spanDragSites']")
	private WebElement siteDropBox;
	
	public WebElement getSiteDropBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, siteDropBox, logger) ==true)
		{
			element=siteDropBox;
		}
		return element;
	}
	
	@FindBy(css="td[title='Remove Site']")
	private WebElement removeSitefromDropBox;
	
	public WebElement getremoveSitefromDropBox(){
		WebElement element=null;
		if(WebElementCommon.waitForElementPresent(driver, removeSitefromDropBox, logger) ==true)
		{
			element=removeSitefromDropBox;
		}
		return element;
	}

}
