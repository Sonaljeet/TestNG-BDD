package mars.JCI.Project.CEP.HeatMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;

public class CEP_HealthCheckHeatMap_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	public CEP_HealthCheckHeatMap_Page_Factory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Chiller Status Drop down
	@FindBy(xpath="//div[contains(@class,'col-md-6 select_status')]/select")
	private WebElement chillerStatusDropDown;
	
	public WebElement getChillerStatusDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerStatusDropDown, logger) == true) {
			return chillerStatusDropDown;
		} else {
			return null;
		}
	}
	//Health Check Green Color
	@FindBy(css="svg>g.highcharts-series-group>g>g>rect[fill='#006400']")
	private WebElement healthCheckGreen;
	
	public WebElement getHealthCheckGreen() throws Exception{
		//System.out.println(healthCheckGreen.getAttribute("fill"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, healthCheckGreen, logger) == true) {
			return healthCheckGreen;
		} else {
			return null;
		}
	}
	//Status/HealthCheck Status Drop down
	@FindBy(xpath="//div[contains(@class,'text-right margin-top-10')]/select")
	private WebElement healthCheckStatusDropDown;
	
	public WebElement getHealthCheckStatusDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, healthCheckStatusDropDown, logger) == true) {
			return healthCheckStatusDropDown;
		} else {
			return null;
		}
	}
	//Count of total green for HealthCheck
	@FindBy(css="svg>g[class*='highcharts-treemap-series']>g>text>tspan.highcharts-text-outline")
	private WebElement healthCheckCountOfGreenColor;
	
	public WebElement getHealthCheckCountOfGreenColor() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, healthCheckCountOfGreenColor, logger) == true) {
			return healthCheckCountOfGreenColor;
		} else {
			return null;
		}
	}
	//Search text box in 'Customer List By Status' section
	@FindBy(css="div[class*='margin-top-10 margin-bottom']>form>input")
	private WebElement searchTextBox;
	
	public WebElement getSearchTextBox() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchTextBox, logger) == true) {
			return searchTextBox;
		} else {
			return null;
		}
	}
	//Customer name in the search result
	public WebElement getCustomerInSearchResult(String customer) throws Exception{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(60, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='customer-body']/div/div/div/span[text()=\"" + customer + "\"]")));
			WebElement element = driver.findElement(By.xpath(
					"//div[@class='customer-body']/div/div/div/span[text()=\"" + customer + "\"]"));
			return element;
	}
}
