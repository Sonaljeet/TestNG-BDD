package mars.JCI.Project.MEMSCloud.EquipmentConfiguration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;

public class MEMSCloud_EquipmentConfiguration_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	//public String configFile="C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	//private static dataFileLoc
	//ReadPropertyFile.getInstance(mailConfigFile).getProperty("host");
	/**
	 * Instantiates a new MEMS dashboard page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_EquipmentConfiguration_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id = "portfolio")
	private WebElement Portfolio;
	public WebElement getPortfolioDropdown() throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Portfolio,driver, logger)==true) {
		return Portfolio;
	}else
		return null;
	}
	
	@FindBy(id = "facility")
	private WebElement Location;
	public WebElement getLocationDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Location,driver, logger)==true) {
		return Location;
	}else
		return null;
	}
	@FindBy(id = "building")
	private WebElement building;
	public WebElement getBuildingDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(building,driver, logger)==true) {
		return building;
	}else
		return null;
	}
	
	@FindBy(id = "equipmentCategory")
	private WebElement equipmentCategory;
	public WebElement getEquipmentCategoryDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentCategory,driver, logger)==true) {
		return equipmentCategory;
	}else
		return null;
	}
	
	@FindBy(id = "equipmentType")
	private WebElement equipmentType;
	public WebElement getEquipmentTypeDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(equipmentType,driver, logger)==true) {
		return equipmentType;
	}else
		return null;
	}	
	
	@FindBy(id = "equipment_name")
	private WebElement equipment_name;
	public WebElement getequipment_nameTextBox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(equipment_name,driver, logger)==true) {
		return equipment_name;
	}else
		return null;
	}	

	@FindBy(id = "fault_detection")
	private WebElement fault_detection;
	public WebElement getFault_DetectionDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(fault_detection,driver, logger)==true) {
		return fault_detection;
	}else
		return null;
	}		
	

	@FindBy(id = "suffix")
	private WebElement suffix;
	public WebElement getsuffixTextBox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(suffix,driver, logger)==true) {
		return suffix;
	}else
		return null;
	}	
	
	@FindBy(id = "max_capacity")
	private WebElement max_Power;
	public WebElement getMax_PowerTextBox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(max_Power,driver, logger)==true) {
		return max_Power;
	}else
		return null;
	}	
	
	@FindBy(xpath = "//button[@class='dropdown-toggle ng-binding btn btn-default']")
	private WebElement Meters;
	public WebElement getMetersDropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Meters,driver, logger)==true) {
		return Meters;
	}else
		return null;
	}	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement Equipment_searchbox;
	public WebElement getEquipment_Searchbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Equipment_searchbox,driver, logger)==true) {
		return Equipment_searchbox;
	}else
		return null;
	}
	
	
		
	@FindBy(xpath="(//button[text()='Yes'])[1]")
	private WebElement DeleteEquipment_confirm;
	public WebElement getDeleteEquipment_Confirm()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(DeleteEquipment_confirm,driver, logger)==true) {
		return DeleteEquipment_confirm;
	}else
		return null;
	}	
		

	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	private WebElement Add_Equipment_btn;
	public WebElement getAdd_Equipment_Btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Add_Equipment_btn,driver, logger)==true) {
		return Add_Equipment_btn;
	}else
		return null;
	}	
	
	@FindBy(xpath="//button[contains(text(),'Update')]")
	//button[contains(text(),'Add')]
	private WebElement Update_Equipment_btn;
	public WebElement getUpdate_Equipment_Btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Update_Equipment_btn,driver, logger)==true) {
		return Update_Equipment_btn;
	}else
		return null;
	}	
	@FindBy(xpath="//button[contains(text(),'Delete')]")
	private WebElement Delete_Equipment_btn;
	public WebElement getDelete_Equipment_Btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Delete_Equipment_btn,driver, logger)==true) {
		return Delete_Equipment_btn;
	}else
		return null;
	}	
	@FindBy(xpath="//button[contains(text(),'Clear')]")
	private WebElement Clear_Equipment_btn;
	public WebElement getClear_Equipment_Btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Clear_Equipment_btn,driver, logger)==true) {
		return Clear_Equipment_btn;
	}else
		return null;
	}
	

    public List<WebElement> equipment_inequipmentlistgrid = null;
    public List<WebElement> checkEquipemtnPresent() throws InterruptedException{
    	  String Equipment_name_JSONPath = "$..Equipment";
    	  Thread.sleep(2000);
		  String Equipmentname=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Equipment_name_JSONPath);
		  equipment_inequipmentlistgrid = driver.findElements(By.xpath("//span[text()='"+Equipmentname+"']"));
          return equipment_inequipmentlistgrid;
    }
}
