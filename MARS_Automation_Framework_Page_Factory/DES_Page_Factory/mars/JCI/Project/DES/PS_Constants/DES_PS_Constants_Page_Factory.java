package mars.JCI.Project.DES.PS_Constants;

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

public class DES_PS_Constants_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	
	public DES_PS_Constants_Page_Factory(WebDriver driver,ExtentTest logger){
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
	
	/**PS Tab customer name dropdown element*/
	@FindBy(css="select[automation-id='drpdwnpsCustomer']")
	WebElement customerNamedrpdown;
	
	public WebElement getcustomerNamedrpdown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, customerNamedrpdown, logger) == true) {
			element = customerNamedrpdown;
		}
		return element;
	}
	
	/**PS Tab site name dropdown element*/
	@FindBy(css="select[automation-id='drpdwnpsSite']")
	WebElement siteNamedrpdown;
	
	public WebElement getsiteNamedrpdown() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, siteNamedrpdown, logger) == true) {
			element = siteNamedrpdown;
		}
		return element;
	}
	
	/**PS  constants tab element*/
	@FindBy(css="a[automation-id='psConstants']")
	WebElement psConstantsTab;
	
	public WebElement getpsConstantsTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsTab, logger) == true) {
			element = psConstantsTab;
		}
		return element;
	}
	
	/**PS  constants System element*/
	@FindBy(css="select[automation-id='drpdwnconstantSystem']")
	WebElement psConstantsSystem;
	
	public WebElement getpsConstantsSystem() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsSystem, logger) == true) {
			element = psConstantsSystem;
		}
		return element;
	}
	
	/**PS  constants Point element*/
	@FindBy(css="select[automation-id='drpdwnconstantPoint']")
	WebElement psConstantsPoint;
	
	public WebElement getpsConstantsPoint() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsPoint, logger) == true) {
			element = psConstantsPoint;
		}
		return element;
	}
	
	/**PS  constants Value element*/
	@FindBy(css="input[automation-id='constantValue']")
	WebElement psConstantsValue;
	
	public WebElement getpsConstantsValue() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsValue, logger) == true) {
			element = psConstantsValue;
		}
		return element;
	}
	
	/**PS  constants add button element*/
	@FindBy(css="button[automation-id='btnconstantAdd']")
	WebElement psConstantsAddButton;
	
	public WebElement getpsConstantsAddButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsAddButton, logger) == true) {
			element = psConstantsAddButton;
		}
		return element;
	}
	
	/**PS  constants Value element*/
	@FindBy(css="button[automation-id='c']")
	WebElement psConstantsClearButton;
	
	public WebElement getpsConstantsClearButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psConstantsClearButton, logger) == true) {
			element = psConstantsClearButton;
		}
		return element;
	}

}
