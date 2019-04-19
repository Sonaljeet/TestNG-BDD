/**
 * 
 */
package mars.JCI.Project.VERASYS.SetUp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.BaseClass;


/**
 * @author jkadhak
 *
 */
public class VERASYS_Setup_Customer_Page_Action {

	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	private static String CustomerID=null ;
	
	/**Variables required for Calendar*/
	static int targetDay = 4, targetMonth = 6, targetYear = 1993;

	static int currenttDate = 0, currenttMonth = 0, currenttYear = 0;

	static int jumMonthBy = 0;

	static boolean increment = true;
	
	/**
	 * Instantiates/Constructor a new Verasys Customer page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public VERASYS_Setup_Customer_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	/**
	 * Verify Customer Tab is Highlighted.
	 *
	 * @return boolean
	 */
public void verifyCustomerTab(){
	 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	 element=setupCustomer.getCustomerTab();
	 if(element!= null){
			if(element.getAttribute("style").contains("rgb(42, 100, 150)")){
				//WebElementCommon.getElementAttributeValue(driver, logger, element, "style")
				logger.log(LogStatus.PASS, "Successfully verified Customer Tab is highlighted on page load");  
			}else{
				logger.log(LogStatus.FAIL, "Customer Tab is NOT highlighted on page load");  
			}
		}else
		{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Tab Field Failed");   
		}
	
 }
/**
 * Verify Customer Tab is Highlighted.
 *
 * @return boolean
 */
public void clickCustomerTab(){
 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
 element=setupCustomer.getCustomerTab();
 if(element!= null){
	 element.click();
	}else
	{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Tab Field Failed");   
	}

}
/**
 * Verify Customer ID.
 *
 * 
 * @return boolean
 */
public void validateCustomerID () {
	
	 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	 waitPageLoad();
	element = setupCustomer.getCustomerID();
	
	if(element!= null){
		if(!element.getText().toString().isEmpty()){
			logger.log(LogStatus.PASS, "Successfully Verified Customer ID Field is present On define Customer page as "+element.getText());  
			//CustomerID=element.getText().toString();
			CustomerID=element.getAttribute("innerHTML");
			System.out.println("CustomerID : "+ CustomerID);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//String text=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById("enter span id")));
			//CustomerID=((JavascriptExecutor) driver).executeScript("arguments[0].);
			int customerIDLength=CustomerID.length();
			if(customerIDLength==6){
			logger.log(LogStatus.PASS, " Successfully Verified Customer ID is 6 digit number");  
		}else{
			logger.log(LogStatus.PASS, "Customer ID is NOT a 6 digit number");  
		}
		}else{
			logger.log(LogStatus.FAIL, "Customer ID Field is NOT present On define Customer page");   
		}
			
		}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer ID Field Failed");   
	}
	 
	
}


/**
 * Validate Customer Name is alphanumeric and mandatory.
 * @param Customer name
 * 
 * @return None
 */
public void validateCustomerName (String custName) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCustomerName();
	if(element!= null){
		if(element.isEnabled()){
			logger.log(LogStatus.PASS, "Verified Customer Name field is present and enabled");  
			
			WebInputTextBox.SendInputTextBox(driver, element, custName);
			//element=setupCustomer.getCustomerNameError();
			if (WebElementCommon.isDisplayedByElement(setupCustomer.getCustomerNameError())){
				logger.log(LogStatus.INFO, "Verified Customer Name validation: Customer name field is NOT alphanumeric");  
			}else{
				logger.log(LogStatus.PASS, "Verified Customer Name validation: Customer name field is alphanumeric");  
			}
			element = setupCustomer.getCustomerName();
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, custName);
			element.clear();
			element = setupCustomer.getMandatoryCustomerNameError();
			if (element.isDisplayed()){
				logger.log(LogStatus.PASS, "Verified Customer Name validation: Customer name field is Mandatory Field");  		
			}else{
				logger.log(LogStatus.INFO, "Verified Customer Name validation: Customer name field is NOT Mandatory Field");  
			}
			element.clear();
				element = setupCustomer.getCustomerName();
				WebInputTextBox.SendInputTextBox(driver, element, custName);
				logger.log(LogStatus.PASS, "Successfully entered valid Customer name");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Customer Name field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Name Field Failed");   
	}
	
}

public void enterCustomerName (String custName) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	
	element = setupCustomer.getCustomerName();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, custName);
			logger.log(LogStatus.PASS, "Successfully Entered Customer name field as: "+custName);  
			}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Name Field Failed");   
	}
}
}

/**
 * Enter JCI Customer Billing ID.
 *
 * @param JCI Customer Billing ID
 * 
 * @return None
 */
public void enterCustBillId (String custID) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCustomerBillingId();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, custID);
			logger.log(LogStatus.PASS, "Successfully Entered Customer Billing ID");  
			}else{
			logger.log(LogStatus.FAIL, "Customer Billing ID field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Billing ID Field Failed");   
	}
	
}

/**
 * Enter Abbrevations.
 * 
 * @param Abbrevation
 * 
 * @return None
 */
public void enterAbbreavtion(String abbrv) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getAbbreviation();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, abbrv);
			logger.log(LogStatus.PASS, "Successfully Entered Customer Abbrevation");  
			}else{
			logger.log(LogStatus.FAIL, "Customer Abbrevation field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Abbrevation Field Failed");   
	}
	
}
 
/**
 * Enter Address 1.
 *
 * @param Address 1
 * 
 * @return None
 */
public void enterAddress1(String add1) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getAddress_1();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, add1);
			logger.log(LogStatus.PASS, "Successfully Entered Address 1");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Address 1 field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Address 1 Field Failed");   
	}
	
}

/**
 * Enter Address 2.
 *
 * @param Address 2
 * 
 * @return None
 */
public void enterAddress2(String add2) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getAddress_2();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, add2);
			logger.log(LogStatus.PASS, "successfully Entered Address 2");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Address 2 field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Address 2 Field Failed");   
	}
	
}
/**
 * Enter Country.
 *
 * @param Country
 * 
 * @return None
 */
public void enterCountry(String Country) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCountry();
	if(element!= null){
		if(!element.isSelected()){
			//WebElementCommon.waitForTextToAppear(driver, Country, element, logger);
			element.click();
			WebDropDown.SelectElementByVisibleText(element, Country);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			logger.log(LogStatus.PASS, "Successfully selected Country from the drop down");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Country field is present but already populated");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Country Field Failed");   
	}
	
}

 

/**
 * Wait until drop options are visible
 * */
public void waitUntilSelectOptionsPopulated(Select select) {
    new FluentWait<WebDriver>(driver)
            .withTimeout(60, TimeUnit.SECONDS)
            .pollingEvery(10, TimeUnit.MILLISECONDS)
            .until(new Predicate<WebDriver>() {
                public boolean apply(WebDriver d) {
                    return (select.getOptions().size() > 1);
                }
            });
}

/**
 * Enter State.
 *
 * @param State
 * 
 * @return None
 */
public void enterState() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getState();
	if(element!= null){
		//WebElementCommon.waitForTextToAppear(driver, "Alabama", element, logger);
		if(!element.isSelected()){
		
			Select select = new Select(element);  
			
			List<WebElement> options = select.getOptions(); 
			waitUntilSelectOptionsPopulated(select);
			if(options.size()>0){
				WebDropDown.SelectElementByIndex(element, 7);
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
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer State Field Failed");   
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
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getState();
	if(element!= null){
		element.click();
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer State Field Failed");   
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
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCity();
	if(element!= null){
		element.click();
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer City Field Failed");   
	}
	
}

/**
 * Enter City.
 *
 * @param City
 * 
 * @return None
 */
public void enterCity() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCity();
	if(element!= null){
		if(!element.isSelected()){
			Select select = new Select(element);  
			waitUntilSelectOptionsPopulated(select);
			WebDropDown.SelectElementByIndex(element, 1);
			logger.log(LogStatus.PASS, "Successfully selected City from the drop down");  
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
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getZipcode();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, zipCode);
			logger.log(LogStatus.PASS, "Successfully entered Zipcode");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Zipcode field is present but NOT Enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Zipcode Field Failed");   
	}
	
}

/**
 * Upload Logo.
 *
 * @param None
 * 
 * @return None
*/
public void uploadLogo() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getUploadCustomerLogo();
	try{
	if(element!= null){
		element.click();
		Runtime.getRuntime().exec("\"C:/Screenshots/upload.exe\"");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		element = setupCustomer.getViewLogo();
		System.out.println(element.getAttribute("src").toString());
		if(!element.getAttribute("src").isEmpty()){
			//WebElementCommon.getElementAttributeValue(driver, logger, element, "src")
			logger.log(LogStatus.PASS, "Successfully uploaded Customer logo");  
		}else{
			logger.log(LogStatus.INFO, "Customer logo upload Failed");   
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Choose File for uploading logo Field Failed");   
	}
	}catch(Exception e){
		System.out.println("Exception occured "+e);
	}
} 

/**
 * Enter Contract type.
 *
 * @param Contract type text
 * 
 * @return None
*/
public void enterContractType(String contractType) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getContactType();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, contractType);
			logger.log(LogStatus.PASS, "Successfully entered Contract type");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Contract type field is present but NOT enabled");  
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Contract type Field Failed");   
	}
	
} 
/**
 * Enter Start Date.
 *
 * @param Start Date text
 * 
 * @return None
*/
public void enterStartDate(String startDate) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getStartDate();
	if(element!= null){
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",element);
		//element.click();
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.clear();
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
* Pick date from calender.
*
* @param date in format year-month-date
* 
* @return None

public void SelectDateFromDatePicker(String year, String month, String date)
{
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
    while (year != setupCustomer.getlblYear().getText())
    {
        if (Integer.parseInt(year) < Integer.parseInt(setupCustomer.getlblYear().getText()))
        {
        	setupCustomer.getBtnPrevious().click();
        }
        else
        {
        	setupCustomer.getBtnNext().click();
        }
    }

    while (setupCustomer.getlblMonth().getText()!= "January")
    {
    	setupCustomer.getBtnPrevious().click();
    }

    while (month != setupCustomer.getlblMonth().getText())
    {
    	setupCustomer.getBtnNext().click();
    }

    element=setupCustomer.getlblDate();

   // List<WebElement> rows = element.findElements(By.tagName("tr"));  
    List<WebElement> columns = element.findElements(By.tagName("td"));  

    for (WebElement cell: columns){
        if (cell.getText().equals(date)){
            cell.findElement(By.linkText(date)).click();
            break; 
        }
    }

}*/
/**
 * Enter End Date.
 *
 * @param End Date text
 * 
 * @return None
*/
public void enterEndDate(String endDate) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getEndDate();
	if(element!= null){
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",element);
		//element.click();
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.clear();
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
 * Select Currency.
 *
 * @param none
 * 
 * @return None
*/
public void selectCurrency() {
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCurrency();
	if(element!= null){
		if(!element.isSelected()){
			WebDropDown.SelectElementByIndex(element, 1);
			logger.log(LogStatus.PASS, "Successfully selected currency");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Currency field is present but already populated");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Currency Field Failed");   
	}
	
}
/**
 * Select Cost unit per Kwh.
 *
 * @param none
 * 
 * @return None
*/
public void selectCost() {
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getCostUnit();
	if(element!= null){
		if(!element.isSelected()){
			WebDropDown.SelectElementByIndex(element, 1);
			logger.log(LogStatus.PASS, "Successfully selected Cost unit per Kwh");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Cost unit per Kwh field is present but already populated");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Cost unit per Kwh Field Failed");   
	}	
}
/**
 * Enter Customer Contact Name.
 *
 * @param Contact name text
 * 
 * @return None
*/
public void enterContactName(String contactName) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getContactName();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, contactName);
			logger.log(LogStatus.PASS, "Successfully entered Customer Contact Name");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Customer Contact Name field is present but NOT enabled");  
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Contact Name Field Failed");   
	}	
}

/**
 * Enter Customer Contact Title.
 *
 * @param Customer Contact Title text
 * 
 * @return None
*/
public void enterTitle(String contactTitle) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getDesignation();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, contactTitle);
			logger.log(LogStatus.PASS, "Successfully entered Customer Contact Title");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Customer Contact Title field is present but NOT enabled");  
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Contact Title Field Failed");   
	}	
}

/**
 * Enter Customer Contact Number.
 *
 * @param Customer Contact Number text
 * 
 * @return None
*/
public void enterContact(String contactNo) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getContactNo();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, contactNo);
			logger.log(LogStatus.PASS, "Successfully entered Customer Contact Number");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Customer Contact Number field is present but NOT enabled");  
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Contact Number Field Failed");   
	}	
}

/**
 * Enter Customer Contact email.
 *
 * @param Customer Contact email text
 * 
 * @return None
*/
public void enterEmail(String email) {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getEmail();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, email);
			logger.log(LogStatus.PASS, "Successfully entered Customer Contact Email");  
			}else{
			logger.log(LogStatus.FAIL, "Verified Customer Contact Email field is present but NOT enabled");  
		}
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Contact Email Field Failed");   
	}	
}

/**
* Click Add to add the customer.
*
* @param None
* 
* @return None
*/
public void clickAdd() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getAddBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.click();
			element=setupCustomer.getToastMessage();
			WebElementCommon.waitForElementPresent(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully Clicked on Add Button");  
			
			/*driver.switchTo().alert();
			if(driver.switchTo().alert().getText().contains("Added")){
			logger.log(LogStatus.PASS, "Successfully verified alert message for adding customer");  
			}else{
				logger.log(LogStatus.FAIL, "Alert message not displayed on successful adition");  
				}
			driver.switchTo().alert().accept();*/
		}else{
			logger.log(LogStatus.FAIL, "Verified Add button is present but NOT enabled");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Customer Contact Email Field Failed");   
	}	
}
/**
* Check Success message.
*
* @param None
* 
* @return None
*/
public String verifyMessage() {
	String toasterMsg=null;
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getToastMessage();
		WebElementCommon.waitForElementPresent(driver, element, logger);
			if(element!=null){
				toasterMsg=element.getText().toString();
				if(!toasterMsg.isEmpty()){
					logger.log(LogStatus.PASS, "Alert message captured successfully");  
			}
		}else{
			logger.log(LogStatus.FAIL, "No toaster message was displayed");  
			}
			return toasterMsg;	
}

/**
* Check validation message.
*
* @param None
* 
* @return None
*/
public boolean verifyValidationMessage() {
	boolean flag=false;
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getToastMessage();
		WebElementCommon.waitForElementPresent(driver, element, logger);
			if(element!=null){
				if(element.getText().contains("added")){
					logger.log(LogStatus.PASS, "Alert message for customer addition verified successfully");  
					flag=true;
			}
		}else{
			logger.log(LogStatus.FAIL, "Verified Add button is present but NOT enabled");  
			}
			return flag;	
}

/**
* Check Error message.
*
* @param None
* 
* @return None
*/
public boolean verifyErrorMessage() {
	boolean flag=false;
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getToastErrorMessage();
		WebElementCommon.waitForElementPresent(driver, element, logger);
			if(element!=null){
					logger.log(LogStatus.PASS, "Alert message for customer field validation verified successfully");  
					flag=true;
		}else{
			logger.log(LogStatus.FAIL, "Error message for field validation NOT displayed");  
			}
			return flag;	
}
/**
* Click on Section Customer-Setup .
*
* @param None
* 
* @return None
*/
public void clickForm() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getcustomerSection();
			if(element!=null){
				element.click();
			}
}

/**
* Search added customer .
*
* @param None
* 
* @return None
 * @throws IOException 
*/
public WebElement searchGrid(String searchData) throws IOException {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
				element=setupCustomer.getCustGrid();
				if(element!=null){
				List<WebElement> tr_collection=element.findElements(By.tagName("tr"));

		        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		        int row_num,col_num;
		        row_num=1;
		        for(WebElement trElement : tr_collection)
		        {
		            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
		            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
		            col_num=1;
		            for(WebElement tdElement : td_collection)
		            {
		            	String row=tdElement.getAttribute("innerText");
		            	if(row.equals(searchData)){
		            		BaseClass.getScreenShot(driver, "Customer added successfully", logger);
							logger.log(LogStatus.PASS, "Successfully Searched with data "+searchData);  
							break;
							}
		            	/*else{
							logger.log(LogStatus.FAIL, "Customer ID:"+searchData+" could not be found in Customer Grid");  
						}*/

		                System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
		                col_num++;
		            }
		            row_num++;
		        } 
		       /* if(WebElementCommon.isDisplayedByElement(element)){
					WebElement tableRow=element.findElement(By.tagName("tr"));
					WebElement column2 = tableRow.findElement(By.tagName("td"));
					String row=column2.getAttribute("innerText");
					if(row.equals(searchData)){
					logger.log(LogStatus.PASS, "Successfully Searched Customer with ID "+searchData);  
					}*/
				
				}else{
					logger.log(LogStatus.FAIL, "Failed to identify Grid");  
				}
			return element;
}

/*
 * Select date from calender
 */

public static void getCurrentDayMonth() {

    Calendar cal = Calendar.getInstance();
    currenttDate = cal.get(Calendar.DAY_OF_MONTH);
    currenttMonth = cal.get(Calendar.MONTH) + 1;
    currenttYear = cal.get(Calendar.YEAR);
}

public static void getTargetDayMonthYear(String dateString) {
    int firstIndex = dateString.indexOf("/");
    int lastIndex = dateString.lastIndexOf("/");

    String day = dateString.substring(0, firstIndex);
    targetDay = Integer.parseInt(day);

    String month = dateString.substring(firstIndex + 1, lastIndex);
    targetMonth = Integer.parseInt(month);

    String year = dateString.substring(lastIndex + 1, dateString.length());
    targetYear = Integer.parseInt(year);

}

public static void calculateToHowManyMonthToJump() {

    if ((targetMonth - currenttMonth) > 0) {
        jumMonthBy = targetMonth - currenttMonth;

    } else {
        jumMonthBy = currenttMonth - targetMonth;
        increment = false;
    }
}

/**
 * Search customer with Customer Name in Grid.
 *
 * @return none
 * @throws IOException 
 */
public void searchCustName(String custName) throws IOException{
 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
 element=setupCustomer.getSearchCustName();
 if(element!=null){
		WebInputTextBox.SendInputTextBox(driver, element, custName);
		element.sendKeys(Keys.ENTER);
		element=searchGrid(custName);
		element.click();
	}else{
		logger.log(LogStatus.FAIL, "Failed to identify Customer Name Search box on customer page");  
	}

}

/**
 * Search customer with Customer ID in Grid.
 *
 * @return none
 * @throws IOException 
 */
public void searchCustID(String CustomerID) throws IOException{
 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
 element = setupCustomer.getCustIDSearch();
	if(element!=null){
		WebInputTextBox.SendInputTextBox(driver, element, CustomerID);
		//element.sendKeys(Keys.ENTER);
		System.out.println("cutomer id entered in serach text" +CustomerID );
		element=searchGrid(CustomerID);
		element.click();
		//waitPageLoad();
	}else{
		logger.log(LogStatus.FAIL, "Failed to identify Customer Id Search box on customer page");  
	}

}
/**
 * Verify Mandatory filed are prepopulated.
 *
 * @return boolean
 */
public boolean verifyMandatFields(){
	boolean flag=false;
 VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
 
 element=setupCustomer.getCustomerName();
 if(element!=null){
	 if(!element.getText().isEmpty()){
		 logger.log(LogStatus.PASS, "Customer Name Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer Name Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer Name Field could not be identified");  
 }
 
 element=setupCustomer.getCountry();
 if(element!=null){
	 if(element.isSelected()){
		 logger.log(LogStatus.PASS, "Customer Country Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer Country Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer Country Field could not be identified");  
 }
 
 element=setupCustomer.getState();
 if(element!=null){
	 if(element.isSelected()){
		 logger.log(LogStatus.PASS, "Customer State Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer State Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer State Field could not be identified");  
 }
 
 element=setupCustomer.getCity();
 if(element!=null){
	 if(element.isSelected()){
		 logger.log(LogStatus.PASS, "Customer City Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer City Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer City Field could not be identified");  
 }
 
 element=setupCustomer.getStartDate();
 if(element!=null){
	 if(!element.getText().isEmpty()){
		 logger.log(LogStatus.PASS, "Customer Start Date Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer Start Date Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer Start Date Field could not be identified");  
 }
 
 element=setupCustomer.getEndDate();
 if(element!=null){
	 if(!element.getText().isEmpty()){
		 logger.log(LogStatus.PASS, "Customer End Date Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer End Date Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer End Date Field could not be identified");  
 }
 
 element=setupCustomer.getCurrency();
 if(element!=null){
	 if(element.isSelected()){
		 logger.log(LogStatus.PASS, "Customer Currency Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer Currency Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer Currency Field could not be identified");  
 }
 
 element=setupCustomer.getCostUnit();
 if(element!=null){
	 if(element.isSelected()){
		 logger.log(LogStatus.PASS, "Customer CostUnit per Kwh Field is Prepopluated as "+element.getText());  
		 flag=true;
	 }else{
		 logger.log(LogStatus.FAIL, "Customer CostUnit per Kwh Field is not Pre Populated");  
	 }
 }else{
	 logger.log(LogStatus.INFO, "Customer CostUnit per Kwh Field could not be identified");  
 }
 
 return false;
}

/**
* Verify Add Button is disabled.
*
* @param None
* 
* @return boolean
*/
public boolean verifyAddBtn() {
	boolean flag=false;
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getAddBtn();
			if(element!=null){
				if(!element.isEnabled()){
					logger.log(LogStatus.PASS, "Successfully verified Add button is disabled ");  
					flag=true;
			}
		}else{
			logger.log(LogStatus.FAIL, "Add button is present and enabled");  
			}
			return flag;	
}

/**
* Click on update button.
*
* @param None
* 
* @return none
*/
public void clickUpdateBtn() {
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	element = setupCustomer.getUpdateBtn();
			if(element!=null){
				if(element.isEnabled()){
					element.click();
					logger.log(LogStatus.PASS, "Successfully Clicked on Update button");  
			}
		}else{
			logger.log(LogStatus.FAIL, "Update button is present and enabled");  
			}
}

/**
 * Wait untill page loads.
 *
 * @return boolean
 */
public void waitPageLoad(){
	element=driver.findElement(By.cssSelector("div.spinner"));
	if(element.isDisplayed()){
		WebElementCommon.waitForElementToDisappear(driver, By.cssSelector("div.spinner"));
	}
}
/**
 * Wait untill page loads.
 *
 * @return boolean
 */
public void waitForPageLoaded() {
    ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")&&((Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0")));
                }
            };
    try {
        Thread.sleep(100);
        WebDriverWait waitForLoad = new WebDriverWait(driver, 30);
        waitForLoad.until(expectation);
    } catch (Throwable error) {
        Assert.fail("Timeout waiting for Page Load Request to complete.");
    }
}
/**
* Add new customer and verify by searching using Customer ID in customer grid.
*
* @param None
* 
* @return Boolean
 * @throws IOException 
*/
public boolean addNewCustomer(String customer_name) throws IOException {
	String dateToSet = "16/12/2016";
	//String customer_name= RandomStringUtils.randomAlphanumeric(3).toUpperCase();
	String[] specialChars = {"#","!","$", "@", "%", "^", "&"};
	clickCustomerTab();
	
	//verifyCustomerTab();
	//validateCustomerName("AutoTest123"+specialChars[1]);
    validateCustomerID();
	
	enterCustomerName(customer_name);
	enterCustBillId("AutoTest123"+specialChars[1]);
	enterAbbreavtion("AutoTest");
	enterAddress1("AutoAdd1");
	enterAddress2("AutoAdd2");
	enterCountry("United States Of America");
	
	enterState();
	enterCity();
	enterZipcode("440023");
	uploadLogo();
	enterContractType("AutocontractType");
	enterStartDate("01/01/2017");
    //SelectDateFromDatePicker("2017","May","13");
	enterEndDate("12/01/2017");
	//SelectDateFromDatePicker("2018","May","13");
	selectCurrency();
	selectCost();
	enterContactName("AutoTest");
	enterEmail("test@jci.com");
	enterContact("8901234567");
	enterTitle("Mr");
	clickAdd();
	String toasterMsg=verifyMessage();
	if(toasterMsg.contains("Customer added successfully")){
	searchCustID(CustomerID);
	return true;
	}else{
		return false;
	}
}
/**
* Validate mandatory Filed while adding new customer
*
* @param None
* 
* @return Boolean
*/
public void customerPageValidation() {
	
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	String customer_name= RandomStringUtils.randomAlphanumeric(3).toUpperCase();
	clickCustomerTab();
 
//Customer Name Field Validation
	enterCustomerName("");
	clickForm();
	if(verifyErrorMessage())
	{
		logger.log(LogStatus.PASS, "Successfully verified that Customer Name is Mandatory field");
	}else{
		logger.log(LogStatus.FAIL, "Error message for Customer Name field validation NOT displayed");  
	}
	enterCustomerName("AutoTest"+customer_name);
	
//Country Name Field Validation	
	enterCountry("");
	clickForm();
	if(verifyErrorMessage())
	{
		logger.log(LogStatus.PASS, "Successfully verified that Country is Mandatory field");
	}else{
		logger.log(LogStatus.FAIL, "Error message for Country field validation NOT displayed");  
	}
	enterCountry("United States Of America");
	
//State Name Field Validation	
	   clickState();
		clickForm();
		if(verifyErrorMessage())
		{
			logger.log(LogStatus.PASS, "Successfully verified that State is Mandatory field");
		}else{
			logger.log(LogStatus.FAIL, "Error message for State field validation NOT displayed");  
		}
		enterState();

//City Name Field Validation	
		   clickCity();
			clickForm();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that City is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for City field validation NOT displayed");  
			}
			enterCity();
//Start Date Field Validation
			 enterStartDate("");
			clickForm();
			clickAdd();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that Start date is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for Start date field validation NOT displayed");  
			}
			//SelectDateFromDatePicker("2017","May","13");
		
//End Date Field Validation
			enterEndDate("");
			clickForm();
			clickAdd();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that End date is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for End date field validation NOT displayed");  
			}
			//SelectDateFromDatePicker("2018","May","13");
			enterEndDate("01/12/2017");
//Currency Field Validation
			setupCustomer.getCurrency().click();
			clickAdd();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that Currency  is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for Currency field validation NOT displayed");  
			}
			selectCurrency();
			
//Cost Field Validation
			setupCustomer.getCostUnit().click();
			clickAdd();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that Cost per Unit is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for Cost per Unit field validation NOT displayed");  
			}
			selectCost();
//Customer contact name Field Validation
			setupCustomer.getContactName().click();
			clickAdd();
			if(verifyErrorMessage())
			{
				logger.log(LogStatus.PASS, "Successfully verified that Customer Contact Name is Mandatory field");
			}else{
				logger.log(LogStatus.FAIL, "Error message for Customer Contact Name field validation NOT displayed");  
			}
			enterContactName("AutoTest");
}


/**
* Update existing customer by Search using Customer Name
*
* @param None
* 
* @return Boolean
 * @throws IOException 
*/
public boolean updateNewCustomer(String customer_name) throws IOException {
	searchCustName(customer_name);
	if(verifyMandatFields()){
		enterContactName("Updated Contact Name");
		if(verifyAddBtn()){
			clickUpdateBtn();
		}
	}else{
		logger.log(LogStatus.FAIL, "Customer record is incomplete as some of the manadtory fields are missing ");  
	}
	return false;
}	

/**
* Activate inactive customer by searching using end date and update end date.
*
* @param None
* 
* @return Boolean
*/
public boolean activateCustomer(String customer_name) {
	VERASYS_SetUp_Customer_Page_Factory setupCustomer=new VERASYS_SetUp_Customer_Page_Factory(driver);
	
	return false;
}	
}
