package mars.JCI.Project.VERASYS.SetUp;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.BaseClass;

public class VERASYS_SetUp_Create_SBH_Page_Action {

	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	private WebElement element1;
	
	/** The WebElements/Locator elements. */
	private List<WebElement> elements;
	
	
	
	/**
	 * Instantiates/Constructor a new Verasys SBH page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public VERASYS_SetUp_Create_SBH_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
/**
 * Verify SBH Tab is Highlighted.
 *
 * @return boolean
 */
public void clickSBHTab(){
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
 element=setupSBH.getSBHTab();
 if(element!= null){
	 element.click();
	 logger.log(LogStatus.PASS, "Successfully Clicked on SBH Tab on set up page.");  
	}else
	{
		logger.log(LogStatus.FAIL, "Identifying WebElement for SBH Tab Field Failed");   
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
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getCustomerDropDown();
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
 * Enter Device id.
 *
 * @param device id
 * 
 * @return None
 */
public void enterSBHId(String deviceId) {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getSBHId();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			WebInputTextBox.SendInputTextBox(driver, element, deviceId);
			logger.log(LogStatus.PASS, "successfully Entered SBH ID as "+deviceId);  
			}else{
			logger.log(LogStatus.FAIL, "Verified SBH ID input field is present but NOT enabled");  
		}
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for SBH ID input field Failed");   
	}
	
}

/**
 * Get input from SBH ID field.
 *
 * @param 
 * 
 * @return None
 */
public String getSBHID() {
	String SBH=null;
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getSBHId();
	if(element!= null){
		SBH=element.getText();
	}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for SBH ID input field Failed");   
	}
	return SBH;
}

/**
* Click Validate SBH button.
*
* @param None
* 
* @return None
*/
public void clickValidateSBH() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	element=setupSBH.getValidateBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.click();
			 customerPA.waitPageLoad();
			 logger.log(LogStatus.PASS, "Successfully Clicked on Validate SBH Button");  
		}else{
			logger.log(LogStatus.FAIL, "Verified Validate SBH button is present but NOT enabled");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Validate SBH button Field Failed");   
	}	
}


/**
* Verify Validate SBH button is present and enabled.
*
* @param None
* 
* @return None
*/
public void verifyValidateSBH() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	element=setupSBH.getValidateBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			 logger.log(LogStatus.PASS, "Successfully verified that Validate SBH Button is present and enabled");  
		}else{
			logger.log(LogStatus.FAIL, "Verified Validate SBH button is present but NOT enabled");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Validate SBH button Field Failed");   
	}	
}

/**
* Verify green check id the SBH id is valid and unmapped to any customer.
*
* @param None
* 
* @return None
*/
public void validateSBH() {
	String attributeCheck,attributeCross,toasterMsg=null;
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	WebElementCommon.staticWait(3000);
	element=setupSBH.getValidateCheck();
	element1=setupSBH.getValidateCross();
	if(element!=null){
	attributeCheck=element.getAttribute("ng-reflect-hidden");
	if(attributeCheck.equalsIgnoreCase("false")){
		logger.log(LogStatus.PASS, "Successfully verified that SBH ID is valid and ready to add to customer"); 
	}else if(element1!=null){
	attributeCross=element1.getAttribute("ng-reflect-hidden");
	//new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(element, attribute, "false"));
	//attribute=element.getAttribute("ng-reflect-hidden");
	 if(attributeCross.equalsIgnoreCase("false")){
		logger.log(LogStatus.PASS, "Successfully verified that SBH ID is NOT valid and Red Cross Mark is displayed"); 
		//toasterMsg=customerPA.verifyMessage();
		/*if(toasterMsg.equalsIgnoreCase("Invalid SBH")){
			logger.log(LogStatus.PASS, "Successfully verified toaster message is diplayed as:"+toasterMsg); 
		}else if(toasterMsg.equalsIgnoreCase("SBH already added")){
			logger.log(LogStatus.PASS, "Successfully verified toaster message is diplayed as:"+toasterMsg); 
		}else{
			logger.log(LogStatus.INFO, "SBH ID is NOT valid but no message is displayed to user");  
		}*/}
	}else{
		logger.log(LogStatus.FAIL, "Failed to validate SBH ID");  
	}
	//return toasterMsg;
}
}

/**
*Click Save button .
*
* @param None
* 
* @return None
*/
public void clickSave() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getSaveBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			logger.log(LogStatus.PASS, "Successfully verified SAVE button is enabled");  
			element.click();
		}else{
			logger.log(LogStatus.FAIL, "Verified SAVE button is disabled");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for SAVE button Failed");   
	}	
}

/**
*Click OK button on the confirmation Message .
*
* @param None
* 
* @return None
*/
public void clickCancel() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getCancelBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			element.click();
			logger.log(LogStatus.PASS, "Successfully verified Cancel button is enabled and clicked on it");  	
		}else{
			logger.log(LogStatus.FAIL, "Cancel button is disabled while adding SBH");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Cancel button Failed");   
	}	
}

/**
*Click OK button on the confirmation Message .
*
* @param None
* 
* @return None
*/
public void clickOk() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getCnfOkBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			logger.log(LogStatus.PASS, "Successfully verified Confirmation Message is displayed and clicked on OK button while adding SBH");  
			element.click();
		}else{
			logger.log(LogStatus.FAIL, "Verified Confirmation Message is NOT displayed while adding SBH");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for OK button on Confirmation Message Failed");   
	}	
}

/**
*Click Cancel button on the confirmation Message .
*
* @param None
* 
* @return None
*/
public void clickCnfCancel() {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getCnfCancelBtn();
	if(element!= null){
		if(WebElementCommon.isElementEnabledByEle(element)){
			logger.log(LogStatus.PASS, "Successfully verified Confirmation Message is displayed and clicked on Cancel button while adding SBH");  
			element.click();
		}else{
			logger.log(LogStatus.FAIL, "Verified Confirmation Message is NOT displayed while adding SBH");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Cancel button on Confirmation Message Failed");   
	}	
}

/**
*Verify device has been added in the device list .
*
* @param None
* 
* @return None
*/
public void verifyDeviceAdded(String deviceId) {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getDeviceList();
	if(element!= null){
		element=element.findElement(By.xpath("//div[@id='"+deviceId+"']"));
		if(WebElementCommon.isDisplayedByElement(element)){
			logger.log(LogStatus.PASS, "Successfully verified SBH device has been added to device list for the customer");  
		}else{
			logger.log(LogStatus.FAIL, "SBH is not present in the Device list for the customer");  
			}	
	}else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Device list on SBH page Failed");   
	}	
}

/**
*Verify device has been added in the device list .
*
* @param None
* 
* @return None
*/
public String getAddedDevice() {
	String deviceId=null;
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	 element=setupSBH.getDeviceList();
	 element=element.findElement(By.xpath("//li/div[1]"));
	if(element!= null){
		deviceId=element.getAttribute("innerText");
			logger.log(LogStatus.PASS, "Successfully verified SBH device is present for the customer with first device as: "+deviceId);  
		}else{
			logger.log(LogStatus.FAIL, "No SBH is present in the Device list for the customer");  
			}	
	return deviceId;
}

/**
*Click on remove button on added device.
*
* @param None
* 
* @return None
*/
public void clickRemove(String deviceId) {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	element=driver.findElement(By.cssSelector("div.form-control.setup-form.margin-btm>div[id='Remove_"+deviceId+"']"));
	 if (element!=null) {
	    	logger.log(LogStatus.PASS, "Remove button for SBH Id: "+deviceId+" is present.");  
	    element.click();
	    logger.log(LogStatus.PASS, "Successfully clicked on Remove button for SBH Id: "+deviceId+".");
	    element=setupSBH.getdeleteBtn();
	    	 if(element!=null){
	    		 element.click();
	    		 logger.log(LogStatus.PASS, "Successfully confirmed to remove SBH with Id: "+deviceId+"");  
	    	 }else{
	    		 logger.log(LogStatus.FAIL, "Failed to idetify Yes button on Confirmation Message");  
	    	 }
	/*List<WebElement> elements=setupSBH.getDeviceTiles();
	if(elements.size()>0){
		Iterator<WebElement> iter = elements.iterator();
		while(iter.hasNext()) {
		    WebElement ele = iter.next();
		   // String att=ele.getAttribute("id");
		    try{
		    element=ele.findElement(By.xpath("div[@id='Remove_"+deviceId+"']"));
		    if (element!=null) {
		    	logger.log(LogStatus.PASS, "Remove button for SBH Id: "+deviceId+" is present.");  
		    element.click();
		    logger.log(LogStatus.PASS, "Successfully clicked on Remove button for SBH Id: "+deviceId+".");
		    element=setupSBH.getdeleteBtn();
		    	 if(element!=null){
		    		 element.click();
		    		 logger.log(LogStatus.PASS, "Successfully confirmed to remove SBH with Id: "+deviceId+"");  
		    	 }
		    	 break;
		    }
		    }catch(Exception e){
		    	System.out.println(e);
		    }
		}  	*/
}else{
	logger.log(LogStatus.FAIL, "No device is present for the customer");  
	}	
}

/**
*
*Verify added device has no Site Mapped .
* @param device id
* 
* @return None
*/
public void verifySiteMapping(String deviceId,String siteName) {
	
	VERASYS_SetUp_Create_SBH_Page_Factory setupSBH=new VERASYS_SetUp_Create_SBH_Page_Factory(driver);
	List<WebElement> elements=setupSBH.getDeviceTiles();
	if(elements.size()>0){
		Iterator<WebElement> iter = elements.iterator();
		while(iter.hasNext()) {
		    WebElement ele = iter.next();
		   // String att=ele.getAttribute("id");
		    if (ele.getAttribute("id").equalsIgnoreCase(deviceId)) {
		    	logger.log(LogStatus.PASS, "Device Id: "+deviceId+" is present.");  
		    	ele= ele.findElement(By.cssSelector("div[id*='"+siteName+"']"));
		    	 if(ele.isDisplayed()){
		    		 logger.log(LogStatus.PASS, "Device Id: "+deviceId+" is present with site name "+ ele.getAttribute("id").toString());  
		    		 break;
		    	 }
		    }
		}  	
}else{
	logger.log(LogStatus.FAIL, "No device is present for the customer");  
	}	
}


/**
* Add new device to existing customer.
*
* @param CustomerName ,Device name
* 
* @return None
 * @throws IOException 
*/
public boolean addDevice(String customerName,String deviceId) throws IOException {

	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	 customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 customerPA.waitPageLoad();
	 enterSBHId(deviceId);
	 clickValidateSBH();
	 validateSBH();
	 clickSave();
	 clickOk();
	String toasterMsg=customerPA.verifyMessage();
	BaseClass.getScreenShot(driver, "SBH added successfully", logger);
	 if(toasterMsg.equalsIgnoreCase("SBH added successfully!"))
	{
		 logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg);  
		 //customerPA.waitPageLoad();
		 verifyDeviceAdded(deviceId);
		 verifySiteMapping(deviceId,"Site Not Mapped");
		 return true;
	}
	return false;
}

/**
* Verify Cancel button.
*
* @param CustomerName ,Device name
* 
* @return None
 * @throws IOException 
*/
public boolean verifyCancel(String customerName,String deviceId) throws IOException {

	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	 customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 customerPA.waitPageLoad();
	 enterSBHId(deviceId);
	 clickCancel();
	 String SBH=getSBHID();
	 if(SBH.isEmpty()){
		 logger.log(LogStatus.PASS, "Successfully verified SBH id Input field is blank");  
		 return true;
	 }
	 return false;
}

/**
* Verify Cancel button on Confirmation Message.
*
* @param CustomerName ,Device name
* 
* @return None
 * @throws IOException 
*/
public boolean verifyCnfCancel(String customerName,String deviceId) throws IOException {

	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	 customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 customerPA.waitPageLoad();
	 enterSBHId(deviceId);
	 clickValidateSBH();
	 validateSBH();
	 clickSave();
	 clickCnfCancel();
	 verifyValidateSBH();
	 String SBH=getSBHID();
	 if(SBH.isEmpty()){
		 logger.log(LogStatus.PASS, "Successfully verified SBH id Input field is blank");  
		 return true;
	 }
	 return false;
}

/**
* Add incorrect device to existing customer.
*
* @param CustomerName ,Device name
* 
* @return None
 * @throws IOException 
*/
public boolean validateIncorrectDevice(String customerName,String deviceId) throws IOException {

	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	 customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 customerPA.waitPageLoad();
	 enterSBHId(deviceId+"X");
	 clickValidateSBH();
	 validateSBH();
	 clickValidateSBH();
	String toasterMsg=customerPA.verifyMessage();
	//BaseClass.getScreenShot(driver, "SBH added successfully", logger);
	 if(toasterMsg.equalsIgnoreCase("Invalid SBH"))
	{
		 logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg);  
		 return true;
	}
	return false;
}

/**
* Add existing device id to customer.
*
* @param CustomerName
* 
* @return None
 * @throws IOException 
*/
public boolean validateAddedDevice(String customerName) throws IOException {
	String deviceId=null;
	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	 customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 customerPA.waitPageLoad();
	 deviceId=getAddedDevice();
	 enterSBHId(deviceId);
	 clickValidateSBH();
	 validateSBH();
	 clickValidateSBH();
	String toasterMsg=customerPA.verifyMessage();
	//BaseClass.getScreenShot(driver, "SBH added successfully", logger);
	 if(toasterMsg.equalsIgnoreCase("SBH already added"))
	{
		 logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg);  
		 return true;
	}
	return false;
}

/**
* Remove existing device id from customer.
*
* @param CustomerName ,Device name
* 
* @return None
 * @throws IOException 
*/
public boolean validateRemoveDevice(String customerName,String deviceId) throws IOException {
	
	VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
	 
	 clickSBHTab();
	// customerPA.waitPageLoad();
	 selectCustomer(customerName);
	 clickRemove(deviceId);
	 customerPA.waitPageLoad();
	String toasterMsg=customerPA.verifyMessage();
	BaseClass.getScreenShot(driver, "SBH deleted successfully", logger);
	 if(toasterMsg.equalsIgnoreCase("Device deleted successfully"))
	{
		 logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg);  
		 return true;
	}
	return false;
}
}
