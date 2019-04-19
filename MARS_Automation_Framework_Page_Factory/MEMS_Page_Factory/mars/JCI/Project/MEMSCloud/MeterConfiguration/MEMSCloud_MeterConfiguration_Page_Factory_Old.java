package mars.JCI.Project.MEMSCloud.MeterConfiguration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;

public class MEMSCloud_MeterConfiguration_Page_Factory_Old {
	/** The WebDriver driver. */
	private static WebDriver driver;

	/** The ExtentTest logger. */
	private static ExtentTest logger;
	public String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

	// private static dataFileLoc
	// ReadPropertyFile.getInstance(mailConfigFile).getProperty("host");
	/**
	 * Instantiates a new MEMS dashboard page factory.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 */
	public MEMSCloud_MeterConfiguration_Page_Factory_Old(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	// *************** METER CONFIGURATION WEBELEMENT
	@FindBy(xpath = "//a[@href='Configuration/MeterConfiguration']")
	private WebElement meterConfiguration;

	public WebElement getMeterConfiguration() throws Exception {
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterConfiguration, driver, logger) == true) {
			return meterConfiguration;
		} else
			return null;
	}

	// *************** SELECT PORTFOLIO WEBELEMENT
	public List<WebElement> memsCloud_portFolioName = null;

	public List<WebElement> getmemsCloud_portFolioName(String portFolioName) throws InterruptedException {
		memsCloud_portFolioName = driver.findElements(By.xpath("//div[text()='+portFolioName+']"));
		return memsCloud_portFolioName;
	}

	// *************** CREATE METER WEBELEMENT
	@FindBy(xpath = "//button[contains(@ng-click,'vm.addNode(systemform, meterform, pointform)')]/i")
	private WebElement createMeter;

	public WebElement getCreateMeter() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(createMeter, driver, logger) == true) {
			return createMeter;
		} else
			return null;
	}

	// *************** EXPAND NAVIGATION TREE WEBELEMENT
	public List<WebElement> memsCloud_expandNavigationTree = null;

	public List<WebElement> getExpandNavigationTree(String locationName) throws InterruptedException {
		memsCloud_expandNavigationTree = driver.findElements(By.xpath("//div[text()='" + locationName
				+ "']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a"));
		System.out.println("memsCloud_expandNavigationTree : " + memsCloud_expandNavigationTree);
		return memsCloud_expandNavigationTree;
	}

	// *************** SELECT BUILDING WEBELEMENT
	public List<WebElement> memsCloud_selectBuilding = null;

	public List<WebElement> getSelectBuilding(String buildingName) throws InterruptedException {
		memsCloud_selectBuilding = driver.findElements(By.xpath("//div[text()='" + buildingName + "']"));
		return memsCloud_selectBuilding;
	}

	// *************** SYSTEM WEBELEMENT
	@FindBy(xpath = "//select[@name='systemtype']")
	private WebElement system;

	public WebElement getSystem() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(system, driver, logger) == true) {
			return system;
		} else
			return null;
	}

	// *************** METER NATURE WEBELEMENT
	@FindBy(xpath = "//select[@name='meternature']")
	private WebElement meterNature;

	public WebElement getmeterNature() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterNature, driver, logger) == true) {
			return meterNature;
		} else
			return null;
	}

	// *************** METER TYPE WEBELEMENT
	@FindBy(xpath = "//select[@name='metertype'][contains(@ng-model, 'vm.selectedNode.mainmeter.Source')]")
	private WebElement meterType;

	public WebElement getmeterType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterType, driver, logger) == true) {
			return meterType;
		} else
			return null;
	}

	// *************** METER LOAD TYPE WEBELEMENT
	@FindBy(xpath = "//select[@id='MeterLoadTypeselector'][contains(@ng-model, 'vm.selectedNode.mainmeter.LoadType')]")
	private WebElement meterLoadType;

	public WebElement getmeterLoadType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterLoadType, driver, logger) == true) {
			return meterLoadType;
		} else
			return null;
	}

	// *************** METER NAME WEBELEMENT
	@FindBy(xpath = "//span/input[@name='MeterName'][contains(@ng-model, 'vm.selectedNode.mainmeter.Name')]")
	private WebElement meterName;

	public WebElement getmeterName() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterName, driver, logger) == true) {
			return meterName;
		} else
			return null;
	}

	// *************** METER ROLL UP YES WEBELEMENT
	@FindBy(xpath = "(//input[@name='meterrollup'][@ng-model='vm.selectedNode.mainmeter.MeterRollUpYesOrNo'])[1]")
	private WebElement meterRollUp_Yes;

	public WebElement getMeterRollUp_Yes() throws Exception {
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterRollUp_Yes, driver, logger) == true) {
			return meterRollUp_Yes;
		} else
			return null;
	}

	// *************** METER ROLL UP NO WEBELEMENT
	@FindBy(xpath = "(//input[@name='meterrollup'][@ng-model='vm.selectedNode.mainmeter.MeterRollUpYesOrNo'])[2]")
	private WebElement meterRollUp_No;

	public WebElement getMeterRollUp_No() throws Exception {
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(meterRollUp_No, driver, logger) == true) {
			return meterRollUp_No;
		} else
			return null;
	}

	// *************** EQUIPMENT CATEGORY WEBELEMENT
	@FindBy(xpath = "(//select[@id='EquipmentTagSelector'])[1]")
	private WebElement equipmentCategory;

	public WebElement getequipmentCategory() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory, driver, logger) == true) {
			return equipmentCategory;
		} else
			return null;
	}

	// *************** OFFLINE METER POINT NAME WEBELEMENT
	@FindBy(xpath = "(//span/input[@name='pointname'])[1]")
	private WebElement offlineMeterPoint;

	public WebElement getofflineMeterPointName() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineMeterPoint, driver, logger) == true) {
			return offlineMeterPoint;
		} else
			return null;
	}

	// *************** OFFLINE METER POINT NAME WEBELEMENT
	@FindBy(xpath = "(//input[@name='pointname'])[2]")
	private WebElement offlineMeterPointName;

	public WebElement getOffline_MeterPointName() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineMeterPointName, driver, logger) == true) {
			return offlineMeterPointName;
		} else
			return null;
	}

	// *************** POINT NAME WEBELEMENT
	@FindBy(xpath = "(//input[@ng-model='vm.selectedNode.point.Name'][@name='pointname'])[1]")
	private WebElement pointName;

	public WebElement getPointName() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pointName, driver, logger) == true) {
			return pointName;
		} else
			return null;
	}

	// *************** ENTER DESCRIPTION WEBELEMENT
	@FindBy(xpath = "(//input[@placeholder='Enter description'])[1]")
	private WebElement enterDescription;

	public WebElement getEnterDescription() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(enterDescription, driver, logger) == true) {
			return enterDescription;
		} else
			return null;
	}

	// *************** ENTER DESCRIPTION WEBELEMENT
	@FindBy(xpath = "(//input[@placeholder='Enter description'])[2]")
	private WebElement enter_Description;

	public WebElement getEnter_Description() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(enter_Description, driver, logger) == true) {
			return enter_Description;
		} else
			return null;
	}

	// *************** UNIT TYPE WEBELEMENT
	@FindBy(xpath = "(//select[@name='unitType'])[1]")
	private WebElement unitType;

	public WebElement getUnitType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(unitType, driver, logger) == true) {
			return unitType;
		} else
			return null;
	}

	// *************** OFFLINE UNIT TYPE WEBELEMENT
	@FindBy(xpath = "(//select[@name='unitType'])[2]")
	private WebElement offlineunitType;

	public WebElement getOfflineunitType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineunitType, driver, logger) == true) {
			return offlineunitType;
		} else
			return null;
	}

	// *************** OFFLINE UNIT TYPE WEBELEMENT
	@FindBy(xpath = "(//select[@name='unitType'])[4]")
	private WebElement offline_UnitType;

	public WebElement getoffline_UnitType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offline_UnitType, driver, logger) == true) {
			return offline_UnitType;
		} else
			return null;
	}

	// *************** UNIT WEBELEMENT
	@FindBy(xpath = "(//select[@name='pointunit'])[1]")
	private WebElement unit;

	public WebElement getUnit() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(unit, driver, logger) == true) {
			return unit;
		} else
			return null;
	}

	// *************** UNIT WEBELEMENT
	@FindBy(xpath = "(//select[@name='pointunit'])[2]")
	private WebElement unitOfflineMeterPoint;

	public WebElement getUnitOfflineMeterPoint() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(unitOfflineMeterPoint, driver, logger) == true) {
			return unitOfflineMeterPoint;
		} else
			return null;
	}

	// *************** POINT ROLE WEBELEMENT
	@FindBy(xpath = "(//select[@name='pointRole'])[1]")
	private WebElement pointRole;

	public WebElement getPointRole() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pointRole, driver, logger) == true) {
			return pointRole;
		} else
			return null;
	}

	// *************** OFFLINE POINT ROLE WEBELEMENT
	@FindBy(xpath = "(//select[@name='pointRole'])[2]")
	private WebElement offlinePointRole;

	public WebElement getOfflinePointRole() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlinePointRole, driver, logger) == true) {
			return offlinePointRole;
		} else
			return null;
	}

	// *************** OFFLINE POINT ROLE WEBELEMENT
	@FindBy(xpath = "(//select[@name='pointRole'])[4]")
	private WebElement offlineMeterPointRole;

	public WebElement getofflineMeterPointRole() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineMeterPointRole, driver, logger) == true) {
			return offlineMeterPointRole;
		} else
			return null;
	}

	// *************** POINT ROLE WEBELEMENT
	@FindBy(xpath = "(//select[@name='seriestype'])[1]")
	private WebElement seriesType;

	public WebElement getSeriesType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(seriesType, driver, logger) == true) {
			return seriesType;
		} else
			return null;
	}

	// *************** OFFLINE SERIES WEBELEMENT
	@FindBy(xpath = "(//select[@name='seriestype'])[2]")
	private WebElement offlineseriesType;

	public WebElement getOfflineSeriesType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineseriesType, driver, logger) == true) {
			return offlineseriesType;
		} else
			return null;
	}

	// *************** OFFLINE SERIES WEBELEMENT
	@FindBy(xpath = "(//select[@name='seriestype'])[4]")
	private WebElement offlineMeterPointseriesType;

	public WebElement getofflineMeterPointseriesType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(offlineMeterPointseriesType, driver,
				logger) == true) {
			return offlineMeterPointseriesType;
		} else
			return null;
	}

	// *************** SAVE WEBELEMENT
	@FindBy(xpath = "//button[@id='btnSaveSystem']")
	private WebElement save;

	public WebElement getSave() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(save, driver, logger) == true) {
			return save;
		} else
			return null;
	}

	// *************** EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> expandBuildingTree = null;

	public List<WebElement> getExpandBuildingTree(String locationName) throws InterruptedException {
		System.out.println("locationName : " + locationName);
		expandBuildingTree = driver.findElements(By.xpath("(//div[text()='" + locationName
				+ "']//ancestor::div[@ng-class='{selected: (vm.selectedNode.id.toLowerCase()  == node.id.toLowerCase() )}']//a//span)[1]"));
		System.out.println("expandBuildingTree : " + expandBuildingTree);
		return expandBuildingTree;
	}

	// *************** EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> expandMeterPointTree = null;

	public List<WebElement> getExpandMeterPointTree(String MeterPointName) throws InterruptedException {
		System.out.println("Meter Point Name : " + MeterPointName);
		// expandMeterPointTree = driver.findElements(By.xpath("(//div[text()='"
		// + MeterPointName + "']//ancestor::div[@class='space-tree-node
		// ng-scope angular-ui-tree-handle']//a//span)[1]"));
		expandMeterPointTree = driver.findElements(By.xpath("(//div[text()='" + MeterPointName
				+ "']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span)[1]"));
		System.out.println("expandMeterPointTree : " + expandMeterPointTree);
		return expandMeterPointTree;
	}

	// *************** EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> selectMeterPointTree = null;

	public List<WebElement> getOfflineMeterPointTree(String MeterPointName) throws InterruptedException {
		selectMeterPointTree = driver.findElements(By.xpath("(//div[text()='" + MeterPointName + "'])[1]"));
		return selectMeterPointTree;
	}

	// *************** SELECT METER POINT WEBELEMENT
	public List<WebElement> SelectOfflineMeterPoint = null;

	public List<WebElement> getSelectOfflineMeterPoint(String MeterPointName) throws InterruptedException {
		SelectOfflineMeterPoint = driver.findElements(By.xpath("(//div[text()='" + MeterPointName + "'])[1]"));
		return SelectOfflineMeterPoint;
	}

	// *************** EXPAND COMMODITY TREE WEBELEMENT
	public List<WebElement> expandCommodityTree = null;

	public List<WebElement> getCommodityTree(String locationName, String commodity) throws InterruptedException {
		System.out.println("locationName : " + locationName);
		expandCommodityTree = driver.findElements(By.xpath("(//div[text()='" + locationName
				+ "'])[1]//parent::div//parent::div//parent::li//div[text()='" + commodity
				+ "']//parent::div//preceding-sibling::a/span[@class='glyphicon tree-plus-icon-small']"));
		System.out.println("expandCommodityTree : " + expandCommodityTree);
		return expandCommodityTree;
	}

	public List<WebElement> expandCommodityTree_Minus = null;

	public List<WebElement> getexpandCommodityTree_Minus(String locationName, String commodity)
			throws InterruptedException {
		System.out.println("locationName : " + locationName);
		expandCommodityTree_Minus = driver.findElements(By.xpath("(//div[text()='" + locationName
				+ "'])[1]//parent::div//parent::div//parent::li//div[text()='" + commodity
				+ "']//parent::div//preceding-sibling::a/span[@class='glyphicon tree-minus-icon-small']"));
		System.out.println("expandCommodityTree_Minus : " + expandCommodityTree_Minus);
		return expandCommodityTree_Minus;
	}

	// *************** EXPAND COMMODITY TREE WEBELEMENT
	public List<WebElement> OnlineMeterName = null;

	public List<WebElement> getOnlineMeter(String meterName) throws InterruptedException {
		// System.out.println("OnlineMeterName : " + OnlineMeterName);
		OnlineMeterName = driver.findElements(By.xpath("(//div[text()='" + meterName + "'])[1]"));
		System.out.println("expandCommodityTree : " + OnlineMeterName);
		return OnlineMeterName;
	}

	// *************** DELETE ICON WEBELEMENT
	@FindBy(xpath = "//button[@ng-click='vm.deleteConfirmation(vm.selectedNode.type.toLowerCase())']/i")
	private WebElement delete;

	public WebElement getdelete() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(delete, driver, logger) == true) {
			return delete;
		} else
			return null;
	}

	// *************** DELETE OFFLINE METER ICON WEBELEMENT
	@FindBy(xpath = "//button[@ng-click='vm.deleteConfirmation(vm.selectedNode.type.toLowerCase())']/i")
	private WebElement deleteOfflineMeter;

	public WebElement getdeleteOfflineMeter() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(deleteOfflineMeter, driver, logger) == true) {
			return deleteOfflineMeter;
		} else
			return null;
	}

	// *************** DELETE OFFLINE METER POINT ICON WEBELEMENT
	@FindBy(xpath = "//button[@ng-click='vm.Deletenode()']/span[text()='Yes']")
	private WebElement deleteOfflineMeterPoint;

	public WebElement getdeleteOfflineMeterPoint() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(deleteOfflineMeterPoint, driver, logger) == true) {
			return deleteOfflineMeterPoint;
		} else
			return null;
	}

	// *************** ADD OFFLINE METER POINT RADIO BUTTON
	@FindBy(xpath = "//input[@id='sbMeterAdd']")
	private WebElement AddofflineMeterPointRadioBtn;

	public WebElement getAddofflineMeterPointRadioBtn() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(AddofflineMeterPointRadioBtn, driver,
				logger) == true) {
			return AddofflineMeterPointRadioBtn;
		} else
			return null;
	}

	// *************** DATA COLLECTOR WEBELEMENT
	@FindBy(xpath = "//select[@name='dataCollector']")
	private WebElement dataCollector;

	public WebElement getdataCollector() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(dataCollector, driver, logger) == true) {
			return dataCollector;
		} else
			return null;
	}

	// *************** DATA SOURCE WEBELEMENT
	@FindBy(xpath = "//select[@name='dataSource']")
	private WebElement dataSource;

	public WebElement getDataSource() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(dataSource, driver, logger) == true) {
			return dataSource;
		} else
			return null;
	}

	// *************** DATA SOURCE DEVICE WEBELEMENT
	@FindBy(xpath = "//select[@name='dataSource']")
	private WebElement dataSourceDevice;

	public WebElement getDataSourceDevice() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(dataSourceDevice, driver, logger) == true) {
			return dataSourceDevice;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION
	// *************** POINT CONFIGURATION NAME WEBELEMENT
	@FindBy(xpath = "//input[@name='selectedConfigurablePointName'][contains(@ng-model, 'vm.selectedConfigurablePoint.name')]")
	private WebElement pt_Config_Name;

	public WebElement getpt_Config_Name() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_Name, driver, logger) == true) {
			return pt_Config_Name;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION READ FREQUENCY WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/select[@name='ddlreadFrequency']")
	private WebElement pt_Config_ReadFrq;

	public WebElement getpt_Config_ReadFrq() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_ReadFrq, driver, logger) == true) {
			return pt_Config_ReadFrq;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION UNIT TYPE WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/select[@name='ddlUnitType']")
	private WebElement pt_Config_unitType;

	public WebElement getpt_Config_unitType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_unitType, driver, logger) == true) {
			return pt_Config_unitType;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION UNIT WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/select[@name='ddlUnit']")
	private WebElement pt_Config_unit;

	public WebElement getpt_Config_unit() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_unit, driver, logger) == true) {
			return pt_Config_unit;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION POINT ROLE WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/select[@name='ddlUnit']")
	private WebElement pt_Config_PointRole;

	public WebElement getpt_Config_PointRole() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_PointRole, driver, logger) == true) {
			return pt_Config_PointRole;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION SERIES TYPE WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/select[@name='ddlUnit']")
	private WebElement pt_Config_SeriesType;

	public WebElement getpt_Config_SeriesType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_SeriesType, driver, logger) == true) {
			return pt_Config_SeriesType;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION MIN VALUE WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/input[@name='minValue']")
	private WebElement pt_Config_MinValue;

	public WebElement getpt_Config_MinValue() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_MinValue, driver, logger) == true) {
			return pt_Config_MinValue;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION MAX VALUE WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4']/input[@name='minValue']")
	private WebElement pt_Config_MaxValue;

	public WebElement getpt_Config_MaxValue() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_MaxValue, driver, logger) == true) {
			return pt_Config_MaxValue;
		} else
			return null;
	}

	// *************** POINT CONFIGURATION UPDATE BUTTON WEBELEMENT
	@FindBy(xpath = "//button[contains(@ng-click, 'vm.UpdatePointEntityData(PointConfigurationPopUpForm)')]")
	private WebElement pt_Config_Update;

	public WebElement getpt_Config_Update() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(pt_Config_Update, driver, logger) == true) {
			return pt_Config_Update;
		} else
			return null;
	}

	// *************** HISTORICAL REQUEST WEBELEMENT
	@FindBy(xpath = "//button[@id='HistoricalRequestModalButton'][contains(@ng-click, 'vm.BindHistoricalRequest()')]")
	private WebElement historicalRequest;

	public WebElement gethistoricalRequest() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(historicalRequest, driver, logger) == true) {
			return historicalRequest;
		} else
			return null;
	}

	// *************** HISTORICAL REQUEST REQUEST TAB WEBELEMENT
	@FindBy(xpath = "//li/a[@href='#requesttab']")
	private WebElement historicalReq_Request;

	public WebElement gethistoricalReq_Request() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(historicalReq_Request, driver, logger) == true) {
			return historicalReq_Request;
		} else
			return null;
	}

	// *************** SUBMIT HISTORICAL REQUEST TAB WEBELEMENT
	@FindBy(xpath = "//button[text()='Submit'][contains(@ng-click, 'hdc.CreateHistoricalRequest()')]")
	private WebElement historicalReq_Submit;

	public WebElement gethistoricalReq_Submit() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(historicalReq_Submit, driver, logger) == true) {
			return historicalReq_Submit;
		} else
			return null;
	}

	// *************** WAIT FOR LOGIN USER WEBELEMENT
	@FindBy(xpath = "//a[@data-toggle='dropdown']/img")
	private WebElement UserImage;

	public WebElement getUserImage() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(UserImage, driver, logger) == true) {
			return UserImage;
		} else
			return null;
	}

	// *************** DATA COLLACTOR WEBELEMENT
	@FindBy(xpath = "//select[@name='dataCollector']")
	private WebElement Datacollector;

	public WebElement getDatacollector() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Datacollector, driver, logger) == true) {
			return Datacollector;
		} else
			return null;
	}

	// *************** DATA SOURCE WEBELEMENT
	@FindBy(xpath = "//select[@name='dataSource']")
	private WebElement DatacSource;

	public WebElement getData_Source() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(DatacSource, driver, logger) == true) {
			return DatacSource;
		} else
			return null;
	}

	// *************** SELECT DEVICE WEBELEMENT
	@FindBy(xpath = "//select[@name='datasourceDevice']")
	private WebElement SelectDevice;

	public WebElement getDataSource_Device() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(SelectDevice, driver, logger) == true) {
			return SelectDevice;
		} else
			return null;
	}

	// *************** SELECT METER POINT WEBELEMENT
	public List<WebElement> getMeterPoint = null;

	public List<WebElement> getMeterPoint(String pointName) throws InterruptedException {
		getMeterPoint = driver
				.findElements(By.xpath("//div[text()='" + pointName + "'][@class='node-tree-name ng-binding']"));
		System.out.println("getMeterPoint : " + getMeterPoint);
		return getMeterPoint;
	}

	// *************** READ FREQUENCY WEBELEMENT
	@FindBy(xpath = "(//select[@name='ddlreadFrequency'])[1]")
	private WebElement ReadFrequency;

	public WebElement getReadFrequency() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(ReadFrequency, driver, logger) == true) {
			return ReadFrequency;
		} else
			return null;
	}

	// *************** METER UNIT TYPE WEBELEMENT
	@FindBy(xpath = "//select[@name='ddlUnitType']")
	private WebElement MeterUnitType;

	public WebElement getMeterUnitType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MeterUnitType, driver, logger) == true) {
			return MeterUnitType;
		} else
			return null;
	}

	// *************** METER UNIT TYPE WEBELEMENT
	@FindBy(xpath = "//select[@name='ddlUnit']")
	private WebElement MeterUnit;

	public WebElement getMeterUnit() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MeterUnit, driver, logger) == true) {
			return MeterUnit;
		} else
			return null;
	}

	// *************** METER POINT ROLE TYPE WEBELEMENT
	@FindBy(xpath = "//form[@name='PointConfigurationPopUpForm']//select[@id='ddlPointRole']")
	private WebElement MeterPointRole;

	public WebElement getMeterPointRole() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MeterPointRole, driver, logger) == true) {
			return MeterPointRole;
		} else
			return null;
	}

	// *************** METER SERIES TYPE WEBELEMENT
	@FindBy(xpath = "//form[@name='PointConfigurationPopUpForm']//select[@name='ddlSeriestype']")
	private WebElement MeterSeriesType;

	public WebElement getMeterSeriesType() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MeterSeriesType, driver, logger) == true) {
			return MeterSeriesType;
		} else
			return null;
	}

	// *************** METER MIN VALUE WEBELEMENT
	@FindBy(xpath = "//input[@name='minValue']")
	private WebElement MinValue;

	public WebElement getMinValue() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MinValue, driver, logger) == true) {
			return MinValue;
		} else
			return null;
	}

	// *************** METER MAX VALUE WEBELEMENT
	@FindBy(xpath = "//input[@name='maxValue']")
	private WebElement MaxValue;

	public WebElement getMaxValue() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(MaxValue, driver, logger) == true) {
			return MaxValue;
		} else
			return null;
	}

	// *************** ALL POINTS WEBELEMENT
	@FindBy(xpath = "//button[text()='All points']")
	private WebElement AllPoints;

	public WebElement getAllPoints() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(AllPoints, driver, logger) == true) {
			return AllPoints;
		} else
			return null;
	}

	// *************** UPDATE WEBELEMENT
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement Update;

	public WebElement getUpdate() throws Exception {
		commonFunctions.WebElementCommon.staticWait(100);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Update, driver, logger) == true) {
			return Update;
		} else
			return null;
	}

	// *************** ADD POINT WEBELEMENT
	@FindBy(xpath = "//input[@ng-model='vm.meterOrPoint'][@id='sbMeterAdd']")
	private WebElement AddPoint;

	public WebElement getAddPoint() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(AddPoint, driver, logger) == true) {
			return AddPoint;
		} else
			return null;
	}

	// *************** SELECT METER POINT WEBELEMENT
	public List<WebElement> selectMeterPoint = null;

	public List<WebElement> getselectMeterPoint(String pointName) throws InterruptedException {
		selectMeterPoint = driver.findElements(By.xpath("//div[text()='" + pointName
				+ "'][@class='weather-data-source-node-icon ng-binding']//ancestor::div//input[@ng-click='vm.selectedPoint(node);'][@class='margin-right-10 margin-left-10 float-left addpointcheckbox ng-pristine ng-untouched ng-valid']"));
		System.out.println("selectMeterPoint : " + selectMeterPoint);
		return selectMeterPoint;
	}

	// *************** ADD POINT WEBELEMENT
	@FindBy(xpath = "//button[text()='Save'][@ng-click='vm.savePoint()']")
	private WebElement saveMeterPoint;

	public WebElement getSaveMeterPoint() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(saveMeterPoint, driver, logger) == true) {
			return saveMeterPoint;
		} else
			return null;
	}

	// *************** SAVE OFFLINE METER WEBELEMENT
	@FindBy(xpath = "//button[text()='Save'][@ng-click='vm.saveSystem()']")
	private WebElement saveOfflineMeterPoint;

	public WebElement getOfflineSaveMeter() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(saveOfflineMeterPoint, driver, logger) == true) {
			return saveOfflineMeterPoint;
		} else
			return null;
	}

	// *************** SAVE OFFLINE METER WEBELEMENT
	@FindBy(xpath = "//button[text()='Save'][@ng-click='vm.savePoint()']")
	private WebElement save_OfflineMeterPoint;

	public WebElement get_OfflineSaveMeter() throws Exception {
		commonFunctions.WebElementCommon.staticWait(3000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(save_OfflineMeterPoint, driver, logger) == true) {
			return save_OfflineMeterPoint;
		} else
			return null;
	}

	// *************** SELECT METER POINT WEBELEMENT
	public List<WebElement> expandMeterPoint = null;

	public List<WebElement> getexpandMeterPoint(String pointName) throws InterruptedException {
		expandMeterPoint = driver.findElements(By.xpath("(//div[text()='" + pointName
				+ "']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span)[1]"));
		System.out.println("expandMeterPoint : " + expandMeterPoint);
		return expandMeterPoint;
	}

	// *************** SELECT METER POINT WEBELEMENT
	public List<WebElement> select_MeterPoint = null;

	public List<WebElement> selectedAddedPoint(String pointName) throws InterruptedException {
		select_MeterPoint = driver.findElements(By.xpath("//div[text()='" + pointName + "'][@class='ng-binding']"));
		System.out.println("select_MeterPoint : " + select_MeterPoint);
		return select_MeterPoint;
	}

	// *************** ADD POINT WEBELEMENT
	@FindBy(xpath = "//button[@id='HistoricalRequestModalButton']")
	private WebElement HistoricalReq;

	public WebElement getHistoricalReq() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(HistoricalReq, driver, logger) == true) {
			return HistoricalReq;
		} else
			return null;
	}

	// *************** HISTORICAL REQ END DATE WEBELEMENT
	@FindBy(xpath = "//input[@id='endDate']")
	private WebElement endDate;

	public WebElement getendDate() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(endDate, driver, logger) == true) {
			return endDate;
		} else
			return null;
	}

	// *************** HISTORICAL REQ START DATE WEBELEMENT
	@FindBy(xpath = "//input[@id='startDate']")
	private WebElement startDate;

	public WebElement getstartDate() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(startDate, driver, logger) == true) {
			return startDate;
		} else
			return null;
	}

	// *************** HISTORICAL REQ START DATE WEBELEMENT
	public List<WebElement> clickMeterPoint = null;

	public List<WebElement> getclickMeterPoint(String pointName) throws InterruptedException {
		// clickMeterPoint = driver.findElements(By.xpath("//span[text()='" +
		// pointName +
		// "']//parent::div//parent::div//parent::div//preceding-sibling::div//input"));
		clickMeterPoint = driver.findElements(By.xpath("//div/span[text()='" + pointName
				+ "']/parent::div//parent::div//parent::div//preceding-sibling::div//input"));
		System.out.println("clickMeterPoint : " + clickMeterPoint);
		return clickMeterPoint;
	}

	// *************** SUBMIT HISTORICAL REQ WEBELEMENT
	@FindBy(xpath = "//button[text()='Submit'][@class='btn btn-primary ng-scope']")
	private WebElement submit;

	public WebElement getsubmitHistoricalReq() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(submit, driver, logger) == true) {
			return submit;
		} else
			return null;
	}

	// *************** VIRTUAL POINT DEFINATION WEBELEMENT
	@FindBy(xpath = "(//button[@id='launchVirtualMeterModal'])[1]")
	private WebElement VirtualPointDef;

	public WebElement getVirtualPointDef() throws Exception {
		commonFunctions.WebElementCommon.staticWait(1000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(VirtualPointDef, driver, logger) == true) {
			return VirtualPointDef;
		} else
			return null;
	}

	// *************** VIRTUAL POINT EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> expandBuildingTree_VirPopUp = null;

	public List<WebElement> getexpandBuildingTree_VirPopUp(String locationName) throws InterruptedException {
		System.out.println("locationName : " + locationName);
		expandBuildingTree_VirPopUp = driver.findElements(By.xpath("(//div[text()='" + locationName
				+ "']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span)[2]"));
		System.out.println("expandBuildingTree_VirPopUp : " + expandBuildingTree_VirPopUp);
		return expandBuildingTree_VirPopUp;
	}

	// *************** VIRTUAL POINT EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> expandCommodityTree_VirPopUp = null;

	public List<WebElement> getexpandCommodityTree_VirPopUp(String buildingName, String commodityName)
			throws InterruptedException {
		System.out.println("BuildingName : " + buildingName + "  CommodityName : " + commodityName);
		expandCommodityTree_VirPopUp = driver.findElements(
				By.xpath("(//div[text()='" + buildingName + "'])[3]//parent::div//parent::div//parent::li//div[text()='"
						+ commodityName + "']//parent::div//preceding-sibling::a/span"));
		System.out.println("expandCommodityTree_VirPopUp : " + expandCommodityTree_VirPopUp);
		return expandCommodityTree_VirPopUp;
	}

	// *************** VIRTUAL POINT EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> expandMeterPoint_VirPopUp = null;

	public List<WebElement> getexpandMeterTree(String pointName) throws InterruptedException {
		// expandMeterPoint_VirPopUp =
		// driver.findElements(By.xpath("(//div[text()='" + pointName +
		// "']//ancestor::div[@class='space-tree-node ng-scope
		// angular-ui-tree-handle']//a//span)[2]"));
		expandMeterPoint_VirPopUp = driver.findElements(By.xpath("//form[@name='virtualRuleform']//div[text()='"
				+ pointName
				+ "']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a[@ng-click='vm.meterSystemRelationalMapping(node,this)']//span"));
		System.out.println("expandMeterPoint_VirPopUp : " + expandMeterPoint_VirPopUp);
		return expandMeterPoint_VirPopUp;
	}

	// *************** VIRTUAL POINT EXPAND BUILDING TREE WEBELEMENT
	public List<WebElement> MeterPoint_VirPopUp = null;

	public List<WebElement> getSelectMeterPoint(String pointName) throws InterruptedException {
		MeterPoint_VirPopUp = driver.findElements(By.xpath("//div[text()='" + pointName
				+ "']//parent::div[@class='ng-binding ui-draggable ui-draggable-handle']"));
		System.out.println("MeterPoint_VirPopUp : " + MeterPoint_VirPopUp);
		return MeterPoint_VirPopUp;
	}

	// *************** VIRTUAL POINT DEFINATION WEBELEMENT
	@FindBy(xpath = "//div[@id='virtualkeyboard']/textarea[@ng-model='vm.selectedNode.point.TimeSeries[0].customTransformBgExp']")
	private WebElement droppableTextArea;

	public WebElement getdroppableTextArea() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(droppableTextArea, driver, logger) == true) {
			return droppableTextArea;
		} else
			return null;
	}

	// *************** VIRTUAL POINT DEFINATION WEBELEMENT
	@FindBy(xpath = "(//div[@id='virtualkeyboard']/button)[5]")
	private WebElement divide;

	public WebElement getDivideBtn() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(divide, driver, logger) == true) {
			return divide;
		} else
			return null;
	}

	// *************** VIRTUAL POINT DEFINATION WEBELEMENT
	@FindBy(xpath = "//span/input[@name='textVirtualString']")
	private WebElement numericaValue;

	public WebElement getNumericValue() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(numericaValue, driver, logger) == true) {
			return numericaValue;
		} else
			return null;
	}

	// *************** ENTER EXP WEBELEMENT
	@FindBy(xpath = "//button[text()='Enter']")
	private WebElement enterExp;

	public WebElement getenterExp() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(enterExp, driver, logger) == true) {
			return enterExp;
		} else
			return null;
	}

	// *************** VALIDATE SYNTAX WEBELEMENT
	@FindBy(xpath = "//button[text()='Validate Syntax']")
	private WebElement validateSyntax;

	public WebElement getValidateSyntax() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(validateSyntax, driver, logger) == true) {
			return validateSyntax;
		} else
			return null;
	}

	// *************** VALIDATE SYNTAX WEBELEMENT
	@FindBy(xpath = "//button[@ng-click='vm.saveVirtualRule()']")
	private WebElement SaveRule;

	public WebElement getSaveRule() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(SaveRule, driver, logger) == true) {
			return SaveRule;
		} else
			return null;
	}

	// *************** VALIDATE SYNTAX WEBELEMENT
	@FindBy(xpath = "//button[text()='Save'][@id='btnSaveSystem']")
	private WebElement SaveVirtualMeterpoint;

	public WebElement getSaveVirtualMeterpoint() throws Exception {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(SaveVirtualMeterpoint, driver, logger) == true) {
			return SaveVirtualMeterpoint;
		} else
			return null;
	}

	// *************** VIRTUAL METER POINT WEBELEMENT
	public List<WebElement> VirtualMeterPoint = null;

	public List<WebElement> getVirtualMeterPoint(String pointName) throws InterruptedException {
		Thread.sleep(1000);
		VirtualMeterPoint = driver.findElements(By.xpath("//div[text()='" + pointName + "'][@class='ng-binding']"));
		System.out.println("VirtualMeterPoint : " + VirtualMeterPoint);
		return VirtualMeterPoint;
	}

	// *************** VIRTUAL POINT WEBELEMENT
	public List<WebElement> VirtualMeterName = null;

	public List<WebElement> getVirtualMeter(String virtualMeterName) throws InterruptedException {
		VirtualMeterName = driver.findElements(By.xpath(
				"//div[@ng-click='vm.selectNode(node,systemform,meterform)']/div[text()='" + virtualMeterName + "']"));
		System.out.println("VirtualMeterName : " + VirtualMeterName);
		return VirtualMeterName;
	}

	// *************** FACILITY WEBELEMENT
	public List<WebElement> facility = null;

	public List<WebElement> getFacility(String facilityName) throws InterruptedException {
		facility = driver.findElements(By.xpath(
				"//div[@ng-click='vm.selectNode(node,systemform,meterform)']/div[text()='" + facilityName + "']"));
		System.out.println("facility : " + facility);
		return facility;
	}
}
