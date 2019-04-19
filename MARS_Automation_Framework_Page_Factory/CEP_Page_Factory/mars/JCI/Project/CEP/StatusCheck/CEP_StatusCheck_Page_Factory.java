package mars.JCI.Project.CEP.StatusCheck;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_StatusCheck_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	@SuppressWarnings("static-access")
	public CEP_StatusCheck_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	//Get chiller info spinner
	@FindBy(css = "div.overlayheatmap>spinner")
	private WebElement spinnerChillerInfo;

	public WebElement getSpinnerChillerInfo() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, spinnerChillerInfo, logger) == true) {
			return spinnerChillerInfo;
		} else {
			return null;
		}
	}
	
	public boolean getSpinnerStatusChillerInfo() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(spinnerChillerInfo));
			return spinner.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}


	// Get Spinner
	@FindBy(css = "div.overlaycustomerlist>spinner")
	private WebElement spinner;

	public WebElement getSpinner() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, spinner, logger) == true) {
			return spinner;
		} else {
			return null;
		}
	}

	public boolean getSpinnerStatus() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(spinner));
			return spinner.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	// Get Date List
	@FindBy(css = "div[class^='highcharts-container']>svg>g[class*='highcharts-yaxis-labels ']>text>tspan")
	private List<WebElement> dateList;

	public List<WebElement> getDateList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, dateList, logger) == true) {
			return dateList;
		} else {
			return null;
		}
	}

	// Get No data message for Status Check
	@FindBy(xpath = "//div[@class='NoDataStatusCheck']/h4")
	private WebElement noDataMessageStatusCheck;

	public WebElement getNoDataMessageStatusCheck() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, noDataMessageStatusCheck, logger) == true) {
			return noDataMessageStatusCheck;
		} else {
			return null;
		}
	}

	// Get Points Name List
	@FindBy(xpath = "//div[contains(@class,'chart-label-box')]/span")
	private List<WebElement> pointNameList;

	public List<WebElement> getPointNameList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pointNameList, logger) == true) {
			return pointNameList;
		} else {
			return null;
		}
	}

	// Get Header
	@FindBy(xpath = "//div[@class='content-header']/h3")
	private List<WebElement> headerList;

	public WebElement getHeader() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, headerList.get(3), logger) == true) {
			return headerList.get(3);
		} else {
			return null;
		}
	}

	// Get Drop down
	@FindBy(name = "StatusHealthChart")
	private WebElement dropDown;

	public WebElement getDropDown() throws Exception {
		if (dropDown!=null) {
			return dropDown;
		} else {
			return null;
		}
	}

	// Get Pagination
	@FindBy(xpath = "//div[@class='col-md-12']/img")
	private List<WebElement> pagination;

	public List<WebElement> getPagination() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pagination, logger) == true) {
			return pagination;
		} else {
			return null;
		}
	}

	// Get Gantt Chart
	//@FindBy(css = "div[class^='highcharts-container']>svg>g[class='highcharts-series-group']>g")
	@FindBy(xpath="//div[@class='col-sm-12 col-md-9 chartBottomMinus23']/chart/div/*[name()='svg']/*[name()='g']/*[name()='g']/*[name()='rect'][1]")
	private WebElement statusChart;

	public WebElement getStatusChart() throws Exception {
		if (statusChart!=null) {
			return statusChart;
		} else {
			return null;
		}
	}

	// Get Trends tab
	@FindBy(xpath = "//li[@class='details tab']/a/b")
	private WebElement trendsTab;

	public WebElement getTrendsTab() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendsTab, logger) == true) {
			return trendsTab;
		} else {
			return null;
		}
	}
}
