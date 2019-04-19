/**
 * 
 */
package mars.JCI.Project.CSD.Localization.HomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Localization.HomePage.CSD_LOCAL_Impersonate_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_LOCAL_Impersonate_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	private static CSD_LOCAL_Impersonate_Page_Factory localIMPPageFactory = null;
	
	@SuppressWarnings("static-access")
	public CSD_LOCAL_Impersonate_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		localIMPPageFactory = new CSD_LOCAL_Impersonate_Page_Factory(driver, logger);
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	
	// Click the Branch/User Tab Link
	public static void clickOnBranchUserLink() {
		waitForSpinnerToDisappear();
		WebElement element = localIMPPageFactory.get_impersonate_BranchUserLink();
		waitForSpinnerToDisappear();
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Branch/User Tab Link clicked successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find Branch/User Tab Link");
		}
	}

	// Search for the User to Impersonate
	public static void searchUserToImpersonate(String userName) {

		waitForSpinnerToDisappear();
		WebElement element = localIMPPageFactory.get_impersonate_searchUserLink();
		waitForSpinnerToDisappear();
		if (element != null) {
			element.sendKeys(userName);
			element.sendKeys(Keys.ENTER);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Desired User to impersonate is entered successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to enter Impersonate User");
		}
	}

	// Click on Impersonate User
	public static void clickOnUserToImpersonate() {
		waitForSpinnerToDisappear();
		WebElement element = localIMPPageFactory.get_impersonate_ImpersonateUserLink();
		waitForSpinnerToDisappear();
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Impersonate User Icon is clicked Successfully!");
		} else {
			logger.log(LogStatus.FAIL, "Failed to click Impersonate User");
		}
	}

	// Verify Impersonate Home Page is Loaded
	public static void checkImpersonateHomePageLoaded() {
		waitForSpinnerToDisappear();
		WebElement element = localIMPPageFactory.get_impersonate_ImpersonateHomePageLink();
		waitForSpinnerToDisappear();
		if (element != null) {
			// logger.log(LogStatus.INFO, "Impersonate User Icon is clicked
			// Successfully!");
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Impersonate Home Page is loaded Successfully!");
		} else {
			logger.log(LogStatus.FAIL, "Failed to load Impersonate Home Page");
		}
	}
	
	
	//Validate Left side Tree Options For Localization.
	public static void validateLeftTreeOptions() {
		
		validateDashboardTab();
		
	}
	
	//Validate Dashboard and its Child nodes' Tags
	public static void validateDashboardTab() {

		waitForSpinnerToDisappear();
		WebElement dashboardTab = localIMPPageFactory.get_impersonate_DashboardTabTextLink();
		if(dashboardTab!=null){
			String dashboardTab_Text = dashboardTab.getText();
			System.out.println("dashboardTab_Text - "+dashboardTab_Text);
			dashboardTab.click();
			logger.log(LogStatus.PASS, "Dashboard Tab is clicked successfully!");
		} else {
			logger.log(LogStatus.FAIL, "Failed to click Dashboard Tab");
		}
	}
	
	
	
	
	
	
	
}
