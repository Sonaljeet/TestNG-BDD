package mars.JCI.Project.DES.Users_RolesAndRight;

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

public class DES_USERS_RolesAndRight_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	
	public DES_USERS_RolesAndRight_Page_Factory(WebDriver driver, ExtentTest logger){
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
	
	/**Role & Rights  Tab element*/
	@FindBy(css="li[automation-id='roleandrighttab']")
	WebElement roleandrighttab;
	
	public WebElement getroleandrighttab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, roleandrighttab, logger) == true) {
			element = roleandrighttab;
		}
		return element;
	}
	
	/**Roles drop down element*/
	@FindBy(css="select[automation-id='rolename']")
	WebElement rolenamedopdown;
	
	public WebElement getrolenamedropdown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, rolenamedopdown, logger) == true) {
			element = rolenamedopdown;
		}
		return element;
	}
	
	/** Get Save button*/
	@FindBy(css = "input[automation-id='rolerightSave']")
	private WebElement rolerightSavebtn;

	public WebElement getrolerightSavebtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, rolerightSavebtn, logger) == true) 
		{
			element = rolerightSavebtn;
		}
		return element;
	}
	
	/** Get Cancel button*/
	@FindBy(css = "input[automation-id='rolerightcancel']")
	private WebElement rolerightcancelbtn;

	public WebElement getrolerightcancelbtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, rolerightcancelbtn, logger) == true) 
		{
			element = rolerightcancelbtn;
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
