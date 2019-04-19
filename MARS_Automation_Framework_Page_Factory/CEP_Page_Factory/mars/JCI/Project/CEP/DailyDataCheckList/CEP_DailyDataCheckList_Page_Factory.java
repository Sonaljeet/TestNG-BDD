package mars.JCI.Project.CEP.DailyDataCheckList;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_DailyDataCheckList_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	@SuppressWarnings("static-access")
	public CEP_DailyDataCheckList_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "svg>g.highcharts-series-group>g>g>rect[fill='#006400']")
	private WebElement highchartGreen;

	public WebElement getHighChartGreen() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, highchartGreen, logger) == true) {
			return highchartGreen;
		} else {
			return null;
		}
	}

	@FindBy(css = ".form-control.width_100")
	private WebElement searchCustomerTextBox;

	public WebElement getSearchCustomerTextBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchCustomerTextBox, logger) == true) {
			return searchCustomerTextBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='overflow_text']/span[@title='SAM HOUSTON STATE UNIVERSITY']")
	private WebElement customerNameToSearch;

	public WebElement getCustomerNameToSearch() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerNameToSearch, logger) == true) {
			return customerNameToSearch;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='overflow_text']/span[@title='SAM HOUSTON STATE WOODLANDS']")
	private WebElement actualCustomerName;

	public WebElement getActualCustomerName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, actualCustomerName, logger) == true) {
			return actualCustomerName;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@title='YMC2 Chiller 2']/span")
	private WebElement chillerName;

	public WebElement getChillerName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerName, logger) == true) {
			return chillerName;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-xs-12 pull-right text-right margin-right-10']/button[@class='btn btn-primary btn-lg']")
	private WebElement manageActivePoints;

	public WebElement getManageActivePoints() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, manageActivePoints, logger) == true) {
			return manageActivePoints;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='input-group']/input")
	private WebElement searchForSelectPoints;

	public WebElement getSearchForSelectPoints() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchForSelectPoints, logger) == true) {
			return searchForSelectPoints;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//span[text()='LEAVING CHW TEMP']//preceding-sibling::input")
	private WebElement checkBoxPointID;

	public WebElement getCheckBoxPointID() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, checkBoxPointID, logger) == true) {
			return checkBoxPointID;
		} else {
			return null;
		}
	}

	@FindBy(id = "save")
	private WebElement saveButton;

	public WebElement getSaveButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveButton, logger) == true) {
			return saveButton;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-md-5 list-inline durationSelectionList']/ul/li[1]")
	private WebElement slider24H;

	public WebElement getSlider24H() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, slider24H, logger) == true) {
			return slider24H;
		} else {
			return null;
		}
	}

	@FindBy(css = "svg.highcharts-root>g.highcharts-series-group>g")
	private List<WebElement> trendsHighChart;

	public List<WebElement> gettrendsHighChart() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendsHighChart, logger) == true) {
			return trendsHighChart;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content-header trends-heading']/ul/li[2]")
	private WebElement chartOptions;

	public WebElement getChartOptions() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chartOptions, logger) == true) {
			return chartOptions;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content-header trends-heading']/ul/li[2]/ul/li[2]")
	private WebElement exportCSVButton;

	public WebElement getExportCSVButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, exportCSVButton, logger) == true) {
			return exportCSVButton;
		} else {
			return null;
		}
	}

}
