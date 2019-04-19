package mars.JCI.Project.DES.Alarms;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;


public class DES_SiteAlarms_Page_Factory {

	private static WebDriver driver;
	private static ExtentTest logger;
	WebElement element = null;

	public DES_SiteAlarms_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}
	}

}
