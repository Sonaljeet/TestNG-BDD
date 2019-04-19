package mars.JCI.Project.BCMET.Engineering;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCMET_Engineering_EnggInfo_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	
	public BCMET_Engineering_EnggInfo_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="bodyPlaceholder_equipmentConfig")
	private WebElement EquipmentConfigTab;
	public WebElement get_EquipmentConfigTab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EquipmentConfigTab, logger)) {
			element = this.EquipmentConfigTab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_equipmentSumm")
	private WebElement EquipmentSummaryTab;
	public WebElement get_EquipmentSummaryTab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EquipmentSummaryTab, logger)) {
			element = this.EquipmentSummaryTab;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rcbSystem_Input")
	private WebElement DD_AddQuipmentType;
	public WebElement get_DD_AddQuipmentType(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, DD_AddQuipmentType, logger)) {
			element = this.DD_AddQuipmentType;
		}
		return element;
	}
	
	@FindBy(id="ctl00_bodyPlaceholder_rcbSystem_DropDown")
	private WebElement AddQuipmentTypeTableGrid;
	public WebElement get_AddQuipmentTypeTableGrid(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, AddQuipmentTypeTableGrid, logger)) {
			element = this.AddQuipmentTypeTableGrid;
		}
		return element;
	}
	
	//This table grid contains all the equipments selected in the drop down
	@FindBy(id="bodyPlaceholder_parenAccordian")
	private WebElement MainAccordionTableGrid;
	public WebElement get_MainAccordionTableGrid(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, MainAccordionTableGrid, logger)) {
//			element = this.MainAccordionTableGrid;
		}
		return element;
	}
	
	
	@FindBy(id="bodyPlaceholder_lblAHU")
	private WebElement Engg_Info_AHUtab;
	public WebElement get_Engg_Info_AHUtab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_AHUtab, logger)) {
			element = this.Engg_Info_AHUtab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_lblVAV")
	private WebElement Engg_Info_VAVtab;
	public WebElement get_Engg_Info_VAVtab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_VAVtab, logger)) {
			element = this.Engg_Info_VAVtab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_lblPAU")
	private WebElement Engg_Info_PAUtab;
	public WebElement get_Engg_Info_PAUtab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_PAUtab, logger)) {
			element = this.Engg_Info_PAUtab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_lblFCU")
	private WebElement Engg_Info_FCUtab;
	public WebElement get_Engg_Info_FCUtab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_FCUtab, logger)) {
			element = this.Engg_Info_FCUtab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanChiller")
	private WebElement Engg_Info_Chillertab;
	public WebElement get_Engg_Info_Chillertab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_Chillertab, logger)) {
			element = this.Engg_Info_Chillertab;
		}
		return element;
	}

	
	@FindBy(id="bodyPlaceholder_spanBoiler")
	private WebElement Engg_Info_Boilertab;
	public WebElement get_Engg_Info_Boilertab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_Boilertab, logger)) {
			element = this.Engg_Info_Boilertab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanExhaustFan")
	private WebElement Engg_Info_ExhaustFantab;
	public WebElement get_Engg_Info_ExhaustFantab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_ExhaustFantab, logger)) {
			element = this.Engg_Info_ExhaustFantab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanSumpPump")
	private WebElement Engg_Info_SumpPumptab;
	public WebElement get_Engg_Info_SumpPumptab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_SumpPumptab, logger)) {
			element = this.Engg_Info_SumpPumptab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanLighting")
	private WebElement Engg_Info_Lightingtab;
	public WebElement get_Engg_Info_Lightingtab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_Lightingtab, logger)) {
			element = this.Engg_Info_Lightingtab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanEnergy")
	private WebElement Engg_Info_Energytab;
	public WebElement get_Engg_Info_Energytab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_Energytab, logger)) {
			element = this.Engg_Info_Energytab;
		}
		return element;
	}
	
	@FindBy(id="bodyPlaceholder_spanMisc")
	private WebElement Engg_Info_Misctab;
	public WebElement get_Engg_Info_Misctab(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, Engg_Info_Misctab, logger)) {
			element = this.Engg_Info_Misctab;
		}
		return element;
	}
	
	
	//Input fields for AHU accordion

	//id="ctl00_bodyPlaceholder_UCAHUSystem_txtSystem"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_txtSystem")
	private WebElement EnggInfo_AHU_Equipment_Type_Name;
	public WebElement get_EnggInfo_AHU_Equipment_Type_Name(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_Equipment_Type_Name, logger)) {
			element = this.EnggInfo_AHU_Equipment_Type_Name;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_rcbSystemType"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_rcbSystemType")
	private WebElement EnggInfo_AHU_DD_BaseConfig;
	public WebElement get_EnggInfo_AHU_DD_BaseConfig(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_DD_BaseConfig, logger)) {
			element = this.EnggInfo_AHU_DD_BaseConfig;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rcbSystemType_DropDown
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_rcbSystemType_DropDown")
	private WebElement EnggInfo_AHU_DD_BaseConfig_ValueGrid;
	public WebElement get_EnggInfo_AHU_DD_BaseConfig_ValueGrid(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_DD_BaseConfig_ValueGrid, logger)) {
			element = this.EnggInfo_AHU_DD_BaseConfig_ValueGrid;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_txtTypicalSystem"
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_txtTypicalSystem")
	private WebElement EnggInfo_AHU_Typical_of;
	public WebElement get_EnggInfo_AHU_Typical_ofd(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_Typical_of, logger)) {
			element = this.EnggInfo_AHU_Typical_of;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rgSystemCatgeoryAHU_GridData
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_rgSystemCatgeoryAHU_GridData")
	private WebElement EnggInfo_AHU_IoPoints_GridData;
	public WebElement get_EnggInfo_AHU_IoPoints_GridData(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_IoPoints_GridData, logger)) {
			element = this.EnggInfo_AHU_IoPoints_GridData;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_btnAddAHU_input"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_btnAddAHU_input")
	private WebElement EnggInfo_AHU_AddEquipmentButton;
	public WebElement get_EnggInfo_AHU_AddEquipmentButton(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_AddEquipmentButton, logger)) {
			element = this.EnggInfo_AHU_AddEquipmentButton;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_btnSaveSystemConfigAHU_input"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_btnSaveSystemConfigAHU_input")
	private WebElement EnggInfo_AHU_SaveButton;
	public WebElement get_EnggInfo_AHU_SaveButton(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_SaveButton, logger)) {
			element = this.EnggInfo_AHU_SaveButton;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rgAHUSummary_GridData
	
	@FindBy(id="ctl00_bodyPlaceholder_UCAHUSystem_rgAHUSummary_GridData")
	private WebElement EnggInfo_AHU_SummaryGridData;
	public WebElement get_EnggInfo_AHU_SummaryGridData(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_AHU_SummaryGridData, logger)) {
			element = this.EnggInfo_AHU_SummaryGridData;
		}
		return element;
	}
	
	
	
	//Input fields for VAV accordion
	
	//id="ctl00_bodyPlaceholder_UCVAVSystem_txtSystemVAV"
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_txtSystemVAV")
	private WebElement EnggInfo_VAV_Equipment_Type_Name;
	public WebElement get_EnggInfo_VAV_Equipment_Type_Name(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_Equipment_Type_Name, logger)) {
			element = this.EnggInfo_VAV_Equipment_Type_Name;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCVAVSystem_rcbSystemTypeVAV"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_rcbSystemTypeVAV")
	private WebElement EnggInfo_VAV_DD_BaseConfig;
	public WebElement get_EnggInfo_VAV_DD_BaseConfig(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_DD_BaseConfig, logger)) {
			element = this.EnggInfo_VAV_DD_BaseConfig;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rcbSystemType_DropDown
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_rcbSystemTypeVAV_DropDown")
	private WebElement EnggInfo_VAV_DD_BaseConfig_ValueGrid;
	public WebElement get_EnggInfo_VAV_DD_BaseConfig_ValueGrid(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_DD_BaseConfig_ValueGrid, logger)) {
			element = this.EnggInfo_VAV_DD_BaseConfig_ValueGrid;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_txtTypicalSystem"
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_txtTypicalSystemVAV")
	private WebElement EnggInfo_VAV_Typical_of;
	public WebElement get_EnggInfo_VAV_Typical_ofd(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_Typical_of, logger)) {
			element = this.EnggInfo_VAV_Typical_of;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rgSystemCatgeoryAHU_GridData
	
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_rgSystemCatgeoryVAV_GridData")
	private WebElement EnggInfo_VAV_IoPoints_GridData;
	public WebElement get_EnggInfo_VAV_IoPoints_GridData(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_IoPoints_GridData, logger)) {
			element = this.EnggInfo_VAV_IoPoints_GridData;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_btnAddAHU_input"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_btnAddVAV_input")
	private WebElement EnggInfo_VAV_AddEquipmentButton;
	public WebElement get_EnggInfo_VAV_AddEquipmentButton(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_AddEquipmentButton, logger)) {
			element = this.EnggInfo_VAV_AddEquipmentButton;
		}
		return element;
	}
	
	//id="ctl00_bodyPlaceholder_UCAHUSystem_btnSaveSystemConfigAHU_input"
	
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_btnSaveSystemConfigVAV_input")
	private WebElement EnggInfo_VAV_SaveButton;
	public WebElement get_EnggInfo_VAV_SaveButton(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_SaveButton, logger)) {
			element = this.EnggInfo_VAV_SaveButton;
		}
		return element;
	}
	
	//ctl00_bodyPlaceholder_UCAHUSystem_rgAHUSummary_GridData
	
	@FindBy(id="ctl00_bodyPlaceholder_UCVAVSystem_rgVAVSummary_GridData")
	private WebElement EnggInfo_VAV_SummaryGridData;
	public WebElement get_EnggInfo_VAV_SummaryGridData(){
		WebElement element = null;
		
		if (WebElementCommon.waitForElementPresent(driver, EnggInfo_VAV_SummaryGridData, logger)) {
			element = this.EnggInfo_VAV_SummaryGridData;
		}
		return element;
	}
	
	//Input fields for PAU accordion
	
	//Input fields for FCU accordion
	
	//Input fields for Chiller/AC plant accordion
	
	//Input fields for Boiler accordion
	
	//Input fields for Exhaust Fan accordion
	
	//Input fields for Sump Pump accordion
	
	//Input fields for Lighting accordion
	
	//Input fields for Energy Monitoring accordion
	
	//Input fields for Miscellaneous accordion
	
	
	
	
	
}












































