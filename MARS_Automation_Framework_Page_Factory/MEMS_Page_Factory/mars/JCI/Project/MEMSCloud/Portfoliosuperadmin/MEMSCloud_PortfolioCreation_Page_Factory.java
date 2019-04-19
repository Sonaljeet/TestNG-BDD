package mars.JCI.Project.MEMSCloud.Portfoliosuperadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_PortfolioCreation_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	//private static dataFileLoc
	//ReadPropertyFile.getInstance(mailConfigFile).getProperty("host");
	/**
	 * Instantiates a new MEMS dashboard page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_PortfolioCreation_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='I Agree']")
	private List<WebElement> Iagree;
	public List<WebElement> getIAgreebtn()throws Exception{
	commonFunctions.WebElementCommon.staticWait(3000);
	if(Iagree.size() >0 ){
		return Iagree;
	}else
		return null;
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userid;
	public WebElement getuser()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(userid,driver, logger)==true) {
		return userid;
	}else
		return null;
	}
	
	
	
	//@FindAll{@FindBy(name = "ParentRole"}
	@FindAll({@FindBy (name = "ParentRole")})
	public WebElement accountTypeDpList = null;
	public WebElement getAccountTypeDPList()throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(accountTypeDpList,driver, logger)==true) {
			return accountTypeDpList;
		}else
			return null;
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	public WebElement getpassword()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(password,driver, logger)==true) {
		return password;
	}else
		return null;
	}
	
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement Login;
	public WebElement getloginin()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Login,driver, logger)==true) {
		return Login;
	}else
		return null;
	}
	
	@FindBy(xpath = "//button[@value='submit']")  //temp changes submit
	private WebElement Setup;
	public WebElement getSetup()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Setup,driver, logger)==true) {
		return Setup;
	}else
		return null;
	}
	

	@FindBy(xpath = "//a[contains(text(),'Create organization')]")
	private WebElement Create_organization_tab;
	public WebElement getCreate_organization_tab()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Create_organization_tab,driver, logger)==true) {
		return Create_organization_tab;
	}else
		return null;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Create role')]")
	private WebElement Create_Role_tab;
	public WebElement getCreate_Role_tab()throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Create_Role_tab,driver, logger)==true) {
			return Create_Role_tab;
		}else
			return null;
	}
		
	@FindBy(name="portfolioname")
	private WebElement Portfolio_name;
	public WebElement getPortfolio_name()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Portfolio_name,driver, logger)==true) {
		return Portfolio_name;
	}else
		return null;
	}
	
	@FindBy(id="dateformat")
	private WebElement dateformat;
	public WebElement getdateformat()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(dateformat,driver, logger)==true) {
		return dateformat;
	}else
		return null;
	}

	@FindBy(id="rolename")
	private WebElement Account_type;
	public WebElement getAccount_type()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Account_type,driver, logger)==true) {
		return Account_type;
	}else
		return null;
	}
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement Add_organization_btn;
	public WebElement getAdd_organization_btn()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Add_organization_btn,driver, logger)==true) {
		return Add_organization_btn;
	}else
		return null;
	}
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement clickOnAddButton;
	public WebElement getclickOnAddButton()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(clickOnAddButton,driver, logger)==true) {
		return clickOnAddButton;
	}else
		return null;
	}	
	
	@FindBy(id="ParentRole")
	private WebElement selectAccountType;
	public WebElement getselectAccountType()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(selectAccountType,driver, logger)==true) {
		return selectAccountType;
	}else
		return null;
	}	
	
	@FindBy(xpath="//Select[@ng-model='pagingOptions.pageSize']")
	private WebElement Pagesize_dropdown;
	public WebElement getpagesize_dropdown()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Pagesize_dropdown,driver, logger)==true) {
		return Pagesize_dropdown;
	}else
		return null;
	}
	
	
	@FindBy(xpath="//button[text()='Deactivate']")
	private WebElement Deactivate_organization_btn;
	public WebElement getDeactivate_organization_btn()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Deactivate_organization_btn,driver, logger)==true) {
		return Deactivate_organization_btn;
	}else
		return null;
	}	
	
	@FindBy(xpath="//a[contains(text(),'Recycle Bin')]")
	private WebElement Recyclebin_tab;
	public WebElement getRecyclebin_tab()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(Recyclebin_tab,driver, logger)==true) {
		return Recyclebin_tab;
	}else
		return null;
	}	
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement DeactivateOrgnization_confirm;
	public WebElement getDeactivateOrgnization_confirm()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1500);
	if (commonFunctions.WebElementCommon.waitForElementPresent(DeactivateOrgnization_confirm,driver, logger)==true) {
		return DeactivateOrgnization_confirm;
	}else
		return null;
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement User_searchbox;
	public WebElement getUser_searchbox()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(User_searchbox,driver,logger)==true) {
		return User_searchbox;
	}else
		return null;
	}
	
	@FindBy(xpath="//input[@placeholder='Search role']")
	private WebElement Superadmin_searchbox;
	public WebElement getSuperadmin_searchbox()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(User_searchbox,driver, logger)==true) {
		return Superadmin_searchbox;
	}else
		return null;
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']/img")
	private WebElement 	UserImage;
	public WebElement getUserImage()throws Exception{
	commonFunctions.WebElementCommon.staticWait(1000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(UserImage,driver, logger)==true) {
		return UserImage;
	}else
		return null;
	}
	
    public WebElement Organizationname_inorgnizationgrid = null;
    public WebElement checkOrgnizationpresent() throws InterruptedException{
    	  Thread.sleep(2000);
          //System.out.println("Organizationame : "+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
          //System.out.println("xpath : "+"//span[text()='"+MEMSCloud_Orgnization_Action.Organizationame+"']");
          Organizationname_inorgnizationgrid = driver.findElement(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")+"']"));
          if(commonFunctions.WebElementCommon.waitForElementPresent(driver, Organizationname_inorgnizationgrid, logger)){
                 return Organizationname_inorgnizationgrid;
          }else
                 return null;
    }
    public WebElement rolename_inrolegrid = null;
    public WebElement checkRolePresent() throws InterruptedException{
    	 Thread.sleep(1000);
          //System.out.println("Organizationame : "+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
          //System.out.println("xpath : "+"//span[text()='"+MEMSCloud_Orgnization_Action.Organizationame+"']");
    	  rolename_inrolegrid = driver.findElement(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminRole")+"']"));
          if(commonFunctions.WebElementCommon.waitForElementPresent(driver, rolename_inrolegrid, logger)){
                 return rolename_inrolegrid;
          }else
                 return null;
    }	
}
