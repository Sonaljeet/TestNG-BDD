package mars.JCI.Project.CEP.Smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Repository_Smoke_Page_Factory {

	private WebDriver driver;
	private ExtentTest logger;

	public CEP_Repository_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "REPOSITORY")
	private WebElement link;

	public WebElement getLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, link, logger) == true) {
			return link;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='cuppa-dropdown']")
	private WebElement branch;

	public WebElement getBranch() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, branch, logger) == true) {
			return branch;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[contains(@class,'ng-touched')]")
	private WebElement searchInBranch;

	public WebElement getSearch() throws Exception {
		if (searchInBranch!=null) {
			return searchInBranch;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//select[@name='ddlYear']")
	private WebElement year;

	public WebElement getYear() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, year, logger) == true) {
			return year;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//select[@name='ddlCustomer']")
	private WebElement customer;

	public WebElement getCustomer() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customer, logger) == true) {
			return customer;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//select[@name='ddlFacility']")
	private WebElement facility;

	public WebElement getFacility() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, facility, logger) == true) {
			return facility;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//select[@name='ddlMonths']")
	private WebElement month;

	public WebElement getMonth() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, month, logger) == true) {
			return month;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//select[@name='ddlReports']")
	private WebElement report;

	public WebElement getReport() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, report, logger) == true) {
			return report;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//label[text()='Phoenix AZ - 0N0J']")
	private WebElement branchName;

	public WebElement getBrName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, branchName, logger) == true) {
			return branchName;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//span[text()='Chiller Health Summary']")
	private WebElement pdf;

	public WebElement getPDF() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pdf, logger) == true) {
			return pdf;
		} else {
			return null;
		}
	}
}