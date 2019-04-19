package mars.JCI.Project.MEMSCloud_MappedPoints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MEMSCloud_MappedPoints_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	/**
	 * Instantiates a new MEMS Cloud Mapped Points page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	
	public MEMSCloud_MappedPoints_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	// *************** WAIT FOR LOGIN USER WEBELEMENT
	@FindBy(xpath = "//a[@data-toggle='dropdown']/img")
	private WebElement UserImage;

	public WebElement getUserImage() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, UserImage, logger) == true) {
			return UserImage;
		} else
			return null;
	}
	
	// *************** MAPPED POINTS WEBELEMENT
	@FindBy(xpath = "//a[@href='Configuration/MappedPointsConfiguration']/span/i")
	private WebElement MappedPoints;

	public WebElement getMappedPoints() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, MappedPoints, logger) == true) {
			return MappedPoints;
		} else
			return null;
	}
	
	// *************** OFFLINE POINTS WEBELEMENT
	@FindBy(xpath = "//a[@class='ng-binding'][contains(text(),'Offline Points')]")
	private WebElement OfflinePoints;

	public WebElement getOfflinePoints() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, OfflinePoints, logger) == true) {
			return OfflinePoints;
		} else
			return null;
	}
	
	// *************** MOVE NEXT TAB LIST WEBELEMENT
	@FindBy(xpath = "//div[@id='liquid1']/span/i[@class='fa fa-angle-right fa-3x']")
	private WebElement NextTabList;

	public WebElement getNextTabList() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, NextTabList, logger) == true) {
			return NextTabList;
		} else
			return null;
	}
	
	// *************** PERIOD WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-4 col-lg-4']/select[@name='perid']")
	private WebElement Period;

	public WebElement getPeriod() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, Period, logger) == true) {
			return Period;
		} else
			return null;
	}
		
	// *************** PERIOD WEBELEMENT
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-4 col-lg-4']/select[@name='resolution']")
	private WebElement Resolution;

	public WebElement getResolution() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, Resolution, logger) == true) {
			return Resolution;
		} else
			return null;
	}
	
	// *************** FROM TIMELINE WEBELEMENT
	@FindBy(xpath = "//label[@for='year-picker-1']/span[@class='glyphicon glyphicon-calendar']")
	private WebElement From_TimeLine;

	public WebElement getFrom_TimeLine() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, From_TimeLine, logger) == true) {
			return From_TimeLine;
		} else
			return null;
	}
	
	// *************** TO TIMELINE WEBELEMENT
	@FindBy(xpath = "//label[@for='year-picker-2']/span[@class='glyphicon glyphicon-calendar']")
	private WebElement To_TimeLine;

	public WebElement getTo_TimeLine() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, To_TimeLine, logger) == true) {
			return To_TimeLine;
		} else
			return null;
	}
	
	// *************** FROM TIMELINE WEBELEMENT
	@FindBy(xpath = "//div[@class='datepicker-years']/table[@class='table-condensed']//tr/th[@class='datepicker-switch']")
	private WebElement YearRange_TimeLine;

	public WebElement getYearRange_TimeLine() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, YearRange_TimeLine, logger) == true) {
			return YearRange_TimeLine;
		} else
			return null;
	}
	
	// *************** FROM TIMELINE WEBELEMENT
	private WebElement selectYr;
	public WebElement getSelectYr(String Year) {		
		commonFunctions.WebElementCommon.staticWait(300);
		selectYr = driver.findElement(By.xpath("//div[@class='datepicker-years']/table[@class='table-condensed']//tr/td/span[text()='"+Year+"']"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, YearRange_TimeLine, logger)) {
			return selectYr;
		} else
			return null;
	}
	
	// *************** FROM TIMELINE WEBELEMENT
	@FindBy(xpath = "//div[@class='datepicker-years']//tr/th[@class='prev']")
	private WebElement YearPrevious;

	public WebElement getYearPrevious() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, YearPrevious, logger) == true) {
			return YearPrevious;
		} else
			return null;
	}	

	// *************** SEARCH TEXT BOX WEBELEMENT
	@FindBy(xpath = "//div[@class='tab-pane col-xs-12 col-sm-12 col-md-12 col-lg-12 ']/div/input[@id='searchbox']")
	private WebElement SearchTextBox;

	public WebElement getSearchTextBox() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, SearchTextBox, logger) == true) {
			return SearchTextBox;
		} else
			return null;
	}

	// *************** SEARCH BUTTON WEBELEMENT
	@FindBy(xpath = "//span[@class='btn btn-primary']/span[text()='Search']")
	private WebElement SearchBtn;

	public WebElement getSearchBtn() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, SearchBtn, logger) == true) {
			return SearchBtn;
		} else
			return null;
	}
	
	// *************** SELECT POINT ON WEBTABLE WEBELEMENT
	private WebElement selectPointOnWebTable;

	public WebElement getselectPointOnWebTable(String PointName) {
		commonFunctions.WebElementCommon.staticWait(300);
		selectPointOnWebTable = driver.findElement(By.xpath("//div[text()='" + PointName + "']"));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectPointOnWebTable, logger)) {
			return selectPointOnWebTable;
		} else
			return null;
	}
	
	// *************** XLS FILE DOWNLOAD WEBELEMENT
	@FindBy(xpath = "//span[@class='cursor-pointer pull-left']/span[text()='OfflinePoints.csv']")
	private WebElement downloadxlsFile;

	public WebElement getdownloadxlsFile() {
		commonFunctions.WebElementCommon.staticWait(300);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, downloadxlsFile, logger) == true) {
			return downloadxlsFile;
		} else
			return null;
	}
}
