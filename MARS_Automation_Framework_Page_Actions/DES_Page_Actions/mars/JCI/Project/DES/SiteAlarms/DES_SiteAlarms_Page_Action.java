package mars.JCI.Project.DES.SiteAlarms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;

public class DES_SiteAlarms_Page_Action {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	private WebElement element=null;
	
	private static DES_SiteAlarms_Page_Action siteAlPF=null;
	
	DES_SiteAlarms_Page_Action(WebDriver driver, ExtentTest logger){
		this.driver= driver;
		this.logger= logger;
		siteAlPF= new DES_SiteAlarms_Page_Action(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingHome");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

}
