package mars.JCI.Project.VERASYS.SetUp;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;

public class VERASYS_SetUp_SBH_Association_Page_Action {

	/** The Selenium driver. */
	public WebDriver driver;

	/** The ExtentTest logger. */
	private ExtentTest logger;

	/** The WebElement/Locator element. */
	private WebElement element;
	/**
	 * Instantiates/Constructor a new Verasys SBH page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public VERASYS_SetUp_SBH_Association_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/**
	 * Click SBH Association Tab is .
	 *
	 * @return boolean
	 */
	public void clickSBHTab(){
		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
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

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
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
	 * Verify SBH ID drop down is disabled.
	 *
	 * 
	 * @return None
	 */
	public void verifySBHId() {

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		WebElementCommon.staticWait(100);
		element=setupSBH.getSBHId();
		Select select = new Select(element);
		if(select.getFirstSelectedOption()!=null){
			if(!element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified SBH ID drop down is Disabled and Populated as "+element.getAttribute("innerText"));  
			}else{
				logger.log(LogStatus.FAIL, "Verified SBH ID field is present but enabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified SBH ID field is NOT selected");   
		}
	}
	/**
	 * Verify SBH ID drop down is enabled.
	 *
	 * 
	 * @return None
	 */
	public void CheckSBHEnabled() {

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		
		element=setupSBH.getSBHId();
		Select select = new Select(element);
		if(select.getFirstSelectedOption().getText().equalsIgnoreCase("Select SBH")){
			if(element.isEnabled()){
				logger.log(LogStatus.PASS, "Successfully verified SBH ID drop down is enabled");  
				
				WebElementCommon.staticWait(2000);
				element=setupSBH.getSaveBtn();
				element.click();
				if(element.getAttribute("ng-reflect-disabled").equalsIgnoreCase("false")){
					logger.log(LogStatus.PASS, "Successfully verified when no device is mapped to selected site Save button is enabled");  
				}else{
					logger.log(LogStatus.FAIL, "Verified Save button is disabled even when no device is mapped to site selected"); 
				}
				
				element=setupSBH.getRemoveBtn();
				if(!element.isEnabled()){
					logger.log(LogStatus.PASS, "Successfully verified when no device is mapped to selected site Remove button is disabled");  
				}else{
					logger.log(LogStatus.FAIL, "Verified Remove button is enabled even when no device is mapped to site selected"); 
				}
			}else{
				logger.log(LogStatus.FAIL, "Verified SBH ID field is present but disabled");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified SBH ID field is NOT selected");   
		}
	}
	
	/**
	 * Verify SBH ID drop down is enabled.
	 *
	 * 
	 * @return None
	 */
	public void CheckSBHDisabled() {

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		element=setupSBH.getSBHId();
		
			if(element.getAttribute("ng-reflect-is-disabled").equalsIgnoreCase("true")){
				logger.log(LogStatus.PASS, "Successfully verified SBH ID drop down is disabled");  
				
				//Save button
				element=setupSBH.getSaveBtn();
				if(!element.isEnabled()){
					logger.log(LogStatus.PASS, "Successfully verified when device is mapped to selected site Save button is disabled");  
				}else{
					logger.log(LogStatus.FAIL, "Verified Save button is enabled even when device is already mapped to site selected"); 
				}
				// Verify site name
				element=setupSBH.getSiteName();
				if(!element.getText().isEmpty()){
					logger.log(LogStatus.PASS, "Successfully verified Site name is populated when device is mapped to selected site as "+element.getText());  
				}else{
					logger.log(LogStatus.FAIL, "Verified site name is not present when device is mapped to selected site"); 
				}
				//Remove button
				element=setupSBH.getRemoveBtn();
				if(element.isEnabled()){
					logger.log(LogStatus.PASS, "Successfully verified when device is mapped to selected site Remove button is enabled");  
				}else{
					logger.log(LogStatus.FAIL, "Verified Remove button is disabled even when device is mapped to site selected"); 
				}
			}else{
				logger.log(LogStatus.FAIL, "Verified SBH ID field is present but enabled");  
			}
	}
	/**
	 * Select SBHID from drop down.
	 *
	 * @param SBH ID
	 * 
	 * @return None
	 */
	public void selectSBH(String SBHID) {

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		element=setupSBH.getSBHId();
		if(element!= null){
			if(!element.isSelected()){
				WebDropDown.SelectElementByVisibleText(element,SBHID);
				logger.log(LogStatus.PASS, "Successfully selected SBH ID from the drop down as "+SBHID);  				
				//Select select = new Select(element);  
				}else{
					logger.log(LogStatus.FAIL, "Verified SBHID field is present but already populated");  
				}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for SBHID Field Failed");   
		}
	}
	
	/**
	 * Click Cancel.
	 *
	 * @param 
	 * 
	 * @return None
	 */
	public void clickCancel() {

		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		element=setupSBH.getCancelBtn();
		if(element!= null){
			element.click();
			
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for SBHID Field Failed");   
		}
	}
	/**
	 * Click Save.
	 *
	 * @param 
	 * 
	 * @return None
	 */
	public void clickSave() {
		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		element=setupSBH.getSaveBtn();
		if(element!= null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully Clicked on Save Button");   
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Save button Field Failed");   
		}
	}
	
	/**
	 * Click Remove.
	 *
	 * @param 
	 * 
	 * @return None
	 */
	public void clickRemove() {
		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		element=setupSBH.getRemoveBtn();
		if(element!= null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully Clicked on Remove Button");   
			element=setupSBH.getCnfOkBtn();
			if(element!= null){
				element.click();
			logger.log(LogStatus.PASS, "Successfully Clicked on OK button on confirmation message while removing device");   
			}else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for OK button on confirmation message Field Failed while removing device from site");   
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Remove button Field Failed");   
		}
	}
	
	/**
	 *Verify Site name field.
	 *
	 * @param 
	 * 
	 * @return None
	 */
	public void verifySiteName(String siteName) {
		VERASYS_SetUp_SBH_Association_Page_Factory setupSBH=new VERASYS_SetUp_SBH_Association_Page_Factory(driver);
		element=setupSBH.getSiteName();
		if(element!= null){
			if(element.getText().equalsIgnoreCase(siteName)){
				logger.log(LogStatus.INFO, "Site name field is Populated with "+siteName);  
			}else{
			logger.log(LogStatus.INFO, "Site name field is blank");   
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for site name Field Failed");   
		}
	}
	

	/**
	 * Associate existing device to a site for a customer.
	 *
	 * @param CustomerName,Site name
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean validateDeviceAssociation(String customerName,String siteName,String SBHID) throws IOException {

		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		VERASYS_Setup_Site_Page_Action sitePA= new VERASYS_Setup_Site_Page_Action(driver, logger);
		VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
		clickSBHTab();
		customerPA.waitPageLoad();
		selectCustomer(customerName);
		customerPA.waitPageLoad();
		sitePA.expandAllCountry();
		sitePA.clickSite(siteName);
		CheckSBHEnabled();
		verifySiteName(siteName);
		selectSBH(SBHID);
		WebElementCommon.staticWait(100);
		clickSave();
		String toasterMsg=customerPA.verifyMessage();
		//BaseClass.getScreenShot(driver, "SBH added successfully", logger);
		if(toasterMsg.equalsIgnoreCase(SBHID+" was successfully mapped with site "+siteName))
		{
			logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg);  
			SBHPA.clickSBHTab();
			//customerPA.waitPageLoad();
			SBHPA.selectCustomer(customerName);
			WebElementCommon.staticWait(2000);
			SBHPA.verifySiteMapping(SBHID,siteName);
			return true;
		}
		return false;
	}

	/**
	 * Associate existing device to a site for a customer.
	 *
	 * @param CustomerName,Site name
	 * 
	 * @return None
	 * @throws IOException 
	 */
	public boolean validateDeviceUnmapping(String customerName,String siteName,String SBHID) throws IOException {
		VERASYS_Setup_Customer_Page_Action customerPA=new VERASYS_Setup_Customer_Page_Action(driver, logger);
		VERASYS_Setup_Site_Page_Action sitePA= new VERASYS_Setup_Site_Page_Action(driver, logger);
		VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
		clickSBHTab();
		customerPA.waitPageLoad();
		selectCustomer(customerName);
		customerPA.waitPageLoad();
		sitePA.expandAllCountry();
		WebElementCommon.staticWait(2000);
		sitePA.clickSite(siteName);
		customerPA.waitPageLoad();
		WebElementCommon.staticWait(1000);
		CheckSBHDisabled();
		clickRemove();
		String toasterMsg=customerPA.verifyMessage();
		//BaseClass.getScreenShot(driver, "SBH added successfully", logger);
		if(toasterMsg.equalsIgnoreCase(SBHID+" is successfully removed from site "+siteName))
		{
			logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg); 
			WebElementCommon.staticWait(1000);
			CheckSBHEnabled();
			verifySiteName(siteName);
			SBHPA.clickSBHTab();
			customerPA.waitPageLoad();
			SBHPA.selectCustomer(customerName);
			customerPA.waitPageLoad();
			SBHPA.verifySiteMapping(SBHID,"Site Not Mapped");
			return true;
		}
		return false;
	}

}
