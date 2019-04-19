/**
 * 
 */
package mars.JCI.Project.CSD.Functionality.Notification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Functionality.Notification.CSD_NOTIF_ConfigureNotification_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_NOTIF_ConfigureNotification_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_NOTIF_ConfigureNotification_Page_Factory notifPageFactory = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	public static String notifCustName,notifFacilityName = null;
	
	public CSD_NOTIF_ConfigureNotification_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		notifPageFactory = new CSD_NOTIF_ConfigureNotification_Page_Factory(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
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
	
	public static String getSelectedOptionFromDropDown(WebElement element) {
		
		Select sel_element_Val = new Select(element);
		String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
		return element_Val_text;
	}
	
	
	//==========WebElement related metods--START ------------------
	
	//Click on the Config Notification Tab of the Left Sided Tree
	public static void clickOnConfigNotificationLink(){
		WebElement element=notifPageFactory.get_notification_AdministrationLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement notif_element=notifPageFactory.get_notification_NotificationLink();
			notif_element.click();
			waitForSpinnerToDisappear();
			WebElement configNotif_element=notifPageFactory.get_notification_ConfigNotificationLink();
			configNotif_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Config Notification Link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Config Notification Link");
		}
	}
	
	//Set the Customer for which we are to set the Alarm Notifications
	public static void selectCustomerNameLink(String custName){
		WebElement element=notifPageFactory.get_notification_CustNameDDLLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			notifCustName = custName;
			selectByVisibleText(element,notifCustName);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Required Customer Name is Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Customer Name.");
		}
	}
	
	//Set the Facility for which we are to set the Alarm Notifications
	public static void selectFacilityNameLink(String facilityName) throws InterruptedException{
		WebElement element=notifPageFactory.get_notification_FacilityNameDDLLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			notifFacilityName = facilityName;
			Thread.sleep(1500);
			selectByVisibleText(element,notifFacilityName);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Required Facility Name is Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Facility Name.");
		}
	}
	
	//Set the Alarm Type
	public static void clickAlarmTypeLink(){
		WebElement element=notifPageFactory.get_notification_AlarmTypeMultipleDDLLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement alarmType_element=notifPageFactory.get_notification_AlarmTypeALLLink();
			alarmType_element.click();
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Type CheckList is Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Alarm Type CheckList.");
		}
	}
	
	//Set the Notification CheckBox
	public static void clickSetNotificationCheckBox(){
		WebElement element=notifPageFactory.get_notification_CN_SetNotifLink();
		waitForSpinnerToDisappear();
		if (element != null) {
			if (element != null && element.isSelected()) {
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.PASS, "Alarm Notification is Set successfully. CheckBox is already Checked.");
			} else {
				element.click();
				logger.log(LogStatus.FAIL, "Alarm Notification is Set successfully. CheckBox is Set.");
			} 
		}else {
			logger.log(LogStatus.FAIL, "Failed to set Alarm Notification.");
		} 
	}
	
	//Configure the Alarm Notification Details
	public static void clickConfigureLink(){
		WebElement element=notifPageFactory.get_notification_ConfigureLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Configure Link is Clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Alarm Type CheckList.");
		}
	}
	
	//Configure the Alarm Notification Details -- Critical Alarm Section
	public static void selectBranchUserCriticalAlarm(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CA_BranchUSerDDLLink();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement allNames_element=notifPageFactory.get_notification_CA_BranchUSerCheckALLLink();
			allNames_element.click();
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Branch User Names selected successfully -- Critical Alarm Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Branch User Names.");
		}
	}
	
	//Configure the Notification Frequency Details -- Critical Alarm Section
	public static void selectNotifFrequencyCriticalAlarm(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CA_NotifFreqDDLLink();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement notifFreq_element=notifPageFactory.get_notification_CA_NotifFreqCheckALLLink();
			notifFreq_element.click();
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Frequency Details selected successfully -- Critical Alarm Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Frequency Details.");
		}
	}
	
	//Configure the Notification Type Details -- SMS -- Critical Alarm Section
	public static void selectNotifTypeSMSCriticalAlarm(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CA_BranchUserSMSLink();
		if (element !=null && !element.isSelected()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Type SMS selected successfully -- Critical Alarm Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}
	
	//Configure the Notification Type Details -- EMAIL -- Critical Alarm Section
	public static void selectNotifTypeEMAILCriticalAlarm(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CA_BranchUserEMAILLink();
		if (element !=null && !element.isSelected()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Type EMAIL selected successfully -- Critical Alarm Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}
	
	//Configure the Alarm Notification branch name Details -- Health Check Section
	public static void selectBranchUserHealthCheck(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_HC_BranchUSerDDLLink();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement allNames_element=notifPageFactory.get_notification_HC_BranchUSerCheckALLLink();
			allNames_element.click();
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Branch User Names selected successfully -- Health Check Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Branch User Names.");
		}
	}
	
	//Configure the Alarm Notification frequency Details -- Health Check Section
	public static void selectNotifFreqHealthCheck(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_HC_NotifFreqDDLLink();
		if (element !=null) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement allNames_element=notifPageFactory.get_notification_HC_NotifFreqCheckALLLink();
			allNames_element.click();
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Frequency selected successfully -- Health Check Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Frequency.");
		}
	}
	
	//Configure the Notification Type Details -- SMS -- Critical Alarm Section
	public static void selectNotifTypeSMSHealthCheck(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_HC_BranchUserSMSLink();
		if (element !=null && !element.isSelected()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Type SMS selected successfully -- Health Check Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}

	//Configure the Notification Type Details -- EMAIL -- Critical Alarm Section
	public static void selectNotifTypeEMAILHealthCheck(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_HC_BranchUserEMAILLink();
		if (element !=null && !element.isSelected()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Type SMS selected successfully -- Health Check Section");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}
	
	//Configure the Notification Type Details -- ADD Button Click
	public static void clickADDNotifDetailsButton(){
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CN_ADDButton();
		if (element !=null && !element.isSelected()) {
			element.click();
			waitForSpinnerToDisappear();
			WebElement popup_element=notifPageFactory.get_csd_PopUpLink();
			popup_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Alarm Notification Details -- Notification Details Added");
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}
	
	//Configure the Notification Type Details -- Check if Notifications Set Properly
	public static void checkNotificationTrue(String custAction) throws InterruptedException{
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CN_SearchCustomerNameLink();
		if (element !=null && !element.isSelected()) {
			Thread.sleep(2000);
			logger.log(LogStatus.INFO, "Searching for the Customer for Set Notification True");
			System.out.println("notifCustName "+custAction+"ing :"+notifCustName);
			element.sendKeys(notifCustName);
			Thread.sleep(2000);
			WebElement tableRowElement = notifPageFactory.get_notification_CN_SearchOutput();
			if(tableRowElement != null){
				WebElement searchResult = driver.findElement(By.cssSelector("div[id='grdConfigureNotification'] > table > tbody > tr > td:nth-child(3)"));
				String custName = searchResult.getText();
				if(custName.equals(notifCustName)){
					logger.log(LogStatus.PASS, "Proper Customer Name is Getting Reflected under the Grid");
					searchResult.click();
					waitForSpinnerToDisappear();
					WebElement custNameDDL = notifPageFactory.get_notification_CustNameDDLLink();
					if(custName.equals(getSelectedOptionFromDropDown(custNameDDL))){
						logger.log(LogStatus.INFO, "Proper Customer is Ready to be configured!");
						notifPageFactory.get_notification_ConfigureLink().click();
						if(custAction.equals("update")){
							//updateCustOnConfigure();
							updateCustOnConfigure2();
						}else if(custAction.equals("delete")){
							deleteCustOnConfigure();
						}
					}
				}else { 
					logger.log(LogStatus.FAIL, "Error encountered while validating Customer Name under Grid table.");
				}
				
			}else{
				logger.log(LogStatus.FAIL, "No Such search result is reflected under the Grid.");
			}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Notification Type SMS.");
		}
	}
	
	
	//Update customer on Configure Click 
	public static void updateCustOnConfigure() {
		
		waitForSpinnerToDisappear();
		WebElement setSMSupdate = notifPageFactory.get_notification_CA_BranchUserSMSLink();
		if (setSMSupdate != null && !setSMSupdate.isSelected()) {
			selectBranchUserCriticalAlarm();
			selectNotifFrequencyCriticalAlarm();
			selectNotifTypeSMSCriticalAlarm();
			selectNotifTypeEMAILCriticalAlarm();
			selectBranchUserHealthCheck();
			selectNotifFreqHealthCheck();
			selectNotifTypeSMSHealthCheck();
			selectNotifTypeEMAILHealthCheck();
			logger.log(LogStatus.INFO, "Updating Notification Settings -- All Mendatory Fields.");
			waitForSpinnerToDisappear();
			WebElement setUpdateButton = notifPageFactory.get_notification_CN_UPDATEButton();
			setUpdateButton.click();
			waitForSpinnerToDisappear();
			WebElement popUP = notifPageFactory.get_csd_PopUpLink();
			popUP.click();
			logger.log(LogStatus.PASS, "Updating Notification Settings -- UPDATED.");
		}else{
			logger.log(LogStatus.FAIL, "Error in Updating Notification Settings.");
		}
	}
	
	//Update customer on Configure Click 
	public static void updateCustOnConfigure2() {
		
		waitForSpinnerToDisappear();
		WebElement setSMSupdate = notifPageFactory.get_notification_CA_BranchUserSMSLink();
		if (setSMSupdate != null && setSMSupdate.isSelected()) {
			/*selectBranchUserCriticalAlarm();
			selectNotifFrequencyCriticalAlarm();
			selectNotifTypeSMSCriticalAlarm();
			selectNotifTypeEMAILCriticalAlarm();
			selectBranchUserHealthCheck();
			selectNotifFreqHealthCheck();
			selectNotifTypeSMSHealthCheck();
			selectNotifTypeEMAILHealthCheck();*/
			setSMSupdate.click();
			//logger.log(LogStatus.INFO, "Updating Notification Settings -- All Mendatory Fields.");
			logger.log(LogStatus.INFO, "Updating Notification Settings -- SMS Update.");
			waitForSpinnerToDisappear();
			WebElement setUpdateButton = notifPageFactory.get_notification_CN_UPDATEButton();
			setUpdateButton.click();
			waitForSpinnerToDisappear();
			WebElement popUP = notifPageFactory.get_csd_PopUpLink();
			popUP.click();
			logger.log(LogStatus.PASS, "Updating Notification Settings -- UPDATED.");
		}else{
			logger.log(LogStatus.FAIL, "Error in Updating Notification Settings.");
		}
	}
	
	//Delete customer on Configure Click 
	public static void deleteCustOnConfigure() {
		
		waitForSpinnerToDisappear();
		WebElement setSMSupdate = notifPageFactory.get_notification_CA_BranchUserSMSLink();
		if (setSMSupdate != null && !setSMSupdate.isSelected()) {
			logger.log(LogStatus.INFO, "Updating Notification Settings -- Deleting ...");
			waitForSpinnerToDisappear();
			WebElement setUpdateButton = notifPageFactory.get_notification_CN_DELETEButton();
			setUpdateButton.click();
			waitForSpinnerToDisappear();
			WebElement popUP = notifPageFactory.get_csd_PopUpLink();
			popUP.click();
			waitForSpinnerToDisappear();
			WebElement popUPConf = notifPageFactory.get_csd_PopUpLink();
			popUPConf.click();
			logger.log(LogStatus.PASS, "Updating Notification Settings -- DELETED.");
		}else{
			logger.log(LogStatus.FAIL, "Error in Updating Notification Settings.");
		}
	}
	
	//Check if Delete is successful
	public static void checkIfDeleteIsSuccessful() throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement element=notifPageFactory.get_notification_CN_SearchCustomerNameLink();
		if (element !=null && !element.isSelected()) {
			logger.log(LogStatus.INFO, "Searching for the Customer for Delete Successful");
			element.sendKeys(notifCustName);
			Thread.sleep(2000);
			WebElement tableRowElement = notifPageFactory.get_notification_CN_SearchOutput();
			if(tableRowElement == null){
				logger.log(LogStatus.PASS, "No Results Found. Respective Customer name is Deleted Successfully.");
				
			}else{
				logger.log(LogStatus.FAIL, "Search result is still reflected under the Grid.");
			}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			
		}else{
			logger.log(LogStatus.FAIL, "Failed to search Customer Name for Delete Successful.");
		}
		
		
	}
}
