package mars.JCI.Project.CSD.Localization.HomePage;

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

public class CSD_LOCAL_Impersonate_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_LOCAL_Impersonate_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	
	//Method Overload, we are using fluent wait
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
	
	//The Site Setup Tab
	
	// Branch/User View Tab
	@FindBy(css = "a[test-id='BranchUserView-tab']")
	private WebElement impersonate_BranchUserLink;

	public WebElement get_impersonate_BranchUserLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_BranchUserLink, logger)) {
			return impersonate_BranchUserLink;
		} else
			return null;
	}

	// User search Textbox
	@FindBy(css = "#wrap > div > div > div > div.row > div > div > div:nth-child(2) > div > span:nth-child(2) > input")
	private WebElement impersonate_searchUserLink;

	public WebElement get_impersonate_searchUserLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_searchUserLink, logger)) {
			return impersonate_searchUserLink;
		} else
			return null;
	}

	// User Impersonate Icon Image
	@FindBy(css = "#wrap > div > div > div > div.row > div > div > div:nth-child(2) > div > div > table > tbody > tr.ng-scope > td:nth-child(1) > span > img")
	private WebElement impersonate_ImpersonateUserLink;

	public WebElement get_impersonate_ImpersonateUserLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ImpersonateUserLink, logger)) {
			return impersonate_ImpersonateUserLink;
		} else
			return null;
	}

	// Verify Impersonate HomePage is loaded
	@FindBy(css = "span[test-id='lnkStopImpersonate']")
	private WebElement impersonate_ImpersonateHomePageLink;

	public WebElement get_impersonate_ImpersonateHomePageLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ImpersonateHomePageLink,
				logger)) {
			return impersonate_ImpersonateHomePageLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Dashboard Tag
	@FindBy(css = "a[test-id='Dashboard-tab']>span>span")
	private WebElement impersonate_DashboardTabLink;

	public WebElement get_impersonate_DashboardTabTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_DashboardTabLink,
				logger)) {
			return impersonate_DashboardTabLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Overview Tag
	@FindBy(css = "a[test-id='Overview-tab']>span>span")
	private WebElement impersonate_OverviewTabLink;

	public WebElement get_impersonate_OverviewTabLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_OverviewTabLink,
				logger)) {
			return impersonate_OverviewTabLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Point Details Tag
	@FindBy(css = "a[test-id='PointDetails-tab']>span>span")
	private WebElement impersonate_PointDetailsTabLink;

	public WebElement get_impersonate_PointDetailsTabLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_PointDetailsTabLink,
				logger)) {
			return impersonate_PointDetailsTabLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Comparative Tag
	@FindBy(css = "a[test-id='Comparative-tab']>span>span")
	private WebElement impersonate_ComparativeTabLink;

	public WebElement get_impersonate_ComparativeTabLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ComparativeTabLink,
				logger)) {
			return impersonate_ComparativeTabLink;
		} else
			return null;
	}

	//Dashboard Tab -- Chiller Status Tag
	@FindBy(css = "div[class='header_chart Runtime chiller-home']>span")
	private WebElement impersonate_ChillerStatusTextLink;

	public WebElement get_impersonate_ChillerStatusTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ChillerStatusTextLink,
				logger)) {
			return impersonate_ChillerStatusTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Customer List by Status Tag
	@FindBy(css = "div[class='header_chart Runtime status-wise']>span")
	private WebElement impersonate_CustListStatusTextLink;

	public WebElement get_impersonate_CustListStatusTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_CustListStatusTextLink,
				logger)) {
			return impersonate_CustListStatusTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab -- Customer List by Status Tag
	@FindBy(css = "#wrap > div > div > div > div.row.image_box > div.col-md-8 > div > div.customer-name-details > div.row > div.col-md-5 > div > div > table > tbody > tr > th > span.heading-custmer-list > span")
	private WebElement impersonate_CustNameStatusTextLink;

	public WebElement get_impersonate_CustNameStatusTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_CustNameStatusTextLink,
				logger)) {
			return impersonate_CustNameStatusTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab --  Facility Name Tag
	@FindBy(css = "#wrap > div > div > div > div.row.image_box > div.col-md-8 > div > div.customer-name-details > div.row > div.col-md-4 > div > div > table > tbody > tr > th > span.heading-custmer-list > span")
	private WebElement impersonate_FacilityNameStatusTextLink;

	public WebElement get_impersonate_FacilityNameStatusTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_FacilityNameStatusTextLink,
				logger)) {
			return impersonate_FacilityNameStatusTextLink;
		} else
			return null;
	}
	
	
	//Dashboard Tab --  Chillers Tag
	@FindBy(css = "#wrap > div > div > div > div.row.image_box > div.col-md-8 > div > div.customer-name-details > div.row > div.col-md-3 > div > div > table > tbody > tr > th > span.heading-custmer-list > span")
	private WebElement impersonate_ChillerNameStatusTextLink;

	public WebElement get_impersonate_ChillerNameStatusTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ChillerNameStatusTextLink,
				logger)) {
			return impersonate_ChillerNameStatusTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab --  Chiller Information Tag
	@FindBy(css = "div[class='header_chart Cooling chiller-home']>span")
	private WebElement impersonate_ChillerInformationTextLink;

	public WebElement get_impersonate_ChillerInformationTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ChillerInformationTextLink,
				logger)) {
			return impersonate_ChillerInformationTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab --  Status Check Tag
	@FindBy(css = "div.header_chart.Cooling.chiller-home.tabs-header-b > ul > li.active > a > span")
	private WebElement impersonate_ChillerStatusCheckTextLink;

	public WebElement get_impersonate_ChillerStatusCheckTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ChillerStatusCheckTextLink,
				logger)) {
			return impersonate_ChillerStatusCheckTextLink;
		} else
			return null;
	}
	
	//Dashboard Tab --  Health Check Tag
	@FindBy(css = "div.header_chart.Cooling.chiller-home.tabs-header-b > ul > li:nth-child(2) > a > span")
	private WebElement impersonate_ChillerHealthCheckTextLink;

	public WebElement get_impersonate_ChillerHealthCheckTextLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ChillerHealthCheckTextLink,
				logger)) {
			return impersonate_ChillerHealthCheckTextLink;
		} else
			return null;
	}
	
	
	//
	
	
	
}
