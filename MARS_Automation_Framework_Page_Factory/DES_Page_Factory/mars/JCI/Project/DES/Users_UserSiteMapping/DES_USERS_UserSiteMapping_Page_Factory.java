package mars.JCI.Project.DES.Users_UserSiteMapping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class DES_USERS_UserSiteMapping_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	
	public DES_USERS_UserSiteMapping_Page_Factory(WebDriver driver, ExtentTest logger){
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
	@FindBy(css="li[automation-id='usersitemappingtab']")
	WebElement usersitemappingtab;
	
	public WebElement getusersitemappingtab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersitemappingtab, logger) == true) {
			element = usersitemappingtab;
		}
		return element;
	}
	
	/**Users Tab element*/
	@FindBy(css="select[automation-id='user']")
	WebElement usersDropdown;
	
	public WebElement getusersDropdown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, usersDropdown, logger) == true) {
			element = usersDropdown;
		}
		return element;
	}
	

	/** Get Save button*/
	@FindBy(css = "input[value='Save']")
	private WebElement UserSitemappingSavebtn;

	public WebElement getUserSitemappingSavebtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserSitemappingSavebtn, logger) == true) 
		{
			element = UserSitemappingSavebtn;
		}
		return element;
	}
	
	/** Get Cancel button*/
	@FindBy(css = "input[value='Cancel']")
	private WebElement UserSitemappingCancelbtn;

	public WebElement getUserSitemappingCancelbtn() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, UserSitemappingCancelbtn, logger) == true) 
		{
			element = UserSitemappingCancelbtn;
		}
		return element;
	}
	
	/** Get Role name*/
	@FindBy(css = "label[class='label ng-binding']")
	private WebElement roleNameLabel;

	public WebElement getroleNameLabel() {
		
		if (WebElementCommon.waitForElementPresent(driver, roleNameLabel, logger) == true) 
		{
			element = roleNameLabel;
		}
		return element;
	}
	
	/** Select JCI Cheesland customer from site list*/
	//@FindBy(xpath="//span[@title='JCI Cheesland']//parent::div/input")
	private WebElement customerNamecheckbox;
	
	public WebElement getcustomerNamecheckbox(String siteName){
		customerNamecheckbox = driver.findElement(By.xpath("//span[@title='"+siteName+"']//parent::div/input"));
		/*if(WebElementCommon.waitForElementPresent(driver, customerNamecheckbox, logger)==true);
		{
			element=customerNamecheckbox;
		}
		*/
		return customerNamecheckbox;
		
	}

}
