package mars.JCI.Project.DES.Trend;

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


public class DES_SiteTrend_Page_Factory {

	private static WebDriver driver;
	private static ExtentTest logger;
	WebElement element = null;

	public DES_SiteTrend_Page_Factory(WebDriver driver, ExtentTest logger) {
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
	
	@FindBy(css="a[automation-id='linkTrend']")
	public WebElement linkTrend;

	public WebElement getlinkTrendTab(){
		if(WebElementCommon.waitForElementPresent(driver, linkTrend, logger)==true){
			element=linkTrend;
		}
		return element;
	}
	
	@FindBy(css="button[automation-id='btnAddChart']")
	private WebElement btnAddChart;
	
	public WebElement getbtnAddChart(){
		if(WebElementCommon.waitForElementPresent(driver, btnAddChart, logger)==true){
			element=btnAddChart;
		}
		return element;
	}
	
	@FindBy(css="div[class='conten_header']")
	public List<WebElement> presentChartList;
	
	@FindBy(xpath="//div//input[@type='checkbox']")
	public List<WebElement> pointList;
	
	@FindBy(css="div[automation-id='pointCompareModal']")
	public WebElement pointPage;
	
	@FindBy(css="div[automation-id='nopointselected']")
	public WebElement nopointselected;
	
	public WebElement getnopointselected(){
		if(WebElementCommon.waitForElementPresent(driver, nopointselected, logger)==true){
			element=nopointselected;
		}
		return element;
	}
	
	@FindBy(xpath="//button[@automation-id='btnClose']")
	public WebElement closePointPopUpButton;

	public WebElement getPopUpCloseButton(){
		if(WebElementCommon.waitForElementPresent(driver, closePointPopUpButton, logger)==true){
			element=closePointPopUpButton;
		}
		return element;
	}
	
	@FindBy(xpath="//button[@automation-id='btnGenerateChart']")
	public WebElement btnGenerateChart;

	public WebElement getbtnGenerateChart(){
		if(WebElementCommon.waitForElementPresent(driver, btnGenerateChart, logger)==true){
			element=btnGenerateChart;
		}
		return element;
	}
	
	@FindBy(xpath="//button[@automation-id='btnResetComaprePoints']")
	public WebElement btnResetComaprePoints;

	public WebElement getbtnResetComaprePoints(){
		if(WebElementCommon.waitForElementPresent(driver, btnResetComaprePoints, logger)==true){
			element=btnResetComaprePoints;
		}
		return element;
	}
	
	@FindBy(xpath="//input[@id='popup_prompt']")
	public WebElement popup_promptTextBox;

	public WebElement getpopup_promptTextBox(){
		if(WebElementCommon.waitForElementPresent(driver, popup_promptTextBox, logger)==true){
			element=popup_promptTextBox;
		}
		return element;
	}
	
	@FindBy(xpath="//input[@id='popup_ok']")
	public WebElement popup_ok;

	public WebElement getpopup_ok(){
		if(WebElementCommon.waitForElementPresent(driver, popup_ok, logger)==true){
			element=popup_ok;
		}
		return element;
	}
}
