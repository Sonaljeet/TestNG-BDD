package mars.JCI.Project.CEP.Smoke;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Trends_Smoke_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	@SuppressWarnings("static-access")
	public CEP_Trends_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	// Get Main Spinner
	@FindBy(css = "div.componentLevelSpinner>spinner")
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
	
	// Get Point Spinner
	@FindBy(css = "div[class*='componentLevelSpinner_trend']>spinner")
	private WebElement spinnerPoint;

	public WebElement getSpinnerPoint() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, spinnerPoint, logger) == true) {
			return spinnerPoint;
		} else {
			return null;
		}
	}

	public boolean getSpinnerStatusPoint() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(spinnerPoint));
			return spinnerPoint.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@class=' pull-left']/ul/li")
	private WebElement breadCrumb;

	public WebElement getBreadCrumb() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, breadCrumb, logger) == true) {
			return breadCrumb;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'text-right')]/button")
	private WebElement managePointButton;

	public WebElement getManagePointButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, managePointButton, logger) == true) {
			return managePointButton;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'selectedPointsLists')]/ul/li")
	private List<WebElement> listOfSelectedPoint;

	public List<WebElement> getListOfSelectedPoints() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, listOfSelectedPoint, logger) == true) {
			return listOfSelectedPoint;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'margin-top-10 text-center')]/button")
	private List<WebElement> saveButton;

	public List<WebElement> getSaveButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveButton, logger) == true) {
			return saveButton;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content_box_height']/div/h3")
	private List<WebElement> graphNameList;

	public List<WebElement> getGraphNameList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, graphNameList, logger) == true) {
			return graphNameList;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'durationSelectionList')]/ul/li")
	private List<WebElement> metricsList;

	public List<WebElement> getMetricsList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, metricsList, logger) == true) {
			return metricsList;
		} else {
			return null;
		}
	}

	@FindBy(css = "div.col-sm-12 chartHeight>chart>div>svg>g[6]>g>rect")
	private WebElement barChart;

	public WebElement getBarChart() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, barChart, logger) == true) {
			return barChart;
		} else {
			return null;
		}
	}
	//chart[@class='responsiveChart']/div
	@FindBy(css = "chart[class='responsiveChart']>div>svg")
	private WebElement lineChart;

	public WebElement getLineChart() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lineChart, logger) == true) {
			return lineChart;
		} else {
			return null;
		}
	}
	@FindBy(css = "chart[class='responsiveChart']>div>svg>g[class='highcharts-series-group']>g[3]>path[fill='#00ff00']")
	private WebElement lineChartPoint;

	public WebElement getLineChartPoint() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lineChartPoint, logger) == true) {
			return lineChartPoint;
		} else {
			return null;
		}
	}
	@FindBy(xpath = "//div[@class='motor scrollcontentheight']")
	private WebElement scrollBar;

	public WebElement getScrollBar() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, scrollBar, logger) == true) {
			return scrollBar;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//chart[@class='responsiveChart']/div/div/span/span")
	private WebElement dateInToolTip;

	public WebElement getToolTipDate() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, dateInToolTip, logger) == true) {
			return dateInToolTip;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-sm-12 chartHeightTrend']/chart/div/div/span/span[2]")
	private WebElement nameInToolTip;

	public WebElement getNameInToolTip() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, nameInToolTip, logger) == true) {
			return nameInToolTip;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='selbtngroup']/button[@aria-label='Open Calendar']/span")
	private WebElement openCalendar;

	public WebElement getOpenCalendarButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, openCalendar, logger) == true) {
			return openCalendar;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[@aria-label='Previous Year']")
	private WebElement previousYearArrow;

	public WebElement getPreviousYearArrow() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, previousYearArrow, logger) == true) {
			return previousYearArrow;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[text()='Show']")
	private WebElement show;

	public WebElement getShow() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, show, logger) == true) {
			return show;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='datevalue currmonth']/span[contains(text(),'13')]")
	private WebElement date;

	public WebElement getCalendarDate() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, date, logger) == true) {
			return date;
		} else {
			return null;
		}
	}

	@FindBy(css = "div[class='content_box_height']>div[class='content-header trends-heading']>ul>li")
	private List<WebElement> chartOptions;

	public List<WebElement> getChartOptions() throws Exception {
		if (chartOptions != null) {
			return chartOptions;
		} else {
			return null;
		}
	}

	@FindBy(css = "div[class='content_box_height']>div[class='content-header trends-heading']>ul>li>a")
	private WebElement maximizeButton;

	public WebElement getMaximizeButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, maximizeButton, logger) == true) {
			return maximizeButton;
		} else {
			return null;
		}
	}

	//// div[@class='content_box_height']/div/ul/li/select
	@FindBy(xpath = "//select[@name='ddlyear']")
	private WebElement selectYear;

	public WebElement getSelectYrValues() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectYear, logger) == true) {
			return selectYear;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//li[@class='pull-right chart-options ']/select")
	private List<WebElement> allSelectedYr;

	public List<WebElement> getAllSelectedYrValues() throws Exception {
		if (allSelectedYr != null) {
			return allSelectedYr;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='content_box_height']/div/ul/li[2]/ul/li")
	private List<WebElement> chartOptionsValues;

	public List<WebElement> getChartOptionsValues() throws Exception {
		if (chartOptionsValues != null) {
			return chartOptionsValues;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//th[@class='ng-star-inserted']")
	private WebElement gridData;

	public WebElement getGridData() throws Exception {
		if (gridData != null) {
			return gridData;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='bottom-header']/nav/ul/li")
	private List<WebElement> trendsHeaderList;

	public List<WebElement> getTrendsHeaderList() throws Exception {
		if (trendsHeaderList != null) {
			return trendsHeaderList;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//li[@aria-level='6']/div/div/span")
	private WebElement chillerName;

	public WebElement getChillerName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerName, logger) == true) {
			return chillerName;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[@name='projectassetlist']")
	private WebElement equipment;

	public WebElement getEquipment() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, equipment, logger) == true) {
			return equipment;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='ui-rangeSlider-label-value']")
	private List<WebElement> sliderTimeList;

	public List<WebElement> getSliderTimeList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sliderTimeList, logger) == true) {
			return sliderTimeList;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//div[@class='col-sm-8 col-md-8  padding-left-0']/span")
	private List<WebElement> pointList;

	public List<WebElement> getPointList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pointList, logger) == true) {
			return pointList;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-4 col-md-4')]/div")
	private List<WebElement> valueList;

	public List<WebElement> getValueList() throws Exception {
		if (valueList!=null) {
			return valueList;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-md-12 margin-top-10 text-left mandatory-txt']")
	private WebElement message;

	public WebElement getMessage() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, message, logger) == true) {
			return message;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[@automation-id='btnPreview']")
	private WebElement pdfPreviewBtn;

	public WebElement getPdfPrvWBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pdfPreviewBtn, logger) == true) {
			return pdfPreviewBtn;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[@automation-id='btnPrint']")
	private WebElement pdfPrintBtn;

	public WebElement getPdfPrintBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pdfPrintBtn, logger) == true) {
			return pdfPrintBtn;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[@name='ddlyear']")
	private WebElement yearInChart;

	public WebElement getYrInChart() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, yearInChart, logger) == true) {
			return yearInChart;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='ui-rangeSlider-arrow ui-rangeSlider-leftArrow']")
	private WebElement slider;

	public WebElement getSliderArrow() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, slider, logger) == true) {
			return slider;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//span[text()='EVAPORATOR PUMP STATUS']/preceding-sibling::input")
	private WebElement evaporatorPoint1;

	public WebElement getEvaporatorPt1() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, evaporatorPoint1, logger) == true) {
			return evaporatorPoint1;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//span[text()='SUBCOOLER EFFECTIVENESS']/preceding-sibling::input")
	private WebElement evaporatorPoint2;

	public WebElement getEvaporatorPt2() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, evaporatorPoint2, logger) == true) {
			return evaporatorPoint2;
		} else {
			return null;
		}
	}

	public List<WebElement> getPointList(String header) throws Exception {
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='col-xs-12 margin-top-10']/h4[text()='" + header
				+ "']/../following-sibling::div/div/div/div/span"));
		return element;
	}
	@FindBy(xpath="//div[@class='pull-right top_buttons']/button[text()='Save']")
	private WebElement save;
	
	public WebElement getSaveBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, save, logger) == true) {
			return save;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Preview']")
	private WebElement preview;
	
	public WebElement getPreviewBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, preview, logger) == true) {
			return preview;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//button[text()='SaveasPdf']")
	private WebElement saveaspdf;
	
	public WebElement getSaveAsPdfBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveaspdf, logger) == true) {
			return saveaspdf;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//button[text()='Email']")
	private WebElement email;
	
	public WebElement getEmailBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, email, logger) == true) {
			return email;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//input[@type='email']")
	private WebElement enterEmail;
	
	public WebElement getEnterEmailBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, enterEmail, logger) == true) {
			return enterEmail;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='modal-footer text-center']/button[text()='Send']")
	private WebElement send;
	
	public WebElement getSendBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, send, logger) == true) {
			return send;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement edit;
	
	public WebElement getEditBtn() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, edit, logger) == true) {
			return edit;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//input[@class='form-control width_100 ng-untouched ng-pristine ng-valid']")
	private List<WebElement> editTxtBox;
	
	public List<WebElement> getEditTxtBoxBtn() throws Exception {
		if (editTxtBox!=null) {
			return editTxtBox;
		} else {
			return null;
		}
	}
}
