package mars.JCI.Project.CEP.HeatMap;

import java.util.List;
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

import mars.Component.Functions.BaseClass;

public class CEP_StatusCheckHeatMap_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	public CEP_StatusCheckHeatMap_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Status Check Red Color
	@FindBy(css = "svg>g.highcharts-series-group>g>g>rect[fill='#FF0000']")
	private WebElement statusCheckRed;

	public WebElement getStatusCheckRed() throws Exception {
		System.out.println(statusCheckRed.getAttribute("fill"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusCheckRed, logger) == true) {
			return statusCheckRed;
		} else {
			return null;
		}
	}

	// Status Check Yellow Color
	@FindBy(css = "svg>g.highcharts-series-group>g>g>rect[fill='#FFFF00']")
	private WebElement statusCheckYellow;

	public WebElement getStatusCheckYellow() throws Exception {
		System.out.println(statusCheckYellow.getAttribute("fill"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusCheckYellow, logger) == true) {
			return statusCheckYellow;
		} else {
			return null;
		}
	}

	// Status Check Orange Color
	@FindBy(css = "svg>g.highcharts-series-group>g>g>rect[fill='#FFA500']")
	private WebElement statusCheckOrange;

	public WebElement getStatusCheckOrange() throws Exception {
		System.out.println(statusCheckOrange.getAttribute("fill"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusCheckOrange, logger) == true) {
			return statusCheckOrange;
		} else {
			return null;
		}
	}

	// Status Check Grey Color
	@FindBy(css = "svg>g.highcharts-series-group>g>g>rect[fill='#808080']")
	private WebElement statusCheckGrey;

	public WebElement getStatusCheckGrey() throws Exception {
		System.out.println(statusCheckGrey.getAttribute("fill"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusCheckGrey, logger) == true) {
			return statusCheckGrey;
		} else {
			return null;
		}
	}
	//Customer for Grey Color
	@FindBy(xpath="//div[@class='Customer_bottom bg_color']/div/span")
	private WebElement customerGrey;
	
	public WebElement getCustomerGrey() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerGrey, logger) == true) {
			return customerGrey;
		} else {
			return null;
		}
	}
	//Get Chillers Count for all colors
	@FindBy(css="svg>g[class*='highcharts-treemap-series']>g>text>tspan.highcharts-text-outline")
	private List<WebElement> chillerCount;
	
	public List<WebElement> getChillerCount() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerCount, logger) == true) {
			return chillerCount;
		} else {
			return null;
		}
	}
	//Site name in the search result
	public WebElement getProjectInSearchResult(String project) throws Exception{
		try{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(30, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-md-4 project-content-height')]/div/div/div/div/div/span[text()=\"" + project + "\"]")));
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'col-md-4 project-content-height')]/div/div/div/div/div/span[text()=\"" + project + "\"]"));
			return element;
		}catch(TimeoutException e){
			return null;
		}
		catch(NoSuchElementException e){
			return null;
		}
	}
	//Asset name in the search result
	public WebElement getAssetInSearchResult(String asset) throws Exception{
		try{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(60, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-md-3 project-content-height')]/div/div/div/div/div/span[contains(text(),\"" + asset + "\")]")));
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'col-md-3 project-content-height')]/div/div/div/div/div/span[contains(text(),\"" + asset + "\")]"));
			return element;
		}catch(TimeoutException e){
			return null;
		}
		catch(NoSuchElementException e){
			return null;
		}	
	}
	//Asset Name in 'Chiller Information' Section
	public WebElement getAssetNameInChillerInformation(String asset) throws Exception{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(60, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-md-12 margin-top-10 padding-left-10']/p[@title=\"" + asset + "\"]")));
			WebElement element = driver.findElement(By.xpath(
					"//div[@class='col-md-12 margin-top-10 padding-left-10']/p[@title=\"" + asset + "\"]"));
			return element;
	}
	//Asset Name in 'Chiller Information' Section
		public List<WebElement> getAssetListInChillerInformation(String asset) throws Exception{
				Thread.sleep(6000);
				List<WebElement> element = driver.findElements(By.xpath(
						"//div[@class='col-md-12 margin-top-10 padding-left-10']/p[@title=\"" + asset + "\"]"));
				return element;
		}
	//Asset Name in 'Status/HealthCheck' Section
	public WebElement getAssetNameInStatusHealthCheck(String asset) throws Exception{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(60, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-md-9 select_status ']/p/span")));
			WebElement element = driver.findElement(By.xpath(
					"//div[@class='col-md-9 select_status ']/p/span"));
			return element;
	}
	//Asset Name in 'Status/HealthCheck' Section
	public List<WebElement> getAssetListInStatusHealthCheck(String asset) throws Exception{
		Thread.sleep(6000);
		List<WebElement> element = driver.findElements(By.xpath(
					"//div[@class='col-md-9 select_status ']/p/span"));
			return element;
	}
}
