package mars.JCI.Project.CSD.HomePage.Dashboard.Charts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.HomePage.Dashboard.Charts.CSD_HomePage_ChillerSnapshot_Page_Factory;
import mars.JCI.Project.CSD.HomePage.Dashboard.CSD_HomePage_DataValidation_Master;

public class CSD_HomePage_ChillerSnapshot_Page_Action {
	
	
	private static WebDriver driver=null;
	private static ExtentTest logger=null;
	
	@SuppressWarnings("unused")
	private static CSD_HomePage_ChillerSnapshot_Page_Factory csdChillerSnapDB = null;
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	@SuppressWarnings("static-access")
	public CSD_HomePage_ChillerSnapshot_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		csdChillerSnapDB = new CSD_HomePage_ChillerSnapshot_Page_Factory(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	//====================================================================================================================
	
	
	//Navigate to overview
	public static void clickOnOverviewTab(){
		
		waitForSpinnerToDisappear();
		WebElement dashboard_element = csdChillerSnapDB.get_db_Overview_DashboardLink();
		if(dashboard_element!=null){
			
			dashboard_element.click();//MouseOperation.leftClick(element);//
			waitForSpinnerToDisappear();
			WebElement overview_element = csdChillerSnapDB.get_db_Overview_OverviewLink();
			if(overview_element.isDisplayed()){
				overview_element.click();
				logger.log(LogStatus.PASS, "Navigated to Overview Tab.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Navigation failed for Overview Tab.");
		}
	}
	
	//Click on the chiller Details Graphs
	public static void clickOnGraphPoints() 
			throws InterruptedException {
		
		waitForSpinnerToDisappear();
		Thread.sleep(5000);
		List<WebElement> chartMarkers_elements = csdChillerSnapDB.get_db_Overview_markersChartWidgetList();
		//WebElement chartMarker_element = csdChillerSnapDB.get_db_Overview_markersChartList_2();
		if(chartMarkers_elements!=null){
			System.out.println(" - element found.");
			int element_size = chartMarkers_elements.size(); System.out.println("element_size : "+element_size);
			for (int i = 1; i < element_size; i++) {
				Thread.sleep(10000);
				WebElement chartMarkersGraph_elements = csdChillerSnapDB.get_db_Overview_markersChartMarkersList();//chartMarkers_elements.get(i).findElement(By.cssSelector("g[class='highcharts-markers highcharts-tracker']")); //>rect:nth-child(1)
				//List<WebElement> chartMarkersGraph_elements = chartMarkers_elements.get(i).findElements(By.cssSelector("g[class='highcharts-series highcharts-tracker']>rect:nth-child(1)"));
				if(chartMarkersGraph_elements!=null && chartMarkersGraph_elements.isDisplayed()){
					Actions action = new Actions(driver).click(chartMarkersGraph_elements);
					action.build().perform();
					Thread.sleep(10000);
					//chartMarkersGraph_elements.click();
					//chartMarkersGraph_elements.get(0).click();
					System.out.println("Marker Clicked!");
					clickOnGetDataButton();
				}else{
					WebElement chartSeriesGraph_elements = csdChillerSnapDB.get_db_Overview_markersChartMarkersList();
					if(chartSeriesGraph_elements!=null && chartSeriesGraph_elements.isDisplayed()){
						Actions action = new Actions(driver).click(chartSeriesGraph_elements);
						action.build().perform();
						Thread.sleep(10000);
						//chartMarkersGraph_elements.click();
						//chartMarkersGraph_elements.get(0).click();
						System.out.println("Marker Clicked!");
						clickOnGetDataButton();
					//System.out.println("Marker not found!");
				}
				System.out.println(i+" - element found.");
				
			}
			logger.log(LogStatus.PASS, "Clicked on the point details for one element");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to click on Point Details Graph.");
		}
		
	}
	
	
	public static void clickOnGetDataButton() {
		
		waitForSpinnerToDisappear();
		WebElement getData_element = csdChillerSnapDB.get_db_Overview_markersChartGetDataBtn();
		if(getData_element!=null && getData_element.isEnabled()){
			
			waitForSpinnerToDisappear();
			getData_element.click();
			System.out.println("Get Data Button Clicked!");
			logger.log(LogStatus.PASS, "Get Data Button Clicked!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click on Get Data Button.");
		}
		
	}

}
