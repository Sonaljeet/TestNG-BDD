/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard.Charts;

import java.util.List;
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

/**
 * @author cdeyso
 *
 */
public class CSD_HomePage_ChillerSnapshot_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	
	public CSD_HomePage_ChillerSnapshot_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	
	//Method Overload, we are using fluent wait -- For Single Element
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
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}
	}
	
	//Method Overload, we are using fluent wait -- For List of WebElement
	public static boolean waitForElementsPresent(WebDriver driver, List<WebElement> webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}
	}
	
	
	///Dashboard -- Overview -- Dashboard Tab
	@FindBy(css="a[test-id='Dashboard-tab']")
	private WebElement db_Overview_DashboardLink;
		
	public WebElement get_db_Overview_DashboardLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, db_Overview_DashboardLink, logger)){
			return db_Overview_DashboardLink;
		}else
			return null;
	}
	
	///Dashboard -- Overview -- Overview Tab
	@FindBy(css="a[test-id='Overview-tab']")
	private WebElement db_Overview_OverviewLink;
		
	public WebElement get_db_Overview_OverviewLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, db_Overview_OverviewLink, logger)){
			return db_Overview_OverviewLink;
		}else
			return null;
	}
	
	//Dashboard -- Overview -- Point Details Widgets -- All Elements
	@FindBy(css="div[class='highcharts-container']")
	private List<WebElement> db_Overview_markersChartWidgetList;
		
	public List<WebElement> get_db_Overview_markersChartWidgetList(){
		if(commonFunctions.WebElementCommon.waitForElementsPresent(driver, db_Overview_markersChartWidgetList, logger)){
			return db_Overview_markersChartWidgetList;
		}else
			return null;
	}
	
	
	//Dashboard -- Overview -- Chart Markers -- All Elements
	//g[class='highcharts-series'] -- //g[class='highcharts-markers highcharts-tracker']
	@FindBy(css="g[class='highcharts-markers highcharts-tracker']")
	private WebElement db_Overview_markersChartMarkersList;
		
	public WebElement get_db_Overview_markersChartMarkersList(){
		if(waitForElementPresent(driver, db_Overview_markersChartMarkersList, logger)){
			return db_Overview_markersChartMarkersList;
		}else
			return null;
	}
	
	
	//Dashboard -- Overview -- Chart Markers -- All Elements
	//g[class='highcharts-series'] -- //g[class='highcharts-markers highcharts-tracker']
	@FindBy(css="g[class='highcharts-series highcharts-tracker']")
	private WebElement db_Overview_markersChartSeriesList;
		
	public WebElement get_db_Overview_markersChartSeriesList(){
		if(waitForElementPresent(driver, db_Overview_markersChartSeriesList, logger)){
			return db_Overview_markersChartSeriesList;
		}else
			return null;
	}
	
	
	
	//Dashboard -- Overview -- Chart Markers -- PopUP -- GET DATA Button
	@FindBy(css="button[id='btnCall']")
	private WebElement db_Overview_markersChartGetDataBtn;
		
	public WebElement get_db_Overview_markersChartGetDataBtn(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, db_Overview_markersChartGetDataBtn, logger)){
			return db_Overview_markersChartGetDataBtn;
		}else
			return null;
	}
	
	
	

}
