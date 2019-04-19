package mars.JCI.Project.DES.SiteTrend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.SiteOverview.DES_SiteOverview_Page_Action;
import mars.JCI.Project.DES.Trend.DES_SiteTrend_Page_Factory;

public class DES_SiteTrend_Page_Action {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element=null;
	
	private static DES_SiteTrend_Page_Factory siteTrPF=null;
	private static DES_Home_Page_Action homePA=null;
	private static DES_Login_Page_Action loginPA=null;
	private static DES_SiteOverview_Page_Action siteOvPA=null;
	
	DES_SiteTrend_Page_Action(WebDriver driver, ExtentTest logger){
		this.driver= driver;
		this.logger= logger;
		siteTrPF= new DES_SiteTrend_Page_Factory(driver, logger);
		homePA= new DES_Home_Page_Action(driver, logger);
		loginPA= new DES_Login_Page_Action(driver, logger);
		
	}
	
	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingHome");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static void verifyIfNoChartsAdded(){
		By xpath= By.xpath("//div[@automation-id='nopointselected']");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		
	}
	
	public static void waitForTrendSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingtrendcharts");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public static void navigateToTrendTab(){
		try {
			element = siteTrPF.getlinkTrendTab();
			if(element!=null){
				waitForSpinnerToDisappear();
				element.click();
				Thread.sleep(5000);
				waitForTrendSpinnerToDisappear();
			}
			logger.log(LogStatus.PASS, "Navigate to Trend Page");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not navigate to Trend page");
		}
	}
	public static void createTrendGraph(){
		try{
		loginPA.DES_CorrectLogin();
		siteOvPA.validateSiteOverviewWidgetsLoad();
		navigateToTrendTab();
		
		
		
	}catch (Exception e) {
		logger.log(LogStatus.FAIL, "Could not create Trend Chart");
	}
	}
	
	
	/*public static boolean getCheckBoxStatus(){
		boolean status=false;
		
		element=driver.findElement(By.)
		status=
		return status;
		
	}*/

}
