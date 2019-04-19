/**
 * 
 */
package mars.JCI.Project.CSD.Functionality.Notification;

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
public class CSD_NOTIF_ConfigureNotification_Page_Factory {
	
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_NOTIF_ConfigureNotification_Page_Factory(WebDriver driver, ExtentTest logger) {
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
	private WebElement notification_AdministrationLink;
		
	public WebElement get_notification_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_AdministrationLink, logger)){
			return notification_AdministrationLink;
		}else
			return null;
	}
	
	//The Notification Tab
	@FindBy(css="a[test-id='Notification-tab']")
	private WebElement notification_NotificationLink;
		
	public WebElement get_notification_NotificationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_NotificationLink, logger)){
			return notification_NotificationLink;
		}else
			return null;
	}
	
	//The Configure Notification Tab
	@FindBy(css="a[test-id='ConfigNotification-tab']")
	private WebElement notification_ConfigNotificationLink;
		
	public WebElement get_notification_ConfigNotificationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_ConfigNotificationLink, logger)){
			return notification_ConfigNotificationLink;
		}else
			return null;
	}
	
	
	//The Customer Names DropDown List
	@FindBy(css="select[name='customerId']")
	private WebElement notification_CustNameDDLLink;
		
	public WebElement get_notification_CustNameDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CustNameDDLLink, logger)){
			return notification_CustNameDDLLink;
		}else
			return null;
	}
	
	//The Facility/Project Names DropDown List
	@FindBy(css="select[name='projectId']")
	private WebElement notification_FacilityNameDDLLink;
		
	public WebElement get_notification_FacilityNameDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_FacilityNameDDLLink, logger)){
			return notification_FacilityNameDDLLink;
		}else
			return null;
	}
	
	//The Alarm Type Multiple Select DropDown Section
	@FindBy(css="#wrap > div > div > div > div > div > div > div.ng-scope > div > div > configure-notification-dir > div.col-md-12 > div > div > div > form > div:nth-child(2) > div:nth-child(1) > div > div:nth-child(2) > span > div > button > span.button_text_span.ng-binding")
	private WebElement notification_AlarmTypeMultipleDDLLink;
		
	public WebElement get_notification_AlarmTypeMultipleDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_AlarmTypeMultipleDDLLink, logger)){
			return notification_AlarmTypeMultipleDDLLink;
		}else
			return null;
	}
	
	//The Alarm Type Multiple Select DropDown Section -- Select All Alarm Types
	@FindBy(css="#wrap > div > div > div > div > div > div > div.ng-scope > div > div > configure-notification-dir > div.col-md-12 > div > div > div > form > div:nth-child(2) > div:nth-child(1) > div > div:nth-child(2) > span > div > ul > li:nth-child(1) > a")
	private WebElement notification_AlarmTypeALLLink;
		
	public WebElement get_notification_AlarmTypeALLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_AlarmTypeALLLink, logger)){
			return notification_AlarmTypeALLLink;
		}else
			return null;
	}
	
	//The Configure Alarm -- Button Element
	@FindBy(css="input[id='btnConfigureNotification'][value='Configure']")
	private WebElement notification_ConfigureLink;
		
	public WebElement get_notification_ConfigureLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_ConfigureLink, logger)){
			return notification_ConfigureLink;
		}else
			return null;
	}

	//The Critical Alarm -- Branch USER - DropDown Selection 
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div > div:nth-child(1) > div > div:nth-child(2) > span > div > button")
	private WebElement notification_CA_BranchUSerDDLLink;
		
	public WebElement get_notification_CA_BranchUSerDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_BranchUSerDDLLink, logger)){
			return notification_CA_BranchUSerDDLLink;
		}else
			return null;
	}
	
	//The Critical Alarm -- Branch USER - Check ALL Selection  
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div > div:nth-child(1) > div > div:nth-child(2) > span > div > ul > li:nth-child(1) > a")
	private WebElement notification_CA_BranchUSerCheckALLLink;
		
	public WebElement get_notification_CA_BranchUSerCheckALLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_BranchUSerCheckALLLink, logger)){
			return notification_CA_BranchUSerCheckALLLink;
		}else
			return null;
	}
	
	//The Critical Alarm -- Branch USER - Notification Frequency DropDown Selection 
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div > div:nth-child(2) > div > div:nth-child(2) > span > div > button")
	private WebElement notification_CA_NotifFreqDDLLink;
		
	public WebElement get_notification_CA_NotifFreqDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_NotifFreqDDLLink, logger)){
			return notification_CA_NotifFreqDDLLink;
		}else
			return null;
	}
	
	//The Critical Alarm -- Branch USER - Notification Frequency CheckALL Selection 
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div > div:nth-child(2) > div > div:nth-child(2) > span > div > ul > li:nth-child(1) > a")
	private WebElement notification_CA_NotifFreqCheckALLLink;
		
	public WebElement get_notification_CA_NotifFreqCheckALLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_NotifFreqCheckALLLink, logger)){
			return notification_CA_NotifFreqCheckALLLink;
		}else
			return null;
	}
	
	//The Critical Alarm -- Branch USER - SMS Selection
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div:nth-child(2) >div > div > div:nth-child(2) > div:nth-child(1) > input")
	private WebElement notification_CA_BranchUserSMSLink;
		
	public WebElement get_notification_CA_BranchUserSMSLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_BranchUserSMSLink, logger)){
			return notification_CA_BranchUserSMSLink;
		}else
			return null;
	}
	
	//The Critical Alarm -- Branch USER - EMAIL Selection
	@FindBy(css="div[id='rapAlarmId'] > div:nth-child(2) > div > div:nth-child(2) >div > div > div:nth-child(2) > div:nth-child(2) > input")
	private WebElement notification_CA_BranchUserEMAILLink;
		
	public WebElement get_notification_CA_BranchUserEMAILLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CA_BranchUserEMAILLink, logger)){
			return notification_CA_BranchUserEMAILLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - Name DropDown Button Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div > div:nth-child(1) > div > div:nth-child(2) > span > div > button")
	private WebElement notification_HC_BranchUSerDDLLink;
		
	public WebElement get_notification_HC_BranchUSerDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_BranchUSerDDLLink, logger)){
			return notification_HC_BranchUSerDDLLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - Name CheckALL Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div > div:nth-child(1) > div > div:nth-child(2) > span > div > ul > li:nth-child(1) > a")
	private WebElement notification_HC_BranchUSerCheckALLLink;
		
	public WebElement get_notification_HC_BranchUSerCheckALLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_BranchUSerCheckALLLink, logger)){
			return notification_HC_BranchUSerCheckALLLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - Notification Frequency DropDown Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div > div:nth-child(2) > div > div:nth-child(2) > span > div > button")
	private WebElement notification_HC_NotifFreqDDLLink;
		
	public WebElement get_notification_HC_NotifFreqDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_NotifFreqDDLLink, logger)){
			return notification_HC_NotifFreqDDLLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - Notification Frequency Check ALL Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div > div:nth-child(2) > div > div:nth-child(2) > span > div > ul > li:nth-child(1) > a")
	private WebElement notification_HC_NotifFreqCheckALLLink;
		
	public WebElement get_notification_HC_NotifFreqCheckALLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_NotifFreqCheckALLLink, logger)){
			return notification_HC_NotifFreqCheckALLLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - SMS Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div:nth-child(2) >div > div > div:nth-child(2) > div:nth-child(1) > input")
	private WebElement notification_HC_BranchUserSMSLink;
		
	public WebElement get_notification_HC_BranchUserSMSLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_BranchUserSMSLink, logger)){
			return notification_HC_BranchUserSMSLink;
		}else
			return null;
	}
	
	//The Health Check -- Branch USER - EMAIL Selection
	@FindBy(css="div[id='healthCheckId'] > div:nth-child(2) > div > div:nth-child(2) >div > div > div:nth-child(2) > div:nth-child(2) > input")
	private WebElement notification_HC_BranchUserEMAILLink;
		
	public WebElement get_notification_HC_BranchUserEMAILLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_HC_BranchUserEMAILLink, logger)){
			return notification_HC_BranchUserEMAILLink;
		}else
			return null;
	}
	
	//The Configure Notification POP UP -- ADD Button
	@FindBy(css="button[id='btnAdd']")
	private WebElement notification_CN_ADDButton;
		
	public WebElement get_notification_CN_ADDButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_ADDButton, logger)){
			return notification_CN_ADDButton;
		}else
			return null;
	}
	
	//The Configure Notification POP UP -- UPDATE Button
	@FindBy(css="button[id='btnUpdate']")
	private WebElement notification_CN_UPDATEButton;
		
	public WebElement get_notification_CN_UPDATEButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_UPDATEButton, logger)){
			return notification_CN_UPDATEButton;
		}else
			return null;
	}
	
	//The Configure Notification POP UP -- DELETE Button
	@FindBy(css="button[id='btnDelete']")
	private WebElement notification_CN_DELETEButton;
		
	public WebElement get_notification_CN_DELETEButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_DELETEButton, logger)){
			return notification_CN_DELETEButton;
		}else
			return null;
	}
	
	//The Configure Notification POP UP -- CLEAR Button
	@FindBy(css="button[id='btnClearPop']")
	private WebElement notification_CN_CLEARButton;
		
	public WebElement get_notification_CN_CLEARButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_CLEARButton, logger)){
			return notification_CN_CLEARButton;
		}else
			return null;
	}
	
	//The Configure Notification POP UP -- CANCEL Button
	@FindBy(css="button[id='btnCancel']")
	private WebElement notification_CN_CANCELButton;
		
	public WebElement get_notification_CN_CANCELButton(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_CANCELButton, logger)){
			return notification_CN_CANCELButton;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Search By Customer Name -- TextBox Field
	@FindBy(css="input[name='Customer_Name']")
	private WebElement notification_CN_SearchCustomerNameLink;
		
	public WebElement get_notification_CN_SearchCustomerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_SearchCustomerNameLink, logger)){
			return notification_CN_SearchCustomerNameLink;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Search By Facility Name -- TextBox Field
	@FindBy(css="input[name='ProjectName']")
	private WebElement notification_CN_SearchFacilityNameLink;
		
	public WebElement get_notification_CN_SearchFacilityNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_SearchFacilityNameLink, logger)){
			return notification_CN_SearchFacilityNameLink;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Search By Alarm Type -- TextBox Field
	@FindBy(css="input[name='AlarmType']")
	private WebElement notification_CN_SearchAlarmTypeLink;
		
	public WebElement get_notification_CN_SearchAlarmTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_SearchAlarmTypeLink, logger)){
			return notification_CN_SearchAlarmTypeLink;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Search By Set Notification -- TextBox Field
	@FindBy(css="input[name='IsEnable']")
	private WebElement notification_CN_SearchSetNotifLink;
		
	public WebElement get_notification_CN_SearchSetNotifLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_SearchSetNotifLink, logger)){
			return notification_CN_SearchSetNotifLink;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Set Notification -- CheckBox
	@FindBy(css="#wrap > div > div > div > div > div > div > div.ng-scope > div > div > configure-notification-dir > div.col-md-12 > div > div > div > form > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > input")
	private WebElement notification_CN_SetNotifLink;
		
	public WebElement get_notification_CN_SetNotifLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, notification_CN_SetNotifLink, logger)){
			return notification_CN_SetNotifLink;
		}else
			return null;
	}
	
	//The Configure Notification Page -- Search Output -- Grid Table 
	@FindBy(css="div[id='grdConfigureNotification'] > table > tbody > tr")
	private WebElement notification_CN_SearchOutput;
		
	public WebElement get_notification_CN_SearchOutput(){
		if(waitForElementPresent(driver, notification_CN_SearchOutput, logger)){
			return notification_CN_SearchOutput;
		}else
			return null;
	}
	
	
	
	
	//Generic POP UP Element
	@FindBy(css="input[id='popup_ok']")
	private WebElement csd_PopUpLink;
		
	public WebElement get_csd_PopUpLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, csd_PopUpLink, logger)){
			return csd_PopUpLink;
		}else
			return null;
	}
	
	
	
}
