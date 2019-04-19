package mars.JCI.Project.MEMSCloud.Users;

import java.util.ArrayList;
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

public class MEMSCloud_Users_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;

	/** The ExtentTest logger. */
	private static ExtentTest logger;
	//public String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
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
	public MEMSCloud_Users_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	public WebElement getusername() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(username,driver, logger) == true) {
			return username;
		} else
			return null;
	}

	@FindBy(name = "password")
	private WebElement password;

	public WebElement getpassword() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(password,driver, logger) == true) {
			return password;
		} else
			return null;
	}

	@FindBy(name = "ConfirmPassword")
	private WebElement ConfirmPassword;

	public WebElement getConfirmPassword() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(ConfirmPassword,driver, logger) == true) {
			return ConfirmPassword;
		} else
			return null;
	}

	@FindBy(name = "firstname")
	private WebElement firstname;

	public WebElement getfirstname() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(firstname,driver, logger) == true) {
			return firstname;
		} else
			return null;
	}

	@FindBy(name = "lastname")
	private WebElement lastname;

	public WebElement getlastname() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(lastname,driver, logger) == true) {
			return lastname;
		} else
			return null;
	}

	@FindBy(name = "organization")
	private WebElement organization;

	public WebElement getorganization() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(organization,driver, logger) == true) {
			return organization;
		} else
			return null;
	}

	@FindBy(name = "role")
	private WebElement role;

	public WebElement getrole() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(role,driver, logger) == true) {
			return role;
		} else
			return null;
	}

	@FindBy(xpath = "//select[contains(@ng-model, 'rrc.role')]")
	private WebElement userrole;

	public WebElement get_User_Role() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(userrole,driver,  logger) == true) {
			return userrole;
		} else {
			return null;
		}

	}

	// Dashboard View check box 
	@FindBy(css = "input[id='chkView_1']") 
	private WebElement chkDashboardView;
	public WebElement get_chkDashboardView() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);					
			return chkDashboardView;	
	}

	// Dashboard Edit check box
	@FindBy(css = "input[id='chkEdit_1']")
	private WebElement chkDashboardEdit;
	public WebElement get_chkDashboardEdit() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);		
			return chkDashboardEdit;		
	}

	// SetUp View check box
	@FindBy(css = "input[id='chkView_17']")
	private WebElement chkSetupView;
	public WebElement get_chkSetupView() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);		
			return chkSetupView;		
	}

	// SetUp Edit check box
	@FindBy(css = "input[id='chkEdit_17']")
	private WebElement chkSetupEdit;
	public WebElement get_chkSetupEdit() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);		
			return chkSetupEdit;		
	}

	// Reports View check box
	@FindBy(css = "input[id='chkView_55']")
	private WebElement chkReportsView;
	public WebElement get_chkReportsView() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);		
			return chkReportsView;		
	}

	// Reports Edit check box
	@FindBy(css = "input[id='chkEdit_55']")
	private WebElement chkReportsEdit;
	public WebElement get_chkReportsEdit() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);		
			return chkReportsEdit;		
	}
	
	// Roles Save button Webelement
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveRoles;
	public WebElement get_SaveRoles()throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(saveRoles,driver, logger) == true) {
			return saveRoles;
		} else
			return null;
	}
	

	@FindBy(name = "userEmail")
	private WebElement userEmail;

	public WebElement getuserEmail() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(userEmail,driver,logger) == true) {
			return userEmail;
		} else
			return null;
	}

	@FindBy(name = "contactnumber")
	private WebElement contactnumber;

	public WebElement getcontactnumber() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(contactnumber,driver, logger) == true) {
			return contactnumber;
		} else
			return null;
	}
	@FindBy(name = "language")
	private WebElement Language;

	public WebElement getLanguageDropDown() throws Exception{
		commonFunctions.WebElementCommon.staticWait(500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Language,driver, logger) == true) {
			return Language;
		} else
			return null;
	}

	
	@FindBy(xpath = "//Select[@ng-model='pagingOptions.pageSize']")
	private WebElement Pagesize_dropdown;

	public WebElement getpagesize_dropdown() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Pagesize_dropdown,driver, logger) == true) {
			return Pagesize_dropdown;
		} else
			return null;
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement User_searchbox;

	public WebElement getUser_searchbox() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(User_searchbox,driver, logger) == true) {
			return User_searchbox;
		} else
			return null;
	}
	
	@FindBy(xpath = "//input[@placeholder='Search role']")
	private WebElement getSuperadmin_searchbox;

	public WebElement getSuperadmin_searchbox() throws Exception{
		commonFunctions.WebElementCommon.staticWait(1200);
		if (commonFunctions.WebElementCommon.waitForElementPresent(getSuperadmin_searchbox,driver, logger) == true) {
			return getSuperadmin_searchbox;
		} else
			return null;
	}

	@FindBy(name = "RoleName")
	private WebElement User_Role;

	public WebElement getUser_Role() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(User_Role,driver, logger) == true) {
			return User_Role;
		} else
			return null;
	}

	@FindBy(name = "Description")
	private WebElement Role_Description;

	public WebElement getRole_Description() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(Role_Description,driver, logger) == true) {
			return Role_Description;
		} else
			return null;
	}

	@FindBy(xpath = "//button[@ng-click='uvc.SaveUserDetails(userPopUpForm)']")
	private WebElement userSubmit_btn;

	public WebElement getuserSubmit_btn() throws Exception{
		commonFunctions.WebElementCommon.staticWait(600);
		if (commonFunctions.WebElementCommon.waitForElementPresent(userSubmit_btn,driver, logger) == true) {
			return userSubmit_btn;
		} else
			return null;
	}

	@FindBy(xpath = "//a[contains(text(),'Create user')]")
	private WebElement createUser_tab;

	public WebElement getcreateUser_tab() throws Exception{
		commonFunctions.WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(createUser_tab,driver, logger) == true) {
			return createUser_tab;
		} else
			return null;
	}

	@FindBy(xpath = "//a[contains(text(),'Role & rights')]")
	private WebElement RolesandRights_tab;

	public WebElement getRolesandRights_tab() throws Exception{
		commonFunctions.WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(RolesandRights_tab,driver, logger) == true) {
			return RolesandRights_tab;
		} else
			return null;
	}

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement DeleteUser_confirm;

	public WebElement getDeleteUser_confirm() throws Exception{
		commonFunctions.WebElementCommon.staticWait(1500);
		if (commonFunctions.WebElementCommon.waitForElementPresent(DeleteUser_confirm,driver, logger) == true) {
			return DeleteUser_confirm;
		} else
			return null;
	}

	@FindBy(xpath = "//button[@data-target='#addUserModel']")
	private WebElement addUSer_btn;

	public WebElement getaddUSer_btn() throws Exception{
		commonFunctions.WebElementCommon.staticWait(2000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(addUSer_btn,driver, logger) == true) {
			return addUSer_btn;
		} else
			return null;
	}

	@FindBy(xpath = "//button[@data-target='#confirmDelete']")
	
	private WebElement DeleteUser_btn;

	public WebElement DeleteUser_btn() throws Exception{
		commonFunctions.WebElementCommon.staticWait(1400);
		if (commonFunctions.WebElementCommon.waitForElementPresent(DeleteUser_btn,driver, logger) == true) {
			return DeleteUser_btn;
		} else
			return null;
	}

	public List<WebElement> username_inuserlistgrid = null;
	public List<WebElement> checkuserpresent() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("username : " + MEMSCloud_Users_Action.username);
		System.out.println("xpath : " + "//span[text()='" + ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser") + "']");
		username_inuserlistgrid = driver
				.findElements(By.xpath("//span[text()='" + ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser") + "']"));
		return username_inuserlistgrid;
	}

}
