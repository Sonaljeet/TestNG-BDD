package mars.JCI.Project.MEMSCloud.Baseline;

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
import mars.JCI.Project.MEMS_Cloud.Users.MEMSCloud_Users_Action;

public class MEMSCloud_Baseline_Page_Factory {

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
	public MEMSCloud_Baseline_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//button[@data-target='#baselineModel']")
	private WebElement addBaseline_btn;
	public WebElement getaddbaselinebtn() throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(addBaseline_btn,driver,logger)==true) {
		return addBaseline_btn;
	}else
		return null;
	}
	
	@FindBy(xpath = "//form[@name='baselineForm']//input[@id='baselineName']")
	private WebElement baselinename;
	public WebElement getbaselinename() throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(baselinename,driver,logger)==true) {
		return baselinename;
	}else
		return null;
	}
	
	@FindBy(id = "baselineType")
	private WebElement baseline_type;
	public WebElement getbaseline_type()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(baseline_type,driver, logger)==true) {
		return baseline_type;
	}else
		return null;
	}
	
	@FindBy(id = "facility")
	private WebElement Location;
	public WebElement getLocation()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Location,driver, logger)==true) {
		return Location;
	}else
		return null;
	}
	
	@FindBy(id = "building")
	private WebElement Building;
	public WebElement getBuilding()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Building,driver, logger)==true) {
		return Building;
	}else
		return null;
	}
		
	@FindBy(id="commodity")
	private WebElement Commodity;
	public WebElement getCommodity()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Commodity,driver, logger)==true) {
		return Commodity;
	}else
		return null;
	}
	
	@FindBy(id="pointrole")
	private WebElement Pointrole;
	public WebElement getPointrole()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Pointrole,driver,logger)==true) {
		return Pointrole;
	}else
		return null;
	}

	@FindBy(xpath="//input[@placeholder='Search baseline']")
	private WebElement Baseline_searchbox;
	public WebElement getBaseline_searchbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Baseline_searchbox,driver, logger)==true) {
		return Baseline_searchbox;
	}else
		return null;
	}
	
	//@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	@FindBy(xpath="//form[@name='baselineForm']//button[1]")
	private WebElement baselineSubmit_btn;
	public WebElement getbaselineSubmit_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(baselineSubmit_btn,driver, logger)==true) {
		return baselineSubmit_btn;
	}else
		return null;
	}	
		
	@FindBy(xpath="(//button[text()='Yes'])[1]")
	private WebElement DeleteBaseline_confirm;
	public WebElement getDeleteBaseline_confirm()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(DeleteBaseline_confirm,driver, logger)==true) {
		return DeleteBaseline_confirm;
	}else
		return null;
	}	
		
	@FindBy(xpath="//a[@data-target='#baselineModel']")
	private WebElement Editbaseline_btn;
	public WebElement getEditbaseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Editbaseline_btn,driver,  logger)==true) {
		return Editbaseline_btn;
	}else
		return null;
	}	
	
	@FindBy(xpath="//a[@data-target='#confirmModal']")
	private WebElement Deletebaseline_btn;
	public WebElement getDeletebaseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Deletebaseline_btn,driver, logger)==true) {
		return Deletebaseline_btn;
	}else
		return null;
	}	
	
	@FindBy(id="bYear")
	private WebElement Baseline_year;
	public WebElement getBaseline_year_dropdown()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Baseline_year,driver, logger)==true) {
		return Baseline_year;
	}else
		return null;
	}	
	@FindBy(id="january")
	private WebElement Jan_month;
	public WebElement getJan_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Jan_month,driver,logger)==true) {
		return Jan_month;
	}else
		return null;
	}	
	@FindBy(id="february")
	private WebElement Feb_month;
	public WebElement getFeb_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Feb_month,driver, logger)==true) {
		return Feb_month;
	}else
		return null;
	}	
	@FindBy(id="march")
	private WebElement Mar_month;
	public WebElement getMar_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Mar_month,driver, logger)==true) {
		return Mar_month;
	}else
		return null;
	}	
	@FindBy(id="april")
	private WebElement Apr_month;
	public WebElement getApr_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Apr_month,driver, logger)==true) {
		return Apr_month;
	}else
		return null;
	}	
	
	@FindBy(id="may")
	private WebElement May_month;
	public WebElement getMay_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(May_month,driver, logger)==true) {
		return May_month;
	}else
		return null;
	}	
	@FindBy(id="june")
	private WebElement June_month;
	public WebElement getJune_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(June_month,driver,logger)==true) {
		return June_month;
	}else
		return null;
	}	
	@FindBy(id="july")
	private WebElement July_month;
	public WebElement getJuly_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(July_month,driver, logger)==true) {
		return July_month;
	}else
		return null;
	}	
	
	@FindBy(id="august")
	private WebElement Aug_month;
	public WebElement getAug_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Aug_month,driver, logger)==true) {
		return Aug_month;
	}else
		return null;
	}	
	@FindBy(id="september")
	private WebElement Sept_month;
	public WebElement getSept_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Sept_month,driver, logger)==true) {
		return Sept_month;
	}else
		return null;
	}	
	@FindBy(id="october")
	private WebElement Oct_month;
	public WebElement getOct_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Oct_month,driver, logger)==true) {
		return Oct_month;
	}else
		return null;
	}	
	@FindBy(id="november")
	private WebElement Nov_month;
	public WebElement getNov_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Nov_month,driver, logger)==true) {
		return Nov_month;
	}else
		return null;
	}	
	@FindBy(id="december")
	private WebElement Dec_month;
	public WebElement getDec_month_textbox()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Dec_month,driver, logger)==true) {
		return Dec_month;
	}else
		return null;
	}	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement Add_define_baseline_btn;
	public WebElement getAdd_define_baseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(Add_define_baseline_btn,driver, logger)==true) {
		return Add_define_baseline_btn;
	}else
		return null;
	}	
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement update_define_baseline_btn;
	public WebElement getUpdate_define_baseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(update_define_baseline_btn,driver,logger)==true) {
		return update_define_baseline_btn;
	}else
		return null;
	}	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement delete_define_baseline_btn;
	public WebElement getDelete_define_baseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(delete_define_baseline_btn,driver,logger)==true) {
		return delete_define_baseline_btn;
	}else
		return null;
	}	
	@FindBy(xpath="//button[text()='Clear']")
	private WebElement clear_define_baseline_btn;
	public WebElement getClear_define_baseline_btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(clear_define_baseline_btn,driver, logger)==true) {
		return clear_define_baseline_btn;
	}else
		return null;
	}
	
	
	
	@FindBy(xpath="(//div[@class='form-control no-border no-border-space-0'])[2]//input")
	private List<WebElement> Allbaselinemonthstextboxes;
	public List<WebElement> getAllbaselinemonthstextboxes(){
	if (Allbaselinemonthstextboxes.size() > 0){
		return Allbaselinemonthstextboxes;
	}else
		return null;
	}	
	
	//@FindBy(xpath="(//button[text()='Yes'])[2]")
     @FindBy(xpath="(//div[@id='confirmBaselineYearModal']//button)[2]")
	private WebElement DeleteDefineBaseline_confirm;
	public WebElement getDeleteDefineBaselineConfirm_Btn()throws Exception{
	if (commonFunctions.WebElementCommon.waitForElementPresent(DeleteDefineBaseline_confirm,driver, logger)==true) {
		return DeleteDefineBaseline_confirm;
	}else
		return null;
	}	
	public List<WebElement> definebaseline_indefinebaselinelistgridbyyear = null;
    public List<WebElement> checkdefinebaselinepresent() throws InterruptedException{
    	  Thread.sleep(2000);
    	  String Baseline_year_JSONPath = "$..Baseline_year";
		  String baseline_year=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_year_JSONPath);
		  definebaseline_indefinebaselinelistgridbyyear = driver.findElements(By.xpath("//span[text()='"+baseline_year+"']"));
          return definebaseline_indefinebaselinelistgridbyyear;
    }
    
    public List<WebElement> definebaseline_indefinebaselinelistgridbymonth = null;
    public List<WebElement> checkdefinebaselinepresentbymonth() throws InterruptedException{
    	 Thread.sleep(2000);
    	  String Baseline_update_month_JSONPath = "$..Baselinedata.BaselineMonthupdateValue";
		  String baseline_updatemonth=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Baseline_update_month_JSONPath);
		  definebaseline_indefinebaselinelistgridbymonth = driver.findElements(By.xpath("//span[text()='"+baseline_updatemonth+"']"));
          return definebaseline_indefinebaselinelistgridbymonth;
    }

    public List<WebElement> baseline_inbaselinelistgrid = null;
    public List<WebElement> checkbaselinepresent() throws InterruptedException{
    	  String Baseline_name_JSONPath = "$..baselinename";
    	  Thread.sleep(2000);
		  String baselinename=ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), Baseline_name_JSONPath);
          baseline_inbaselinelistgrid = driver.findElements(By.xpath("//a[text()='"+baselinename+"']"));
          return baseline_inbaselinelistgrid;
    }
}
