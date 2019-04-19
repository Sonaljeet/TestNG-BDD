package mars.JCI.Project.DES.SiteOverView;

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

import commonFunctions.WebElementCommon;

public class DES_SiteOverView_Page_Factory {
	/** The WebDriver driver. */
	private static WebDriver driver;
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	
	public DES_SiteOverView_Page_Factory(WebDriver driver,ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
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
	
	/**  searchBox  Element. */
	@FindBy(css = "input[automation-id='txtSearch']")
	private WebElement searchBox;

	public WebElement getSearchBox() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, searchBox, logger) == true) {
			element = searchBox;
		}
		return element;
	}
	
	/**  customer List  Element. */
	@FindBy(css = "span[title='QA Site Demo']")
	private WebElement demoSite;

	public WebElement getDemoSite() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, demoSite, logger) == true) {
			element = demoSite;
		}
		return element;
	}
	
	/**  Get overview Tab */
	@FindBy(css = "a[automation-id='linkOverview']")
	private WebElement overviewTab;

	public WebElement getoverviewTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, overviewTab, logger) == true) {
			element = overviewTab;
		}
		return element;
	}
	
	/**  Get Details Tab */
	@FindBy(css = "a[automation-id='linkDetails']")
	private WebElement detailsTab;

	public WebElement getdetailsTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, detailsTab, logger) == true) {
			element = detailsTab;
		}
		return element;
	}
	
	/**  Get trend Tab */
	@FindBy(css = "a[automation-id='linkTrend']")
	private WebElement trendTab;

	public WebElement gettrendTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, trendTab, logger) == true) {
			element = trendTab;
		}
		return element;
	}
	
	/**  Get alarms Tab */
	@FindBy(css = "a[automation-id='linkAlarms']")
	private WebElement alarmsTab;

	public WebElement getalarmsTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, alarmsTab, logger) == true) {
			element = alarmsTab;
		}
		return element;
	}
	
	/**  Get alarms Tab */
	@FindBy(css = "a[automation-id='linkReports']")
	private WebElement reportTab;

	public WebElement getreportTab() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, reportTab, logger) == true) {
			element = reportTab;
		}
		return element;
	}
	
	/**  State of Charge Div */
	@FindBy(css = "div[automation-id='divEnergy']")
	private WebElement energyWidget;

	public WebElement getenergyWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, energyWidget, logger) == true) {
			element = energyWidget;
		}
		return element;
	}
	
	/**  Get battery Level Percentage  */
	@FindBy(css = "h2[automation-id='batteryLevelPercentage']")
	private WebElement batteryLevelPercentage;

	public WebElement getbatteryLevelPercentage() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, batteryLevelPercentage, logger) == true) {
			element = batteryLevelPercentage;
		}
		return element;
	}
	/**  Get  AC Capacity */
	@FindBy(css = "div[automation-id='dcCapacity']")
	private WebElement DCCapacity;
	public WebElement getDCCapacity() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, DCCapacity, logger) == true) {
			element = DCCapacity;
		}
		return element;
	}
	
	//**  Get current battery Level   */
	/*@FindBy(css = "span[automation-id='currentLevel']")
	private WebElement currentLevel;

	public WebElement getcurrentLevel() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, currentLevel, logger) == true) {
			element = currentLevel;
		}
		return element;
	}
	
	*//**  Get  max Level   *//*
	@FindBy(css = "span[automation-id='maxLevel']")
	private WebElement maxLevel;

	public WebElement getmaxLevel() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, maxLevel, logger) == true) {
			element = maxLevel;
		}
		return element;
	}*/
	
	/**  Get  Units assinged */
	@FindBy(css = "span[automation-id='unitType']")
	private WebElement unitType;

	public WebElement getunitType() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, unitType, logger) == true) {
			element = unitType;
		}
		return element;
	}

	//**--------------------------------------------------------*/
	/**  Get  agg. Power Summary Widget */
	@FindBy(css = "div[automation-id='aggPowerSummary']")
	private WebElement aggPowerSummaryWidget;
	public WebElement getaggPowerSummary() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, aggPowerSummaryWidget, logger) == true) {
			element = aggPowerSummaryWidget;
		}
		return element;
	}
	
	/**  Get  agg. Power agg charge value */
	@FindBy(css = "span[automation-id='aggchargevalue']")
	private WebElement aggchargevalue;
	public WebElement getaggchargevalue() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, aggchargevalue, logger) == true) {
			element = aggchargevalue;
		}
		return element;
	}
	
	/**  Get  agg. Power agg charge value */
	@FindBy(css = "span[automation-id='aggpowerunit']")
	private WebElement aggchargevalueUnit;
	public WebElement getaggchargevalueUnit() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, aggchargevalueUnit, logger) == true) {
			element = aggchargevalueUnit;
		}
		return element;
	}
	
	/**  Get  AC Capacity */
	@FindBy(css = "div[automation-id='accapacity']")
	private WebElement ACCapacity;
	public WebElement getACCapacity() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ACCapacity, logger) == true) {
			element = ACCapacity;
		}
		return element;
	}
	
	
	/**  Get  agg. Power Summary chart */
	@FindBy(css = "div[id='simpleaggPowergaugechartWidgetHC']")
	private WebElement aggPowerSummarychart;

	public WebElement getaggPowerSummarychart() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, aggPowerSummarychart, logger) == true) {
			element = aggPowerSummarychart;
		}
		return element;
	}
	
	/**  Get  agg. Power Summary value */
	@FindBy(xpath = "//div[@automation-id='aggpowernodata']")
	private WebElement aggPowerSummaryvalue;

	public WebElement getaggPowerSummaryvalue() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, aggPowerSummaryvalue, logger) == true) {
			element = aggPowerSummaryvalue;
		}
		return element;
	}
	
	/**  Get  system health widget */
	@FindBy(css = "div[automation-id='systemHealth']")
	private WebElement systemHealthWidget;

	public WebElement getsystemHealthWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, systemHealthWidget, logger) == true) {
			element = systemHealthWidget;
		}
		return element;
	}
	
	/**  Get  Site Name */
	@FindBy(css = "h3[automation-id='siteName']")
	private WebElement SiteName;

	public WebElement getSiteName() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, SiteName, logger) == true) {
			element = SiteName;
		}
		return element;
	}
	
	/**  Get powerPercentage percentage */
	@FindBy(css = "span[automation-id='powerPercentage']")
	private WebElement powerPercentage;

	public WebElement getpowerPercentageValue() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, powerPercentage, logger) == true) {
			element = powerPercentage;
		}
		return element;
	}
	
	/**  Get commission  date */
	@FindBy(css = "span[automation-id='commissioningDate']")
	private WebElement commissionDate;

	public WebElement getcommissionDate() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, commissionDate, logger) == true) {
			element = commissionDate;
		}
		return element;
	}
	
	/**  Get Last Data Collected Date */
	@FindBy(css = "h3[automation-id='lastDataCollected']")
	private WebElement latDataCollectedDate;

	public WebElement getlatDataCollectedDate() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, latDataCollectedDate, logger) == true) {
			element = latDataCollectedDate;
		}
		return element;
	}
	
	
	/**  Get Last Data Collected time */
	@FindBy(css = "h3[automation-id='lastDataCollectedTime']")
	private WebElement latDataCollectedTime;

	public WebElement getlatDataCollectedTime() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, latDataCollectedTime, logger) == true) {
			element = latDataCollectedTime;
		}
		return element;
	}
	
	/**  Get SOC trend*/
	@FindBy(css = "div[automation-id='socTrend']")
	private WebElement socTrendWidget;

	public WebElement getsocTrendWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, socTrendWidget, logger) == true) {
			element = socTrendWidget;
		}
		return element;
	}
	
	/**  Get SOC trend maximize button*/
	@FindBy(css = "i[automation-id='showMaximizeView']")
	private WebElement socGraphMax;

	public WebElement getsocGraphMax() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, socGraphMax, logger) == true) {
			element = socGraphMax;
		}
		return element;
	}
	
	//"//*[contains(text(), 'No data to display for selected period.')]"
	
	/**  No Data available*/
	@FindBy(xpath = "//*[contains(text(), 'No data to display for selected period.')]")
	private WebElement noGraphavailable;

	public WebElement getNoGraphDataAvailable() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, noGraphavailable, logger) == true) {
			element = noGraphavailable;
		}
		return element;
	}
	
	/**  Current Power trend*/
	@FindBy(css = "div[automation-id='currentPowerTrend']")
	private WebElement currentPowerTrendWidget;

	public WebElement getcurrentPowerTrendWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, currentPowerTrendWidget, logger) == true) {
			element = currentPowerTrendWidget;
		}
		return element;
	}
	
	/**  Get SOC trend maximize button*/
	@FindBy(css = "i[automation-id='showMaximizeViewcurrentPower']")
	private WebElement currentPowerGraphMax;

	public WebElement getcurrentPowerGraphMax() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, currentPowerGraphMax, logger) == true) {
			element = currentPowerGraphMax;
		}
		return element;
	}
	
	
	
	/**  Get Site info link from overview page*/
	@FindBy(css = "a[automation-id='btnSiteInfo']")
	private WebElement siteInfoWidget;

	public WebElement getsiteInfoWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, siteInfoWidget, logger) == true) {
			element = siteInfoWidget;
		}
		return element;
	}
	
	/**  Get Site info link  close button*/
	@FindBy(css = "button[automation-id='btnModalClose']")
	private WebElement closeSiteInfoWidget;

	public WebElement getcloseSiteInfoWidget() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, closeSiteInfoWidget, logger) == true) {
			element = closeSiteInfoWidget;
		}
		return element;
	}
	/**  Get Site info link Logo for Site*/
	@FindBy(css = "img[id='viewLogo']")
	private WebElement siteLogo;
	public WebElement getsiteLogo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, siteLogo, logger) == true) {
			element = siteLogo;
		}
		return element;
	}
	
	/**  Get Alarms List raised for Site*/
	@FindBy(xpath = "//*[@id='alarmsData']/div/div[1]/h3")//"//div/div[1]/h3[contains(text(),'Alarms')]"
	private WebElement alrmWidgetHeader;
	public WebElement getalrmWidgetHeader() 
	{
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, alrmWidgetHeader, logger) == true) {
			element = alrmWidgetHeader;
		}
		return element;
	}
	
	/**  Get Alarms Expansion button*/
	@FindBy(css = "i[id='alarmsexpandicon']")
	private WebElement alarmsExpansion;
	public WebElement getalarmsExpansionBtn() 
	{
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, alarmsExpansion, logger) == true) {
			element = alarmsExpansion;
		}
		return element;
	}
	
	
}
