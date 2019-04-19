package mars.JCI.Project.VERASYS.SetUp;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.BaseClass;

public class VERASYS_Setup_Site_Page_Action {
	/** The Selenium driver. */
	public WebDriver driver;

	/** The ExtentTest logger. */
	private ExtentTest logger;

	/** The WebElement/Locator element. */
	private WebElement element;

	/** The WebElements/Locator elements. */
	private List<WebElement> elements;



	/**
	 * Instantiates/Constructor a new Verasys Site page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public VERASYS_Setup_Site_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/**
	 * Verify Customer Tab is Highlighted.
	 *
	 * @return boolean
	 */
	public void clickCustomerTab(){
		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteTab();
		if(element!= null){
			element.click();
		}else
		{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Tab Field Failed");   
		}

	}

	/**
	 * Select Active customer from drop down.
	 *
	 * @param Customer name
	 * 
	 * @return None
	 */
	public void selectCustomer(String customerName) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getCustomerDropDown(); 
		if(element!= null){
			if(!element.isSelected()){
				WebElementCommon.waitForTextToAppear(driver, customerName, element, logger);
				element.click();
				WebDropDown.SelectElementByVisibleText(element, customerName);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
				logger.log(LogStatus.PASS, "Successfully selected Customer from the drop down as "+customerName);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Customer field is present but already populated");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Field Failed");   
		}

	}
	/**
	 * Enter Site Name.
	 *
	 * @param Site Name
	 * 
	 * @return None
	 */
	public void enterSiteName(String siteName) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteName();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, siteName);
				logger.log(LogStatus.PASS, "successfully Entered Site Name as "+siteName);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site Name field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Name Field Failed");   
		}

	}

	/**
	 * Enter Site ID.
	 *
	 * @param Site ID
	 * 
	 * @return None
	 */
	public void enterSiteID(String siteID) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteId();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, siteID);
				logger.log(LogStatus.PASS, "Successfully Entered Site ID as "+"Auto"+siteID);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site ID field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site ID Field Failed");   
		}

	}
	/**
	 * Enter Site Address1.
	 *
	 * @param Site Address1
	 * 
	 * @return None
	 */
	public void enterAddress1(String Address1) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getsiteAddress1();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, Address1);
				logger.log(LogStatus.PASS, "successfully Entered Site Address1 as "+Address1);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site Address1 field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Address1 Field Failed");   
		}
	}

	/**
	 * Enter Site Address2.
	 *
	 * @param Site Address2
	 * 
	 * @return None
	 */
	public void enterAddress2(String Address2) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getsiteAddress2();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, Address2);
				logger.log(LogStatus.PASS, "successfully Entered Site Address2 as "+Address2);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site Address2 field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Address2 Field Failed");   
		}
	}
	/**
	 * Select Country from drop down.
	 *
	 * @param Country name
	 * 
	 * @return None
	 */
	public void selectCountry(String Country) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		WebElementCommon.staticWait(100);
		element=setupSite.getSiteCountry();
		if(element!= null){
			if(!element.isSelected()){
				Select select = new Select(element);  
				List<WebElement> options = select.getOptions(); 
				customerPA.waitUntilSelectOptionsPopulated(select);
				if(options.size()>0){
					//WebElementCommon.waitForTextToAppear(driver, Country, element, logger);
					element.click();
					WebDropDown.SelectElementByVisibleText(element, Country);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
					logger.log(LogStatus.PASS, "Successfully selected Country from the drop down as "+Country);  
				}else{
					logger.log(LogStatus.FAIL, "Verified Country field is present but already populated");  
				}
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Country Field Failed");   
		}
	}

	/**
	 * Verify Country drop down is disabled.
	 *
	 * 
	 * @return None
	 */
	public void verifySiteName() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		WebElementCommon.staticWait(100);
		element=setupSite.getSiteName();
		if(element!=null){
			if(!element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified site name is Disabled and Populated as "+element.getAttribute("innerText"));  
			}else{
				logger.log(LogStatus.FAIL, "Verified site name field is present but enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for site name Field Failed");   
		}
	}

	/**
	 * Verify Country drop down is disabled.
	 *
	 * 
	 * @return None
	 */
	public void verifyCountry() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		WebElementCommon.staticWait(100);
		element=setupSite.getSiteCountry();
		Select select = new Select(element);
		if(select.getFirstSelectedOption()!=null){
			if(!element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified Country drop down is Disabled and Populated as "+element.getAttribute("innerText"));  
			}else{
				logger.log(LogStatus.FAIL, "Verified Country field is present but enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified Country field is NOT selected");   
		}
	}

	/**
	 * Verify State drop down is disabled.
	 *
	 * 
	 * @return None
	 */
	public void verifyState() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		WebElementCommon.staticWait(100);
		element=setupSite.getSiteState();
		Select select = new Select(element);
		if(select.getFirstSelectedOption()!=null){
			if(!element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified State drop down is Disabled and Populated as "+element.getAttribute("innerText"));  
			}else{
				logger.log(LogStatus.FAIL, "Verified State field is present but enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified State field is NOT selected");   
		}
	}

	/**
	 * Verify City drop down is disabled.
	 *
	 * 
	 * @return None
	 */
	public void verifyCity() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		WebElementCommon.staticWait(100);
		element=setupSite.getSiteCity();
		Select select = new Select(element);
		if(select.getFirstSelectedOption()!=null)
		{
			if(!element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified City drop down is Disabled and Populated as "+element.getAttribute("innerText"));  
			}else{
				logger.log(LogStatus.FAIL, "Verified City field is present but enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified City field is NOT selected");   
		}
	}

	/**
	 * Select State.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void selectState() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		element=setupSite.getSiteState();
		if(element!= null){
			//WebElementCommon.waitForTextToAppear(driver, "Alabama", element, logger);
			if(!element.isSelected()){

				Select select = new Select(element);  
				List<WebElement> options = select.getOptions(); 
				customerPA.waitUntilSelectOptionsPopulated(select);
				if(options.size()>0){
					WebDropDown.SelectElementByIndex(element, 2);

					logger.log(LogStatus.PASS, "Successfully selected State from the drop down");  
				}else{
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); //nullify implicitlyWait() 
					logger.log(LogStatus.FAIL, "State Drop Down is empty"); 
				}

			}else{
				logger.log(LogStatus.FAIL, "Verified State field is present but already populated");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site State Field Failed");   
		}

	}

	/**
	 * Click State Field.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickState() {
		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteState();
		if(element!= null){
			element.click();
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site State Field Failed");   
		}
	}

	/**
	 * Click City Field.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickCity() {
		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteCity();
		if(element!= null){
			element.click();
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site City Field Failed");   
		}

	}

	/**
	 * Enter City.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void selectCity() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		element=setupSite.getSiteCity();
		if(element!= null){
			if(!element.isSelected()){
				Select select = new Select(element);  
				customerPA.waitUntilSelectOptionsPopulated(select);
				WebDropDown.SelectElementByIndex(element, 1);
				logger.log(LogStatus.PASS, "Successfully selected City from the drop down as "+element.getText());  
			}else{
				logger.log(LogStatus.FAIL, "Verified City field is present but already populated");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Customer City Field Failed");   
		}
	}

	/**
	 * Enter Zipcode.
	 *
	 * @param Zipcode
	 * 
	 * @return None
	 */
	public void enterZipcode(String zipCode) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteZipcode();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, zipCode);
				logger.log(LogStatus.PASS, "Successfully entered Zipcode as "+zipCode);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Zipcode field is present but NOT Enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Zipcode Field Failed");   
		}
	}
	/**
	 * Enter Start Date.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void enterStartDate(String startDate) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getStartDate();
		if(element!= null){
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",element);
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, startDate);
				logger.log(LogStatus.PASS, "Successfully entered Start Date as "+startDate);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Start Date field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Start Date Field Failed");   
		}	
	}

	/**
	 * Enter End Date.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void enterEndDate(String endDate) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getEndDate();
		if(element!= null){
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",element);
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, endDate);
				logger.log(LogStatus.PASS, "Successfully entered End Date as "+endDate);  
			}else{
				logger.log(LogStatus.FAIL, "Verified End Date field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for End Date Field Failed");   
		}	
	}

	/**
	 * Enter Primary Contact Name.
	 *
	 * @param Primary Contact Name
	 * 
	 * @return None
	 */
	public void enterPrimContactName(String PrimContactName) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getPrimName();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				if(!element.getText().isEmpty()){
					logger.log(LogStatus.INFO, "Primary Contact Name is Populated as "+element.getText().toString());  
					element.clear();
				}
				WebInputTextBox.SendInputTextBox(driver, element, PrimContactName);
				logger.log(LogStatus.PASS, "Successfully Entered Primary Contact Name as "+PrimContactName);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site Primary Contact Name field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Primary Contact Name Field Failed");   
		}
	}

	/**
	 * Enter Primary Contact Title.
	 *
	 * @param Primary Contact Title text
	 * 
	 * @return None
	 */
	public void enterPrimTitle(String contactTitle) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getPrimDesignation();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, contactTitle);
				logger.log(LogStatus.PASS, "Successfully entered Primary Contact Title as"+contactTitle);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Primary Contact Title field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Primary Contact Title Field Failed");   
		}	
	}

	/**
	 * Enter Primary Contact Number.
	 *
	 * @param Primary Contact Number text
	 * 
	 * @return None
	 */
	public void enterPrimContact(String contactNo) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getPrimContact();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, contactNo);
				logger.log(LogStatus.PASS, "Successfully entered Primary Contact Number "+contactNo);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Primary Contact Number field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Primary Contact Number Field Failed");   
		}	
	}

	/**
	 * Enter Primary Contact email.
	 *
	 * @param Primary Contact email text
	 * 
	 * @return None
	 */
	public void enterPrimEmail(String primeMail) {
		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getPrimEmail();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, primeMail);
				logger.log(LogStatus.PASS, "Successfully entered Primary Contact Email as "+primeMail);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Primary Contact Email field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Primary Contact Email Field Failed");   
		}	
	}
	/**
	 * Enter Secondary Contact Name.
	 *
	 * @param Secondary Contact Name
	 * 
	 * @return None
	 */
	public void enterSecContactName(String SecContactName) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSecName();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, SecContactName);
				logger.log(LogStatus.PASS, "Successfully Entered Secondary Contact Name as"+SecContactName);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Site Secondary Contact Name field is present but NOT enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Secondary Contact Name Field Failed");   
		}
	}
	/**
	 * Enter Secondary Contact Title.
	 *
	 * @param Secondary Contact Title text
	 * 
	 * @return None
	 */
	public void enterSecTitle(String contactTitle) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSecDesignation();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, contactTitle);
				logger.log(LogStatus.PASS, "Successfully entered Secondary Contact Title as"+contactTitle);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Secondary Contact Title field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Secondary Contact Title Field Failed");   
		}	
	}

	/**
	 * Enter Secondary Contact Number.
	 *
	 * @param Secondary Contact Number text
	 * 
	 * @return None
	 */
	public void enterSecContact(String contactNo) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSecContact();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, contactNo);
				logger.log(LogStatus.PASS, "Successfully entered Secondary Contact Number as"+contactNo);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Secondary Contact Number field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Secondary Contact Number Field Failed");   
		}	
	}

	/**
	 * Enter Secondary Contact email.
	 *
	 * @param Secondary Contact email text
	 * 
	 * @return None
	 */
	public void enterSecEmail(String secMail) {
		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSecEmail();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebInputTextBox.SendInputTextBox(driver, element, secMail);
				logger.log(LogStatus.PASS, "Successfully entered Primary Contact Email as"+secMail);  
			}else{
				logger.log(LogStatus.FAIL, "Verified Secondary Contact Email field is present but NOT enabled");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Secondary Contact Email Field Failed");   
		}	
	}
	/**
	 * Click Add to add site to the customer.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickAdd() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		element=setupSite.getSiteAddbtn();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				element.click();
				element=setupCustomer.getToastMessage();
				WebElementCommon.waitForElementPresent(driver, element, logger);
				logger.log(LogStatus.PASS, "Successfully Clicked on Add Button");  
			}else{
				logger.log(LogStatus.FAIL, "Verified Add button is present but NOT enabled");  
			}	
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site add button Field Failed");   
		}	
	}

	/**
	 * Verify Add button is disabled.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyAdd() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteAddbtn();
		if(element!= null){
			if(!WebElementCommon.isElementEnabledByEle(element)){
				logger.log(LogStatus.PASS, "Successfully verified Add Button is disabled");  
			}else{
				logger.log(LogStatus.FAIL, "Verified Add button is enabled");  
			}	
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site add button Field Failed");   
		}	
	}

	/**
	 * Click update to edit site.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickUpdate() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);

		element=setupSite.getSiteUpdatebtn();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebElementCommon.staticWait(100);
				element.click();
				customerPA.waitPageLoad();
				element=setupCustomer.getToastMessage();
				WebElementCommon.waitForElementPresent(driver, element, logger);
				logger.log(LogStatus.PASS, "Successfully Clicked on Update Button");  
			}else{
				logger.log(LogStatus.FAIL, "Verified Update button is present but NOT enabled");  
			}	
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Update button Field Failed");   
		}	
	}
	/**
	 * Click Delete button.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickDelete() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		element=setupSite.getSiteDeletebtn();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebElementCommon.staticWait(100);
				element.click();
				logger.log(LogStatus.PASS, "Successfully Clicked on Delete Button");  
			}else{
				logger.log(LogStatus.FAIL, "Verified Delete button is present but NOT enabled");  
			}	
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Site Delete button Field Failed");   
		}	
	}
	/**
	 * Click Yes button on Pop up form while Deleting Site.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void clickDeleteSiteYesBtn() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		//VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		// customerPA.waitPageLoad();
		element=setupSite.getdeleteSiteYesBtn();
		if(element!= null){
			if(WebElementCommon.isElementEnabledByEle(element)){
				WebElementCommon.staticWait(100);
				element.click();
				//customerPA.waitPageLoad();
				logger.log(LogStatus.PASS, "Successfully Clicked on YES button on Pop up form while Deleting Site");  
				element=setupCustomer.getToastMessage();
				WebElementCommon.waitForElementPresent(driver, element, logger);
			}else{
				logger.log(LogStatus.FAIL, "Verified YES button is present but NOT enabled");  
			}	
		}else{
			logger.log(LogStatus.FAIL, "Confirmation message is not displayed while site deletion");   
		}	
	}
	/**
	 * Check Success message for adding site.
	 *
	 * @param None
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean verifySuccessMessage() throws IOException {
		boolean flag=false;
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		element = setupCustomer.getToastMessage();
		//	WebElementCommon.waitForElementPresent(driver, element, logger);
		if(element!=null){
			if(element.getText().contains("Site added successfully")){
				WebElementCommon.staticWait(100);
				BaseClass.getScreenShot(driver, "Site added successfully", logger);
				logger.log(LogStatus.PASS, "Message for Site addition verified successfully");  
				flag=true;
			}
		}else{
			logger.log(LogStatus.FAIL, "Success message is not displayed after creating new site");  
		}
		return flag;	
	}
	/**
	 * Check Success message for site Update.
	 *
	 * @param None
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean verifyEditMessage() throws IOException {
		boolean flag=false;
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		element = setupCustomer.getToastMessage();
		//WebElementCommon.waitForElementPresent(driver, element, logger);
		if(element!=null){
			if(element.getText().contains("Site edited successfully")){
				BaseClass.getScreenShot(driver, "Site edited successfully", logger);
				logger.log(LogStatus.PASS, "Alert message for Site edition verified successfully");  
				flag=true;
			}
		}else{
			logger.log(LogStatus.FAIL, "Success message is not displayed after updating site");  
		}
		return flag;	
	}

	/**
	 * Check Success message for site Delete.
	 *
	 * @param None
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean verifyDeleteMessage() throws IOException {
		boolean flag=false;
		VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
		element = setupCustomer.getToastMessage();
		//WebElementCommon.waitForElementPresent(driver, element, logger);
		if(element!=null){
			if(element.getText().contains("Site deleted successfully")){
				BaseClass.getScreenShot(driver, "Site deleted successfully", logger);
				logger.log(LogStatus.PASS, "Alert message for Site deletion verified successfully");  
				flag=true;
			}
		}else{
			logger.log(LogStatus.FAIL, "Success message is not displayed after deleting site");  
		}
		return flag;	
	}

	/**
	 * Expand all the tree by clicking on the plus node at country level.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void expandAllCountry() {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		WebElementCommon.staticWait(5000);
		elements=setupSite.getcountryExpand();
		//WebElementCommon.waitForElementPresent(driver, elements.get(0), logger);
		if(elements.size()>0){
			Iterator<WebElement> iter = elements.iterator();
			while(iter.hasNext()) {
				WebElement ele = iter.next();
				ele.click();
			}
			logger.log(LogStatus.PASS, "All Nodes are expanded to view Site");  
		}else{
			logger.log(LogStatus.FAIL, "No site is present for the customer");  
		}

	}

	/**
	 * Find Site in the Tree and Click on site name.
	 *
	 * @param Site name
	 * 
	 * @return None
	 */
	public void clickSite(String siteName) {

		VERASYS_SetUp_Site_Page_Factory setupSite=new VERASYS_SetUp_Site_Page_Factory(driver);
		elements=setupSite.getSiteTree();
		
		//WebElementCommon.waitForElementPresent(driver, elements.get(0), logger);
		//int size=elements.size();
		if(elements.size()>2){
			Iterator<WebElement> iter = elements.iterator();
			while(iter.hasNext()) {
				WebElement ele = iter.next();
				// String att=ele.getAttribute("id");
				if (ele.getAttribute("id").endsWith(siteName)) {
					logger.log(LogStatus.PASS, "Site: "+siteName+" is present in the Site tree");  
					ele.click();
					if(ele.getAttribute("class").endsWith("selectedNode")|| ele.getAttribute("class").endsWith("activeTreeNode")){
						logger.log(LogStatus.PASS, "Site Name is highlighted in Site Tree"); 
					break;
				}
				}
			}
		}else{
			logger.log(LogStatus.FAIL, "No site is present for the customer");  
		}			
	}
	/**
	 * Add new site to existing customer.
	 *
	 * @param None
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean addSite(String customerName,String siteName) throws IOException {

		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);

		clickCustomerTab();
		customerPA.waitPageLoad();
		selectCustomer(customerName);
		customerPA.waitPageLoad();
		enterSiteName(siteName);
		enterSiteID("Auto"+siteName);
		enterAddress1("Auto"+siteName);
		enterAddress2("Auto"+siteName);
		selectCountry("United States Of America");
		selectState();
		selectCity();
		enterZipcode("99501");
		enterStartDate("01/01/2017");
		//customerPA.SelectDateFromDatePicker("2017","May","13");
		enterEndDate("01/12/2017");
		//customerPA.SelectDateFromDatePicker("2018","May","13");
		enterPrimContactName("Auto"+siteName);
		enterPrimTitle("Mr");
		enterPrimContact("9860156666");
		enterPrimEmail("Sec@jci.com");
		enterSecContactName("Auto"+siteName);
		enterSecTitle("Ms");
		enterSecContact("9860158888");
		enterSecEmail("Sec@jci.com");
		clickAdd();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Site added successfully", logger);
		if(toasterMsg.contains("Site added successfully"))
		{
			logger.log(LogStatus.PASS, "Message for Site addition verified successfully"); 
			customerPA.waitPageLoad();
			expandAllCountry();
			clickSite("Auto"+siteName);
			return true;
		}else{
			logger.log(LogStatus.FAIL, "Site is not added for the customer");  
			return false;
		}
	}

	/**
	 * Update existing site.
	 *
	 * @param Customer Name, Site name
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean updateSite(String customerName,String siteName) throws IOException {
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		clickCustomerTab();
		selectCustomer(customerName);
		expandAllCountry();
		clickSite(siteName);
		customerPA.waitPageLoad();
		enterPrimContactName(siteName+"Updated");
		verifyAdd();
		verifySiteName();
		verifyCountry();
		verifyState();
		verifyCity();
		clickUpdate();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Site edited successfully", logger);
		if(toasterMsg.contains("Site edited successfully"))
		{
			logger.log(LogStatus.PASS, "Alert message for Site edition verified successfully");  
			return true;
		}
		return false;
	}

	/**
	 * Delete existing site.
	 *
	 * @param Customer Name, Site name
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean deleteSite(String customerName,String siteName) throws IOException {
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		clickCustomerTab();
		selectCustomer(customerName);
		customerPA.waitPageLoad();
		expandAllCountry();
		clickSite(siteName);
		customerPA.waitPageLoad();
		verifyAdd();
		clickDelete();
		clickDeleteSiteYesBtn();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Site Deleted successfully", logger);
		if(toasterMsg.contains("Site deleted successfully"))
		{
			logger.log(LogStatus.PASS, "Alert message for Site deletion verified successfully");
			return true;
		}else{
			return false;
		}
	}
}
