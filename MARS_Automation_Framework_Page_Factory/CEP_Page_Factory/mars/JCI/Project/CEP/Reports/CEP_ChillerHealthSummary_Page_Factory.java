package mars.JCI.Project.CEP.Reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_ChillerHealthSummary_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	@SuppressWarnings("static-access")
	public CEP_ChillerHealthSummary_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='AZDoR']")
	private WebElement preparedFor;

	public WebElement getPreparedFor() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, preparedFor, logger) == true) {
			return preparedFor;
		} else {
			return null;
		}
	}

	public WebElement getPreparedOnDate() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
			Date date = new Date();
			String sysDate = dateFormat.format(date);
			WebElement pdfDate = driver.findElement(By.xpath("//span[contains(text(),'" + sysDate + "')]"));
			return pdfDate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@FindBy(xpath = "//span[text()='11/24/2018 - 12/24/2018']")
	private WebElement coveringPeriod;

	public WebElement getCoveringPeriod() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, coveringPeriod, logger) == true) {
			return coveringPeriod;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='MEMORIAL MAIN']")
	private WebElement siteLocation;

	public WebElement getSiteLocation() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteLocation, logger) == true) {
			return siteLocation;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='Memorial Main - YK, CHILLER 1']")
	private WebElement equipName;

	public WebElement getEquipName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, equipName, logger) == true) {
			return equipName;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='12/15/2017 - 01/17/2018']")
	private WebElement dateRange;

	public WebElement getDateRange() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, dateRange, logger) == true) {
			return dateRange;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='816']")
	private WebElement periodHours;

	public WebElement getPeriodHours() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, periodHours, logger) == true) {
			return periodHours;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='ACCUM OPERATING HOURS']")
	private WebElement runHoursSystem;

	public WebElement getRunHoursSystem() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, runHoursSystem, logger) == true) {
			return runHoursSystem;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='415 hrs']")
	private WebElement period;

	public WebElement getPeriod() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, period, logger) == true) {
			return period;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='22056 hrs']")
	private WebElement lifetime;

	public WebElement getLifetime() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lifetime, logger) == true) {
			return lifetime;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//table[@id='tblHealthCheck']/tbody/tr/td")
	private List<WebElement> mainTable;

	public List<WebElement> getMainTable() throws Exception {
		if (mainTable!=null) {
			return mainTable;
		} else {
			return null;
		}
	}
}
