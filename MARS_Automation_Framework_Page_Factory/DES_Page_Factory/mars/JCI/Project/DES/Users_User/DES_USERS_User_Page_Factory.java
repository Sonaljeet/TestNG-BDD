package mars.JCI.Project.DES.Users_User;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;

public class DES_USERS_User_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	WebElement element = null;
	
	
	public DES_USERS_User_Page_Factory(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		
	}
	
	public static boolean waitForElementPresent(WebDriver driver,WebElement webElement,ExtentTest logger) throws TimeoutException{
		try{
		 // Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(15, TimeUnit.SECONDS)
		       .pollingEvery(1, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);
		   fluentWait.until(ExpectedConditions.visibilityOf(webElement));
		return true;
		}catch (NullPointerException e){
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		
		}catch (TimeoutException e){
			logger.log(LogStatus.ERROR, "Failled! --"+e.getMessage().substring(0,150));
			return false;
		}catch (Exception e){
			logger.log(LogStatus.ERROR, "Failled! --"+e.getMessage().substring(0,150));
			return false;
		}
	}
	
	/**User tab element*/
	@FindBy(css="li[automation-id='usertab']")
	WebElement usertab;
	
	public WebElement getusertab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usertab, logger) == true) {
			element = usertab;
		}
		return element;
	}
	/**User first name element*/
	@FindBy(css="input[automation-id='firstname']")
	WebElement usersfirstname;
	
	public WebElement getuserFirstnameTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersfirstname, logger) == true) {
			element = usersfirstname;
		}
		return element;
	}
	
	/**User last name element*/
	@FindBy(css="input[automation-id='lastname']")
	WebElement userslastname;
	
	public WebElement getuserLastnameTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userslastname, logger) == true) {
			element = userslastname;
		}
		return element;
	}

	/**User Role element*/
	@FindBy(css="select[automation-id='roleid']")
	WebElement userslroleid;
	
	public WebElement getRoleidTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userslroleid, logger) == true) {
			element = userslroleid;
		}
		return element;
	}
	
	@FindBy(css = "div[class='growl-message ng-binding']")
	private WebElement rolePageSuccessMessage;
	public WebElement getUserSuccessMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, rolePageSuccessMessage, logger) == true) 
		{
			element = rolePageSuccessMessage;
		}
		return element;
	}
	
	/**User Name*/
	@FindBy(css="input[automation-id='username']")
	WebElement username;
	
	public WebElement getUsernameTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, username, logger) == true) {
			element = username;
		}
		return element;
	}
	
	/**User password*/
	@FindBy(css="input[automation-id='password']")
	WebElement userspassword;
	
	public WebElement getPasswordTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userspassword, logger) == true) {
			element = userspassword;
		}
		return element;
	}
	
	/**User Confirm Password */
	@FindBy(css="input[automation-id='confirmpassword']")
	WebElement usersconfirmpassword;
	
	public WebElement getConfirmpasswordTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersconfirmpassword, logger) == true) {
			element = usersconfirmpassword;
		}
		return element;
	}
	
	/**User Email */
	@FindBy(css="input[automation-id='email']")
	WebElement usersemail;
	
	public WebElement getusersemailTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersemail, logger) == true) {
			element = usersemail;
		}
		return element;
	}
	
	/**User contact number*/
	@FindBy(css="input[name='contactNumber']")
	WebElement userscontactnumber;
	
	public WebElement getuserContactnumberTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, userscontactnumber, logger) == true) {
			element = userscontactnumber;
		}
		return element;
	}
	
	/**User profilepic*/
	@FindBy(css="input[automation-id='profilepic']")
	WebElement usersprofilepic;
	
	public WebElement getuserProfilepicTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersprofilepic, logger) == true) {
			element = usersprofilepic;
		}
		return element;
	}
	
	/**User userViewLogo*/
	@FindBy(css="img[automation-id='userViewLogo']")
	WebElement usersViewLogo;
	
	public WebElement getusersViewLogo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersViewLogo, logger) == true) {
			element = usersViewLogo;
		}
		return element;
	}
	
	/** Get Add button*/
	@FindBy(css = "button[automation-id='btnAddUser']")
	private WebElement btnAddUser;

	public WebElement getbtnAddUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, btnAddUser, logger) == true) 
		{
			element = btnAddUser;
		}
		return element;
	}
	
	/** Get Update button*/
	@FindBy(css = "button[automation-id='btnUpdateUser']")
	private WebElement btnUpdateUser;

	public WebElement getbtnUpdateUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, btnUpdateUser, logger) == true) 
		{
			element = btnUpdateUser;
		}
		return element;
	}
	
	/** Get Delete button*/
	@FindBy(css = "button[automation-id='btnDeleteUser']")
	private WebElement btnDeleteUser;

	public WebElement getbtnDeleteUser() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, btnDeleteUser, logger) == true) 
		{
			element = btnDeleteUser;
		}
		return element;
	}
	
	/** Get Clear button*/
	@FindBy(css = "button[automation-id='btnReset']")
	private WebElement btnReset;

	public WebElement getUserClearbtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, btnReset, logger) == true) 
		{
			element = btnReset;
		}
		return element;
	}
	
	/** Get FirstName Search textbox from grid*/
	@FindBy(xpath = "(//input[@class='ui-grid-filter-input ui-grid-filter-input-0'])[1]")
	private WebElement firstNameSearchTextbox;

	public WebElement getfirstNameSearchTextbox() {
		
		if (WebElementCommon.waitForElementPresent(driver, firstNameSearchTextbox, logger) == true) 
		{
			element = firstNameSearchTextbox;
		}
		return element;
	}
	
	
	/** Get first Element from Grid */
	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-00AS-cell') +1) = '0-uiGrid-00AS-cell']")
	private WebElement UserFirstNameFromGrid;

	public WebElement getUserFirstNameFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, UserFirstNameFromGrid, logger) == true) {
			element = UserFirstNameFromGrid;
		}
		return element;
	}
	
	/** Get first Element from Grid */
	@FindBy(xpath = "//input[@id='popup_ok']")
	private WebElement confirmOKButton;

	public WebElement getconfirmOKButton() {
		if (WebElementCommon.waitForElementPresent(driver, confirmOKButton, logger) == true) {
			element = confirmOKButton;
		}
		return element;
	}
	
	/** Get first Element from Grid */
	@FindBy(xpath = "//input[@id='popup_cancel']")
	private WebElement confirmCancelButton;

	public WebElement getconfirmCancelButton() {
		if (WebElementCommon.waitForElementPresent(driver, confirmCancelButton, logger) == true) {
			element = confirmCancelButton;
		}
		return element;
	}
	
}
