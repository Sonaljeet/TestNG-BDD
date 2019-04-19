package mars.JCI.Project.CSD.Setup.SCC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CSD_SCC_Import_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SCC_Import_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		
		PageFactory.initElements(driver, this);
	}

	
	//The Administration Tab
	@FindBy(css="a[test-id='administration-tab']")
	private WebElement sccTab_AdministrationLink;
	
	public WebElement get_sccTab_AdministrationLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_AdministrationLink, logger)){
			return sccTab_AdministrationLink;
		}else
			return null;
	}
	
	//The SCC Tab
	@FindBy(css="a[test-id='SCC-tab']")
	private WebElement sccTab_SCCLink;
		
	public WebElement get_sccTab_SCCLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCCLink, logger)){
			return sccTab_SCCLink;
		}else
			return null;
	}
	
	//The SCC Import Tab
	@FindBy(css="a[test-id='SCCImport-tab']")
	private WebElement sccTab_SCCImportLink;
		
	public WebElement get_sccTab_SCCImportLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCCImportLink, logger)){
			return sccTab_SCCImportLink;
		}else
			return null;
	}
	
	//The SCC Import Page -- DataSource DDL
	@FindBy(css="select[name='ddlDataSource']")
	private WebElement sccTab_DataSourceDDL;
		
	public WebElement get_sccTab_DataSourceDDL(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_DataSourceDDL, logger)){
			return sccTab_DataSourceDDL;
		}else
			return null;
	}
	
	//The SCC Import Page -- EquipmentType DDL
	@FindBy(css="select[name='ddlEquipmentType']")
	private WebElement sccTab_EquipmentTypeDDL;
		
	public WebElement get_sccTab_EquipmentTypeDDL(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentTypeDDL, logger)){
			return sccTab_EquipmentTypeDDL;
		}else
			return null;
	}
	
	//The SCC Import Page -- Customer DDL
	@FindBy(css="select[name='ddlCustomer']")
	private WebElement sccTab_CustomerNameDDL;
		
	public WebElement get_sccTab_CustomerNameDDL(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_CustomerNameDDL, logger)){
			return sccTab_CustomerNameDDL;
		}else
			return null;
	}
	
	//The SCC Import Page -- Facility DDL
	@FindBy(css="select[name='ddlProjectType']")
	private WebElement sccTab_FacilityNameDDL;
		
	public WebElement get_sccTab_FacilityNameDDL(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_FacilityNameDDL, logger)){
			return sccTab_FacilityNameDDL;
		}else
			return null;
	}
	
	//The SCC Import Page -- SCC_Customer DDL
	@FindBy(css="select[name='ddlsccCustomerInfo']")
	private WebElement sccTab_SCC_CustomerDDL;
		
	public WebElement get_sccTab_SCC_CustomerDDL(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCC_CustomerDDL, logger)){
			return sccTab_SCC_CustomerDDL;
		}else
			return null;
	}
	
	//The SCC Import Page -- Generate Button
	@FindBy(css="input[name='btnGenerate']")
	private WebElement sccTab_SCC_GenerateBTN;
		
	public WebElement get_sccTab_SCC_GenerateBTN(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCC_GenerateBTN, logger)){
			return sccTab_SCC_GenerateBTN;
		}else
			return null;
	}
	
	
	//The SCC Import Page -- Clear Button
	@FindBy(css="input[value='Clear']")
	private WebElement sccTab_SCC_ClearBTN;
		
	public WebElement get_sccTab_SCC_ClearBTN(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCC_ClearBTN, logger)){
			return sccTab_SCC_ClearBTN;
		}else
			return null;
	}
	
	
	
	
}
