package mars.JCI.Project.CEP.Smoke;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Reports_Smoke_Page_Factory {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public CEP_Reports_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="REPORTS")
	private WebElement reportsLink;
	
	public WebElement getReportsLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, reportsLink, logger) == true) {
			return reportsLink;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div/select[@name='ddlReports']")
	private WebElement report;
	
	public WebElement getReportDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, report, logger) == true) {
			return report;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div/select[@name='ddlCustomer']")
	private WebElement customer;
	
	public WebElement getCustomerDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customer, logger) == true) {
			return customer;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//div[@class='c-token']/span")
	private WebElement facility;
	
	public WebElement getFacilityDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, facility, logger) == true) {
			return facility;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//label[text()='Asset ']//following-sibling::div//div[@class='c-btn']")
	private WebElement asset;
	
	public WebElement getAssetDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, asset, logger) == true) {
			return asset;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//button[@aria-label='Open Calendar']")
	private List<WebElement> calendar;
	
	public List<WebElement> getCalendarButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, calendar, logger) == true) {
			return calendar;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//my-date-picker[@name='startdate']/div/div/input")
	private WebElement startDateTextBox;
	
	public WebElement getStartDateTextBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, startDateTextBox, logger) == true) {
			return startDateTextBox;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//my-date-picker[@name='enddate']/div/div/input")
	private WebElement endDateTextBox;
	
	public WebElement getEndDateTextBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, startDateTextBox, logger) == true) {
			return endDateTextBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//button[@class='btn-primary btn']")
	private WebElement reportButton;
	
	public WebElement getReportButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, reportButton, logger) == true) {
			return reportButton;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[@id='lblSiteLocation']")
	private WebElement siteLocation;
	
	public WebElement getSiteLocation() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteLocation, logger) == true) {
			return siteLocation;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//span[@id='lblFacility']")
	private WebElement facilityInECloud;
	
	public WebElement getFacilityInECloudReport() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, facilityInECloud, logger) == true) {
			return facilityInECloud;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement eCloudConfirmYes;
	
	public WebElement getECloudConfirmYesButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eCloudConfirmYes, logger) == true) {
			return eCloudConfirmYes;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Generate Report']")
	private WebElement eCloudConfirmGenerateReport;
	
	public WebElement getECloudConfirmGenerateReportButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, eCloudConfirmGenerateReport, logger) == true) {
			return eCloudConfirmGenerateReport;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//div[@class='col-sm-6 col-md-6']/input")
	private WebElement efficiencyMax;
	
	public WebElement getEfficincyMax() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, efficiencyMax, logger) == true) {
			return efficiencyMax;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement okButton;
	
	public WebElement getOkButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, okButton, logger) == true) {
			return okButton;
		} else {
			return null;
		}
	}
	
	@FindBy(linkText="Select Points")
	private WebElement selectPointLink;
	
	public WebElement getSelectPointLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectPointLink, logger) == true) {
			return selectPointLink;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='col-xs-12 margin-top-10 padding-left-0']/input")
	private WebElement selectPoints;
	
	public WebElement getSelectPointsChkBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectPoints, logger) == true) {
			return selectPoints;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	public WebElement getSaveButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveButton, logger) == true) {
			return saveButton;
		} else {
			return null;
		}
	}
}
