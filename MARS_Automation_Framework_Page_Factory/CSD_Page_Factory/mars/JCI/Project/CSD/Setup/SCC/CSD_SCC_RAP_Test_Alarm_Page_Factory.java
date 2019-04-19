package mars.JCI.Project.CSD.Setup.SCC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CSD_SCC_RAP_Test_Alarm_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SCC_RAP_Test_Alarm_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	
	//The Administration Tab
	@FindBy(css="a[test-id='administration-tab']")
	private WebElement rapTA_AdministrationLink;
	
	public WebElement get_rapTA_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_AdministrationLink, logger)){
			return rapTA_AdministrationLink;
		}else
			return null;
	}
	
	//The SCC Tab
	@FindBy(css="a[test-id='SCC-tab']")
	private WebElement rapTA_SCCLink;
		
	public WebElement get_rapTA_SCCLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_SCCLink, logger)){
			return rapTA_SCCLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab
	@FindBy(css="a[test-id='RapTestAlarm-tab']")
	private WebElement rapTA_RAPTestAlarmLink;
		
	public WebElement get_rapTA_RAPTestAlarmLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_RAPTestAlarmLink, logger)){
			return rapTA_RAPTestAlarmLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab -- Customer DropDown
	@FindBy(css="select[automation-id='ddlCustomer']")
	private WebElement rapTA_CustomerDDLLink;
		
	public WebElement get_rapTA_CustomerDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_CustomerDDLLink, logger)){
			return rapTA_CustomerDDLLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab -- Facility DropDown
	@FindBy(css="select[automation-id='ddlProject']")
	private WebElement rapTA_FacilityDDLLink;
		
	public WebElement get_rapTA_FacilityDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_FacilityDDLLink, logger)){
			return rapTA_FacilityDDLLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab -- Asset DropDown
	@FindBy(css="select[automation-id='ddlAsset']")
	private WebElement rapTA_AssetDDLLink;
		
	public WebElement get_rapTA_AssetDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_AssetDDLLink, logger)){
			return rapTA_AssetDDLLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab -- Owner Name
	@FindBy(css="span[automation-id='lblOwner']")
	private WebElement rapTA_OwnerNameLink;
		
	public WebElement get_rapTA_OwnerNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_OwnerNameLink, logger)){
			return rapTA_OwnerNameLink;
		}else
			return null;
	}
	
	//The RAP Test Alarm Tab -- Device Name
	@FindBy(css="span[automation-id='lblDevice']")
	private WebElement rapTA_DeviceNameLink;
		
	public WebElement get_rapTA_DeviceNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rapTA_DeviceNameLink, logger)){
			return rapTA_DeviceNameLink;
		}else
			return null;
	}
	
	
	

}
