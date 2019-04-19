/**
 * 
 */
package mars.JCI.Project.CSD.Setup.CPO5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class CSD_SCC_Data_Import_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SCC_Data_Import_Page_Factory(WebDriver driver, ExtentTest logger) {
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
	
	//The SCC Data Import Tab
	@FindBy(css="a[test-id='SCCDataImport-tab']")
	private WebElement sccTab_SCCDataImportLink;
		
	public WebElement get_sccTab_SCCDataImportLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_SCCDataImportLink, logger)){
			return sccTab_SCCDataImportLink;
		}else
			return null;
	}
	
	//The Data Source Selection Dropdown
	@FindBy(css="select[name=ddlDataSource]")
	private WebElement sccTab_DataSourceLink;
		
	public WebElement get_sccTab_DataSourceLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_DataSourceLink, logger)){
			return sccTab_DataSourceLink;
		}else
			return null;
	}
	
	//The Equipment Type Selection Dropdown
	@FindBy(css="select[name=ddlEquipmentType]")
	private WebElement sccTab_EquipmentTypeLink;
		
	public WebElement get_sccTab_EquipmentTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentTypeLink, logger)){
			return sccTab_EquipmentTypeLink;
		}else
			return null;
	}
	
	//The Customer Selection Dropdown
	@FindBy(css="select[name=ddlCustomer]")
	private WebElement sccTab_CustomerLink;
		
	public WebElement get_sccTab_CustomerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_CustomerLink, logger)){
			return sccTab_CustomerLink;
		}else
			return null;
	}
	
	//The Facility Selection Dropdown
	@FindBy(css="select[name=ddlProjectType]")
	private WebElement sccTab_FacilityLink;
		
	public WebElement get_sccTab_FacilityLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_FacilityLink, logger)){
			return sccTab_FacilityLink;
		}else
			return null;
	}
	
	//The SCC Equipment Type Selection RadioButton
	@FindBy(css="input[name=sccType][value=isExisting]")
	private WebElement sccTab_sccEquipmentTypeLink;
		
	public WebElement get_sccTab_sccEquipmentTypeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_sccEquipmentTypeLink, logger)){
			return sccTab_sccEquipmentTypeLink;
		}else
			return null;
	}
	
	//The SCC Equipment Selection DropDown -- IF Existing RadioButton is selected
	@FindBy(css="select[name=ddlAsset]")
	private WebElement sccTab_sccEquipmentddSelectLink;
		
	public WebElement get_sccTab_sccEquipmentddSelectLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_sccEquipmentddSelectLink, logger)){
			return sccTab_sccEquipmentddSelectLink;
		}else
			return null;
	}
	
	//The SCC Equipment Owner Selection 
	@FindBy(css="input[name=txtOwner]")
	private WebElement sccTab_EquipmentOwnerLink;
		
	public WebElement get_sccTab_EquipmentOwnerLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentOwnerLink, logger)){
			return sccTab_EquipmentOwnerLink;
		}else
			return null;
	}
	
	//The SCC Equipment Device Selection 
	@FindBy(css="input[name=txtDevice]")
	private WebElement sccTab_EquipmentDeviceLink;
		
	public WebElement get_sccTab_EquipmentDeviceLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentDeviceLink, logger)){
			return sccTab_EquipmentDeviceLink;
		}else
			return null;
	}
	
	//The SCC Equipment Device Model Selection 
	@FindBy(css="input[name=txtDevice]")
	private WebElement sccTab_EquipmentDeviceModelLink;
		
	public WebElement get_sccTab_EquipmentDeviceModelLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentDeviceModelLink, logger)){
			return sccTab_EquipmentDeviceModelLink;
		}else
			return null;
	}
	
	//The SCC Equipment Model Dropdown Element Selection
	@FindBy(css="select[name=ddlModel]")
	private WebElement sccTab_EquipmentModelddLink;
		
	public WebElement get_sccTab_EquipmentModelddLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentModelddLink, logger)){
			return sccTab_EquipmentModelddLink;
		}else
			return null;
	}
	
	//The SCC Equipment Device Reporting Unit Selection 
	@FindBy(css="select[name=ddlUnit]")
	private WebElement sccTab_EquipmentRepoUnitlLink;
		
	public WebElement get_sccTab_EquipmentRepoUnitlLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentRepoUnitlLink, logger)){
			return sccTab_EquipmentRepoUnitlLink;
		}else
			return null;
	}
	
	//The SCC Equipment Device MAC ID Selection 
	@FindBy(css="input[name=txtEquipmentReference]")
	private WebElement sccTab_EquipmentMacIDLink;
		
	public WebElement get_sccTab_EquipmentMacIDLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EquipmentMacIDLink, logger)){
			return sccTab_EquipmentMacIDLink;
		}else
			return null;
	}
	
	
	//The SCC Equipment RAP Alarm Enable CheckBox
	@FindBy(xpath="//input[@ng-model='ImportModel.EnableRapAlarm']")
	private WebElement sccTab_EnableRAPAlmLink;
		
	public WebElement get_sccTab_EnableRAPAlmLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EnableRAPAlmLink, logger)){
			return sccTab_EnableRAPAlmLink;
		}else
			return null;
	}
	
	
	//The SCC Equipment CPO 5 CheckBox
	@FindBy(xpath="//input[@ng-model='ImportModel.IsCpo5']")
	private WebElement sccTab_EnableCPO5EquipLink;
		
	public WebElement get_sccTab_EnableCPO5EquipLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_EnableCPO5EquipLink, logger)){
			return sccTab_EnableCPO5EquipLink;
		}else
			return null;
	}
	
	//The Import Button for the Selected Chiller
	@FindBy(css="input[value=Import]") //#wrap > div > div > div > div > div > div > div.ng-scope > div > div > scc-data-import-dir > div > div:nth-child(2) > div > div > div > div.panel.panel-info > div > form > div:nth-child(4) > div.row.ng-scope > div > input:nth-child(1)
	private WebElement sccTab_ImportTemplatePointsLink;
		
	public WebElement get_sccTab_ImportTemplatePointsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_ImportTemplatePointsLink, logger)){
			return sccTab_ImportTemplatePointsLink;
		}else
			return null;
	}
	
	//The Clear Button for the Selected Chiller -- To select new Equipment
	@FindBy(css="input[value=Clear]")
	private WebElement sccTab_ClearDeviceSelectionLink;
		
	public WebElement get_sccTab_ClearDeviceSelectionLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_ClearDeviceSelectionLink, logger)){
			return sccTab_ClearDeviceSelectionLink;
		}else
			return null;
	}
	
	//The Pop Up Button for the Selected Chiller after Import is Done
	@FindBy(css="input[id=popup_ok]")
	private WebElement sccTab_PopUpButtonLink;
		
	public WebElement get_sccTab_PopUpButtonLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_PopUpButtonLink, logger)){
			return sccTab_PopUpButtonLink;
		}else
			return null;
	}
	
	//The TextBox to enter the FQR Pointdetails for checking the validity of the point
	@FindBy(css="input[type=text][name=FQR]")
	private WebElement sccTab_inputFQRPointNameLink;
		
	public WebElement get_sccTab_inputFQRPointNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_inputFQRPointNameLink, logger)){
			return sccTab_inputFQRPointNameLink;
		}else
			return null;
	}
	
	//The Single Table Entry after a successful Point is entered into the FQR Set  //
	@FindBy(css="#grdAssetDetail > table > tbody > tr > td:nth-child(3)")
	private WebElement sccTab_outputFQRPointNameLink;
		
	public WebElement get_sccTab_outputFQRPointNameLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, sccTab_outputFQRPointNameLink, logger)){
			return sccTab_outputFQRPointNameLink;
		}else
			return null;
	}
	
}
