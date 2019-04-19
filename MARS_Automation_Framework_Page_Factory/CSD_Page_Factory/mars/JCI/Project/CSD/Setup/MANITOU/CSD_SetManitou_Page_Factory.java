/**
 * 
 */
package mars.JCI.Project.CSD.Setup.MANITOU;

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
public class CSD_SetManitou_Page_Factory {

	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SetManitou_Page_Factory(WebDriver driver, ExtentTest logger) {
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
	
	//The Home Page Button
	@FindBy(css="a[test-id='btnHome_5']")
	private WebElement manitou_HomeButtonLink;
		
	public WebElement get_manitou_HomeButtonLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_HomeButtonLink, logger)){
			return manitou_HomeButtonLink;
		}else
			return null;
	}
	
	//The Administration Tab
	@FindBy(css="a[test-id='administration-tab']")
	private WebElement manitou_AdministrationLink;
		
	public WebElement get_manitou_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_AdministrationLink, logger)){
			return manitou_AdministrationLink;
		}else
			return null;
	}
	
	//The SCC Tab
	@FindBy(css="a[test-id='SCC-tab']")
	private WebElement manitou_SCCTabLink;
		
	public WebElement get_manitou_SCCTabLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_SCCTabLink, logger)){
			return manitou_SCCTabLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab
	@FindBy(css="a[test-id='RapTestAlarm-tab']")
	private WebElement manitou_RTATabLink;
		
	public WebElement get_manitou_RTATabLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTATabLink, logger)){
			return manitou_RTATabLink;
		}else
			return null;
	}
	
	
	//The RAPTestAlarm Page -- Customer DropDown List
	@FindBy(css="select[automation-id='ddlCustomer']")
	private WebElement manitou_RTA_CustomerDDLLink;
		
	public WebElement get_manitou_RTA_CustomerDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_CustomerDDLLink, logger)){
			return manitou_RTA_CustomerDDLLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Facility/Project DropDown List
	@FindBy(css="select[automation-id='ddlProject']")
	private WebElement manitou_RTA_FacilityDDLLink;
	
	public WebElement get_manitou_RTA_FacilityDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_FacilityDDLLink, logger)){
			return manitou_RTA_FacilityDDLLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Asset DropDown List
	@FindBy(css="select[automation-id='ddlAsset']")
	private WebElement manitou_RTA_AssetDDLLink;
	
	public WebElement get_manitou_RTA_AssetDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_AssetDDLLink, logger)){
			return manitou_RTA_AssetDDLLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Communication Protocol Selection Text
	@FindBy(css="span[automation-id='lblProtocol']")
	private WebElement manitou_RTA_CommProtocolTextLink;
	
	public WebElement get_manitou_RTA_CommProtocolTextLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_CommProtocolTextLink, logger)){
			return manitou_RTA_CommProtocolTextLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Owner Selection Text
	@FindBy(css="span[automation-id='lblOwner']")
	private WebElement manitou_RTA_OwnerTextLink;
	
	public WebElement get_manitou_RTA_OwnerTextLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_OwnerTextLink, logger)){
			return manitou_RTA_OwnerTextLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Device Selection Text
	@FindBy(css="span[automation-id='lblDevice']")
	private WebElement manitou_RTA_DeviceTextLink;
	
	public WebElement get_manitou_RTA_DeviceTextLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_DeviceTextLink, logger)){
			return manitou_RTA_DeviceTextLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Equipment Reference Selection Text
	@FindBy(css="span[automation-id='lblReference']")
	private WebElement manitou_RTA_EqpRefTextLink;
	
	public WebElement get_manitou_RTA_EqpRefTextLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_EqpRefTextLink, logger)){
			return manitou_RTA_EqpRefTextLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page -- Alarm Type DropDown List
	@FindBy(css="select[automation-id='ddlAlarmType']")
	private WebElement manitou_RTA_AlarmTypeDDLLink;
	
	public WebElement get_manitou_RTA_AlarmTypeDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_AlarmTypeDDLLink, logger)){
			return manitou_RTA_AlarmTypeDDLLink;
		}else
			return null;
	}
	
	//The RAPTestAlarm Page --  Value DropDown List
	@FindBy(css="select[automation-id='ddlAlarmValue']")
	private WebElement manitou_RTA_AlarmValueDDLLink;
	
	public WebElement get_manitou_RTA_AlarmValueDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, manitou_RTA_AlarmValueDDLLink, logger)){
			return manitou_RTA_AlarmValueDDLLink;
		}else
			return null;
	}
	
}
