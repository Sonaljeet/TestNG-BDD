package mars.JCI.Project.CSD.Setup.SCC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CSD_SCC_Critical_Alarm_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";	
	
	
	public CSD_SCC_Critical_Alarm_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	//The Critical Alarm Tab
	@FindBy(css="a[test-id='CriticalAlarm-tab']")
	private WebElement ca_CriticalAlarmLink;
		
	public WebElement get_ca_CriticalAlarmLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_CriticalAlarmLink, logger)){
			return ca_CriticalAlarmLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Customer Name DDL
	@FindBy(css="select[automation-id='ddlCustomer']")
	private WebElement ca_CustNameDDLLink;
		
	public WebElement get_ca_CustNameDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_CustNameDDLLink, logger)){
			return ca_CustNameDDLLink;
		}else
			return null;
	}

	//The Critical Alarm Tab -- Facility Name DDL
	@FindBy(css="select[automation-id='ddlProject']")
	private WebElement ca_FacilityNameDDLLink;
		
	public WebElement get_ca_FacilityNameDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_FacilityNameDDLLink, logger)){
			return ca_FacilityNameDDLLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Asset Name DDL
	@FindBy(css="select[automation-id='ddlAsset']")
	private WebElement ca_AssetNameDDLLink;
		
	public WebElement get_ca_AssetNameDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_AssetNameDDLLink, logger)){
			return ca_AssetNameDDLLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Communication Protocol Text
	@FindBy(css="span[automation-id='lblProtocol']")
	private WebElement ca_CommnProtoLink;
		
	public WebElement get_ca_CommnProtoLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_CommnProtoLink, logger)){
			return ca_CommnProtoLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Owner Details Text
	@FindBy(css="span[automation-id='lblOwner']")
	private WebElement ca_OwnerDetailsLink;
		
	public WebElement get_ca_OwnerDetailsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_OwnerDetailsLink, logger)){
			return ca_OwnerDetailsLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Device Details Text
	@FindBy(css="span[automation-id='lblDevice']")
	private WebElement ca_DeviceDetailsLink;
		
	public WebElement get_ca_DeviceDetailsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_DeviceDetailsLink, logger)){
			return ca_DeviceDetailsLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Equipment Reference Details Text
	@FindBy(css="span[automation-id='lblReference']")
	private WebElement ca_EqpRefDetailsLink;
		
	public WebElement get_ca_EqpRefDetailsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_EqpRefDetailsLink, logger)){
			return ca_EqpRefDetailsLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Alarm Type DDL
	@FindBy(css="select[automation-id='ddlAlarmType']")
	private WebElement ca_AlarmTypeDDLLink;
		
	public WebElement get_ca_AlarmTypeDDLLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ca_AlarmTypeDDLLink, logger)){
			return ca_AlarmTypeDDLLink;
		}else
			return null;
	}
	
	//The Critical Alarm Tab -- Send Alarm Button
	
}
