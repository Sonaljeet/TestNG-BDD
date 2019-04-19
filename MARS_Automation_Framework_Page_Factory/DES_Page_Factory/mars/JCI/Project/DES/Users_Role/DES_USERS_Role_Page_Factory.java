package mars.JCI.Project.DES.Users_Role;

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

public class DES_USERS_Role_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	
	public DES_USERS_Role_Page_Factory(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver,this);
		
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
	
	/**Users Tab element*/
	@FindBy(css="a[automation-id='userTab']")
	WebElement usersTab;
	
	public WebElement getusersTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersTab, logger) == true) {
			element = usersTab;
		}
		return element;
	}
	
	/**Role Tab element*/
	@FindBy(css="li[automation-id='roletab']")
	WebElement roleTab;
	
	public WebElement getroleTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roleTab, logger) == true) {
			element = roleTab;
		}
		return element;
	}
	
	/**role Name Textbox Tab element*/
	@FindBy(css="input[automation-id='rolename']")
	WebElement roleNameTextbox;
	
	public WebElement getroleNameTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roleNameTextbox, logger) == true) {
			element = roleNameTextbox;
		}
		return element;
	}
	
	/**role description Textbox Tab element*/
	@FindBy(css="input[automation-id='roledescription']")
	WebElement roledescriptionTextbox;
	
	public WebElement getroledescriptionTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roledescriptionTextbox, logger) == true) {
			element = roledescriptionTextbox;
		}
		return element;
	}
	
	/** Get Add button*/
	@FindBy(css = "button[automation-id='roleadd']")
	private WebElement Addbtn;

	public WebElement getAddbtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, Addbtn, logger) == true) 
		{
			element = Addbtn;
		}
		return element;
	}
	
	/** Get Update button*/
	@FindBy(css = "button[automation-id='roleupdate']")
	private WebElement Updatebtn;

	public WebElement getUpdatebtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, Updatebtn, logger) == true) 
		{
			element = Updatebtn;
		}
		return element;
	}
	
	/** Get Okbtn button*/
	@FindBy(css = "input[id='popup_ok']")
	private WebElement popup_ok;

	public WebElement getpopup_ok() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, popup_ok, logger) == true) 
		{
			element = popup_ok;
		}
		return element;
	}
	
	/** Get Okbtn button*/
	@FindBy(css = "input[id='popup_cancel']")
	private WebElement popup_cancel;

	public WebElement getpopup_cancel() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, popup_cancel, logger) == true) 
		{
			element = popup_cancel;
		}
		return element;
	}
	
	/** Get Delete button*/
	@FindBy(css = "button[automation-id='roledelete']")
	private WebElement Deletebtn;

	public WebElement getDeletebtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, Deletebtn, logger) == true) 
		{
			element = Deletebtn;
		}
		return element;
	}
	
	/** Get Clear button*/
	@FindBy(css = "button[automation-id='roleclear']")
	private WebElement Clearbtn;

	public WebElement getClearbtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, Clearbtn, logger) == true) 
		{
			element = Clearbtn;
		}
		return element;
	}
	
	/** Get role grid search textbox*/
	@FindBy(xpath = "//input[@class='ui-grid-filter-input ui-grid-filter-input-0'][1]")
	private WebElement roleSeachTextbox;

	public WebElement getroleSeachTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roleSeachTextbox, logger) == true) 
		{
			element = roleSeachTextbox;
		}
		return element;
	}
	
	/** Get role_descrciption grid search textbox*/
	@FindBy(xpath = "//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-00G0']//input")
	private WebElement roleDescriptionSeachTextbox;

	public WebElement getroleDescriptionSeachTextbox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roleDescriptionSeachTextbox, logger) == true) 
		{
			element = roleDescriptionSeachTextbox;
		}
		return element;
	}

	@FindBy(css = "div[class='growl-message ng-binding']")
	private WebElement rolePageSuccessMessage;
	public WebElement getRoleSuccessMessage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, rolePageSuccessMessage, logger) == true) 
		{
			element = rolePageSuccessMessage;
		}
		return element;
	}

}
