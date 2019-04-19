package mars.JCI.Project.DES.PS_Tariff;

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

public class DES_PS_Tariff_Page_Factory {
	public static WebDriver driver;
	public static ExtentTest logger;
	
	public DES_PS_Tariff_Page_Factory(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver,  this);
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
	@FindBy(css="a[automation-id='psTariff']")
	WebElement psTariffTab;
	
	public WebElement getpsTariffTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, psTariffTab, logger) == true) {
			element = psTariffTab;
		}
		return element;
	}

}
